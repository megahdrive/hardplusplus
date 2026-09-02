package com.megahdrive.integrations;

import com.megahdrive.HardPlusPlus;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;


public class ModMenuConfigImpl implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Component.translatable("text.hardplusplus.title"));

            ConfigCategory general = builder.getOrCreateCategory(Component.literal("General"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            general.addEntry(
                    entryBuilder.startTextDescription(
                            Component.translatable("text.hardplusplus.disclaimer").withStyle(ChatFormatting.YELLOW)
                    ).build()
            );

            general.addEntry(
                    entryBuilder.startFloatField(
                        Component.translatable("text.hardplusplus.healthModifier"),
                        HardPlusPlus.CONFIG.healthModifier
                    ).setDefaultValue(2.0F)
                    .setSaveConsumer(v -> HardPlusPlus.CONFIG.healthModifier = v)
                    .build());

            general.addEntry(
                    entryBuilder.startFloatField(
                                    Component.translatable("text.hardplusplus.healRate"),
                                    HardPlusPlus.CONFIG.healRate
                            ).setDefaultValue(1.0F)
                            .setSaveConsumer(v -> HardPlusPlus.CONFIG.healRate = v)
                            .build());

            general.addEntry(
                    entryBuilder.startDoubleField(
                                    Component.translatable("text.hardplusplus.speedUpRate"),
                                    HardPlusPlus.CONFIG.speedUpRate
                            ).setDefaultValue(1.5)
                            .setSaveConsumer(v -> HardPlusPlus.CONFIG.speedUpRate = v)
                            .build());

            general.addEntry(
                    entryBuilder.startDoubleField(
                                    Component.translatable("text.hardplusplus.atkUpRate"),
                                    HardPlusPlus.CONFIG.atkUpRate
                            ).setDefaultValue(1.7)
                            .setSaveConsumer(v -> HardPlusPlus.CONFIG.atkUpRate = v)
                            .build());

            general.addEntry(
                    entryBuilder.startDoubleField(
                                    Component.translatable("text.hardplusplus.creeperSpeed"),
                                    HardPlusPlus.CONFIG.creeperSpeed
                            ).setDefaultValue(1.25)
                            .setSaveConsumer(v -> HardPlusPlus.CONFIG.creeperSpeed = v)
                            .build());

            general.addEntry(
                    entryBuilder.startFloatField(
                                    Component.translatable("text.hardplusplus.fireDmgMod"),
                                    HardPlusPlus.CONFIG.fireDamageModifier
                            ).setDefaultValue(2F)
                            .setSaveConsumer(v -> HardPlusPlus.CONFIG.fireDamageModifier = v)
                            .build());

            general.addEntry(
                    entryBuilder.startFloatField(
                                    Component.translatable("text.hardplusplus.explosionRadMod"),
                                    HardPlusPlus.CONFIG.explosionRadiusModifier
                            ).setDefaultValue(2F)
                            .setSaveConsumer(v -> HardPlusPlus.CONFIG.explosionRadiusModifier = v)
                            .build());

            general.addEntry(
                    entryBuilder.startBooleanToggle(
                            Component.translatable("text.hardplusplus.disableElytraFireworks"),
                            HardPlusPlus.CONFIG.disableElytraFireworks
                    ).setDefaultValue(true)
                            .setSaveConsumer(v -> HardPlusPlus.CONFIG.disableElytraFireworks = v)
                            .build());

            builder.setSavingRunnable(HardPlusPlus.CONFIG::commit);
            return builder.build();
        };
    }

}