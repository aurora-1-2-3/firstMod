package net.aurora.firstmod.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


import static net.aurora.firstmod.FirstMod.MODID;

public class ModAttributes{
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(
            BuiltInRegistries.ATTRIBUTE, MODID);


    public static final DeferredHolder<Attribute, Attribute> SWEEP_HITBOX = ATTRIBUTES.register("player.sweep_hitbox_sweep",
            () -> new RangedAttribute("attributes.firstmod.sweep_hitbox", 0.25D, 0.0D, 10.0D).setSyncable(true));









    public static void register(IEventBus eventBus){
        ATTRIBUTES.register(eventBus);

    }
}
