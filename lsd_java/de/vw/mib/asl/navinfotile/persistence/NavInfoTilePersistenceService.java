/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navinfotile.persistence;

import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTile;

public interface NavInfoTilePersistenceService
extends ModulePersistenceService {
    default public NavInfoTile loadNavInfoTile() {
    }

    default public NavInfoTile createNavInfoTile() {
    }
}

