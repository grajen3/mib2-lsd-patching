/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.playback.Seeker;

class Seeker$1
implements Runnable {
    private final /* synthetic */ Seeker this$0;

    Seeker$1(Seeker seeker) {
        this.this$0 = seeker;
    }

    @Override
    public void run() {
        this.this$0.increaseSeekSpeed();
    }
}

