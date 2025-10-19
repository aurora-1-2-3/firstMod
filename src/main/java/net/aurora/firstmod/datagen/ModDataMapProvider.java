package net.aurora.firstmod.datagen;

import net.aurora.firstmod.items.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }


    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.GALLIUM_BALL.getId(), new FurnaceFuel(8000), false)
                .add(ModItems.GALLIUM_CLUMP.getId(), new FurnaceFuel(800), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.GALLIUM_WHEAT.getId(), new Compostable(0.25f), false)
                .add(ModItems.GALLIUM_WHEAT_SEEDS.getId(), new Compostable(0.25f), false)
                .add(ModItems.NEON_POTATO.getId(), new Compostable(0.25f), false);
    }
}
