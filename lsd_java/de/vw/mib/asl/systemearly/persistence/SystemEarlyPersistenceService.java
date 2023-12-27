/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemearly.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.systemearly.persistence.SystemEarly;

public interface SystemEarlyPersistenceService
extends ModulePersistenceService {
    default public SystemEarly loadSystemEarly() {
    }

    default public SystemEarly createSystemEarly() {
    }
}

