package net.aurora.firstmod.effect;

import net.aurora.firstmod.ModUtility;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

public class BulwarkEffect extends MobEffect {
    protected BulwarkEffect(MobEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        return true;
    }

    private static void spawnSmokeAndRemoveProjectile(LivingEntity livingEntity, DamageSource damageSource) {
        Entity projectile = damageSource.getDirectEntity();
        if (projectile == null) return;

        ModUtility.spawnParticles((ServerLevel) livingEntity.level(), ParticleTypes.SMOKE,
                projectile.getX(), projectile.getY(), projectile.getZ(),
                10,
                0.2, 0.2, 0.2,
                0.01
        );
        projectile.discard();
    }
    private static void playShieldSound(LivingEntity livingEntity) {
        ModUtility.playSound(livingEntity.level(), livingEntity.blockPosition(), SoundEvents.SHIELD_BLOCK, SoundSource.PLAYERS, 0.8F, 1.2F);
    }
}
