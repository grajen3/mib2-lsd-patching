/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionService;

public interface TileSelectionAppProvider {
    default public TileSelectionService retrieveTileSelectionService(Tile tile) {
    }

    default public boolean hasTileSelectionService(Tile tile) {
    }
}

