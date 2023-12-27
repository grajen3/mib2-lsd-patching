/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.autozoom;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapViewerAutoZoomNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;
    private DSIMapViewerZoomEngineVW dsiMapViewerZoomEngine;

    public void autoZoomEnable() {
        this.dsiMapViewerZoomEngine.autoZoomEnable(true);
    }

    public void setCarPosition(Point point) {
        this.dsiMapViewerZoomEngine.setCarPosition(point);
    }

    public void viewFreeze(boolean bl) {
        this.dsiMapViewerControl.viewFreeze(bl);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setDsiMapViewerZoomEngine(DSIMapViewerZoomEngineVW dSIMapViewerZoomEngineVW) {
        this.dsiMapViewerZoomEngine = dSIMapViewerZoomEngineVW;
    }

    public void setMapOrientation(int n) {
        this.dsiMapViewerZoomEngine.setMapOrientation(n);
    }

    public void setMapRotation(short s) {
        this.dsiMapViewerZoomEngine.setMapRotation(s);
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setViewType(int n) {
        this.dsiMapViewerZoomEngine.setViewType(n);
    }

    public void setZoomArea(Rect rect) {
        this.dsiMapViewerZoomEngine.setZoomArea(rect);
    }

    public void setZoomIndex(int n) {
        this.dsiMapViewerControl.setZoomLevel(32959, n);
    }

    public void setZoomLevel(float f2) {
        this.dsiMapViewerControl.setZoomLevel(f2, -1);
    }
}

