package ink.hydroxide.mixins;


import net.minecraft.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Minecraft.class)
public class MinecraftClientMixin {

    @Overwrite
    public static boolean inDevMode() {
        return true;
    }

}
