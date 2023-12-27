/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;

public class MapViewerRocketzoomNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setZoomIndex(int n) {
        this.dsiMapViewerControl.setZoomLevel(32959, n);
    }
}

