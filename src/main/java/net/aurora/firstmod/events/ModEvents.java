package net.aurora.firstmod.events;


import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.items.ModPotions;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.List;


@SuppressWarnings("removal")
@EventBusSubscriber(modid = FirstMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
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

        builder.addMix(Potions.AWKWARD, Items.PRISMARINE_SHARD, ModPotions.TIDE_POTION);
        builder.addMix(Potions.AWKWARD, Items.HEART_OF_THE_SEA, ModPotions.GRACE_POTION);
        builder.addMix(Potions.AWKWARD, Items.FLINT, ModPotions.BULWARK_POTION);
    }


    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre livingDamageEvent){
        if(livingDamageEvent.getEntity() instanceof EnderMan enderman && livingDamageEvent.getSource().getDirectEntity() instanceof Player player){
            if(player.getOffhandItem().getItem() == Items.COOKED_CHICKEN) {
                player.displayClientMessage(Component.literal(player.getName().getString() + " was being racist. Here a "+player.getMainHandItem().getItem()),false);
                player.getMainHandItem().grow(1);
            }

        }

    }

}
