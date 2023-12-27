/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewHsmTarget;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class DualListViewNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void configureFlagsAdd(MapFlag[] mapFlagArray) {
        this.dsiMapViewerControl.configureFlags(0, mapFlagArray);
    }

    public void configureFlagsClear() {
        this.dsiMapViewerControl.configureFlags(1, null);
    }

    public void dragMap(short s, short s2) {
        this.dsiMapViewerControl.dragMap(s, s2);
    }

    public void getInfoForScreenPosition(DualListViewHsmTarget dualListViewHsmTarget, Point point) {
        this.dsiMapViewerControl.getInfoForScreenPosition(dualListViewHsmTarget, point);
    }

    public DSIMapViewerControlVW getMapViewerControl() {
        return this.dsiMapViewerControl;
    }

    public void setEnableSoftJump(boolean bl) {
        this.dsiMapViewerControl.setEnableSoftJump(bl);
    }

    public void setGeneralPoiVisibility(boolean bl) {
        this.dsiMapViewerControl.setGeneralPoiVisibility(bl);
    }

    public void setMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setMapViewPortByLD(NavLocation navLocation, NavLocation navLocation2, int n) {
        this.dsiMapViewerControl.setMapViewPortByLD(navLocation, navLocation2, n);
    }

    public void setMode(int n) {
        this.dsiMapViewerControl.setMode(n);
    }

    public void setOrientation(int n) {
        this.dsiMapViewerControl.setOrientation(n, null);
    }

    public void setTMCVisibility(boolean bl) {
        this.dsiMapViewerControl.showTMCMessages(bl);
    }

    public void setViewType(int n) {
        this.dsiMapViewerControl.setViewType(n);
    }

    public void setZoomArea(Rect rect) {
        this.dsiMapViewerControl.setZoomArea(rect);
    }

    public void stopScrollToDirection() {
        this.dsiMapViewerControl.stopScrollToDirection();
    }

    public void viewFreeze(boolean bl) {
        this.dsiMapViewerControl.viewFreeze(bl);
    }
}

