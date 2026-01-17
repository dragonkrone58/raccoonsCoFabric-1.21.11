package net.racquo.raccoonsCo.entity.ai.raccoon;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.sound.SoundEvents;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;
import net.racquo.raccoonsCo.sound.ModSounds;

public class RaccoonAttackGoal extends MeleeAttackGoal {

    private final RaccoonEntity raccoon;

    public RaccoonAttackGoal(RaccoonEntity raccoon, double speed) {
        super(raccoon, speed, true);
        this.raccoon = raccoon;
    }

    @Override
    public boolean canStart() {
        return !raccoon.isTamed()
                && !raccoon.isFull()
                && !raccoon.isSleeping()
                && super.canStart();
    }

    @Override
    protected void attack(LivingEntity target) {
        if (this.canAttack(target)) {
            this.resetCooldown();
            this.mob.tryAttack(getServerWorld(this.mob), target);
            raccoon.playSound(ModSounds.RACCOON_BITES, 1.0F, 1.0F);
        }
    }

    @Override
    public boolean shouldContinue() {
        return !raccoon.isTamed()
                && !raccoon.isFull()
                && super.shouldContinue();
    }
}
