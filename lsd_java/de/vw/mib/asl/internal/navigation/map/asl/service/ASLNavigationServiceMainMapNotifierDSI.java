/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.asl.service;

import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSINavigationVW;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class ASLNavigationServiceMainMapNotifierDSI {
    private final DSIMapViewerControlVW dsiMapViewerControl;
    private DSINavigationVW dsiNavigation;
    private final ASLNavigationServiceMainMapTarget target;

    ASLNavigationServiceMainMapNotifierDSI(DSIMapViewerControlVW dSIMapViewerControlVW, ASLNavigationServiceMainMapTarget aSLNavigationServiceMainMapTarget) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
        this.target = aSLNavigationServiceMainMapTarget;
    }

    void clearFlags() {
        this.dsiMapViewerControl.configureFlags(1, null);
    }

    void configureFlags(int n, MapFlag[] mapFlagArray) {
        this.dsiMapViewerControl.configureFlags(n, mapFlagArray);
    }

    void dragMap(short s, short s2) {
        this.dsiMapViewerControl.dragMap(s, s2);
    }

    public void ensureTMCVisibility(long l) {
        this.dsiMapViewerControl.ensureTMCVisibility(l);
    }

    public DSINavigationVW getDsiNavigation() {
        return this.dsiNavigation;
    }

    void getInfoForScreenPosition(Point point) {
        this.dsiMapViewerControl.getInfoForScreenPosition(this.target, point);
    }

    public void goToTMCMessage(long l) {
        this.dsiMapViewerControl.goToTMCMessage(l);
    }

    void setCarPosition(Point point) {
        this.dsiMapViewerControl.setCarPosition(point);
    }

    public void setDsiNavigation(DSINavigationVW dSINavigationVW) {
        this.dsiNavigation = dSINavigationVW;
    }

    void setGeneralPoiVisibility(boolean bl) {
        this.dsiMapViewerControl.setGeneralPoiVisibility(bl);
    }

    void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    void setLocationByLocation(NavLocation navLocation) {
        this.dsiMapViewerControl.setLocationByLocation(navLocation);
    }

    void setMapLayerVisible(int n) {
        int[] nArray = n != -1 ? new int[]{n} : new int[]{};
        this.dsiMapViewerControl.setMapLayerVisible(nArray);
    }

    void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
        this.dsiMapViewerControl.setMapViewPortByWGS84Rectangle(navRectangle, n);
    }

    void setMode(int n) {
        this.dsiMapViewerControl.setMode(n);
    }

    void setOrientation(int n) {
        this.dsiMapViewerControl.setOrientation(n, null);
    }

    void setScreenViewport(Rect rect) {
        this.dsiMapViewerControl.setScreenViewport(rect);
    }

    void setScreenViewportMaximum(Rect rect) {
        this.dsiMapViewerControl.setScreenViewportMaximum(rect);
    }

    void setViewType(int n) {
        this.dsiMapViewerControl.setViewType(n);
    }

    void setZoomArea(Rect rect) {
        this.dsiMapViewerControl.setZoomArea(rect);
    }

    void setZoomLevel(int n) {
        this.dsiMapViewerControl.setZoomLevel(n, -1);
    }

    void showSpeedAndFlowCongestion(boolean bl) {
        this.dsiMapViewerControl.showSpeedAndFlowCongestions(bl);
    }

    void showSpeedAndFlowFreeFlow(boolean bl) {
        this.dsiMapViewerControl.showSpeedAndFlowFreeFlow(bl);
    }

    void showTMCMessages(boolean bl) {
        this.dsiMapViewerControl.showTMCMessages(bl);
    }

    void stopScrollToDirection() {
        this.dsiMapViewerControl.stopScrollToDirection();
    }

    public void touchApproach(boolean bl) {
        this.dsiMapViewerControl.touchApproach(bl);
    }

    void viewFreeze() {
        this.dsiMapViewerControl.viewFreeze(true);
    }

    void viewSetInvisible() {
        this.dsiMapViewerControl.viewSetVisible(false);
    }

    void viewSetVisible() {
        this.dsiMapViewerControl.viewSetVisible(true);
    }

    void viewUnfreeze() {
        this.dsiMapViewerControl.viewFreeze(false);
    }

    public void setMobilityHorizonVisibility(boolean bl) {
        this.dsiMapViewerControl.setMobilityHorizonVisibility(bl);
    }
}

