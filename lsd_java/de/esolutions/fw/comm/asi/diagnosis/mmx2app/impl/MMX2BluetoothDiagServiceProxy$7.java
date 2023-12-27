/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sConnectedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$7
implements ISerializable {
    private final /* synthetic */ sConnectedBtDevices val$btConnectedDevices;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$7(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sConnectedBtDevices sConnectedBtDevices2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$btConnectedDevices = sConnectedBtDevices2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sConnectedBtDevicesSerializer.putOptionalsConnectedBtDevices(iSerializer, this.val$btConnectedDevices);
    }
}

