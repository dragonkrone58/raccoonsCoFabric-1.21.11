package net.racquo.raccoonsCo.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

import java.util.EnumSet;

public class RaccoonSeekShadeSleepGoal extends Goal {

    private final RaccoonEntity raccoon;
    private BlockPos targetPos;


    public RaccoonSeekShadeSleepGoal(RaccoonEntity raccoon) {
        this.raccoon = raccoon;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (raccoon.getFullness() < RaccoonEntity.MAX_FULLNESS) return false;
        if(raccoon.isEating()) return false;
        if (raccoon.isSleeping()) return false;
        if (raccoon.isPanic()) return false;
        if (raccoon.isTamed()) return false;

        targetPos = findShade();
        return targetPos != null;
    }

    @Override
    public void start() {
        if (targetPos != null) {
            raccoon.getNavigation().startMovingTo(
                    targetPos.getX() + 0.5,
                    targetPos.getY(),
                    targetPos.getZ() + 0.5,
                    1.0D
            );
        }
    }

    @Override
    public boolean shouldContinue() {
        return targetPos != null
                && !raccoon.isSleeping();
    }

    @Override
    public void tick() {
        if (targetPos == null) return;

        double tx = targetPos.getX() + 0.5;
        double ty = targetPos.getY() + 0.1;
        double tz = targetPos.getZ() + 0.5;

        if (raccoon.squaredDistanceTo(tx, ty, tz) < 0.75 * 0.75) {
            raccoon.getNavigation().stop();
            raccoon.startSleeping();
        }
    }

    @Override
    public void stop() {
        targetPos = null;
    }

    private BlockPos findShade() {
        World world = raccoon.getEntityWorld();
        BlockPos origin = raccoon.getBlockPos();

        for (BlockPos pos : BlockPos.iterateOutwards(origin, 12, 4, 12)) {
            if (world.isSkyVisible(pos)) continue;
            if (world.getLightLevel(pos) > 11) continue;
            if (!world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), Direction.UP)) continue;
            if (!world.getBlockState(pos).isAir()) continue;

            return pos.toImmutable();
        }
        return null;
    }
}
