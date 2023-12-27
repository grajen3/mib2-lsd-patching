/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public final class MapViewerPerspectivesStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesStateMain]");
    private final MapViewerPerspectivesTargetHSM target;

    public MapViewerPerspectivesStateMain(MapViewerPerspectivesTargetHSM mapViewerPerspectivesTargetHSM, String string, HsmState hsmState) {
        super(mapViewerPerspectivesTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerPerspectivesTargetHSM;
    }

    private void checkCountryOverview() {
        this.logger.trace("checkCountryOverview()");
        if (!NavigationConfiguration.COUNTRY_OVERVIEW_FEATURE_AVAILABLE) {
            return;
        }
        if (!MapViewerUtils.isMainMapMaximumZoomListIndexReached()) {
            return;
        }
        this.target.transStateCountryOverview();
    }

    private void checkZoomLevelSwitchTo2DNorthOvershoot(int n) {
        int n2;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("checkZoomLevelSwitchTo2DNorthOvershoot(zoomLevel=").append(n).append(")").log();
        }
        if (this.target.datapool.isMobilityHorzionVisible()) {
            this.logger.trace("We ignore the NorthUpSwitch if MobilityHorizon is activ");
            return;
        }
        if (this.target.datapool.isPerspectiveDestinationZoom() || this.target.datapool.isPerspectiveRocketZoom() || this.target.datapool.isPerspectiveAlternativeRouteMap() || this.target.datapool.isPerspectiveOverviewZoom()) {
            this.logger.trace("We ignore the NorthUpSwitch because 2D or 3D mode is not active");
            return;
        }
        float f2 = MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        if (f2 > (float)(n2 = this.target.datapool.getZoomLevelSwitchToNorthUp())) {
            if (!this.target.datapool.isZoomLevelSwitchTo2DNorthOvershoot()) {
                this.target.datapool.setZoomLevelSwitchTo2DNorthOvershoot(true);
                this.target.datapool.setZoomLevelSwitchTo2DNorthUndershoot(false);
                this.logger.trace("sendHMIEvent(ASLNavigationMapViewSystemEventConstants.NAVI_ZOOMLIMIT_OVERSHOOT)");
                this.target.sendHMIEvent(96);
            }
        } else if (!this.target.datapool.isZoomLevelSwitchTo2DNorthUndershoot()) {
            this.target.datapool.setZoomLevelSwitchTo2DNorthOvershoot(false);
            this.target.datapool.setZoomLevelSwitchTo2DNorthUndershoot(true);
            this.logger.trace("sendHMIEvent(ASLNavigationMapViewSystemEventConstants.NAVI_ZOOMLIMIT_UNDERSHOOT)");
            this.target.sendHMIEvent(97);
        }
    }

    public HsmState dsiMapViewerControlUpdateZoomListIndex(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateZoomListIndex(zoomListIndex=").append(n).append(")").log();
        }
        if (!this.target.datapool.isMapInMainScreen()) {
            return null;
        }
        if (this.target.datapool.isPerspectiveRocketZoom()) {
            this.logger.trace("RocketZoom is currently enabled, the ZoomLevel won't be updated");
            return null;
        }
        if (this.target.datapool.isPerspectiveAlternativeRouteMap()) {
            this.logger.trace("Alternative route map is currently enabled, the ZoomLevel won't be updated");
            return null;
        }
        this.checkZoomLevelSwitchTo2DNorthOvershoot(n);
        this.checkCountryOverview();
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3499028: {
                this.handleASLNavigationMapMainActivateFinalDestinationZoom();
                break;
            }
            case 3499029: {
                this.handleASLNavigationMapMainActivateDestinationZoom();
                break;
            }
            case 1073742416: {
                this.handleASLNavigationMapViewToggleOverviewZoom();
                break;
            }
            case 1073742406: {
                this.handleASLNavigationMapViewActivateDestinationZoom();
                break;
            }
            case 1073742408: {
                this.handleASLNavigationMapViewActivateAlternativeRouteMap();
                break;
            }
            case 1074841920: {
                this.handleASLNavigationMapViewActivateWaypointTourOverviewMap();
                break;
            }
            case 1073742385: {
                this.handleASLNavigationMapSetupPerspectiveSet(eventGeneric);
                break;
            }
            case 1073744396: {
                this.handleASLNavigationMapViewSetRangeViewEnabled(eventGeneric);
                break;
            }
            case 1073742423: {
                this.handleASLNavigationMapViewSetZoomLimit(eventGeneric);
                break;
            }
            case 3499036: {
                this.handleZoomIndexChanged(eventGeneric);
                break;
            }
            case 3499051: {
                this.handleZoomLevelChanged(eventGeneric);
                break;
            }
            case 1073742382: {
                this.handleASLNavigationMapSetContent(eventGeneric);
                break;
            }
            case 3497006: {
                int n = eventGeneric.getInt(0);
                this.handleASLNavigationGuidanceStart(n);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationGuidanceStart(int n) {
        if (n == 1) {
            if (ASLNavigationUtilFactory.getNavigationUtilApi().isPreviousRoutePresent()) {
                if (ASLNavigationServiceMainMapDatapool.getInstance().getCachedPersistedPerspective() != -1) {
                    int n2 = ASLNavigationServiceMainMapDatapool.getInstance().getCachedPersistedPerspective();
                    ASLNavigationServiceMainMapDatapool.getInstance().setCachedPersistedPerspective(-1);
                    if (this.target.datapool.isMapInMainScreen()) {
                        ASLNavigationServiceMainMapDatapool.getInstance().setIgnoreNextPerspectiveSet(true);
                        ASLNavigationServiceMainMapDatapool.getInstance().setIgnoreNextFocusMode(true);
                    }
                    try {
                        switch (n2) {
                            case 10: {
                                this.handleASLNavigationMapViewToggleOverviewZoom();
                                this.logger.trace("Persisted map mode OVERVIEWMAP will be restored in main map.");
                                break;
                            }
                            case 9: {
                                this.handleASLNavigationMapMainActivateDestinationZoom();
                                this.logger.trace("Persisted map mode DESTINATIONMAP will be restored in main map.");
                                break;
                            }
                            default: {
                                this.logger.trace("Persisted map mode was neither overview not destinatino map!!! Nothing to do.");
                                break;
                            }
                        }
                    }
                    catch (Exception exception) {
                        ServiceManager.errorHandler.handleError(exception);
                    }
                }
            } else {
                ASLNavigationServiceMainMapDatapool.getInstance().setCachedPersistedPerspective(-1);
            }
        }
    }

    private void handleASLNavigationMapSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetContent(content= ").append(n).append(")").log();
        }
        if (n == 34) {
            this.target.transStatePNavView();
        }
        if (n != 0) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapPerspectiveStateChanged(99);
        }
        if (n == 0 && (this.target.datapool.isPerspectiveOverviewZoom() || this.target.datapool.isPerspectiveDestinationZoom())) {
            this.sendOverviewPerspective();
        }
    }

    private void sendOverviewPerspective() {
        if (this.target.datapool.isPerspectiveOverviewZoom()) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapPerspectiveStateChanged(3);
        } else if (this.target.datapool.isPerspectiveDestinationZoom()) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapPerspectiveStateChanged(1);
        } else if (this.target.datapool.isPerspectiveMobilityHorizon()) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapPerspectiveStateChanged(7);
        }
    }

    private void handleASLNavigationMapMainActivateDestinationZoom() {
        this.logger.trace("handleASLNavigationMapMainActivateDestinationZoom()");
        this.target.transStateDestinationZoom();
    }

    private void handleASLNavigationMapMainActivateFinalDestinationZoom() {
        this.logger.trace("handleASLNavigationMapMainActivateFinalDestinationZoom()");
        this.target.transStateFinalDestionationZoom();
    }

    private void handleASLNavigationMapSetupPerspectiveSet(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationMapSetupPerspectiveSet()");
        if (!ASLNavigationServiceMainMapDatapool.getInstance().isIgnoreNextPerspectiveSet()) {
            switch (eventGeneric.getInt(0)) {
                case 0: {
                    this.handleASLNavigationMapSetupPerspectiveSet2DNorth();
                    break;
                }
                case 1: {
                    this.handleASLNavigationMapSetupPerspectiveSet2DHeading();
                    break;
                }
                case 2: {
                    this.handleASLNavigationMapSetupPerspectiveSet25DHeading();
                    break;
                }
                case 3: {
                    this.handleASLNavigationMapSetupPerspectiveSet3DHeading();
                    break;
                }
                case 4: {
                    this.handleASLNavigationMapSetupPerspectiveSet3DDTM();
                    break;
                }
                default: {
                    this.logger.trace("setViewPerspective() received Unknown Perspective! ERROR!");
                    break;
                }
            }
        } else {
            ASLNavigationServiceMainMapDatapool.getInstance().setIgnoreNextPerspectiveSet(false);
            this.logger.trace("Ignore handleASLNavigationMapSetupPerspectiveSet() because the this set perspective has to be ignored after profile change.");
        }
    }

    private void handleASLNavigationMapSetupPerspectiveSet25DHeading() {
        this.logger.trace("handleASLNavigationMapSetupPerspectiveSet25DHeading()");
        this.target.transStateCarUpBirdview();
    }

    private void handleASLNavigationMapSetupPerspectiveSet2DHeading() {
        this.logger.trace("handleASLNavigationMapSetupPerspectiveSet2DHeading()");
        this.target.transStateCarUp2D();
    }

    private void handleASLNavigationMapSetupPerspectiveSet2DNorth() {
        this.logger.trace("handleASLNavigationMapSetupPerspectiveSet2DNorth()");
        this.target.transStateNorthUp2D();
    }

    private void handleASLNavigationMapSetupPerspectiveSet3DDTM() {
        this.logger.trace("handleASLNavigationMapSetupPerspectiveSet3DDTM()");
        this.target.transStateCarUp3D();
    }

    private void handleASLNavigationMapSetupPerspectiveSet3DHeading() {
        this.logger.error("handleASLNavigationMapSetupPerspectiveSet3DHeading() - 3D Heading is deprectated! HIGH uses 3DDTM and STD 25DHeading");
    }

    private void handleASLNavigationMapViewActivateAlternativeRouteMap() {
        this.logger.trace("handleASLNavigationMapViewActivateAlternativeRouteMap()");
        this.target.transStateAlternativeRoute();
    }

    private void handleASLNavigationMapViewActivateDestinationZoom() {
        this.logger.trace("handleASLNavigationMapViewActivateDestinationZoom()");
        Route route = this.target.datapool.getCurrentRoute();
        if (route == null) {
            this.target.transStateDestinationZoom();
            return;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        if (routeDestinationArray.length <= 1) {
            this.target.transStateDestinationZoom();
        } else if (this.target.datapool.isStatusLineInfo()) {
            this.target.transStateDestinationZoom();
        } else {
            this.target.transStateFinalDestionationZoom();
        }
    }

    private void handleASLNavigationMapViewActivateWaypointTourOverviewMap() {
        this.logger.trace("handleASLNavigationMapViewActivateWaypointTourOverviewMap()");
        this.target.transStateWayPointOverview();
    }

    private void handleASLNavigationMapViewSetRangeViewEnabled(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationMapViewSetRangeViewEnabled()");
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            this.target.transStateRangeView();
        } else {
            this.target.notifierModel.notifyRangeViewDisabled();
            this.target.notifierDSI.setMobilityHorizonInvisible();
        }
    }

    private void handleASLNavigationMapViewSetZoomLimit(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0) * 100;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewSetZoomLimit(zoomLimit= ").append(n).append(")").log();
        }
        this.target.datapool.setZoomLevelSwitchTo2DNorth(n);
    }

    private void handleASLNavigationMapViewToggleOverviewZoom() {
        this.logger.trace("handleASLNavigationMapViewToggleOverviewZoom()");
        this.target.transStateOverviewZoom();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleZoomIndexChanged(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleZoomIndexChanged(").append(n).append(") - calling dsiMapViewerControlUpdateZoomListIndex() directly").log();
        }
        this.dsiMapViewerControlUpdateZoomListIndex(n, 1);
    }

    private void handleZoomLevelChanged(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleZoomLevelChanged(").append(n).append(") - calling dsiMapViewerControlUpdateZoomListIndex() directly").log();
        }
        int n2 = MapViewerUtils.calculateZoomIndexByZoomLevel(n);
        this.dsiMapViewerControlUpdateZoomListIndex(n2, 1);
    }
}

