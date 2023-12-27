/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.PredictableModelProperty$ModelUpdater;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

class MediaPlayerState$1
implements PredictableModelProperty$ModelUpdater {
    private final /* synthetic */ MediaPlayerState this$0;

    MediaPlayerState$1(MediaPlayerState mediaPlayerState) {
        this.this$0 = mediaPlayerState;
    }

    @Override
    public void forward(Object object) {
        MediaCollector mediaCollector = (MediaCollector)object;
        if (this.this$0.mListener != null) {
            this.this$0.mListener.onPlaybackMediaChanged(mediaCollector);
            this.this$0.notifyActiveMediaListener();
        }
    }
}

