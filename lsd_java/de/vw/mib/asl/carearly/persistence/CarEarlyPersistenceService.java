/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.carearly.persistence;

import de.vw.mib.asl.carearly.persistence.CarEarly;
import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;

public interface CarEarlyPersistenceService
extends ModulePersistenceService {
    default public CarEarly loadCarEarly() {
    }

    default public CarEarly createCarEarly() {
    }
}

