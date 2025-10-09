package net.aurora.firstmod.items.custom;



import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;

import static net.aurora.firstmod.FirstMod.ID;
import static net.aurora.firstmod.FirstMod.PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID;

public class SpearItem extends TieredItem {
    public SpearItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }


    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed, double reach) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(ID(PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID), reach, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }




    // register(context, SWEEPING_EDGE, Enchantment.enchantment(Enchantment.definition(holdergetter2.getOrThrow(ItemTags.SWORD_ENCHANTABLE), 2, 3, Enchantment.dynamicCost(5, 9), Enchantment.dynamicCost(20, 9), 4, new EquipmentSlotGroup[]{EquipmentSlotGroup.MAINHAND})).withEffect(EnchantmentEffectComponents.ATTRIBUTES, new EnchantmentAttributeEffect(ResourceLocation.withDefaultNamespace("enchantment.sweeping_edge"), Attributes.SWEEPING_DAMAGE_RATIO, new LevelBasedValue.Fraction(LevelBasedValue.perLevel(1.0F), LevelBasedValue.perLevel(2.0F, 1.0F)), AttributeModifier.Operation.ADD_VALUE)));
}
