/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance;

public interface ASIHMISyncInstanceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseInstanceId(String string, String string2, int n, int n2) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }
}

