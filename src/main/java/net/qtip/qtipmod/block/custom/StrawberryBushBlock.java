package net.qtip.qtipmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.qtip.qtipmod.item.ModItems;

public class StrawberryBushBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntProperty AGE = Properties.AGE_7;

    public StrawberryBushBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.STRAWBERRY;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}
