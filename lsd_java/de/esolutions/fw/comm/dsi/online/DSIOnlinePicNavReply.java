/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.online.PicNavSyncInfo;

public interface DSIOnlinePicNavReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateSyncStatus(int n, int n2) {
    }

    default public void synchronizeResult(int n, PicNavSyncInfo picNavSyncInfo) {
    }

    default public void getPendingTransactionsResult(int n, PicNavSyncInfo picNavSyncInfo) {
    }

    default public void setActiveProfileResult(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

