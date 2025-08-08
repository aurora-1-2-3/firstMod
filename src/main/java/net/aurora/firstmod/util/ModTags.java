package net.aurora.firstmod.util;

import net.aurora.firstmod.FirstMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public class Blocks {
        public static final TagKey<Block> NEEDS_GALLIUM_TOOL = createTag("needs_gallium_tool");
        public static final TagKey<Block> INCORRECT_FOR_GALLIUM_TOOL = createTag("incorrect_for_gallium_tool");



        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MODID, name));
        }
    }



    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MODID, name));
        }

    }

}
