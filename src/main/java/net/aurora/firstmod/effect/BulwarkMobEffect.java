package net.aurora.firstmod.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;

public class BulwarkMobEffect extends MobEffect {
    private static final TagKey<DamageType> PROJECTILE_TAG =
            TagKey.create(Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath("minecraft", "projectile"));

    protected BulwarkMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onMobHurt(LivingEntity livingEntity, int amplifier, DamageSource damageSource, float amount) {
        if (livingEntity.level().isClientSide) return;

        boolean isProjectileDamage = damageSource.is(PROJECTILE_TAG)
                || damageSource.getDirectEntity() instanceof Projectile;

        if (isProjectileDamage) {
            livingEntity.invulnerableTime = 0;
            livingEntity.setHealth(livingEntity.getHealth() + amount);

            livingEntity.level().playSound(null, livingEntity.blockPosition(),
                    SoundEvents.SHIELD_BLOCK, SoundSource.PLAYERS, 0.8F, 1.2F);
        }


        Entity projectile = damageSource.getDirectEntity();
        if (projectile != null) {
            ((ServerLevel) livingEntity.level()).sendParticles(
                    ParticleTypes.SMOKE,
                    projectile.getX(),
                    projectile.getY(),
                    projectile.getZ(),
                    10, 0.2, 0.2, 0.2, 0.01);
        }
    }
}
