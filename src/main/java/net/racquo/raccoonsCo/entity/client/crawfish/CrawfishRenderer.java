package net.racquo.raccoonsCo.entity.client.crawfish;

import com.google.common.collect.Maps;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.racquo.raccoonsCo.RaccoonsCo;
import net.racquo.raccoonsCo.entity.custom.CrawfishEntity;
import net.racquo.raccoonsCo.entity.custom.CrawfishVariant;

import java.util.Map;

public class CrawfishRenderer extends MobEntityRenderer<CrawfishEntity, CrawfishRenderState, CrawfishModel> {

    private static final Map<CrawfishVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CrawfishVariant.class), map -> {
                map.put(CrawfishVariant.DEFAULT,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/crawfish/crawfish_brown.png"));
                map.put(CrawfishVariant.BLUE,
                        Identifier.of(RaccoonsCo.MOD_ID, "textures/entity/crawfish/crawfish_blue.png"));
            });

    public CrawfishRenderer(EntityRendererFactory.Context context) {
        super(context, new CrawfishModel(context.getPart(CrawfishModel.CRAWFISH)), 0.1f);
    }

    @Override
    public void render(CrawfishRenderState state, MatrixStack matrixStack,
                       OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (state.baby) {
            matrixStack.scale(0.7f, 0.7f, 0.7f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(state, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public Identifier getTexture(CrawfishRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
    }


    @Override
    public CrawfishRenderState createRenderState() {
        return new CrawfishRenderState();
    }

    @Override
    public void updateRenderState(CrawfishEntity livingEntity, CrawfishRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);


        livingEntityRenderState.variant = livingEntity.getVariant();
    }
}
