package net.racquo.raccoonsCo.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.entity.ai.raccoon.*;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.sound.ModSounds;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RedPandaEntity extends AnimalEntity {


    private static final Logger log = LoggerFactory.getLogger(RedPandaEntity.class);

    /* ---------------- ANIMATION STATES ---------------- */
    public final AnimationState idleAnimationState = new AnimationState();

    /* ---------------- ENTITY STATES ---------------- */
    public enum RedPandaAction {
        IDLE
    }
    //ENTITY STATE TRACKER
    public static final TrackedData<Integer> DATA_ACTION =
            DataTracker.registerData(RedPandaEntity.class, TrackedDataHandlerRegistry.INTEGER);


    /* ---------------- CONSTRUCTOR ---------------- */

    public RedPandaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);
    }

    /* ---------------- ENTITY GOALS ---------------- */
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, ChickenEntity.class, true ));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 1.6D));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.15D));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }


    /* ---------------- ENTITY ATTRIBUTES ---------------- */
    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25D);
                //.add(EntityAttributes.TEMPT_RANGE, 12);
    }

    /* ---------------- INIT ---------------- */
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {

        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    /* ---------------- ACTION DATA TRACKER ---------------- */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ACTION, RedPandaEntity.RedPandaAction.IDLE.ordinal());

    }
    public RedPandaEntity.RedPandaAction getAction() {
        return RedPandaEntity.RedPandaAction.values()[this.dataTracker.get(DATA_ACTION)];
    }
    private void setAction(RedPandaEntity.RedPandaAction action) {
        if (getAction() == action) return;
        this.dataTracker.set(DATA_ACTION, action.ordinal());
    }

    public boolean isAction(RedPandaEntity.RedPandaAction action) {
        return getAction() == action;
    }

    /* ---------------- ANIMATION STATE SETUP---------------- */
    @Nullable
    private AnimationState currentAnimation = null;

    private void setupAnimationStates() {
        switch (getAction()) {

            default -> switchTo(idleAnimationState);
        }
    }

    //ANIMATION SETUP HELPER
    private void switchTo(AnimationState next) {
        if (currentAnimation == next) return;

        if (currentAnimation != null) {
            currentAnimation.stop();
        }

        currentAnimation = next;
        next.start(this.age);
    }

    /* ---------------- TICKING ---------------- */

    @Override
    public void tick() {
        super.tick();

        final World world = this.getEntityWorld();
        final boolean isServer = !world.isClient();

        // CLIENT ANIMATIONS
        setupAnimationStates();

    }

    /* ---------------- SOUNDS ---------------- */

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.RACCOON_IDLE;
    }

    @Nullable @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.RACCOON_HURT;
    }

    @Nullable @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.RACCOON_DEATH;
    }


    private static final List<ItemConvertible> REDPANDA_EATABLES =
            List.of(Items.BAMBOO, Items.SWEET_BERRIES, Items.GLOW_BERRIES);

    private static final Ingredient REDPANDA_INGREDIENT = Ingredient.ofItems(REDPANDA_EATABLES.toArray(ItemConvertible[]::new));


    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return REDPANDA_INGREDIENT.test(stack);
    }

    /* ---------------- CREATE CHILD ---------------- */

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {

        return ModEntities.RED_PANDA.create(world, SpawnReason.BREEDING);
    }
}
