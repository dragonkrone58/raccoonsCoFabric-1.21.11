package net.racquo.raccoonsCo.block;

import com.mojang.serialization.MapCodec;
import jdk.jshell.Snippet;
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
import net.racquo.raccoonsCo.block.custom.SuspiciousMudBlock;
import net.racquo.raccoonsCo.block.custom.SwampyReedsBlock;

import java.util.function.Function;

public class ModBlocks {

    //REGISTER BLOCKS

    public static final Block EXAMPLE_BLOCK = registerBlock("example_block",
            properties -> new Block(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.COPPER)));

    public static final Block SWAMPY_REEDS = registerBlock("swampy_reeds",
            properties -> new SwampyReedsBlock(properties
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SWAMP_GRASS = registerBlock("swamp_grass",
            properties -> new PlantBlock(properties
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)) {
                @Override
                protected MapCodec<? extends PlantBlock> getCodec() {
                    return null;
                }
            });
    public static final Block MARIGOLD = registerBlock("marigold",
            properties -> new FlowerBlock(
            StatusEffects.SPEED, 4.0f, properties
                    .mapColor(MapColor.ORANGE)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block MARIGOLD_FLOWER_POT = registerBlockWithoutBlockItem("marigold_flower_pot",
            properties -> new FlowerPotBlock(ModBlocks.MARIGOLD, properties
                    .breakInstantly()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block VIOLET = registerBlock("violet",
            properties -> new FlowerBlock(
                    StatusEffects.POISON, 4.0f, properties
                    .mapColor(MapColor.PURPLE)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block VIOLET_FLOWER_POT = registerBlockWithoutBlockItem("violet_flower_pot",
            properties -> new FlowerPotBlock(ModBlocks.VIOLET, properties
                    .breakInstantly()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block LUPINE = registerBlock("lupine",
            properties -> new FlowerBlock(
                    StatusEffects.NIGHT_VISION, 4.0f, properties
                    .mapColor(MapColor.PURPLE)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block LUPINE_FLOWER_POT = registerBlockWithoutBlockItem("lupine_flower_pot",
            properties -> new FlowerPotBlock(ModBlocks.LUPINE, properties
                    .breakInstantly()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));


    public static final Block MILKWEED = registerBlock("milkweed",
            properties -> new FlowerBlock(
                    StatusEffects.POISON, 4.0f, properties
                    .mapColor(MapColor.PINK)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block MILKWEED_FLOWER_POT = registerBlockWithoutBlockItem("milkweed_flower_pot",
            properties -> new FlowerPotBlock(ModBlocks.MILKWEED, properties
                    .breakInstantly()
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)));


    //BLOCK REGISTER HELPERS
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RaccoonsCo.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(RaccoonsCo.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(RaccoonsCo.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RaccoonsCo.MOD_ID, name)))));
    }


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(RaccoonsCo.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RaccoonsCo.MOD_ID, name)))));
    }

    //REGISTER TO CREATIVE TABS
    public static void registerModBlocks(){
        RaccoonsCo.LOGGER.info("Registering ModBlocks for " + RaccoonsCo.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.EXAMPLE_BLOCK);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.MARIGOLD);
            entries.add(ModBlocks.VIOLET);
            entries.add(ModBlocks.LUPINE);
            entries.add(ModBlocks.MILKWEED);
            entries.add(ModBlocks.SWAMPY_REEDS);
            entries.add(ModBlocks.SWAMP_GRASS);
        });
    }


}
