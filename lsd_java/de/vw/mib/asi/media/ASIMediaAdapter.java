/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.media.ASIMedia;
import de.vw.mib.asi.media.ASIMediaListener;
import de.vw.mib.asi.media.ASIMediaResponse;

public class ASIMediaAdapter
implements ASIMedia {
    protected ASIMediaListener listener;

    @Override
    public ASIMediaListener getASIMediaListener() {
        return this.listener;
    }

    @Override
    public void setASIMediaListener(ASIMediaListener aSIMediaListener) {
        this.listener = aSIMediaListener;
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void resume(ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void pause(ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void skip(byte by, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void seek(boolean bl, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void stopSeek(ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void mix(boolean bl, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void repeatTitle(boolean bl, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setEntry(long l, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setTimePosition(int n, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void touchEvent(int n, int n2, int n3, int n4, int n5, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void executeDvdVideoCommand(int n, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void requestPlayList(int n, long l, int n2, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public void playMoreFrom(long l, int n, ASIMediaResponse aSIMediaResponse) {
        throw new UnsupportedOperationException("Method not implemented");
    }
}

