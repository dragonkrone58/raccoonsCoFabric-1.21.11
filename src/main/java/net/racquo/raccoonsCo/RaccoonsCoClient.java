package net.racquo.raccoonsCo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.world.chunk.ChunkSection;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.entity.client.RaccoonModel;
import net.racquo.raccoonsCo.entity.client.RaccoonRenderer;
import net.racquo.raccoonsCo.entity.custom.RaccoonEntity;

public class RaccoonsCoClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.putBlock(ModBlocks.MARIGOLD, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MARIGOLD_FLOWER_POT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VIOLET, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.VIOLET_FLOWER_POT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.LUPINE, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.LUPINE_FLOWER_POT, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MILKWEED, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.MILKWEED_FLOWER_POT, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(RaccoonModel.RACCOON, RaccoonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);


    }
}
