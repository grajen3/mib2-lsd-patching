/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerPerspectivesNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        this.dsiMapViewerControl.configureFlags(n, mapFlagArray);
    }

    public void set3DLandmarksVisible() {
        this.dsiMapViewerControl.set3DLandmarksVisible(false);
    }

    public void setCityModelModeOff() {
        this.dsiMapViewerControl.setCityModelMode(0);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setGeneralPoiVisibilityFalse() {
        this.dsiMapViewerControl.setGeneralPoiVisibility(false);
    }

    public void setMobilityHorizonInvisible() {
        this.dsiMapViewerControl.setMobilityHorizonVisibility(false);
    }

    public void setMobilityHorizonVisible() {
        this.dsiMapViewerControl.setMobilityHorizonVisibility(true);
    }

    public void setMobilityHorizonZoomModeHorizonRoute() {
        this.dsiMapViewerControl.setMobilityHorizonZoomMode(2);
    }

    public void setModeMobilityHorizon() {
        this.dsiMapViewerControl.setMode(14);
    }

    public void setModeOverviewMap() {
        this.dsiMapViewerControl.setMode(10);
    }

    public void setModePositionMap() {
        this.dsiMapViewerControl.setMode(1);
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

    public void setZoomArea(Rect rect) {
        this.dsiMapViewerControl.setZoomArea(rect);
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

    public void viewSetInvisible() {
        this.dsiMapViewerControl.viewSetVisible(false);
    }

    public void viewSetVisible() {
        this.dsiMapViewerControl.viewSetVisible(true);
    }
}

