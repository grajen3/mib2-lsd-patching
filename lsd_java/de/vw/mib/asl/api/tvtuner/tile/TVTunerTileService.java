/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.tvtuner.tile;

import de.vw.mib.asl.api.tvtuner.tile.TVTunerTileListener;

public interface TVTunerTileService {
    default public void registerListener(TVTunerTileListener tVTunerTileListener) {
    }

    default public void unregisterListener(TVTunerTileListener tVTunerTileListener) {
    }

    default public void requestNextStation() {
    }

    default public void requestPreviousStation() {
    }

    default public void requestActiveSource(int n) {
    }
}

