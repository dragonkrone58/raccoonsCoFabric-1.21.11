package net.racquo.raccoonsCo.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.ConcretePowderBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ConcretePowderBlock.class)
public interface ConcretePowderBlockAccessor {

    @Accessor("hardenedState")
    Block raccoonsCo$getHardenedBlock();
}
