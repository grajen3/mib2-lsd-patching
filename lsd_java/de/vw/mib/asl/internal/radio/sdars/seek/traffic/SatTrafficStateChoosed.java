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

final class SatTrafficStateChoosed
extends AbstractSatTrafficState {
    SatTrafficStateChoosed(SatTrafficWxTarget satTrafficWxTarget, AbstractHsmState abstractHsmState) {
        super(satTrafficWxTarget, "Choosed", abstractHsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("SatTrafficStateChoosed is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(42, this.getName());
                break;
            }
            case 3: {
                this.trans(this.mTarget.mStateNormal);
                this.mTarget.updateCurrentMarketToHmi();
                break;
            }
            case 100005: {
                LogMessage logMessage = this.getLogHandler().getLogMsg();
                if (logMessage != null) {
                    logMessage.append("Market unchoosed, go back to ").append(this.mTarget.mStateNotChoosed.getName()).log();
                }
                this.trans(this.mTarget.mStateNotChoosed);
                break;
            }
            case 100004: {
                LogMessage logMessage = this.getLogHandler().getLogMsg();
                if (logMessage != null) {
                    logMessage.append("Market unchoosed, go back to ").append(this.mTarget.mStateNotChoosed.getName()).log();
                }
                this.trans(this.mTarget.mStateNormal);
                this.mTarget.updateCurrentMarketToHmi();
                this.mPool.setInt(173, 0);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

