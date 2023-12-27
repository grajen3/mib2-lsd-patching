/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.audio.DelayedReleaseClient;
import de.vw.mib.asl.internal.speechengine.audio.GEMAudioConnectionClient;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

public class DialogSystemAudioAccessor
implements AudioAccessor {
    private static final int TRACE_CLASSIFIER;
    private final AudioConnectionProvider audioConnectionProvider;
    private GEMAudioConnectionClient gemAudioConnectionClient;
    private DelayedReleaseClient delayedReleaseClient;
    private final Logger logger;

    public DialogSystemAudioAccessor(Logger logger, AudioConnectionProvider audioConnectionProvider, TimerManager timerManager, ThreadSwitchingTarget threadSwitchingTarget) {
        this.audioConnectionProvider = audioConnectionProvider;
        this.logger = logger;
        try {
            this.gemAudioConnectionClient = new GEMAudioConnectionClient(this.audioConnectionProvider);
            this.delayedReleaseClient = new DelayedReleaseClient(this.audioConnectionProvider, timerManager, threadSwitchingTarget);
        }
        catch (Exception exception) {
            this.logger.fatal(2048, "Can't create AudioConnectionClients for AudioAccessor! ", exception);
        }
    }

    @Override
    public void hangOn(int n, int n2) {
        this.delayedReleaseClient.hangOn(n, n2);
    }

    @Override
    public void letGo(int n) {
        this.delayedReleaseClient.letGo();
    }

    @Override
    public void requestSpeechOutputConnection() {
        this.gemAudioConnectionClient.requestSpeechOutputConnection();
    }

    @Override
    public void releaseSpeechOutputConnection() {
        this.gemAudioConnectionClient.releaseSpeechOutputConnection();
    }
}

