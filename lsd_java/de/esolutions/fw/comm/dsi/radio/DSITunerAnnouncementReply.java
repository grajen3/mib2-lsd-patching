/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio;

public interface DSITunerAnnouncementReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateFilter(int n, int n2) {
    }

    default public void updateAvailability(int n, int n2) {
    }

    default public void updateStatus(int n, int n2) {
    }

    default public void updateStationName(String string, int n, long l, int n2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

