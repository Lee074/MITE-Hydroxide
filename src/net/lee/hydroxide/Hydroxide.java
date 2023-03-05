package net.lee.hydroxide;

import net.lee.hydroxide.mixins.MinecraftMixin;
import net.lee.hydroxide.module.ModuleManger;
import net.xiaoyu233.fml.AbstractMod;
import net.xiaoyu233.fml.classloading.Mod;
import net.xiaoyu233.fml.config.InjectionConfig;
import org.spongepowered.asm.mixin.MixinEnvironment;

import javax.annotation.Nonnull;

@Mod(MixinEnvironment.Side.CLIENT)
public class Hydroxide extends AbstractMod {
    public static ModuleManger moduleManger;
    @Override
    public void preInit() {
    }


    @Override
    public void postInit() {
    }

    public static void start() {
        moduleManger = new ModuleManger();
        //moduleManger.load();
    }



    @Nonnull
    @Override
    public InjectionConfig getInjectionConfig() {
        return InjectionConfig.Builder.of("MITE-Hydroxide", MinecraftMixin.class.getPackage(), MixinEnvironment.Phase.INIT).setRequired().build();
    }

    @Override
    public String modId() {
        return "Hydroxide";
    }

    @Override
    public int modVerNum() {
        return 100;
    }

    @Override
    public String modVerStr() {
        return "v1.0.0";
    }
}

