package net.aurora.firstmod.datagen;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.DEEPSLATE_GALLIUM_ORE.get())
                .add(ModBlocks.GALLIUM_ORE.get())
                .add(ModBlocks.GALLIUM_ROD_BLOCK.get())
                .add(ModBlocks.GALVANIZED_SQUARE_STEEL.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.GALVANIZED_SQUARE_STEEL.get())
                .add(ModBlocks.GALLIUM_ROD_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GALLIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_GALLIUM_ORE.get());


        tag(BlockTags.FENCES)
                .add(ModBlocks.GALLIUM_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.GALLIUM_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.GALLIUM_WALL.get());


    }
}
