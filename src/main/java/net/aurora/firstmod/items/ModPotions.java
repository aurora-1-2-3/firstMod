package net.aurora.firstmod.items;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTION =
            DeferredRegister.create(BuiltInRegistries.POTION, FirstMod.MODID);

    public static final Holder<Potion> STUMPED_POTION = POTION.register("stumped_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.STUMPED_EFFECT, 1200, 0)));










    public static void register(IEventBus eventBus){
        POTION.register(eventBus);
    }

}
