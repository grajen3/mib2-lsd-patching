/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.main;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;
    private DSIMapViewerZoomEngineVW dsiMapViewerZoomEngineVW;

    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        this.dsiMapViewerControl.configureFlags(n, mapFlagArray);
    }

    public DSIMapViewerZoomEngineVW getDsiMapViewerZoomEngineVW() {
        return this.dsiMapViewerZoomEngineVW;
    }

    public void set3DLandmarksVisible() {
        this.dsiMapViewerControl.set3DLandmarksVisible(false);
    }

    public void setCarPosition(Point point) {
        this.dsiMapViewerControl.setCarPosition(point);
    }

    public void setCityModelModeOff() {
        this.dsiMapViewerControl.setCityModelMode(0);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setDsiMapViewerZoomEngineVW(DSIMapViewerZoomEngineVW dSIMapViewerZoomEngineVW) {
        this.dsiMapViewerZoomEngineVW = dSIMapViewerZoomEngineVW;
    }

    public void setEnableSoftZoom(boolean bl) {
        this.dsiMapViewerControl.setEnableSoftZoom(bl);
    }

    public void setGeneralPoiVisibilityFalse() {
        this.dsiMapViewerControl.setGeneralPoiVisibility(false);
    }

    public void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    public void setLocation(int n, short s) {
        this.dsiMapViewerControl.setLocation(n, s);
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

