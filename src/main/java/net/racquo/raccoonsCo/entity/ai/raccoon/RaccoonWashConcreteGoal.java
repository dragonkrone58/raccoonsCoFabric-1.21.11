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
    private BlockPos waterPos;

    public RaccoonWashConcreteGoal(RaccoonEntity raccoon, double speed) {
        this.raccoon = raccoon;
        this.speed = speed;
        this.setControls(EnumSet.of(Goal.Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (!raccoon.isTamed()) return false;
        if (raccoon.isInSittingPose()) return false;
        if (raccoon.isEating() || raccoon.isSleeping()) return false;
        if (!raccoon.grabbedStack.isEmpty()) return false;

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

        if (raccoon.distanceTo(targetPowder) < 1.5F) {
            grabConcrete();
        }
    }

    @Override
    public boolean shouldContinue() {
        return targetPowder != null
                && targetPowder.isAlive()
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
                item -> item.getStack().getItem() instanceof BlockItem blockItem
                        && blockItem.getBlock() instanceof ConcretePowderBlock
        );

        return items.stream()
                .min(Comparator.comparingDouble(raccoon::distanceTo))
                .orElse(null);
    }

    private void grabConcrete() {
        ItemStack stack = targetPowder.getStack();

        raccoon.grabbedStack = stack.copyWithCount(1);
        raccoon.getDataTracker().set(RaccoonEntity.DATA_GRABBING, true);
        raccoon.grabAnimationState.start(raccoon.age);

        stack.decrement(1);
        if (stack.isEmpty()) targetPowder.discard();

        raccoon.startGrabSequence();
    }
}
