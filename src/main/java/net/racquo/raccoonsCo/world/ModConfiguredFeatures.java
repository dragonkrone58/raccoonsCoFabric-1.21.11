package net.racquo.raccoonsCo.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.racquo.raccoonsCo.RaccoonsCo;
import net.racquo.raccoonsCo.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MARIGOLD_KEY = registerKey("marigold");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIOLET_KEY = registerKey("violet");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){

        register(context, MARIGOLD_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MARIGOLD.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, VIOLET_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.VIOLET.getDefaultState())), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL)));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(RaccoonsCo.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>>
    void register(Registerable<ConfiguredFeature<?, ?>> context,
                  RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
