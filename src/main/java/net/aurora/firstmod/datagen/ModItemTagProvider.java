package net.aurora.firstmod.datagen;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.items.ModItems;
import net.aurora.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, FirstMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.GALLIUM_CLUMP.get())
                .add(ModItems.GALLIUM_BALL.get())
                .add(ModItems.GALLIUM_INGOT.get())
                .add(ModItems.RAW_GALLIUM.get())
                .add(ModItems.GALLIUM_BREAD.get());

        tag(ModTags.Items.BOIIUM_ITEMS)
                .add(ModItems.BOIIUM_ROD.get())
                .add(ModItems.RAW_BOIIUM.get());


        tag(ItemTags.SHOVELS).add(ModItems.GALLIUM_SHOVEL.get());
        tag(ItemTags.SWORDS).add(ModItems.GALLIUM_SWORD.get());
        tag(ItemTags.PICKAXES).add(ModItems.GALLIUM_PICKAXE.get());
        tag(ItemTags.AXES).add(ModItems.GALLIUM_AXE.get());
        tag(ItemTags.HOES).add(ModItems.GALLIUM_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GALLIUM_HELMET.get())
                .add(ModItems.GALLIUM_CHESTPLATE.get())
                .add(ModItems.GALLIUM_LEGGINGS.get())
                .add(ModItems.GALLIUM_BOOTS.get())
                .add(ModItems.RAW_BOIIUM_HELMET.get())
                .add(ModItems.RAW_BOIIUM_CHESTPLATE.get())
                .add(ModItems.RAW_BOIIUM_LEGGINGS.get())
                .add(ModItems.RAW_BOIIUM_BOOTS.get());





    }
}
