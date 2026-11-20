package net.racquo.raccoonsCo.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.RaccoonsCo;
import net.racquo.raccoonsCo.entity.custom.CrawfishEntity;
import net.racquo.raccoonsCo.entity.custom.CrawfishVariant;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;
import net.racquo.raccoonsCo.entity.custom.RedPandaEntity;

public class ModEntities {

    private static final RegistryKey<EntityType<?>> RACCOON_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RaccoonsCo.MOD_ID, "raccoon"));

    private static final RegistryKey<EntityType<?>> CRAWFISH_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RaccoonsCo.MOD_ID, "crawfish"));

    public static final RegistryKey<EntityType<?>> RED_PANDA_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(RaccoonsCo.MOD_ID, "red_panda"));

    public static final EntityType<RaccoonEntity> RACCOON = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RaccoonsCo.MOD_ID, "raccoon"),
            EntityType.Builder.create(RaccoonEntity :: new, SpawnGroup.CREATURE)
                    .dimensions(0.8f, 0.8f).build(RACCOON_KEY));

    public static final EntityType<CrawfishEntity> CRAWFISH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RaccoonsCo.MOD_ID, "crawfish"),
            EntityType.Builder.create(CrawfishEntity :: new, SpawnGroup.WATER_AMBIENT)
                    .dimensions(0.5f, 0.3f).build(CRAWFISH_KEY));


    public static final EntityType<RedPandaEntity> RED_PANDA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(RaccoonsCo.MOD_ID, "red_panda"),
            EntityType.Builder.create(RedPandaEntity :: new, SpawnGroup.CREATURE)
                    .dimensions(0.8f, 0.8f).build(RED_PANDA_KEY));

    public static void registerModEntities(){
        RaccoonsCo.LOGGER.info("Registering Mod Entities for " + RaccoonsCo.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.CRAWFISH, CrawfishEntity.createAttributes());
        // RACCOON registration if needed
        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.createAttributes());

        FabricDefaultAttributeRegistry.register(ModEntities.RED_PANDA, RedPandaEntity.createAttributes());
    }
}

