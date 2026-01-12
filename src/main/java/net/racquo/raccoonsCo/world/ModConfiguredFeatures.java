package net.racquo.raccoonsCo.world;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.PredicatedStateProvider;
import net.racquo.raccoonsCo.RaccoonsCo;
import net.racquo.raccoonsCo.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MARIGOLD_KEY = registerKey("marigold");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIOLET_KEY = registerKey("violet");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUPINE_KEY = registerKey("lupine");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MILKWEED_KEY = registerKey("milkweed");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMPY_REEDS_KEY = registerKey("swampy_reeds");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_GRASS_KEY = registerKey("swamp_grass");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        //define generation parameters
        register(context, MARIGOLD_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MARIGOLD.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, VIOLET_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.VIOLET.getDefaultState())), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, Blocks.COARSE_DIRT)));

        register(context, LUPINE_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUPINE.getDefaultState())), List.of(Blocks.GRASS_BLOCK)));

        register(context, MILKWEED_KEY, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MILKWEED.getDefaultState())), List.of(Blocks.GRASS_BLOCK, Blocks.MUD)));

        register(context, SWAMPY_REEDS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        32, 6, 3,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        BlockStateProvider.of(ModBlocks.SWAMPY_REEDS.getDefaultState())
                                )
                        )
                )
        );
        register(context, SWAMP_GRASS_KEY, Feature.RANDOM_PATCH,ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SWAMP_GRASS.getDefaultState())), List.of(Blocks.GRASS_BLOCK, Blocks.MUD)));
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
