/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import org.dsi.ifc.map.Point;

public class MapInMapViewerTouchgesturesNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setEnableSoftZoom(boolean bl) {
        this.dsiMapViewerControl.setEnableSoftZoom(bl);
    }

    public void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setZoomLevel(float f2) {
        this.dsiMapViewerControl.setZoomLevel(f2, -1);
    }

    public void viewSetVisible() {
        this.dsiMapViewerControl.viewSetVisible(true);
    }
}

