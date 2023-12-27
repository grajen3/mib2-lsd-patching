/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocationWgs84;

public final class MapViewerPerspectivesStateOverviewZoom
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesStateOverviewZoom]");
    private final MapViewerPerspectivesTargetHSM target;

    public MapViewerPerspectivesStateOverviewZoom(MapViewerPerspectivesTargetHSM mapViewerPerspectivesTargetHSM, String string, HsmState hsmState) {
        super(mapViewerPerspectivesTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerPerspectivesTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapPosition(mapPosition=").append(navLocationWgs84.toString()).append(")").log();
        }
        this.target.datapool.setMapPositionOverviewZoom(navLocationWgs84);
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
            case 3499036: {
                this.handleZoomLevelChangedByUser();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() Ev Id: ").append(eventGeneric.getReceiverEventId()).append(" PARAMS: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setMapPositionOverviewZoom(null);
        this.target.datapool.setPerspectiveOverviewZoom(false);
        this.target.notifierModel.notifyOverviewZoomOff();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setMapMoved(false);
        this.target.datapool.setPerspectiveOverviewZoom(true);
        this.target.datapool.setFocusCCPZoom(false);
        this.target.datapool.setFocusSurroundingZoom(false);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModeOverviewMap();
        this.target.notifierDSI.setViewType2D();
        this.target.notifierDSI.setOrientationNorthUp();
        if (this.target.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
            this.target.notifierDSI.setCityModelModeEnhanced();
        } else {
            this.target.notifierDSI.setCityModelModeOff();
        }
        this.target.notifierDSI.set3DLandmarksVisible();
        this.target.notifierDSI.viewFreezeFalse();
        this.target.notifierModel.notifyOverviewZoomOn();
        this.target.notifierModel.notifyMapMovedFalse();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapPerspectiveStateChanged(3);
    }

    private void handleZoomLevelChangedByUser() {
        this.logger.trace("handleZoomLevelChangedByUser()");
        if (!this.target.datapool.isMapInMainScreen()) {
            this.logger.warn("handleZoomLevelChangedByUser() - we are not in main map, zooming will be ignored");
            return;
        }
        NavLocationWgs84 navLocationWgs84 = this.target.datapool.getMapPositionOverviewZoom();
        if (navLocationWgs84 == null) {
            this.logger.warn("handleZoomLevelChangedByUser() - no mapPosition for overviewZoom was send by the southside");
        } else {
            this.logger.trace("handleZoomLevelChangedByUser() - updating map position");
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocationWgs84.latitude, navLocationWgs84.longitude);
            this.target.datapool.setMapPosition(iLocationWrapper.getLocation());
        }
        this.target.datapool.setMapMoved(true);
        this.target.notifierModel.notifyMapMovedTrue();
    }
}

