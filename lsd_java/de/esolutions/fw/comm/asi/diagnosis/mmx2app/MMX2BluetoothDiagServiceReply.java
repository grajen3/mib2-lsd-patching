/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

public interface MMX2BluetoothDiagServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void requestBluetoothState(long l) {
    }

    default public void requestBluetoothMAC(long l) {
    }

    default public void requestBluetoothDevices(long l) {
    }

    default public void requestLastPairedBtDevices(long l, short s) {
    }

    default public void requestPairedBtDevices(long l) {
    }

    default public void requestConnectedBtDevices(long l) {
    }

    default public void requestConnectedBtDevice(long l, short s) {
    }

    default public void requestAutoConnectBtHandset(long l, int n) {
    }

    default public void requestBtDeleteLinkKeys(long l, int n, int n2) {
    }

    default public void requestBtDeviceSearch(long l, short s, short s2) {
    }

    default public void requestConnectionToLastBtDevice(long l, short s, short s2) {
    }
}

