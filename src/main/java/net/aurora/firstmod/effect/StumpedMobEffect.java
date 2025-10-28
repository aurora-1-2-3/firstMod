package net.aurora.firstmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class StumpedMobEffect extends MobEffect{
    protected StumpedMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        livingEntity.fallDistance = 0.0F;
        Vec3 velocity = livingEntity.getDeltaMovement();
        if (!livingEntity.onGround() && velocity.y > 0) {
            livingEntity.setDeltaMovement(velocity.x, velocity.y * 0.5, velocity.z);
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
