package com.megahdrive;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLevelEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.Identifier;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.monster.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HardPlusPlus implements ModInitializer {
	public static final String MOD_ID = "hardplusplus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ModConfig CONFIG = ModConfig.load();

	/*public static final float HEALTH_MODIFIER = 2.0F;
	public static final float HEAL_RATE = 1.0F;
	public static final double SPEED_UP_RATE = 1.5;
	public static final double ATK_UP_RATE = 1.7;
	public static final double CREEPER_SPEED = 1.25;
	//public static final float SPIDER_EFFECT_CHANCE = 0.5F;
	public static final float FIRE_DAMAGE_MODIFIER = 2F;
	public static final float EXPLOSION_RADIUS_MODIFIER = 2F;
	public static final boolean DISABLE_ELYTRA_FIREWORKS = true;*/

	@Override
	public void onInitialize() {
		LOGGER.info("onInitialize called");

		ServerLevelEvents.LOAD.register((server, level) -> {
			if (level.getDifficulty() != Difficulty.HARD)
				LOGGER.warn("A level loaded that is not hard difficulty.");
		});

		ServerLifecycleEvents.SERVER_STOPPING.register(server -> CONFIG.commit());
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
