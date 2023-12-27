/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sConnectedBtDeviceSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevice;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$8
implements ISerializable {
    private final /* synthetic */ sConnectedBtDevice val$btConnectedDevice;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$8(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sConnectedBtDevice sConnectedBtDevice2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$btConnectedDevice = sConnectedBtDevice2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sConnectedBtDeviceSerializer.putOptionalsConnectedBtDevice(iSerializer, this.val$btConnectedDevice);
    }
}

