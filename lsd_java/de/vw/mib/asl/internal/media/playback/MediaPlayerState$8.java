/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.api.media.services.player.MediaActivationStateListener;
import de.vw.mib.asl.internal.media.browser.PredictableModelProperty$ModelUpdater;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;

class MediaPlayerState$8
implements PredictableModelProperty$ModelUpdater {
    private final /* synthetic */ MediaPlayerState this$0;

    MediaPlayerState$8(MediaPlayerState mediaPlayerState) {
        this.this$0 = mediaPlayerState;
    }

    @Override
    public void forward(Object object) {
        int n;
        int n2 = n = object == null ? 0 : (Integer)object;
        if (this.this$0.mListener != null) {
            this.this$0.mListener.onActivationStateChanged(n);
        }
        for (int i2 = 0; i2 < MediaPlayerState.access$200(this.this$0).size(); ++i2) {
            MediaActivationStateListener mediaActivationStateListener = (MediaActivationStateListener)MediaPlayerState.access$200(this.this$0).get(i2);
            mediaActivationStateListener.updateActivationState(n);
        }
    }
}

