package net.racquo.raccoonsCo.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.RaccoonsCo;

import java.util.function.Function;

public class ModBlocks {

    //create block(s)




    public static final Block EXAMPLE_BLOCK = registerBlock("example_block",
            properties -> new Block(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.COPPER)));

    /*public static final Block MARIGOLD = registerBlockWithoutBlockItem("marigold",
            properties-> new FlowerBlock(
                StatusEffects.SPEED,
                4f,
                AbstractBlock.Settings.create()
                .mapColor(MapColor.ORANGE)
                .noCollision()
                .breakInstantly()
                .sounds(BlockSoundGroup.GRASS)
                .offset(AbstractBlock.OffsetType.XZ).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block MARIGOLD_POT = registerBlock("marigold_pot", properties-> createFlowerPotBlock(MARIGOLD));


    //flower pot creator helper method because i cannot be arsed
    private static Block createFlowerPotBlock(Block flower){
        return new FlowerPotBlock(
                flower,
                AbstractBlock.Settings.create()
                .breakInstantly()
                .nonOpaque()
                .pistonBehavior(PistonBehavior.DESTROY));
    }

*/

    //helper to register block w/ item
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RaccoonsCo.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(RaccoonsCo.MOD_ID, name), toRegister);
    }


    //helper to register block item
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(RaccoonsCo.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RaccoonsCo.MOD_ID, name)))));
    }

    public static void registerModBlocks(){
        RaccoonsCo.LOGGER.info("Registering ModBlocks for " + RaccoonsCo.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.EXAMPLE_BLOCK);
        });
    }


}
