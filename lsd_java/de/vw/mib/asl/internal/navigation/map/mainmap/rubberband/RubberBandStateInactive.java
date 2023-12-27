/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class RubberBandStateInactive
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberBandStateInactive]");
    private final RubberBandHsmTarget target;

    public RubberBandStateInactive(RubberBandHsmTarget rubberBandHsmTarget, String string, HsmState hsmState) {
        super(rubberBandHsmTarget.getHsm(), string, hsmState);
        this.target = rubberBandHsmTarget;
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
            case 1073742382: {
                this.handleSetContent(eventGeneric);
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
            this.logger.makeTrace().append("handleDefault() ").append(eventGeneric).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n == 33) {
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("handleSetContent(content=").append(n).log();
            }
            this.target.transStateRubberBandActive();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (this.target.datapool.getDrageRouteMarker() != 0) {
            this.target.notifierDSI.setDragRouteMarker(0);
        }
        this.target.notifierModel.notifyLoadingStatusIdle();
    }
}

