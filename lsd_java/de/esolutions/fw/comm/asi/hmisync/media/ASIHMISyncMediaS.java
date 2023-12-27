/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

public interface ASIHMISyncMediaS {
    default public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void resume(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void pause(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void skip(byte by, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void seek(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void stopSeek(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void mix(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void repeatTitle(boolean bl, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void toggleRepeatState(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void toggleShuffleState(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void setEntry(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void setTimePosition(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void touchEvent(int n, int n2, int n3, int n4, int n5, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void executeDvdVideoCommand(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void requestPlayList(int n, long l, int n2, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void playMoreFrom(long l, int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void setNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void setNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void clearNotification(ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void clearNotification(long l, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
    }
}

