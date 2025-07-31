package net.aurora.firstmod.datagen;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}
