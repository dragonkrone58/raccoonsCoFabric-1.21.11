package net.racquo.raccoonsCo.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static final FoodComponent BOILED_EGG =
            new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();

    public static final FoodComponent RAW_CRAWFISH =
            new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).build();

    public static final FoodComponent COOKED_CRAWFISH =
            new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build();

    public static final ConsumableComponent RAW_CRAWFISH_CONSUMABLE =
            ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(
                    new StatusEffectInstance( StatusEffects.POISON, 140), 0.8f)).build();

}
