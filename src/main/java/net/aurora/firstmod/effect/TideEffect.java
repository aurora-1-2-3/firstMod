package net.aurora.firstmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;


public class TideEffect extends MobEffect {

    protected TideEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {


        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }


}
