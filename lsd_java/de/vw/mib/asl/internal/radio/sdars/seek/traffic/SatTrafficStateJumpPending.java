/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek.traffic;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.AbstractSatTrafficState;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficWxTarget;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.TrafficApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatTrafficStateJumpPending
extends AbstractSatTrafficState {
    int timerToNormalState = 1000;

    SatTrafficStateJumpPending(SatTrafficWxTarget satTrafficWxTarget, AbstractHsmState abstractHsmState) {
        super(satTrafficWxTarget, "JumpPending", abstractHsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("SatTrafficStateJumpPending is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(42, this.getName());
                break;
            }
            case 1076141827: {
                TrafficApi.jumpCancelled = true;
                this.mPool.setInt(173, 4);
                this.mTarget.startTimer(-1249509120, (long)this.timerToNormalState, false);
                break;
            }
            case 1073742937: {
                this.mTarget.processTMAlert();
                break;
            }
            case 100021: {
                this.mPool.setInt(173, 0);
                break;
            }
            case 4: {
                this.mTarget.stopTimer(-1249509120);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

