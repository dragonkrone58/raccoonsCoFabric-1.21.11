package net.racquo.raccoonsCo.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BOILED_EGG =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();

    public static final FoodComponent RAW_CRAWFISH =
            new FoodComponent.Builder().nutrition(3).saturationModifier(0.1f).build();

    public static final FoodComponent COOKED_CRAWFISH =
            new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build();

}
