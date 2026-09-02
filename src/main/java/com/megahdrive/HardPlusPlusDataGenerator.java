package com.megahdrive;

import com.megahdrive.datagen.ModEnglishLangProvider;
import com.megahdrive.datagen.ModEntityTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class HardPlusPlusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModEntityTagProvider::new);
		pack.addProvider(ModEnglishLangProvider::new);
	}
}
