package net.racquo.raccoonsCo.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEquipment;
import net.minecraft.item.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.racquo.raccoonsCo.RaccoonsCo;


import java.util.function.Consumer;
import java.util.function.Function;


public class ModItems {


    //register items

    public static final Item RACCOON_PELT = registerItem( "raccoon_pelt", Item :: new);
    public static final Item BANDIT_POTTERY_SHERD = registerItem( "bandit_pottery_sherd", Item :: new);
    public static final Item BOILED_EGG = registerItem( "boiled_egg",
            setting -> new Item(setting.food(ModFoodComponents.BOILED_EGG)));
    public static final Item RACCOON_PELT_HELMET = registerItem("raccoon_pelt_helmet",
            setting -> new Item(setting.armor(ModArmorMaterials.RACCOON_PELT_ARMOR_MATERIAL, EquipmentType.HELMET)));


    //register item helper

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(RaccoonsCo.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RaccoonsCo.MOD_ID, name)))));
    }

    //register items to creative tab(s)

    public static void registerModItems(){
        RaccoonsCo.LOGGER.info("Registering ModItems for" + RaccoonsCo.MOD_ID );

        //add item(s) to creative tab(s)
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RACCOON_PELT);
            entries.add(BANDIT_POTTERY_SHERD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(BOILED_EGG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(RACCOON_PELT_HELMET);
        });


        }
    }

