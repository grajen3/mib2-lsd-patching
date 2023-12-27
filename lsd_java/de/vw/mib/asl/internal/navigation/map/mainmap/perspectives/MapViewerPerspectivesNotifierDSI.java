/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import org.dsi.ifc.global.NavLocation;

public class MapViewerPerspectivesNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void set3DLandmarksInvisible() {
        this.dsiMapViewerControl.set3DLandmarksVisible(false);
    }

    public void set3DLandmarksVisible() {
        this.dsiMapViewerControl.set3DLandmarksVisible(true);
    }

    public void setCityModelModeEnhanced() {
        this.dsiMapViewerControl.setCityModelMode(2);
    }

    public void setCityModelModeOff() {
        this.dsiMapViewerControl.setCityModelMode(0);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    void setLocationByLocation(NavLocation navLocation) {
        this.dsiMapViewerControl.setLocationByLocation(navLocation);
    }

    public void setLocationDestination() {
        this.dsiMapViewerControl.setLocation(1, (short)0);
    }

    public void setMobilityHorizonInvisible() {
        this.dsiMapViewerControl.setMobilityHorizonVisibility(false);
    }

    public void setMobilityHorizonVisible() {
        this.dsiMapViewerControl.setMobilityHorizonVisibility(true);
    }

    public void setMobilityHorizonZoomModeHorizon() {
        this.dsiMapViewerControl.setMobilityHorizonZoomMode(0);
    }

    public void setModeAlternativeRouteMap() {
        this.dsiMapViewerControl.setMode(6);
    }

    public void setModeDestinationMap() {
        this.dsiMapViewerControl.setMode(9);
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setModeMobilityHorizon() {
        this.dsiMapViewerControl.setMode(14);
    }

    public void setModeOverviewMap() {
        this.dsiMapViewerControl.setMode(10);
    }

    public void setModePNavOverview() {
        this.dsiMapViewerControl.setMode(16);
    }

    public void setModePositionMap() {
        this.dsiMapViewerControl.setMode(1);
    }

    public void setModeRouteOverview() {
        this.dsiMapViewerControl.setMode(18);
    }

    public void setOrientationHeadingUp() {
        this.dsiMapViewerControl.setOrientation(0, null);
    }

    public void setOrientationNorthUp() {
        this.dsiMapViewerControl.setOrientation(2, null);
    }

    public void setViewType2D() {
        this.dsiMapViewerControl.setViewType(0);
    }

    public void setViewType3D() {
        this.dsiMapViewerControl.setViewType(3);
    }

    public void setViewTypeBirdview() {
        this.dsiMapViewerControl.setViewType(1);
    }

    public void setZoomIndex(int n) {
        this.dsiMapViewerControl.setZoomLevel(32959, n);
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

