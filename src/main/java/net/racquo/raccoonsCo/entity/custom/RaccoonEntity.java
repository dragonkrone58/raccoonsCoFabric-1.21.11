package net.racquo.raccoonsCo.entity.custom;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.entity.ai.raccoon.*;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.mixin.ConcretePowderBlockAccessor;
import net.racquo.raccoonsCo.sound.ModSounds;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

import net.minecraft.util.math.random.Random;
/*
   Current issues with washing:
   grabbing & washing animation do not play every two washing instances.

 */
public class RaccoonEntity extends TameableEntity {


    private static final Logger log = LoggerFactory.getLogger(RaccoonEntity.class);

    /* ---------------- ANIMATION STATES ---------------- */
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sittingAnimationState = new AnimationState();
    public final AnimationState eatingAnimationState = new AnimationState();
    public final AnimationState sleepingAnimationState = new AnimationState();
    public final AnimationState begAnimationState = new AnimationState();
    public final AnimationState grabAnimationState = new AnimationState();
    public final AnimationState washAnimationState = new AnimationState();

    public enum RaccoonAction {
        IDLE,
        GRABBING,
        WALKING_TO_WATER,
        WASHING,
        EATING,
        SLEEPING,
        BEGGING,
        SITTING,
        PANIC
    }

    public static final TrackedData<Integer> DATA_ACTION =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);


    /* ---------------- GRABBING & WASHING ---------------- */


    public ItemStack grabbedStack = ItemStack.EMPTY;
    private boolean headingToWater = false;
    private BlockPos waterPos;



    private static final int GRABBING_COOLDOWN = 2;

    public static final int MAX_GRAB_STACK = 16;

    private static final int GRAB_DURATION_TICKS = 35;
    private static final int WATER_RETRY_TICKS = 40;
    private static final int WASH_DROP_TICK = 90;
    private static final int WASHING_DURATION_TICKS = 20 * 7;
    private static final int MAX_WASH_SEARCH_DISTANCE = 24;
    private static final int POST_WASH_COOLDOWN_TICKS = 40;

    private int grabbingCooldown = 0;
    private int washingStartDelay = 0;
    private int grabbingTicks = 0;
    private int washingTicks = 0;
    private int waterRetryTicks = 0;
    private int postWashCooldown = 0;
    /* ---------------- EATING ---------------- */
    private ItemStack currentEatingStack;


    private static final int EATING_COOLDOWN_TICKS = 20;
    private static final int EATING_ANIMATION_DURATION = 70;
    private static final int EATING_SOUND_START = 20;
    private static final int EATING_SOUND_END = 50;
    private static final int BURP_TICK = 60;

    private int eatingCooldownTicks = 0;
    private int eatingTicks = 0;

    /* ---------------- FULLNESS ---------------- */

    public static final int MAX_FULLNESS = 3;
    private static final int FULLNESS_COOLDOWN_TICKS = 20 * 300;

    //FULLNESS DATA TRACKER
    private static final TrackedData<Integer> DATA_FULLNESS =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);

    private int fullnessCooldownTicks = 0;

    // FULLNESS TIMEOUT
    private static final int FULL_SLEEP_SEARCH_TICKS = 20 * 120; //2 minutes
    private int fullSleepSearchTicks = 0;

    //TAMED BUFF
    private int tamedBuffTicks = 0;
    private boolean hasTamedBuff = false;

    /* ---------------- PANIC MODE ---------------- */
    private static final int PANIC_TICKS = 20 * 8;
    private int panicTicks = 0;

    /* ---------------- SLEEPING ---------------- */
    private static final int SLEEP_DURATION_TICKS = 20 * 300; // 5 minutes
    private static final int MAX_SLEEP_LIGHT = 12;
    private int sleepTicks = 0;

    /* ---------------- TEMPTABLES ---------------- */
    private static final List<ItemConvertible> RACCOON_EATABLES =
            List.of(ModItems.BOILED_EGG, ModItems.COOKED_CRAWFISH, ModItems.RAW_CRAWFISH, Items.SWEET_BERRIES, Items.COOKIE, Items.APPLE, Items.MELON_SLICE,
                    Items.GLOW_BERRIES, Items.PUMPKIN_PIE, Items.POTATO, Items.BAKED_POTATO, Items.SALMON, Items.COOKED_SALMON,
                    Items.COD, Items.COOKED_COD, Items.CHICKEN, Items.COOKED_CHICKEN);

    private static final Ingredient RACCOON_TEMPT_INGREDIENT = Ingredient.ofItems(RACCOON_EATABLES.toArray(ItemConvertible[]::new));


    /* ---------------- VARIANTS ---------------- */
    private static final RaccoonVariant[] RARE_VARIANTS = {
            RaccoonVariant.BLACK,
            RaccoonVariant.ALBINO
    };

    private static final RaccoonVariant[] UNCOMMON_VARIANTS = {
            RaccoonVariant.BLOND,
            RaccoonVariant.CINNAMON,
    };

    //VARIANT DATA TRACKER
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);


    /* ---------------- CONSTRUCTOR ---------------- */
    public RaccoonEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);
    }

    /* ---------------- ENTITY GOALS ---------------- */
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new TameableEscapeDangerGoal(1.5D, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.add(2, new SitGoal(this));
        this.targetSelector.add(4, new ActiveTargetGoal<>(this, ChickenEntity.class, true ));
        this.goalSelector.add(4, new RaccoonWashConcreteGoal(this, 1.2D));
        this.goalSelector.add(3, new EscapeDangerGoal(this, 1.6D));
        this.goalSelector.add(5, new RaccoonSeekShadeSleepGoal(this, 1.2D));
        this.goalSelector.add(6, new FollowOwnerGoal(this, 1.2D, 10.0F, 2.0F));
        this.goalSelector.add(7, new RaccoonAttackGoal(this, 1.4D));

        this.goalSelector.add(8, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(9, new RaccoonEatFoodGoal(this));
        this.goalSelector.add(10, new RaccoonTemptGoal(this, 1.25D,
                RACCOON_TEMPT_INGREDIENT));

        this.goalSelector.add(11, new RaccoonFollowParentGoal(this, 1.1D));

        this.goalSelector.add(12, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(13, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(14, new LookAroundGoal(this));
    }

    @Override
    public boolean canTarget(@Nullable LivingEntity target) {
        if (isGrabbing() || isWashing()) return false;
        return super.canTarget(target);
    }


    /* ---------------- ENTITY ATTRIBUTES ---------------- */
    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.TEMPT_RANGE, 12)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 5.0F)
                .add(EntityAttributes.ATTACK_DAMAGE, 1.5D);
    }

    /* ---------------- RACCOON INIT ---------------- */
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {
        RegistryKey<Biome> biomeKey =
                world.getBiome(this.getBlockPos()).getKey().orElse(null);
        setVariant(pickVariant(this.random, biomeKey));

        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    /* ---------------- ACTION DATA TRACKER ---------------- */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ACTION, RaccoonAction.IDLE.ordinal());
        builder.add(DATA_FULLNESS, 0);
        builder.add(DATA_ID_TYPE_VARIANT, 0);


    }
    public RaccoonAction getAction() {
        return RaccoonAction.values()[this.dataTracker.get(DATA_ACTION)];
    }
    private void setAction(RaccoonAction action) {
        if (getAction() == action) return;
        this.dataTracker.set(DATA_ACTION, action.ordinal());
    }

    public boolean isAction(RaccoonAction action) {
        return getAction() == action;
    }

    /* ---------------- ANIMATION STATE SETUP---------------- */
    @Nullable
    private AnimationState currentAnimation = null;

    private void setupAnimationStates() {
        switch (getAction()) {
            case SLEEPING -> switchTo(sleepingAnimationState);
            case WASHING -> switchTo(washAnimationState);
            case GRABBING -> switchTo(grabAnimationState);
            case EATING -> switchTo(eatingAnimationState);
            case BEGGING -> switchTo(begAnimationState);
            case SITTING -> switchTo(sittingAnimationState);
            default -> switchTo(idleAnimationState);
        }
    }



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

        // PANIC MODE
        if (isAction(RaccoonAction.PANIC)) {
            if (--panicTicks <= 0) {
                panicTicks = 0;
                setAction(RaccoonAction.IDLE);
                if (isServer) log.info("Raccoon panic mode ended");
            }
        }

        // TAMED BUFF
        if (isServer && hasTamedBuff && --tamedBuffTicks <= 0) {
            endTamedBuff();
        }

        if (isServer && postWashCooldown > 0) {
            postWashCooldown--;
        }

        // GRABBING
        if (isServer && isAction(RaccoonAction.GRABBING)){
            handleGrabbingTick();
        }
        //RETRY WATER SEARCHING
        if (isServer
                && !isAction(RaccoonAction.WASHING)
                && !(isAction(RaccoonAction.GRABBING))
                && !isAction(RaccoonAction.WALKING_TO_WATER)
                && !grabbedStack.isEmpty()) {

            if (++waterRetryTicks >= WATER_RETRY_TICKS) {
                waterRetryTicks = 0;
                attemptFindWater();
            }
        }

        // ARRIVED AT WATER
        if (headingToWater && waterPos != null) {
            if (this.getBlockPos().isWithinDistance(waterPos, 1.5)) {
                headingToWater = false;

                setAction(RaccoonAction.IDLE);
                //delay washing
                washingStartDelay = 1;
                washingTicks = 0;
                getNavigation().stop();
            }
        }

        // START WASHING AFTER DELAY
        if (washingStartDelay > 0 && --washingStartDelay == 0) {

            // Transition directly into washing
            if (!isAction(RaccoonAction.WASHING) && !grabbedStack.isEmpty()) {
                setAction(RaccoonAction.WASHING);
                washingTicks = 0;
            }
        }

        // WASHING
        if (isServer && isAction(RaccoonAction.WASHING)) {
            handleWashingTick();
        }

        // EATING COOLDOWN
        if (eatingCooldownTicks > 0) eatingCooldownTicks--;

        // EATING ANIMATION
        if (this.isEating()) {
            handleEatingTick(isServer);
        }

        // FULLNESS COOLDOWN (TAMED)
        if (this.isTamed() && fullnessCooldownTicks > 0 && --fullnessCooldownTicks == 0) {
            resetFullness();
        }

        // SLEEP SEARCH (WILD ONLY)
        if (isServer && shouldSearchForSleep()) {
            if (++fullSleepSearchTicks >= FULL_SLEEP_SEARCH_TICKS) {
                resetFullness();
            }
        } else {
            fullSleepSearchTicks = 0;
        }

        // SLEEPING
        if (isServer && this.isSleeping() && !this.isTamed()) {
            sleepTicks++;
            if (++sleepTicks >= SLEEP_DURATION_TICKS) {
                wakeNatural();
            }
        }

        // FREEZE MOVEMENT WHILE SLEEPING
        if (this.isSleeping() && !this.isTamed()) {
            this.getNavigation().stop();
            this.setVelocity(0, this.getVelocity().y, 0);
            this.velocityDirty = true;
        }

        // CLIENT ANIMATIONS

        setupAnimationStates();

    }


    /* ---------------- CREATE CHILD ---------------- */

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        RaccoonEntity baby = ModEntities.RACCOON.create(world, SpawnReason.BREEDING);
        if (baby == null) return null;

        RegistryKey<Biome> biomeKey =
                world.getBiome(this.getBlockPos()).getKey().orElse(null);

        baby.setVariant(pickVariant(this.random, biomeKey));

        return baby;
    }

    /* ---------------- INTERACTING WITH RACCOON ---------------- */
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {

        if (isSleeping()) return ActionResult.PASS;

        ItemStack stack = player.getStackInHand(hand);

        if (tryHandleTaming(player, stack)) return ActionResult.SUCCESS;
        if (tryHandleHealing(player, hand, stack)) return ActionResult.SUCCESS;

        ActionResult result = super.interactMob(player, hand);
        if (!result.isAccepted() && this.isOwner(player)) {
            toggleSitting();
            return ActionResult.SUCCESS.noIncrementStat();
        }

        return result;
    }

    /* ---------------- TAMING RACCOON ---------------- */

    private boolean tryHandleTaming(PlayerEntity player, ItemStack stack) {
        if (isTamed()) return false;
        if (!stack.isOf(ModItems.RAW_CRAWFISH) && !stack.isOf(ModItems.COOKED_CRAWFISH)) return false;

        if (!getEntityWorld().isClient()) {
            stack.decrementUnlessCreative(1, player);
            tryTame(player, stack);
        }
        return true;
    }

    /* ---------------- TAMED RACCOON HEALING ---------------- */

    private boolean tryHandleHealing(PlayerEntity player, Hand hand, ItemStack stack) {
        if (!isTamed()) return false;
        if (!RACCOON_TEMPT_INGREDIENT.test(stack)) return false;
        if (getHealth() >= getMaxHealth()) return false;

        eat(player, hand, stack);
        eatingEffect(stack);
        healFromFood(stack);
        return true;
    }

    private void healFromFood(ItemStack stack) {
        FoodComponent food = stack.get(DataComponentTypes.FOOD);
        this.heal(2.0F * (food != null ? food.nutrition() : 1.0F));
    }

    /* ---------------- TAMED RACCOON GRABBING  ---------------- */

    public boolean isGrabbing(){
        return isAction(RaccoonAction.GRABBING);    }

    // Add at the top with other fields
    private ItemEntity grabTarget = null;

    // Setter
    public void setGrabTarget(ItemEntity target) {
        this.grabTarget = target;
    }

    public boolean canGrab(ItemStack stack) {
        if (stack.isEmpty()) return false;
        if (postWashCooldown > 0) return false;
        if(this.isInSittingPose()) return false;
        if(this.isSleeping()) return false;
        if(this.isEating()) return false;
        if(this.isWashing()) return false;

        if (!(stack.getItem() instanceof BlockItem blockItem)) return false;
        if (!(blockItem.getBlock() instanceof ConcretePowderBlock)) return false;

        if (grabbedStack.isEmpty()) return true;

        // Only grab same color
        return grabbedStack.isOf(stack.getItem()) && grabbedStack.getCount() < MAX_GRAB_STACK;
    }

    public void addToInventory(ItemStack stack) {
        if (stack.isEmpty()) return;

        if (grabbedStack.isEmpty()) {
            grabbedStack = stack.copy();
            grabbedStack.setCount(Math.min(stack.getCount(), MAX_GRAB_STACK));
            return;
        }

        if (!grabbedStack.isOf(stack.getItem())) return;

        int space = MAX_GRAB_STACK - grabbedStack.getCount();
        if (space <= 0) return;

        grabbedStack.increment(Math.min(space, stack.getCount()));
    }


    public void startGrabSequence() {
        if (isGrabbing()) return;
        if (grabTarget == null) return;
        setAction(RaccoonAction.GRABBING);
        grabbingTicks = 0;
        grabbingCooldown = GRABBING_COOLDOWN;
    }


    private void resumeConcreteSearch() {
        this.headingToWater = false;
        this.waterPos = null;
        this.grabbingTicks = 0;
    }

      // GRABBING TICK HANDLER
      private void handleGrabbingTick() {
          grabbingTicks++;

          // Stop movement during grab
          getNavigation().stop();
          setVelocity(0, getVelocity().y, 0);
          velocityDirty = true;
          this.bodyYaw = this.getYaw();
          this.headYaw = this.getYaw();

          if (grabbingTicks == 10) playSound(ModSounds.RACCOON_SNIFFS, 1.0F, 1.0F);

          if (grabbingCooldown > 0) {
              grabbingCooldown--;
              return;
          }

          if (grabTarget == null || !grabTarget.isAlive()) {
              // No valid target, stop grabbing
              setAction(RaccoonAction.IDLE);
              return;
          }

          // Only pick up if canGrab
          if (grabbingTicks >= GRAB_DURATION_TICKS && canGrab(grabTarget.getStack())) {
              ItemStack stack = grabTarget.getStack();

              int spaceLeft = MAX_GRAB_STACK - grabbedStack.getCount();
              int toGrab = Math.min(spaceLeft, stack.getCount());
              if (toGrab > 0) {
                  ItemStack taken = stack.split(toGrab);
                  addToInventory(taken);

                  if (stack.isEmpty()) grabTarget.discard();
              }

              grabTarget = null;
              attemptFindWater();
              setAction(RaccoonAction.IDLE);
              grabbingTicks = 0;
          }
      }



    /* ---------------- TAMED RACCOON SEEK WATER  ---------------- */
    public void attemptFindWater() {
        waterPos = findNearestWater();

        if (waterPos == null || grabbedStack.isEmpty()) return;

        waterRetryTicks = 0;
        headingToWater = true;

        setAction(RaccoonAction.WALKING_TO_WATER);

        getNavigation().startMovingTo(
                waterPos.getX() + 0.5,
                waterPos.getY(),
                waterPos.getZ() + 0.5,
                1.1D
        );
    }


    @Nullable
    private BlockPos findNearestWater() {
        BlockPos origin = getBlockPos();

        for (BlockPos pos : BlockPos.iterateOutwards(origin, MAX_WASH_SEARCH_DISTANCE, 2, MAX_WASH_SEARCH_DISTANCE)) {
            if (getEntityWorld().getBlockState(pos).isOf(Blocks.WATER)) {
                return pos;
            }
        }
        return null;
    }


    /* ---------------- TAMED RACCOON WASHING  ---------------- */

    // WASHING TICK HANDLER
    public boolean isWashing(){
        return isAction(RaccoonAction.WASHING);
    }

    private void handleWashingTick() {
        washingTicks++;

        // Stop movement while washing
        getNavigation().stop();
        setVelocity(0, getVelocity().y, 0);
        velocityDirty = true;
        this.bodyYaw = this.getYaw();
        this.headYaw = this.getYaw();

        // Play water sounds and particles periodically
        if (washingTicks % 20 == 0 && washingTicks < WASH_DROP_TICK) {
            playSound(SoundEvents.ENTITY_GENERIC_SPLASH, 0.5F, 1.0F);

            if (!getEntityWorld().isClient()) {
                ((ServerWorld) getEntityWorld()).spawnParticles(
                        ParticleTypes.SPLASH,
                        getX(),
                        getBodyY(0.5),
                        getZ(),
                        3,
                        0.2, 0.2, 0.2, 0.01
                );
            }
        }
        if (washingTicks == WASH_DROP_TICK) {
            playSound(SoundEvents.ENTITY_ITEM_PICKUP);
            dropWashedConcrete();
        }

        if (washingTicks >= WASHING_DURATION_TICKS) {
            if (isAction(RaccoonAction.WASHING)) {
                setAction(RaccoonAction.IDLE);
            }
            washingStartDelay = 1;
            washingTicks = 0;
            waterPos = null;
            grabbedStack = ItemStack.EMPTY;

            getNavigation().stop();
            setVelocity(0, getVelocity().y, 0);
            velocityDirty = true;

            resumeConcreteSearch();
            postWashCooldown = POST_WASH_COOLDOWN_TICKS;        }

    }

    private void dropWashedConcrete() {
        if (grabbedStack.isEmpty()) return;
        if (!(grabbedStack.getItem() instanceof BlockItem blockItem)) return;
        if (!(blockItem.getBlock() instanceof ConcretePowderBlock powder)) return;

        Block hardened = ((ConcretePowderBlockAccessor) powder).raccoonsCo$getHardenedBlock();
        ItemStack output = new ItemStack(hardened.asItem(), grabbedStack.getCount());

        ItemEntity entity = new ItemEntity(
                getEntityWorld(),
                getX(),
                getBodyY(0.5),
                getZ(),
                output
        );
        getEntityWorld().spawnEntity(entity);

        grabbedStack = ItemStack.EMPTY;
    }

    public boolean isPostWashCoolingDown() {
        return postWashCooldown > 0;
    }


    @Override
    public void onDeath(DamageSource source) {
        super.onDeath(source);
        dropInventory(); // drop any concrete powder or washed blocks
    }


    private void dropInventory() {
        if (grabbedStack.isEmpty()) return;

        ItemStack toDrop = grabbedStack;
        grabbedStack = ItemStack.EMPTY;

        ItemEntity entity = new ItemEntity(
                getEntityWorld(),
                getX(),
                getBodyY(0.5),
                getZ(),
                toDrop
        );

        getEntityWorld().spawnEntity(entity);
    }


    /* ---------------- TAMED RACCOON SITTING ---------------- */

    private void toggleSitting() {
        if (isGrabbing() || isWashing()) return;

        boolean newState = !isSitting();
        setSitting(newState);

        jumping = false;
        navigation.stop();
        setTarget(null);

        if (newState) {
            setAction(RaccoonAction.SITTING);
            dropInventory();
        } else {
            setAction(RaccoonAction.IDLE);
        }
    }



    /* ---------------- TAMING ATTEMPT METHOD  ---------------- */
    private void tryTame(PlayerEntity player, ItemStack itemStack) {
        this.eatingEffect(itemStack);
        if (this.random.nextInt(3) == 0) {
            this.setTamedBy(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setSitting(true);
            this.getEntityWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
        } else {
            this.getEntityWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);
        }
    }

    /* ---------------- BREEDING ---------------- */
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return this.isTamed() && this.getHealth() >= this.getMaxHealth()
                && RACCOON_TEMPT_INGREDIENT.test(stack);
    }

    /* ---------------- TAMED RACCOON BUFFING ---------------- */

    private void endTamedBuff() {
        hasTamedBuff = false;

        var attr = this.getAttributeInstance(EntityAttributes.MAX_HEALTH);
        if (attr != null && attr.getBaseValue() != 10.0D) {
            attr.setBaseValue(10.0D);
        }

        if (this.getHealth() > 10.0F) {
            this.setHealth(10.0F);
        }

        resetFullness();
    }


    /* ---------------- SOUND & PARTICLE EFFECTS ---------------- */
    private void eatingEffect(ItemStack itemStack){
        this.playSound(ModSounds.RACCOON_EATS, 0.7F, 1.1F);

        if (!this.getEntityWorld().isClient()) {
            ((ServerWorld) this.getEntityWorld()).spawnParticles(
                    new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack),
                    this.getX(),
                    this.getBodyY(0.6),
                    this.getZ(),
                    6,
                    0.2, 0.2, 0.2,
                    0.05
            );
        }
    }

    /* ---------------- EATING ITEM HELPERS ---------------- */
    public void startEating(ItemStack stack) {
        setAction(RaccoonAction.EATING);
        this.stopBegging();
        this.currentEatingStack = stack.copyWithCount(1);
        this.eatingTicks = 0;
        this.getNavigation().stop();
    }

    //EATING TICK HANDLER
    private void handleEatingTick(boolean isServer) {
        eatingTicks++;

        if (isServer) this.getNavigation().stop();

        if (eatingTicks == 1) {
            playSound(ModSounds.RACCOON_SNIFFS, 1.0F, 1.0F);
        }
        // Play Sounds
        if (eatingTicks >= EATING_SOUND_START
                && eatingTicks <= EATING_SOUND_END
                && eatingTicks % 5 == 0) {
            eatingEffect(currentEatingStack);
        }
        if (eatingTicks == BURP_TICK) {
            playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, 1.0F);
        }

        // Finish eating after animation duration
        if (eatingTicks >= EATING_ANIMATION_DURATION && isServer) {
            finishEating();
        }
    }


    //ITEM EATING ELIGIBILITY HELPER
    public boolean canEatItem(ItemStack itemStack) {

        return RACCOON_TEMPT_INGREDIENT.test(itemStack);
    }

    //ITEM EATING COOLDOWN HELPER
    public boolean canEatDroppedFood() {
        if (eatingCooldownTicks > 0) return false;
        if (isSleeping()) return false;

        return !isTamed() || fullnessCooldownTicks == 0;
    }


    //EATING GETTER
    public boolean isEating() {
        return isAction(RaccoonAction.EATING);
    }

    //STOP EATING
    private void finishEating() {
        setAction(RaccoonAction.IDLE);
        this.stopBegging();
        this.currentEatingStack = ItemStack.EMPTY;
        increaseFullness();

        // Start eating cooldown after finishing the animation
        this.eatingCooldownTicks = EATING_COOLDOWN_TICKS;
    }


    //EAT DROPPED ITEM METHOD:
    public void consumeDroppedFood(ItemEntity itemEntity) {
        if (this.getEntityWorld().isClient()) return;

        // Already eating or cooldown not finished
        if (this.isEating() || this.eatingCooldownTicks > 0) return;

        if (this.isInSittingPose()) return;
        if (this.isFull()) return;

        ItemStack itemStack = itemEntity.getStack();

        if (!canEatItem(itemStack)) return; // ensure it's a valid food item

        // Start eating animation
        this.startEating(itemStack);

        // Remove 1 item from stack
        itemStack.decrement(1);
        if (itemStack.isEmpty()) {
            itemEntity.discard();
        }
    }


    /* ---------------- FULLNESS HELPERS ---------------- */

    //FULLNESS GETTER
    public int getFullness(){
        return this.dataTracker.get(DATA_FULLNESS);
    }

    //IS FULLNESS
    public boolean isFull(){
        return getFullness() >= MAX_FULLNESS;
    }

    //FULLNESS SETTER
    public void increaseFullness() {
        if (isFull()) return;

        int before = getFullness();
        int after = before + 1;
        this.dataTracker.set(DATA_FULLNESS, after);

        if (!this.getEntityWorld().isClient()) {
            log.info("Raccoon fullness increased: {} -> {}", before, after);
        }

        // If tamed and now full, start buff period
        if (this.isTamed() && after >= MAX_FULLNESS) {
            hasTamedBuff = true;
            tamedBuffTicks = FULLNESS_COOLDOWN_TICKS;

            Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.MAX_HEALTH))
                    .setBaseValue(20.0D);

            if (this.getHealth() < 20.0F) {
                this.setHealth(20.0F);
            }
            playSound(SoundEvents.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            if (!this.getEntityWorld().isClient()) {
                log.info("Tamed raccoon reached full fullness: resistance period started");
            }
        }
    }

    /* ---------------- SLEEPING HELPERS ---------------- */
    @Override
    public boolean isImmobile() {
        return this.isSleeping() || super.isImmobile();
    }

    public boolean isPanic(){

        return isAction(RaccoonAction.PANIC);
    }

    public boolean isSleeping() {

        return isAction(RaccoonAction.SLEEPING);
    }



    /* ---------------- START SLEEPING METHOD ---------------- */

    private boolean shouldSearchForSleep() {
        return !isTamed()
                && isFull()
                && !isSleeping()
                && !isPanic();
    }

    public void startSleeping() {

        if(!canSleepHere()) return;

        this.sleepTicks = 0;
        this.fullSleepSearchTicks = 0;
        setAction(RaccoonAction.SLEEPING);
        this.setSitting(false);
        this.getNavigation().stop();
        this.setVelocity(0, this.getVelocity().y, 0);
    }
    /* ---------------- SLEEP SEARCH METHOD---------------- */
    public boolean canSleepHere() {
        if (this.isTamed()) return false;
        if (isAction(RaccoonAction.PANIC)) return false;
        if (!this.isFull()) return false;

        int light = this.getEntityWorld().getLightLevel(this.getBlockPos());
        return light <= MAX_SLEEP_LIGHT;
    }

    /* ---------------- WAKING METHOD ---------------- */


    //RACCOON SLEEP WAKE
    public void wakeNatural() {
        if(!isSleeping()) return;

        this.sleepTicks = 0;
        setAction(RaccoonAction.IDLE);

        // Fully rested : reset fullness & timer
        resetFullness();
        this.getNavigation().stop();
        this.velocityDirty = false;
    }

    //RACCOON SLEEP INTERRUPTED
    public void wakeInterrupted(){
        if(!isSleeping()) return;

        sleepTicks = 0;
        setAction(RaccoonAction.IDLE);

        this.fullSleepSearchTicks = 0;

        getNavigation().stop();
        velocityDirty = false;
    }
    /* ---------------- WAKE WHEN DAMAGE ---------------- */
    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        boolean result = super.damage(world, source, amount);

        if (result) {
            // Enter panic mode
            wakeInterrupted();
            setAction(RaccoonAction.PANIC);
            this.panicTicks = PANIC_TICKS;
        }

        return result;
    }
    /* ---------------- FULLNESS RESET ---------------- */
    private void resetFullness() {
        this.dataTracker.set(DATA_FULLNESS, 0);
        this.fullSleepSearchTicks = 0;
        this.fullnessCooldownTicks = 0;

        if (!this.getEntityWorld().isClient()) {
            log.info("Raccoon fullness reset");
        }
    }


    /* ---------------- ATTACK HELPERS ---------------- */
    @Override
    public void setTarget(@Nullable LivingEntity target) {
        LivingEntity previous = this.getTarget();
        super.setTarget(target);

        if (!this.getEntityWorld().isClient()
                && target instanceof ChickenEntity
                && previous == null
                && !this.isTamed()
                && !this.isFull()) {

            this.playSound(ModSounds.RACCOON_GROWLS, 1.0F, 1.0F);
        }
    }

    /* ---------------- BEGGING HELPERS ---------------- */
    @Nullable
    private RaccoonAction actionBeforeBegging = null;

    public void startBegging() {
        if (isAction(RaccoonAction.BEGGING)) return;
        if (isEating() || isSleeping() || isGrabbing() || isWashing()) return;

        actionBeforeBegging = getAction();
        setAction(RaccoonAction.BEGGING);
    }

    public void stopBegging() {
        if (!isAction(RaccoonAction.BEGGING)) return;

        setAction(actionBeforeBegging != null ? actionBeforeBegging : RaccoonAction.IDLE);
        actionBeforeBegging = null;
    }
    /* ---------------- SOUNDS ---------------- */
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if(this.isSleeping()){
            return ModSounds.RACCOON_SLEEPS;
        }
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


    /* ---------------- VARIANT HELPERS ---------------- */
    public RaccoonVariant getVariant(){
        return RaccoonVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant(){
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(RaccoonVariant variant){
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    /* ---------------- VARIANT DATA METHODS ---------------- */

    @Override
    public void writeData(WriteView view) {
        super.writeData(view);
        view.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readData(ReadView view) {
        super.readData(view);
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, view.getInt("Variant", 0));
    }

    /* ---------------- PICK VARIANT METHOD ---------------- */

    private static RaccoonVariant pickVariant(Random random, @Nullable RegistryKey<Biome> biomeKey){
        if(random.nextFloat() < 0.02F){return Util.getRandom(RARE_VARIANTS, random);}

        if(random.nextFloat() < 0.1F){return Util.getRandom(UNCOMMON_VARIANTS, random);}

        if(biomeKey == null){return RaccoonVariant.DEFAULT;}

        if (biomeKey.equals(BiomeKeys.TAIGA)) {
            return random.nextBoolean()
                    ? RaccoonVariant.DEFAULT
                    : RaccoonVariant.GRAY;

        } else if (biomeKey.equals(BiomeKeys.FOREST)) {
            return random.nextBoolean()
                    ? RaccoonVariant.GRAY
                    : RaccoonVariant.BROWN;

        } else if (biomeKey.equals(BiomeKeys.SWAMP)) {
            return RaccoonVariant.SWAMP;

        } else {return RaccoonVariant.DEFAULT;}
    }
}
