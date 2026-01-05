package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.sound.ModSounds;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    //generate en_us lang

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.RACCOON_PELT, "Raccoon Pelt");
        translationBuilder.add(ModItems.BANDIT_POTTERY_SHERD, "Bandit Pottery Sherd");
        translationBuilder.add(ModItems.BOILED_EGG, "Boiled Egg");
        translationBuilder.add(ModItems.RACCOON_PELT_HELMET, "Raccoon Skin Cap");
        translationBuilder.add(ModItems.RACCOON_SPAWN_EGG, "Raccoon Spawn Egg");

        translationBuilder.add(ModBlocks.EXAMPLE_BLOCK, "Example Block");
        translationBuilder.add(ModBlocks.MARIGOLD, "Marigold");
        translationBuilder.add(ModBlocks.MARIGOLD_FLOWER_POT, "Marigold Flower Pot");
        translationBuilder.add(ModBlocks.VIOLET, "Violet");
        translationBuilder.add(ModBlocks.VIOLET_FLOWER_POT, "Violet Flower Pot");
        translationBuilder.add(ModBlocks.LUPINE, "Lupine");
        translationBuilder.add(ModBlocks.LUPINE_FLOWER_POT, "Lupine Flower Pot");

        translationBuilder.add(ModEntities.RACCOON, "Raccoon");
        translationBuilder.add(ModSounds.RACCOON_IDLE, "Raccoon Chitters");



    }
}
