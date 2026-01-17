package net.racquo.raccoonsCo.entity.client;

import net.minecraft.client.render.entity.animation.*;

public class RaccoonAnimations  {

    public static final AnimationDefinition ANIM_RACCOON_WALK = AnimationDefinition.Builder.create(1.0F).looping()
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.7917F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0462F, -4.8812F, -1.0848F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0462F, -4.8812F, -1.0848F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.0462F, -4.8812F, -1.0848F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createRotationalVector(5.0462F, -4.8812F, -1.0848F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.0462F, -4.8812F, -1.0848F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-33.7424F, 14.6914F, -9.6152F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(-33.7424F, -14.6914F, 9.6152F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createRotationalVector(-32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(-33.7424F, 14.6914F, -9.6152F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.33F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -5.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-1.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -2.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();

    public static final AnimationDefinition ANIM_RACCOON_IDLE = AnimationDefinition.Builder.create(12.0F).looping()
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7083F, AnimationHelper.createRotationalVector(4.8863F, -0.2152F, 2.4883F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createRotationalVector(5.1476F, -3.0992F, -2.7823F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0417F, AnimationHelper.createRotationalVector(5.0127F, 4.1509F, 0.3664F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.2083F, AnimationHelper.createRotationalVector(5.0079F, -3.3205F, -0.2882F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4583F, AnimationHelper.createRotationalVector(5.0127F, 4.1509F, 0.3664F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5833F, AnimationHelper.createRotationalVector(5.0079F, -3.3205F, -0.2882F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.75F, AnimationHelper.createRotationalVector(5.0016F, 1.6605F, 0.1479F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.2083F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(6.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(9.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(10.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(12.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.2083F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(9.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(10.5F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(12.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-12.5F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(-12.5F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.625F, AnimationHelper.createRotationalVector(-12.5F, -2.78F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.875F, AnimationHelper.createRotationalVector(-12.4988F, 2.3795F, -1.0818F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(-12.5937F, -6.6611F, 1.0226F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.2083F, AnimationHelper.createRotationalVector(-12.7845F, 5.3002F, -1.5411F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(-12.5774F, -6.4629F, 1.1921F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5F, AnimationHelper.createRotationalVector(-12.5347F, 2.3481F, -0.5085F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.625F, AnimationHelper.createRotationalVector(-12.6367F, -6.4689F, 1.5179F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.8333F, AnimationHelper.createRotationalVector(-12.5276F, 1.7947F, -0.2588F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-12.5221F, -0.6458F, 0.2834F), Transformation.Interpolations.CUBIC),
                    new Keyframe(6.0F, AnimationHelper.createRotationalVector(-12.5F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.5F, AnimationHelper.createRotationalVector(-12.5F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(9.0F, AnimationHelper.createRotationalVector(-12.5F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(10.5F, AnimationHelper.createRotationalVector(-12.5F, -7.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(12.0F, AnimationHelper.createRotationalVector(-12.5F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.8333F, AnimationHelper.createRotationalVector(-2.5095F, 4.9952F, -2.7187F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(2.4925F, -2.2798F, -7.604F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 5.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(6.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(9.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(12.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.8333F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.125F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4583F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.3333F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(6.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.5F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(9.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(10.5F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(12.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.25F, AnimationHelper.createRotationalVector(22.1916F, -3.8102F, 9.2525F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(-4.9244F, 0.8672F, 9.9627F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(5.0417F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(5.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.7917F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.2083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.3333F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.7083F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(22.2895F, 2.5536F, -7.0559F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0417F, AnimationHelper.createRotationalVector(19.7197F, 3.4049F, -9.408F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.2083F, AnimationHelper.createRotationalVector(-14.7822F, -2.5759F, -9.6658F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(5.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(5.25F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(5.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5F, AnimationHelper.createRotationalVector(-4.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.625F, AnimationHelper.createRotationalVector(-4.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7917F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(-4.37F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0833F, AnimationHelper.createRotationalVector(1.21F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.25F, AnimationHelper.createRotationalVector(-4.16F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(2.69F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5833F, AnimationHelper.createRotationalVector(-5.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.75F, AnimationHelper.createRotationalVector(-4.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(7.9167F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.0417F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(8.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(9.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(9.9583F, AnimationHelper.createRotationalVector(-4.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(10.0417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(10.0833F, AnimationHelper.createRotationalVector(-4.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(10.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();
    public static final AnimationDefinition ANIM_RACCOON_SIT = AnimationDefinition.Builder.create(4.0F).looping()
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(-45.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.6144F, 9.9136F, -1.3184F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(-7.7021F, -12.3906F, 1.6607F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.6144F, 9.9136F, -1.3184F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(-7.7021F, -12.3906F, 1.6607F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-7.6144F, 9.9136F, -1.3184F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, -2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, -5.0F, -2.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 2.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 2.5F, 2.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.625F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("eyelids", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("eyelids", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();

    // Save this class in your mod and generate all required imports


    public static final AnimationDefinition ANIM_RACCOON_EATING = AnimationDefinition.Builder.create(3.5F)
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-77.0736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-84.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-74.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-84.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-74.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-84.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-74.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-84.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-74.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(-84.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-74.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-77.0736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-77.0736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(0.0F, -0.12F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-77.0736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-84.157F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-74.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-84.157F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.2917F, AnimationHelper.createRotationalVector(-74.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-84.157F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5417F, AnimationHelper.createRotationalVector(-74.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-84.157F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7917F, AnimationHelper.createRotationalVector(-74.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(-84.157F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0417F, AnimationHelper.createRotationalVector(-74.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-77.0736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createRotationalVector(-77.0736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2917F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(0.0F, -0.12F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.875F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.125F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.375F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5417F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.8333F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.375F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.375F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(2.7917F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createScalingVector(1.0F, 1.1F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0417F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-12.8248F, 14.8181F, -1.6746F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0417F, AnimationHelper.createRotationalVector(-12.8039F, -10.0F, 4.9071F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.3333F, AnimationHelper.createRotationalVector(-12.9853F, 10.0F, -2.2555F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-12.8039F, -10.0F, 4.9071F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(-12.9853F, 10.0F, -2.2555F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.375F, AnimationHelper.createRotationalVector(-12.8039F, -10.0F, 4.9071F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5417F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.0833F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.875F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.125F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.375F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7917F, AnimationHelper.createRotationalVector(40.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.89F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -2.89F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.8333F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.3333F, AnimationHelper.createRotationalVector(20.89F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5833F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.8333F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0833F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.3333F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7917F, AnimationHelper.createRotationalVector(20.7F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.3333F, AnimationHelper.createRotationalVector(20.89F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5833F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.8333F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9583F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0833F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(-4.91F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.3333F, AnimationHelper.createRotationalVector(7.98F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.7917F, AnimationHelper.createRotationalVector(20.7F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.875F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(2.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.0833F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9583F, AnimationHelper.createRotationalVector(-7.4366F, -0.9762F, -7.4366F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.2083F, AnimationHelper.createRotationalVector(-7.4366F, -0.9762F, -7.4366F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-7.4366F, -0.9762F, -7.4366F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.7083F, AnimationHelper.createRotationalVector(-7.4366F, -0.9762F, -7.4366F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.4366F, -0.9762F, -7.4366F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.2083F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4583F, AnimationHelper.createRotationalVector(-8.75F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.875F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();


    public static final AnimationDefinition ANIM_RACCOON_SLEEPING = AnimationDefinition.Builder.create(4.0F).looping()
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-92.6602F, -19.9802F, 0.9096F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(-92.6602F, -19.9802F, 0.9096F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-92.6602F, -19.9802F, 0.9096F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(4.0F, -5.0F, 5.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(4.0F, -5.0F, 5.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(4.0F, -5.0F, 5.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-76.1015F, -32.2109F, -3.6223F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(-76.1015F, -32.2109F, -3.6223F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-76.1015F, -32.2109F, -3.6223F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.0F, -4.0F, 3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(1.0F, -4.0F, 3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(1.0F, -4.0F, 3.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-2.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(-2.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(-2.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-7.5F, -40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(-7.5F, -40.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-7.5F, -40.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(3.0F, -4.74F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(3.0F, -4.54F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(3.0F, -4.74F, 2.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createScalingVector(1.0F, 1.1F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-173.4451F, -52.0953F, 168.4835F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(-178.4451F, -52.0953F, 168.4835F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-173.4451F, -52.0953F, 168.4835F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, -6.0F, 3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, -7.0F, 3.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(30.1683F, 18.6615F, 13.9753F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(30.1683F, 18.6615F, 13.9753F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(30.1683F, 18.6615F, 13.9753F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(5.0F, -5.0F, 4.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(5.0F, -4.5F, 4.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(5.0F, -5.0F, 4.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-58.487F, -34.2235F, 67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0417F, AnimationHelper.createRotationalVector(-58.487F, -34.2235F, 67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.125F, AnimationHelper.createRotationalVector(-48.487F, -34.2235F, 67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.2083F, AnimationHelper.createRotationalVector(-58.487F, -34.2235F, 67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-58.487F, -34.2235F, 67.3333F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-62.4307F, 34.2235F, -67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createRotationalVector(-62.4307F, 34.2235F, -67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.25F, AnimationHelper.createRotationalVector(-52.4307F, 34.2235F, -67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.375F, AnimationHelper.createRotationalVector(-62.4307F, 34.2235F, -67.3333F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-62.4307F, 34.2235F, -67.3333F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 32.5F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(1.0F, 0.0F, 3.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.25F, AnimationHelper.createRotationalVector(-4.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-4.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.25F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createRotationalVector(-5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("eyelids", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createRotationalVector(-10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("eyelids", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, -1.2F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, -1.2F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.0F, AnimationHelper.createTranslationalVector(0.0F, -0.3F, -1.2F), Transformation.Interpolations.CUBIC)
            ))
            .build();

    public static final AnimationDefinition ANIM_RACCOON_BEG = AnimationDefinition.Builder.create(0.6667F).looping()
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-99.5684F, 26.128F, -8.8967F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-124.5684F, 26.128F, -8.8967F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-99.5684F, 26.128F, -8.8967F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.0F, 5.0F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(1.0F, 5.0F, 2.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-100.0053F, -28.4804F, 9.8491F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-125.0053F, -28.4804F, 9.8491F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-100.0053F, -28.4804F, 9.8491F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.0F, 5.0F, 2.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, -3.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-57.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 5.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-33.4066F, 12.6084F, -8.1925F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-33.4066F, -12.6084F, 8.1925F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-33.4066F, 12.6084F, -8.1925F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, -2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, -2.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-19.9299F, -1.7082F, -4.6999F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-19.9299F, 1.7082F, 4.6999F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-19.9299F, -1.7082F, -4.6999F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 8.5F, 5.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 7.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -7.5F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();

    public static final AnimationDefinition ANIM_RACCOON_GRAB = AnimationDefinition.Builder.create(1.75F)
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-39.57F, 14.64F, 3.32F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-77.0736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-77.0736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-77.0736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, -4.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(-39.57F, -14.64F, -3.32F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2083F, AnimationHelper.createRotationalVector(-77.0736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-77.0736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-77.0736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, -4.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 1.2F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 1.2F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -1.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.375F, AnimationHelper.createRotationalVector(-5.2806F, 7.2989F, -1.2966F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.7917F, AnimationHelper.createRotationalVector(-12.5698F, -9.5891F, 3.7847F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-12.8248F, 14.8181F, -1.6746F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(-12.5F, 7.5F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2083F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.7917F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.875F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9583F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0417F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.125F, AnimationHelper.createRotationalVector(32.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2083F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, -2.89F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, -3.2F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2917F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2917F, AnimationHelper.createRotationalVector(22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(1.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(1.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4583F, AnimationHelper.createRotationalVector(-7.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5417F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();



    public static final AnimationDefinition ANIM_RACCOON_WASH = AnimationDefinition.Builder.create(5.0F)
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-64.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-67.0736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-64.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(-64.5736F, 14.6364F, 3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.25F, AnimationHelper.createRotationalVector(-36.9F, 8.36F, 1.9F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createRotationalVector(-72.1913F, -9.363F, -3.6577F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createRotationalVector(-122.7696F, -30.3467F, 2.7865F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createRotationalVector(-62.2056F, 5.7586F, 6.0636F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.625F, AnimationHelper.createRotationalVector(-31.0094F, 2.8617F, 0.3965F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.25F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.57F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createTranslationalVector(1.0F, 5.85F, -2.71F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createTranslationalVector(1.0F, 5.85F, -2.71F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-64.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.2917F, AnimationHelper.createRotationalVector(-67.0736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-64.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(-64.5736F, -14.6364F, -3.3191F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.25F, AnimationHelper.createRotationalVector(-36.9F, -8.36F, -1.9F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createRotationalVector(-72.1913F, 9.363F, 3.6577F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createRotationalVector(-124.405F, 35.9567F, -4.9091F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createRotationalVector(-63.2072F, -3.0211F, -6.8345F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.625F, AnimationHelper.createRotationalVector(-31.0094F, -2.8617F, -0.3965F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("frontLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -4.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, 2.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createTranslationalVector(0.0F, -3.5F, -1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.25F, AnimationHelper.createTranslationalVector(0.0F, 0.71F, 0.57F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createTranslationalVector(-1.0F, 5.85F, -2.71F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createTranslationalVector(-1.0F, 5.85F, -2.71F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegL", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createTranslationalVector(-1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createTranslationalVector(0.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("backLegR", new Transformation(Transformation.Targets.SCALE,
                    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(24.2477F, 6.2797F, -6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(24.2477F, -6.2797F, 6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(24.2477F, 6.2797F, -6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createRotationalVector(24.2477F, -6.2797F, 6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(24.2477F, 6.2797F, -6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(24.2477F, -6.2797F, 6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createRotationalVector(24.2477F, 6.2797F, -6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createRotationalVector(24.2477F, -6.2797F, 6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createRotationalVector(24.2477F, 6.2797F, -6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createRotationalVector(24.2477F, -6.2797F, 6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createRotationalVector(24.2477F, 6.2797F, -6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createRotationalVector(24.2477F, -6.2797F, 6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createRotationalVector(24.2477F, 6.2797F, -6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createRotationalVector(24.2477F, -6.2797F, 6.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(22.11F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createRotationalVector(-17.88F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createRotationalVector(-17.88F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createRotationalVector(5.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createTranslationalVector(0.0F, 4.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createRotationalVector(-22.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createRotationalVector(-23.2109F, 13.8345F, -5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createRotationalVector(-23.2109F, -13.8345F, 5.8546F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.2917F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createRotationalVector(15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createRotationalVector(-2.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("tail", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5833F, AnimationHelper.createTranslationalVector(0.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-2.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(3.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(-2.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(3.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(-2.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(3.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(-2.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(3.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(-2.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createTranslationalVector(3.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createTranslationalVector(-2.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createTranslationalVector(3.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createTranslationalVector(-2.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createTranslationalVector(3.0F, 3.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.2917F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createTranslationalVector(0.0F, 2.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(37.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createRotationalVector(37.0772F, 6.0681F, -7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createRotationalVector(37.0772F, -6.0681F, 7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(37.0772F, 6.0681F, -7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createRotationalVector(37.0772F, -6.0681F, 7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createRotationalVector(37.0772F, 6.0681F, -7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createRotationalVector(37.0772F, -6.0681F, 7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createRotationalVector(37.0772F, 6.0681F, -7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createRotationalVector(37.0772F, -6.0681F, 7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createRotationalVector(37.0772F, 6.0681F, -7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createRotationalVector(37.0772F, -6.0681F, 7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createRotationalVector(37.0772F, 6.0681F, -7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createRotationalVector(37.0772F, -6.0681F, 7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createRotationalVector(37.0772F, 6.0681F, -7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createRotationalVector(37.0772F, -6.0681F, 7.9634F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(31.78F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createRotationalVector(-21.9057F, 1.7314F, -2.2743F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createRotationalVector(-21.9057F, 1.7314F, -2.2743F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createRotationalVector(-9.4057F, 1.7314F, -2.2743F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.625F, AnimationHelper.createRotationalVector(5.2971F, 0.8657F, -1.1371F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4167F, AnimationHelper.createTranslationalVector(0.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.5417F, AnimationHelper.createTranslationalVector(0.0F, -2.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.6667F, AnimationHelper.createTranslationalVector(-1.0F, -2.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.9167F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.1667F, AnimationHelper.createTranslationalVector(-1.0F, -2.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.4167F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.6667F, AnimationHelper.createTranslationalVector(-1.0F, -2.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.9167F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.1667F, AnimationHelper.createTranslationalVector(-1.0F, -2.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.4167F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.6667F, AnimationHelper.createTranslationalVector(-1.0F, -2.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.9167F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.1667F, AnimationHelper.createTranslationalVector(-1.0F, -2.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.4167F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.6667F, AnimationHelper.createTranslationalVector(-1.0F, -2.5F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.9167F, AnimationHelper.createTranslationalVector(1.0F, -3.0F, 1.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createTranslationalVector(0.0F, -2.29F, 0.86F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createTranslationalVector(-0.41F, 6.39F, 0.41F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createTranslationalVector(-0.41F, 6.39F, 0.41F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.125F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.6667F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.125F, AnimationHelper.createRotationalVector(-30.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(1.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(2.8333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.0833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.3333F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.5833F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(3.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createRotationalVector(-25.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.6667F, AnimationHelper.createRotationalVector(17.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("earL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.125F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.6667F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-20.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(4.3333F, AnimationHelper.createRotationalVector(-2.89F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(4.4167F, AnimationHelper.createRotationalVector(-17.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(4.7083F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("neck", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, -1.0F, 1.0F), Transformation.Interpolations.LINEAR),
                    new Keyframe(4.3333F, AnimationHelper.createTranslationalVector(0.0F, -0.14F, 0.14F), Transformation.Interpolations.LINEAR),
                    new Keyframe(4.4167F, AnimationHelper.createTranslationalVector(0.0F, -0.1F, 0.1F), Transformation.Interpolations.LINEAR),
                    new Keyframe(4.7083F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.ROTATE,
                    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.25F, AnimationHelper.createRotationalVector(-19.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(0.4583F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.5417F, AnimationHelper.createRotationalVector(-15.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.6667F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .addBoneAnimation("nose", new Transformation(Transformation.Targets.MOVE_ORIGIN,
                    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.375F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
                    new Keyframe(4.875F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
            ))
            .build();



}
