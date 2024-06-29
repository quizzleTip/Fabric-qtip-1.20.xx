package net.qtip.qtipmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.qtip.qtipmod.QtipMod;

public class ModSounds {

    public static final SoundEvent CROW_CAW = registerSoundEvent("crow_caw");
    public static final SoundEvent OWl_HOOT = registerSoundEvent("owl_hoot");





    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(QtipMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        QtipMod.LOGGER.info("Registering Sounds for " + QtipMod.MOD_ID);
    }
}
