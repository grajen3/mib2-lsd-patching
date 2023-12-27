/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.sound;

import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;

public class CmdRestoreAudioConnection
extends AbstractCommand {
    private static int TIMEOUT = 15000;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;
    private Command mRestoreCmd = null;

    public CmdRestoreAudioConnection(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager) {
        super(6, 1, 5, TIMEOUT);
        this.mPlayer = mediaPlayer;
        this.mSound = mediaAudioManager;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                if (this.mSound.isMuteBeforeAmUnavailable()) {
                    this.mSound.rqMute(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                this.mSound.rqAudioConnection(this.mPlayer.getActiveMedia(), this.NEXT_STEP);
                return;
            }
            case 3: {
                this.mSound.rqMediaFadeIn(this.NEXT_STEP);
                return;
            }
            case 4: {
                this.mSound.unlockAllVolumeConnections();
                this.nextStep();
                break;
            }
            case 5: {
                this.mRestoreCmd = this.mSound.isMuteActive() ? CmdPlaybackPause.createUserPauseCmd(this.mPlayer, this.mSound) : new CmdPlaybackResume(this.mPlayer, this.mSound);
                this.rqExecuteCmd(this.mRestoreCmd, this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    protected String getParameterStr() {
        return this.mPlayer.getActiveMedia() != null ? this.mPlayer.getActiveMedia().toStringShort() : "player has no active media";
    }

    @Override
    protected String getStepStr(int n) {
        return null;
    }
}

