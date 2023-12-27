/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import org.dsi.ifc.media.EntryInfo;

class MediaPlayer$2
implements Runnable {
    private final /* synthetic */ MediaPlayer this$0;

    MediaPlayer$2(MediaPlayer mediaPlayer) {
        this.this$0 = mediaPlayer;
    }

    @Override
    public void run() {
        this.this$0.dsiMediaPlayerResponseDetailInfo(new EntryInfo());
    }
}

