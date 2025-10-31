package net.aurora.firstmod;

import com.mojang.logging.LogUtils;
import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.components.ModDataComponents;
import net.aurora.firstmod.effect.ModMobEffects;
import net.aurora.firstmod.items.ModCreativeModeTab;
import net.aurora.firstmod.items.ModItems;
import net.aurora.firstmod.items.ModPotions;
import net.aurora.firstmod.util.ModAttributes;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(FirstMod.MOD_ID)
public class FirstMod {
    public static final String MOD_ID = "firstmod";
    public static final Logger LOGGER = LogUtils.getLogger();

     static final List<DeferredRegister<?>> REGISTERS = List.of(
            ModBlocks.REGISTRY,
            ModItems.REGISTRY,
            ModPotions.REGISTRY,
            ModMobEffects.REGISTRY,
            ModDataComponents.REGISTRY,
            ModAttributes.REGISTRY,
            ModCreativeModeTab.REGISTRY
     );

    public FirstMod(IEventBus modEventBus, ModContainer modContainer) {
        for (var register : REGISTERS) {
            register.register(modEventBus);
        }


        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }



    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }





}
