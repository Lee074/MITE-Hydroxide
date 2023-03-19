package net.lee.hydroxide.module.modules.world;

import net.lee.hydroxide.module.Category;
import net.lee.hydroxide.module.Module;
import net.lee.hydroxide.module.ModuleManger;

public class Xray extends Module {
    public Xray() {
        super("Xray", Category.WORLD);
        setKey(50);
    }
//    @Override
//    public boolean isEnable() {
//        return ModuleManger.Xray || this.enable;
//    }
}
