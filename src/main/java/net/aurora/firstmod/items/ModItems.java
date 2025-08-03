package net.aurora.firstmod.items;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.components.ModDataComponents;
import net.aurora.firstmod.items.custom.FuelItem;
import net.aurora.firstmod.items.custom.GalliumRod;
import net.aurora.firstmod.items.custom.ModFoodProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
      public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirstMod.MODID);


      public static final DeferredItem<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new Item(new Item.Properties()));
      public static final DeferredItem<Item> RAW_GALLIUM = ITEMS.register("raw_gallium", () -> new Item(new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                  tooltipComponents.add(Component.translatable("tooltips.firstmod.raw_gallium"));

                  super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
      });


      public static final DeferredItem<Item> GALLIUM_BALL = ITEMS.register("gallium_ball", () -> new FuelItem(new Item.Properties(), 80000));
      public static final DeferredItem<Item> GALLIUM_CLUMP = ITEMS.register("gallium_clump", () -> new FuelItem(new Item.Properties(), 100));



      public static final DeferredItem<Item> GALLIUM_BREAD = ITEMS.register("gallium_bread", () -> new Item(new Item.Properties().food(ModFoodProperties.GALLIUM_BREAD)));
      public static final DeferredItem<Item> COOKED_AXOLOTL_EGG = ITEMS.register("cooked_axolotl_egg", () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_AXOLOTL_EGG)));


      public static final DeferredItem<Item> GALLIUM_ROD = ITEMS.register("gallium_rod", () -> new GalliumRod(new Item.Properties().durability(32)) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                  if (stack.get(ModDataComponents.COORDINATES) != null){
                        tooltipComponents.add(Component.literal("Last Block Galvanized: " + stack.get(ModDataComponents.COORDINATES)));
                  }

                  super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }


      });


      public static void register(IEventBus eventBus){
          ITEMS.register(eventBus);

      }


}
