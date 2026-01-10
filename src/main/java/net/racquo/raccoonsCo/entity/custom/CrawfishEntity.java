package net.racquo.raccoonsCo.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.ai.pathing.AmphibiousSwimNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.WaterAnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.sound.ModSounds;
import org.jspecify.annotations.Nullable;

public class CrawfishEntity extends WaterAnimalEntity implements Bucketable {

    /* ---------------- DATA TRACKERS ---------------- */
    private static final TrackedData<Boolean> FROM_BUCKET =
            DataTracker.registerData(CrawfishEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(CrawfishEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private static final double RARE_VARIANT_CHANCE = 0.02;

    public final AnimationState idleAnimationState = new AnimationState();

    /* ---------------- CONSTRUCTOR ---------------- */

    public CrawfishEntity(EntityType<? extends WaterAnimalEntity> type, World world) {
        super(type, world);
        this.setPathfindingPenalty(net.minecraft.entity.ai.pathing.PathNodeType.WATER, 0.0F);
        this.setPathfindingPenalty(net.minecraft.entity.ai.pathing.PathNodeType.WALKABLE, 0.0F);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {
        setVariant(pickVariant(this.random));

        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    /* ---------------- ANIMATION ---------------- */

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (!this.idleAnimationState.isRunning()) {
            this.idleAnimationState.start(this.age);
        }
    }

    /* ---------------- SPAWNING ---------------- */


    public static boolean canCrawfishSpawn(
            net.minecraft.entity.EntityType<?> type,
            WorldAccess world,
            net.minecraft.entity.SpawnReason reason,
            BlockPos pos,
            Random random
    ) {
        return world.getBlockState(pos).isOf(net.minecraft.block.Blocks.WATER)
                && world.getFluidState(pos).isStill();
    }

    /* ---------------- ENTITY GOALS ---------------- */

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new EscapeDangerGoal(this, 1.5));
        this.goalSelector.add(2, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.6, 1.4));
        this.goalSelector.add(4, new SwimAroundGoal(this, 1.5, 40));
    }

    /* ---------------- ENTITY ATTRIBUTES ---------------- */

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 3.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.20D)
                .add(EntityAttributes.WATER_MOVEMENT_EFFICIENCY);
    }

    /* ---------------- DATA TRACKER ---------------- */

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(FROM_BUCKET, false);
    }

    /* ---------------- VARIANTS ---------------- */

    public CrawfishVariant getVariant() {
        return CrawfishVariant.byId(this.dataTracker.get(DATA_ID_TYPE_VARIANT));
    }

    private void setVariant(CrawfishVariant variant) {
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId());
    }

    private static CrawfishVariant pickVariant(Random random) {
        return random.nextDouble() < RARE_VARIANT_CHANCE
                ? CrawfishVariant.BLUE
                : CrawfishVariant.DEFAULT;
    }

    /* ---------------- BREEDING ---------------- */

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        CrawfishEntity baby = ModEntities.CRAWFISH.create(world, SpawnReason.BREEDING);
        if (baby != null) {
            baby.setVariant(pickVariant(this.random));
        }
        return baby;
    }


    /*ADD KELP AS BREEDING ITEM
    MANUALLY ADD: INTERACTMOB W/ KELP, BREEDS.
    CRAWFISH WILL INCUBATE EGGS & HATCH AFTER TIME


     */

    /* ---------------- MOVEMENT ---------------- */

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public int getMaxAir() {
        return 4800;
    }

    @Override
    protected int getNextAirOnLand(int air) {
        return this.getMaxAir();
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new AmphibiousSwimNavigation(this, world);
    }

    /* ---------------- SOUNDS ---------------- */

    @Nullable @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.CRAWFISH_HURT;
    }

    @Nullable @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CRAWFISH_DEATH;
    }

    @Override
    protected void playStepSound(net.minecraft.util.math.BlockPos pos, net.minecraft.block.BlockState state) {
        this.playSound(
                SoundEvents.BLOCK_SAND_STEP,
                0.15F,
                this.getSoundPitch()
        );
    }

    /* ---------------- BUCKET ---------------- */

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (stack.isOf(Items.BUCKET) || stack.isOf( Items.WATER_BUCKET)) {
            return Bucketable.tryBucket(player, hand, this).orElse(ActionResult.PASS);
        }

        return super.interactMob(player, hand);
    }

    @Override
    public boolean isFromBucket() {
        return this.dataTracker.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean fromBucket) {
        this.dataTracker.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void copyDataToStack(ItemStack stack) {

        Bucketable.copyDataToStack(this, stack);

        NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, stack, nbt -> {
            nbt.putInt("Variant", this.getVariant().getId());

            nbt.putBoolean("IsBaby", this.isBaby());
        });
    }

    @Override
    public void copyDataFromNbt(NbtCompound nbt) {
        nbt.getInt("Variant").ifPresent(value -> this.setVariant(CrawfishVariant.byId(value)));
        nbt.getBoolean("IsBaby").ifPresent(this :: setBaby);
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.CRAWFISH_BUCKET);
    }

    @Override
    public SoundEvent getBucketFillSound() {
        return SoundEvents.ITEM_BUCKET_FILL;
    }
}
