//package net.lee.hydroxide.mixins.entity;
//
//import net.lee.hydroxide.module.modules.Modules;
//import net.minecraft.*;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Overwrite;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(EntityLiving.class)
//public class EntityLivingMixin extends Entity {
//    public EntityLivingMixin(World par1World) {
//        super(par1World);
//    }
//   //@Inject(method = "updateFallState", at = @At(value = "INVOKE"))
//    @Overwrite
//    protected void updateFallState(double par1, boolean par3) {
//        if (!this.isInWater()) {
//            this.handleWaterMovement();
//        }
//
//        if (par3 && this.fallDistance > 0.0F) {
//            if(Modules.noFull){
//                return;
//            }
//            int var4 = MathHelper.floor_double(this.posX);
//            int var5 = MathHelper.floor_double(this.posY - 0.20000000298023224 - (double)this.yOffset);
//            int var6 = MathHelper.floor_double(this.posZ);
//            int var7 = this.worldObj.getBlockId(var4, var5, var6);
//            if (var7 == 0) {
//                int var8 = this.worldObj.blockGetRenderType(var4, var5 - 1, var6);
//                if (var8 == 11 || var8 == 32 || var8 == 21) {
//                    var7 = this.worldObj.getBlockId(var4, var5 - 1, var6);
//                }
//            }
//
//            if (var7 > 0) {
//                Block.blocksList[var7].onFallenUpon(this.worldObj, var4, var5, var6, this, this.fallDistance);
//            }
//        }
//
//        super.updateFallState(par1, par3);
//    }
//
//    @Shadow
//    protected void entityInit() {
//
//    }
//    @Shadow
//    protected void readEntityFromNBT(NBTTagCompound nbtTagCompound) {
//
//    }
//    @Shadow
//    protected void writeEntityToNBT(NBTTagCompound nbtTagCompound) {
//
//    }
//}
