/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilities;
import de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilities;

public interface InstrumentClusterPersistenceService
extends ModulePersistenceService {
    default public AudioSD_ASGCapabilities loadAudioSD_ASGCapabilities() {
    }

    default public SDSSD_ASGCapabilities loadSDSSD_ASGCapabilities() {
    }

    default public AudioSD_ASGCapabilities createAudioSD_ASGCapabilities() {
    }

    default public SDSSD_ASGCapabilities createSDSSD_ASGCapabilities() {
    }
}

