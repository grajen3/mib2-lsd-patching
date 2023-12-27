/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.attributes;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.MediaListObserver;
import de.vw.mib.asl.api.media.services.player.MediaPlaySimilarListener;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.listener.MediaActiveMediaListener;
import de.vw.mib.asl.internal.media.playback.listener.MediaPlaybackEntryListener;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import java.util.ArrayList;
import org.dsi.ifc.media.EntryInfo;

public class PlaySimilarAttribute
implements MediaActiveMediaListener,
MediaPlaybackEntryListener,
MediaListObserver {
    private final ArrayList mPlaySimilarListener = new ArrayList();
    private final MediaPlayerState mPlayerState;

    public PlaySimilarAttribute(MediaPlayerState mediaPlayerState) {
        this.mPlayerState = mediaPlayerState;
        mediaPlayerState.addPlaybackEntryListener(this);
        mediaPlayerState.addActiveMediaListener(this);
        ASLDeviceHandlingFactory.getDeviceHandlingApi().register(this);
    }

    public void addListener(MediaPlaySimilarListener mediaPlaySimilarListener) {
        this.mPlaySimilarListener.add(mediaPlaySimilarListener);
        mediaPlaySimilarListener.updatePlaySimilarAvailable(this.isPlaySimilarAvailable());
    }

    private void update() {
        for (int i2 = 0; i2 < this.mPlaySimilarListener.size(); ++i2) {
            MediaPlaySimilarListener mediaPlaySimilarListener = (MediaPlaySimilarListener)this.mPlaySimilarListener.get(i2);
            mediaPlaySimilarListener.updatePlaySimilarAvailable(this.isPlaySimilarAvailable());
        }
    }

    private boolean isPlaySimilarAvailable() {
        boolean bl = false;
        MediaCollector mediaCollector = null;
        EntryInfo entryInfo = null;
        if (this.mPlayerState != null) {
            mediaCollector = this.mPlayerState.getActiveMedia();
            entryInfo = this.mPlayerState.getPlaybackEntry();
        }
        if (mediaCollector != null && entryInfo != null) {
            bl = mediaCollector.isPlaySimilarReadyToUse() && !MediaBrowserHelper.isVideoFile(entryInfo);
        }
        return bl;
    }

    @Override
    public void updatePlaybackEntry() {
        this.update();
    }

    @Override
    public void updatePlaybackMedia() {
        this.update();
    }

    @Override
    public void onUpdate(Devices devices) {
        this.update();
    }
}

