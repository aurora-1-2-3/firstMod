package net.aurora.firstmod.effect;

import net.aurora.firstmod.ModUtility;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class BerserkerEffect extends MobEffect {
    private final ResourceLocation SPEED_MODIFIER_ID = ModUtility.ID("berserker_effect");

    protected BerserkerEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        var speedAttribute = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
        float currentHealth = livingEntity.getMaxHealth() - livingEntity.getHealth();
        double speedBoost = (currentHealth / 2.0f) * 0.5;

        if (speedAttribute != null) {
            speedAttribute.removeModifier(SPEED_MODIFIER_ID);
        }

        if (speedBoost > 0 && speedAttribute != null) {
                speedAttribute.addTransientModifier(new AttributeModifier(
                        SPEED_MODIFIER_ID,
                        speedBoost,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                ));
        }
        return true;
    }
    @Override
    public void removeAttributeModifiers(AttributeMap attributeMap) {
        var speedAttribute = attributeMap.getInstance(Attributes.MOVEMENT_SPEED);
        if (speedAttribute != null) {
            speedAttribute.removeModifier(SPEED_MODIFIER_ID);
        }
        super.removeAttributeModifiers(attributeMap);
    }
}
