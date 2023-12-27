/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerPerspectivesStateRangeView
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesStateRangeView]");
    private final MapViewerPerspectivesTargetHSM target;

    public MapViewerPerspectivesStateRangeView(MapViewerPerspectivesTargetHSM mapViewerPerspectivesTargetHSM, String string, HsmState hsmState) {
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
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.notifierModel.notifyRangeViewDisabled();
        this.target.datapool.setPerspectiveMobilityHorizon(false);
        this.target.notifierDSI.setMobilityHorizonInvisible();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setMapMoved(false);
        this.target.datapool.setFocusCCPZoom(false);
        this.target.datapool.setFocusSurroundingZoom(false);
        this.target.datapool.setPerspectiveMobilityHorizon(true);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModeMobilityHorizon();
        this.target.notifierDSI.setViewType2D();
        this.target.notifierDSI.setMobilityHorizonVisible();
        this.target.notifierDSI.setMobilityHorizonZoomModeHorizon();
        if (this.target.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
            this.target.notifierDSI.setCityModelModeEnhanced();
        } else {
            this.target.notifierDSI.setCityModelModeOff();
        }
        this.target.notifierDSI.set3DLandmarksVisible();
        this.target.notifierDSI.setOrientationNorthUp();
        this.target.notifierDSI.viewFreezeFalse();
        this.target.notifierModel.notifyRangeViewEnabled();
        this.target.notifierModel.notifyMapMovedFalse();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapPerspectiveStateChanged(7);
    }

    private void handleZoomLevelChangedByUser() {
        this.logger.trace("handleZoomLevelChangedByUser()");
        if (!this.target.datapool.isMapInMainScreen()) {
            this.logger.warn("handleZoomLevelChangedByUser() - we are not in main map, zooming will be ignored");
            return;
        }
        this.target.datapool.setMapMoved(true);
        this.target.notifierModel.notifyMapMovedTrue();
    }
}

