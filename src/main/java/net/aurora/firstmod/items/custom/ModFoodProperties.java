package net.aurora.firstmod.items.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GALLIUM_BREAD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4000, 4), 1f).build();

    public static final FoodProperties COOKED_AXOLOTL_EGG = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 4000, 4), 0.5f).build();

    public static final FoodProperties NEON_POTATO = new FoodProperties.Builder().nutrition(4).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1500, 1), 1F).build();
}
