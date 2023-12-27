/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import org.dsi.ifc.media.Capabilities;

public final class CmdSeek
extends AbstractCommand {
    private static int TIMEOUT = 5000;
    private static final int STEP_0_VALIDATE;
    private static final int STEP_1_AUTOPLAY;
    private static final int STEP_2_RESUME_PLAYER;
    private static final int STEP_3_SEEK;
    private static final int STEP_4_AUTOPLAY_BT;
    private static final int STEP_5_ABORT_SEEK;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;
    private final int mDirection;

    private CmdSeek(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager, int n) {
        super(6, 0, 5, TIMEOUT);
        this.mPlayer = mediaPlayer;
        this.mSound = mediaAudioManager;
        this.mDirection = n;
    }

    public static Command createSeekFw(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager) {
        return new CmdSeek(mediaPlayer, mediaAudioManager, 0);
    }

    public static Command createSeekBw(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager) {
        return new CmdSeek(mediaPlayer, mediaAudioManager, 1);
    }

    @Override
    protected void execute(int n) {
        switch (n) {
            case 0: {
                if (!this.mPlayer.getPlayerState().isActivated()) {
                    this.commandFailed("player not ready");
                    return;
                }
                Capabilities capabilities = this.mPlayer.getCapabilities();
                if (!capabilities.isFastFwd() || !capabilities.isFastBwd()) {
                    this.commandCompleted("seek not supported");
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                if (this.mSound.isMuteActive()) {
                    if (!this.mPlayer.getActiveMedia().isBT()) {
                        this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                        return;
                    }
                    this.mSound.rqDemute(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                if (!this.mPlayer.getActiveMedia().isBT() && !this.mSound.isMediaOnTop()) {
                    this.mPlayer.rqWaitForPlaying(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 3: {
                this.suspendTimer("seek running");
                this.mPlayer.rqSeek(this.mDirection, this.NEXT_STEP);
                return;
            }
            case 4: {
                this.resumeTimer();
                if (this.mPlayer.getActiveMedia().isBT()) {
                    this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                return;
            }
            case 5: {
                if (!this.mSound.isMediaOnTop()) {
                    this.trace("-> stop seek by pause");
                    this.mPlayer.rqPause(this.NEXT_STEP);
                } else {
                    this.trace("-> stop seek by resume");
                    this.mPlayer.rqResume(this.NEXT_STEP);
                }
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        int n = (this.mSound.isMediaOnTop() || this.mSound.isMuteActive()) && !this.mSound.isMuteStarted() ? (this.mDirection == 0 ? 6 : 7) : 2;
        this.mPlayer.getPlayerState().predictPlaybackState(n, this.getSequenceNumber());
        this.mPlayer.setSeekCanceled(false);
    }

    @Override
    public void onExit() {
        if (!this.isCompleted()) {
            this.mPlayer.pauseIfNotOnTop();
        }
        this.mPlayer.getPlayerState().clearPlaybackState(this.getSequenceNumber());
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("direction = ").append(this.getDirectionStr(this.mDirection)).toString();
    }

    private String getDirectionStr(int n) {
        switch (n) {
            case 1: {
                return "Backward";
            }
            case 0: {
                return "Forward";
            }
        }
        return "Unknown";
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "AUTOPLAY";
            }
            case 2: {
                return "RESUME_PLAYER";
            }
            case 3: {
                return "SEEK";
            }
            case 4: {
                return "AUTOPLAY_BT";
            }
            case 5: {
                return "ABORT_SEEK";
            }
        }
        return "UNKNOWN";
    }
}

