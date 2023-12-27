/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.media.ASIMediaBrowserListener;
import de.vw.mib.asi.media.ASIMediaBrowserResponse;

public interface ASIMediaBrowser
extends ASIService {
    default public ASIMediaBrowserListener getASIMediaBrowserListener() {
    }

    default public void setASIMediaBrowserListener(ASIMediaBrowserListener aSIMediaBrowserListener) {
    }

    default public void activate(MediaSourceSlot mediaSourceSlot, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
    }

    default public void deactivate(ASIMediaBrowserResponse aSIMediaBrowserResponse) {
    }

    default public void setBrowseMode(int n, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
    }

    default public void changeFolder(MediaEntry[] mediaEntryArray, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
    }

    default public void addSelection(int n, MediaEntry mediaEntry, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
    }

    default public void requestList(int n, long l, int n2, int n3, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
    }
}

