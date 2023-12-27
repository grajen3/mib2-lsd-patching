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

public class StateBluetoothServiceConnectPasskeyFirst
extends AbstractHsmBluetoothServiceConnectState {
    private final HsmPhoneBluetoothServiceConnect target;

    public StateBluetoothServiceConnectPasskeyFirst(HsmPhoneBluetoothServiceConnect hsmPhoneBluetoothServiceConnect, GenericEvents genericEvents, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmPhoneBluetoothServiceConnect;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("BLUETOOTH_EXTERNAL_REQUEST sent!").log();
                }
                this.target.sendHMIEvent(144);
                break;
            }
            case 1073742712: {
                this.target.warn("ENTER_CONNECT_WAITSTATE handled in StateBluetoothServiceConnectPasskeyFirst");
                break;
            }
            case 1073742704: {
                this.target.sendHMIEvent(146);
                this.target.sendHMIEvent(131);
                this.trans(this.target.stateServiceConnect);
                break;
            }
            case 1073742715: {
                this.target.dsiBluetooth.requestPasskeyResponse("", this.target.btDeviceAddress, 0);
                this.trans(this.target.stateServiceConnect);
                break;
            }
        }
        return this.myParent;
    }

    @Override
    public HsmState dsiBluetoothResponseConnectService(String string, String string2, int n, int n2, int n3) {
        return this.myParent;
    }
}

