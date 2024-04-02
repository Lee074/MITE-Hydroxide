package ink.hydroxide.modules;

import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemStack;

public class Categories {
    public static final Category Combat = new Category("Combat", Item.swordGold.getItemStackForStatsIcon());
    public static final Category Player = new Category("Player", Item.helmetAdamantium.getItemStackForStatsIcon());
    public static final Category Movement = new Category("Movement", Item.bootsAdamantium.getItemStackForStatsIcon());
    public static final Category Render = new Category("Render", new ItemStack(Block.grass.blockID));
    public static final Category World = new Category("World", new ItemStack(Block.dirt.blockID));
    public static final Category Misc = new Category("Misc", Item.bucketIronLava.getItemStackForStatsIcon());

    public static boolean REGISTERING;

    public static void init() {
        REGISTERING = true;

        Modules.registerCategory(Combat);
        Modules.registerCategory(Player);
        Modules.registerCategory(Movement);
        Modules.registerCategory(Render);
        Modules.registerCategory(World);
        Modules.registerCategory(Misc);

        REGISTERING = false;
    }
}
