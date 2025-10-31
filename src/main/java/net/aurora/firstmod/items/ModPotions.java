package net.aurora.firstmod.items;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.effect.ModMobEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> REGISTRY =
            DeferredRegister.create(BuiltInRegistries.POTION, FirstMod.MOD_ID);

    public static final Holder<Potion> STUMPED_POTION = REGISTRY.register("stumped_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.STUMPED_EFFECT, 1200, 0)));

    public static final Holder<Potion> TIDE_POTION = REGISTRY.register("tide_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.TIDE_EFFECT, 1200, 0)));

    public static final  Holder<Potion> GRACE_POTION = REGISTRY.register("grace_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 1200, 0)));

    public static final Holder<Potion> BULWARK_POTION = REGISTRY.register("bulwark_potion",
            () -> new Potion(new MobEffectInstance(ModMobEffects.BULWARK_EFFECT, 1200, 0)));

}
