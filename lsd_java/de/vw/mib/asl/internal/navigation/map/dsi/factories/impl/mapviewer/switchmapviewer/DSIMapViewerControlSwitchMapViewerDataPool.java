/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.DSIMapViewerControlListener;
import org.dsi.ifc.map.Point;

public final class DSIMapViewerControlSwitchMapViewerDataPool {
    public static final int TIMEOUT_WAKEUP_SUSPEND;
    private DSIMapViewerControl dsiMapViewerControlCurrentMainMap;
    private int dsiMapViewerControlCurrentMainMapInstanceId;
    private DSIMapViewerControl dsiMapViewerControlCurrentSplitscreenMap;
    private DSIMapViewerControlListener dsiMapViewerControlListener;
    private DSIMapViewerControl[] dsiMapViewerControlsMainMap;
    private DSIMapViewerControl[] dsiMapViewerControlsSplitscreenMap;
    private boolean googleEarthRegistered;
    private final MapDataPool mapDataPool;
    private boolean mapViewerCurrentAwakeReceived;
    private boolean mapViewerCurrentSuspendedReceived;
    private final MapViewerDatapoolShared mapViewerDatapoolShared;
    private int mapViewerNewId;
    private final PersistedMapSetup persistedMapSetup;
    private boolean resetGoogleEarth;
    private boolean runlevelSuspendedReveivedAfterSetNotification;
    private boolean suspendInProgress;
    private boolean wakeupInProgress;
    private boolean resentConnectionState;

    public DSIMapViewerControlSwitchMapViewerDataPool(MapDataPool mapDataPool) {
        this.mapDataPool = mapDataPool;
        this.mapViewerDatapoolShared = MapViewerDatapoolShared.getInstance();
        this.persistedMapSetup = PersistedMapSetup.getInstance();
    }

    public int getAutoZoomRecommendedZoomLast() {
        return this.persistedMapSetup.getAutoZoomRecommendedZoomLast();
    }

    public DSIMapViewerControl getDsiMapViewerControlCurrentMainMap() {
        return this.dsiMapViewerControlCurrentMainMap;
    }

    public int getDsiMapViewerControlCurrentMainMapInstanceId() {
        return this.dsiMapViewerControlCurrentMainMapInstanceId;
    }

    public DSIMapViewerControl getDsiMapViewerControlCurrentSplitscreenMap() {
        return this.dsiMapViewerControlCurrentSplitscreenMap;
    }

    public DSIMapViewerControlListener getDsiMapViewerControlListener() {
        return this.dsiMapViewerControlListener;
    }

    public DSIMapViewerControl[] getDsiMapViewerControlsMainMap() {
        return this.dsiMapViewerControlsMainMap;
    }

    public DSIMapViewerControl[] getDsiMapViewerControlsSplitscreenMap() {
        return this.dsiMapViewerControlsSplitscreenMap;
    }

    public Point getMainMapCarPosition() {
        return this.persistedMapSetup.getMainMapCarPosition();
    }

    public MapDataPool getMapDataPool() {
        return this.mapDataPool;
    }

    public short getMapRotation() {
        return this.mapViewerDatapoolShared.getMapRotation();
    }

    public int getMapViewerNewId() {
        return this.mapViewerNewId;
    }

    public boolean isAutoZoomMainMap() {
        return this.persistedMapSetup.isAutoZoomMainMap();
    }

    public boolean isGoogleEarthRegistered() {
        return this.googleEarthRegistered;
    }

    public boolean isMapViewerCurrentAwakeReceived() {
        return this.mapViewerCurrentAwakeReceived;
    }

    public boolean isMapViewerCurrentSuspendedReceived() {
        return this.mapViewerCurrentSuspendedReceived;
    }

    public boolean isResetGoogleEarth() {
        return this.resetGoogleEarth;
    }

    public boolean isRunlevelSuspendedReveivedAfterSetNotification() {
        return this.runlevelSuspendedReveivedAfterSetNotification;
    }

    public boolean isSuspendInProgress() {
        return this.suspendInProgress;
    }

    public boolean isSwitchInProgress() {
        return this.mapViewerDatapoolShared.isSwitchInProgress();
    }

    public boolean isWakeupInProgress() {
        return this.wakeupInProgress;
    }

    public void setDsiMapViewerControlCurrentMainMap(DSIMapViewerControl dSIMapViewerControl) {
        this.dsiMapViewerControlCurrentMainMap = dSIMapViewerControl;
    }

    public void setDsiMapViewerControlCurrentMainMapInstanceId(int n) {
        this.dsiMapViewerControlCurrentMainMapInstanceId = n;
    }

    public void setDsiMapViewerControlCurrentSplitscreenMap(DSIMapViewerControl dSIMapViewerControl) {
        this.dsiMapViewerControlCurrentSplitscreenMap = dSIMapViewerControl;
    }

    public void setDsiMapViewerControlListener(DSIMapViewerControlListener dSIMapViewerControlListener) {
        this.dsiMapViewerControlListener = dSIMapViewerControlListener;
    }

    public void setDsiMapViewerControlsMainMap(DSIMapViewerControl[] dSIMapViewerControlArray) {
        this.dsiMapViewerControlsMainMap = dSIMapViewerControlArray;
    }

    public void setDsiMapViewerControlsSplitscreenMap(DSIMapViewerControl[] dSIMapViewerControlArray) {
        this.dsiMapViewerControlsSplitscreenMap = dSIMapViewerControlArray;
    }

    public void setGoogleEarthRegistered(boolean bl) {
        this.googleEarthRegistered = bl;
    }

    public void setMainMapLastMapType(int n) {
        this.persistedMapSetup.setMainMapLastMapType(n);
    }

    public void setMapViewerCurrentAwakeReceived(boolean bl) {
        this.mapViewerCurrentAwakeReceived = bl;
    }

    public void setMapViewerCurrentSuspendedReceived(boolean bl) {
        this.mapViewerCurrentSuspendedReceived = bl;
    }

    public void setMapViewerNewId(int n) {
        this.mapViewerNewId = n;
    }

    public void setResetGoogleEarth(boolean bl) {
        this.resetGoogleEarth = bl;
    }

    public void setRunlevelSuspendedReveivedAfterSetNotification(boolean bl) {
        this.runlevelSuspendedReveivedAfterSetNotification = bl;
    }

    public void setSuspendInProgress(boolean bl) {
        this.suspendInProgress = bl;
    }

    public void setSwitchInProgress(boolean bl) {
        this.mapViewerDatapoolShared.setSwitchInProgress(bl);
    }

    public void setWakeupInProgress(boolean bl) {
        this.wakeupInProgress = bl;
    }

    public void setResentConnectionState(boolean bl) {
        this.resentConnectionState = bl;
    }

    public boolean isResentConnectionState() {
        return this.resentConnectionState;
    }

    public boolean isConnectionStateAllow() {
        return this.mapViewerDatapoolShared.isConnectionStateAllow();
    }
}

