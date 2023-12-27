/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.guidance.IPersistedDestInputSetup;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerDatapoolShared$Holder;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerDatapoolShared {
    private int lastZoomLevelRangeview;
    private final MapDataPool mapInMapDatapool;
    private final IPersistedDestInputSetup persistedDestInputSetup;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private boolean perspective2DCarUpActive;
    private boolean perspective2DNorthUpActive;
    private boolean perspective3DCarUpActive;
    private boolean perspectiveOverviewZoomActive;
    private boolean perspectiveRangeViewActive;
    private boolean twoFingerZoomActive;

    public static MapInMapViewerDatapoolShared getInstance() {
        return MapInMapViewerDatapoolShared$Holder.INSTANCE;
    }

    MapInMapViewerDatapoolShared() {
        this.persistedDestInputSetup = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getDestInputSetup();
        this.mapInMapDatapool = DSIMapViewerControlFactoryVW.getMapDatapoolSplitScreen();
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

    public float getMapDatapoolZoomLevel() {
        return this.mapInMapDatapool.getZoomLevel();
    }

    public int getMapInMapMode() {
        return this.persistedMapSetup.getMapInMapMode();
    }

    public int getMapInMapPerspective() {
        return this.persistedMapSetup.getMapInMapOrientation();
    }

    public int getMapInMapZoomLevel() {
        return this.persistedMapSetup.getMapInMapZoomLevel();
    }

    public Rect getZoomArea() {
        return this.mapInMapDatapool.getZoomArea();
    }

    public boolean isAutoZoomMapInMap() {
        return this.persistedMapSetup.isAutoZoomMapInMap();
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

    public boolean isTwoFingerZoomActive() {
        return this.twoFingerZoomActive;
    }

    public void setAutoZoomMapInMap(boolean bl) {
        this.persistedMapSetup.setAutoZoomMapInMap(bl);
    }

    public void setLastZoomLevelRangeview(int n) {
        this.lastZoomLevelRangeview = n;
    }

    public void setMapInMapMode(int n) {
        this.persistedMapSetup.setMapInMapMode(n);
    }

    public void setMapInMapPerspective(int n) {
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

    public void setTwoFingerZoomActive(boolean bl) {
        this.twoFingerZoomActive = bl;
    }
}

