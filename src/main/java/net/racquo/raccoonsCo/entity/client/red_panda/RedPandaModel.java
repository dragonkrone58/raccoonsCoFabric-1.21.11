package net.racquo.raccoonsCo.entity.client.red_panda;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;

import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.RaccoonsCo;


public class RedPandaModel extends EntityModel<RedPandaRenderState> {
    public static final EntityModelLayer RED_PANDA = new EntityModelLayer(Identifier.of(RaccoonsCo.MOD_ID, "red_panda"), "main");

    private final ModelPart root;
    private final ModelPart red_panda;

    private final Animation idlingAnimation;
    private final Animation walkingAnimation;


    public RedPandaModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
        this.red_panda = this.root.getChild("red_panda");
        this.idlingAnimation = RedPandaAnimations.ANIM_REDPANDA_IDLE.createAnimation(root);
        this.walkingAnimation = RedPandaAnimations.ANIM_REDPANDA_WALK.createAnimation(root);

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 26.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData red_panda = root.addChild("red_panda", ModelPartBuilder.create(), ModelTransform.of(1.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData frontLegR = red_panda.addChild("frontLegR", ModelPartBuilder.create().uv(34, 22).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.0F, -2.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData frontLegL = red_panda.addChild("frontLegL", ModelPartBuilder.create().uv(34, 16).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData backLegR = red_panda.addChild("backLegR", ModelPartBuilder.create().uv(24, 30).cuboid(-3.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 2.0F, -2.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData backLegL = red_panda.addChild("backLegL", ModelPartBuilder.create().uv(32, 30).cuboid(-3.0F, 0.0F, 0.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData head = red_panda.addChild("head", ModelPartBuilder.create().uv(0, 24).cuboid(0.0F, -2.5F, -4.0F, 4.0F, 6.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(24, 24).cuboid(0.0F, -1.0F, -2.0F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData earR = head.addChild("earR", ModelPartBuilder.create(), ModelTransform.of(2.0F, -2.0F, -3.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = earR.addChild("cube_r1", ModelPartBuilder.create().uv(32, 36).cuboid(0.0F, -2.0F, -1.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        ModelPartData earL = head.addChild("earL", ModelPartBuilder.create(), ModelTransform.of(2.0F, -2.0F, 3.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData cube_r2 = earL.addChild("cube_r2", ModelPartBuilder.create().uv(24, 36).cuboid(0.0F, -2.0F, -1.5F, 1.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData body = red_panda.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -4.0F, -4.5F, 14.0F, 7.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 16).cuboid(-15.0F, -2.0F, -2.0F, 13.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }
    @Override
    public void setAngles(RedPandaRenderState state) {
        super.setAngles(state);

        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
    }

}
