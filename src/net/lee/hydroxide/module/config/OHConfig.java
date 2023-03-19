package net.lee.hydroxide.module.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.lee.hydroxide.Hydroxide;
import net.lee.hydroxide.module.Module;
import net.lee.hydroxide.module.ModuleManger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class OHConfig extends Config {
    public OHConfig() {
        super("Config");
    }

    @Override
    public void load() {
        try {
            JsonObject jsonObject = new Gson().fromJson(new String(Files.readAllBytes(getPath()), StandardCharsets.UTF_8), JsonObject.class);
            for (Module module : Hydroxide.moduleManger.getModules()) {
//                System.out.println("getName: " + module.getName());
//                System.out.println("getBoolean: " + module.isEnable());
//                module.setEnable(true);
//                System.out.println("getBooleanAfter: " + module.isEnable());
                if (jsonObject.has(module.getName())) {
                    JsonObject moduleJson = jsonObject.get(module.getName()).getAsJsonObject();
                    if (moduleJson.has("enable")) {
                        module.setEnable(moduleJson.get("enable").getAsBoolean());
                    }
                    if (moduleJson.has("key")) {
                        module.setKey(moduleJson.get("key").getAsInt());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save() {
        JsonObject jsonObject = new JsonObject();
        for (Module module : Hydroxide.moduleManger.getModules()) {
            JsonObject json = new JsonObject();
            json.addProperty("enable", module.isEnable());
            json.addProperty("key", module.getKey());
            json.addProperty("category", module.getCategory().name());
            jsonObject.add(module.getName(), json);
        }
        try {
            Files.write(getPath(), new GsonBuilder().setPrettyPrinting().create().toJson(jsonObject).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
