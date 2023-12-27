/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BluetoothSmartphoneIntegrationReplyProxy$6
implements ISerializable {
    private final /* synthetic */ String val$btAddress;
    private final /* synthetic */ boolean val$success;
    private final /* synthetic */ BluetoothSmartphoneIntegrationReplyProxy this$0;

    BluetoothSmartphoneIntegrationReplyProxy$6(BluetoothSmartphoneIntegrationReplyProxy bluetoothSmartphoneIntegrationReplyProxy, String string, boolean bl) {
        this.this$0 = bluetoothSmartphoneIntegrationReplyProxy;
        this.val$btAddress = string;
        this.val$success = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$btAddress);
        iSerializer.putBool(this.val$success);
    }
}

