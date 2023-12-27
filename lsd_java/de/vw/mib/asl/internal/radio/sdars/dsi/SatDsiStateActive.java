/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.internal.radio.sdars.dsi.AbstractDsiState;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiTarget;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatDsiStateActive
extends AbstractDsiState {
    SatDsiStateActive(SatDb satDb, SatDsiTarget satDsiTarget, HsmState hsmState) {
        super(satDb, satDsiTarget, satDsiTarget.getHsm(), "Active", hsmState);
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
                this.mTarget.transStateIdle();
                break;
            }
            case 100102: {
                this.mTarget.transStateInactive();
                break;
            }
            case 100006: 
            case 100105: {
                this.mTarget.addEvent(eventGeneric);
                break;
            }
            case 100106: {
                int n = eventGeneric.getInt(0);
                if (n == 1) break;
                this.mPool.setInt(17, n);
                this.mTarget.notifySelectionStatus(n);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

