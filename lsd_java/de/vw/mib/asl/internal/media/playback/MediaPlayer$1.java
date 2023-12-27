/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.playback.MediaPlayer;

class MediaPlayer$1
implements Runnable {
    private final /* synthetic */ MediaPlayer this$0;

    MediaPlayer$1(MediaPlayer mediaPlayer) {
        this.this$0 = mediaPlayer;
    }

    @Override
    public void run() {
        if (this.this$0.isRegisteredForResponse(MediaPlayer.access$000()) && !this.this$0.isSeeking()) {
            MediaPlayer.access$100(this.this$0).abortSeek();
            this.this$0.fireResponse(true, "aborted by timeout, seek state not reached within: 2000ms");
        }
    }
}

