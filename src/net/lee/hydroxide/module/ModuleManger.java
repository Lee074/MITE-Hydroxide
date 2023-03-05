package net.lee.hydroxide.module;

//import net.lee.hydroxide.module.modules.NoFall;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManger {
    public final List<Module> modules = new ArrayList<>();

//    public void load() {
//        modules.add(new NoFall());
//    }

    public List<Module> getMods() {
        return modules;
    }

    public List<Module> getEnableMods() {
        return modules.stream().filter(Module::isEnable).collect(Collectors.toList());
    }

    public void onKey(int key) {
        for (Module enablemodules : modules) {
            if (enablemodules.getKey() == key) {
                enablemodules.setEnable(!enablemodules.isEnable());
            }
        }
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
        for (Module mod : modules) {
            if (mod.getClass() == modClass) {
                return mod;
            }
        }
        return null;
    }
}
