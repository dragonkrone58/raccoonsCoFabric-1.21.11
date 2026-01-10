package net.racquo.raccoonsCo.entity.custom;

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
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.entity.ai.*;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.sound.ModSounds;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import net.minecraft.util.math.random.Random;

public class RaccoonEntity extends TameableEntity {


    private static final Logger log = LoggerFactory.getLogger(RaccoonEntity.class);

    /* ---------------- ANIMATION STATES ---------------- */
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sittingAnimationState = new AnimationState();
    public final AnimationState eatingAnimationState = new AnimationState();
    public final AnimationState sleepingAnimationState = new AnimationState();
    public final AnimationState begAnimationState = new AnimationState();

    /* ---------------- EATING ---------------- */
    private ItemStack currentEatingStack;
    private int eatingTicks = 0;
    private int eatingCooldown = 0;
    //EATING DATA TRACKER
    private static final TrackedData<Boolean> DATA_EATING =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final int EATING_COOLDOWN_TICKS = 20;
    private static final int EATING_ANIMATION_DURATION = 70;
    private static final int EATING_SOUND_START = 20;
    private static final int EATING_SOUND_END = 50;
    private static final int BURP_TICK = 60;

    /* ---------------- FULLNESS ---------------- */
    public static final int MAX_FULLNESS = 3;
    //FULLNESS DATA TRACKER
    private static final TrackedData<Integer> DATA_FULLNESS =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);
    //ALTER TIMER FOR LONGER TAMED RACCOON BUFF
    private static final int FULLNESS_COOLDOWN_TICKS = 20 * 300; // 5 minutes
    private int fullnessCooldownTicks = 0;

    // FULLNESS TIMEOUT
    private static final int FULL_SLEEP_SEARCH_TICKS = 20 * 120; //2 minutes
    private int fullSleepSearchTicks = 0;

    //TAMED BUFF
    private int tamedBuffTicks = 0;
    private boolean hasTamedBuff = false;

    /* ---------------- PANIC MODE ---------------- */
    private static final int PANIC_TICKS = 20 * 8;
    //PANIC DATA TRACKER
    private static final TrackedData<Boolean> DATA_PANIC_MODE =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int panicTicks = 0;

    /* ---------------- SLEEPING ---------------- */
    private static final int SLEEP_DURATION_TICKS = 20 * 300; // 5 minutes
    private static final int MAX_SLEEP_LIGHT = 12;
    //SLEEPING DATA TRACKER
    private static final TrackedData<Boolean> DATA_SLEEPING =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int sleepTicks = 0;


    /* ---------------- BEGGING ---------------- */
    //BEGGING DATA TRACKER
    private static final TrackedData<Boolean> DATA_BEGGING =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

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
        this.goalSelector.add(1, new TameableEntity.TameableEscapeDangerGoal(1.5D, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.add(2, new SitGoal(this));
        this.targetSelector.add(4, new ActiveTargetGoal<>(
                this,
                ChickenEntity.class,
                true
        ));
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

    /* ---------------- ENTITY ATTRIBUTES ---------------- */
    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.TEMPT_RANGE, 12)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 5.0F)
                .add(EntityAttributes.ATTACK_DAMAGE, 1.0D);
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

    /* ---------------- DATA TRACKER INIT ---------------- */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(DATA_EATING, false);
        builder.add(DATA_FULLNESS, 0);
        builder.add(DATA_SLEEPING, false);
        builder.add(DATA_PANIC_MODE, false);
        builder.add(DATA_BEGGING, false);
    }

    /* ---------------- ANIMATION STATE SETUP---------------- */
    private void setupAnimationStates() {

        // SLEEPING STATE
        if (this.isSleeping()) {
            idleAnimationState.stop();
            sittingAnimationState.stop();
            eatingAnimationState.stop();
            begAnimationState.stop();

            if (!sleepingAnimationState.isRunning()) {
                sleepingAnimationState.start(this.age);
            }
            return;
        }
        sleepingAnimationState.stop();

        //EATING STATE
        if(this.isEating()) {
            idleAnimationState.stop();
            sittingAnimationState.stop();
            begAnimationState.stop();
            sleepingAnimationState.stop();

            if(!eatingAnimationState.isRunning()){
                eatingAnimationState.start(this.age);
            }
            return;
        }
        eatingAnimationState.stop();

        // BEGGING STATE
        if (this.isBegging()) {
            idleAnimationState.stop();
            sittingAnimationState.stop();
            eatingAnimationState.stop();
            sleepingAnimationState.stop();

            if (!begAnimationState.isRunning()) {
                begAnimationState.start(this.age);
            }
            return;
        }
        begAnimationState.stop();

        //SITTING STATE
        boolean sitting = this.isInSittingPose();

        if (sitting) {
            idleAnimationState.stop();

            if (!sittingAnimationState.isRunning()) {
                sittingAnimationState.start(this.age);
            }
        } else {
            sittingAnimationState.stop();

            if (!idleAnimationState.isRunning()) {
                idleAnimationState.start(this.age);
            }
        }
    }


    /* ---------------- TICKING ---------------- */

    @Override
    public void tick() {

        super.tick();


        //PANIC TICKS
        if (this.dataTracker.get(DATA_PANIC_MODE)) {
            panicTicks--;

            if (panicTicks <= 0) {
                panicTicks = 0;
                this.dataTracker.set(DATA_PANIC_MODE, false);

                if (!this.getEntityWorld().isClient()) {
                    log.info("Raccoon panic mode ended");
                }
            }
        }
        //BUFF TICKS
        if (!this.getEntityWorld().isClient() && hasTamedBuff) {
            tamedBuffTicks--;

            if (tamedBuffTicks <= 0) {
                hasTamedBuff = false;

                this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
                        .setBaseValue(10.0D);

                if (this.getHealth() > 10.0F) {
                    this.setHealth(10.0F);
                }

                this.dataTracker.set(DATA_FULLNESS, 0);

                if (!this.getEntityWorld().isClient()) {
                    log.info("Tamed raccoon fullness buff expired");
                }
            }
        }

        //EATING TICKS
        if(this.eatingCooldown > 0){
            this.eatingCooldown--;
        }
        if(this.eatingTicks > 0){
            this.eatingTicks--;

            // Stop navigation while eating
            if (!this.getEntityWorld().isClient()) {
                this.getNavigation().stop();
            }

            //eating effects timeline
            int elapsed = EATING_ANIMATION_DURATION - this.eatingTicks;
            if(elapsed >= EATING_SOUND_START && elapsed <= EATING_SOUND_END){
                if(elapsed % 5 == 0 ){
                    eatingEffect(currentEatingStack);
                }
            }

            if(elapsed == BURP_TICK){
                playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, 1.0F);
            }
            //finish eating
            if(this.eatingTicks == 0 && !this.getEntityWorld().isClient()){
                this.dataTracker.set(DATA_EATING, false);
                this.setBegging(false);
                this.currentEatingStack = ItemStack.EMPTY;

                increaseFullness();
            }
        }


        // TAMED RACCOON FULLNESS COOLDOWN TICKS
        if (this.isTamed() && this.fullnessCooldownTicks > 0) {
            this.fullnessCooldownTicks--;

            // End of buff period
            if (fullnessCooldownTicks == 0) {
                this.dataTracker.set(DATA_FULLNESS, 0);
                if (!this.getEntityWorld().isClient()) {
                    log.info("Tamed raccoon fullness reset after resistance period");
                }
            }
        }

        // SLEEP SEARCHING TICKS
        if (!this.getEntityWorld().isClient()
                && !this.isTamed()
                && this.isFull()
                && !this.isSleeping()
                && !this.isPanic()) {

            fullSleepSearchTicks++;

            if (fullSleepSearchTicks >= FULL_SLEEP_SEARCH_TICKS) {
                resetFullnessFromSleepFailure();
                fullSleepSearchTicks = 0;
            }
        } else {
            // Reset timer if not in valid searching state
            fullSleepSearchTicks = 0;
        }

        //SLEEPING TICKS

        if (!this.getEntityWorld().isClient() && this.isSleeping() && !this.isTamed()) {
            this.sleepTicks++;

            if (this.sleepTicks >= SLEEP_DURATION_TICKS) {
                wakeNatural();
            }
        }

        // freeze while sleeping
        if (this.isSleeping() && !this.isTamed()) {
            float prevYaw = this.getYaw();
            float prevHeadYaw = this.getHeadYaw();
            float prevBodyYaw = this.getBodyYaw();

            this.getNavigation().stop();
            this.setVelocity(0.0, this.getVelocity().y, 0.0);
            this.velocityDirty = true;

            this.setYaw(prevYaw);
            this.setHeadYaw(prevHeadYaw);
            this.setBodyYaw(prevBodyYaw);
        }


        if (this.getEntityWorld().isClient()) {
            this.setupAnimationStates();
        }
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

    /* ---------------- TAMING RACCOON ---------------- */
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {

        if (isSleeping()) {
            // ignore interactions while sleeping
            return ActionResult.PASS;
        }

        ItemStack itemStack = player.getStackInHand(hand);

        //RACCOON TAMING
        if (!this.isTamed() && (itemStack.isOf(ModItems.RAW_CRAWFISH) || itemStack.isOf(ModItems.COOKED_CRAWFISH))) {
            if(!this.getEntityWorld().isClient()) {
                itemStack.decrementUnlessCreative(1, player);
                this.tryTame(player, itemStack);
            }
            return ActionResult.SUCCESS;
        }

        if (this.isTamed()) {

            //RACCOON HEALING
            if (RACCOON_TEMPT_INGREDIENT.test(itemStack)
                    && this.getHealth() < this.getMaxHealth()) {

                this.eat(player, hand, itemStack);
                this.eatingEffect(itemStack);

                FoodComponent foodComponent = itemStack.get(DataComponentTypes.FOOD);
                float f = foodComponent != null ? foodComponent.nutrition() : 1.0F;
                this.heal(2.0F * f);
                this.playSound(ModSounds.RACCOON_EATS, 0.7F, 1.1F);

                return ActionResult.SUCCESS;
            }

            //BREEDING @ FULL HEALTH ONLY
            ActionResult actionResult = super.interactMob(player, hand);

            //OWNER SITTING & STANDING
            if (!actionResult.isAccepted() && this.isOwner(player)) {
                this.setSitting(!this.isSitting());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
                return ActionResult.SUCCESS.noIncrementStat();
            }

            return actionResult;
        }

        return super.interactMob(player, hand);
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
        this.dataTracker.set(DATA_EATING, true);
        this.setBegging(false);
        this.currentEatingStack = stack.copyWithCount(1);
        this.eatingTicks = EATING_ANIMATION_DURATION;
        this.getNavigation().stop();
    }

    //item eating eligibility helper
    public boolean canEatItem(ItemStack itemStack) {

        return RACCOON_TEMPT_INGREDIENT.test(itemStack);
    }

    //item eating cooldown helper
    public boolean canEatDroppedFood() {

        if(!this.isTamed()) return this.eatingCooldown <= 0 && !this.isSleeping();

        return this.eatingCooldown <= 0 && fullnessCooldownTicks == 0;
    }

    //item eating cooldown reset helper
    public void resetEatCooldown() {
        this.eatingCooldown = EATING_COOLDOWN_TICKS;
    }

    public boolean isEating() {
        return this.dataTracker.get(DATA_EATING);
    }


    //EAT DROPPED ITEM METHOD:
    public void consumeDroppedFood(ItemEntity itemEntity) {
        if (this.getEntityWorld().isClient()) return;

        if(this.eatingCooldown > 0) return;
        if (this.isInSittingPose()) return;
        if (this.isFull()) return;

        ItemStack itemStack = itemEntity.getStack();

        this.startEating(itemStack);

        this.resetEatCooldown();


        // Remove 1 item
        itemStack.decrement(1);
        if (itemStack.isEmpty()) {
            itemEntity.discard();
        }

        // Heal when not full health
        if (this.getHealth() < this.getMaxHealth()) {
            FoodComponent food = itemStack.get(DataComponentTypes.FOOD);
            float nutrition = food != null ? food.nutrition() : 1.0F;
            this.heal(2.0F * nutrition);
        }
    }

    /* ---------------- FULLNESS HELPERS ---------------- */
    public int getFullness(){
        return this.dataTracker.get(DATA_FULLNESS);
    }

    public boolean isFull(){
        return getFullness() >= MAX_FULLNESS;
    }

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

            this.getAttributeInstance(EntityAttributes.MAX_HEALTH)
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
        return this.dataTracker.get(DATA_PANIC_MODE);
    }

    public boolean isSleeping() {
        return this.dataTracker.get(DATA_SLEEPING);
    }

    /* ---------------- START SLEEPING METHOD ---------------- */
    public void startSleeping() {

        if(!canSleepHere()) return;

        this.sleepTicks = 0;
        this.fullSleepSearchTicks = 0;
        this.dataTracker.set(DATA_SLEEPING, true);
        this.setSitting(false);
        this.getNavigation().stop();
        this.setVelocity(0, this.getVelocity().y, 0);
    }
    /* ---------------- SLEEP SEARCH METHOD---------------- */
    public boolean canSleepHere() {
        if (this.isTamed()) return false;
        if (this.dataTracker.get(DATA_PANIC_MODE)) return false;
        if (!this.isFull()) return false;

        int light = this.getEntityWorld().getLightLevel(this.getBlockPos());
        return light <= MAX_SLEEP_LIGHT;
    }

    /* ---------------- WAKING METHOD ---------------- */
    //RACCOON SLEEP WAKE
    public void wakeNatural() {
        if(!isSleeping()) return;

        this.sleepTicks = 0;
        this.dataTracker.set(DATA_SLEEPING, false);

        // Fully rested : reset fullness & timer
        this.dataTracker.set(DATA_FULLNESS, 0);
        this.fullSleepSearchTicks = 0;

        this.getNavigation().stop();
        this.velocityDirty = false;

        if (!this.getEntityWorld().isClient()) {
            log.info("Raccoon woken, fullness reset");
        }
    }

    //RACCOON SLEEP INTERRUPTED
    public void wakeInterrupted(){
        if(!isSleeping()) return;

        sleepTicks = 0;
        dataTracker.set(DATA_SLEEPING, false);

        this.fullSleepSearchTicks = 0;

        getNavigation().stop();
        velocityDirty = false;

        if (!getEntityWorld().isClient()) {
            log.info("Raccoon woke due to interruption, fullness preserved");
        }
    }
    /* ---------------- WAKE WHEN DAMAGE ---------------- */
    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        boolean result = super.damage(world, source, amount);

        if (result) {
            // Enter panic mode
            wakeInterrupted();
            this.dataTracker.set(DATA_PANIC_MODE, true);
            this.panicTicks = PANIC_TICKS;
        }

        return result;
    }
    /* ---------------- FULLNESS RESET ---------------- */
    public void resetFullnessFromSleepFailure() {
        if (this.isSleeping()) return;

        this.dataTracker.set(DATA_FULLNESS, 0);

        if (!this.getEntityWorld().isClient()) {
            log.info("Raccoon failed to find sleep spot — fullness reset");
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

            this.playSound(SoundEvents.ENTITY_FOX_AGGRO, 1.0F, 1.0F);
        }
    }

    /* ---------------- BEGGING HELPERS ---------------- */
    public boolean isBegging() {
        return this.dataTracker.get(DATA_BEGGING);
    }

    public void setBegging(boolean begging) {
        if(begging && this.isEating()) return;
        this.dataTracker.set(DATA_BEGGING, begging);
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

        if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.TAIGA)) {
            return random.nextBoolean()
                    ? RaccoonVariant.DEFAULT
                    : RaccoonVariant.GRAY;

        } else if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.FOREST)) {
            return random.nextBoolean()
                    ? RaccoonVariant.GRAY
                    : RaccoonVariant.BROWN;

        } else if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.SWAMP)) {
            return RaccoonVariant.SWAMP;

        } else {return RaccoonVariant.DEFAULT;}
    }
}