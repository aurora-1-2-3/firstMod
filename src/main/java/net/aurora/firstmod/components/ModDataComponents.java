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
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS =
            DeferredRegister.createDataComponents(FirstMod.MODID);


    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC));


    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
        UnaryOperator<DataComponentType.Builder<T>> builderOperator){

        return DATA_COMPONENTS.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }




    public static void register(IEventBus eventBus){
        DATA_COMPONENTS.register(eventBus);
    }

}
