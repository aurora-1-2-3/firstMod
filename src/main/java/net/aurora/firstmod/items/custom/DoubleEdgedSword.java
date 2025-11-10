package net.aurora.firstmod.items.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class DoubleEdgedSword extends SwordItem {

    private static final double SPIN_RADIUS = 1.5;
    private static final int MAX_USE_DURATION = 72000;

    public DoubleEdgedSword(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);

        if (player.isCrouching()) {
            player.startUsingItem(interactionHand);
            return InteractionResultHolder.consume(itemStack);
        }
        return InteractionResultHolder.pass(itemStack);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int remainingUseTicks) {
        if (!(livingEntity instanceof Player player)) return;

        if (!player.isCrouching()) {
            player.stopUsingItem();
            return;
        }
        int ticksUsed = getUseDuration(itemStack, livingEntity) - remainingUseTicks;

        if (ticksUsed % 5 == 0 && !level.isClientSide) {
            damageNearbyEntities(level, player, itemStack);
        }
    }

    private void damageNearbyEntities(Level level, Player player, ItemStack itemStack) {
        float normalDamage = this.getTier().getAttackDamageBonus();
        float spinDamage = normalDamage / 2.0f;

        AABB searchBox = new AABB(player.blockPosition()).inflate(SPIN_RADIUS);
        List<LivingEntity> nearbyEntities = level.getEntitiesOfClass(
                LivingEntity.class,
                searchBox,
                target -> target != player && target.distanceTo(player) <= SPIN_RADIUS
        );

        for (LivingEntity nearbyEntity : nearbyEntities) {
            DamageSource damageSource = new DamageSource(
                    level.damageSources().playerAttack(player).typeHolder()
            );
            nearbyEntity.hurt(damageSource, spinDamage);
            itemStack.hurtAndBreak(3, player, EquipmentSlot.MAINHAND);
        }
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return MAX_USE_DURATION;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }
}