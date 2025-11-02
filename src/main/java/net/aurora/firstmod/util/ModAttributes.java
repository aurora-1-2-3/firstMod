package net.aurora.firstmod.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.neoforge.registries.DeferredRegister;


import static net.aurora.firstmod.FirstMod.MOD_ID;

public class ModAttributes{
    public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister.create(
            BuiltInRegistries.ATTRIBUTE, MOD_ID);


}
