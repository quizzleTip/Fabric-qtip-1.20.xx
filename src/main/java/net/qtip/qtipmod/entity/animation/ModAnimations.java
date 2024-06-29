package net.qtip.qtipmod.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ModAnimations {
    public static final Animation SIT = Animation.Builder.create(0.5f)
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 4f, 3f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-45f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation SCHWALK = Animation.Builder.create(1f).looping()
            .addBoneAnimation("frontlegs",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("backlegs",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation CROWWALK = Animation.Builder.create(1f).looping()
            .addBoneAnimation("crow",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(0f, 10f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(0f, -10f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legL",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createTranslationalVector(0f, 0f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legL",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.75f, AnimationHelper.createRotationalVector(22.5f, 10f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0.02f, -2.5f, 0.11f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legR",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, 1f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legR",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(20f, -10f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-0.04f, -0.01f, 0.43f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation CROWFLYING = Animation.Builder.create(2f).looping()
            .addBoneAnimation("crow",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 2f, 2f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("crow",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-40f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(40f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("butt",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, -1f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("butt",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(40f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("WingL",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(2f, 2f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("WingL",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(40.48f, 41.7f, -88.71f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(67.4f, 37.17f, -52.67f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(40.48f, 41.7f, -88.71f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingR",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(-2f, 2f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingR",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(41.93f, -40.01f, 87.9f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(67.3f, -35.15f, 52.88f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(41.15f, -41.68f, 87.89f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legL",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legL",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legR",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("legR",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-30f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation HEADSPIN = Animation.Builder.create(15f).looping()
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, -180f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(2f, AnimationHelper.createRotationalVector(0f, -180f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(3f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingr",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.4f, -2.4f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingr",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingl",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.4f, -2.4f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingl",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(22.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation OWLFLY = Animation.Builder.create(2f).looping()
            .addBoneAnimation("owl",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(67.5f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -0.92f, 0.38f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-70f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("tail",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingr",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(2f, 1f, 4f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingr",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 67.5f, 90f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-64.44f, 27.51f, 12.46f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 67.5f, 90f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingl",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(-2f, 1f, 4f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("wingl",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, -67.5f, -90f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-64.44f, -27.51f, -12.46f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, -67.5f, -90f),
                                    Transformation.Interpolations.LINEAR))).build();
    public static final Animation FLAPPING = Animation.Builder.create(0.5f).looping()
            .addBoneAnimation("right",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(-50f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(50f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-50f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("left",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(50f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createRotationalVector(-50f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createRotationalVector(50f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("moth",
                    new Transformation(Transformation.Targets.TRANSLATE,
                            new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 1f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, -1f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
}
