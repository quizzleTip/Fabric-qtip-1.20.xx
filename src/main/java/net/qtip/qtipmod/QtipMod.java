package net.qtip.qtipmod;

import net.fabricmc.api.ModInitializer;

import net.qtip.qtipmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QtipMod implements ModInitializer {
	public static final String MOD_ID = "qtipmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


		ModItems.registerModItems();
	}
}