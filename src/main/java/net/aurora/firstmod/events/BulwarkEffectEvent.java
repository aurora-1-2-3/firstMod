package net.aurora.firstmod.events;

import net.aurora.firstmod.ModUtility;
import net.aurora.firstmod.FirstMod;
import net.aurora.firstmod.effect.ModEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;


@EventBusSubscriber(modid = FirstMod.MOD_ID)

public class BulwarkEffectEvent {

    @SubscribeEvent
    public static void onLivingDamage(LivingIncomingDamageEvent incomingDamageEvent) {
        LivingEntity livingEntity = incomingDamageEvent.getEntity();
        
        if (livingEntity.hasEffect(ModEffects.BULWARK_EFFECT) && ModUtility.isProjectileDamage(incomingDamageEvent.getSource()) && !livingEntity.level().isClientSide) {
            incomingDamageEvent.setCanceled(true);
            ModUtility.noDamageTilt(livingEntity);
            spawnSmokeAndRemoveProjectile(livingEntity, incomingDamageEvent.getSource());
            playShieldSound(livingEntity);
        }
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
