/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerPerspectivesStateWayPointOverview
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesStateWayPointOverview]");
    private final MapViewerPerspectivesTargetHSM target;

    public MapViewerPerspectivesStateWayPointOverview(MapViewerPerspectivesTargetHSM mapViewerPerspectivesTargetHSM, String string, HsmState hsmState) {
        super(mapViewerPerspectivesTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerPerspectivesTargetHSM;
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
        this.target.datapool.setPerspectiveWayPointOverviewZoomActive(false);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setPerspectiveWayPointOverviewZoomActive(false);
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
        this.target.notifierModel.notifyMapMovedFalse();
    }

    private void handleZoomLevelChangedByUser() {
        this.logger.trace("handleZoomLevelChangedByUser()");
        this.target.notifierModel.notifyMapMovedTrue();
    }
}

