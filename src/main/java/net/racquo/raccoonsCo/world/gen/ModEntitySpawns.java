package net.racquo.raccoonsCo.world.gen;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.racquo.raccoonsCo.entity.ModEntities;

public class ModEntitySpawns {

    public static void addSpawns(){
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.MANGROVE_SWAMP, BiomeKeys.TAIGA)
        , SpawnGroup.CREATURE, ModEntities.RACCOON, 30, 1, 3);

        SpawnRestriction.register(ModEntities.RACCOON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES
        , AnimalEntity::isValidNaturalSpawn);
    }
}
