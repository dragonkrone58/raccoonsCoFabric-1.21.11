package net.racquo.raccoonsCo.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.entity.LivingEntity;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.racquo.raccoonsCo.sound.ModSounds;

import java.sql.SQLOutput;

public class SuspiciousMudBlock extends Block {

    private static final VoxelShape FALLING_SHAPE = VoxelShapes.cuboid(0.0, 0.0, 0.0, 1.0, 0.9F, 1.0);

    public SuspiciousMudBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        return stateFrom.isOf(this) ? true : super.isSideInvisible(state, stateFrom, direction);
    }


    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos,
                                     Entity entity, EntityCollisionHandler handler, boolean bl) {


        if (!(entity instanceof LivingEntity) || entity.getBlockStateAtPos().isOf(this)) {
            entity.slowMovement(state, new Vec3d(0.9F, 1.5, 0.9F));

            //only play when moving in mud
            if (entity.isMovingHorizontally() && entity.age % 18 == 0) {
                world.playSound(
                        null,
                        entity.getBlockPos(),
                        ModSounds.SUSPICIOUS_MUD_STEP,
                        entity.getSoundCategory(),
                        0.6F,
                        0.9F + world.random.nextFloat() * 0.2F
                );
            }


            if (!world.isClient() && world instanceof ServerWorld serverWorld
                    && entity instanceof LivingEntity living) {

                BlockPos headPos = BlockPos.ofFloored(entity.getX(), entity.getEyeY(), entity.getZ());

                // Suffocate only when fully submerged
                if (serverWorld.getBlockState(headPos).getBlock() == this) {
                    living.damage(
                            serverWorld,
                            serverWorld.getDamageSources().drown(),
                            1.0f
                    );
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