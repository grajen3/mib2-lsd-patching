/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerPerspectivesStateMobilityHorizon
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerPerspectivesStateMobilityHorizon]");
    private final MapInMapViewerPerspectivesTargetHsm target;

    public MapInMapViewerPerspectivesStateMobilityHorizon(MapInMapViewerPerspectivesTargetHsm mapInMapViewerPerspectivesTargetHsm, String string, AbstractHsmState abstractHsmState) {
        super(mapInMapViewerPerspectivesTargetHsm.getHsm(), string, abstractHsmState);
        this.target = mapInMapViewerPerspectivesTargetHsm;
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
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setPerspectiveRangeViewActive(false);
        if (this.target.datapool.isAutoZoomMapInMap()) {
            this.target.mapAPI.sendEvMapInMapPerspectiveChanged();
        }
        this.target.notifierDSI.setMobilityHorizonInvisible();
        this.target.notifierModel.notifyRangeViewDisabled();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setPerspectiveRangeViewActive(true);
        int n = this.target.zoomLevelDependingOnAutoZoom();
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModeMobilityHorizon();
        this.target.notifierDSI.setViewType2D();
        this.target.notifierDSI.setMobilityHorizonVisible();
        this.target.notifierDSI.setOrientationNorthUp();
        this.target.notifierDSI.setMobilityHorizonZoomModeHorizonRoute();
        this.target.notifierDSI.setZoomLevel(n);
        this.target.notifierDSI.viewSetVisible();
        this.target.notifierDSI.viewFreezeFalse();
        if (this.target.datapool.isAutoZoomMapInMap()) {
            this.target.mapAPI.sendEvMapInMapPerspectiveChanged();
        }
        this.target.notifierModel.notifyRangeViewEnabled();
        int n2 = MapViewerUtils.calculateZoomLevelNormalized(n);
        this.target.notifierModel.notifyZoomLevelChanged(n2);
    }
}

