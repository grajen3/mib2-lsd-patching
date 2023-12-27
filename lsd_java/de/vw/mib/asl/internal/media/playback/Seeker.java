/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.internal.media.common.MediaTimer;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.Seeker$1;

public class Seeker {
    private static final int SEEK_ACCELERATION_INTERVALL;
    private static final int[] SEEK_STEPS;
    private final MediaPlayer mPlayer;
    private int mCurrentSeekDirection = 0;
    private int mCurrentSeekSpeedIndex = 0;
    private final Runnable mIncreaseSeekSpeedRunnable = new Seeker$1(this);
    private final MediaTimer mIncreaseSeekSpeedTimer = new MediaTimer(this.mIncreaseSeekSpeedRunnable, 4000, "increase_seek_speed");
    private boolean mSeekAborted;

    public Seeker(MediaPlayer mediaPlayer) {
        this.mPlayer = mediaPlayer;
    }

    public void abortSeek() {
        this.mIncreaseSeekSpeedTimer.stop();
        this.mSeekAborted = true;
    }

    public void startSeek(int n) {
        this.mCurrentSeekDirection = n;
        this.mCurrentSeekSpeedIndex = 0;
        this.mPlayer.getDSI().seek(this.mCurrentSeekDirection, SEEK_STEPS[this.mCurrentSeekSpeedIndex]);
        this.mIncreaseSeekSpeedTimer.start();
        this.mSeekAborted = false;
    }

    void increaseSeekSpeed() {
        if (this.mCurrentSeekSpeedIndex < SEEK_STEPS.length - 1 && !this.mSeekAborted) {
            ++this.mCurrentSeekSpeedIndex;
            this.mPlayer.getDSI().seek(this.mCurrentSeekDirection, SEEK_STEPS[this.mCurrentSeekSpeedIndex]);
            this.mIncreaseSeekSpeedTimer.start();
        }
    }

    public boolean isSeekAborted() {
        return this.mSeekAborted;
    }

    static {
        SEEK_STEPS = new int[]{1, 2, 4, 6, 7};
    }
}

