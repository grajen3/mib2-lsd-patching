/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.audio;

import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionClient;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionProvider;
import de.vw.mib.asl.internal.speechengine.audio.AudioConnectionState;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class DelayedReleaseClient
extends AudioConnectionClient
implements Runnable {
    private boolean isBlocked = false;
    private static final int SDS_AUDIO_CONNECTION;
    private static final int CLIENT_ID;
    private Timer timer;
    private static final String TIMER_NAME;

    public DelayedReleaseClient(AudioConnectionProvider audioConnectionProvider, TimerManager timerManager, ThreadSwitchingTarget threadSwitchingTarget) {
        super(audioConnectionProvider);
        this.timer = timerManager.createTimer("DelayedReleaseClient");
        this.timer.setRepeat(false);
        this.timer.setRunnable(this, threadSwitchingTarget);
    }

    @Override
    public int getClientID() {
        return 4;
    }

    @Override
    public void updateAudioConnectionState(int n, AudioConnectionState audioConnectionState) {
        boolean bl;
        boolean bl2 = bl = AudioConnectionState.LOST.equals(audioConnectionState) || AudioConnectionState.RELEASED.equals(audioConnectionState);
        if (n == 112 && bl && this.timer.isStarted()) {
            this.timer.stop();
            this.isBlocked = false;
        }
    }

    void hangOn(int n, int n2) {
        if (n2 < 0) {
            return;
        }
        if (!this.isBlocked) {
            this.isBlocked = true;
            this.audioConnectionProvider.requestConnection(112, this);
            if (!this.timer.isStarted()) {
                this.timer.setDelay(n2);
                this.timer.start();
            }
        }
    }

    void letGo() {
        if (this.isBlocked) {
            this.isBlocked = false;
            if (this.timer.isStarted()) {
                this.timer.stop();
            }
            this.audioConnectionProvider.releaseConnection(112, this);
        }
    }

    @Override
    public void run() {
        this.letGo();
    }
}

