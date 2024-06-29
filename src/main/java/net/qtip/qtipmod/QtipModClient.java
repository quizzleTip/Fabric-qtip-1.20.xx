package net.qtip.qtipmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.qtip.qtipmod.block.ModBlocks;
import net.qtip.qtipmod.entity.ModEntities;
import net.qtip.qtipmod.entity.client.*;

public class QtipModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PEANUT_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOREL, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.MOUSE, MouseRenderer::new);
        EntityRendererRegistry.register(ModEntities.CROW, CrowRenderer::new);
        EntityRendererRegistry.register(ModEntities.SNOWOWL, SnowOwlRenderer::new);
        EntityRendererRegistry.register(ModEntities.MOTH, MothRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOUSE, Mouse::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CROW, Crow::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SNOWOWL, SnowOwl::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOTH, Moth::getTexturedModelData);
    }
}
