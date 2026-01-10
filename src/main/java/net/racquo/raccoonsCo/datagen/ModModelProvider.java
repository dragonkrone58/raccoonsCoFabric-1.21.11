package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Model;
import net.minecraft.client.data.Models;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.item.ModArmorMaterials;
import net.racquo.raccoonsCo.item.ModItems;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXAMPLE_BLOCK);

        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModBlocks.MARIGOLD, ModBlocks.MARIGOLD_FLOWER_POT, BlockStateModelGenerator.CrossType.NOT_TINTED );
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModBlocks.VIOLET, ModBlocks.VIOLET_FLOWER_POT, BlockStateModelGenerator.CrossType.NOT_TINTED );
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModBlocks.LUPINE, ModBlocks.LUPINE_FLOWER_POT, BlockStateModelGenerator.CrossType.NOT_TINTED );
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModBlocks.MILKWEED, ModBlocks.MILKWEED_FLOWER_POT, BlockStateModelGenerator.CrossType.NOT_TINTED );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RACCOON_PELT, Models.GENERATED);
        //itemModelGenerator.register(ModItems.BANDIT_POTTERY_SHERD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOILED_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_CRAWFISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_CRAWFISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRAWFISH_BUCKET, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.RACCOON_PELT_HELMET, ModArmorMaterials.RACCOON_PELT_KEY,
                ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);

        itemModelGenerator.register(ModItems.RACCOON_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRAWFISH_SPAWN_EGG, Models.GENERATED);


    }
}

