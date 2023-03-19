package net.lee.hydroxide.mixins.render;

import net.lee.hydroxide.Hydroxide;
import net.lee.hydroxide.module.Module;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class GuiInGameMixin extends avk{

    @Inject(method = "a(FZII)V", at = @At(value = "RETURN", target = "Lnet/minecraft/Minecraft;inDevMode()Z", shift = At.Shift.BEFORE))
    private void injectRenderGameOverlay(CallbackInfo callbackInfo) {
            Hydroxide.moduleManger.getEnableModules().forEach(Module::draw);
    }

//    @Shadow
//    private void drawAllottedTime(int row, int col, avi var8) {
//
//    }
//    @Shadow
//    private void drawTournamentScore(int row, int col, avi var8) {
//
//    }
//    @Shadow
//    private void a(ScoreboardObjective par1ScoreObjective, int par2, int par3, avi par4FontRenderer) {
//
//    }
//    @Shadow
//    @Final
//    private Minecraft g;
//    @Shadow
//    private auu h;
//    @Shadow
//    private int i;
//    @Shadow
//    private String j = "";
//    @Shadow
//    private int o;
//    @Shadow
//    private boolean p;
//    @Shadow
//    public float a = 1.0F;
//    @Shadow
//    private int q;
//    @Shadow
//    private ItemStack r;
//    @Shadow
//    @Final
//    protected static bjo MITE_icons;
//    @Shadow
//    private void d() {
//
//    }
//    @Shadow
//    private void a(int par1, int par2) {
//
//    }
//    @Shadow
//    private void a(float par1, int par2, int par3) {
//
//    }
//    @Shadow
//    private void renderVisionDim(int par1, int par2, float vision_dimming) {
//
//    }
//    @Shadow
//    private void renderRunegateEffect(int par1, int par2) {
//
//    }
//    @Shadow
//    private void b(int par1, int par2) {
//
//    }
//    @Shadow
//    public static long display_overburdened_cpu_icon_until_ms;
//    @Shadow
//    public int curse_notification_counter;
//    @Shadow
//    private String last_highlighting_item_stack_text;
//    @Shadow
//    public static int allotted_time = -1;
//    @Shadow
//    public static int server_load = -1;
//    @Shadow
//    private void a(int par1, int par2, int par3, float par4) {
//
//    }
//    @Shadow
//    @Final
//    private static bjo c;

//    public void a(float par1, boolean par2, int par3, int par4) {
//    awf var5 = new awf(this.g.u, this.g.d, this.g.e);
//    int var6 = var5.a();
//    int var7 = var5.b();
//    avi var8 = this.g.l;
//    this.g.p.c();
//    if (!this.g.h.isGhost()) {
//        GL11.glEnable(3042);
//        int skylight_subtracted = this.g.f.skylightSubtracted;
//        int skylight_subtracted_ignoring_rain_and_thunder = this.g.f.skylight_subtracted_ignoring_rain_and_thunder;
//        this.g.f.skylightSubtracted = 0;
//        this.g.f.skylight_subtracted_ignoring_rain_and_thunder = 0;
//        float vignette_brightness = this.g.h.getBrightness(par1);
//        this.g.f.skylightSubtracted = skylight_subtracted;
//        this.g.f.skylight_subtracted_ignoring_rain_and_thunder = skylight_subtracted_ignoring_rain_and_thunder;
//        if (this.g.h.is_cursed && vignette_brightness > 0.0F) {
//            vignette_brightness = 0.0F;
//        }
//
//        if ((Minecraft.s() || this.g.h.is_cursed) && this.g.u.gui_mode != 2) {
//            this.a(vignette_brightness, var6, var7);
//        } else {
//            GL11.glBlendFunc(770, 771);
//        }
//
//        if (this.g.u.aa == 0 && this.g.h.isWearingPumpkinHelmet()) {
//            this.b(var6, var7);
//        }
//
//        if (!this.g.h.isPotionActive(MobEffectList.confusion)) {
//            float var10000 = this.g.h.bO + (this.g.h.bN - this.g.h.bO) * par1;
//        }
//
//        float interpolated_vision_dimming = this.g.h.vision_dimming - par1 * 0.01F;
//        if (interpolated_vision_dimming > 0.01F) {
//            this.renderVisionDim(var6, var7, Math.min(interpolated_vision_dimming, 0.9F));
//        }
//
//        if (this.g.h.runegate_counter > 0) {
//            this.renderRunegateEffect(var6, var7);
//        }
//
//        int eye_block_x = this.g.h.getBlockPosX();
//        int eye_block_y = MathHelper.floor_double(this.g.h.getEyePosY() - 0.05000000074505806);
//        int eye_block_z = this.g.h.getBlockPosZ();
//        Block block = this.g.f.getBlock(eye_block_x, eye_block_y, eye_block_z);
//        boolean prevent_xray_vision = this.g.f.isBlockSolid(block, eye_block_x, eye_block_y, eye_block_z) && block != Block.glass;
//        if (prevent_xray_vision && !block.isOpaqueStandardFormCube(this.g.f, eye_block_x, eye_block_y, eye_block_z)) {
//            prevent_xray_vision = false;
//        }
//
//        if (prevent_xray_vision) {
//            GL11.glDisable(2929);
//            GL11.glDisable(3008);
//            a(0, 0, var6, var7, -16777216);
//            GL11.glEnable(3008);
//            GL11.glEnable(2929);
//        }
//
//        int sleep_counter = this.g.h.falling_asleep_counter;
//        int var11;
//        if (sleep_counter > 0) {
//            var11 = Math.min(255 * sleep_counter / 100, 255);
//            this.g.C.startSection("sleep");
//            GL11.glDisable(2929);
//            GL11.glDisable(3008);
//            a(0, 0, var6, var7, var11 << 24);
//            GL11.glEnable(3008);
//            GL11.glEnable(2929);
//            this.g.C.endSection();
//        }
//
//        int var13;
//        if (!this.g.c.a() && this.g.u.gui_mode == 0) {
//            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//            if (display_overburdened_cpu_icon_until_ms >= System.currentTimeMillis()) {
//                this.g.J().a(MITE_icons);
//                this.b(var6 - 17, 2, 0, 0, 16, 16);
//            }
//
//            this.g.J().a(c);
//            PlayerInventory var31 = this.g.h.inventory;
//            this.n = -90.0F;
//            this.b(var6 / 2 - 91, var7 - 22, 0, 0, 182, 22);
//            if (this.g.c.auto_use_mode_item != null) {
//                GL11.glColor4f(0.8F, 1.0F, 0.7F, 1.0F);
//            }
//
//            this.b(var6 / 2 - 91 - 1 + var31.currentItem * 20, var7 - 22 - 1, 0, 22, 24, 22);
//            if (this.g.c.auto_use_mode_item != null) {
//                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//            }
//
//            this.g.J().a(m);
//            GL11.glEnable(3042);
//            GL11.glBlendFunc(775, 769);
//            this.b(var6 / 2 - 7, var7 / 2 - 7, 0, 0, 16, 16);
//            GL11.glDisable(3042);
//            this.g.C.startSection("bossHealth");
//            this.d();
//            this.g.C.endSection();
//            if (this.g.c.b()) {
//                this.a(var6, var7);
//            }
//
//            GL11.glDisable(3042);
//            this.g.C.startSection("actionBar");
//            GL11.glEnable(32826);
//            att.c();
//
//            for(var11 = 0; var11 < 9; ++var11) {
//                int var12 = var6 / 2 - 90 + var11 * 20 + 2;
//                var13 = var7 - 16 - 3;
//                this.a(var11, var12, var13, par1);
//            }
//
//            att.a();
//            GL11.glDisable(32826);
//            this.g.C.endSection();
//        }
//
//        int var32 = 16777215;
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        var11 = var6 / 2 - 91;
//        int var14;
//        int var15;
//        int var17;
//        int var16;
//        float var33;
//        short var37;
//        if (this.g.h.u() && this.g.u.gui_mode == 0) {
//            this.g.C.startSection("jumpBar");
//            this.g.J().a(avk.m);
//            var33 = this.g.h.bN();
//            var37 = 182;
//            var14 = (int)(var33 * (float)(var37 + 1));
//            var15 = var7 - 32 + 3;
//            this.b(var11, var15, 0, 84, var37, 5);
//            if (var14 > 0) {
//                this.b(var11, var15, 0, 89, var14, 5);
//            }
//
//            this.g.C.endSection();
//        } else if (this.g.c.f() && this.g.u.gui_mode == 0 && !(this.g.n instanceof axf)) {
//            this.g.C.startSection("expBar");
//            this.g.J().a(avk.m);
//            var37 = 182;
//            var14 = (int)(this.g.h.getLevelProgress() * (float)(var37 + 1));
//            var15 = var7 - 32 + 3;
//            this.b(var11, var15, 0, 64, var37, 5);
//            if (var14 > 0) {
//                this.b(var11, var15, 0, 69, var14, 5);
//            }
//
//            this.g.C.endSection();
//            if (this.g.h.getExperienceLevel() != 0 && !(this.g.n instanceof axf)) {
//                this.g.C.startSection("expLevel");
//                boolean var35 = false;
//                var14 = var35 ? 16777215 : 8453920;
//                if (this.g.h.getExperienceLevel() < 0) {
//                    var14 = 16716563;
//                }
//
//                String var42 = "" + this.g.h.getExperienceLevel();
//                var16 = (var6 - var8.a(var42)) / 2;
//                var17 = var7 - 31 - 4;
//                boolean var18 = false;
//                var8.b(var42, var16 + 1, var17, 0);
//                var8.b(var42, var16 - 1, var17, 0);
//                var8.b(var42, var16, var17 + 1, 0);
//                var8.b(var42, var16, var17 - 1, 0);
//                var8.b(var42, var16, var17, var14);
//                this.g.C.endSection();
//            }
//        }
//
//        int var22;
//        if (this.curse_notification_counter > 0 && this.g.h.is_cursed) {
//            avi fr = this.g.l;
//            awf sr = new awf(this.g.u, this.g.d, this.g.e);
//            String text = Translator.get(this.g.h.is_cursed ? "curse.notify" : "curse.lifted");
//            var14 = var7 - 59;
//            if (!this.g.c.b()) {
//                var14 += 14;
//            }
//
//            var22 = (int)((float)this.curse_notification_counter * 256.0F / 10.0F);
//            if (var22 > 255) {
//                var22 = 255;
//            }
//
//            if (var22 > 0) {
//                GL11.glEnable(3042);
//                GL11.glBlendFunc(770, 771);
//                fr.a(EnumChatFormat.DARK_PURPLE + text, (sr.a() - fr.a(text)) / 2, var14, 16777215 + (var22 << 24));
//                GL11.glDisable(3042);
//            }
//
//            this.q = 0;
//        }
//
//        String var36;
//        if (this.g.u.D && this.g.u.gui_mode == 0) {
//            this.g.C.startSection("toolHighlight");
//            if (this.q > 0 && this.r != null) {
//                var36 = this.r.getMITEStyleDisplayName();
//                var13 = (var6 - var8.a(var36)) / 2;
//                var14 = var7 - 59;
//                if (!this.g.c.b()) {
//                    var14 += 14;
//                }
//
//                var15 = (int)((float)this.q * 256.0F / 10.0F);
//                if (var15 > 255) {
//                    var15 = 255;
//                }
//
//                if (var15 > 0) {
//                    GL11.glPushMatrix();
//                    GL11.glEnable(3042);
//                    GL11.glBlendFunc(770, 771);
//                    var8.a(var36, var13, var14, 16777215 + (var15 << 24));
//                    GL11.glDisable(3042);
//                    GL11.glPopMatrix();
//                }
//
//                this.last_highlighting_item_stack_text = var36;
//            }
//
//            if (this.r == null) {
//                this.last_highlighting_item_stack_text = null;
//            }
//
//            this.g.C.endSection();
//        }
//        if (this.g.u.gui_mode == 0) {
//            this.g.C.startSection("Hydroxide");
//            //Hydroxide.moduleManger.getEnableModules().forEach(Module::draw);
//            //Minecraft.w().l.b("HY212", 100, 100, new Color(12, 12, 12).getRGB());
//            Block entityHit = Minecraft.w().t.getBlockHit();
//            if (Minecraft.w().t.isBlock()){
//                System.out.println("isBlock ok");
//            //Minecraft.w().l.b("HY212", 100, 100, new Color(12, 12, 12).getRGB());
////                EntityLiving entity = (EntityLiving)entityHit;
////                axv.a(110, 100, 30, 0, 0, entity);
////                Minecraft.w().l.b(entityHit.getEntityName(), 100, 100, new Color(12, 12, 12).getRGB());
////                Minecraft.w().l.b(String.format("%s/%s", entity.getMaxHealth(), entity.getHealth()), 100, 110, new Color(12, 12, 12).getRGB());
//            }
//            this.g.C.endSection();
//        }
//
//        if (this.g.p()) {
//            this.g.C.startSection("demo");
//            var36 = "";
//            if (this.g.f.getTotalWorldTime() >= 120500L) {
//                var36 = bkb.a("demo.demoExpired");
//            } else {
//                var36 = bkb.a("demo.remainingTime", new Object[]{StripColor.a((int)(120500L - this.g.f.getTotalWorldTime()))});
//            }
//
//            var13 = var8.a(var36);
//            var8.a(var36, var6 - var13 - 10, 5, 16777215);
//            this.g.C.endSection();
//        }
//
//        if (DedicatedServer.tournament_type == EnumTournamentType.score) {
//            ClientPlayer var67 = this.g.h;
//            var67.delta_tournament_score_opacity -= 2;
//            if (this.g.h.delta_tournament_score_opacity < 0) {
//                this.g.h.delta_tournament_score = 0;
//                this.g.h.delta_tournament_score_opacity = 0;
//            }
//
//            this.g.last_known_delta_tournament_score = this.g.h.delta_tournament_score;
//            this.g.last_known_delta_tournament_score_opacity = this.g.h.delta_tournament_score_opacity;
//            this.g.last_known_tournament_score = this.g.h.tournament_score;
//        }
//
//        int row = 0;
//        if (Minecraft.getErrorMessage() != null) {
//            this.b(var8, Minecraft.getErrorMessage(), 2, 2 + 10 * row++, 16716563);
//            this.b(var8, "Press [c] to clear error message.", 2, 2 + 10 * row++, 16716563);
//        }
//
//        if (this.g.u.ab && this.g.u.gui_mode == 0) {
//            if (DedicatedServer.tournament_type == EnumTournamentType.score) {
//                this.drawTournamentScore(row++, 2, var8);
//            }
//
//            if (allotted_time >= 0) {
//                this.drawAllottedTime(row++, 2, var8);
//            }
//        }
//
//        Minecraft var10003;
//        StringBuilder var68;
//        if (Minecraft.inDevMode() && this.g.u.gui_mode == 0) {
//            if (server_load >= 0) {
//                awf sr = new awf(this.g.u, this.g.d, this.g.e);
//                String text = server_load + "%";
//                this.b(var8, text, sr.a() - var8.a(text) - 2, 2, 14737632);
//            }
//
//            var68 = (new StringBuilder()).append("Legs (").append(MathHelper.floor_double(this.g.h.posX)).append(", ").append(MathHelper.floor_double(this.g.h.posY - (double)this.g.h.yOffset)).append(", ").append(MathHelper.floor_double(this.g.h.posZ)).append(")  yaw=").append(StringHelper.formatFloat(this.g.h.rotationYaw, 1, 1)).append("  ").append(this.g.h.getDirectionFromYaw()).append(" pitch=").append(StringHelper.formatFloat(this.g.h.rotationPitch, 1, 1)).append("   FPS=");
//            var10003 = this.g;
//            var68 = var68.append(Minecraft.last_fps).append(" (");
//            var10003 = this.g;
//            this.b(var8, var68.append(Minecraft.last_fp10s).append(")").toString(), 2, 2 + 10 * row++, 14737632);
//            if (Debug.flag) {
//                this.b(var8, "FLAG", 320, 2, 16716563);
//            }
//        }
//
//        if (Debug.is_active && this.g.u.gui_mode == 0) {
//            this.b(var8, "Counter: " + Debug.general_counter, 2, 2 + 10 * row++, 14737632);
//            if (Debug.biome_info != null) {
//                this.b(var8, Debug.biome_info, 2, 2 + 10 * row++, 14737632);
//            }
//
//            if (Debug.selected_object_info != null) {
//                this.b(var8, Debug.selected_object_info, 2, 2 + 10 * row++, 14737632);
//            }
//
//            if (Debug.equipped_item_info != null) {
//                this.b(var8, Debug.equipped_item_info, 2, 2 + 10 * row++, 14737632);
//            }
//
//            if (Debug.general_info != null) {
//                this.b(var8, Debug.general_info, 2, 2 + 10 * row++, 14737632);
//            }
//
//            if (Debug.general_info_client != null) {
//                this.b(var8, "[Client] " + Debug.general_info_client, 2, 2 + 10 * row++, 14737632);
//            }
//
//            if (Debug.general_info_server != null) {
//                this.b(var8, "[Server] " + Debug.general_info_server, 2, 2 + 10 * row++, 14737632);
//            }
//
//            row += 2;
//            this.b(var8, "Player entityId: " + this.g.h.entityId + ", username: " + this.g.h.getUsername(), 2, 2 + 10 * row++, 14737632);
//            this.b(var8, "O:" + this.g.f.getWorldInfo().getWorldTotalTime(0) + " U:" + this.g.f.getWorldInfo().getWorldTotalTime(-2) + " N:" + this.g.f.getWorldInfo().getWorldTotalTime(-1) + " E:" + this.g.f.getWorldInfo().getWorldTotalTime(1), 2, 2 + 10 * row++, 14737632);
//            WeatherEvent event = this.g.f.getCurrentWeatherEvent();
//            String s;
//            if (event != null) {
//                s = "Current rain: " + event.start + " to " + event.end;
//            } else {
//                event = this.g.f.getNextWeatherEvent(false);
//                if (event != null) {
//                    s = "Next rain: " + event.start + " to " + event.end;
//                } else {
//                    event = this.g.f.getPreviousWeatherEvent(false);
//                    s = event == null ? "No rain today" : "Previous rain: " + event.start + " to " + event.end;
//                }
//            }
//
//            this.b(var8, s, 2, 2 + 10 * row++, 14737632);
//            event = this.g.f.getCurrentWeatherEvent(true, false);
//            if (event != null) {
//                s = "Current storm: " + event.start_of_storm + " to " + event.end_of_storm;
//            } else {
//                event = this.g.f.getNextWeatherEvent(true);
//                if (event != null) {
//                    s = "Next storm: " + event.start_of_storm + " to " + event.end_of_storm;
//                } else {
//                    event = this.g.f.getPreviousWeatherEvent(true);
//                    s = event == null ? "No storm today" : "Previous storm: " + event.start_of_storm + " to " + event.end_of_storm;
//                }
//            }
//
//            this.b(var8, s, 2, 2 + 10 * row++, 14737632);
//            this.b(var8, "Client Pools: " + AxisAlignedBB.getAABBPool().getlistAABBsize() + " | " + this.g.f.getWorldVec3Pool().getPoolSize(), 2, 2 + 10 * row++, 14737632);
//            this.b(var8, "Server Pools: " + Minecraft.server_pools_string, 2, 2 + 10 * row++, 14737632);
//            ++row;
//            this.b(var8, "Atk: " + StringHelper.formatFloat(this.g.h.calcRawMeleeDamageVs((Entity)null), 1, 1) + "  Prt:" + StringHelper.formatFloat(this.g.h.getTotalProtection((DamageSource)null), 1, 1), 2, 2 + 10 * row++, 14737632);
//            this.b(var8, "Look: " + MathHelper.getNormalizedVector(this.g.h.rotationYaw, this.g.h.rotationPitch, this.g.f.getWorldVec3Pool()).toStringCompact(), 2, 2 + 10 * row++, 14737632);
//            this.b(var8, "fxLayers" + this.g.k.getStatsString(), 2, 2 + 10 * row++, 14737632);
//            Chunk chunk = this.g.h.getChunkFromPosition();
//            this.b(var8, "Chunk: " + chunk.xPosition + "," + chunk.zPosition + " [" + (this.g.h.getFootBlockPosY() >> 4) + "] FPP=" + StringHelper.formatDouble((double)EntityRenderer.getProximityToNearestFogPost(this.g.h), 3, 3), 2, 2 + 10 * row++, 14737632);
//            MinecraftServer mc_server = MinecraftServer.F();
//            if (mc_server != null) {
//                WorldServer world_server = mc_server.a(this.g.h.dimension);
//                this.b(var8, "Mobs high: " + world_server.countMobs(false, true) + " / " + world_server.last_mob_spawn_limit_at_60_or_higher, 2, 2 + 10 * row++, 14737632);
//                this.b(var8, "Mobs low:  " + world_server.countMobs(true, false) + " / " + world_server.last_mob_spawn_limit_under_60, 2, 2 + 10 * row++, 14737632);
//            }
//
//            this.b(var8, "Mem: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024L / 1024L + " / " + Runtime.getRuntime().totalMemory() / 1024L / 1024L, 2, 2 + 10 * row++, 14737632);
//        } else if (this.g.u.ab && this.g.u.gui_mode == 0) {
//            this.g.C.startSection("debug");
//            this.g.C.endSection();
//            if (DedicatedServer.tournament_type != EnumTournamentType.score && allotted_time < 0) {
//                var68 = (new StringBuilder()).append("");
//                var10003 = this.g;
//                this.b(var8, var68.append(Minecraft.last_fps).toString(), 2, 2 + 10 * row++, 14737632);
//            }
//        }
//
//        if (this.o > 0) {
//            this.g.C.startSection("overlayMessage");
//            var33 = (float)this.o - par1;
//            var13 = (int)(var33 * 255.0F / 20.0F);
//            if (var13 > 255) {
//                var13 = 255;
//            }
//
//            if (var13 > 8) {
//                GL11.glPushMatrix();
//                GL11.glTranslatef((float)(var6 / 2), (float)(var7 - 68), 0.0F);
//                GL11.glEnable(3042);
//                GL11.glBlendFunc(770, 771);
//                var14 = 16777215;
//                if (this.p) {
//                    var14 = Color.HSBtoRGB(var33 / 50.0F, 0.7F, 0.6F) & 16777215;
//                }
//
//                var8.b(this.j, -var8.a(this.j) / 2, -4, var14 + (var13 << 24 & -16777216));
//                GL11.glDisable(3042);
//                GL11.glPopMatrix();
//            }
//
//            this.g.C.endSection();
//        }
//
//        ScoreboardObjective var43 = this.g.f.getScoreboard().func_96539_a(1);
//        if (var43 != null) {
//            this.a(var43, var7, var6, var8);
//        }
//
//        GL11.glEnable(3042);
//        GL11.glBlendFunc(770, 771);
//        GL11.glDisable(3008);
//        GL11.glPushMatrix();
//        GL11.glTranslatef(0.0F, (float)(var7 - 48), 0.0F);
//        this.g.C.startSection("chat");
//        this.h.a(this.i);
//        this.g.C.endSection();
//        GL11.glPopMatrix();
//        var43 = this.g.f.getScoreboard().func_96539_a(0);
//        if (this.g.u.T.e && (!this.g.A() || this.g.h.netClientHandler.c.size() > 1 || var43 != null)) {
//            this.g.C.startSection("playerList");
//            NetClientHandler var41 = this.g.h.netClientHandler;
//            List var44 = var41.c;
//            var15 = var41.d;
//            var16 = var15;
//
//            for(var17 = 1; var16 > 20; var16 = (var15 + var17 - 1) / var17) {
//                ++var17;
//            }
//
//            int var45 = 300 / var17;
//            if (var45 > 150) {
//                var45 = 150;
//            }
//
//            int var19 = (var6 - var17 * var45) / 2;
//            byte var47 = 10;
//            a(var19 - 1, var47 - 1, var19 + var45 * var17, var47 + 9 * var16, Integer.MIN_VALUE);
//            int players_skipped = 0;
//
//            for(int var21 = 0; var21 < var15; ++var21) {
//                var22 = var19 + var21 % var17 * var45;
//                int var23 = var47 + var21 / var17 * 9;
//                int var23_alt = var47 + (var21 - players_skipped) / var17 * 9;
//                a(var22, var23, var22 + var45 - 1, var23 + 8, 553648127);
//                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//                GL11.glEnable(3008);
//                if (var21 < var44.size()) {
//                    bdj var49 = (bdj)var44.get(var21);
//                    ScoreboardTeam var48 = this.g.f.getScoreboard().getPlayersTeam(var49.a);
//                    String var52 = ScoreboardTeam.formatPlayerName(var48, var49.a);
//                    if ("avernite".equals(var52) && DedicatedServer.isTournament()) {
//                        ++players_skipped;
//                    } else {
//                        var8.a(var52, var22, var23_alt, 16777215);
//                        int var27;
//                        int var28;
//                        if (var43 != null) {
//                            var27 = var22 + var8.a(var52) + 5;
//                            var28 = var22 + var45 - 12 - 5;
//                            if (var28 - var27 > 5) {
//                                ScoreboardScore var29 = var43.a().func_96529_a(var49.a, var43);
//                                String var30 = EnumChatFormat.YELLOW + "" + var29.getScorePoints();
//                                var8.a(var30, var28 - var8.a(var30), var23_alt, 16777215);
//                            }
//                        } else {
//                            var27 = var22 + var8.a(var52) + 5;
//                            var28 = var22 + var45 - 12 - 5;
//                            if (var28 - var27 > 5) {
//                                String level;
//                                if (var49.level < 0) {
//                                    level = EnumChatFormat.RED + "" + var49.level;
//                                } else if (var49.level == 0) {
//                                    level = EnumChatFormat.GRAY + "" + var49.level;
//                                } else {
//                                    level = EnumChatFormat.GREEN + "+" + var49.level;
//                                }
//
//                                var8.a(level, var28 - var8.a(level), var23_alt, 16777215);
//                            }
//                        }
//
//                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//                        this.g.J().a(m);
//                        byte var53 = 0;
//                        boolean var51 = false;
//                        byte var50;
//                        if (var49.b < 0) {
//                            var50 = 5;
//                        } else if (var49.b < 150) {
//                            var50 = 0;
//                        } else if (var49.b < 300) {
//                            var50 = 1;
//                        } else if (var49.b < 600) {
//                            var50 = 2;
//                        } else if (var49.b < 1000) {
//                            var50 = 3;
//                        } else {
//                            var50 = 4;
//                        }
//
//                        this.n += 100.0F;
//                        this.b(var22 + var45 - 12, var23_alt, 0 + var53 * 10, 176 + var50 * 8, 10, 8);
//                        this.n -= 100.0F;
//                    }
//                }
//            }
//        }
//
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        GL11.glDisable(2896);
//        GL11.glEnable(3008);
//    }
//}
}
