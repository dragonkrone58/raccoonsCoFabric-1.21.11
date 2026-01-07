package net.racquo.raccoonsCo.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

import java.util.EnumSet;

public class RaccoonSleepGoal extends Goal {


    private final RaccoonEntity raccoon;
    private BlockPos sleepPos;

    public RaccoonSleepGoal(RaccoonEntity raccoon) {
        this.raccoon = raccoon;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if(!raccoon.isFull()) return false;
        if(raccoon.isSleeping()) return false;

        if(raccoon.isTamed() && !raccoon.isInSittingPose()) return false;

        sleepPos = findSleepSpot();
        return sleepPos != null;
    }

    @Override
    public void start() {
        raccoon.getNavigation().startMovingTo(
                sleepPos.getX() + 0.5,
                sleepPos.getY(),
                sleepPos.getZ() + 0.5,
                1.0D
        );
    }

    @Override
    public boolean shouldContinue() {
        return !raccoon.isSleeping();
    }

    @Override
    public void tick() {
        if (sleepPos == null) return;

        if (raccoon.getBlockPos().isWithinDistance(sleepPos, 1.2)) {
            raccoon.startSleeping();
        }
    }

    private BlockPos findSleepSpot() {
        World world = raccoon.getEntityWorld();
        BlockPos origin = raccoon.getBlockPos();

        for (BlockPos pos : BlockPos.iterateOutwards(origin, 8, 4, 8)) {
            if (world.isSkyVisible(pos)) continue;
            if(world.getLightLevel(pos) > 11) continue;
            if(!world.getBlockState(pos.down()).isSolid()) continue;
            if(!world.getBlockState(pos).isAir()) continue;

            return pos.toImmutable();
            }
        return null;
    }
}
