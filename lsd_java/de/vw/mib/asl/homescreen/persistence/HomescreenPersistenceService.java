/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfo;
import de.vw.mib.asl.homescreen.persistence.TileContent;

public interface HomescreenPersistenceService
extends ModulePersistenceService {
    default public HomescreenInfo loadHomescreenInfo() {
    }

    default public HomescreenInfo createHomescreenInfo() {
    }

    default public TileContent createTileContent() {
    }
}

