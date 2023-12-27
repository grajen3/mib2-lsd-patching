/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProviderImpl;

class AudioConnectionProviderImpl$HoldSDSConnectionTimeout
implements Runnable {
    private final /* synthetic */ AudioConnectionProviderImpl this$0;

    AudioConnectionProviderImpl$HoldSDSConnectionTimeout(AudioConnectionProviderImpl audioConnectionProviderImpl) {
        this.this$0 = audioConnectionProviderImpl;
    }

    @Override
    public void run() {
        this.this$0.releaseSDSConnection();
    }
}

