package net.aurora.firstmod.items;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.components.ModDataComponents;
import net.aurora.firstmod.items.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
      public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirstMod.MODID);


      public static final DeferredItem<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new Item(new Item.Properties()));
      public static final DeferredItem<Item> GALLIUM_NUGGET = ITEMS.register("gallium_nugget", () -> new Item(new Item.Properties()));
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



      public static final DeferredItem<ModSwordItem> GALLIUM_SWORD = ITEMS.register("gallium_sword",
              () -> new ModSwordItem(ModToolTiers.GALLIUM, new Item.Properties()
                      .attributes(ModSwordItem.createAttributes(ModToolTiers.GALLIUM, 5, -2.4f))));





      public static final DeferredItem<PickaxeItem> GALLIUM_PICKAXE = ITEMS.register("gallium_pickaxe",
              () -> new PickaxeItem(ModToolTiers.GALLIUM, new Item.Properties()
                      .attributes(PickaxeItem.createAttributes(ModToolTiers.GALLIUM, 1.0F, -2.8f))));

      public static final DeferredItem<ShovelItem> GALLIUM_SHOVEL = ITEMS.register("gallium_shovel",
              () -> new ShovelItem(ModToolTiers.GALLIUM, new Item.Properties()
                      .attributes(ShovelItem.createAttributes(ModToolTiers.GALLIUM, 1.5F, -3.0f))));

      public static final DeferredItem<AxeItem> GALLIUM_AXE = ITEMS.register("gallium_axe",
              () -> new AxeItem(ModToolTiers.GALLIUM, new Item.Properties()
                      .attributes(AxeItem.createAttributes(ModToolTiers.GALLIUM, 1.0f, -2.0f))));

      public static final DeferredItem<HoeItem> GALLIUM_HOE = ITEMS.register("gallium_hoe",
              () -> new HoeItem(ModToolTiers.GALLIUM, new Item.Properties()
                      .attributes(HoeItem.createAttributes(ModToolTiers.GALLIUM, 1.0f, -2.0f))));


      public static void register(IEventBus eventBus){
          ITEMS.register(eventBus);

      }


}
