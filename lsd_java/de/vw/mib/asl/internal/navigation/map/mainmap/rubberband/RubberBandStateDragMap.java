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

public class RubberBandStateDragMap
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberBandStateDragMap]");
    private final RubberBandHsmTarget target;

    public RubberBandStateDragMap(RubberBandHsmTarget rubberBandHsmTarget, String string, HsmState hsmState) {
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
            case 1074841840: {
                return this.handleSetClickInMap(eventGeneric);
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

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private HsmState handleSetClickInMap(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMap()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                return this.myParent;
            }
            case 1: {
                return this.handleSetClickInMapDragged(eventGeneric);
            }
            case 2: {
                this.handleSetClickInMapReleased(eventGeneric);
                return this.myParent;
            }
            case 3: {
                return this.myParent;
            }
        }
        return this.myParent;
    }

    private void handleSetClickInMapReleased(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMapReleased");
        this.target.notifierDSI.stopScrollToDirection();
    }

    private HsmState handleSetClickInMapDragged(EventGeneric eventGeneric) {
        if (this.target.datapool.isDragRoute()) {
            return this.myParent;
        }
        this.target.notifierModel.notifyMapMovedTrue();
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetClickInMapDragged(x=").append(n).append(", y=").append(n2).append(")").log();
        }
        short s = (short)(n - this.target.datapool.getOneFingerClickX());
        short s2 = (short)(n2 - this.target.datapool.getOneFingerClickY());
        this.target.datapool.setOneFingerClickX(n);
        this.target.datapool.setOneFingerClickY(n2);
        this.target.notifierDSI.dragMap(s, s2);
        return null;
    }
}

