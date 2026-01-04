package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.MARIGOLD, ModBlocks.MARIGOLD_POT, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXAMPLE_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RACCOON_PELT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANDIT_POTTERY_SHERD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOILED_EGG, Models.GENERATED);

    }
}
