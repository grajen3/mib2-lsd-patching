/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothMACSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothMAC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceProxy$3
implements ISerializable {
    private final /* synthetic */ sBluetoothMAC val$btMAC;
    private final /* synthetic */ MMX2BluetoothDiagServiceProxy this$0;

    MMX2BluetoothDiagServiceProxy$3(MMX2BluetoothDiagServiceProxy mMX2BluetoothDiagServiceProxy, sBluetoothMAC sBluetoothMAC2) {
        this.this$0 = mMX2BluetoothDiagServiceProxy;
        this.val$btMAC = sBluetoothMAC2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sBluetoothMACSerializer.putOptionalsBluetoothMAC(iSerializer, this.val$btMAC);
    }
}

