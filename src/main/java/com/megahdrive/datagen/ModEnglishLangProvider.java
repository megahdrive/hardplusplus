package com.megahdrive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("text.hardplusplus.title", "Configure Hard++");
        translationBuilder.add("text.hardplusplus.disclaimer", "Multipliers are only applied to new mob spawns. Existing mobs will not be affected. For best results, create a new world.");

        translationBuilder.add("text.hardplusplus.healthModifier", "HP multiplier");
        translationBuilder.add("text.hardplusplus.healRate", "Passive healing rate (Hearts/second)");
        translationBuilder.add("text.hardplusplus.speedUpRate", "Undead speed multiplier");
        translationBuilder.add("text.hardplusplus.atkUpRate", "Attack multiplier");
        translationBuilder.add("text.hardplusplus.creeperSpeed", "Creeper speed multiplier");
        translationBuilder.add("text.hardplusplus.fireDmgMod", "On-fire damage multiplier");
        translationBuilder.add("text.hardplusplus.explosionRadMod", "Explosion power multiplier");
        translationBuilder.add("text.hardplusplus.disableElytraFireworks", "Elytra fireworks disabled");

    }

}
