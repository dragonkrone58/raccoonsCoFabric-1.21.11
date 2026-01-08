package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.racquo.raccoonsCo.block.ModBlocks;
import net.racquo.raccoonsCo.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate(){
                List<ItemConvertible> BOILED_EGG_COOKABLES = List.of(Items.EGG, Items.BLUE_EGG, Items.BROWN_EGG, Items.TURTLE_EGG);

                offerSmelting(BOILED_EGG_COOKABLES, RecipeCategory.FOOD, ModItems.BOILED_EGG, 0.25f, 140, "boiled_egg");

                //the offerFoodCookingRecipe is kinda scuffed sooo.... done manually in resources/data/.../recipe


                //marigold to orange dye recipe
                createShapeless(RecipeCategory.MISC, Items.ORANGE_DYE, 1)
                        .input(ModBlocks.MARIGOLD)
                        .criterion(hasItem(ModBlocks.MARIGOLD), conditionsFromItem(Items.ORANGE_DYE))
                        .offerTo(exporter);

                //violet to purple dye recipe
                createShapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                        .input(ModBlocks.VIOLET)
                        .criterion(hasItem(ModBlocks.VIOLET), conditionsFromItem(Items.PURPLE_DYE))
                        .offerTo(exporter);

                //lupine to magenta dye recipe
                createShapeless(RecipeCategory.MISC, Items.MAGENTA_DYE, 1)
                        .input(ModBlocks.LUPINE)
                        .criterion(hasItem(ModBlocks.LUPINE), conditionsFromItem(Items.MAGENTA_DYE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, Items.PINK_DYE, 1)
                        .input(ModBlocks.MILKWEED)
                        .criterion(hasItem(ModBlocks.MILKWEED), conditionsFromItem(Items.PINK_DYE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.RACCOON_PELT_HELMET)
                        .pattern("R")
                        .pattern("L")
                        .input('R', ModItems.RACCOON_PELT)
                        .input('L', Items.LEATHER_HELMET)
                        .criterion(hasItem(ModItems.RACCOON_PELT), conditionsFromItem(ModItems.RACCOON_PELT_HELMET))
                        .criterion(hasItem(Items.LEATHER_HELMET), conditionsFromItem(ModItems.RACCOON_PELT_HELMET))
                        .offerTo(exporter);

            }
        };

    }



    @Override
    public String getName() {
        return "RaccoonsCoModRecipeProvider";
    }
}
