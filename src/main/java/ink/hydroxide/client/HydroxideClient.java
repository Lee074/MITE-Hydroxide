package ink.hydroxide.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.minecraft.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class HydroxideClient implements ClientModInitializer {
    public static final String MOD_ID = "oh-client";
    public static final ModMetadata MOD_META;
    public static final String NAME;
    public static HydroxideClient INSTANCE;
    public static Minecraft mc;
    public static final File FOLDER;
    public static final Logger LOG = LogManager.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        if (INSTANCE == null) {
            INSTANCE = this;
            return;
        }
        System.out.println("===============");

        mc = Minecraft.getMinecraft();
    }

    static {
        MOD_META = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().getMetadata();

        NAME = MOD_META.getName();
        FOLDER = mc.mcDataDir.toPath().resolve(MOD_ID).toFile();
    }

}
