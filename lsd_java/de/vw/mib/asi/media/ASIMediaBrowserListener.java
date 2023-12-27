/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.ASIListener;

public interface ASIMediaBrowserListener
extends ASIListener {
    default public void updateActiveSlot(MediaSourceSlot mediaSourceSlot, boolean bl) {
    }

    default public void updateBrowseFolder(MediaEntry[] mediaEntryArray, boolean bl) {
    }

    default public void updateBrowseMode(int n, boolean bl) {
    }

    default public void updateDatabaseMode(boolean bl, boolean bl2) {
    }

    default public void updateListSize(int n, boolean bl) {
    }

    default public void updateRawMode(boolean bl, boolean bl2) {
    }
}

