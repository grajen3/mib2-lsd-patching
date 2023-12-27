/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.ASIService;
import de.vw.mib.asi.media.ASIMediaListener;
import de.vw.mib.asi.media.ASIMediaResponse;

public interface ASIMedia
extends ASIService {
    default public ASIMediaListener getASIMediaListener() {
    }

    default public void setASIMediaListener(ASIMediaListener aSIMediaListener) {
    }

    default public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData, ASIMediaResponse aSIMediaResponse) {
    }

    default public void resume(ASIMediaResponse aSIMediaResponse) {
    }

    default public void pause(ASIMediaResponse aSIMediaResponse) {
    }

    default public void skip(byte by, ASIMediaResponse aSIMediaResponse) {
    }

    default public void seek(boolean bl, ASIMediaResponse aSIMediaResponse) {
    }

    default public void stopSeek(ASIMediaResponse aSIMediaResponse) {
    }

    default public void mix(boolean bl, ASIMediaResponse aSIMediaResponse) {
    }

    default public void repeatTitle(boolean bl, ASIMediaResponse aSIMediaResponse) {
    }

    default public void setEntry(long l, ASIMediaResponse aSIMediaResponse) {
    }

    default public void setTimePosition(int n, ASIMediaResponse aSIMediaResponse) {
    }

    default public void touchEvent(int n, int n2, int n3, int n4, int n5, ASIMediaResponse aSIMediaResponse) {
    }

    default public void executeDvdVideoCommand(int n, ASIMediaResponse aSIMediaResponse) {
    }

    default public void requestPlayList(int n, long l, int n2, ASIMediaResponse aSIMediaResponse) {
    }

    default public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData, ASIMediaResponse aSIMediaResponse) {
    }

    default public void playMoreFrom(long l, int n, ASIMediaResponse aSIMediaResponse) {
    }
}

