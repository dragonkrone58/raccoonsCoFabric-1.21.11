package net.racquo.raccoonsCo.entity.ai.raccoon;

import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.recipe.Ingredient;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

public class RaccoonTemptGoal extends TemptGoal {

    private final RaccoonEntity raccoon;
    private static final double BEG_DISTANCE = 2.5D;

    public RaccoonTemptGoal(RaccoonEntity raccoon, double speed, Ingredient ingredient){
        super(raccoon, speed, ingredient, false);
        this.raccoon = raccoon;
    }

    @Override
    public boolean canStart() {
        return !raccoon.isEating() && !raccoon.isFull()
                && !raccoon.isSleeping() &&!raccoon.isGrabbing()
                && !raccoon.isWashing()&& super.canStart();
    }

    @Override
    public boolean shouldContinue() {
        return !raccoon.isEating() && !raccoon.isFull() && !raccoon.isSleeping() && super.shouldContinue();
    }

    @Override
    public void tick() {
        super.tick();

        if (this.closestPlayer == null) {
            raccoon.setBegging(false);
            return;
        }

        if (raccoon.isEating() || raccoon.isFull() || raccoon.isSleeping()) {
            raccoon.setBegging(false);
            this.stop();
            return;
        }

        double distanceSq = raccoon.squaredDistanceTo(this.closestPlayer);

        if (distanceSq <= BEG_DISTANCE * BEG_DISTANCE) {
            raccoon.getNavigation().stop();
            raccoon.setBegging(true);
            raccoon.getLookControl().lookAt(this.closestPlayer, 30.0F, 30.0F);
        } else {
            raccoon.setBegging(false);
        }
    }

    @Override
    public void stop() {
        super.stop();
        raccoon.setBegging(false);
    }
}
