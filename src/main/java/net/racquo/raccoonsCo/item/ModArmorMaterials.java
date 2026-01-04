package net.racquo.raccoonsCo.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.racquo.raccoonsCo.RaccoonsCo;
import net.racquo.raccoonsCo.util.ModTags;

import java.util.EnumMap;
import java.util.function.Supplier;

public class ModArmorMaterials {

    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> RACCOON_PELT_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(RaccoonsCo.MOD_ID, "raccoon_pelt"));

    public static final ArmorMaterial RACCOON_PELT_ARMOR_MATERIAL = new ArmorMaterial(8, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 6);
        map.put(EquipmentType.HELMET, 1);
        map.put(EquipmentType.BODY, 4);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,0,0, ModTags.Items.RACCOON_PELT_REPAIR, RACCOON_PELT_KEY);
}