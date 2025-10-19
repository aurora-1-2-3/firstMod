package net.aurora.firstmod.blocks;

import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.blocks.custom.GalliumRodBlock;
import net.aurora.firstmod.blocks.custom.GalliumWheatCropBlock;
import net.aurora.firstmod.blocks.custom.GalvanizedSquareSteel;
import net.aurora.firstmod.blocks.custom.NeonPotatoCropBlock;
import net.aurora.firstmod.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
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

    public static final DeferredBlock<Block> RAW_BOIIUM_BLOCK = registerBlock("raw_boiium_block",
            () -> new Block(BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> GALLIUM_WHEAT_CROP = BLOCKS.register("gallium_wheat_crop",
            () -> new GalliumWheatCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT), ModItems.GALLIUM_WHEAT_SEEDS));

    public static final DeferredBlock<Block> NEON_POTATO_CROP = BLOCKS.register("neon_potato_crop",
            () -> new NeonPotatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES), ModItems.NEON_POTATO));

    // test

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
            () -> new GalliumRodBlock( BlockBehaviour
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



    public static final DeferredBlock<StairBlock> GALLIUM_STAIRS = registerBlock("gallium_stairs",
            () -> new StairBlock(ModBlocks.GALLIUM_BLOCK.get().defaultBlockState(), BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<SlabBlock> GALLIUM_SLAB = registerBlock("gallium_slab",
            () -> new SlabBlock(BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> GALLIUM_PRESSURE_PLATE = registerBlock("gallium_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<ButtonBlock> GALLIUM_BUTTON = registerBlock("gallium_button",
            () -> new ButtonBlock(BlockSetType.IRON, 30, BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .noCollission()));

    public static final DeferredBlock<FenceBlock> GALLIUM_FENCE = registerBlock("gallium_fence",
            () -> new FenceBlock(BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<FenceGateBlock> GALLIUM_FENCE_GATE = registerBlock("gallium_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<WallBlock> GALLIUM_WALL = registerBlock("gallium_wall",
            () -> new WallBlock(BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> GALLIUM_DOOR = registerBlock("gallium_door",
            () -> new DoorBlock(BlockSetType.ACACIA, BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> GALLIUM_TRAP_DOOR = registerBlock("gallium_trap_door",
            () -> new TrapDoorBlock(BlockSetType.ACACIA, BlockBehaviour
                    .Properties.of()
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

















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
