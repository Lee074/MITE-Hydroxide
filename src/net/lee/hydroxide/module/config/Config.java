package net.lee.hydroxide.module.config;

import net.minecraft.Minecraft;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Config {
    private final String name;

    public Config(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return Paths.get(Minecraft.w().x.getAbsolutePath(), "Hydroxide", name + ".json");
    }

    public void load() {

    }

    public void save() {

    }

}
