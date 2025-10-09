package net.aurora.firstmod.datagen;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemProvider extends ItemModelProvider {
    public ModItemProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_GALLIUM.get());
        basicItem(ModItems.GALLIUM_BALL.get());
        basicItem(ModItems.GALLIUM_BREAD.get());
        basicItem(ModItems.GALLIUM_ROD.get());
        basicItem(ModItems.GALLIUM_CLUMP.get());
        basicItem(ModItems.COOKED_AXOLOTL_EGG.get());
        basicItem(ModItems.GALLIUM_INGOT.get());
        basicItem(ModItems.GALLIUM_NUGGET.get());
        basicItem(ModItems.RAW_BOIIUM.get());
        basicItem(ModItems.BOIIUM_ROD.get());
        basicItem(ModItems.DIAMOND_SPEAR.get());
        basicItem(ModItems.DIAMOND_BROAD_SWORD.get());


        buttonItem(ModBlocks.GALLIUM_BUTTON, ModBlocks.GALLIUM_BLOCK);
        fenceItem(ModBlocks.GALLIUM_FENCE, ModBlocks.GALLIUM_BLOCK);
        wallItem(ModBlocks.GALLIUM_WALL, ModBlocks.GALLIUM_BLOCK);


        basicItem(ModBlocks.GALLIUM_DOOR.asItem());

        handheldItem(ModItems.GALLIUM_AXE);
        handheldItem(ModItems.GALLIUM_PICKAXE);
        handheldItem(ModItems.GALLIUM_HOE);
        handheldItem(ModItems.GALLIUM_SHOVEL);
        handheldItem(ModItems.GALLIUM_SWORD);





    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(FirstMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(FirstMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(FirstMod.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(FirstMod.MODID,"item/" + item.getId().getPath()));
    }





}
