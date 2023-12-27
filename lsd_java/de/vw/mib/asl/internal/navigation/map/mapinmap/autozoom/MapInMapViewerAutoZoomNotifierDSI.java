/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;

public class MapInMapViewerAutoZoomNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;
    private DSIMapViewerZoomEngineVW dsiMapViewerZoomEngineVW;

    public void autoZoomEnable(boolean bl) {
        this.dsiMapViewerZoomEngineVW.autoZoomEnable(bl);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setDsiMapViewerZoomEngineVW(DSIMapViewerZoomEngineVW dSIMapViewerZoomEngineVW) {
        this.dsiMapViewerZoomEngineVW = dSIMapViewerZoomEngineVW;
    }

    public void setZoomLevel(float f2) {
        this.dsiMapViewerControl.setZoomLevel(f2, -1);
    }
}

