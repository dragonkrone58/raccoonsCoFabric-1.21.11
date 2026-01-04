package net.racquo.raccoonsCo.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.racquo.raccoonsCo.world.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers(){
        //define biome(s) flowers generate into

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.FLOWER_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MARIGOLD_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.VIOLET_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(
                BiomeKeys.MEADOW, BiomeKeys.WINDSWEPT_HILLS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUPINE_PLACED_KEY);
    }
}
