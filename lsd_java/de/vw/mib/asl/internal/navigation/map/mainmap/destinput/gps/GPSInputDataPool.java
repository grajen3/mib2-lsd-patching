/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputDataPool$Holder;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public final class GPSInputDataPool {
    static final int SCOPE_DESTINATION_MAP;
    static final int SCOPE_MAP_REFINEMENT;
    static final int SCOPE_POI;
    static final int SCOPE_POI_SEARCH_AREA;
    static final int SCOPE_UNUSED;
    public static final int ZOOMLEVEL_FACTOR;
    private boolean callGetInfoForScreenPosAfterReleased;
    private Point hotPoint;
    private int draggedX;
    private int draggedY;
    private ILocationWrapper locationCurrent;
    private int scope;
    private int selectedX;
    private int selectedY;
    private final MapDataPool mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    private final INavigationDP navigationDataPool = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    private Rect zoomArea;

    public static GPSInputDataPool getInstance() {
        return GPSInputDataPool$Holder.INSTANCE;
    }

    public NavLocation getDestInputLocation() {
        return this.navigationDataPool.getDestInputLocation();
    }

    public int getDraggedX() {
        return this.draggedX;
    }

    public int getDraggedY() {
        return this.draggedY;
    }

    public Point getHotPoint() {
        return this.hotPoint;
    }

    public ILocationWrapper getLocationCurrent() {
        return this.locationCurrent;
    }

    public NavLocation getMapInputLocation() {
        return this.navigationDataPool.getMapInputLocation();
    }

    public boolean getRGIsActive() {
        return this.navigationDataPool.getRGIsActive();
    }

    public int getScope() {
        return this.scope;
    }

    public int getSelectedX() {
        return this.selectedX;
    }

    public int getSelectedY() {
        return this.selectedY;
    }

    public NavLocation getSpellerLocation() {
        return this.navigationDataPool.getSpellerLocation();
    }

    public Rect getZoomArea() {
        return this.zoomArea;
    }

    public float[] getZoomList() {
        return this.mapDataPool.getZoomList();
    }

    public int getZoomListIndexMax() {
        return this.mapDataPool.getZoomListIndexMax();
    }

    public boolean isCallGetInfoForScreenPosAfterReleased() {
        return this.callGetInfoForScreenPosAfterReleased;
    }

    public void setCallGetInfoForScreenPosAfterReleased(boolean bl) {
        this.callGetInfoForScreenPosAfterReleased = bl;
    }

    public void setDestInputLocation(NavLocation navLocation) {
        this.navigationDataPool.setDestInputLocation(navLocation);
    }

    public void setDraggedX(int n) {
        this.draggedX = n;
    }

    public void setDraggedY(int n) {
        this.draggedY = n;
    }

    public void setHotPoint(Point point) {
        this.hotPoint = point;
    }

    public void setLocationCurrent(ILocationWrapper iLocationWrapper) {
        this.locationCurrent = iLocationWrapper;
    }

    public void setMapInputLocation(NavLocation navLocation) {
        this.navigationDataPool.setMapInputLocation(navLocation);
    }

    public void setScope(int n) {
        this.scope = n;
    }

    public void setSelectedX(int n) {
        this.selectedX = n;
    }

    public void setSelectedY(int n) {
        this.selectedY = n;
    }

    public void setSpellerLocation(NavLocation navLocation) {
        this.navigationDataPool.setSpellerLocation(navLocation);
    }

    public void setZoomArea(Rect rect) {
        this.zoomArea = rect;
    }
}

