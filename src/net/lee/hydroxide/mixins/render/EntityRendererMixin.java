package net.lee.hydroxide.mixins.render;

import net.lee.hydroxide.Hydroxide;
import net.minecraft.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {

    @Inject(method = "b(F)V", at = @At(value = "RETURN"))
    private void injectRenderGameOverlay(float par1, CallbackInfo callbackInfo) {
        Hydroxide.moduleManger.getEnableModules().forEach(it -> it.render(par1));
    }
}
