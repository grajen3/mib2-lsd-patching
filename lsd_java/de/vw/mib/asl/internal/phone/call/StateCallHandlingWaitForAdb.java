/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.internal.phone.call.HsmPhoneCallHandling;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateCallHandlingWaitForAdb
extends AbstractHsmState {
    private final HsmPhoneCallHandling target;

    public StateCallHandlingWaitForAdb(HsmPhoneCallHandling hsmPhoneCallHandling, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneCallHandling;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.init();
                this.target.clearNotification();
                this.target.setNotification();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAdbSetupUpdateAdbState(int n, int n2) {
        if (n == 2 && !this.target.getHsm().isActive(this.target.stateCallHandling)) {
            this.trans(this.target.stateInit);
        }
    }
}

