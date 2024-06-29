package net.qtip.qtipmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;
import net.qtip.qtipmod.entity.custom.CrowEntity;

public class CrowRenderer extends MobEntityRenderer<CrowEntity, Crow<CrowEntity>> {
    private static final Identifier TEXTURE = Identifier.of(QtipMod.MOD_ID, "textures/entity/crow.png");

    public CrowRenderer(EntityRendererFactory.Context context) {
        super(context, new Crow<>(context.getPart(ModModelLayers.CROW)), 0.5f);
    }

    @Override
    public Identifier getTexture(CrowEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CrowEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.75f, 0.75f, 0.75f);
        } else {
            matrixStack.scale(1.5f, 1.5f, 1.5f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
