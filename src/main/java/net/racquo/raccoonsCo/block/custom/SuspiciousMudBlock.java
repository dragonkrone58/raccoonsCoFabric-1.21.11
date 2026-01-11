package net.racquo.raccoonsCo.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.state.property.BooleanProperty;

import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.text.StyleSpriteSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.racquo.raccoonsCo.sound.ModSounds;
/*
    NEXT STEPS: MAKE SURE IT DOES NOT BREAK WHEN PLACED NEAR / IN WATER
 */

public class SuspiciousMudBlock extends Block implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private static final VoxelShape FALLING_SHAPE = VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.9F, 1.0);

    public SuspiciousMudBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) || super.isSideInvisible(state, stateFrom, direction);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED)
                ? Fluids.WATER.getStill(false)
                : super.getFluidState(state);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());

        return this.getDefaultState()
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random
    ) {
        if (state.get(WATERLOGGED)) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random);
    }

    private static boolean isEntityPartiallyInside(BlockPos pos, Entity entity) {
        return entity.getBoundingBox().intersects(
                new net.minecraft.util.math.Box(pos)
        );
    }



    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos,
                                     Entity entity, EntityCollisionHandler handler, boolean bl) {

        if (!(entity instanceof PlayerEntity player)) return;

        // Check leather boots
        boolean hasLeatherBoots = player.getEquippedStack(EquipmentSlot.FEET).getItem() == Items.LEATHER_BOOTS;

        // If wearing leather boots, skip sinking/slowdown
        if (hasLeatherBoots) return;

        // Only apply sinking/slowdown if partially inside the mud block
        if (isEntityPartiallyInside(pos, entity)) {

            player.setSprinting(false);

            // Strong horizontal slowdown
            entity.setVelocity(entity.getVelocity().multiply(0.2, 0.4, 0.2));

            // Waterlogged behavior
            if (state.get(WATERLOGGED)) {
                Vec3d velocity = entity.getVelocity();
                if (velocity.y > 0) entity.setVelocity(velocity.x, 0.01, velocity.z);
                entity.addVelocity(0.0, -0.03, 0.0);
            }

            // Step sounds
            if ((player.isMovingHorizontally() || player.isJumping()) && player.age % 18 == 0) {
                world.playSound(
                        null,
                        entity.getBlockPos(),
                        ModSounds.SUSPICIOUS_MUD_STEP,
                        entity.getSoundCategory(),
                        0.6F,
                        0.9F + world.random.nextFloat() * 0.2F
                );
            }

            // Suffocation if head inside
            if (!world.isClient() && world instanceof ServerWorld serverWorld) {
                BlockPos headPos = BlockPos.ofFloored(entity.getX(), entity.getEyeY(), entity.getZ());
                if (serverWorld.getBlockState(headPos).isOf(this)) {
                    player.damage(serverWorld, serverWorld.getDamageSources().drown(), 0.75f);
                }
            }
        }
    }

    //TAKEN FROM POWDERED SNOW -W-

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
        if (!(fallDistance < 4.0) && entity instanceof LivingEntity livingEntity) {
            LivingEntity.FallSounds fallSounds = livingEntity.getFallSounds();
            SoundEvent soundEvent = fallDistance < 7.0 ? fallSounds.small() : fallSounds.big();
            entity.playSound(soundEvent, 1.0F, 1.0F);
            entity.playSound(ModSounds.SUSPICIOUS_MUD_STEP, 1.0F, 1.0F);
        }
    }

    @Override
    protected VoxelShape getInsideCollisionShape(BlockState state, BlockView world, BlockPos pos, Entity entity) {
        VoxelShape voxelShape = this.getCollisionShape(state, world, pos, ShapeContext.of(entity));
        return voxelShape.isEmpty() ? VoxelShapes.fullCube() : voxelShape;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (!context.isPlacement() && context instanceof EntityShapeContext entityShapeContext) {
            Entity entity = entityShapeContext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5) {
                    return FALLING_SHAPE;
                }

                boolean bl = entity instanceof FallingBlockEntity;
                if (bl || context.isAbove(VoxelShapes.fullCube(), pos, false) && !context.isDescending()) {
                    return super.getCollisionShape(state, world, pos, context);
                }
            }
        }

        return VoxelShapes.empty();
    }

    @Override
    protected VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }
}