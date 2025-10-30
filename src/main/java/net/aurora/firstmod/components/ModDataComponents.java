package net.aurora.firstmod.components;

import net.aurora.firstmod.FirstMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.UnaryOperator;


@SuppressWarnings("removal")
public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> REGISTRY =
            DeferredRegister.createDataComponents(FirstMod.MOD_ID);




    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC));


    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
        UnaryOperator<DataComponentType.Builder<T>> builderOperator){

        return REGISTRY.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

}
