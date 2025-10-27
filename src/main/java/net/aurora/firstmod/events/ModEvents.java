package net.aurora.firstmod.events;


import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.items.ModPotions;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

import java.util.List;


@SuppressWarnings("removal")
@EventBusSubscriber(modid = FirstMod.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {





    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        List<Item> logItems = List.of(
                Items.OAK_LOG,
                Items.SPRUCE_LOG,
                Items.BIRCH_LOG,
                Items.JUNGLE_LOG,
                Items.ACACIA_LOG,
                Items.DARK_OAK_LOG,
                Items.MANGROVE_LOG,
                Items.CHERRY_LOG,
                Items.BAMBOO_BLOCK,
                Items.CRIMSON_STEM,
                Items.WARPED_STEM
        );

        for (Item log : logItems) {
            builder.addMix(Potions.AWKWARD, log, ModPotions.STUMPED_POTION);
        }
    }
}
