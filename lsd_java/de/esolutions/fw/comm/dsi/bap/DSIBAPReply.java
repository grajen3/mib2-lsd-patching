/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bap;

public interface DSIBAPReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void bapStateStatus(int n, int n2) {
    }

    default public void indication(int n, int n2, int n3, int n4, int n5) {
    }

    default public void indicationVoid(int n, int n2, int n3) {
    }

    default public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
    }

    default public void indicationError(int n, int n2, int n3) {
    }

    default public void acknowledge(int n, int n2, int n3) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

