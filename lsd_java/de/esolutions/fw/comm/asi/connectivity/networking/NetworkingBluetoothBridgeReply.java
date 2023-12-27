/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

public interface NetworkingBluetoothBridgeReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void setConnectionState(long l, int n, int n2) {
    }

    default public void setProfileConnectable(long l, int n, boolean bl) {
    }
}

