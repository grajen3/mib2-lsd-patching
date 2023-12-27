/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothInquiry;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateBluetoothInquiryAbortPending
extends AbstractHsmState {
    private final HsmPhoneBluetoothInquiry target;

    public StateBluetoothInquiryAbortPending(HsmPhoneBluetoothInquiry hsmPhoneBluetoothInquiry, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothInquiry;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            default: 
        }
        hsmState = this.myParent;
        return hsmState;
    }

    public void dsiBluetoothResponseAbortInquiry(int n) {
        this.trans(this.target.stateInquiry);
    }
}

