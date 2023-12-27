/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BluetoothSmartphoneIntegrationReplyProxy$4
implements ISerializable {
    private final /* synthetic */ String val$btAddress;
    private final /* synthetic */ String val$passkey;
    private final /* synthetic */ BluetoothSmartphoneIntegrationReplyProxy this$0;

    BluetoothSmartphoneIntegrationReplyProxy$4(BluetoothSmartphoneIntegrationReplyProxy bluetoothSmartphoneIntegrationReplyProxy, String string, String string2) {
        this.this$0 = bluetoothSmartphoneIntegrationReplyProxy;
        this.val$btAddress = string;
        this.val$passkey = string2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$btAddress);
        iSerializer.putOptionalString(this.val$passkey);
    }
}

