package net.lee.hydroxide.module;

import net.lee.hydroxide.module.modules.movement.NoFall;
import net.lee.hydroxide.module.modules.draw.ModulesInfo;
import net.lee.hydroxide.module.modules.world.Xray;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManger {
//    public static boolean Xray;
//    public static boolean NoFall;
//    public static boolean ModulesInfo;

    public final List<Module> modules = new ArrayList<>();
    public void load() {
        modules.add(new NoFall());
        modules.add(new Xray());
        modules.add(new ModulesInfo());
    }

    public List<Module> getByCategory(Category category) {
        return modules.stream().filter(m -> m.getCategory() == category).collect(Collectors.toList());
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getEnableModules() {
        return modules.stream().filter(Module::isEnable).collect(Collectors.toList());
    }

    public Module getByName(String name) {
        for (Module module: modules) {
            if (name.equalsIgnoreCase(module.getName())) {
                return module;
            }
        }
        return null;
    }

    public Module getByClass(Class<? extends Module> modClass) {
        for (Module module : modules) {
            if (module.getClass() == modClass) {
                return module;
            }
        }
        return null;
    }
}
