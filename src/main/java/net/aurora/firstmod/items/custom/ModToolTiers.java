package net.aurora.firstmod.items.custom;

import net.aurora.firstmod.items.ModItems;
import net.aurora.firstmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier GALLIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_GALLIUM_TOOL,
            1400, 100f, 5f, 50, () -> Ingredient.of(ModItems.GALLIUM_INGOT));

}
