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

public class StateBluetoothInquiryWaitForWaitstateEntered
extends AbstractHsmState {
    private final HsmPhoneBluetoothInquiry target;

    public StateBluetoothInquiryWaitForWaitstateEntered(HsmPhoneBluetoothInquiry hsmPhoneBluetoothInquiry, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothInquiry;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742712: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace("ENTER_CONNECT_WAITSTATE handled in StateBluetoothInquiryWaitForWaitstateEntered");
                }
                this.target.sendHMIEvent(148);
                this.trans(this.target.getHsm().getPreviousState());
                break;
            }
            case 1073744401: {
                hsmState = this.target.stateInquiry;
                this.trans(this.target.stateInquiry);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

