package net.racquo.raccoonsCo.entity.ai.raccoon;

import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
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

        // Already holding something or washing
        if (!raccoon.grabbedStack.isEmpty()) return false;
        if (raccoon.isWashing()) return false;

        targetPowder = findNearestConcretePowder();
        return targetPowder != null;
    }

    @Override
    public void start() {
        raccoon.getNavigation().startMovingTo(targetPowder, speed);
    }

    @Override
    public void tick() {
        if (targetPowder == null || !targetPowder.isAlive()) {
            stop();
            return;
        }

        if (raccoon.distanceTo(targetPowder) <= 1.5F) {
            grabConcrete();

            // Immediately hand off to entity logic
            raccoon.getNavigation().stop();
            raccoon.attemptFindWater();

            stop();
        }
    }

    @Override
    public boolean shouldContinue() {
        return targetPowder != null
                && targetPowder.isAlive()
                && raccoon.grabbedStack.isEmpty()
                && !raccoon.isWashing();
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

    private void grabConcrete() {
        if (raccoon.isInSittingPose()) return;
        if (!raccoon.grabbedStack.isEmpty() && raccoon.grabbedStack.getCount() >= RaccoonEntity.MAX_GRAB_STACK) return;

        ItemStack stack = targetPowder.getStack();
        if (stack.isEmpty()) return;

        int spaceLeft = RaccoonEntity.MAX_GRAB_STACK - raccoon.grabbedStack.getCount();
        int toGrab = Math.min(spaceLeft, stack.getCount());
        if (toGrab <= 0) return;

        ItemStack taken = stack.split(toGrab);
        raccoon.addToInventory(taken);

        if (stack.isEmpty()) targetPowder.discard();

        raccoon.startGrabSequence();
        raccoon.attemptFindWater();
    }

}

