package net.lee.hydroxide.module.config;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
public class ConfigManager {
    private final List<Config> configs = new ArrayList<Config>() {
        {
            add(new OHConfig());
        }
    };

    public void load() {
        //System.out.println("LOAD 1");
        for (Config config : configs) {
            //System.out.println("LOAD FOR");
            if (config.getPath().toFile().exists()) {
                //System.out.println("LOAD IF");
                config.load();
            }
        }
    }

    public void save() {
        //System.out.println("save");
        for (Config config : configs) {
            if (!config.getPath().toFile().exists()) {
                try {
                    //System.out.println("LOAD CreateNewFile");
                    Files.createDirectories(config.getPath().getParent());
                    config.getPath().toFile().createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            config.save();
        }
    }
}
