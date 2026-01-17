package net.racquo.raccoonsCo.entity.ai.raccoon;

import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class RaccoonWashConcreteGoal extends Goal {

    private final RaccoonEntity raccoon;
    private final double speed;
    private ItemEntity targetPowder;

    public RaccoonWashConcreteGoal(RaccoonEntity raccoon, double speed) {
        this.raccoon = raccoon;
        this.speed = speed;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (!raccoon.isTamed()) return false;
        if (raccoon.isPostWashCoolingDown()) return false;
        if (raccoon.isInSittingPose()) return false;
        if (raccoon.isEating() || raccoon.isSleeping()) return false;
        if (!raccoon.grabbedStack.isEmpty()) return false;
        if (raccoon.isWashing()) return false;

        targetPowder = findNearestConcretePowder();
        return targetPowder != null;
    }

    @Override
    public void start() {
        if (targetPowder != null) {
            raccoon.getNavigation().startMovingTo(targetPowder, speed);
        }
    }

    @Override
    public void tick() {
        if (targetPowder == null || !targetPowder.isAlive()) {
            stop();
            return;
        }

        double distance = raccoon.distanceTo(targetPowder);

        // If close enough, trigger entity grab
        if (distance <= 1.5F) {
            if (!raccoon.isGrabbing() && raccoon.canGrab(targetPowder.getStack())) {
                raccoon.setGrabTarget(targetPowder); // only set once
                raccoon.startGrabSequence();
            }
        }
    }

    @Override
    public boolean shouldContinue() {
        return targetPowder != null
                && targetPowder.isAlive()
                && !raccoon.isWashing()
                && !raccoon.isGrabbing()
                && raccoon.grabbedStack.isEmpty();
    }

    @Override
    public void stop() {
        targetPowder = null;
    }

    /* ---------------- HELPERS ---------------- */

    private ItemEntity findNearestConcretePowder() {
        List<ItemEntity> items = raccoon.getEntityWorld().getEntitiesByClass(
                ItemEntity.class,
                raccoon.getBoundingBox().expand(12),
                item -> {
                    ItemStack stack = item.getStack();
                    if (!(stack.getItem() instanceof BlockItem blockItem)) return false;
                    if (!(blockItem.getBlock() instanceof ConcretePowderBlock)) return false;
                    return raccoon.canGrab(stack);
                }
        );

        return items.stream()
                .min(Comparator.comparingDouble(raccoon::distanceTo))
                .orElse(null);
    }
}
