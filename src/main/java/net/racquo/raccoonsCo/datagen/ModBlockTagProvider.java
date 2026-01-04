package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.racquo.raccoonsCo.block.ModBlocks;


import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

       valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.EXAMPLE_BLOCK);

       valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.MARIGOLD);
       valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.MARIGOLD_FLOWER_POT);
       valueLookupBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.VIOLET);
       valueLookupBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.VIOLET_FLOWER_POT);

    }
}
