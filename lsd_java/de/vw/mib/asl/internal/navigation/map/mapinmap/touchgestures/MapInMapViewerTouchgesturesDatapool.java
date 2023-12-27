/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures;

import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerDatapoolShared;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerTouchgesturesDatapool {
    private final MapInMapViewerDatapoolShared datapoolShared = MapInMapViewerDatapoolShared.getInstance();
    private int twoFingerX;
    private int twoFingerY;
    private int twoFingerZDelta;
    private int twoFingerZDistance;
    private float zoomLevelTwoFinger;

    public float getMapDatapoolZoomLevel() {
        return this.datapoolShared.getMapDatapoolZoomLevel();
    }

    public int getMapInMapZoomLevel() {
        return this.datapoolShared.getMapInMapZoomLevel();
    }

    public int getTwoFingerX() {
        return this.twoFingerX;
    }

    public int getTwoFingerY() {
        return this.twoFingerY;
    }

    public int getTwoFingerZDelta() {
        return this.twoFingerZDelta;
    }

    public int getTwoFingerZDistance() {
        return this.twoFingerZDistance;
    }

    public Rect getZoomArea() {
        return this.datapoolShared.getZoomArea();
    }

    public float getZoomLevelTwoFinger() {
        return this.zoomLevelTwoFinger;
    }

    public boolean isPerspectiveOverviewZoomActive() {
        return this.datapoolShared.isPerspectiveOverviewZoomActive();
    }

    public boolean isPerspectiveRangeViewActive() {
        return this.datapoolShared.isPerspectiveRangeViewActive();
    }

    public void setMapInMapZoomLevel(int n) {
        this.datapoolShared.setMapInMapZoomLevel(n);
    }

    public void setTwoFingerX(int n) {
        this.twoFingerX = n;
    }

    public void setTwoFingerY(int n) {
        this.twoFingerY = n;
    }

    public void setTwoFingerZDelta(int n) {
        this.twoFingerZDelta = n;
    }

    public void setTwoFingerZDistance(int n) {
        this.twoFingerZDistance = n;
    }

    public void setTwoFingerZoomActive(boolean bl) {
        this.datapoolShared.setTwoFingerZoomActive(bl);
    }

    public void setZoomLevelTwoFinger(float f2) {
        this.zoomLevelTwoFinger = f2;
    }
}

