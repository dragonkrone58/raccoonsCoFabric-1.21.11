package net.racquo.raccoonsCo.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.RaccoonsCo;

public class ModSounds {

    public static final SoundEvent RACCOON_IDLE = registerSoundEvent("raccoon_idle");
    public static final SoundEvent RACCOON_HURT = registerSoundEvent("raccoon_hurt");
    public static final SoundEvent RACCOON_DEATH = registerSoundEvent("raccoon_death");
    public static final SoundEvent RACCOON_EATS = registerSoundEvent("raccoon_eats");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(RaccoonsCo.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        RaccoonsCo.LOGGER.info("Registering Mod Sounds for " + RaccoonsCo.MOD_ID);
    }
}
