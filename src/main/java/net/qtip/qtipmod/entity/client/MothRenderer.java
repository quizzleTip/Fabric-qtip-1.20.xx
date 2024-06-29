package net.qtip.qtipmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;
import net.qtip.qtipmod.entity.custom.MothEntity;

public class MothRenderer extends MobEntityRenderer<MothEntity, Moth<MothEntity>> {
    private static final Identifier TEXTURE = Identifier.of(QtipMod.MOD_ID, "textures/entity/moth.png");

    public MothRenderer(EntityRendererFactory.Context context) {
        super(context, new Moth<>(context.getPart(ModModelLayers.MOTH)), 0.5f);
    }

    @Override
    public Identifier getTexture(MothEntity entity) {return TEXTURE;}

    public void render(MothEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.75f, 0.75f, 0.75f);
        } else {
            matrixStack.scale(1.5f, 1.5f, 1.5f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
