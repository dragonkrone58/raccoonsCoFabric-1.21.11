package net.racquo.raccoonsCo.entity.ai.raccoon;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

import java.util.EnumSet;
import java.util.List;

public class RaccoonEatFoodGoal extends Goal {
    private final RaccoonEntity raccoon;
    private ItemEntity targetFood;
    private int repathCooldown = 0;

    public RaccoonEatFoodGoal(RaccoonEntity raccoon) {
        this.raccoon = raccoon;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart(){
        if (raccoon. isInSittingPose()) return false;
        if (raccoon.isSleeping()) return false;
        if(!raccoon.canEatDroppedFood()) return false;
        if(raccoon.isFull()) return false;


        List<ItemEntity> items = raccoon.getEntityWorld().getEntitiesByClass(
                ItemEntity.class,
                raccoon.getBoundingBox().expand(8.0),
                item -> raccoon.canEatItem(item.getStack())
        );

        if (items.isEmpty()) return false;

        targetFood = items.get(0);
        return true;
    }

    @Override
    public boolean shouldContinue() {
        return targetFood != null
                && targetFood.isAlive()
                && !raccoon.isInSittingPose()
                && raccoon.squaredDistanceTo(targetFood) > 1.2
                && !raccoon.isSleeping()
                && !raccoon.isFull();
    }

    @Override
    public void start() {
        this.repathCooldown = 0;
    }

    @Override
    public void tick() {
        if(targetFood == null) { return; }

        raccoon.getLookControl().lookAt(targetFood, 30.0F, 30.0F);

        // Repath every 10 ticks to avoid spam
        if (repathCooldown-- <= 0) {
            raccoon.getNavigation().startMovingTo(
                    targetFood.getX(),
                    targetFood.getY(),
                    targetFood.getZ(),
                    1.1D
            );
            repathCooldown = 10;
        }

        if (raccoon.squaredDistanceTo(targetFood) <= 2.5) {
            raccoon.consumeDroppedFood(targetFood);
            targetFood = null;
        }
    }

    @Override
    public void stop() {
        targetFood = null;
        raccoon.getNavigation().stop();
    }

}
