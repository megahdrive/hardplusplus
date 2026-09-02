package com.megahdrive.mixin;

import com.megahdrive.HardPlusPlus;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;


@Mixin(LivingEntity.class)
public class LivingEntityFireDmgMixin {
    @ModifyVariable(method = "hurtServer", at = @At("HEAD"), argsOnly = true, name = "damage")
    private float modifyFireDmg(float damage, ServerLevel level, DamageSource source) {
        return source.is(DamageTypeTags.IS_FIRE) ? damage * HardPlusPlus.CONFIG.fireDamageModifier : damage;
    }
}
