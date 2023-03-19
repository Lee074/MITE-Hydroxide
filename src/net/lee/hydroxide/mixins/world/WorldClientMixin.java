//package net.lee.hydroxide.mixins.world;
//
//import net.minecraft.*;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//
//@Mixin(bdd.class)
//public class WorldClientMixin extends World {
//    public WorldClientMixin(IDataManager par1ISaveHandler, String par2Str, WorldProvider par3WorldProvider, WorldSettings par4WorldSettings, MethodProfiler par5Profiler, IConsoleLogManager par6ILogAgent, long world_creation_time, long total_world_time) {
//        super(par1ISaveHandler, par2Str, par3WorldProvider, par4WorldSettings, par5Profiler, par6ILogAgent, world_creation_time, total_world_time);
//    }
//
//    public WorldData getWorldInfoC(){
//        return this.worldInfo;
//    }
//
//    @Shadow
//    protected IChunkProvider createChunkProvider() {
//        return null;
//    }
//
//    @Shadow
//    public Entity getEntityByID(int i) {
//        return null;
//    }
//}
