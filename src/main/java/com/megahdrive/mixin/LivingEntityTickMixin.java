package com.megahdrive.mixin;

import com.megahdrive.HardPlusPlus;
import com.megahdrive.tags.ModTags;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityTickMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    private void tick(CallbackInfo ci) {
        LivingEntity e = (LivingEntity) (Object) this;
        if (e.is(ModTags.HEALTH_UP) && e.tickCount % 20 == 0 && e.getHealth() < e.getMaxHealth()) {
            e.heal(HardPlusPlus.CONFIG.healRate);
        }
    }
}
