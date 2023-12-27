/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

public interface ASIHMISyncMediaReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void indicationCmdBlocked(int n) {
    }

    default public void responsePlayList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
    }

    default public void responseSetPlaySelection(boolean bl) {
    }

    default public void responsePlayMoreFrom(long l, int n, int n2) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray, boolean bl) {
    }

    default public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState, boolean bl) {
    }

    default public void updatePlaybackState(int n, boolean bl) {
    }

    default public void updateListState(MediaPlaylistState mediaPlaylistState, boolean bl) {
    }

    default public void updatePlayerCapabilities(int n, boolean bl) {
    }

    default public void updateMix(boolean bl, boolean bl2) {
    }

    default public void updateRepeatTitle(boolean bl, boolean bl2) {
    }

    default public void updateRepeatState(int n, boolean bl) {
    }

    default public void updateShuffleState(int n, boolean bl) {
    }

    default public void updatePlayingTrack(MediaEntry mediaEntry, boolean bl) {
    }

    default public void updatePlayPosition(MediaPlayTime mediaPlayTime, boolean bl) {
    }

    default public void updatePlaybackFolder(MediaEntry[] mediaEntryArray, boolean bl) {
    }

    default public void updatePlaybackPossible(int n, boolean bl) {
    }
}

