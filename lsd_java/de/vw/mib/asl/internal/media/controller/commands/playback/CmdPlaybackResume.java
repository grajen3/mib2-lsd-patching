/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;

public class CmdPlaybackResume
extends AbstractCommand {
    private static int TIMEOUT = 10000;
    private static int TIMEOUT_WAIT_FOR_PAUSED = 500;
    private static final int STEP_0_DEMUTE;
    private static final int STEP_1_WAIT_FOR_PAUSED;
    private static final int STEP_2_RESUME;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;

    public CmdPlaybackResume(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager) {
        this(mediaPlayer, mediaAudioManager, TIMEOUT);
    }

    private CmdPlaybackResume(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager, int n) {
        super(6, 0, 2, n);
        this.mPlayer = mediaPlayer;
        this.mSound = mediaAudioManager;
    }

    public static CmdPlaybackResume createInfiniteResumeCmd(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager) {
        return new CmdPlaybackResume(mediaPlayer, mediaAudioManager, 0);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append("mediaAudible: ").append(this.mSound.isMediaOnTop()).toString());
                    this.trace(new StringBuffer().append("mediaMuted: ").append(this.mSound.isMuteActive()).toString());
                    this.trace(new StringBuffer().append("muteStarted:").append(this.mSound.isMuteStarted()).toString());
                    this.trace(new StringBuffer().append("soundAvail: ").append(this.mSound.isAudioConnectionAvailable()).toString());
                }
                if (this.mSound.isMuteStarted() && this.mSound.isAudioConnectionAvailable()) {
                    if (this.isTraceEnabled()) {
                        this.trace("-> request demute");
                    }
                    this.mSound.rqDemute(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                if (!this.mSound.isMediaOnTop()) {
                    this.commandCompleted("resume postponed as media is not audible after demute");
                    return;
                }
                if (this.mPlayer.getCapabilities() == null || !this.mPlayer.getCapabilities().isPlay()) {
                    this.commandCompleted("capabilities do not support play");
                    return;
                }
                this.mPlayer.rqWaitForState(5, TIMEOUT_WAIT_FOR_PAUSED, this.NEXT_STEP);
                return;
            }
            case 2: {
                if (this.mPlayer.isPaused()) {
                    if (this.isTraceEnabled()) {
                        this.trace("-> request resume");
                    }
                    this.mPlayer.rqResume(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
        }
    }

    @Override
    public void onEnter() {
        int n = (this.mSound.isMediaOnTop() || this.mSound.isMuteActive()) && !this.mSound.isMuteStarted() ? 1 : 2;
        this.mPlayer.getPlayerState().predictPlaybackState(n, this.getSequenceNumber());
    }

    @Override
    public void onExit() {
        this.mPlayer.getPlayerState().clearPlaybackState(this.getSequenceNumber());
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "DEMUTE";
            }
            case 1: {
                return "WAIT_FOR_PAUSED";
            }
            case 2: {
                return "RESUME";
            }
        }
        return "UNKNOWN";
    }

    @Override
    protected String getParameterStr() {
        return null;
    }
}

