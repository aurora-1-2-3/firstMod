package com.example.examplemod.items.custom;

import com.example.examplemod.blocks.ModBlocks;
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
                    Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE,
                    Blocks.COPPER_BLOCK, Blocks.COPPER_ORE,
                    Blocks.COAL_BLOCK, Blocks.COAL_ORE,
                    Blocks.NETHERITE_BLOCK, Blocks.ANCIENT_DEBRIS,
                    Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE,
                    Blocks.REDSTONE_BLOCK, Blocks.REDSTONE_ORE,
                    Blocks.EMERALD_BLOCK, Blocks.EMERALD_ORE,
                    Blocks.IRON_BLOCK, Blocks.IRON_ORE,
                    Blocks.GOLD_BLOCK, Blocks.GOLD_ORE,
                    ModBlocks.GALLIUM_BLOCK.get(), ModBlocks.GALLIUM_ORE.get()



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
            }


        }

        return InteractionResult.SUCCESS;
    }
}
