/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.PredictableModelProperty$ModelUpdater;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;

class MediaPlayerState$5
implements PredictableModelProperty$ModelUpdater {
    private final /* synthetic */ MediaPlayerState this$0;

    MediaPlayerState$5(MediaPlayerState mediaPlayerState) {
        this.this$0 = mediaPlayerState;
    }

    @Override
    public void forward(Object object) {
        int n;
        int n2 = n = object == null ? 0 : (Integer)object;
        if (this.this$0.mListener != null) {
            this.this$0.mListener.onPlaybackStateChanged(n);
        }
    }
}

