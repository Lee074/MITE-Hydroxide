package net.lee.hydroxide.mixins.entity;

import net.lee.hydroxide.Hydroxide;
import net.minecraft.ClientPlayer;
import net.lee.hydroxide.module.Module;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayer.class)
public class ClientPlayerMixin {
    @Inject(method = "onUpdate", at = @At(value = "HEAD"))
    private void injectOnUpdate(CallbackInfo callbackInfo) {
        Hydroxide.moduleManger.getEnableModules().forEach(Module::update);
    }

}
