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

final class SatTrafficStateNotChoosed
extends AbstractSatTrafficState {
    SatTrafficStateNotChoosed(SatTrafficWxTarget satTrafficWxTarget, AbstractHsmState abstractHsmState) {
        super(satTrafficWxTarget, "NotChoosed", abstractHsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("SatTrafficStateNotChoosed is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(42, this.getName());
                this.mPool.setInt(173, 0);
                this.mTarget.updateCurrentMarketToHmi();
                break;
            }
            case 100004: {
                this.trans(this.mTarget.mStateChoosed);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

