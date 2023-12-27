/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

public interface ComponentProtectionReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void authStringResult(String string, String string2, byte by) {
    }
}

