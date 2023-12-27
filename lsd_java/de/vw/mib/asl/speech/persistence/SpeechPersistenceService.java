/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistable;

public interface SpeechPersistenceService
extends ModulePersistenceService {
    default public SpeechSettingsPersistable loadSpeechSettingsPersistable() {
    }

    default public SpeechSettingsPersistable createSpeechSettingsPersistable() {
    }
}

