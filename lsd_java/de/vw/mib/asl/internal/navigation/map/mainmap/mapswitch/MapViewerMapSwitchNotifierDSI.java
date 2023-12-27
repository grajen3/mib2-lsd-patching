/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapViewerMapSwitchNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchNotifierDSI] ");

    public void setCarPosition(Point point) {
        this.dsiMapViewerControl.setCarPosition(point);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    public void setMapModeDestinationMap() {
        this.dsiMapViewerControl.setMode(9);
    }

    public void setMapModeOverviewMap() {
        this.dsiMapViewerControl.setMode(10);
    }

    public void setMapModePositionMap() {
        this.dsiMapViewerControl.setMode(1);
    }

    public void setOrientation(int n) {
        this.dsiMapViewerControl.setOrientation(n, null);
    }

    public void setViewType(int n) {
        this.dsiMapViewerControl.setViewType(n);
    }

    public void setZoomArea(Rect rect) {
        this.dsiMapViewerControl.setZoomArea(rect);
    }

    public void setScreenViewport(Rect rect) {
        this.dsiMapViewerControl.setScreenViewport(rect);
    }

    public void setZoomLevel(float f2) {
        this.dsiMapViewerControl.setZoomLevel(f2, -1);
    }

    public void touchApproach(boolean bl) {
        this.LOGGER.makeTrace().append("touchApproach( ").append(bl).append(" )").log();
        this.dsiMapViewerControl.touchApproach(bl);
    }

    public void viewFreeze(boolean bl) {
        this.dsiMapViewerControl.viewFreeze(bl);
    }

    public void viewSetInvisible() {
        this.LOGGER.makeTrace().append("viewSetInvisible( )").log();
        this.dsiMapViewerControl.viewSetVisible(false);
    }

    public void viewSetVisible() {
        this.LOGGER.makeTrace().append("viewSetVisible( )").log();
        this.dsiMapViewerControl.viewSetVisible(true);
    }
}

