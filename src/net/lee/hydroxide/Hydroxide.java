package net.lee.hydroxide;

import net.lee.hydroxide.module.ModuleManger;
import net.lee.hydroxide.module.config.ConfigManager;

public class Hydroxide{
    public static ModuleManger moduleManger;
    public static ConfigManager configManager;

    public static void start() {
        moduleManger = new ModuleManger();
        configManager = new ConfigManager();
        moduleManger.load();
        configManager.load();

        System.out.println("Hydroxide");
    }
    public static void stop() {
        configManager.save();
    }

}

