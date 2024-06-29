package net.qtip.qtipmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;
import net.qtip.qtipmod.entity.custom.SnowOwlEntity;

public class SnowOwlRenderer extends MobEntityRenderer<SnowOwlEntity, SnowOwl<SnowOwlEntity>> {
    private static final Identifier TEXTURE = Identifier.of(QtipMod.MOD_ID, "textures/entity/snowy_owl.png");

    public SnowOwlRenderer(EntityRendererFactory.Context context) {
        super(context, new SnowOwl<>(context.getPart(ModModelLayers.SNOWOWL)), 0.5f);
    }

    @Override
    public Identifier getTexture(SnowOwlEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SnowOwlEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }else{
            matrixStack.scale(1.0f, 1.0f, 1.0f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}