/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeReply;

public interface NetworkingBluetoothBridgeS {
    default public void updateConnectionState(long l, int n, int n2, NetworkingBluetoothBridgeReply networkingBluetoothBridgeReply) {
    }

    default public void updateBluetoothAddress(long l, NetworkingBluetoothBridgeReply networkingBluetoothBridgeReply) {
    }
}

