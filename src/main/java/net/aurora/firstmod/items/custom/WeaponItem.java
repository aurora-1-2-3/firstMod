package net.aurora.firstmod.items.custom;

import net.aurora.firstmod.ModConstants;
import net.aurora.firstmod.ModUtility;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.phys.AABB;

public class WeaponItem extends SwordItem {
    private final double sweepHitbox;
    public WeaponItem(Tier tier, Properties properties, double sweepHitbox) {
        super(tier, properties);
        if (sweepHitbox == 0.0D) {
            throw new IllegalArgumentException("Sweep hitbox value cannot be 0.0");
        }

        this.sweepHitbox = sweepHitbox;
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed, double reach, double sweepDamageRatio) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, attackDamage + tier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(ModUtility.ID(ModConstants.PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID), reach, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(ModUtility.ID(ModConstants.PLAYER_SWEEP_DAMAGE_RATIO_MODIFIER_ID), sweepDamageRatio, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public AABB getSweepHitBox(ItemStack stack, Player player, Entity target) {
        double sweepRange = this.sweepHitbox;
        return target.getBoundingBox().inflate(sweepRange*4, sweepRange, sweepRange*4);
    }
}
