package com.megahdrive.tags;

import com.megahdrive.HardPlusPlus;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public interface ModTags {
    TagKey<EntityType<?>> HEALTH_UP = create("entity_health_up");
    TagKey<EntityType<?>> SPEED_UP = create("entity_speed_up");
    TagKey<EntityType<?>> DAMAGE_UP = create("entity_damage_up");

    private static TagKey<EntityType<?>> create(final String name) {
        return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(HardPlusPlus.MOD_ID, name));
    }
}
