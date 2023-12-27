/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.gridmenu.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.gridmenu.persistence.GridMenu;

public interface GridMenuPersistenceService
extends ModulePersistenceService {
    default public GridMenu loadGridMenu() {
    }

    default public GridMenu createGridMenu() {
    }
}

