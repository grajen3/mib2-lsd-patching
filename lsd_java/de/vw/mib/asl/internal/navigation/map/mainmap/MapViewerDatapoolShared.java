/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared$Holder;

public class MapViewerDatapoolShared {
    public static final int VALUE_NOT_SET;
    private boolean clickInMapMenuActive;
    private boolean focusCCPZoom;
    private boolean focusSurroundingZoom;
    private long homeFlagId;
    private int icMapServiceState;
    private boolean isASLServiceActive;
    private boolean isASLServiceProximityActive;
    private boolean isAutozoomDeactivatedWhileDrag;
    private boolean isMapFPKSwitchRunning;
    private boolean latestTouchApproach;
    private boolean mapInMainScreen;
    private boolean mapMoved;
    private short mapRotation;
    private boolean mapSwitchFunctionAvailableInKombi;
    private int mapSwitchState;
    private int mapViewer3Resolution;
    private boolean mapVisibilityForFPKSwitch;
    private boolean perspective25DCarUp;
    private boolean perspective2DCarUp;
    private boolean perspective2DNorthUp;
    private boolean perspective3DCarUp;
    private boolean perspective3DDTM;
    private boolean perspectiveAlternativeRouteMap;
    private boolean perspectiveCountryOverview;
    private boolean perspectiveDestinationZoom;
    private boolean perspectiveFinalDestinationZoom;
    private boolean perspectiveMobilityHorizon;
    private boolean perspectiveOverviewZoom;
    private boolean perspectivePNavOverview;
    private boolean streetViewVisible;
    private boolean perspectiveRocketZoom;
    private boolean perspectiveRouteOverviewActive;
    private boolean perspectiveWayPointOverviewZoomActive;
    private boolean pnavRouteVisibility;
    private boolean streetviewLicenceOK;
    private boolean streetViewAvailable;
    private boolean switchDoneAtLockMapViewer;
    private boolean switchInProgress;
    private boolean touchApproximated;
    private boolean twoFingerZoomActive;
    private boolean velocityTresholdForStreetViewReached;
    private int zoomLevelSwitchTo2DNorth = 1078071040;
    private boolean zoomLevelSwitchTo2DNorthOvershoot = false;
    private boolean zoomLevelSwitchTo2DNorthUndershoot = false;
    private boolean speechRecognitionActive;
    private boolean mapSetToVisibleByClient;
    private boolean mapExternalConfigured;
    private boolean continuousZoomActive;
    private int heading;
    private boolean driverDistractionPreventionFeatureAvailable = false;
    private int zoomLevelMainMapBackup;
    private int zoomLevelOverviewMapBackup;
    private int persistedPerspective = -1;
    private boolean googleEarthConnectionStateAllow;
    private int cachedPersistedPerspective = -1;
    private boolean ignoreNextPerspectiveSet;
    private boolean ignoreNextFocusMode;

    public static MapViewerDatapoolShared getInstance() {
        return MapViewerDatapoolShared$Holder.INSTANCE;
    }

    MapViewerDatapoolShared() {
    }

    public long getHomeFlagId() {
        return this.homeFlagId;
    }

    public int getICMapServiceState() {
        return this.icMapServiceState;
    }

    public boolean getLatestTouchApproach() {
        return this.latestTouchApproach;
    }

    public short getMapRotation() {
        return this.mapRotation;
    }

    public int getMapSwitchState() {
        return this.mapSwitchState;
    }

    public int getMapViewer3Resolution() {
        return this.mapViewer3Resolution;
    }

    public boolean getMapVisibilityForFPKSwitch() {
        return this.mapVisibilityForFPKSwitch;
    }

    public int getZoomLevelSwitchToNorthUp() {
        return this.zoomLevelSwitchTo2DNorth;
    }

    public boolean isASLServiceActive() {
        return this.isASLServiceActive;
    }

    public boolean isASLServiceProximityActive() {
        return this.isASLServiceProximityActive;
    }

    public boolean isAutozoomDeactivatedWhileDrag() {
        return this.isAutozoomDeactivatedWhileDrag;
    }

    public boolean isClickInMapMenuActive() {
        return this.clickInMapMenuActive;
    }

    public boolean isFocusCCPZoom() {
        return this.focusCCPZoom;
    }

    public boolean isFocusSurroundingZoom() {
        return this.focusSurroundingZoom;
    }

    public boolean isMapFPKSwitchRunning() {
        return this.isMapFPKSwitchRunning;
    }

    public boolean isMapInMainScreen() {
        return this.mapInMainScreen;
    }

    public boolean isMapMoved() {
        return this.mapMoved;
    }

    public boolean isMapSwitchFunctionAvailableInKombi() {
        return this.mapSwitchFunctionAvailableInKombi;
    }

    public boolean isPerspective25DCarUp() {
        return this.perspective25DCarUp;
    }

    public boolean isPerspective2DCarUp() {
        return this.perspective2DCarUp;
    }

    public boolean isPerspective2DNorthUp() {
        return this.perspective2DNorthUp;
    }

    public boolean isPerspective3DCarUp() {
        return this.perspective3DCarUp;
    }

    public boolean isPerspective3DDTM() {
        return this.perspective3DDTM;
    }

    public boolean isPerspectiveAlternativeRouteMap() {
        return this.perspectiveAlternativeRouteMap;
    }

    public boolean isPerspectiveCountryOverview() {
        return this.perspectiveCountryOverview;
    }

    public boolean isPerspectiveDestinationZoom() {
        return this.perspectiveDestinationZoom;
    }

    public boolean isPerspectiveFinalDestinationZoom() {
        return this.perspectiveFinalDestinationZoom;
    }

    public boolean isPerspectiveMobilityHorizon() {
        return this.perspectiveMobilityHorizon;
    }

    public boolean isPerspectiveOverviewZoom() {
        return this.perspectiveOverviewZoom;
    }

    public boolean isPerspectivePNavOverview() {
        return this.perspectivePNavOverview;
    }

    public boolean isPerspectiveRocketZoom() {
        return this.perspectiveRocketZoom;
    }

    public boolean isPerspectiveRouteOverviewActive() {
        return this.perspectiveRouteOverviewActive;
    }

    public boolean isPerspectiveWayPointOverviewZoomActive() {
        return this.perspectiveWayPointOverviewZoomActive;
    }

    public boolean isPnavRouteVisibility() {
        return this.pnavRouteVisibility;
    }

    public boolean isStreetviewLicenceOK() {
        return this.streetviewLicenceOK;
    }

    public boolean isStreetViewAvailable() {
        return this.streetViewAvailable;
    }

    public boolean isSwitchDoneAtLockMapViewer() {
        return this.switchDoneAtLockMapViewer;
    }

    public boolean isSwitchInProgress() {
        return this.switchInProgress;
    }

    public boolean isTouchApproximated() {
        return this.touchApproximated;
    }

    public boolean isTwoFingerZoomActive() {
        return this.twoFingerZoomActive;
    }

    public boolean isVelocityTresholdForStreetViewReached() {
        return this.velocityTresholdForStreetViewReached;
    }

    public boolean isZoomLevelSwitchTo2DNorthOvershoot() {
        return this.zoomLevelSwitchTo2DNorthOvershoot;
    }

    public boolean isZoomLevelSwitchTo2DNorthUndershoot() {
        return this.zoomLevelSwitchTo2DNorthUndershoot;
    }

    public void setASLServiceActive(boolean bl) {
        this.isASLServiceActive = bl;
    }

    public void setASLServiceProximityActive(boolean bl) {
        this.isASLServiceProximityActive = bl;
    }

    public void setAutozoomDeactivatedWhileDrag(boolean bl) {
        this.isAutozoomDeactivatedWhileDrag = bl;
    }

    public void setClickInMapMenuActive(boolean bl) {
        this.clickInMapMenuActive = bl;
    }

    public void setFocusCCPZoom(boolean bl) {
        this.focusCCPZoom = bl;
    }

    public void setFocusSurroundingZoom(boolean bl) {
        this.focusSurroundingZoom = bl;
    }

    public void setHomeFlagId(long l) {
        this.homeFlagId = l;
    }

    public void setICMapServiceState(int n) {
        this.icMapServiceState = n;
    }

    public void setLatestTouchApproach(boolean bl) {
        this.latestTouchApproach = bl;
    }

    public void setMapFPKSwitchRunning(boolean bl) {
        this.isMapFPKSwitchRunning = bl;
    }

    public void setMapInMainScreen(boolean bl) {
        this.mapInMainScreen = bl;
    }

    public void setMapMoved(boolean bl) {
        this.mapMoved = bl;
    }

    public void setMapRotation(short s) {
        this.mapRotation = s;
    }

    public void setMapSwitchFunctionAvailableInKombi(boolean bl) {
        this.mapSwitchFunctionAvailableInKombi = bl;
    }

    public void setMapSwitchState(int n) {
        this.mapSwitchState = n;
    }

    public void setMapViewer3Resolution(int n) {
        this.mapViewer3Resolution = n;
    }

    public void setMapVisibilityForFPKSwitch(boolean bl) {
        this.mapVisibilityForFPKSwitch = bl;
    }

    public void setPerspective25DCarUp(boolean bl) {
        this.perspective25DCarUp = bl;
    }

    public void setPerspective2DCarUp(boolean bl) {
        this.perspective2DCarUp = bl;
    }

    public void setPerspective2DNorthUp(boolean bl) {
        this.perspective2DNorthUp = bl;
    }

    public void setPerspective3DCarUp(boolean bl) {
        this.perspective3DCarUp = bl;
    }

    public void setPerspective3DDTM(boolean bl) {
        this.perspective3DDTM = bl;
    }

    public void setPerspectiveAlternativeRouteMap(boolean bl) {
        this.perspectiveAlternativeRouteMap = bl;
    }

    public void setPerspectiveCountryOverview(boolean bl) {
        this.perspectiveCountryOverview = bl;
    }

    public void setPerspectiveDestinationZoom(boolean bl) {
        this.perspectiveDestinationZoom = bl;
    }

    public void setPerspectiveFinalDestinationZoom(boolean bl) {
        this.perspectiveFinalDestinationZoom = bl;
    }

    public void setPerspectiveMobilityHorizon(boolean bl) {
        this.perspectiveMobilityHorizon = bl;
    }

    public void setPerspectiveOverviewZoom(boolean bl) {
        this.perspectiveOverviewZoom = bl;
    }

    public void setPerspectivePNavOverview(boolean bl) {
        this.perspectivePNavOverview = bl;
    }

    public void setPerspectiveRocketZoom(boolean bl) {
        this.perspectiveRocketZoom = bl;
    }

    public void setPerspectiveRouteOverviewActive(boolean bl) {
        this.perspectiveRouteOverviewActive = bl;
    }

    public void setPerspectiveWayPointOverviewZoomActive(boolean bl) {
        this.perspectiveWayPointOverviewZoomActive = bl;
    }

    public void setPnavRouteVisibility(boolean bl) {
        this.pnavRouteVisibility = bl;
    }

    public void setStreetviewLicenceOK(boolean bl) {
        this.streetviewLicenceOK = bl;
    }

    public void setStreetViewAvailable(boolean bl) {
        this.streetViewAvailable = bl;
    }

    public void setSwitchDoneAtLockMapViewer(boolean bl) {
        this.switchDoneAtLockMapViewer = bl;
    }

    public void setSwitchInProgress(boolean bl) {
        this.switchInProgress = bl;
    }

    public void setTouchApproximated(boolean bl) {
        this.touchApproximated = bl;
    }

    public void setTwoFingerZoomActive(boolean bl) {
        this.twoFingerZoomActive = bl;
    }

    public void setVelocityTresholdForStreetViewReached(boolean bl) {
        this.velocityTresholdForStreetViewReached = bl;
    }

    public void setZoomLevelSwitchTo2DNorthOvershoot(boolean bl) {
        this.zoomLevelSwitchTo2DNorthOvershoot = bl;
    }

    public void setZoomLevelSwitchTo2DNorthUndershoot(boolean bl) {
        this.zoomLevelSwitchTo2DNorthUndershoot = bl;
    }

    public void setZoomLevelSwitchToNorthUp(int n) {
        this.zoomLevelSwitchTo2DNorth = n;
    }

    public boolean isStreetViewVisible() {
        return this.streetViewVisible;
    }

    public void setStreetViewVisible(boolean bl) {
        this.streetViewVisible = bl;
    }

    public void setSpeechRecognitionActive(boolean bl) {
        this.speechRecognitionActive = bl;
    }

    public boolean isSpeechRecognitionActive() {
        return this.speechRecognitionActive;
    }

    public boolean isContinuousZoomActive() {
        return this.continuousZoomActive;
    }

    public MapViewerDatapoolShared setContinuousZoomActive(boolean bl) {
        this.continuousZoomActive = bl;
        return this;
    }

    public void setMapSetToVisibleByClient(boolean bl) {
        this.mapSetToVisibleByClient = bl;
    }

    public boolean isMapSetToVisibleByClient() {
        return this.mapSetToVisibleByClient;
    }

    public boolean isMapExternalConfigured() {
        return this.mapExternalConfigured;
    }

    public void setMapExternalConfigured(boolean bl) {
        this.mapExternalConfigured = bl;
    }

    public void setHeadingValue(int n) {
        this.heading = n;
    }

    public int getHeadingValue() {
        return this.heading;
    }

    public boolean isDriverDistractionPreventionFeatureAvailable() {
        return this.driverDistractionPreventionFeatureAvailable;
    }

    public void setDriverDistractionPreventionFeatureAvailable(boolean bl) {
        this.driverDistractionPreventionFeatureAvailable = bl;
    }

    public int getZoomLevelMainMapBackup() {
        return this.zoomLevelMainMapBackup;
    }

    public void setZoomLevelMainMapBackup(int n) {
        this.zoomLevelMainMapBackup = n;
    }

    public int getZoomLevelOverviewMapBackup() {
        return this.zoomLevelOverviewMapBackup;
    }

    public void setZoomLevelOverviewMapBackup(int n) {
        this.zoomLevelOverviewMapBackup = n;
    }

    public int getPersistedPerspective() {
        return this.persistedPerspective;
    }

    public void setPersistedPerspective(int n) {
        this.persistedPerspective = n;
    }

    public boolean isConnectionStateAllow() {
        return this.googleEarthConnectionStateAllow;
    }

    public void setConnectionStateAllow(boolean bl) {
        this.googleEarthConnectionStateAllow = bl;
    }

    public void setCachedPersistedPerspective(int n) {
        this.cachedPersistedPerspective = n;
    }

    public int getCachedPersistedPerspective() {
        return this.cachedPersistedPerspective;
    }

    public void setIgnoreNextPerspectiveSet(boolean bl) {
        this.ignoreNextPerspectiveSet = bl;
    }

    public boolean isIgnoreNextPerspectiveSet() {
        return this.ignoreNextPerspectiveSet;
    }

    public void setIgnoreNextFocusMode(boolean bl) {
        this.ignoreNextFocusMode = bl;
    }

    public boolean isIgnoreNextFocusMode() {
        return this.ignoreNextFocusMode;
    }
}

