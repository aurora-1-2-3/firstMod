package net.aurora.firstmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;

import static net.aurora.firstmod.FirstMod.MOD_ID;

public class ConstantsAndHelperMethods {

    // CONSTANTS
    public static final String PLAYER_ENTITY_INTERACTION_RANGE_MODIFIER_ID = "72551fd8-ec05-4009-ae5f-fdfe492da7e4";
    public static final String PLAYER_SWEEP_DAMAGE_RATIO_MODIFIER_ID = "3a6aa20c-2f42-4397-b0c0-57aedcc23d24";
    public static final String PLAYER_SWEEP_HITBOX_MODIFIER_ID = "f6c776c9-ca44-4336-a905-5c84b3625285";


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
}
