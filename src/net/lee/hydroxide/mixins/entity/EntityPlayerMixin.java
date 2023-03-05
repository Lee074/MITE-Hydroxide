package net.lee.hydroxide.mixins.entity;

import net.lee.hydroxide.Hydroxide;
import net.lee.hydroxide.module.Module;
import net.lee.hydroxide.module.modules.Modules;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin extends EntityLiving {


    @Inject(method = "onUpdate", at = @At(value = "RETURN"))
    private void injectOnUpdate(CallbackInfo callbackInfo) {
        //Hydroxide.moduleManger.getEnableMods().forEach(Module::update);
        if (Modules.noFall) {
            if (Minecraft.w().h.getAsPlayer().fallDistance > 0.5) {
                Minecraft.w().q().c(new Packet10Flying(true));
            }
        }
    }


    public EntityPlayerMixin(World par1World) {
        super(par1World);
    }

    @Shadow
    public ItemStack[] getWornItems() {
        return new ItemStack[0];
    }

    @Shadow
    public boolean isWearing(ItemStack itemStack) {
        return false;
    }

    @Shadow
    public boolean setWornItem(int i, ItemStack itemStack) {
        return false;
    }

    @Shadow
    public void setHeldItemStack(ItemStack itemStack) {

    }

    @Shadow
    public ItemStack getHeldItemStack() {
        return null;
    }

    @Shadow
    public ItemStack getEquipmentInSlot(int i) {
        return null;
    }

    @Shadow
    public void setCurrentItemOrArmor(int i, ItemStack itemStack) {

    }

    @Shadow
    public ItemStack[] getInventory() {
        return new ItemStack[0];
    }
}
