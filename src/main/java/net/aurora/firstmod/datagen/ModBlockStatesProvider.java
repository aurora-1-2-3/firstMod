package net.aurora.firstmod.datagen;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GALLIUM_BLOCK);
        blockWithItem(ModBlocks.GALLIUM_ROD_BLOCK);
        blockWithItem(ModBlocks.GALLIUM_ORE);
        blockWithItem(ModBlocks.RAW_GALLIUM_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_GALLIUM_ORE);


    }



    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }


}
