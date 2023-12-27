/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.hknav;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;

public class MapViewerHKNavNotifierDSI {
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberBandNotifierDSI]");
    private DSIMapViewerControlVW dsiMapViewerControl;

    void clearFlags() {
        this.LOGGER.trace("clearFlags()");
        this.dsiMapViewerControl.configureFlags(1, null);
    }

    DSIMapViewerControlVW getDSIMapViewerControl() {
        return this.dsiMapViewerControl;
    }

    public void set3DLandmarksVisible() {
        this.dsiMapViewerControl.set3DLandmarksVisible(true);
    }

    public void setCityModelModeOff() {
        this.dsiMapViewerControl.setCityModelMode(0);
    }

    public void setCityModelModeEnhanced() {
        this.dsiMapViewerControl.setCityModelMode(2);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setOrientationNorthUp() {
        this.dsiMapViewerControl.setOrientation(2, null);
    }

    public void setViewType2D() {
        this.dsiMapViewerControl.setViewType(0);
    }

    public void setZoomLevel(float f2) {
        this.dsiMapViewerControl.setZoomLevel(f2, -1);
    }

    public void viewFreezeFalse() {
        this.dsiMapViewerControl.viewFreeze(false);
    }

    public void viewFreezeTrue() {
        this.dsiMapViewerControl.viewFreeze(true);
    }
}

