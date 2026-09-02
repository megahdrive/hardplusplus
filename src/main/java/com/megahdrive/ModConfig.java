package com.megahdrive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE_PATH = FabricLoader.getInstance().getConfigDir().resolve(HardPlusPlus.MOD_ID + ".json");

    public float healthModifier = 2.0F;
    public float healRate = 1.0F;
    public double speedUpRate = 1.5;
    public double atkUpRate = 1.7;
    public double creeperSpeed = 1.25;
    public float fireDamageModifier = 2F;
    public float explosionRadiusModifier = 2F;
    public boolean disableElytraFireworks = true;

    public static ModConfig load() {
        try {
            if (Files.exists(FILE_PATH))
                return GSON.fromJson(Files.readString(FILE_PATH), ModConfig.class);
        } catch (IOException e) {
            HardPlusPlus.LOGGER.warn("Failed to read configuration from disk. Falling back to defaults.");
        }
        ModConfig def = new ModConfig();
        def.commit();
        return def;
    }

    public void commit() {
        try {
            Files.writeString(FILE_PATH, GSON.toJson(this));
        } catch (IOException e) {
            HardPlusPlus.LOGGER.warn("Failed to write configuration data to disk");
        }
    }

}
