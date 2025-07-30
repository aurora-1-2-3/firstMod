package com.example.examplemod.blocks;

import com.example.examplemod.FirstMod;
import com.example.examplemod.blocks.custom.GalvanizedSquareSteel;
import com.example.examplemod.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(FirstMod.MODID);

    public static final DeferredBlock<Block> GALLIUM_BLOCK = registerBlock("gallium_block",
            () -> new Block(BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> RAW_GALLIUM_BLOCK = registerBlock("raw_gallium_block",
            () -> new Block(BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> GALLIUM_ORE = registerBlock("gallium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 5), BlockBehaviour
                    .Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_GALLIUM_ORE = registerBlock("deepslate_gallium_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 5), BlockBehaviour
                    .Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> GALLIUM_ROD_BLOCK = registerBlock("gallium_rod_block",
            () -> new DropExperienceBlock(UniformInt.of(3, 5), BlockBehaviour
                    .Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> GALVANIZED_SQUARE_STEEL = registerBlock("galvanized_square_steel",
            () -> new GalvanizedSquareSteel( BlockBehaviour
                    .Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANVIL)));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
