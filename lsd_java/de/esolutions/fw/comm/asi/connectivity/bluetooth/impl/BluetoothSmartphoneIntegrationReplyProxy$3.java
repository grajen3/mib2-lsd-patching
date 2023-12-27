/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothSmartphoneIntegrationReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BluetoothSmartphoneIntegrationReplyProxy$3
implements ISerializable {
    private final /* synthetic */ String val$btAddress;
    private final /* synthetic */ boolean val$alreadyPaired;
    private final /* synthetic */ boolean val$alreadyHFPConnected;
    private final /* synthetic */ BluetoothSmartphoneIntegrationReplyProxy this$0;

    BluetoothSmartphoneIntegrationReplyProxy$3(BluetoothSmartphoneIntegrationReplyProxy bluetoothSmartphoneIntegrationReplyProxy, String string, boolean bl, boolean bl2) {
        this.this$0 = bluetoothSmartphoneIntegrationReplyProxy;
        this.val$btAddress = string;
        this.val$alreadyPaired = bl;
        this.val$alreadyHFPConnected = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$btAddress);
        iSerializer.putBool(this.val$alreadyPaired);
        iSerializer.putBool(this.val$alreadyHFPConnected);
    }
}

