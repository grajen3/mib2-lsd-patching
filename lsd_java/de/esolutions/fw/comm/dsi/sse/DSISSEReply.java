/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sse;

public interface DSISSEReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseSetMode(int n) {
    }

    default public void updateMode(int n, int n2) {
    }

    default public void updateMicGainLevel(int n, int n2) {
    }

    default public void responseSetMicGainLevel(int n) {
    }

    default public void updateMicMuteState(int n, int n2) {
    }

    default public void responseSetMicMuteState(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

