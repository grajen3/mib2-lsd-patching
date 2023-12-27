/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.Point;

public class DSIMapViewerGetInfoForScreenPositionNotifierDSI {
    private DSIMapViewerControl mapViewerControl;

    public void getInfoForScreenPosition(Point point) {
        this.mapViewerControl.getInfoForScreenPosition(point);
    }

    public DSIMapViewerControl getMapViewerControl() {
        return this.mapViewerControl;
    }

    public void setMapViewerControl(DSIMapViewerControl dSIMapViewerControl) {
        this.mapViewerControl = dSIMapViewerControl;
    }
}

