package net.racquo.raccoonsCo.entity.client.raccoon;

import com.google.common.collect.Maps;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.racquo.raccoonsCo.RaccoonsCo;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;
import net.racquo.raccoonsCo.entity.custom.RaccoonVariant;

import java.util.Map;

public class RaccoonRenderer extends MobEntityRenderer<RaccoonEntity, RaccoonRenderState, RaccoonModel> {

    private static final Map<RaccoonVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(RaccoonVariant.class), map -> {
                map.put(RaccoonVariant.DEFAULT,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/raccoon.png"));
                map.put(RaccoonVariant.GRAY,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/gray_raccoon.png"));
                map.put(RaccoonVariant.BROWN,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/brown_raccoon.png"));
                map.put(RaccoonVariant.CINNAMON,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/cinnamon_raccoon.png"));
                map.put(RaccoonVariant.BLOND,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/blond_raccoon.png"));
                map.put(RaccoonVariant.ALBINO,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/albino_raccoon.png"));
                map.put(RaccoonVariant.SWAMP,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/swamp_raccoon.png"));
                map.put(RaccoonVariant.BLACK,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/raccoon/black_raccoon.png"));

            });

    public RaccoonRenderer(EntityRendererFactory.Context context) {
        super(context, new RaccoonModel(context.getPart(RaccoonModel.RACCOON)), 0.5f);
    }

    @Override
    public Identifier getTexture(RaccoonRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
    }

    @Override
    public void render(RaccoonRenderState state, MatrixStack matrixStack,
                       OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (state.baby) {
            matrixStack.scale(0.7f, 0.7f, 0.7f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(state, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public RaccoonRenderState createRenderState() {
        return new RaccoonRenderState();
    }

    @Override
    public void updateRenderState(RaccoonEntity livingEntity, RaccoonRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.sittingAnimationState.copyFrom(livingEntity.sittingAnimationState);
        livingEntityRenderState.eatingAnimationState.copyFrom(livingEntity.eatingAnimationState);
        livingEntityRenderState.sleepingAnimationState.copyFrom(livingEntity.sleepingAnimationState);
        livingEntityRenderState.begAnimationState.copyFrom(livingEntity.begAnimationState);
        livingEntityRenderState.grabAnimationState.copyFrom(livingEntity.grabAnimationState);
        livingEntityRenderState.washAnimationState.copyFrom(livingEntity.washAnimationState);


        livingEntityRenderState.variant = livingEntity.getVariant();
    }
}
