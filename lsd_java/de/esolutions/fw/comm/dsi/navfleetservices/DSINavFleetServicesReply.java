/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navfleetservices;

public interface DSINavFleetServicesReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void setVZOTrackerStateResult(int n) {
    }

    default public void setVZODownloadStateResult(int n) {
    }

    default public void setLGITrackerStateResult(int n) {
    }

    default public void setLGIDownloadStateResult(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

