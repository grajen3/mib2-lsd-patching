/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

public interface ASIHMISyncMediaBrowserC {
    default public void activate(MediaSourceSlot mediaSourceSlot) {
    }

    default public void deactivate() {
    }

    default public void setBrowseMode(int n) {
    }

    default public void changeFolder(MediaEntry[] mediaEntryArray) {
    }

    default public void addSelection(int n, MediaEntry mediaEntry) {
    }

    default public void requestList(int n, long l, int n2, int n3) {
    }

    default public void setNotification() {
    }

    default public void setNotification(long l) {
    }

    default public void setNotification(long[] lArray) {
    }

    default public void clearNotification() {
    }

    default public void clearNotification(long l) {
    }

    default public void clearNotification(long[] lArray) {
    }
}

