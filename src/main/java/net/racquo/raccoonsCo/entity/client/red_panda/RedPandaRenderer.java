package net.racquo.raccoonsCo.entity.client.red_panda;

import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import net.racquo.raccoonsCo.entity.custom.RedPandaEntity;


public class RedPandaRenderer extends MobEntityRenderer<RedPandaEntity, RedPandaRenderState, RedPandaModel> {

    public RedPandaRenderer(EntityRendererFactory.Context context) {
        super(context, new RedPandaModel (context.getPart(RedPandaModel.RED_PANDA)), 0.5f);
    }

    @Override
    public void render(RedPandaRenderState state, MatrixStack matrixStack,
                       OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (state.baby) {
            matrixStack.scale(0.7f, 0.7f, 0.7f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(state, matrixStack, orderedRenderCommandQueue, cameraRenderState);
    }

    @Override
    public RedPandaRenderState createRenderState() {
        return new RedPandaRenderState();
    }


    @Override
    public Identifier getTexture(RedPandaRenderState state) {
        return  Identifier.of("raccoonsco", "textures/entity/red_panda/red_panda.png");
    }

    @Override
    public void updateRenderState(RedPandaEntity livingEntity, RedPandaRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
    }

}
