package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.racquo.raccoonsCo.block.ModBlocks;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

       valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.EXAMPLE_BLOCK);

        List<Block> MOD_FLOWERS = List.of(ModBlocks.MARIGOLD, ModBlocks.LUPINE, ModBlocks.VIOLET, ModBlocks.MILKWEED);

        List<Block> MOD_FLOWERPOTS = List.of(ModBlocks.LUPINE_FLOWER_POT,ModBlocks.MARIGOLD_FLOWER_POT,
                ModBlocks.VIOLET_FLOWER_POT, ModBlocks.MILKWEED_FLOWER_POT);

        for(Block block : MOD_FLOWERS){
            valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(block);
            valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(block);
        }

        for(Block block : MOD_FLOWERPOTS){
            valueLookupBuilder(BlockTags.FLOWER_POTS).add(block);
            valueLookupBuilder(BlockTags.BEE_ATTRACTIVE).add(block);
        }
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.MARIGOLD);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.MARIGOLD_FLOWER_POT);
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.VIOLET);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.VIOLET_FLOWER_POT);
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.LUPINE);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.LUPINE_FLOWER_POT);
        valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.MILKWEED);
        valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.MILKWEED_FLOWER_POT);


    }
}
