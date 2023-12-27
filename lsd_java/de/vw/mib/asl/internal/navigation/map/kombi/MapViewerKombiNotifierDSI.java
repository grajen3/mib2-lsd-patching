/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapViewerKombiNotifierDSI {
    private DSIMapViewerControlVW mapViewerControl;

    public void dragMap(short s, short s2) {
        this.mapViewerControl.dragMap(s, s2);
    }

    public void set3DLandmarksVisible() {
        this.mapViewerControl.set3DLandmarksVisible(true);
    }

    public void setCarPosition(Point point) {
        this.mapViewerControl.setCarPosition(point);
    }

    public void setCityModelModeEnhanced() {
        this.mapViewerControl.setCityModelMode(2);
    }

    public void setCityModelModeOff() {
        this.mapViewerControl.setCityModelMode(0);
    }

    public void setDayView() {
        this.mapViewerControl.setDayView();
    }

    public void setEnableSoftZoom() {
        this.mapViewerControl.setEnableSoftZoom(true);
    }

    public void setGeneralPoiVisibilityFalse() {
        this.mapViewerControl.setGeneralPoiVisibility(false);
    }

    public void setGeneralPoiVisibilityTrue() {
        this.mapViewerControl.setGeneralPoiVisibility(true);
    }

    public void setHotPoint(Point point) {
        this.mapViewerControl.setHotPoint(point);
    }

    public void setMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.mapViewerControl = dSIMapViewerControlVW;
    }

    public void setMetricSystem(int n) {
        this.mapViewerControl.setMetricSystem(n);
    }

    public void setModePositionMap() {
        this.mapViewerControl.setMode(1);
    }

    public void setNightView() {
        this.mapViewerControl.setNightView();
    }

    public void setOrientation(int n) {
        this.mapViewerControl.setOrientation(n, null);
    }

    public void setRouteColoringPolicyRouteoption() {
        this.mapViewerControl.setRouteColoringPolicy(0);
    }

    void setSpeedAndFlowRoadClass(int n) {
        this.mapViewerControl.setSpeedAndFlowRoadClass(n);
    }

    public void setViewType(int n) {
        this.mapViewerControl.setViewType(n);
    }

    public void setZoomArea(Rect rect) {
        this.mapViewerControl.setZoomArea(rect);
    }

    public void setZoomLevel(float f2) {
        this.mapViewerControl.setZoomLevel(f2, -1);
    }

    public void showSpeedAndFlowCongestions(boolean bl) {
        this.mapViewerControl.showSpeedAndFlowCongestions(bl);
    }

    public void showSpeedAndFlowFreeFlow(boolean bl) {
        this.mapViewerControl.showSpeedAndFlowFreeFlow(bl);
    }

    public void showTMCMessages(boolean bl) {
        this.mapViewerControl.showTMCMessages(bl);
    }

    public void stopScrollToDirection() {
        this.mapViewerControl.stopScrollToDirection();
    }

    public void viewFreeze(boolean bl) {
        this.mapViewerControl.viewFreeze(bl);
    }

    public void viewSetInvisible() {
        this.mapViewerControl.viewSetVisible(false);
    }

    public void viewSetVisible() {
        this.mapViewerControl.viewSetVisible(true);
    }

    public void ehSetCategoryVisibility(int[] nArray, boolean[] blArray) {
        this.mapViewerControl.ehSetCategoryVisibility(nArray, blArray);
    }

    public void ehSetCategoryVisibilityToDefault() {
        this.mapViewerControl.ehSetCategoryVisibilityToDefault();
    }
}

