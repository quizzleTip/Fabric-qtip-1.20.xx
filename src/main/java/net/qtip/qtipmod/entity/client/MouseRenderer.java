package net.qtip.qtipmod.entity.client;


import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;
import net.qtip.qtipmod.entity.custom.MouseEntity;

public class MouseRenderer extends MobEntityRenderer<MouseEntity, Mouse<MouseEntity>> {
    private static final Identifier TEXTURE = Identifier.of(QtipMod.MOD_ID, "textures/entity/mouse.png");

    public MouseRenderer(EntityRendererFactory.Context context) {
        super(context, new Mouse<>(context.getPart(ModModelLayers.MOUSE)), 0.5f);
    }

    @Override
    public Identifier getTexture(MouseEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MouseEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }else{
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
