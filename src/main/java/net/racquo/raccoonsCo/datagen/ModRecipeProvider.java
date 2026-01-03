package net.racquo.raccoonsCo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
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
                List<ItemConvertible> BOILED_EGG_COOKABLES = List.of(Items.EGG, Items.BLUE_EGG, Items.BROWN_EGG);

                offerSmelting(BOILED_EGG_COOKABLES, RecipeCategory.FOOD, ModItems.BOILED_EGG, 0.25f, 140, "boiled_egg");

                for (ItemConvertible item : BOILED_EGG_COOKABLES) {
                    offerFoodCookingRecipe( "campfire",
                            RecipeSerializer.CAMPFIRE_COOKING,
                            CampfireCookingRecipe::new,
                            100,
                            item,
                            ModItems.BOILED_EGG,
                            0.25f);
                    offerFoodCookingRecipe( "smoking",
                            RecipeSerializer.SMOKING,
                            SmokingRecipe::new,
                            100,
                            item,
                            ModItems.BOILED_EGG,
                            0.25f);



                }



            }
        };

    }



    @Override
    public String getName() {
        return "RaccoonsCoModRecipeProvider";
    }
}
