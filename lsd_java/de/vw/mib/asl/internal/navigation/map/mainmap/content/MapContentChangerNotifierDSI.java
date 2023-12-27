/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapContentChangerNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void configureFlags(int n, MapFlag[] mapFlagArray) {
        this.dsiMapViewerControl.configureFlags(n, mapFlagArray);
    }

    public void ensurePoiVisibility(NavLocation[] navLocationArray) {
        this.dsiMapViewerControl.ensurePoiVisibility(navLocationArray);
    }

    public void ensureTMCVisibility(long l) {
        this.dsiMapViewerControl.ensureTMCVisibility(l);
    }

    public void goToTMCMessage(long l) {
        this.dsiMapViewerControl.goToTMCMessage(l);
    }

    void resetLayers() {
        int[] nArray = new int[]{};
        this.dsiMapViewerControl.setMapLayerVisible(nArray);
    }

    public void set3DLandmarksVisible(boolean bl) {
        this.dsiMapViewerControl.set3DLandmarksVisible(bl);
    }

    public void setCityModelMode(int n) {
        this.dsiMapViewerControl.setCityModelMode(n);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setGeneralPoiVisibility(boolean bl) {
        this.dsiMapViewerControl.setGeneralPoiVisibility(bl);
    }

    public void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    public void setLocation(int n, short s) {
        this.dsiMapViewerControl.setLocation(n, s);
    }

    public void setLocationByLocation(NavLocation navLocation) {
        this.dsiMapViewerControl.setLocationByLocation(navLocation);
    }

    public void setMobilityHorizonVisibility(boolean bl) {
        this.dsiMapViewerControl.setMobilityHorizonVisibility(bl);
    }

    public void setMode(int n) {
        this.dsiMapViewerControl.setMode(n);
    }

    void setNightMode() {
        this.dsiMapViewerControl.setNightView();
    }

    public void setOrientation(int n, Point point) {
        this.dsiMapViewerControl.setOrientation(n, point);
    }

    public void setRouteVisibility(boolean bl) {
        this.dsiMapViewerControl.setRouteVisibility(bl);
    }

    public void setViewType(int n) {
        this.dsiMapViewerControl.setViewType(n);
    }

    public void setZoomArea(Rect rect) {
        this.dsiMapViewerControl.setZoomArea(rect);
    }

    public void setZoomLevel(float f2) {
        this.dsiMapViewerControl.setZoomLevel(f2, -1);
    }

    void showTMCMessages(boolean bl) {
        this.dsiMapViewerControl.showTMCMessages(bl);
    }

    void showTrafficEventListView(long[] lArray, boolean bl, boolean bl2) {
        this.dsiMapViewerControl.showTrafficEventListView(lArray, bl, bl2);
    }

    public void viewFreeze(boolean bl) {
        this.dsiMapViewerControl.viewFreeze(bl);
    }

    public void viewSetVisible(boolean bl) {
        this.dsiMapViewerControl.viewSetVisible(bl);
    }
}

