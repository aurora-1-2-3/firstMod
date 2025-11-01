package net.aurora.firstmod.effect;

import net.aurora.firstmod.FirstMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> REGISTRY =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, FirstMod.MOD_ID);


    public static final Holder<MobEffect> STUMPED_EFFECT = REGISTRY.register("stumped",
    () -> new StumpedEffect(MobEffectCategory.NEUTRAL, 0x8B4513));

    public static final Holder<MobEffect> TIDE_EFFECT = REGISTRY.register("tide",
            () -> new TideEffect(MobEffectCategory.BENEFICIAL, 0x00BFA5));

    public static final Holder<MobEffect> BULWARK_EFFECT = REGISTRY.register("bulwark",
            () -> new BulwarkEffect(MobEffectCategory.BENEFICIAL, 0x22253D));

}
