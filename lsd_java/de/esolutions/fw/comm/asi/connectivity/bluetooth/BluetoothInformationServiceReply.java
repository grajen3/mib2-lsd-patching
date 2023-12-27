/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothDevice;

public interface BluetoothInformationServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateBluetoothState(int n) {
    }

    default public void updateBluetoothDevices(BluetoothDevice[] bluetoothDeviceArray) {
    }
}

