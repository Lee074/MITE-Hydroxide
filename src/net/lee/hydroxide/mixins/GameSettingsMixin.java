package net.lee.hydroxide.mixins;

import net.minecraft.ats;
import net.minecraft.aul;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(aul.class)
public class GameSettingsMixin {

    public ats keyBindXray= new ats("key.xray", 50);
    public ats keyBindNightVision= new ats("key.nightvision", 47);
    public ats keyBindNoFall= new ats("key.nofall", 38);

    @Overwrite
    public void initKeybindings() {
        this.W = new ats[]{this.R, this.S, this.I, this.J, this.K, this.L, this.M, this.Q, this.O, this.N, this.P, this.T, this.U, this.V, this.keyBindToggleRun, this.keyBindZoom, this.keyBindRedrawChunks,
                this.keyBindXray, this.keyBindNightVision, this.keyBindNoFall};
    }

    @Shadow
    public ats[] W;
    @Shadow
    public ats I;
    @Shadow
    public ats J;
    @Shadow
    public ats K;
    @Shadow
    public ats L;
    @Shadow
    public ats M;
    @Shadow
    public ats N;
    @Shadow
    public ats O;
    @Shadow
    public ats P;
    @Shadow
    public ats Q;
    @Shadow
    public ats R;
    @Shadow
    public ats S;
    @Shadow
    public ats T;
    @Shadow
    public ats U;
    @Shadow
    public ats V;
    public ats keyBindToggleRun;
    @Shadow
    public ats keyBindZoom;
    @Shadow
    public ats keyBindRedrawChunks;
}
