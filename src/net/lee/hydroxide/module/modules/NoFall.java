//package net.lee.hydroxide.module.modules;
//
//import net.lee.hydroxide.module.Module;
//import net.minecraft.Minecraft;
//import net.minecraft.Packet10Flying;
//import org.lwjgl.input.Keyboard;
//
//public class NoFall extends Module {
//    public Modules modules = new Modules();
//    public NoFall() {
//        super("NoFall");
//        this.setEnable(modules.noFall);
//        //this.setKey(Keyboard.KEY_L);
//    }
//    @Override
//    public void update() {
//        //System.out.println("update OK");
//        if (Minecraft.w().h.getAsPlayer().fallDistance > 0.5) {
//            Minecraft.w().q().c(new Packet10Flying(true));
//        }
//    }
//}
