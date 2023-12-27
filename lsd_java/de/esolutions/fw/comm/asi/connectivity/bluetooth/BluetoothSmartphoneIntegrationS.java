/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationReply;

public interface BluetoothSmartphoneIntegrationS {
    default public void updateSmartphoneMode(int n, String[] stringArray, BluetoothSmartphoneIntegrationReply bluetoothSmartphoneIntegrationReply) {
    }

    default public void requestLocalBluetoothAddress(BluetoothSmartphoneIntegrationReply bluetoothSmartphoneIntegrationReply) {
    }

    default public void requestPrepareConnect(String string, BluetoothSmartphoneIntegrationReply bluetoothSmartphoneIntegrationReply) {
    }
}

