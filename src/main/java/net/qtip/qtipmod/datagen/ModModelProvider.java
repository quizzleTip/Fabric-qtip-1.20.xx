package net.qtip.qtipmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.qtip.qtipmod.block.ModBlocks;
import net.qtip.qtipmod.block.custom.PeanutCropBlock;
import net.qtip.qtipmod.block.custom.StrawberryBushBlock;
import net.qtip.qtipmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerCrop(ModBlocks.PEANUT_CROP, PeanutCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_BUSH, StrawberryBushBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCross(ModBlocks.MOREL, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.APPLEPIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESESTEAK, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOWBERRYPIE, Models.GENERATED);
        //itemModelGenerator.register(ModItems.MOREL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEANUTBUTTER, Models.GENERATED);
        //itemModelGenerator.register(ModItems.PEANUTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROASTEDPEANUTS, Models.GENERATED);
        //itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SWEETBERRYPIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRYPIE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSEQUARTZ, Models.GENERATED);

        itemModelGenerator.register(ModItems.MAROON_GREATSWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MOONLIGHT_GREATSWORD, Models.HANDHELD);
    }
}
