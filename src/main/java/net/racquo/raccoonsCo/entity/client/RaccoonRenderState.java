package net.racquo.raccoonsCo.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.racquo.raccoonsCo.entity.custom.RaccoonVariant;

public class RaccoonRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sittingAnimationState = new AnimationState();
    public AnimationState eatingAnimationState = new AnimationState();
    public AnimationState sleepingAnimationState = new AnimationState();

    public RaccoonVariant variant;
}
