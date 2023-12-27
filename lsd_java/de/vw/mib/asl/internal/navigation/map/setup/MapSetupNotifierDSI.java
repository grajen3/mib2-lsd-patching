/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIAdbEditVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSINavigationVW;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;

public class MapSetupNotifierDSI {
    private DSIAdbEditVW dsiAdbEditService;
    private DSIMapViewerControlVW dsiMapViewerControlMainMap;
    private DSIMapViewerControlVW dsiMapViewerControlSplitscreenMap;
    private DSINavigationVW dsiNavigation;

    public void dsiAdbEditGetEntries(long[] lArray, int n, int n2) {
        this.dsiAdbEditService.getEntries(lArray, n, n2);
    }

    public void dsiMapViewerMainConfigureFlags(int n, MapFlag[] mapFlagArray) {
        this.dsiMapViewerControlMainMap.configureFlags(n, mapFlagArray);
    }

    public void dsiMapViewerMainEhSetCategoryVisibility(int[] nArray, boolean[] blArray) {
        this.dsiMapViewerControlMainMap.ehSetCategoryVisibility(nArray, blArray);
    }

    public void dsiMapViewerMainEhSetCategoryVisibilityToDefault() {
        this.dsiMapViewerControlMainMap.ehSetCategoryVisibilityToDefault();
    }

    public void dsiMapViewerMainRbSelectAlternativeRoute(int n) {
        this.dsiMapViewerControlMainMap.rbSelectAlternativeRoute(n);
    }

    public void dsiMapViewerMainSetBrandIconStyle(int[] nArray, int n) {
        this.dsiMapViewerControlMainMap.setBrandIconStyle(nArray, n);
    }

    public void dsiMapViewerMainSetCarPosition(Point point) {
        this.dsiMapViewerControlMainMap.setCarPosition(point);
    }

    public void dsiMapViewerMainSetCityModelMode(int n) {
        this.dsiMapViewerControlMainMap.setCityModelMode(n);
    }

    public void dsiMapViewerMainSetDayView() {
        this.dsiMapViewerControlMainMap.setDayView();
    }

    public void dsiMapViewerMainSetEnableSoftJump(boolean bl) {
        this.dsiMapViewerControlMainMap.setEnableSoftJump(bl);
    }

    public void dsiMapViewerMainSetEnableSoftTilt(boolean bl) {
        this.dsiMapViewerControlMainMap.setEnableSoftTilt(bl);
    }

    public void dsiMapViewerMainSetEnableSoftZoom(boolean bl) {
        this.dsiMapViewerControlMainMap.setEnableSoftZoom(bl);
    }

    public void dsiMapViewerMainsetGeneralPoiVisibility(boolean bl) {
        this.dsiMapViewerControlMainMap.setGeneralPoiVisibility(bl);
    }

    public void dsiMapViewerMainSetGeneralPoiVisibility(boolean bl) {
        this.dsiMapViewerControlMainMap.setGeneralPoiVisibility(bl);
    }

    public void dsiMapViewerMainSetMetricSystem(int n) {
        this.dsiMapViewerControlMainMap.setMetricSystem(n);
    }

    public void dsiMapViewerMainSetMode(int n) {
        this.dsiMapViewerControlMainMap.setMode(n);
    }

    public void dsiMapViewerMainSetNightView() {
        this.dsiMapViewerControlMainMap.setNightView();
    }

    public void dsiMapViewerMainSetOrientation(int n, Point point) {
        this.dsiMapViewerControlMainMap.setOrientation(n, point);
    }

    public void dsiMapViewerMainSetRouteColoringPolicy(int n) {
        this.dsiMapViewerControlMainMap.setRouteColoringPolicy(n);
    }

    public void dsiMapViewerMainSetRouteVisibility(boolean bl) {
        this.dsiMapViewerControlMainMap.setRouteVisibility(bl);
    }

    public void dsiMapViewerMainSetTemperatureScale(int n) {
        this.dsiMapViewerControlMainMap.setTemperatureScale(n);
    }

    public void dsiMapViewerMainSetViewType(int n) {
        this.dsiMapViewerControlMainMap.setViewType(n);
    }

    public void dsiMapViewerMainSetZoomLevel(float f2, int n) {
        this.dsiMapViewerControlMainMap.setZoomLevel(f2, n);
    }

    public void dsiMapViewerMainShowTMCMessages(boolean bl) {
        this.dsiMapViewerControlMainMap.showTMCMessages(bl);
    }

    public void dsiMapViewerMainViewFreeze(boolean bl) {
        this.dsiMapViewerControlMainMap.viewFreeze(bl);
    }

    public void dsiMapViewerMainViewSetVisible(boolean bl) {
        this.dsiMapViewerControlMainMap.viewSetVisible(bl);
    }

    public void dsiMapViewerSplitScreenSetDayView() {
        this.dsiMapViewerControlSplitscreenMap.setDayView();
    }

    public void dsiMapViewerSplitScreenSetNightView() {
        this.dsiMapViewerControlSplitscreenMap.setNightView();
    }

    public void dsiNavigationEnableRgLaneGuidance(boolean bl) {
        this.dsiNavigation.enableRgLaneGuidance(bl);
    }

    public void setDsiAdbEditService(DSIAdbEditVW dSIAdbEditVW) {
        this.dsiAdbEditService = dSIAdbEditVW;
    }

    public void setDsiMapViewerControlMainMap(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControlMainMap = dSIMapViewerControlVW;
    }

    public void setDsiMapViewerControlSplitscreenMap(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControlSplitscreenMap = dSIMapViewerControlVW;
    }

    public void setDsiNavigation(DSINavigationVW dSINavigationVW) {
        this.dsiNavigation = dSINavigationVW;
    }

    public void setSpeedAndFlowRoadClass(int n) {
        this.dsiMapViewerControlMainMap.setSpeedAndFlowRoadClass(n);
    }
}

