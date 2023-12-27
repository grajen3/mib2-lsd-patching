/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.entertainmentmanager.persistence;

import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistence;
import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;

public interface EntertainmentManagerPersistenceService
extends ModulePersistenceService {
    default public EntertainmentPersistence loadEntertainmentPersistence() {
    }

    default public EntertainmentPersistence createEntertainmentPersistence() {
    }
}

