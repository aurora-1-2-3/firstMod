package net.aurora.firstmod;

import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.components.ModDataComponents;
import net.aurora.firstmod.items.ModCreativeModeTab;
import net.aurora.firstmod.items.ModItems;
import net.aurora.firstmod.util.ModAttributes;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FirstMod.MODID)
public class FirstMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "firstmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public FirstMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        ModCreativeModeTab.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModAttributes.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {


    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    public static ResourceLocation ID(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static final String PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID = "72551fd8-ec05-4009-ae5f-fdfe492da7e4";
    public static final String PLAYER_SWEEP_DAMAGE_RATIO_MODIFIER_ID = "3a6aa20c-2f42-4397-b0c0-57aedcc23d24";
    public static final String PLAYER_SWEEP_HITBOX_MODIFIER_ID = "f6c776c9-ca44-4336-a905-5c84b3625285";

}
