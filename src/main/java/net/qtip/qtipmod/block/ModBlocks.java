package net.qtip.qtipmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;

public class ModBlocks {
//blocks here================
    public static final Block MOREL = registerBlock("morel",
            new Block(FabricBlockSettings.copyOf(Blocks.BROWN_MUSHROOM)));






    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(QtipMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(QtipMod.MOD_ID,name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        QtipMod.LOGGER.info("Registering ModBlocks for "+ QtipMod.MOD_ID);
    }
}
