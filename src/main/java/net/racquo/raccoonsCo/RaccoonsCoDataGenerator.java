package net.racquo.raccoonsCo;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.racquo.raccoonsCo.datagen.*;
import net.racquo.raccoonsCo.world.ModConfiguredFeatures;
import net.racquo.raccoonsCo.world.ModPlacedFeatures;

public class RaccoonsCoDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        //datagen
        pack.addProvider(ModModelProvider :: new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModLanguageProvider :: new);
        pack.addProvider(ModLootTableProvider :: new);
        pack.addProvider(ModEntityLootTableProvider :: new);
        pack.addProvider(ModRegistryDataGenerator :: new);
        pack.addProvider(ModItemTagProvider::new);

	}

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures:: bootstrap);
    }
}
