/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.dsi;

import de.vw.mib.asl.internal.radio.amfm.dsi.HsmAmFmDsi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateInactive
extends AbstractHsmState {
    private final HsmAmFmDsi mDsiHsm;

    StateInactive(HsmAmFmDsi hsmAmFmDsi, String string, HsmState hsmState) {
        super(hsmAmFmDsi.getHsm(), string, hsmState);
        this.mDsiHsm = hsmAmFmDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 100000: {
                this.trans(this.mDsiHsm.stateActive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

