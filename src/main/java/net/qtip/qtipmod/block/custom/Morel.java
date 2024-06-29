package net.qtip.qtipmod.block.custom;

import net.minecraft.block.MushroomPlantBlock;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class Morel extends MushroomPlantBlock {
    public Morel(RegistryKey<ConfiguredFeature<?, ?>> featureKey, Settings settings) {
        super(featureKey, settings);
    }
}
