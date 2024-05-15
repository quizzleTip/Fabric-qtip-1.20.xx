package net.qtip.qtipmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent PEANUTBUTTER = new FoodComponent.Builder().nutrition(8).saturationModifier(0.9f).build();
    public static final FoodComponent PEANUTS = new FoodComponent.Builder().nutrition(3).saturationModifier(0.2f).build();
    public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f).build();
    public static final FoodComponent SWEETBERRYPIE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 6000, 1), 1f).build();
    public static final FoodComponent APPLEPIE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 12000,1), 1f).build();
    public static final FoodComponent GLOWBERRYPIE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000), 1f).build();
}
