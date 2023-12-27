/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class AbstractHsmBluetoothServiceConnectState
extends AbstractHsmState {
    public AbstractHsmBluetoothServiceConnectState(Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
    }

    public abstract HsmState dsiBluetoothResponseConnectService(String string, String string2, int n, int n2, int n3) {
    }
}

