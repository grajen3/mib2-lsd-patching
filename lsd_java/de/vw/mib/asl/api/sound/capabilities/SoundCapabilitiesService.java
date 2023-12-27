/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.sound.capabilities;

import de.vw.mib.asl.api.sound.capabilities.SoundCapabilitiesUpdate;

public interface SoundCapabilitiesService {
    default public void register(SoundCapabilitiesUpdate soundCapabilitiesUpdate) {
    }

    default public void unregister(SoundCapabilitiesUpdate soundCapabilitiesUpdate) {
    }
}

