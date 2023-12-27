/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sLastPairedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sLastPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$5
implements ISerializable {
    private final /* synthetic */ sLastPairedBtDevices val$btDevice;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$5(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sLastPairedBtDevices sLastPairedBtDevices2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$btDevice = sLastPairedBtDevices2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sLastPairedBtDevicesSerializer.putOptionalsLastPairedBtDevices(iSerializer, this.val$btDevice);
    }
}

