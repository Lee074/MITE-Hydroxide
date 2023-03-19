package net.lee.hydroxide.module.modules.movement;

import net.lee.hydroxide.module.Category;
import net.lee.hydroxide.module.Module;
import net.lee.hydroxide.module.ModuleManger;
import net.minecraft.Minecraft;
import net.minecraft.Packet10Flying;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", Category.MOVEMENT);
        setKey(38);
    }
    @Override
    public void update() {
        //System.out.println("noFall OK");
        if (Minecraft.w().h.getAsPlayer().fallDistance > 0.5F) {
            Minecraft.w().q().c(new Packet10Flying(true));
        }
    }
//    @Override
//    public boolean isEnable() {
//        return ModuleManger.NoFall || this.enable;
//    }
}
