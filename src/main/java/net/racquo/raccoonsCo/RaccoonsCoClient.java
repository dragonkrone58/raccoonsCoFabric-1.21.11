package net.racquo.raccoonsCo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.entity.ModEntities;
import net.racquo.raccoonsCo.entity.client.crawfish.CrawfishModel;
import net.racquo.raccoonsCo.entity.client.crawfish.CrawfishRenderer;
import net.racquo.raccoonsCo.entity.client.raccoon.RaccoonModel;
import net.racquo.raccoonsCo.entity.client.raccoon.RaccoonRenderer;
import net.racquo.raccoonsCo.entity.client.red_panda.RedPandaModel;
import net.racquo.raccoonsCo.entity.client.red_panda.RedPandaRenderer;


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
        BlockRenderLayerMap.putBlock(ModBlocks.SWAMPY_REEDS, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.SWAMP_GRASS, BlockRenderLayer.CUTOUT);

        EntityModelLayerRegistry.registerModelLayer(RaccoonModel.RACCOON, RaccoonModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RACCOON, RaccoonRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CrawfishModel.CRAWFISH, CrawfishModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CRAWFISH, CrawfishRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(RedPandaModel.RED_PANDA, RedPandaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.RED_PANDA, RedPandaRenderer::new);


    }
}
