/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.asl.internal.phone.bluetooth.AbstractHsmBluetoothServiceConnectState;
import de.vw.mib.asl.internal.phone.bluetooth.HsmPhoneBluetoothServiceConnect;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateBluetoothServiceConnectWaitForWaitstateEntered
extends AbstractHsmBluetoothServiceConnectState {
    private final HsmPhoneBluetoothServiceConnect target;

    public StateBluetoothServiceConnectWaitForWaitstateEntered(HsmPhoneBluetoothServiceConnect hsmPhoneBluetoothServiceConnect, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothServiceConnect;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742712: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace("ENTER_CONNECT_WAITSTATE handled in StateBluetoothServiceConnectWaitForWaitstateEntered");
                }
                this.target.sendHMIEvent(148);
                this.trans(this.target.getHsm().getPreviousState());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    @Override
    public HsmState dsiBluetoothResponseConnectService(String string, String string2, int n, int n2, int n3) {
        return this.myParent;
    }
}

