/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdllogging;

public interface DSISwdlLoggingReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void getHistory(String[] stringArray, int[] nArray) {
    }

    default public void setUpdate(int n) {
    }

    default public void getGeneralInformation(boolean bl, String string, String string2, boolean bl2, String string3, String string4, int[] nArray, boolean bl3, int n, int[] nArray2) {
    }

    default public void getUnusualEvents(int[] nArray, String[] stringArray) {
    }

    default public void getUnusualEvent(int n, String string, String string2, String string3, byte by, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

