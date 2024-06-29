package net.qtip.qtipmod.block;


import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.qtip.qtipmod.QtipMod;
import net.qtip.qtipmod.block.custom.Morel;
import net.qtip.qtipmod.block.custom.PeanutCropBlock;
import net.qtip.qtipmod.block.custom.StrawberryBushBlock;

public class ModBlocks {
//blocks here================
    public static final Block MOREL =  Registry.register(Registries.BLOCK, Identifier.of(QtipMod.MOD_ID,"morel_block"),
        new Morel(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM, FabricBlockSettings.copy(Blocks.BROWN_MUSHROOM)));



    public static final Block PEANUT_CROP = Registry.register(Registries.BLOCK, Identifier.of(QtipMod.MOD_ID,"peanut_crop"),
            new PeanutCropBlock(FabricBlockSettings.copy(Blocks.CARROTS)));
    public static final Block STRAWBERRY_BUSH = Registry.register(Registries.BLOCK, Identifier.of(QtipMod.MOD_ID,"strawberry_bush"),
            new StrawberryBushBlock(FabricBlockSettings.copy(Blocks.SWEET_BERRY_BUSH)));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(QtipMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(QtipMod.MOD_ID,name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        QtipMod.LOGGER.info("Registering ModBlocks for "+ QtipMod.MOD_ID);
    }
}
