/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

public interface MMX2WlanDiagServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void requestWlanProperties(long l) {
    }

    default public void requestSetWlanHotSpotActive(long l, boolean bl) {
    }

    default public void requestWlanHotSpotActive(long l) {
    }

    default public void requestWlanConnectToAP(long l, boolean bl, String string, String string2, int n) {
    }
}

