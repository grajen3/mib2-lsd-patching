/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;

public class MapViewerStreetviewDatapool {
    private final MapDataPool datapoolMainMap = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    private final MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private NavLocationWgs84 streetViewPosition;
    private float[] zoomList;
    private int zoomListIndex;
    private int zoomListIndexMax;
    private int zoomListIndexMin;
    private int twoFingerZDistance;
    private float zoomLevel;
    private boolean dataConnectionAvailable;
    private boolean streetviewServiceAvailable;
    private boolean streetviewDSIready;

    public Point getHotPoint() {
        return this.datapoolMainMap.getHotPoint();
    }

    public NavLocationWgs84 getStreetViewPosition() {
        return this.streetViewPosition;
    }

    public int getTwoFingerZDistance() {
        return this.twoFingerZDistance;
    }

    public float getZoomLevel() {
        return this.zoomLevel;
    }

    public float[] getZoomList() {
        return this.zoomList;
    }

    public int getZoomListIndex() {
        return this.zoomListIndex;
    }

    public int getZoomListIndexMax() {
        return this.zoomListIndexMax;
    }

    public int getZoomListIndexMin() {
        return this.zoomListIndexMin;
    }

    public boolean isDataConnectionAvailable() {
        return this.dataConnectionAvailable;
    }

    public boolean isStreetviewLicenceOK() {
        return this.datapoolShared.isStreetviewLicenceOK();
    }

    public boolean isStreetViewAvailable() {
        return this.datapoolShared.isStreetViewAvailable();
    }

    public boolean isVelocityTresholdForStreetViewReached() {
        return this.datapoolShared.isVelocityTresholdForStreetViewReached();
    }

    public void setDataConnectionAvailable(boolean bl) {
        this.dataConnectionAvailable = bl;
    }

    public void setStreetviewLicenceOK(boolean bl) {
        this.datapoolShared.setStreetviewLicenceOK(bl);
    }

    public void setStreetViewAvailable(boolean bl) {
        this.datapoolShared.setStreetViewAvailable(bl);
    }

    public void setStreetViewPosition(NavLocationWgs84 navLocationWgs84) {
        this.streetViewPosition = navLocationWgs84;
    }

    public void setTwoFingerZDistance(int n) {
        this.twoFingerZDistance = n;
    }

    public void setVelocityTresholdForStreetViewReached(boolean bl) {
        this.datapoolShared.setVelocityTresholdForStreetViewReached(bl);
    }

    public void setZoomLevel(float f2) {
        this.zoomLevel = f2;
    }

    public void setZoomList(float[] fArray) {
        this.zoomList = fArray;
    }

    public void setZoomListIndex(int n) {
        this.zoomListIndex = n;
    }

    public void setZoomListIndexMax(int n) {
        this.zoomListIndexMax = n;
    }

    public void setZoomListIndexMin(int n) {
        this.zoomListIndexMin = n;
    }

    public boolean isClickInMapMenuActive() {
        return this.datapoolShared.isClickInMapMenuActive();
    }

    public void setStreetviewServiceAvailable(boolean bl) {
        this.streetviewServiceAvailable = bl;
    }

    public boolean isStreetviewServiceAvailable() {
        return this.streetviewServiceAvailable;
    }

    public boolean isDriverDistractionPreventionFeatureAvailable() {
        return this.datapoolShared.isDriverDistractionPreventionFeatureAvailable();
    }

    public void setStreetviewDSIready(boolean bl) {
        this.streetviewDSIready = bl;
    }

    public boolean getStreetviewDSIready() {
        return this.streetviewDSIready;
    }
}

