package net.aurora.firstmod.items;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.components.ModDataComponents;
import net.aurora.firstmod.items.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Map;

public class ModItems {
      public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FirstMod.MODID);


      public static final DeferredItem<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new Item(new Item.Properties()));
      public static final DeferredItem<Item> RAW_BOIIUM = ITEMS.register("raw_boiium", () -> new Item(new Item.Properties()));
      public static final DeferredItem<Item> BOIIUM_ROD = ITEMS.register("boiium_rod", () -> new Item(new Item.Properties().durability(32)){
          public static final Map<Block, Block> BOIIUM_ROD_LIST =
                  Map.of(
                          Blocks.DIAMOND_BLOCK, Blocks.AIR,
                          Blocks.COPPER_BLOCK, Blocks.AIR,
                          Blocks.COAL_BLOCK, Blocks.AIR,
                          Blocks.NETHERITE_BLOCK, Blocks.AIR,
                          Blocks.LAPIS_BLOCK, Blocks.AIR,
                          Blocks.REDSTONE_BLOCK, Blocks.AIR,
                          Blocks.EMERALD_BLOCK, Blocks.AIR,
                          Blocks.IRON_BLOCK, Blocks.AIR,
                          Blocks.GOLD_BLOCK, Blocks.AIR,
                          ModBlocks.GALLIUM_BLOCK.get(), Blocks.AIR



                  );

          @Override
          public InteractionResult useOn(UseOnContext context) {
              Level level = context.getLevel();
              Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

              if(BOIIUM_ROD_LIST.containsKey(clickedBlock)) {
                  if(!level.isClientSide()) {
                      level.setBlockAndUpdate(context.getClickedPos(), BOIIUM_ROD_LIST.get(clickedBlock).defaultBlockState());


                      context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level),  context.getPlayer(),
                              item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                      level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS);



                      context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());

                  }
              }
              return InteractionResult.SUCCESS;
          }
      });
      public static final DeferredItem<Item> GALLIUM_NUGGET = ITEMS.register("gallium_nugget", () -> new Item(new Item.Properties()));
      public static final DeferredItem<Item> RAW_GALLIUM = ITEMS.register("raw_gallium", () -> new Item(new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                  tooltipComponents.add(Component.translatable("tooltips.firstmod.raw_gallium"));

                  super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
      });
      public static final DeferredItem<Item> GALLIUM_BALL = ITEMS.register("gallium_ball", () -> new Item(new Item.Properties()));
      public static final DeferredItem<Item> GALLIUM_CLUMP = ITEMS.register("gallium_clump", () -> new Item(new Item.Properties()));
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




    public static final DeferredItem<ArmorItem> GALLIUM_HELMET = ITEMS.register("gallium_helmet",
            () -> new ArmorItem(ModArmorMaterials.GALLIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));

    public static final DeferredItem<ArmorItem> GALLIUM_CHESTPLATE = ITEMS.register("gallium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GALLIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));

    public static final DeferredItem<ArmorItem> GALLIUM_LEGGINGS = ITEMS.register("gallium_leggings",
            () -> new ArmorItem(ModArmorMaterials.GALLIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));

    public static final DeferredItem<ArmorItem> GALLIUM_BOOTS = ITEMS.register("gallium_boots",
            () -> new ArmorItem(ModArmorMaterials.GALLIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final DeferredItem<ArmorItem> RAW_BOIIUM_HELMET = ITEMS.register("raw_boiium_helmet",
            () -> new ArmorItem(ModArmorMaterials.RAW_BOIIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));

    public static final DeferredItem<ArmorItem> RAW_BOIIUM_CHESTPLATE = ITEMS.register("raw_boiium_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RAW_BOIIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));

    public static final DeferredItem<ArmorItem> RAW_BOIIUM_LEGGINGS = ITEMS.register("raw_boiium_leggings",
            () -> new ArmorItem(ModArmorMaterials.RAW_BOIIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));

    public static final DeferredItem<ArmorItem> RAW_BOIIUM_BOOTS = ITEMS.register("raw_boiium_boots",
            () -> new ArmorItem(ModArmorMaterials.RAW_BOIIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static final DeferredItem<Item> GALLIUM_HORSE_ARMOR = ITEMS.register("gallium_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.GALLIUM_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));


    public static final DeferredItem<IceWand> ICE_WAND = ITEMS.register("ice_wand",
            () -> new IceWand(new Item.Properties().stacksTo(1).durability(128)));

    public static final DeferredItem<Item> GALLIUM_WHEAT = ITEMS.register("gallium_wheat", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GALLIUM_WHEAT_SEEDS = ITEMS.register("gallium_wheat_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GALLIUM_WHEAT_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> NEON_POTATO = ITEMS.register("neon_potato",
            () -> new ItemNameBlockItem(ModBlocks.NEON_POTATO_CROP.get(), new Item.Properties().food(ModFoodProperties.NEON_POTATO)));



















      public static final DeferredItem<ScytheItem> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
              () -> new ScytheItem(Tiers.DIAMOND, new Item.Properties()
                      .attributes(ScytheItem.createAttributes(Tiers.DIAMOND, 2, -2.4f,5, 2)), 0.75D));

      public static final DeferredItem<BroadSwordItem> DIAMOND_BROAD_SWORD = ITEMS.register("diamond_broad_sword",
              () -> new BroadSwordItem(Tiers.DIAMOND, new Item.Properties()
                      .attributes(BroadSwordItem.createAttributes(Tiers.DIAMOND, 2, -3.4f,4, 5)), 0.50D));

      public static final DeferredItem<SpearItem> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
              () -> new SpearItem(Tiers.DIAMOND, new Item.Properties()
                      .attributes(SpearItem.createAttributes(Tiers.DIAMOND, 2, -2.4f, 5))));


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
