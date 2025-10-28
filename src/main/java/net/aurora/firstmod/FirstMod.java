package net.aurora.firstmod;

import com.mojang.logging.LogUtils;
import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.components.ModDataComponents;
import net.aurora.firstmod.effect.ModEffects;
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
import java.util.UUID;

@Mod(FirstMod.MOD_ID)
public class FirstMod {
    public static final String MOD_ID = "firstmod";
    public static final Logger LOGGER = LogUtils.getLogger();

     static final List<DeferredRegister<?>> REGISTERS = List.of(
            ModBlocks.REGISTRY,
            ModItems.REGISTRY,
            ModPotions.REGISTRY,
            ModEffects.REGISTRY,
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

    public static ResourceLocation ID(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static final String PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID = "72551fd8-ec05-4009-ae5f-fdfe492da7e4";
    public static final String PLAYER_SWEEP_DAMAGE_RATIO_MODIFIER_ID = "3a6aa20c-2f42-4397-b0c0-57aedcc23d24";
    public static final String PLAYER_SWEEP_HITBOX_MODIFIER_ID = "f6c776c9-ca44-4336-a905-5c84b3625285";


}
