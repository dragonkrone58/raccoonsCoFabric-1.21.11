package net.racquo.raccoonsCo.entity.client.crawfish;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.racquo.raccoonsCo.entity.custom.CrawfishVariant;

public class CrawfishRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();

    public CrawfishVariant variant;
}
