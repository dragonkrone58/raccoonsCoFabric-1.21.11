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
import net.racquo.raccoonsCo.entity.ai.RaccoonEatFoodGoal;
import net.racquo.raccoonsCo.entity.ai.RaccoonFollowParentGoal;
import net.racquo.raccoonsCo.entity.ai.RaccoonSleepGoal;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.sound.ModSounds;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import net.minecraft.util.math.random.Random;


public class RaccoonEntity extends TameableEntity {

    private static final Logger log = LoggerFactory.getLogger(RaccoonEntity.class);
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sittingAnimationState = new AnimationState();
    public final AnimationState eatingAnimationState = new AnimationState();
    public final AnimationState sleepingAnimationState = new AnimationState();

    private ItemStack currentEatingStack;
    private int eatingTicks = 0;
    private int eatingCooldown = 0;
    private static final TrackedData<Boolean> DATA_EATING =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final int EATING_COOLDOWN_TICKS = 200;
    private static final int EATING_ANIMATION_DURATION = 70;
    private static final int EATING_SOUND_START = 20;
    private static final int EATING_SOUND_END = 50;
    private static final int BURP_TICK = 60;

    private static final int MAX_FULLNESS = 3;
    private static final TrackedData<Integer> DATA_FULLNESS =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);


    private static final int MIN_SLEEP_TICKS = 20 * 60 * 2; // 2 minutes
    private static final int MAX_SLEEP_TICKS = 20 * 60 * 5; // 5 minutes
    private static final int MAX_SLEEP_LIGHT = 11;
    private static final TrackedData<Boolean> DATA_SLEEPING =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private int sleepTicks = 0;

    //LIST OF FOOD ITEMS RACCOONS WILL EAT

    private static final List<ItemConvertible> RACCOON_EATABLES =
            List.of(ModItems.BOILED_EGG, Items.SWEET_BERRIES, Items.COOKIE, Items.APPLE, Items.MELON_SLICE,
                Items.GLOW_BERRIES, Items.PUMPKIN_PIE, Items.POTATO, Items.BAKED_POTATO, Items.SALMON, Items.COOKED_SALMON,
                    Items.COD, Items.COOKED_COD, Items.CHICKEN, Items.COOKED_CHICKEN);
    private static final Ingredient RACCOON_TEMPT_INGREDIENT = Ingredient.ofItems(RACCOON_EATABLES.toArray(ItemConvertible[]::new));


    //LIST OF RARE RACCOON VARIANTS
    private static final RaccoonVariant[] RARE_VARIANTS = {
            RaccoonVariant.BLACK,
            RaccoonVariant.ALBINO
    };

    //LIST OF UNCOMMON RACCOON VARIANTS
    private static final RaccoonVariant[] UNCOMMON_VARIANTS = {
            RaccoonVariant.BLOND,
            RaccoonVariant.CINNAMON,
    };

    //DATA TRACKER FOR RACCOON VARIANT
    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);


    //RACCOON CONSTRUCTOR
    public RaccoonEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);

    }

    /*
        RACCOON ENTITY GOALS
     */
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new TameableEntity.TameableEscapeDangerGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new EscapeDangerGoal(this, 1.6));
        this.goalSelector.add(4, new RaccoonSleepGoal(this));
        this.goalSelector.add(5, new FollowOwnerGoal(this, 1.2, 10.0F, 2.0F));

        this.goalSelector.add(6, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(7, new RaccoonEatFoodGoal(this));
        this.goalSelector.add(8, new TemptGoal(this, 1.25D,
                RACCOON_TEMPT_INGREDIENT, false));


        this.goalSelector.add(9, new RaccoonFollowParentGoal(this, 1.1D));

        this.goalSelector.add(10, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(11, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(12, new LookAroundGoal(this));


    }

    /*
        RACCOON ENTITY ATTRIBUTES
     */

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.FOLLOW_RANGE, 32.0D)
                .add(EntityAttributes.TEMPT_RANGE, 12)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 5.0F);
                //.add(EntityAttributes.WAYPOINT_TRANSMIT_RANGE, 1.0D)
                //MAY BE USEFUL FOR COONSKIN CAP mechanic
    }


    /*
        RACCOON ANIMATION STATES
    */

    private void setupAnimationStates() {

        // sleeping state
        if (this.isSleeping()) {
            idleAnimationState.stop();
            sittingAnimationState.stop();
            eatingAnimationState.stop();

            if (!sleepingAnimationState.isRunning()) {
                sleepingAnimationState.start(this.age);
            }
            return;
        }

        sleepingAnimationState.stop();

        //eating state
        if(this.dataTracker.get(DATA_EATING)) {
            idleAnimationState.stop();
            sittingAnimationState.stop();

            if(!eatingAnimationState.isRunning()){
                eatingAnimationState.start(this.age);
            }
            return;
        }

        eatingAnimationState.stop();

        boolean sitting = this.isInSittingPose();

        //sitting state
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


    @Override
    public void tick() {
        super.tick();

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
                if(elapsed % 4 == 0 ){
                    eatingEffect(currentEatingStack);
                }

            }

            if(elapsed == BURP_TICK){
                playSound(SoundEvents.ENTITY_PLAYER_BURP, 1.0F, 1.0F);
            }

            if(this.eatingTicks == 0 && !this.getEntityWorld().isClient()){
                this.dataTracker.set(DATA_EATING, false);
                this.currentEatingStack = ItemStack.EMPTY;
            }
        }
        if (isSleeping()) {
            this.sleepTicks++;

            boolean isNight = this.getEntityWorld().isNight();

            // Minimum sleep enforced
            if (sleepTicks < MIN_SLEEP_TICKS) {
                return;
            }

            // Wake rules
            if (isNight) {
                stopSleeping();
                return;
            }

            if (sleepTicks >= MAX_SLEEP_TICKS) {
                stopSleeping();
                return;
            }
        }


        if (this.getEntityWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    /* DATA TRACKER  */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
        builder.add(DATA_EATING, false);
        builder.add(DATA_FULLNESS, 0);
        builder.add(DATA_SLEEPING, false);
    }


    /*
        RACCOON CHILD CREATOR
    */

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        RaccoonEntity baby = ModEntities.RACCOON.create(world, SpawnReason.BREEDING);
        if (baby == null) return null;

        RegistryKey<Biome> biomeKey =
                world.getBiome(this.getBlockPos()).getKey().orElse(null);

        baby.setVariant(pickVariant(this.random, biomeKey));

        return baby;
    }



    /*
        TAMING & MOB INTERACTION
    */

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {

        ItemStack itemStack = player.getStackInHand(hand);

        //RACCOON TAMING
        if (!this.isTamed() && itemStack.isOf(Items.SWEET_BERRIES)) {
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
                this.playSound(ModSounds.RACCOON_EATS, 1.0F, 1.0F);

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

    /*
        RACCOON TAMING ENTITY ATTEMPT
     */
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

    /*
        BREEDING
     */
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return this.isTamed() && this.getHealth() >= this.getMaxHealth()
                && RACCOON_TEMPT_INGREDIENT.test(stack);
    }

    /*
        EATING PARTICLE & SOUND EFFECTS
     */

   private void eatingEffect(ItemStack itemStack){
       this.playSound(ModSounds.RACCOON_EATS, 1.0F, 0.8F);

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

    /*
        EATING DROPPED ITEMS HELPERS
    */

    //item eating eligibility helper
    public boolean canEatItem(ItemStack itemStack) {
        return RACCOON_TEMPT_INGREDIENT.test(itemStack);
    }

    //item eating cooldown helper
    public boolean canEatDroppedFood() {
        return this.eatingCooldown <= 0 && !this.isSleeping() && !this.isFull();
    }

    //item eating cooldown reset helper
    public void resetEatCooldown() {
        this.eatingCooldown = EATING_COOLDOWN_TICKS;
    }

    //item eating method

    public void consumeDroppedFood(ItemEntity itemEntity) {
        if (this.getEntityWorld().isClient()) return;
        if (this.isInSittingPose()) return;
        if (this.isFull()) return;

        ItemStack itemStack = itemEntity.getStack();


        this.getNavigation().stop();
        this.eatingTicks = EATING_ANIMATION_DURATION;
        this.dataTracker.set(DATA_EATING, true);
        this.currentEatingStack = itemStack.copyWithCount(1);


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
        increaseFullness();
        this.resetEatCooldown();
    }

    /*
        FULLNESS HELPERS
     */
    public int getFullness(){
        return this.dataTracker.get(DATA_FULLNESS);
    }

    public boolean isFull(){
        return getFullness() >= MAX_FULLNESS;
    }

    public void increaseFullness(){
        if(!isFull()){
            int before = getFullness();
            int after = before + 1;
            this.dataTracker.set(DATA_FULLNESS, this.getFullness() + 1);

            if (!this.getEntityWorld().isClient()) {
                log.info("Raccoon fullness increased: {} -> {}", before, after);
            }
        }
    }

    /*
        SLEEPING HELPERS
     */

    public boolean isSleeping() {
        return this.dataTracker.get(DATA_SLEEPING);
    }

    public void startSleeping() {

        if(!canSleepHere()) return;

        this.sleepTicks = 0;
        this.dataTracker.set(DATA_SLEEPING, true);
        this.getNavigation().stop();
        this.setVelocity(0, this.getVelocity().y, 0);

        this.setPose(EntityPose.SLEEPING);

        if (!this.getEntityWorld().isClient()) {
            log.info("Raccoon started sleeping at light level {}",
                    this.getEntityWorld().getLightLevel(this.getBlockPos()));
        }
    }

    public boolean canSleepHere() {
        if (!this.isFull()) return false;

        // tamed raccoons must already be sitting
        if (this.isTamed() && !this.isInSittingPose()) return false;

        int light = this.getEntityWorld().getLightLevel(this.getBlockPos());
        return light <= MAX_SLEEP_LIGHT;
    }

    public void stopSleeping() {
        this.sleepTicks = 0;
        this.dataTracker.set(DATA_SLEEPING, false);

        // reset fullness on wake
        if (!this.getEntityWorld().isClient()) {
            log.info("Raccoon woke up, fullness reset from {} to 0", getFullness());
        }
        this.dataTracker.set(DATA_FULLNESS, 0);

        this.setPose(this.isInSittingPose() ? EntityPose.SITTING : EntityPose.STANDING);
    }


    /*
        SOUNDS
     */


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.RACCOON_IDLE;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.RACCOON_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.RACCOON_DEATH;
    }


    /*
        VARIANT METHODS
     */

    public RaccoonVariant getVariant(){
        return RaccoonVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant(){
        return this.dataTracker.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(RaccoonVariant variant){
        this.dataTracker.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

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

    private static RaccoonVariant pickVariant(Random random, @Nullable RegistryKey<Biome> biomeKey){
        if(random.nextFloat() < 0.02F){
            return Util.getRandom(RARE_VARIANTS, random);
        }

        if(random.nextFloat() < 0.1F){
            return Util.getRandom(UNCOMMON_VARIANTS, random);
        }

        if(biomeKey == null){
            return RaccoonVariant.DEFAULT;
        }

        if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.TAIGA)) {
            return random.nextBoolean()
                    ? RaccoonVariant.DEFAULT
                    : RaccoonVariant.GRAY;

        } else if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.FOREST)) {
            return random.nextBoolean()
                    ? RaccoonVariant.GRAY
                    : RaccoonVariant.BROWN;

        } else if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.SWAMP)) {
            return random.nextBoolean()
                    ? RaccoonVariant.SWAMP
                    : RaccoonVariant.DEFAULT;

        } else {
            // Fallback for other biomes
            return RaccoonVariant.DEFAULT;
        }
    }


    /*
        INITIALISE RACCOON
     */
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {
        RegistryKey<Biome> biomeKey =
                world.getBiome(this.getBlockPos()).getKey().orElse(null);
        setVariant(pickVariant(this.random, biomeKey));

        return super.initialize(world, difficulty, spawnReason, entityData);
    }
}
