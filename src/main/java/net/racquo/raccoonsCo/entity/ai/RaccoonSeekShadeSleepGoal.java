package net.racquo.raccoonsCo.entity.ai;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;
import org.jspecify.annotations.Nullable;

import java.util.EnumSet;
import net.minecraft.util.math.random.Random;

public class RaccoonSeekShadeSleepGoal extends Goal {

    private final RaccoonEntity raccoon;
    private final World world;
    private double targetX;
    private double targetY;
    private double targetZ;
    private final double speed;

    private static final int MAX_ATTEMPTS = 10;

    public RaccoonSeekShadeSleepGoal(RaccoonEntity raccoon, double speed) {
        this.raccoon = raccoon;
        this.world = raccoon.getEntityWorld();
        this.speed = speed;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (raccoon.isTamed()) return false;
        if (!raccoon.isFull()) return false;
        if (raccoon.isEating()) return false;
        if (raccoon.isSleeping()) return false;
        if (raccoon.isPanic()) return false;

        Vec3d target = findShade();
        if (target == null) return false;

        targetX = target.x;
        targetY = target.y;
        targetZ = target.z;

        return true;
    }

    @Override
    public void start() {
        raccoon.getNavigation().startMovingTo(targetX, targetY, targetZ, speed);
    }

    @Override
    public boolean shouldContinue() {
        // Continue until navigation is done or raccoon has started sleeping
        return !raccoon.isSleeping() && !raccoon.getNavigation().isIdle();
    }

    @Override
    public void tick() {
        if (raccoon.isSleeping()) return;

        double dx = targetX - raccoon.getX();
        double dy = targetY - raccoon.getY();
        double dz = targetZ - raccoon.getZ();
        double distSq = dx * dx + dy * dy + dz * dz;

        // Once within ~1 block, start sleeping
        if (distSq < 1.0) {
            raccoon.getNavigation().stop();
            raccoon.startSleeping();
        }
    }

    @Override
    public void stop() {
        // Clear target when goal stops
        targetX = targetY = targetZ = 0;
    }

    @Nullable
    private Vec3d findShade() {
        BlockPos origin = raccoon.getBlockPos();
        Random random = raccoon.getRandom();

        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            BlockPos candidate = origin.add(
                    random.nextInt(25) - 12,
                    random.nextInt(9) - 4,
                    random.nextInt(25) - 12
            );

            // viable sleeping conditions:
            if (world.isSkyVisible(candidate)) continue;
            if (world.getLightLevel(candidate) > 11) continue;
            if (!world.getBlockState(candidate.down()).isSideSolidFullSquare(world, candidate.down(), Direction.UP)) continue;
            if (!world.getBlockState(candidate).isAir()) continue;

            return Vec3d.ofBottomCenter(candidate);
        }

        return null;
    }
}
