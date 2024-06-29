// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.qtip.qtipmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.qtip.qtipmod.entity.animation.ModAnimations;
import net.qtip.qtipmod.entity.custom.CrowEntity;


public class Crow<T extends CrowEntity> extends SinglePartEntityModel<T> {
    private final ModelPart crow;
    private final ModelPart head;
    private final ModelPart body;

    public Crow(ModelPart root) {
        this.crow = root.getChild("crow");
        this.head = crow.getChild("head");
        this.body = crow.getChild("body");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData crow = modelPartData.addChild("crow", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData head = crow.addChild("head", ModelPartBuilder.create().uv(19, 21).cuboid(-1.5F, -1.06F, -2.82F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
                .uv(15, 0).cuboid(-0.5F, -0.86F, -0.82F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(18, 13).cuboid(-0.5F, 0.14F, 0.18F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(1, 24).cuboid(1.6F, -0.86F, -1.02F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(1, 24).cuboid(-1.6F, -0.86F, -1.02F, 0.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -8.94F, 3.82F));

        ModelPartData body = crow.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.5F, -4.4374F, 0.1098F));

        ModelPartData body_r1 = body.addChild("body_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, 1.0F, -2.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.8016F, 2.9809F, -0.6981F, 0.0F, 0.0F));

        ModelPartData butt = crow.addChild("butt", ModelPartBuilder.create().uv(10, 6).cuboid(-1.5F, -0.5F, -4.5F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -3.7F, -2.3F));

        ModelPartData WingL = crow.addChild("WingL", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -4.4088F, -0.1233F));

        ModelPartData wingL_r1 = WingL.addChild("wingL_r1", ModelPartBuilder.create().uv(11, 13).cuboid(3.5F, -3.0F, -2.0F, 1.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 0.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        ModelPartData wingR = crow.addChild("wingR", ModelPartBuilder.create(), ModelTransform.pivot(-1.5F, -4.4088F, -0.1233F));

        ModelPartData wingR_r1 = wingR.addChild("wingR_r1", ModelPartBuilder.create().uv(0, 11).cuboid(-0.5F, -3.0F, -2.0F, 1.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

        ModelPartData legL = crow.addChild("legL", ModelPartBuilder.create().uv(22, 17).cuboid(-0.5F, -2.0824F, -1.2887F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 22).cuboid(-0.5F, 0.8076F, -0.1887F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -0.9176F, 0.2887F));

        ModelPartData footL1_r1 = legL.addChild("footL1_r1", ModelPartBuilder.create().uv(0, 11).cuboid(0.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 0.9176F, -0.7887F, 0.6981F, 0.0F, 0.0F));

        ModelPartData legR = crow.addChild("legR", ModelPartBuilder.create().uv(22, 6).cuboid(-0.5F, -2.0824F, -1.2887F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(11, 0).cuboid(-0.5F, 0.8076F, -0.1887F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -0.9176F, 0.2887F));

        ModelPartData footL2_r1 = legR.addChild("footL2_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, 0.9176F, -0.7887F, 0.6981F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(CrowEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.animateMovement(ModAnimations.CROWFLYING, limbSwing, limbSwingAmount, 2f, 2f);
        if (entity.getIsFlying()) {
            this.crow.pitch = -0.72332F;
        }

    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        crow.render(matrices, vertexConsumer, light, overlay);
    }

    @Override
    public ModelPart getPart() {
        return crow;
    }


}