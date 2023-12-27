/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.navi.persistence.Navigation;

public interface NaviPersistenceService
extends ModulePersistenceService {
    default public Navigation loadNavigation() {
    }

    default public Navigation createNavigation() {
    }
}

