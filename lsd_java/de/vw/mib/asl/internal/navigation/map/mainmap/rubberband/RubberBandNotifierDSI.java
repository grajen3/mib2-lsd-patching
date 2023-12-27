/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.DSINavigation;

public class RubberBandNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;
    private DSINavigation dsiNavigation;

    public void dragMap(short s, short s2) {
        this.dsiMapViewerControl.dragMap(s, s2);
    }

    public void dragRoute(short s, short s2) {
        this.dsiMapViewerControl.dragRoute(s, s2);
    }

    public void getInfoForScreenPosition(AbstractTarget abstractTarget, Point point) {
        this.dsiMapViewerControl.getInfoForScreenPosition(abstractTarget, point);
    }

    public void rgDeleteCalculatedRubberbandPoint() {
        this.dsiNavigation.rgDeleteCalculatedRubberbandPoint();
    }

    public void rgGetRouteBoundingRectangle(boolean bl, int n) {
        this.dsiNavigation.rgGetRouteBoundingRectangle(bl, n);
    }

    public void rgGetRubberBandPointPosition() {
        this.dsiNavigation.rgGetRubberBandPointPosition();
    }

    public void rgPrepareRubberbandManipulation(boolean bl) {
        this.dsiNavigation.rgPrepareRubberbandManipulation(bl);
    }

    public void rgSetRubberbandPosition(NavLocationWgs84 navLocationWgs84) {
        this.dsiNavigation.rgSetRubberbandPosition(navLocationWgs84);
    }

    public void rgStartRubberbandManipulation(int n) {
        this.dsiNavigation.rgStartRubberbandManipulation(n);
    }

    public void rgStopRubberbandManipulation() {
        this.dsiNavigation.rgStopRubberbandManipulation();
    }

    public void setDragRouteMarker(int n) {
        this.dsiMapViewerControl.setDragRouteMarker(n);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setDsiNavigation(DSINavigation dSINavigation) {
        this.dsiNavigation = dSINavigation;
    }

    public void setMapViewPortByWGS84Rectangle(NavRectangle navRectangle, int n) {
        this.dsiMapViewerControl.setMapViewPortByWGS84Rectangle(navRectangle, n);
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setZoomArea(Rect rect) {
        this.dsiMapViewerControl.setZoomArea(rect);
    }

    public void startRouteDragging(NavLocationWgs84 navLocationWgs84) {
        this.dsiMapViewerControl.startRouteDragging(navLocationWgs84);
    }

    public void stopScrollToDirection() {
        this.dsiMapViewerControl.stopScrollToDirection();
    }

    public void viewFreeze(boolean bl) {
        this.dsiMapViewerControl.viewFreeze(bl);
    }
}

