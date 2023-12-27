/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import org.dsi.ifc.map.Point;

public class MapViewerTouchgesturesNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    public void dragMap(short s, short s2) {
        this.dsiMapViewerControl.dragMap(s, s2);
    }

    public void getInfoForScreenPosition(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Point point) {
        this.dsiMapViewerControl.getInfoForScreenPosition(mapViewerTouchgesturesTargetHSM, point);
    }

    public void setDsiMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    public void setEnableSoftJump(boolean bl) {
        this.dsiMapViewerControl.setEnableSoftJump(bl);
    }

    public void setEnableSoftTilt(boolean bl) {
        this.dsiMapViewerControl.setEnableSoftTilt(bl);
    }

    public void setEnableSoftZoom(boolean bl) {
        this.dsiMapViewerControl.setEnableSoftZoom(bl);
    }

    public void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    public void setModeFreeMap() {
        this.dsiMapViewerControl.setMode(2);
    }

    public void setZoomLevel(float f2) {
        this.dsiMapViewerControl.setZoomLevel(f2, -1);
    }

    public void stopScrollToDirection() {
        this.dsiMapViewerControl.stopScrollToDirection();
    }
}

