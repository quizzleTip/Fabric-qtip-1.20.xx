package net.qtip.qtipmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.qtip.qtipmod.block.ModBlocks;
import net.qtip.qtipmod.entity.ModEntities;
import net.qtip.qtipmod.entity.ModEntitySpawn;
import net.qtip.qtipmod.entity.custom.MothEntity;
import net.qtip.qtipmod.entity.custom.CrowEntity;
import net.qtip.qtipmod.entity.custom.MouseEntity;
import net.qtip.qtipmod.entity.custom.SnowOwlEntity;
import net.qtip.qtipmod.item.ModItems;
import net.qtip.qtipmod.util.ModCustomTrades;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QtipMod implements ModInitializer {
	public static final String MOD_ID = "qtipmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntities.registerModEntities();
		ModCustomTrades.registerCustomTrades();


		FabricDefaultAttributeRegistry.register(ModEntities.MOUSE, MouseEntity.createMouseAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.CROW, CrowEntity.createCrowAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SNOWOWL, SnowOwlEntity.createSnowOwlAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.MOTH, MothEntity.createMothAttributes());


		// Add entity spawn settings
		ModEntitySpawn.addEntitySpawn();
















	}
}