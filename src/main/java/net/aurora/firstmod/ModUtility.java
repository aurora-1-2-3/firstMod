package net.aurora.firstmod;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

import static net.aurora.firstmod.FirstMod.MOD_ID;

public class ModUtility {
    // HELPER METHODS
    public static ResourceLocation ID(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static boolean isProjectileDamage(DamageSource damageSource) {
        return damageSource.getDirectEntity() instanceof Projectile;
    }

    public static void noDamageTilt(LivingEntity entity) {
        entity.hurtTime = 0;
        entity.hurtDuration = 0;
    }

    public static void spawnParticles(ServerLevel level, ParticleOptions particle, double x, double y, double z,
                                      int count, double spreadX, double spreadY, double spreadZ, double speed) {
        level.sendParticles(particle, x, y, z, count, spreadX, spreadY, spreadZ, speed);
    }

    public static void playSound(Level level, BlockPos pos, SoundEvent sound, SoundSource source, float volume, float pitch) {
        level.playSound(null, pos, sound, source, volume, pitch);
    }
}
