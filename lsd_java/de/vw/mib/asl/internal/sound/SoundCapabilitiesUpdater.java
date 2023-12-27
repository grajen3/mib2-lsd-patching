/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.sound.capabilities.SoundCapabilitiesService;
import de.vw.mib.asl.api.sound.capabilities.SoundCapabilitiesUpdate;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import java.util.HashMap;
import java.util.Iterator;

public class SoundCapabilitiesUpdater
implements SoundCapabilitiesService {
    private final HashMap listeners = new HashMap();
    private boolean dynaudioCharacterPresetsAvailable = false;

    void onDynaudioCharacterPresetsAvailableChanged(boolean bl) {
        if (this.dynaudioCharacterPresetsAvailable != bl) {
            this.dynaudioCharacterPresetsAvailable = bl;
            Iterator iterator = this.listeners.values().iterator();
            while (iterator.hasNext()) {
                SoundCapabilitiesUpdate soundCapabilitiesUpdate = (SoundCapabilitiesUpdate)iterator.next();
                soundCapabilitiesUpdate.onDynaudioCharacterPresetsAvailableChanged(bl);
            }
        }
    }

    @Override
    public void register(SoundCapabilitiesUpdate soundCapabilitiesUpdate) {
        SoundCapabilitiesUpdate soundCapabilitiesUpdate2 = (SoundCapabilitiesUpdate)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory().create(soundCapabilitiesUpdate);
        this.listeners.put(soundCapabilitiesUpdate, soundCapabilitiesUpdate2);
        soundCapabilitiesUpdate2.onDynaudioCharacterPresetsAvailableChanged(this.dynaudioCharacterPresetsAvailable);
    }

    @Override
    public void unregister(SoundCapabilitiesUpdate soundCapabilitiesUpdate) {
        this.listeners.remove(soundCapabilitiesUpdate);
    }
}

