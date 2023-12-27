/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerRocketzoomStateActive
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerRocketzoomStateActive]");
    private int rocketZoomZoomLevelEndIndex;
    private int rocketZoomZoomLevelStartIndex;
    private float lastMainMapZoomLevel;
    private boolean rocketZoomTimeoutReceived;
    private final MapViewerRocketzoomTargetHSM target;
    private boolean acceptNextSetPerspectiveBecauseOfOvershoot;

    public MapViewerRocketzoomStateActive(MapViewerRocketzoomTargetHSM mapViewerRocketzoomTargetHSM, String string, HsmState hsmState) {
        super(mapViewerRocketzoomTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerRocketzoomTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateZoomListIndex(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateZoomListIndex() received zoomListIndex=").append(n).log();
        }
        if (this.rocketZoomTimeoutReceived && n == this.rocketZoomZoomLevelStartIndex) {
            this.target.transStateInactive();
            return null;
        }
        if (n == this.rocketZoomZoomLevelEndIndex) {
            this.rocketZoomTimeoutReceived = false;
            this.target.notifierModel.notifyRocketZoomOff();
            this.target.startTimer(6567168, (long)0, false);
        }
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 3499008: {
                this.handleEvPrivateMapViewerRocketZoomTimeOut();
                break;
            }
            case 1073742420: {
                this.handleASLNavigationMapViewZoomIn();
                break;
            }
            case 1073742422: {
                this.handleASLNavigationMapViewZoomOut();
                break;
            }
            case 1074841824: {
                this.handleASLNavigationMapViewTwoFingerZoomed(eventGeneric);
                break;
            }
            case 1074841825: {
                this.handleASLNavigationMapViewTwoFingerDragged(eventGeneric);
                break;
            }
            case 1073742411: {
                this.handleASLNavigationMapViewSetClickInMainMap(eventGeneric);
                break;
            }
            case 1073742385: {
                this.handleASLNavigationMapSetupPerspectiveSet(eventGeneric);
                break;
            }
            case 1073742408: {
                this.handleASLNavigationMapViewActivateAlternativeRouteMap(eventGeneric);
                break;
            }
            case 1073742406: {
                this.handleASLNavigationMapViewActivateDestinationZoom(eventGeneric);
                break;
            }
            case 1074841920: {
                this.handleASLNavigationMapViewActivateWaypointTourOverviewMap(eventGeneric);
                break;
            }
            case 1073744396: {
                this.handleASLNavigationMapViewSetRangeViewEnabled(eventGeneric);
                break;
            }
            case 1073742416: {
                this.handleASLNavigationMapViewToogleOverviewZoom(eventGeneric);
                break;
            }
            case 3499028: {
                this.handleEvPrivateMapMainActivateFinalDestinationZoom(eventGeneric);
                break;
            }
            case 3499029: {
                this.handleEvPrivateMapMainActivateDestinationZoom(eventGeneric);
                break;
            }
            case 1073742389: {
                this.handleASLNavigationMapSetupToogleAutoZoom(eventGeneric);
                break;
            }
            case 1073742382: {
                this.handleASLNavigationMapSetContent(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapSetContent(EventGeneric eventGeneric) {
        this.logger.trace("Main Map was left. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapSetupToogleAutoZoom(EventGeneric eventGeneric) {
        this.logger.trace("Autozoom was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleEvPrivateMapMainActivateDestinationZoom(EventGeneric eventGeneric) {
        this.logger.trace("Destination view was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleEvPrivateMapMainActivateFinalDestinationZoom(EventGeneric eventGeneric) {
        this.logger.trace("Final destination view was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewToogleOverviewZoom(EventGeneric eventGeneric) {
        this.logger.trace("Overview was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewSetRangeViewEnabled(EventGeneric eventGeneric) {
        this.logger.trace("Range view was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewActivateWaypointTourOverviewMap(EventGeneric eventGeneric) {
        this.logger.trace("Waypoint tour overview map was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewActivateDestinationZoom(EventGeneric eventGeneric) {
        this.logger.trace("Destination view was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewActivateAlternativeRouteMap(EventGeneric eventGeneric) {
        this.logger.trace("Alternative route map was activated. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapSetupPerspectiveSet(EventGeneric eventGeneric) {
        if (this.acceptNextSetPerspectiveBecauseOfOvershoot) {
            this.logger.trace("SetPerspective is accepted because it was triggered by overshoot event.");
            this.acceptNextSetPerspectiveBecauseOfOvershoot = false;
            return;
        }
        this.logger.trace("Perspective was changed. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewSetClickInMainMap(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 1) {
            this.logger.trace("A one finger drag appears while the rocket zoom is active. The rocket zoom will be stopped.");
            this.target.transStateInactive();
        }
        if (n == 3 || n == 0) {
            this.logger.trace("A click/press appears while the rocket zoom is active. The rocket zoom will be stopped.");
            this.target.transStateInactive();
        }
    }

    private void handleASLNavigationMapViewTwoFingerDragged(EventGeneric eventGeneric) {
        this.logger.trace("A two finger drag appears while the rocket zoom is active. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewTwoFingerZoomed(EventGeneric eventGeneric) {
        this.logger.trace("A two finger zoom appears while the rocket zoom is active. The rocket zoom will be stopped.");
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewZoomIn() {
        this.logger.trace("A zoom event appears while the rocket zoom is active. The rocket zoom will be stopped.");
        this.target.datapool.setAutoZoomMainMap(false);
        this.target.notifierModel.notifyAutoZoomDisabled();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAutozoomStatusChanged(false);
        this.target.transStateInactive();
    }

    private void handleASLNavigationMapViewZoomOut() {
        this.logger.trace("A zoom event appears while the rocket zoom is active. The rocket zoom will be stopped.");
        this.target.datapool.setAutoZoomMainMap(false);
        this.target.notifierModel.notifyAutoZoomDisabled();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAutozoomStatusChanged(false);
        this.target.transStateInactive();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handle(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()()");
    }

    private void handleEvPrivateMapViewerRocketZoomTimeOut() {
        this.logger.trace("handleEvPrivateMapViewerRocketZoomTimeOut()");
        this.rocketZoomTimeoutReceived = true;
        this.target.notifierModel.notifyRocketZoomOn();
        this.restoreZoomLevel();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (!this.rocketZoomTimeoutReceived) {
            this.target.stopTimer(6567168);
            MapViewerUtils.updateMainMapPersistedZoomLevel(MapViewerUtils.calculateZoomLevelByZoomIndex(this.rocketZoomZoomLevelEndIndex));
        } else {
            if (this.target.datapool.isPerspectiveDestinationZoom() || this.target.datapool.isPerspectiveOverviewZoom()) {
                this.target.datapool.setMainMapZoomLevel((int)this.lastMainMapZoomLevel);
            }
            int n = this.target.datapool.getZoomLevelSwitchToNorthUp();
            int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(this.rocketZoomZoomLevelStartIndex);
            if (n2 <= n && !this.target.datapool.isZoomLevelSwitchTo2DNorthUndershoot()) {
                this.target.datapool.setZoomLevelSwitchTo2DNorthOvershoot(false);
                this.target.datapool.setZoomLevelSwitchTo2DNorthUndershoot(true);
                this.logger.trace("sendHMIEvent(ASLNavigationMapViewSystemEventConstants.NAVI_ZOOMLIMIT_UNDERSHOOT)");
                this.target.sendHMIEvent(97);
            }
        }
        this.target.notifierModel.notifyRocketZoomOff();
        this.target.notifierModel.notifyRocketZoomEnabled();
        this.target.datapool.setPerspectiveRocketZoom(false);
        this.target.sendHMIEvent(95);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.lastMainMapZoomLevel = this.target.datapool.getMainMapZoomLevel();
        this.target.notifierModel.notifyRocketZoomOn();
        this.target.notifierModel.notifyRocketZoomDisabled();
        this.target.datapool.setPerspectiveRocketZoom(true);
        int n = this.target.datapool.getZoomListIndexCurrent();
        this.rocketZoomZoomLevelStartIndex = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive() && this.target.datapool.isAutoZoomMainMap() && this.target.datapool.getMapMode() == 1 ? MapViewerUtils.calculateZoomIndexByZoomLevel(this.target.datapool.getAutoZoomRecommendedZoomLast()) : (n == -1 ? MapViewerUtils.calculateZoomIndexByZoomLevel(this.target.datapool.getZoomLevel()) : n);
        this.rocketZoomZoomLevelEndIndex = this.rocketZoomZoomLevelStartIndex + 10;
        int n2 = this.target.datapool.getZoomListIndexMax();
        if (this.rocketZoomZoomLevelEndIndex > n2) {
            this.rocketZoomZoomLevelEndIndex = n2;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("rocketZoomStartIndex=").append(this.rocketZoomZoomLevelStartIndex).append(", rocketZoomEndIndex=").append(this.rocketZoomZoomLevelEndIndex).log();
        }
        if (!MapViewerUtils.isMainMapModeCurrentZoomable()) {
            this.logger.makeTrace().append("the current mapMode is not zoomable, we switch to FreeMap");
            this.target.notifierDSI.setModeFreeMap();
        }
        this.target.notifierDSI.setZoomIndex(this.rocketZoomZoomLevelEndIndex);
        int n3 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(this.rocketZoomZoomLevelEndIndex);
        this.target.datapool.setMainMapZoomLevel(n3);
        int n4 = this.target.datapool.getZoomLevelSwitchToNorthUp();
        if (n3 > n4 && !this.target.datapool.isZoomLevelSwitchTo2DNorthOvershoot()) {
            this.target.datapool.setZoomLevelSwitchTo2DNorthOvershoot(true);
            this.target.datapool.setZoomLevelSwitchTo2DNorthUndershoot(false);
            this.logger.trace("sendHMIEvent(ASLNavigationMapViewSystemEventConstants.NAVI_ZOOMLIMIT_OVERSHOOT)");
            this.target.sendHMIEvent(96);
            int n5 = this.target.datapool.getMainMapPerspective();
            if (n5 == 1 || n5 == 2 || n5 == 4) {
                this.acceptNextSetPerspectiveBecauseOfOvershoot = true;
            }
        }
    }

    private void restoreZoomLevel() {
        int n;
        this.logger.trace("restoreZoomLevel()");
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive() && this.target.datapool.isAutoZoomMainMap() && this.target.datapool.getMapMode() == 1) {
            this.logger.trace("autoZoom is enabled, so we zoom down to the last recommendedZoom");
            int n2 = this.target.datapool.getAutoZoomRecommendedZoomLast();
            n = MapViewerUtils.calculateZoomIndexByZoomLevel(n2);
        } else {
            n = this.rocketZoomZoomLevelStartIndex;
        }
        this.rocketZoomZoomLevelStartIndex = n;
        this.target.notifierDSI.setZoomIndex(n);
        this.target.datapool.setMainMapZoomLevel((int)MapViewerUtils.calculateZoomLevelByZoomIndex(n));
        if (!this.target.datapool.isMapInMainScreen()) {
            this.target.datapool.setZoomLevelMainMapBackup((int)MapViewerUtils.calculateZoomLevelByZoomIndex(n));
        }
    }
}

