/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BluetoothSmartphoneIntegrationReplyProxy$1
implements ISerializable {
    private final /* synthetic */ String val$btAddress;
    private final /* synthetic */ BluetoothSmartphoneIntegrationReplyProxy this$0;

    BluetoothSmartphoneIntegrationReplyProxy$1(BluetoothSmartphoneIntegrationReplyProxy bluetoothSmartphoneIntegrationReplyProxy, String string) {
        this.this$0 = bluetoothSmartphoneIntegrationReplyProxy;
        this.val$btAddress = string;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$btAddress);
    }
}

