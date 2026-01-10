package net.racquo.raccoonsCo.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.RaccoonsCo;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

public class ModEntities {

    private static final RegistryKey<EntityType<?>> RACCOONS_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RaccoonsCo.MOD_ID, "raccoon"));


    public static final EntityType<RaccoonEntity> RACCOON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RaccoonsCo.MOD_ID, "raccoon"),
            EntityType.Builder.create(RaccoonEntity :: new, SpawnGroup.CREATURE)
                    .dimensions(0.8f, 0.8f).build(RACCOONS_KEY));

    public static void registerModEntities(){
        RaccoonsCo.LOGGER.info("Registering Mod Entities for " + RaccoonsCo.MOD_ID);
    }
}
