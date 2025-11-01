package net.aurora.firstmod.items.custom;

import net.aurora.firstmod.blocks.ModBlocks;
import net.aurora.firstmod.components.ModDataComponents;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import java.util.Map;

public class IceWand extends Item {
    public static final Map<Block, Block> ICE_WAND_LIST =
            Map.of(
                    Blocks.ICE, Blocks.PACKED_ICE,
                    Blocks.PACKED_ICE, Blocks.BLUE_ICE
            );


    public IceWand(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(ICE_WAND_LIST.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), ICE_WAND_LIST.get(clickedBlock).defaultBlockState());
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level),  context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS);
                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget, InteractionHand usedHand) {
        if(!player.level().isClientSide){
            interactionTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3));
            player.level().playSound(null, interactionTarget.blockPosition(), SoundEvents.SNOW_HIT, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        return InteractionResult.SUCCESS;
    }
}
