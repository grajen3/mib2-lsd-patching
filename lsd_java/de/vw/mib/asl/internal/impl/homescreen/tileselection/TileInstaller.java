/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen.tileselection;

import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.cio.CioIntent;

public interface TileInstaller {
    default public void installTile(Tile tile, CioIntent cioIntent) {
    }

    default public void activateTiles() {
    }

    default public CioIntent findCurrentHeaderAction(int n) {
    }

    default public void activateSelectionTile(int n) {
    }

    default public void deactivateSelectionTile() {
    }

    default public void resetTiles() {
    }
}

