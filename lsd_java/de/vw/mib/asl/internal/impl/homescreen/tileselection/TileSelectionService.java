/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.asl.internal.impl.homescreen.model.Tile;

public interface TileSelectionService {
    default public void activateTileSelection(Tile tile) {
    }

    default public void cancelTileSelection() {
    }
}

