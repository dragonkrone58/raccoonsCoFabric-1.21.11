package net.racquo.raccoonsCo.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.racquo.raccoonsCo.RaccoonsCo;

public class RaccoonModel extends EntityModel<RaccoonRenderState> {
    public static final EntityModelLayer RACCOON = new EntityModelLayer(Identifier.of(RaccoonsCo.MOD_ID, "raccoon"), "main");
    private final ModelPart root;
    private final ModelPart raccoon;
    private final ModelPart head;

    private final Animation walkingAnimation;
    private final Animation idlingAnimation;
    private final Animation sittingAnimation;


    public RaccoonModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
        this.raccoon = this.root.getChild("raccoon");
        this.head = this.raccoon.getChild("head");
        this.walkingAnimation = RaccoonAnimations.ANIM_RACCOON_WALK.createAnimation(root);
        this.idlingAnimation = RaccoonAnimations.ANIM_RACCOON_IDLE.createAnimation(root);
        this.sittingAnimation = RaccoonAnimations.ANIM_RACCOON_SIT.createAnimation(root);
    }
    /*
    Note: Issue with Blockbench java exported file: turn .pivot -> .of and add 'default' rotation in radians?

     */

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0F, 0F, 0F));

        ModelPartData raccoon = root.addChild("raccoon", ModelPartBuilder.create(), ModelTransform.of(0.0F, -8.0F, 0.0F, 0F, 0f, 0F));

        ModelPartData frontLegL = raccoon.addChild("frontLegL", ModelPartBuilder.create().uv(0, 36).cuboid(-0.5F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 2.0F, -4.0F, 0F, 0F, 0F));

        ModelPartData frontLegR = raccoon.addChild("frontLegR", ModelPartBuilder.create().uv(8, 36).cuboid(-1.5F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 2.0F, -4.0F,  0F, 0F, 0F));

        ModelPartData backLegL = raccoon.addChild("backLegL", ModelPartBuilder.create().uv(16, 36).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 2.0F, 6.0F,  0F, 0F, 0F));

        ModelPartData backLegR = raccoon.addChild("backLegR", ModelPartBuilder.create().uv(24, 36).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 2.0F, 6.0F,  0F, 0F, 0F));

        ModelPartData tail = raccoon.addChild("tail", ModelPartBuilder.create().uv(0, 20).cuboid(-1.7F, -2.0F, 0.5F, 4.0F, 4.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-0.7962F, -0.3656F, 6.83F,  0F, 0F, 0F));

        ModelPartData body = raccoon.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-5.5F, -5.5F, -2.0F, 10.0F, 8.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, -2.0F,  0F, 0F, 0F));

        ModelPartData neck = body.addChild("neck", ModelPartBuilder.create().uv(32, 31).cuboid(-4.5F, -4.0F, -3.0F, 9.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -1.0F, -2.0F,  0F, 0F, 0F));

        ModelPartData head = raccoon.addChild("head", ModelPartBuilder.create().uv(32, 20).cuboid(-4.0F, -2.5F, -3.0F, 8.0F, 6.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -1.0F, -8.0F, 0F, 0F, 0F));

        ModelPartData earL = head.addChild("earL", ModelPartBuilder.create().uv(0, 44).cuboid(-1.5F, -1.5F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.5F, -3.0F, -1.0F,  0F, 0F, 0F));

        ModelPartData earR = head.addChild("earR", ModelPartBuilder.create().uv(44, 0).cuboid(-0.5F, -1.5F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(2.5F, -3.0F, -1.0F,  0F, 0F, 0F));

        ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(32, 42).cuboid(-2.0F, -0.5F, -1.5F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, -3.5F,  0F, 0F, 0F));

        ModelPartData eyelids = head.addChild("eyelids", ModelPartBuilder.create().uv(4, 4).cuboid(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(4, 4).cuboid(-4.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 1.0F, -2.0F,  0F, 0F, 0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(RaccoonRenderState state) {
        super.setAngles(state);
        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
        this.sittingAnimation.apply(state.sittingAnimationState, state.age, 1f);

    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

}
