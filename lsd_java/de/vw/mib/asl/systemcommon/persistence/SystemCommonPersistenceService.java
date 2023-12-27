/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.Units;

public interface SystemCommonPersistenceService
extends ModulePersistenceService {
    default public SystemCommon loadSystemCommon() {
    }

    default public Units loadUnits() {
    }

    default public AbtFeatures loadAbtFeatures() {
    }

    default public SystemCommon createSystemCommon() {
    }

    default public Units createUnits() {
    }

    default public AbtFeatures createAbtFeatures() {
    }
}

