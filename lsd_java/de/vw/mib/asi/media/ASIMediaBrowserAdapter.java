/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.media.ASIMediaBrowser;
import de.vw.mib.asi.media.ASIMediaBrowserListener;
import de.vw.mib.asi.media.ASIMediaBrowserResponse;

public class ASIMediaBrowserAdapter
implements ASIMediaBrowser {
    protected ASIMediaBrowserListener listener;

    @Override
    public ASIMediaBrowserListener getASIMediaBrowserListener() {
        return this.listener;
    }

    @Override
    public void setASIMediaBrowserListener(ASIMediaBrowserListener aSIMediaBrowserListener) {
        this.listener = aSIMediaBrowserListener;
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void deactivate(ASIMediaBrowserResponse aSIMediaBrowserResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setBrowseMode(int n, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void changeFolder(MediaEntry[] mediaEntryArray, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void addSelection(int n, MediaEntry mediaEntry, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void requestList(int n, long l, int n2, int n3, ASIMediaBrowserResponse aSIMediaBrowserResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

