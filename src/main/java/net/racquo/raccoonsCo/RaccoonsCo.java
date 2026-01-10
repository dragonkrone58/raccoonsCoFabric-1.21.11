package net.racquo.raccoonsCo;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;
import net.racquo.raccoonsCo.item.ModItems;
import net.racquo.raccoonsCo.sound.ModSounds;
import net.racquo.raccoonsCo.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;
public class RaccoonsCo implements ModInitializer {
	public static final String MOD_ID = "raccoonsco";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModWorldGeneration.generateModWorldGen();
        ModSounds.registerSounds();
        ModEntities.registerModEntities();

        FabricDefaultAttributeRegistry.register(ModEntities.RACCOON, RaccoonEntity.createAttributes());

	}
}