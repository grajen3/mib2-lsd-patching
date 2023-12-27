/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media;

import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.vw.mib.asi.ASIListener;

public interface ASIMediaListener
extends ASIListener {
    default public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState, boolean bl) {
    }

    default public void updateListState(MediaPlaylistState mediaPlaylistState, boolean bl) {
    }

    default public void updateMix(boolean bl, boolean bl2) {
    }

    default public void updatePlayPosition(MediaPlayTime mediaPlayTime, boolean bl) {
    }

    default public void updatePlaybackFolder(MediaEntry[] mediaEntryArray, boolean bl) {
    }

    default public void updatePlaybackPossible(int n, boolean bl) {
    }

    default public void updatePlaybackState(int n, boolean bl) {
    }

    default public void updatePlayingTrack(MediaEntry mediaEntry, boolean bl) {
    }

    default public void updateRepeatTitle(boolean bl, boolean bl2) {
    }

    default public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray, boolean bl) {
    }
}

