package net.lee.hydroxide.mixins;

import net.lee.hydroxide.Hydroxide;
import net.lee.hydroxide.module.Module;
import net.lee.hydroxide.module.ModuleManger;
import net.lee.hydroxide.module.modules.draw.ModulesInfo;
import net.lee.hydroxide.module.modules.movement.NoFall;
import net.lee.hydroxide.module.modules.world.Xray;
import net.minecraft.*;
import org.lwjgl.input.Keyboard;
import org.objectweb.asm.tree.ModuleNode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Shadow
    public aul u;
    @Shadow
    public bfl g;
    @Shadow
    @Final
    public MethodProfiler C;

    @Inject(method = "k", at = @At(value = "FIELD", target = "Lnet/minecraft/aul;keyBindToggleRun:Lnet/minecraft/ats;",
            shift = At.Shift.BEFORE))
    public void injectRunTick(CallbackInfo callbackInfo) {
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.isKeyDown(this.getModuleByClass(Xray.class).getKey())) {
                this.getModuleByClass(Xray.class).setEnable(!this.getModuleByClass(Xray.class).isEnable());
                this.g.a();
                this.ModuleTips("Xray");
            }
            if (Keyboard.isKeyDown(this.getModuleByClass(NoFall.class).getKey())) {
                this.getModuleByClass(NoFall.class).setEnable(!this.getModuleByClass(NoFall.class).isEnable());
                this.ModuleTips("NoFall");
            }
            if (Keyboard.isKeyDown(this.getModuleByClass(ModulesInfo.class).getKey())) {
                this.getModuleByClass(ModulesInfo.class).setEnable(!this.getModuleByClass(ModulesInfo.class).isEnable());
                this.ModuleTips("ModulesInfo");
            }
        }
    }

    @Inject(method = "O", at = @At("HEAD"))
    private void injectStartGame(CallbackInfo callbackInfo) {
        Hydroxide.start();
    }

    @Inject(method = "c()V", at = @At("HEAD"))
    private void injectStopGame(CallbackInfo callbackInfo) {
        Hydroxide.stop();
    }

    protected void ModuleTips(String moduleName){
        Minecraft.w().r.b().a("[Hydroxide]: Module " + moduleName + " " +String.valueOf(Hydroxide.moduleManger.getByName(moduleName).isEnable()));
    }
    protected Module getModuleByClass(Class ModuleByClass) {
        return Hydroxide.moduleManger.getByClass(ModuleByClass);
    }

}
