/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPBrowserReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateBrowseFolder(ListEntry[] listEntryArray, int n) {
    }

    default public void updateListSize(int n, int n2, int n3) {
    }

    default public void responseList(ListEntry[] listEntryArray, int n) {
    }

    default public void invalidBrowsePath() {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

