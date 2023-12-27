/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.browser.PredictableModelProperty$ModelUpdater;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import org.dsi.ifc.media.Capabilities;

class MediaPlayerState$6
implements PredictableModelProperty$ModelUpdater {
    private final /* synthetic */ MediaPlayerState this$0;

    MediaPlayerState$6(MediaPlayerState mediaPlayerState) {
        this.this$0 = mediaPlayerState;
    }

    @Override
    public void forward(Object object) {
        Capabilities capabilities = (Capabilities)object;
        if (this.this$0.mListener != null) {
            this.this$0.mListener.onCapabilitiesChanged(capabilities);
        }
    }
}

