/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.internal.radio.sdars.dsi.AbstractDsiState;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatDsiStateIdle
extends AbstractDsiState {
    SatDsiStateIdle(SatDb satDb, SatDsiTarget satDsiTarget, HsmState hsmState) {
        super(satDb, satDsiTarget, satDsiTarget.getHsm(), "Idle", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mPool.setString(41, this.getName());
                break;
            }
            case 3: {
                EventGeneric eventGeneric2 = this.mTarget.nextEvent();
                if (eventGeneric2 == null) break;
                this.processEvent(eventGeneric2);
                break;
            }
            default: {
                hsmState = this.processEvent(eventGeneric);
            }
        }
        return hsmState;
    }

    private HsmState processEvent(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 100105: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.mTarget.transStateSelectStation();
                break;
            }
            case 100006: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.mTarget.transStateReset();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

