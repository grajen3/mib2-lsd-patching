/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

public interface NetworkingServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateRoamingState(int n) {
    }

    default public void updateOnlineState(int n) {
    }

    default public void updateThrottlingState(int n) {
    }

    default public void updateServiceIdentifier(String string) {
    }

    default public void updateSimCardType(int n) {
    }

    default public void updateSim(String string, String string2, String string3, String string4) {
    }
}

