/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth;

public interface BluetoothSmartphoneIntegrationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseLocalBluetoothAddress(String string) {
    }

    default public void updateSpiBtState(int n) {
    }

    default public void responsePrepareConnect(String string, boolean bl, boolean bl2) {
    }

    default public void reportSharedSecret(String string, String string2) {
    }

    default public void reportParingSuccess(String string, boolean bl) {
    }

    default public void reportConnectionEstablished(String string, boolean bl) {
    }
}

