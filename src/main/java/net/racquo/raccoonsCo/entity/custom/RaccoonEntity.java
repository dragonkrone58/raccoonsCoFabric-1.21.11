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
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.entity.ai.RaccoonFollowParentGoal;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.sound.ModSounds;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RaccoonEntity extends TameableEntity {

    private static final Logger log = LoggerFactory.getLogger(RaccoonEntity.class);
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState sittingAnimationState = new AnimationState();
    public final AnimationState eatingAnimationState = new AnimationState();

    private int eatingTicks = 0;



    private static final List<ItemConvertible> RACCOON_EATABLES =
            List.of(ModItems.BOILED_EGG, Items.SWEET_BERRIES, Items.COOKIE, Items.APPLE);
    private static final Ingredient RACCOON_TEMPT_INGREDIENT = Ingredient.ofItems(RACCOON_EATABLES.toArray(ItemConvertible[]::new));

    private static final RaccoonVariant[] RARE_VARIANTS = {
            RaccoonVariant.BLACK,
            RaccoonVariant.ALBINO
    };

    private static final RaccoonVariant[] UNCOMMON_VARIANTS = {
            RaccoonVariant.BLOND,
            RaccoonVariant.CINNAMON,
    };

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);


    public RaccoonEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);

    }

    /*
    ENTITY GOALS
     */
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new TameableEntity.TameableEscapeDangerGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.add(2, new SitGoal(this));
        this.goalSelector.add(3, new EscapeDangerGoal(this, 1.6));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 1.2, 10.0F, 2.0F));

        this.goalSelector.add(5, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(6, new TemptGoal(this, 1.25D,
                RACCOON_TEMPT_INGREDIENT, false));

        this.goalSelector.add(7, new RaccoonFollowParentGoal(this, 1.1D));

        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));


    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.TEMPT_RANGE, 12)
                .add(EntityAttributes.FALL_DAMAGE_MULTIPLIER, 0.5D);
                //.add(EntityAttributes.WAYPOINT_TRANSMIT_RANGE, 1.0D)
                //MAY BE USEFUL FOR COONSKIN CAP mechanic
    }


    //raccoon animation states

    private void setupAnimationStates() {

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


    @Override
    public void tick() {
        super.tick();

        if(this.eatingTicks > 0){
            this.eatingTicks--;
            if(this.eatingTicks == 0){
                this.eatingAnimationState.stop();
            }
        }

        if (this.getEntityWorld().isClient()) {
            this.setupAnimationStates();
        }
    }


    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return RACCOON_TEMPT_INGREDIENT.test(stack);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        RaccoonEntity baby = ModEntities.RACCOON.create(world, SpawnReason.BREEDING);
        RaccoonVariant variant = Util.getRandom(RaccoonVariant.values(), this.random);
        baby.setVariant(variant);
        return baby;
    }



    /* TAMING & MOB INTERACTION*/

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {

        ItemStack itemStack = player.getStackInHand(hand);

        if (this.isTamed()) {
            if (this.isBreedingItem(itemStack) && this.getHealth() < this.getMaxHealth()) {
                this.eat(player, hand, itemStack);
                this.eatingEffect(itemStack);
                FoodComponent foodComponent = itemStack.get(DataComponentTypes.FOOD);
                float f = foodComponent != null ? foodComponent.nutrition() : 1.0F;
                this.heal(2.0F * f);
                this.playSound(SoundEvents.ENTITY_FOX_EAT, 1.0F, 1.0F);
                return ActionResult.SUCCESS;
            }

            ActionResult actionResult = super.interactMob(player, hand);
            if (!actionResult.isAccepted() && this.isOwner(player)) {
                this.setSitting(!this.isSitting());
                this.jumping = false;
                this.navigation.stop();
                this.setTarget(null);
                return ActionResult.SUCCESS.noIncrementStat();
            }

            return actionResult;

        //tame raccoon with sweet berries
        } else if (!this.getEntityWorld().isClient() && itemStack.isOf(Items.SWEET_BERRIES)) {
            itemStack.decrementUnlessCreative(1, player);
            this.tryTame(player, itemStack);
            return ActionResult.SUCCESS_SERVER;
        }

        return super.interactMob(player, hand);
    }
    //the taming attempt method
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

   private void eatingEffect(ItemStack itemStack){
       this.playSound(SoundEvents.ENTITY_FOX_EAT, 1.0F, 0.8F);

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
        return SoundEvents.ENTITY_FOX_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_FOX_DEATH;
    }


    /* VARIANT */
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_ID_TYPE_VARIANT, 0);
    }

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

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {

        if(this.random.nextFloat() < 0.02F){
            setVariant(Util.getRandom(RARE_VARIANTS, this.random));
            return super.initialize(world, difficulty, spawnReason, entityData);
        }

        if(this.random.nextFloat() < 0.1F){
            setVariant(Util.getRandom(UNCOMMON_VARIANTS, this.random));
            return super.initialize(world, difficulty, spawnReason, entityData);
        }

        var biomeKey = world.getBiome(this.getBlockPos()).getKey().orElse(null);

        if(biomeKey == null){
            setVariant(RaccoonVariant.DEFAULT);
            return super.initialize(world, difficulty, spawnReason, entityData);
        }

        if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.TAIGA)) {
            setVariant(this.random.nextBoolean()
                    ? RaccoonVariant.DEFAULT
                    : RaccoonVariant.GRAY);

        } else if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.FOREST)) {
            setVariant(this.random.nextBoolean()
                    ? RaccoonVariant.GRAY
                    : RaccoonVariant.BROWN);

        } else if (biomeKey.equals(net.minecraft.world.biome.BiomeKeys.MANGROVE_SWAMP)) {
            setVariant(this.random.nextBoolean()
                    ? RaccoonVariant.SWAMP
                    : RaccoonVariant.DEFAULT);

        } else {
            // Fallback for other biomes
            setVariant(RaccoonVariant.DEFAULT);
        }

        return super.initialize(world, difficulty, spawnReason, entityData);
    }
}
