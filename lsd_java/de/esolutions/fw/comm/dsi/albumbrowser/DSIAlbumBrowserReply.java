/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.albumbrowser;

import org.dsi.ifc.albumbrowser.AlbumEntryInfo;

public interface DSIAlbumBrowserReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateBrowserState(int n, int n2) {
    }

    default public void updateFocusedEntry(AlbumEntryInfo albumEntryInfo, int n) {
    }

    default public void updateListPosition(long l, int n) {
    }

    default public void updateNumEntries(long l, int n) {
    }

    default public void updateScrollMode(int n, int n2) {
    }

    default public void selectAlbum(long l) {
    }

    default public void albumIdxForFID(long l, long l2) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

