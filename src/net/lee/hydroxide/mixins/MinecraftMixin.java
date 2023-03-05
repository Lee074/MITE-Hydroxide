package net.lee.hydroxide.mixins;

import net.lee.hydroxide.Hydroxide;
import net.lee.hydroxide.module.modules.Modules;
//import net.lee.hydroxide.module.modules.NoFall;
import net.minecraft.ClientPlayer;
import net.minecraft.Minecraft;
import net.minecraft.aul;
import net.minecraft.bfl;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {
    @Shadow
    public ClientPlayer h;
    @Shadow
    public aul u;
    @Shadow
    public abstract void h();
    @Shadow
    public bfl g;
    @Shadow
    public static boolean night_vision_override;

    @Inject(method = "k", at = @At("INVOKE"))
    public void injectRunTick(CallbackInfo callbackInfo) {
//        int k = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
//        if (Keyboard.getEventKeyState()) {
//            Hydroxide.moduleManger.onKey(k);
//        }
        if (this.u.keyBindXray.c()) {
            Modules.xray = !Modules.xray;
            this.g.a();
        }
        if (this.u.keyBindNightVision.c()) {
            night_vision_override = !night_vision_override;
        }
        if (this.u.keyBindNoFall.c()) {
            //NoFall noFall = new NoFall();
            //Modules modules = new Modules();
            Modules.noFall = !Modules.noFall;
        }
    }
    @Inject(method = "O", at = @At("RETURN"))
    public void injectStartGame(CallbackInfo callbackInfo) {
        Hydroxide.start();
    }

}
