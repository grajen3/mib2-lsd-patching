/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanDevice;

public interface WlanServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateWlanReady(boolean bl, String string) {
    }

    default public void updateWLANDevice(WlanDevice wlanDevice) {
    }
}

