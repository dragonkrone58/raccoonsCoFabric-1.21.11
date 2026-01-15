package net.racquo.raccoonsCo.item.custom;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.item.ModItems;

public class RaccoonPeltHelmet {

    public static final Identifier RACCOON_SNEAK_SPEED_ID =
            Identifier.of("raccoonsco", "raccoon_sneak_speed");

    public static final EntityAttributeModifier RACCOON_SNEAK_SPEED_MODIFIER =
            new EntityAttributeModifier(
                    RACCOON_SNEAK_SPEED_ID,
                    0.5, // +50% total → Swift Sneak I feel
                    EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
            );

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(RaccoonPeltHelmet::onServerTick);
    }

    private static void onServerTick(MinecraftServer server) {
        for (PlayerEntity player : server.getPlayerManager().getPlayerList()) {
            applySneakSpeed(player);
        }
    }

    private static void applySneakSpeed(PlayerEntity player) {
        ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);

        boolean wearingHelmet = helmet.isOf(ModItems.RACCOON_PELT_HELMET);
        boolean sneaking = player.isSneaking();

        var attribute = player.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
        if (attribute == null) return;

        boolean hasModifier = attribute.getModifier(RACCOON_SNEAK_SPEED_ID) != null;

        if (wearingHelmet && sneaking) {
            if (!hasModifier) {
                attribute.addTemporaryModifier(RACCOON_SNEAK_SPEED_MODIFIER);

            }
        } else {
            if (hasModifier) {
                attribute.removeModifier(RACCOON_SNEAK_SPEED_ID);
            }
        }
    }
}
