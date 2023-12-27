/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.focus;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapViewerFocusStateSurroundingZoom
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerFocusStateSurroundingZoom]");
    private final MapViewerFocusTargetHSM target;

    public MapViewerFocusStateSurroundingZoom(MapViewerFocusTargetHSM mapViewerFocusTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerFocusTargetHSM;
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

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(reveiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params=").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setSurroundingZoom(false);
        this.target.notifierModel.notifySurroundingZoomOff();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (!(this.target.datapool.isMapMoved() || this.target.datapool.isPerspectiveOverviewZoom() || this.target.datapool.isPerspectiveDestinationZoom() || this.target.datapool.isPerspectiveMobilityHorizon())) {
            this.logger.trace("MapMoved is false, so we activate CCPZoom");
            this.target.transStateCCPZoom();
            return;
        }
        this.target.datapool.setMapMoved(true);
        this.target.notifierModel.notifyMapMovedTrue();
        this.target.datapool.setSurroundingZoom(true);
        this.target.notifierModel.notifySurroundingZoomOn();
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModeFreeMap();
        this.target.notifierDSI.setLocationByLocation(this.target.datapool.getMapPosition());
        this.target.notifierDSI.setRotation(this.target.datapool.getMapRotation());
        if (this.target.isPerspectiveOverviewType()) {
            this.target.zoomByManualOverviewZoomLevel();
        } else {
            this.target.zoomByManualPersistedZoomLevel();
        }
        this.target.notifierDSI.viewFreezeFalse();
    }
}

