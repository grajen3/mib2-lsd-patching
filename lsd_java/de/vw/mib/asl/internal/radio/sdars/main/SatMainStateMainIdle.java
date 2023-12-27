/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.main.AbstractMainState;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

final class SatMainStateMainIdle
extends AbstractMainState {
    SatMainStateMainIdle(SatDb satDb, SatMainTarget satMainTarget, Hsm hsm, HsmState hsmState) {
        super(satDb, satMainTarget, hsm, "stateMainIdle", hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mPool.setString(39, this.getName());
                break;
            }
            case 4: {
                this.mPool.setChannel(22, null);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

