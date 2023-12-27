/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothDevice;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothDeviceSerializer;
import de.esolutions.fw.comm.asi.connectivity.bluetooth.impl.BluetoothInformationServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class BluetoothInformationServiceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ BluetoothDevice[] val$devices;
    private final /* synthetic */ BluetoothInformationServiceReplyProxy this$0;

    BluetoothInformationServiceReplyProxy$2(BluetoothInformationServiceReplyProxy bluetoothInformationServiceReplyProxy, BluetoothDevice[] bluetoothDeviceArray) {
        this.this$0 = bluetoothInformationServiceReplyProxy;
        this.val$devices = bluetoothDeviceArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        BluetoothDeviceSerializer.putOptionalBluetoothDeviceVarArray(iSerializer, this.val$devices);
    }
}

