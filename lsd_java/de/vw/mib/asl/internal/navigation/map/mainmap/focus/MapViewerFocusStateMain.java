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

public final class MapViewerFocusStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerFocusStateMain]");
    private final MapViewerFocusTargetHSM target;

    public MapViewerFocusStateMain(MapViewerFocusTargetHSM mapViewerFocusTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742407: {
                this.handleASLNavigationMapViewActivateSurroundingZoom();
                break;
            }
            case 1073742409: {
                this.handleASLNavigationMapViewCenterMapToCCP();
                break;
            }
            case 3499070: {
                this.handleASLNavigationMapGuidanceStateChanged(eventGeneric);
                break;
            }
            case 1073743908: {
                this.handleASLNavigationTourModeSkipNextStopover();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationTourModeSkipNextStopover() {
        this.target.datapool.setMapReinitRequired(true);
    }

    private void handleASLNavigationMapViewActivateSurroundingZoom() {
        this.logger.trace("handleASLNavigationMapViewActivateSurroundingZoom()");
        if (this.target.datapool.isIgnoreNextFocusMode()) {
            this.logger.trace("Ignore handleASLNavigationMapViewActivateSurroundingZoom() because the this activate surrounding zoom has to be ignored after profile change.");
            this.target.datapool.setIgnoreNextFocusMode(false);
            return;
        }
        this.target.transStateSurroundingZoom();
    }

    private void handleASLNavigationMapViewCenterMapToCCP() {
        this.logger.trace("handleASLNavigationMapViewCenterMapToCCP()");
        if (this.target.datapool.isIgnoreNextFocusMode()) {
            this.logger.trace("Ignore handleASLNavigationMapViewCenterMapToCCP() because the this activate surrounding zoom has to be ignored after profile change.");
            this.target.datapool.setIgnoreNextFocusMode(false);
            return;
        }
        this.target.transStateCCPZoom();
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

    private void handleASLNavigationMapGuidanceStateChanged(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapGuidanceStateChanged( =").append(n).append(" )").log();
        }
        if (n == 1) {
            if (this.target.datapool.isMapMoved()) {
                this.target.datapool.setMapReinitRequired(true);
            }
            this.target.notifierModel.notifyMapMovedFalse();
            this.target.datapool.setMapMoved(false);
            if (this.target.datapool.isMapReinitRequired()) {
                this.target.datapool.setMapReinitRequired(false);
                this.target.sendHMIEvent(200282112);
            }
        }
    }
}

