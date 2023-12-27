/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.navinfotile;

import de.vw.mib.appadapter.navinfotile.NavInfoTileAdapter;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTilePersistenceAdapter;

class ASLNavInfoTilePersistenceListener
extends ASLNavInfoTilePersistenceAdapter {
    private NavInfoTileAdapter navInfoTileAdapter;

    ASLNavInfoTilePersistenceListener(NavInfoTileAdapter navInfoTileAdapter) {
        this.navInfoTileAdapter = navInfoTileAdapter;
    }

    @Override
    public void updatePersistentPage(int n) {
        this.navInfoTileAdapter.updatePageFromPersistence(n);
    }
}

