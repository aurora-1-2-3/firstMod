package com.example.examplemod.items;

import com.example.examplemod.FirstMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
      public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirstMod.MODID);


      public static final DeferredItem<Item> GALLIUM = ITEMS.register("gallium", () -> new Item(new Item.Properties()));
      public static final DeferredItem<Item> RAW_GALLIUM = ITEMS.register("raw_gallium", () -> new Item(new Item.Properties()));



      public static void register(IEventBus eventBus){
          ITEMS.register(eventBus);

      }


}
