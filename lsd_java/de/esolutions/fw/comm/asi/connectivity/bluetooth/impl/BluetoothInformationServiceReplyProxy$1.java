/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothInformationServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BluetoothInformationServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$state;
    private final /* synthetic */ BluetoothInformationServiceReplyProxy this$0;

    BluetoothInformationServiceReplyProxy$1(BluetoothInformationServiceReplyProxy bluetoothInformationServiceReplyProxy, int n) {
        this.this$0 = bluetoothInformationServiceReplyProxy;
        this.val$state = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$state);
    }
}

