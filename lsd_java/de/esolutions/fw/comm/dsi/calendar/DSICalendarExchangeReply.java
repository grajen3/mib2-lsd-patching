/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar;

public interface DSICalendarExchangeReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void parseICalResult(int n) {
    }

    default public void parseICalDirectoryResult(int[] nArray) {
    }

    default public void exportICalResult(int n, String string) {
    }

    default public void finishExportResult(int n, long[] lArray, int n2, String string) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

