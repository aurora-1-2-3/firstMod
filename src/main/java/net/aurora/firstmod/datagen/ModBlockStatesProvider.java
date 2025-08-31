package net.aurora.firstmod.datagen;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.blocks.custom.GalliumRodBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.GALLIUM_BLOCK);
        blockWithItem(ModBlocks.GALLIUM_ORE);
        blockWithItem(ModBlocks.RAW_GALLIUM_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_GALLIUM_ORE);
        blockWithItem(ModBlocks.RAW_BOIIUM_BLOCK);


        stairsBlock(ModBlocks.GALLIUM_STAIRS.get(), blockTexture(ModBlocks.GALLIUM_BLOCK.get()));
        slabBlock(ModBlocks.GALLIUM_SLAB.get(), blockTexture(ModBlocks.GALLIUM_BLOCK.get()), blockTexture(ModBlocks.GALLIUM_BLOCK.get()));
        buttonBlock(ModBlocks.GALLIUM_BUTTON.get(), blockTexture(ModBlocks.GALLIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.GALLIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.GALLIUM_BLOCK.get()));
        fenceBlock(ModBlocks.GALLIUM_FENCE.get(), blockTexture(ModBlocks.GALLIUM_BLOCK.get()));
        fenceGateBlock(ModBlocks.GALLIUM_FENCE_GATE.get(), blockTexture(ModBlocks.GALLIUM_BLOCK.get()));
        wallBlock(ModBlocks.GALLIUM_WALL.get(), blockTexture(ModBlocks.GALLIUM_BLOCK.get()));
        doorBlockWithRenderType(ModBlocks.GALLIUM_DOOR.get(), modLoc("block/gallium_door_bottem"), modLoc("block/gallium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.GALLIUM_TRAP_DOOR.get(), modLoc("block/gallium_trapdoor"), true,"cutout");


        blockItem(ModBlocks.GALLIUM_STAIRS);
        blockItem(ModBlocks.GALLIUM_SLAB);
        blockItem(ModBlocks.GALLIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.GALLIUM_FENCE_GATE);
        blockItem(ModBlocks.GALLIUM_TRAP_DOOR, "_bottom");


        galliumRodBlockColorChange();

    }


    private void galliumRodBlockColorChange() {
        getVariantBuilder(ModBlocks.GALLIUM_ROD_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(GalliumRodBlock.TOUCHED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("gallium_rod_block_blue",
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MODID, "block/" + "gallium_rod_block_blue")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("gallium_rod_block_red",
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MODID, "block/" + "gallium_rod_block_red")))};
            }
        });

        simpleBlockItem(ModBlocks.GALLIUM_ROD_BLOCK.get(), models().cubeAll("gallium_rod_block_red",
                ResourceLocation.fromNamespaceAndPath(FirstMod.MODID, "block/" + "gallium_rod_block_red")));
    }


    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }


    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("firstmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("firstmod:block/" + deferredBlock.getId().getPath() + appendix));
    }

}
