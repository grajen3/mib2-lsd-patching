/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sPairedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$6
implements ISerializable {
    private final /* synthetic */ sPairedBtDevices val$btPairedDevices;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$6(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sPairedBtDevices sPairedBtDevices2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$btPairedDevices = sPairedBtDevices2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sPairedBtDevicesSerializer.putOptionalsPairedBtDevices(iSerializer, this.val$btPairedDevices);
    }
}

