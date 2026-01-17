package net.racquo.raccoonsCo.entity.client.crawfish;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.RaccoonsCo;


public class CrawfishModel extends EntityModel<CrawfishRenderState> {
    public static final EntityModelLayer CRAWFISH = new EntityModelLayer(Identifier.of(RaccoonsCo.MOD_ID, "crawfish"), "main");

    private final ModelPart root;
    private final ModelPart crawfish;

    private final Animation idlingAnimation;

    public CrawfishModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
        this.crawfish = this.root.getChild("crawfish");
        this.idlingAnimation = CrawfishAnimations.ANIM_CRAWFISH_IDLE.createAnimation(root);

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData crawfish = root.addChild("crawfish", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData antennaR = crawfish.addChild("antennaR", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -1.5F, -4.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.5F, -4.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData antennaL = crawfish.addChild("antennaL", ModelPartBuilder.create().uv(16, 0).cuboid(0.0F, -1.5F, -4.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.5F, -4.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData body = crawfish.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.5F, -2.5F, -4.0F, 3.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData tergum = body.addChild("tergum", ModelPartBuilder.create().uv(14, 13).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 1.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData tail = tergum.addChild("tail", ModelPartBuilder.create().uv(0, 13).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F));

        ModelPartData clawR = crawfish.addChild("clawR", ModelPartBuilder.create().uv(12, 7).cuboid(-3.0F, -0.5F, -3.5F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(8, 16).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.5F, -1.5F, 0.0F, 0.0F, 0.0F));

        ModelPartData clawL = crawfish.addChild("clawL", ModelPartBuilder.create().uv(0, 7).cuboid(1.0F, -0.5F, -3.5F, 2.0F, 2.0F, 4.0F, new Dilation(0.0F))
                .uv(16, 6).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.5F, -1.5F, 0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(CrawfishRenderState state) {
        super.setAngles(state);

        this.idlingAnimation.apply(state.idleAnimationState, state.age, 1f);
    }

}