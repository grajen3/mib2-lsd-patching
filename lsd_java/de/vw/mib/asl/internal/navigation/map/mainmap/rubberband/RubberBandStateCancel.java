/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class RubberBandStateCancel
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberbandStateCancel]");
    private final RubberBandHsmTarget target;

    public RubberBandStateCancel(RubberBandHsmTarget rubberBandHsmTarget, String string, HsmState hsmState) {
        super(rubberBandHsmTarget.getHsm(), string, hsmState);
        this.target = rubberBandHsmTarget;
    }

    public HsmState dsiNavigationUpdateRgActive(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiNavigationUpdateRgActive(rgActive=").append(bl).append(", validFlag=").append(n).append(")").log();
        }
        if (bl) {
            this.target.datapool.setRgActiveTrueReceivedAfterCancelRubberBand(true);
            if (this.target.datapool.isActivateRubberBandReceivedWhileWaitingForLastCancel()) {
                this.target.transStateRubberBandActive();
            } else {
                this.target.transStateRubberBandInactive();
            }
        }
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
            case 1073742382: {
                this.handleSetContent(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
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
            if (this.target.datapool.isRgActiveTrueReceivedAfterCancelRubberBand()) {
                this.target.transStateRubberBandActive();
            } else {
                this.logger.trace("rgActive=true wasn't received yet, we have to wait for the southside before we can start a new rubberband manipulation");
                this.target.datapool.setActivateRubberBandReceivedWhileWaitingForLastCancel(true);
            }
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setRgActiveTrueReceivedAfterCancelRubberBand(false);
        this.target.datapool.setActivateRubberBandReceivedWhileWaitingForLastCancel(false);
        this.target.datapool.setNeedsRubberbandStart(true);
        ASLNavigationGuidanceFactory.getNavigationGuidanceApi().sendEvMapMainRubberbandManipulationCancel();
        this.target.notifierDSI.rgStopRubberbandManipulation();
    }
}

