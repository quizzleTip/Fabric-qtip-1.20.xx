// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.qtip.qtipmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.qtip.qtipmod.entity.animation.ModAnimations;
import net.qtip.qtipmod.entity.custom.MothEntity;

public class Moth<T extends MothEntity>extends SinglePartEntityModel<T> {
	private final ModelPart moth;

	public Moth(ModelPart root) {
		this.moth = root.getChild("moth");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData moth = modelPartData.addChild("moth", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData body = moth.addChild("body", ModelPartBuilder.create().uv(22, 21).cuboid(0.0F, -7.25F, -0.5F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head_r1 = body.addChild("head_r1", ModelPartBuilder.create().uv(24, 16).cuboid(-1.0F, -0.75F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -6.25F, 0.5F, 0.0F, 0.0F, 0.3491F));

		ModelPartData butt_r1 = body.addChild("butt_r1", ModelPartBuilder.create().uv(14, 25).cuboid(-2.0F, -0.5F, -1.5F, 4.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -6.5F, 0.5F, 0.0F, 0.0F, -0.2618F));

		ModelPartData right = moth.addChild("right", ModelPartBuilder.create().uv(-6, 10).cuboid(-11.0F, 0.125F, -6.0F, 12.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.125F, -0.5F));

		ModelPartData topright_r1 = right.addChild("topright_r1", ModelPartBuilder.create().uv(-8, 1).cuboid(-2.0F, 0.0F, -8.0F, 6.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -0.125F, 0.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData left = moth.addChild("left", ModelPartBuilder.create().uv(-6, 16).cuboid(-10.0F, 0.125F, 0.0F, 12.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -7.125F, 1.5F));

		ModelPartData topleft_r1 = left.addChild("topleft_r1", ModelPartBuilder.create().uv(4, 1).cuboid(-2.0F, 0.0F, 2.0F, 6.0F, 0.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -0.125F, -2.0F, 0.0F, 0.0F, 0.0F));

		ModelPartData legs = moth.addChild("legs", ModelPartBuilder.create().uv(26, 11).cuboid(-4.0F, 1.0F, -1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(26, 11).cuboid(-4.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -6.25F, 0.5F));

		ModelPartData antennas = moth.addChild("antennas", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData antennas_r1 = antennas.addChild("antennas_r1", ModelPartBuilder.create().uv(-5, 24).cuboid(0.0F, 0.25F, -3.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -6.75F, 0.5F, 0.0F, 0.0F, -0.1745F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(MothEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animateMovement(ModAnimations.FLAPPING, limbSwing, limbSwingAmount, 2f, 2f);
	}


	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		moth.render(matrices, vertexConsumer, light, overlay);
	}

	@Override
	public ModelPart getPart() {
		return moth;
	}
}