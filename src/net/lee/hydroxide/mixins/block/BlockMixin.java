package net.lee.hydroxide.mixins.block;

import net.lee.hydroxide.Hydroxide;
import net.lee.hydroxide.module.modules.world.Xray;
import net.minecraft.Block;
import net.minecraft.IBlockAccess;
import net.minecraft.Minecraft;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import static net.xiaoyu233.fml.util.ReflectHelper.dyCast;

@Mixin(Block.class)
public class BlockMixin {
    @Overwrite
    public boolean a(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
        if (Hydroxide.moduleManger.getByClass(Xray.class).isEnable()) {
            int block_id = par1IBlockAccess.getBlockId(par2, par3, par4);
            if (block_id == Block.oreCopper.blockID || block_id == Block.oreSilver.blockID || block_id == Block.oreGold.blockID ||
                    block_id == Block.oreIron.blockID || block_id == Block.oreMithril.blockID || block_id == Block.oreAdamantium.blockID ||
                    block_id == Block.oreCoal.blockID || block_id == Block.oreEmerald.blockID || block_id == Block.oreDiamond.blockID ||
                    block_id == Block.oreNetherQuartz.blockID || block_id == Block.oreLapis.blockID || block_id == Block.oreRedstone.blockID) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.isAlwaysStandardFormCube()) {
                return !doesBlockHideAdjacentSide(par1IBlockAccess, par2, par3, par4, dyCast(this), par5);
            } else {
                int index = Minecraft.getThreadIndex();
                if (par5 == 0) {
                    if (this.minY[index] > 0.0) {
                        return true;
                    }
                } else if (par5 == 1) {
                    if (this.maxY[index] < 1.0) {
                        return true;
                    }
                } else if (par5 == 2) {
                    if (this.minZ[index] > 0.0) {
                        return true;
                    }
                } else if (par5 == 3) {
                    if (this.maxZ[index] < 1.0) {
                        return true;
                    }
                } else if (par5 == 4) {
                    if (this.minX[index] > 0.0) {
                        return true;
                    }
                } else if (par5 == 5 && this.maxX[index] < 1.0) {
                    return true;
                }
                return !doesBlockHideAdjacentSide(par1IBlockAccess, par2, par3, par4, dyCast(this), par5);
            }
        }
    }
//    @Overwrite
//    @Final
//    public static boolean doesBlockHideAdjacentSide(IBlockAccess block_access, int x, int y, int z, Block neighbor, int side) {
//        int block_id = block_access.getBlockId(x, y, z);
//        if (block_id == 0) {
//            return false;
//        } else if(block_id == Block.oreCopper.blockID || block_id == Block.oreSilver.blockID || block_id == Block.oreGold.blockID ||
//                block_id == Block.oreIron.blockID || block_id == Block.oreMithril.blockID || block_id == Block.oreAdamantium.blockID ||
//                block_id == Block.oreCoal.blockID || block_id == Block.oreEmerald.blockID || block_id == Block.oreDiamond.blockID ||
//                block_id == Block.oreNetherQuartz.blockID || block_id == Block.oreLapis.blockID || block_id == Block.oreRedstone.blockID){
//            return true;
//        } else {
//            Block block = getBlock(block_id);
//            return block.neverHidesAdjacentFaces() ? false : block.hidesAdjacentSide(block_access, x, y, z, neighbor, side);
//        }
//    }
    @Shadow
    @Final
    protected double[] minX;
    @Shadow
    @Final
    protected double[] minY;
    @Shadow
    @Final
    protected double[] minZ;
    @Shadow
    @Final
    protected double[] maxX;
    @Shadow
    @Final
    protected double[] maxY;
    @Shadow
    @Final
    protected double[] maxZ;
    @Shadow
    @Final
    public boolean isAlwaysStandardFormCube() {
        return false;
    }
    @Shadow
    @Final
    public static boolean doesBlockHideAdjacentSide(IBlockAccess block_access, int x, int y, int z, Block neighbor, int side) {
        return false;
    }
}
