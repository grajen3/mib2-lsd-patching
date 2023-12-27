/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerDatapool {
    private int lastZoomLevelRangeview;
    private final IPersistedDestInputSetup persistedDestInputSetup;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private int twoFingerX;
    private int twoFingerY;
    private int twoFingerZDelta;
    private int twoFingerZDistance;
    private boolean twoFingerZoomActive;
    private float zoomLevelTwoFinger;
    private final MapDataPool mapDatapool;
    private boolean perspective2DNorthUpActive;
    private boolean perspective2DCarUpActive;
    private boolean perspective3DCarUpActive;
    private boolean perspectiveRangeViewActive;
    private boolean perspectiveOverviewZoomActive;

    public MapInMapViewerDatapool() {
        this.persistedDestInputSetup = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
        this.mapDatapool = DSIMapViewerControlFactoryVW.getMapDatapoolSplitScreen();
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public NavLocation getHomeLocation() {
        return this.persistedDestInputSetup.getHomeLocation();
    }

    public int getLastZoomLevelRangeview() {
        return this.lastZoomLevelRangeview;
    }

    public float getMapDataPoolZoomLevel() {
        return this.mapDatapool.getZoomLevel();
    }

    public Point getMapInMapCarPosition() {
        return this.persistedMapSetup.getMapInMapCarPosition();
    }

    public int getMapInMapMode() {
        return this.persistedMapSetup.getMapInMapMode();
    }

    public int getMapInMapOrientation() {
        return this.persistedMapSetup.getMapInMapOrientation();
    }

    public int getMapInMapZoomLevel() {
        return this.persistedMapSetup.getMapInMapZoomLevel();
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
        return this.mapDatapool.getZoomArea();
    }

    public float getZoomLevelTwoFinger() {
        return this.zoomLevelTwoFinger;
    }

    public boolean isAutoZoomMapInMap() {
        return this.persistedMapSetup.isAutoZoomMapInMap();
    }

    boolean isOverviewZoomActive() {
        return this.persistedMapSetup.getMapInMapMode() == 10;
    }

    public boolean isPerspective2DCarUpActive() {
        return this.perspective2DCarUpActive;
    }

    public boolean isPerspective2DNorthUpActive() {
        return this.perspective2DNorthUpActive;
    }

    public boolean isPerspective3DCarUpActive() {
        return this.perspective3DCarUpActive;
    }

    public boolean isPerspectiveOverviewZoomActive() {
        return this.perspectiveOverviewZoomActive;
    }

    public boolean isPerspectiveRangeViewActive() {
        return this.perspectiveRangeViewActive;
    }

    public boolean isSplitscreenMapVisible() {
        boolean bl = this.persistedMapSetup.isSplitScreenGuidance() && this.persistedMapSetup.getSplitScreenContentGuidance() == 6 || this.persistedMapSetup.isSplitScreenNoGuidance() && this.persistedMapSetup.getSplitScreenContentNoGuidance() == 4;
        return bl;
    }

    public boolean isTwoFingerZoomActive() {
        return this.twoFingerZoomActive;
    }

    public void setAutoZoomMapInMap(boolean bl) {
        this.persistedMapSetup.setAutoZoomMapInMap(bl);
    }

    public void setLastZoomLevelRangeview(int n) {
        this.lastZoomLevelRangeview = n;
    }

    public void setMapInMapCarPosition(Point point) {
        this.persistedMapSetup.setMapInMapCarPosition(point);
    }

    public void setMapInMapMode(int n) {
        this.persistedMapSetup.setMapInMapMode(n);
    }

    public void setMapInMapOrientation(int n) {
        this.persistedMapSetup.setMapInMapOrientation(n);
    }

    public void setMapInMapZoomLevel(int n) {
        this.persistedMapSetup.setMapInMapZoomLevel(n);
    }

    public void setPerspective2DCarUpActive(boolean bl) {
        this.perspective2DCarUpActive = bl;
    }

    public void setPerspective2DNorthUpActive(boolean bl) {
        this.perspective2DNorthUpActive = bl;
    }

    public void setPerspective3DCarUpActive(boolean bl) {
        this.perspective3DCarUpActive = bl;
    }

    public void setPerspectiveOverviewZoomActive(boolean bl) {
        this.perspectiveOverviewZoomActive = bl;
    }

    public void setPerspectiveRangeViewActive(boolean bl) {
        this.perspectiveRangeViewActive = bl;
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
        this.twoFingerZoomActive = bl;
    }

    public void setZoomLevelTwoFinger(float f2) {
        this.zoomLevelTwoFinger = f2;
    }
}

