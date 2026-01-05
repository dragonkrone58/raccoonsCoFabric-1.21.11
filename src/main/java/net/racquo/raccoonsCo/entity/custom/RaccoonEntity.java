package net.racquo.raccoonsCo.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.item.ModItems;
import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RaccoonEntity extends AnimalEntity {

    private static final Logger log = LoggerFactory.getLogger(RaccoonEntity.class);
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private static final TrackedData<Integer> DATA_ID_TYPE_VARIANT =
            DataTracker.registerData(RaccoonEntity.class, TrackedDataHandlerRegistry.INTEGER);


    public RaccoonEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
        this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItems(Items.SWEET_BERRIES), false));

        this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));


    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 10.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.25D)
                .add(EntityAttributes.FOLLOW_RANGE, 20.0D)
                .add(EntityAttributes.TEMPT_RANGE, 12);
                //.add(EntityAttributes.WAYPOINT_TRANSMIT_RANGE, 1.0D)
                //MAY BE USEFUL FOR COONSKIN CAP mechanic
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 2400;
            this.idleAnimationState.start(this.age);
        }else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getEntityWorld().isClient()) {
            this.setupAnimationStates();
        }
    }


    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.SWEET_BERRIES);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        RaccoonEntity baby = ModEntities.RACCOON.create(world, SpawnReason.BREEDING);
        RaccoonVariant variant = Util.getRandom(RaccoonVariant.values(), this.random);
        baby.setVariant(variant);
        return baby;
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
        RaccoonVariant variant = Util.getRandom(RaccoonVariant.values(), this.random);
        setVariant(variant);
        return super.initialize(world, difficulty, spawnReason, entityData);
    }
}
