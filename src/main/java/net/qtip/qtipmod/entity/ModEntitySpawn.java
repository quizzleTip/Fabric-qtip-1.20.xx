package net.qtip.qtipmod.entity;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {
    public static void addEntitySpawn() {
        // Add spawn settings for SnowOwlEntity in snowy taiga biomes
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.SNOWY_TAIGA),
                SpawnGroup.CREATURE,
                ModEntities.SNOWOWL,
                10, 1, 3
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.SNOWY_TAIGA, BiomeKeys.DARK_FOREST, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.BIRCH_FOREST),
                SpawnGroup.CREATURE,
                ModEntities.MOUSE,
                15, 1, 3
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.SNOWY_TAIGA, BiomeKeys.BIRCH_FOREST, BiomeKeys.DARK_FOREST, BiomeKeys.FOREST),
                SpawnGroup.CREATURE,
                ModEntities.CROW,
                15, 2, 5
        );
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST, BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP),
                SpawnGroup.CREATURE,
                ModEntities.MOTH,
                10, 1, 3
        );




        // Register spawn restriction to ensure mob spawns correctly
        //SpawnRestriction.register(ModEntities.SNOWOWL, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SnowOwlEntity::canSpawnInBiome);
    }
}