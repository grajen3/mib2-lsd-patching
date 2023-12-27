/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

public interface MMX2TelephoneDiagServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void requestSimState(long l) {
    }

    default public void requestNadIMEI(long l) {
    }

    default public void requestTelephoneAntennaState(long l, int n) {
    }

    default public void requestConnectedBtHandset(long l, int n) {
    }

    default public void requestNumberHandsetsHUCs(long l) {
    }

    default public void requestTelephoneNetworkState(long l) {
    }

    default public void requestTelephoneTemperature(long l) {
    }

    default public void requestDeleteMemory(long l, int n) {
    }

    default public void requestNetworkName(long l) {
    }

    default public void requestNetworkType(long l) {
    }

    default public void requestDialNumber(long l, String string) {
    }

    default public void requestCallStatus(long l) {
    }

    default public void requestInternalSimIdentification(long l) {
    }
}

