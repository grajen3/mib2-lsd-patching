/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek.traffic;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.AbstractSatTrafficState;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficWxTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

final class SatTrafficStateNormal
extends AbstractSatTrafficState {
    SatTrafficStateNormal(SatTrafficWxTarget satTrafficWxTarget, AbstractHsmState abstractHsmState) {
        super(satTrafficWxTarget, "Normal", abstractHsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("SatTrafficStateNormal is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(42, this.getName());
                break;
            }
            case 3: {
                boolean bl = this.mTarget.isBroadcastActive();
                LogMessage logMessage = this.getLogHandler().getLogMsg();
                if (logMessage != null) {
                    logMessage.append("+JUMP_TO_SELECTED_TRAFFIC_CHANNEL: Broadcast is ").append(bl ? "active" : "inactive").log();
                }
                if (bl) {
                    this.trans(this.mTarget.mStateJumped);
                    break;
                }
                this.trans(this.mTarget.mStateJumpPending);
                break;
            }
            case 1073742937: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

