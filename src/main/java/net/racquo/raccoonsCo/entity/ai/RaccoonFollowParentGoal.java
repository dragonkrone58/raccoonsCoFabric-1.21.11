package net.racquo.raccoonsCo.entity.ai;

import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

public class RaccoonFollowParentGoal extends FollowParentGoal {

    private final RaccoonEntity raccoon;

    public RaccoonFollowParentGoal(RaccoonEntity raccoon, double speed) {
        super(raccoon, speed);
        this.raccoon = raccoon;
    }

    @Override
    public boolean canStart() {
        //Sitting raccoons should never follow
        if (raccoon.isSitting()) {
            return false;
        }

        // Tamed babies should not auto-follow
        if (raccoon.isTamed()) {
            return false;
        }

        return super.canStart();
    }
}
