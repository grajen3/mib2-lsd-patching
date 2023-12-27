/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.focus;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapViewerFocusStateCCPZoom
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerFocusStateCCPZoom]");
    private final MapViewerFocusTargetHSM target;

    public MapViewerFocusStateCCPZoom(MapViewerFocusTargetHSM mapViewerFocusTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            this.logger.makeTrace().append("handleDefault(): receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setCcpZoom(false);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierModel.notifyMapMovedFalse();
        this.target.datapool.setMapMoved(false);
        this.target.datapool.setCcpZoom(true);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModePositionMap();
        if (this.target.datapool.isAutoZoomMainMap() || this.target.datapool.isAutozoomDeactivatedWhileDrag()) {
            this.logger.trace("autoZoom is enabled");
            this.target.notifierModel.notifyAutozoomTrue();
            this.target.datapool.setAutoZoomMainMap(true);
            this.target.datapool.setAutozoomDeactivatedWhileDrag(false);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAutozoomStatusChanged(true);
            this.target.zoomByAutozoom();
        } else {
            this.logger.trace("autoZoom is disabled, so we set the last zoom which was set by the user");
            this.target.zoomByManualPersistedZoomLevel();
        }
        this.target.notifierDSI.viewFreezeFalse();
        if (GoogleEarthUtils.isGoogleEarthActive()) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthMapPositionChanged();
        }
    }
}

