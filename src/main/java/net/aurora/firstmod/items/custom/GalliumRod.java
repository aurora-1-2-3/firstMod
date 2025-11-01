package net.aurora.firstmod.items.custom;

import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.components.ModDataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class GalliumRod extends Item {
    public static final Map<Block, Block> GALLIUM_ROD_LIST =
            Map.of(
                    Blocks.DIAMOND_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.COPPER_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.COAL_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.NETHERITE_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.LAPIS_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.REDSTONE_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.EMERALD_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.IRON_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    Blocks.GOLD_BLOCK, ModBlocks.GALLIUM_BLOCK.get(),
                    ModBlocks.GALLIUM_BLOCK.get(), ModBlocks.GALVANIZED_SQUARE_STEEL.get()

            );


    public GalliumRod(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(GALLIUM_ROD_LIST.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), GALLIUM_ROD_LIST.get(clickedBlock).defaultBlockState());


                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level),  context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS);



                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());

            }


        }

        return InteractionResult.SUCCESS;




    }
}
