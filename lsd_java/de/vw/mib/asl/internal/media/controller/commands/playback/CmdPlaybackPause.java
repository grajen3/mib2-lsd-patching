/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import org.dsi.ifc.media.Capabilities;

public final class CmdPlaybackPause
extends AbstractCommand {
    private static int TIMEOUT = 10000;
    private static final int STEP_0_MUTE;
    private static final int STEP_1_PAUSE;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;
    private final boolean mUserPause;

    private CmdPlaybackPause(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager, boolean bl) {
        super(6, 0, 1, TIMEOUT);
        this.mPlayer = mediaPlayer;
        this.mSound = mediaAudioManager;
        this.mUserPause = bl;
    }

    public static Command createUserPauseCmd(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager) {
        return new CmdPlaybackPause(mediaPlayer, mediaAudioManager, true);
    }

    public static Command createSystemPauseCmd(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager) {
        return new CmdPlaybackPause(mediaPlayer, mediaAudioManager, false);
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
                if (this.mUserPause && !this.mSound.isMuteActive() && this.mSound.isAudioConnectionAvailable()) {
                    if (this.isTraceEnabled()) {
                        this.trace("-> request mute");
                    }
                    this.mSound.rqMute(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                if (!this.mSound.isMediaOnTop() || !this.mUserPause) {
                    Capabilities capabilities;
                    if (this.isTraceEnabled()) {
                        this.trace(new StringBuffer().append("playerState: ").append(MediaBrowserHelper.getPlaybackStateStr(this.mPlayer.getDSIPlaybackState())).toString());
                    }
                    if ((this.mPlayer.isPlaying() || this.mPlayer.getDSIPlaybackState() == 1) && (capabilities = this.mPlayer.getCapabilities()) != null && capabilities.isPause()) {
                        if (this.isTraceEnabled()) {
                            this.trace("-> request pause");
                        }
                        this.mPlayer.rqPause(this.NEXT_STEP);
                        return;
                    }
                } else {
                    this.commandCompleted("pause postponed as media is still audible after mute");
                    return;
                }
                this.nextStep();
                break;
            }
        }
    }

    @Override
    public void onEnter() {
        this.mPlayer.getPlayerState().predictPlaybackState(2, this.getSequenceNumber());
    }

    @Override
    public void onExit() {
        this.mPlayer.getPlayerState().clearPlaybackState(this.getSequenceNumber());
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "MUTE";
            }
            case 1: {
                return "PAUSE";
            }
        }
        return "UNKNOWN";
    }

    @Override
    protected String getParameterStr() {
        return this.mUserPause ? "userPause" : "systemPause";
    }
}

