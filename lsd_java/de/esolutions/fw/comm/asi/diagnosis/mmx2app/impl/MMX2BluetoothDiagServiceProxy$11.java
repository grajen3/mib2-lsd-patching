/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothDeviceNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDeviceName;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$11
implements ISerializable {
    private final /* synthetic */ sBluetoothDeviceName[] val$devices;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$11(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sBluetoothDeviceName[] sBluetoothDeviceNameArray) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$devices = sBluetoothDeviceNameArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sBluetoothDeviceNameSerializer.putOptionalsBluetoothDeviceNameVarArray(iSerializer, this.val$devices);
    }
}

