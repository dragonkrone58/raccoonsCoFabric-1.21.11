package net.racquo.raccoonsCo.entity.ai;

import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

import java.util.function.Predicate;

public class RaccoonTemptGoal extends TemptGoal {

    private final RaccoonEntity raccoon;

    public RaccoonTemptGoal(RaccoonEntity raccoon, double speed, Ingredient ingredient){
        super(raccoon, speed, ingredient, false);
        this.raccoon = raccoon;
    }

    @Override
    public boolean canStart() {
        return !raccoon.isFull() && !raccoon.isSleeping() && super.canStart();
    }

    @Override
    public boolean shouldContinue() {
        return !raccoon.isFull() && !raccoon.isSleeping() && super.shouldContinue();
    }


}
