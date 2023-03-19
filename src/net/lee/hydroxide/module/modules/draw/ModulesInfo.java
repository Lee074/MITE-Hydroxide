package net.lee.hydroxide.module.modules.draw;

import net.lee.hydroxide.Hydroxide;
import net.lee.hydroxide.module.Category;
import net.lee.hydroxide.module.Module;
import net.lee.hydroxide.module.ModuleManger;
import net.minecraft.*;
import org.lwjgl.input.Keyboard;

import java.util.List;

public class ModulesInfo extends Module {
    public ModulesInfo() {
        super("ModulesInfo", Category.DRAW);
        setKey(25);
    }
    @Override
    public void draw() {
        awf scaledResolution = new awf(Minecraft.w().u, Minecraft.w().d, Minecraft.w().e);
        int width = scaledResolution.a();
        //int height = scaledResolution.b();

        List<Module> enableModules = Hydroxide.moduleManger.getEnableModules();
        avi font = Minecraft.w().l;
        enableModules.sort((o1, o2) -> font.a(o2.getName()) - font.a(o1.getName()));

        int y = 10;
        for (Module enableModule : enableModules) {
            font.b(enableModule.getName(), width - font.a(enableModule.getName()), y, 0xFFFFFFFF);
            y += font.a + 2;
        }
    }
//    @Override
//    public boolean isEnable() {
//        return ModuleManger.ModulesInfo || this.enable;
//    }
}
