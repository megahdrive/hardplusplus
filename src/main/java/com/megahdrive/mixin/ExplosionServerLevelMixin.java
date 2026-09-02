package com.megahdrive.mixin;

import com.megahdrive.HardPlusPlus;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerLevel.class)
public class ExplosionServerLevelMixin {
    @ModifyVariable(method = "explode", at = @At("HEAD"), argsOnly = true, name = "r")
    private float modifyExplosionRadius(float r) {
        return r * HardPlusPlus.CONFIG.explosionRadiusModifier;
    }
}
