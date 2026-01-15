package net.racquo.raccoonsCo.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.util.ModTags;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.RACCOON_PELT_HELMET);
        //valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.RACCOON_PELT_HELMET);
        valueLookupBuilder(ModTags.Items.RACCOON_PELT_REPAIR).add(ModItems.RACCOON_PELT);
        valueLookupBuilder(ItemTags.MAP_INVISIBILITY_EQUIPMENT).add(ModItems.RACCOON_PELT_HELMET);
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModBlocks.LUPINE.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModBlocks.MARIGOLD.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModBlocks.VIOLET.asItem());
        valueLookupBuilder(ItemTags.BEE_FOOD).add(ModBlocks.MILKWEED.asItem());



    }
}
