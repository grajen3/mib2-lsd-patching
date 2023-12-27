/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;

public class MapViewerNotifierDSI {
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerHsmTarget - MapViewerDSINotifier] ");
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void setCarPosition(Point point) {
        this.LOGGER.trace("setCarPosition()");
        this.dsiMapViewerControl.setCarPosition(point);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    public void setLocationByLocation(NavLocation navLocation) {
        this.dsiMapViewerControl.setLocationByLocation(navLocation);
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setModePositionMap() {
        this.dsiMapViewerControl.setMode(1);
    }

    public void setZoomIndex(int n) {
        this.dsiMapViewerControl.setZoomLevel(32959, n);
    }

    public void viewSetVisible(boolean bl) {
        this.dsiMapViewerControl.viewSetVisible(bl);
    }
}

