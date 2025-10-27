package net.aurora.firstmod.effect;

import net.aurora.firstmod.FirstMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Mob;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECT =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, FirstMod.MODID);


    public static final Holder<MobEffect> STUMPED_EFFECT = MOB_EFFECT.register("stumped",
    () -> new StumpedEffect(MobEffectCategory.NEUTRAL, 0x8B4513));




    public static void register(IEventBus eventBus){
        MOB_EFFECT.register(eventBus);
    }
}
