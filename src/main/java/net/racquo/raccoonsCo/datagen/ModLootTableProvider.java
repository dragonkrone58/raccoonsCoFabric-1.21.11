package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.entity.ModEntities;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {


    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //generate block drops/loot
        addDrop(ModBlocks.EXAMPLE_BLOCK);
        addDrop(ModBlocks.MARIGOLD);
        addPottedPlantDrops(ModBlocks.MARIGOLD_FLOWER_POT);
        addDrop(ModBlocks.VIOLET);
        addPottedPlantDrops(ModBlocks.VIOLET_FLOWER_POT);
        addDrop(ModBlocks.LUPINE);
        addPottedPlantDrops(ModBlocks.LUPINE_FLOWER_POT);
    }
}


