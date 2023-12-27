/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

public interface ASIHMISyncMediaBrowserReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseChangeFolder(boolean bl) {
    }

    default public void responseAddSelection(boolean bl) {
    }

    default public void responseList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateActiveSlot(MediaSourceSlot mediaSourceSlot, boolean bl) {
    }

    default public void updateBrowseMode(int n, boolean bl) {
    }

    default public void updateDatabaseMode(boolean bl, boolean bl2) {
    }

    default public void updateRawMode(boolean bl, boolean bl2) {
    }

    default public void updateBrowseFolder(MediaEntry[] mediaEntryArray, boolean bl) {
    }

    default public void updateListSize(int n, boolean bl) {
    }
}

