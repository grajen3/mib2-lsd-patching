/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$2
implements ISerializable {
    private final /* synthetic */ sBluetoothState val$btState;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$2(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sBluetoothState sBluetoothState2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$btState = sBluetoothState2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sBluetoothStateSerializer.putOptionalsBluetoothState(iSerializer, this.val$btState);
    }
}

