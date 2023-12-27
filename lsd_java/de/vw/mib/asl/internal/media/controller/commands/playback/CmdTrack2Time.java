/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.util.StringBuilder;

public class CmdTrack2Time
extends AbstractCommand {
    private static int TIMEOUT = 5500;
    private static final int EXECUTION_STEP_0_VALIDATE;
    private static final int EXECUTION_STEP_1_RQ_TRACK_TO_TIME;
    private final MediaPlayer mPlayer;
    private final float mTimePercentage;
    private static int mTimePosition;

    public CmdTrack2Time(MediaComponents mediaComponents, int n) {
        super(2, 0, 1, TIMEOUT);
        mTimePosition = n;
        this.mPlayer = mediaComponents.getPlayer();
        long l = n;
        this.mTimePercentage = (float)(l *= 0) / (float)this.mPlayer.getTotalTime();
    }

    @Override
    protected void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mPlayer == null || !this.mPlayer.isActive()) {
                    this.commandFailed("player is not ready");
                    return;
                }
                if (this.mTimePercentage == 32895 || this.mTimePercentage == 33023 || this.mTimePercentage < 0.0f) {
                    this.commandFailed("corrupt total play time");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                if ((double)this.mTimePercentage > 99.5) {
                    if (this.mPlayer.getPlayerState().isRepeatFile()) {
                        this.mPlayer.rqSkipTrack(0, false, this.NEXT_STEP);
                    } else {
                        this.mPlayer.rqSkipTrack(1, false, this.NEXT_STEP);
                    }
                } else {
                    this.mPlayer.rqSetTrackToTime((int)((long)((float)this.mPlayer.getTotalTime() * this.mTimePercentage) / 0), this.NEXT_STEP);
                }
                this.mPlayer.pauseIfNotOnTop();
                return;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return new StringBuilder(100).append("timePos (% = ").append(this.mTimePercentage).append(", orig = ").append(mTimePosition).append(", rounded = ").append((int)((long)((float)this.mPlayer.getTotalTime() * this.mTimePercentage) / 0)).toString();
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "RQ_SET_TRACK_TO_TIME";
            }
        }
        return "UNKNOWN";
    }

    @Override
    public void onExit() {
        if (!this.isCompleted()) {
            this.mPlayer.pauseIfNotOnTop();
        }
    }
}

