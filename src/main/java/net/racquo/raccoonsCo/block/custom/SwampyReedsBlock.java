package net.racquo.raccoonsCo.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.racquo.raccoonsCo.sound.ModSounds;

public class SwampyReedsBlock extends TallPlantBlock {
    public SwampyReedsBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, boolean bl) {
            super.onEntityCollision(state, world, pos, entity, handler, bl);


        // Only trigger for players
        if (entity instanceof PlayerEntity player) {
            // Only play occasionally, avoid spamming
            if (!world.isClient() && player.isMovingHorizontally() && player.age % 15 == 0) { // roughly once per second
                world.playSound(
                        null,
                        pos,
                        ModSounds.REED_RUSTLE,
                        SoundCategory.BLOCKS,
                        0.3f, // lower volume for subtle rustle
                        1.0f + world.random.nextFloat() * 0.2f // slight pitch variation
                );
            }
        }
    }

}
