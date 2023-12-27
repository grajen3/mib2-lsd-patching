/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

public interface ASIHMISyncMediaBrowserS {
    default public void activate(MediaSourceSlot mediaSourceSlot, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void deactivate(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void setBrowseMode(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void changeFolder(MediaEntry[] mediaEntryArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void addSelection(int n, MediaEntry mediaEntry, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void requestList(int n, long l, int n2, int n3, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void setNotification(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void setNotification(long l, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void clearNotification(ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void clearNotification(long l, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
    }
}

