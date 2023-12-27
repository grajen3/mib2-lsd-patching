/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.media.ASIMediaListener;
import de.vw.mib.asi.media.impl.ASIMediaBaseServiceImpl;

class ASIMediaBaseServiceImpl$ListenerProxy
implements ASIMediaListener {
    private final /* synthetic */ ASIMediaBaseServiceImpl this$0;

    ASIMediaBaseServiceImpl$ListenerProxy(ASIMediaBaseServiceImpl aSIMediaBaseServiceImpl) {
        this.this$0 = aSIMediaBaseServiceImpl;
    }

    @Override
    public void updateActiveSlotState(MediaActiveSourceState mediaActiveSourceState, boolean bl) {
        try {
            this.this$0.updateActiveSlotState(mediaActiveSourceState, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateListState(MediaPlaylistState mediaPlaylistState, boolean bl) {
        try {
            this.this$0.updateListState(mediaPlaylistState, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateMix(boolean bl, boolean bl2) {
        try {
            this.this$0.updateMix(bl, bl2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePlayPosition(MediaPlayTime mediaPlayTime, boolean bl) {
        try {
            this.this$0.updatePlayPosition(mediaPlayTime, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePlaybackFolder(MediaEntry[] mediaEntryArray, boolean bl) {
        try {
            this.this$0.updatePlaybackFolder(mediaEntryArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePlaybackPossible(int n, boolean bl) {
        try {
            this.this$0.updatePlaybackPossible(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePlaybackState(int n, boolean bl) {
        try {
            this.this$0.updatePlaybackState(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePlayingTrack(MediaEntry mediaEntry, boolean bl) {
        try {
            this.this$0.updatePlayingTrack(mediaEntry, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateRepeatTitle(boolean bl, boolean bl2) {
        try {
            this.this$0.updateRepeatTitle(bl, bl2);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSourceList(MediaSourceSlot[] mediaSourceSlotArray, boolean bl) {
        try {
            this.this$0.updateSourceList(mediaSourceSlotArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

