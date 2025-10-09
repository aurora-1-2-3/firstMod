package net.aurora.firstmod.items;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MODID);



  // java should fuck itself
    public static final Supplier<CreativeModeTab> GALLIUM_TAB = CREATIVE_MODE_TAB.register("gallium_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GALLIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.firstmod.gallium_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.GALLIUM_INGOT);
                        output.accept(ModItems.RAW_GALLIUM);
                        output.accept(ModItems.GALLIUM_ROD);
                        output.accept(ModItems.COOKED_AXOLOTL_EGG);
                        output.accept(ModItems.GALLIUM_CLUMP);
                        output.accept(ModItems.GALLIUM_BREAD);
                        output.accept(ModItems.GALLIUM_BALL);
                        output.accept(ModItems.GALLIUM_NUGGET);
                        output.accept(ModItems.GALLIUM_AXE);
                        output.accept(ModItems.GALLIUM_PICKAXE);
                        output.accept(ModItems.GALLIUM_SWORD);
                        output.accept(ModItems.GALLIUM_SHOVEL);
                        output.accept(ModItems.GALLIUM_HOE);
                        output.accept(ModItems.DIAMOND_SPEAR);
                        output.accept(ModItems.DIAMOND_BROAD_SWORD);


                        output.accept(ModBlocks.GALLIUM_BLOCK);
                        output.accept(ModBlocks.DEEPSLATE_GALLIUM_ORE);
                        output.accept(ModBlocks.GALLIUM_ORE);
                        output.accept(ModBlocks.GALVANIZED_SQUARE_STEEL);
                        output.accept(ModBlocks.RAW_GALLIUM_BLOCK);
                        output.accept(ModBlocks.GALLIUM_ROD_BLOCK);
                        output.accept(ModBlocks.GALLIUM_TRAP_DOOR);
                        output.accept(ModBlocks.GALLIUM_DOOR);
                        output.accept(ModBlocks.GALLIUM_WALL);
                        output.accept(ModBlocks.GALLIUM_FENCE_GATE);
                        output.accept(ModBlocks.GALLIUM_FENCE);
                        output.accept(ModBlocks.GALLIUM_BUTTON);
                        output.accept(ModBlocks.GALLIUM_PRESSURE_PLATE);
                        output.accept(ModBlocks.GALLIUM_SLAB);
                        output.accept(ModBlocks.GALLIUM_STAIRS);
                    }).build());


    public static final Supplier<CreativeModeTab> BOIIUM_TAB = CREATIVE_MODE_TAB.register("boiium_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.RAW_BOIIUM.get()))
            .title(Component.translatable("creativetab.firstmod.boiium_items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.RAW_BOIIUM);
                output.accept(ModBlocks.RAW_BOIIUM_BLOCK);
                output.accept(ModItems.BOIIUM_ROD);
            })


            .build());


  public static void register(IEventBus eventBus) {
     CREATIVE_MODE_TAB.register(eventBus);
  }

}
