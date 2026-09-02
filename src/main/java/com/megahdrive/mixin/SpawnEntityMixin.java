package com.megahdrive.mixin;

import com.megahdrive.HardPlusPlus;
import com.megahdrive.tags.ModTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.zombie.Zombie;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerLevel.class)
public class SpawnEntityMixin {
	@Inject(at = @At("HEAD"), method = "addFreshEntity")
	private void addFreshEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		if (!(entity instanceof LivingEntity e)) return;

		AttributeInstance maxHealthAttribute = e.getAttribute(Attributes.MAX_HEALTH);
		AttributeInstance movementSpeedAttribute = e.getAttribute(Attributes.MOVEMENT_SPEED);
		AttributeInstance attackDamageAttribute = e.getAttribute(Attributes.ATTACK_DAMAGE);

		if (e.is(ModTags.HEALTH_UP) && maxHealthAttribute != null) {
			double max = maxHealthAttribute.getBaseValue() * HardPlusPlus.CONFIG.healthModifier;

			maxHealthAttribute.setBaseValue(max);
			e.setHealth((float) max);
		}

		if (e.is(ModTags.SPEED_UP) && movementSpeedAttribute != null) {
			movementSpeedAttribute.setBaseValue(movementSpeedAttribute.getBaseValue() * HardPlusPlus.CONFIG.speedUpRate);
		}

		if (e.is(ModTags.DAMAGE_UP) && attackDamageAttribute != null) {
			attackDamageAttribute.setBaseValue(attackDamageAttribute.getBaseValue() * HardPlusPlus.CONFIG.atkUpRate);
		}

		if (e instanceof Creeper && movementSpeedAttribute != null) {
			movementSpeedAttribute.setBaseValue(movementSpeedAttribute.getBaseValue() * HardPlusPlus.CONFIG.creeperSpeed);
		}
	}
}