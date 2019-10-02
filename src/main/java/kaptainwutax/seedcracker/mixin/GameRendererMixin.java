package kaptainwutax.seedcracker.mixin;

import kaptainwutax.seedcracker.render.RenderTracker;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class GameRendererMixin {

    @Inject(method = "renderCenter", at = @At("HEAD"))
    private void renderCenterStart(float delta, long time, CallbackInfo ci) {
        RenderTracker.get().setTrackRender(true);
    }

    @Inject(method = "renderCenter", at = @At("TAIL"))
    private void renderCenterFinish(float delta, long time, CallbackInfo ci) {
        RenderTracker.get().setTrackRender(false);
    }

}
