package net.qtip.qtipmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;
import net.qtip.qtipmod.entity.custom.MothEntity;
import net.qtip.qtipmod.entity.custom.CrowEntity;
import net.qtip.qtipmod.entity.custom.MouseEntity;
import net.qtip.qtipmod.entity.custom.SnowOwlEntity;

public class ModEntities {
    public static final EntityType<MouseEntity> MOUSE = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(QtipMod.MOD_ID, "mouse"),
        FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MouseEntity::new)
            .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<CrowEntity> CROW = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(QtipMod.MOD_ID, "crow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static final EntityType<SnowOwlEntity> SNOWOWL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(QtipMod.MOD_ID, "snowowl"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SnowOwlEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f,1.5f)).build());
    public static final EntityType<MothEntity> MOTH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(QtipMod.MOD_ID, "moth"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MothEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());

    public static void registerModEntities() {
        QtipMod.LOGGER.info("Registering Entities for " + QtipMod.MOD_ID);
    }




}


