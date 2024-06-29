package net.qtip.qtipmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.qtip.qtipmod.block.ModBlocks;
import net.qtip.qtipmod.block.custom.PeanutCropBlock;
import net.qtip.qtipmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //add blocks here to drop themselves
        addDrop(ModBlocks.MOREL);

        //other shit
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.PEANUT_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(PeanutCropBlock.AGE,7));
        addDrop(ModBlocks.PEANUT_CROP, cropDrops(ModBlocks.PEANUT_CROP, ModItems.PEANUTS, ModItems.PEANUTS, builder));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_BUSH).properties(StatePredicate.Builder.create()
                .exactMatch(PeanutCropBlock.AGE,7));
        addDrop(ModBlocks.STRAWBERRY_BUSH, cropDrops(ModBlocks.STRAWBERRY_BUSH, ModItems.STRAWBERRY, ModItems.STRAWBERRY, builder2));






    }
}
