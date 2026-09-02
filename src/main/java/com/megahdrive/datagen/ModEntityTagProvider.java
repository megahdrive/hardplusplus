package com.megahdrive.datagen;

import com.megahdrive.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.TagAppender;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypeIds;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public ModEntityTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @SuppressWarnings("UnusedReturnValue")
    private TagAppender<EntityType<?>> buildAgainstHostiles(TagKey<EntityType<?>> tK) {
        return builder(tK)
                .add(EntityTypeIds.SKELETON)
                .add(EntityTypeIds.BLAZE)
                .add(EntityTypeIds.BOGGED)
                .add(EntityTypeIds.BREEZE)
                .add(EntityTypeIds.CAMEL_HUSK)
                .add(EntityTypeIds.CREAKING)
                .add(EntityTypeIds.CREEPER)
                .add(EntityTypeIds.ELDER_GUARDIAN)
                .add(EntityTypeIds.ENDER_DRAGON)
                .add(EntityTypeIds.ENDERMITE)
                .add(EntityTypeIds.EVOKER)
                .add(EntityTypeIds.GHAST)
                .add(EntityTypeIds.GIANT)
                .add(EntityTypeIds.GUARDIAN)
                .add(EntityTypeIds.HOGLIN)
                .add(EntityTypeIds.HUSK)
                .add(EntityTypeIds.ILLUSIONER)
                .add(EntityTypeIds.MAGMA_CUBE)
                .add(EntityTypeIds.PARCHED)
                .add(EntityTypeIds.PHANTOM)
                .add(EntityTypeIds.PIGLIN_BRUTE)
                .add(EntityTypeIds.PIGLIN)
                .add(EntityTypeIds.PILLAGER)
                .add(EntityTypeIds.RAVAGER)
                .add(EntityTypeIds.SHULKER)
                .add(EntityTypeIds.SILVERFISH)
                .add(EntityTypeIds.SKELETON_HORSE)
                .add(EntityTypeIds.SLIME)
                .add(EntityTypeIds.SPIDER)
                .add(EntityTypeIds.STRAY)
                .add(EntityTypeIds.VEX)
                .add(EntityTypeIds.VINDICATOR)
                .add(EntityTypeIds.WARDEN)
                .add(EntityTypeIds.WITCH)
                .add(EntityTypeIds.WITHER)
                .add(EntityTypeIds.WITHER_SKELETON)
                .add(EntityTypeIds.ZOGLIN)
                .add(EntityTypeIds.ZOMBIE)
                .add(EntityTypeIds.ZOMBIE_HORSE)
                .add(EntityTypeIds.ZOMBIE_VILLAGER)
                .add(EntityTypeIds.CAVE_SPIDER)
                .add(EntityTypeIds.POLAR_BEAR)
                .add(EntityTypeIds.IRON_GOLEM)
                .add(EntityTypeIds.DROWNED);

    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        buildAgainstHostiles(ModTags.HEALTH_UP);
        buildAgainstHostiles(ModTags.DAMAGE_UP);

        builder(ModTags.SPEED_UP)
                .add(EntityTypeIds.ZOMBIE)
                .add(EntityTypeIds.HUSK)
                .add(EntityTypeIds.DROWNED)
                .add(EntityTypeIds.ZOMBIE_VILLAGER);
    }
}
