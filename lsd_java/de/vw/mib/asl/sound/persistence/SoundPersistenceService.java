/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.sound.persistence.SoundSettings;

public interface SoundPersistenceService
extends ModulePersistenceService {
    default public SoundSettings loadSoundSettings() {
    }

    default public SoundSettings createSoundSettings() {
    }
}

