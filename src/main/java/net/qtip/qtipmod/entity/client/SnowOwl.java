// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.qtip.qtipmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.qtip.qtipmod.entity.animation.ModAnimations;
import net.qtip.qtipmod.entity.custom.SnowOwlEntity;


public class SnowOwl<T extends SnowOwlEntity> extends SinglePartEntityModel<T> {
    public final ModelPart owl;
    private final ModelPart head;
    private final ModelPart torso;

    public SnowOwl(ModelPart root) {
        this.owl = root.getChild("owl");
        this.head = owl.getChild("head");
        this.torso = owl.getChild("torso");

    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData owl = modelPartData.addChild("owl", ModelPartBuilder.create(), ModelTransform.of(0.0F, 13.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData head = owl.addChild("head", ModelPartBuilder.create().uv(0, 32).cuboid(-4.5F, -1.75F, -4.0F, 9.0F, 8.0F, 9.0F, new Dilation(0.0F))
                .uv(0, 34).cuboid(-1.0F, 1.75F, -6.0F, 2.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -13.25F, -2.0F));

        ModelPartData ear2_r1 = head.addChild("ear2_r1", ModelPartBuilder.create().uv(2, 2).cuboid(1.0F, -1.0F, 4.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
                .uv(2, 2).cuboid(1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -2.75F, -2.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData torso = owl.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -6.5F, -4.5F, 9.0F, 12.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -0.5F, -0.5F, 0.3927F, 0.0F, 0.0F));

        ModelPartData wingr = owl.addChild("wingr", ModelPartBuilder.create().uv(41, 39).cuboid(-0.5F, 0.0F, -2.0F, 2.0F, 15.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -6.0F, -3.0F));

        ModelPartData wingl = owl.addChild("wingl", ModelPartBuilder.create().uv(40, 14).cuboid(-1.5F, 0.0F, -2.0F, 2.0F, 15.0F, 9.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -6.0F, -3.0F));

        ModelPartData tail = owl.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 2.5732F, 5.0924F));

        ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(0, 50).cuboid(-4.5F, -0.5F, -0.5F, 9.0F, 1.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.7861F, 0.1698F, -0.6981F, 0.0F, 0.0F));

        ModelPartData legsandshit = owl.addChild("legsandshit", ModelPartBuilder.create().uv(37, 0).cuboid(-5.0F, -1.35F, -0.5F, 3.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(37, 0).cuboid(1.0F, -1.35F, -0.5F, 3.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(25, 4).cuboid(1.0F, 5.65F, -3.5F, 3.0F, 0.0F, 4.0F, new Dilation(0.0F))
                .uv(25, 4).cuboid(-5.0F, 5.65F, -3.5F, 3.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, 5.25F, -0.5F));
        return TexturedModelData.of(modelData, 64, 64);
    }


    @Override
    public void setAngles(SnowOwlEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.animateMovement(ModAnimations.OWLFLY, limbSwing, limbSwingAmount, 2f, 2.5f);
        if (entity.getIsFlying()) {
            this.owl.pitch = 1.2F;
        }


        if (!entity.getIsFlying() && !entity.getIsMoving()) {
            this.updateAnimation(entity.idleAnimationState, ModAnimations.HEADSPIN, ageInTicks, 1f);
        }

    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        owl.render(matrices, vertexConsumer, light, overlay);
    }

    @Override
    public ModelPart getPart() {
        return owl;
    }
}