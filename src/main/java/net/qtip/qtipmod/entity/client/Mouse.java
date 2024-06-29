// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.qtip.qtipmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.qtip.qtipmod.entity.animation.ModAnimations;
import net.qtip.qtipmod.entity.custom.MouseEntity;

public class Mouse<T extends MouseEntity> extends SinglePartEntityModel<T> {
	private final ModelPart mouse;
	private final ModelPart head;
	private final ModelPart body;

	public Mouse(ModelPart root) {

		this.mouse = root.getChild("mouse");
		this.head = mouse.getChild("head");
		this.body = mouse.getChild("body");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData mouse = modelPartData.addChild("mouse", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = mouse.addChild("head", ModelPartBuilder.create().uv(18, 0).cuboid(-1.0F, -3.0F, -9.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(11, 12).cuboid(-1.5F, -4.0F, -7.0F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData ear1_r1 = head.addChild("ear1_r1", ModelPartBuilder.create().uv(0, 12).cuboid(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, -4.5F, -4.5F, 0.0F, 0.5236F, 0.0F));

		ModelPartData ear2_r1 = head.addChild("ear2_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, -4.5F, -4.5F, 0.0F, -0.5236F, 0.0F));

		ModelPartData body = mouse.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -4.0F, -5.5F, 5.0F, 4.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -1.0F, 1.5F));

		ModelPartData frontlegs = body.addChild("frontlegs", ModelPartBuilder.create().uv(3, 22).cuboid(-2.0F, -2.0F, -3.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 22).cuboid(2.0F, -2.0F, -3.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(-0.5F, 1.0F, -1.5F));

		ModelPartData backlegs = mouse.addChild("backlegs", ModelPartBuilder.create().uv(19, 19).cuboid(2.0F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(11, 12).cuboid(-2.0F, -2.0F, 2.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 16).cuboid(-2.0F, 0.0F, 0.0F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 4).cuboid(2.0F, 0.0F, 0.0F, 1.0F, 0.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData extermidies = mouse.addChild("extermidies", ModelPartBuilder.create().uv(0, 12).cuboid(0.0F, -2.0F, 3.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(MouseEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateMovement(ModAnimations.SCHWALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		//this.updateAnimation(entity.idleAnimationState, ModAnimations.SIT,ageInTicks, 1f);
	}

	//private void setHeadAngles(float headYaw, float headPitch)

	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		mouse.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return mouse;
	}
}