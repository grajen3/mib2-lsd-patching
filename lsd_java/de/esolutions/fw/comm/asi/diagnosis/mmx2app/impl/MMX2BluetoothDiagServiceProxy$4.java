/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDevices;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$4
implements ISerializable {
    private final /* synthetic */ sBluetoothDevices val$btDevices;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$4(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sBluetoothDevices sBluetoothDevices2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$btDevices = sBluetoothDevices2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sBluetoothDevicesSerializer.putOptionalsBluetoothDevices(iSerializer, this.val$btDevices);
    }
}

