/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navinfotile;

import de.vw.mib.asl.api.navinfotile.ASLNavInfoTileGuidanceListener;
import de.vw.mib.asl.api.navinfotile.ASLNavInfoTilePersistenceListener;

public interface ASLNavInfoTileAPI {
    default public void setPersistedPage(int n) {
    }

    default public int getPersistedPage() {
    }

    default public void registerPersistenceListener(ASLNavInfoTilePersistenceListener aSLNavInfoTilePersistenceListener) {
    }

    default public void registerGuidanceListener(ASLNavInfoTileGuidanceListener aSLNavInfoTileGuidanceListener) {
    }
}

