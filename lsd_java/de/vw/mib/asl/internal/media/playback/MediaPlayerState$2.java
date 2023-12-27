/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.PredictableModelProperty$ModelUpdater;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;

class MediaPlayerState$2
implements PredictableModelProperty$ModelUpdater {
    private final /* synthetic */ MediaPlayerState this$0;

    MediaPlayerState$2(MediaPlayerState mediaPlayerState) {
        this.this$0 = mediaPlayerState;
    }

    @Override
    public void forward(Object object) {
        Selection selection = (Selection)object;
        if (this.this$0.mListener != null) {
            this.this$0.mListener.onPlaySelectionChanged(selection);
        }
    }
}

