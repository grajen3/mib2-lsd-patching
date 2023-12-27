/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BluetoothSmartphoneIntegrationReplyProxy$2
implements ISerializable {
    private final /* synthetic */ int val$state;
    private final /* synthetic */ BluetoothSmartphoneIntegrationReplyProxy this$0;

    BluetoothSmartphoneIntegrationReplyProxy$2(BluetoothSmartphoneIntegrationReplyProxy bluetoothSmartphoneIntegrationReplyProxy, int n) {
        this.this$0 = bluetoothSmartphoneIntegrationReplyProxy;
        this.val$state = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$state);
    }
}

