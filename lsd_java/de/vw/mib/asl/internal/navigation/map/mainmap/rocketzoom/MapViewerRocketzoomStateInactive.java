/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerRocketzoomStateInactive
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerRocketzoomStateInactive]");
    private final MapViewerRocketzoomTargetHSM target;

    public MapViewerRocketzoomStateInactive(MapViewerRocketzoomTargetHSM mapViewerRocketzoomTargetHSM, String string, HsmState hsmState) {
        super(mapViewerRocketzoomTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerRocketzoomTargetHSM;
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
            case 1073742418: {
                this.handleToggleRocketZoom();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return null;
            }
        }
        return null;
    }

    private void handleToggleRocketZoom() {
        this.logger.trace("handleASLNavigationMapViewToggleRocketZoom()");
        if (this.target.datapool.isPerspectiveRocketZoom()) {
            this.logger.warn("Rocketzoom is still running, we ignore this toggleRocketZoom-Event");
            return;
        }
        this.target.transStateActive();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handle(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierModel.notifyRocketZoomEnabled();
    }
}

