/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;

public class CmdDeactivatePlayer
extends AbstractCommand {
    private static int TIMEOUT = 15000;
    private static final int STEP_1_RQ_DUMMY_AUDIO_CONNECTION;
    private static final int STEP_2_DEACTIVATE_PLAYER;
    private static final int STEP_3_WAIT_FOR_PLAYBACK_FLAG_UNSET;
    private final ISources mSources;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;
    private final boolean mLeaveMedia;
    private final boolean mCallbackSources;
    private MediaCollector mDeactivatedMedia;

    public CmdDeactivatePlayer(MediaAudioManager mediaAudioManager, MediaPlayer mediaPlayer, ISources iSources, boolean bl, boolean bl2) {
        super(7, 1, 3, TIMEOUT);
        this.mSound = mediaAudioManager;
        this.mPlayer = mediaPlayer;
        this.mSources = iSources;
        this.mLeaveMedia = bl;
        this.mCallbackSources = bl2;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                if (!this.mCallbackSources) {
                    this.mSources.beginActivation();
                }
                this.mDeactivatedMedia = this.mPlayer.getActiveMedia();
                this.mPlayer.setPlayerState(0);
                if (this.mLeaveMedia) {
                    if (this.mSound.isMediaOnTop()) {
                        this.mSound.rqWaitForMediaNotAudible(this.NEXT_STEP);
                        return;
                    }
                } else {
                    this.mSound.rqDummyAudioConnection(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                this.deactivate();
                return;
            }
            case 3: {
                if (this.mDeactivatedMedia != null && this.mDeactivatedMedia != MediaCollector.EMPTY) {
                    this.mPlayer.rqWaitForFlag(this.mDeactivatedMedia, 512, false, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
        }
    }

    private void deactivate() {
        this.mSound.resetLastRequestedConnections();
        if (this.mPlayer.getCapabilities() != null && this.mPlayer.getCapabilities().isPause()) {
            this.mPlayer.pause(false);
        }
        this.mPlayer.rqMediaActivation(MediaCollector.EMPTY, this.NEXT_STEP);
    }

    @Override
    public void onExit() {
        if (this.isAbortedByTimeout()) {
            this.deactivate();
        }
        if (this.mSources != null && this.mCallbackSources) {
            this.mSources.endDeactivation(MediaCollector.EMPTY, this, true);
        }
        if (this.isCompleted()) {
            MediaObjectAccessor.mMediaController.synchronizeBrowser(true, "CmdDeactivatePlayer.onExit()");
        }
        this.mPlayer.setPlayerState(1);
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "RQ_DUMMY_AUDIO_CONNECTION";
            }
            case 2: {
                return "DEACTIVATE_PLAYER";
            }
            case 3: {
                return "WAIT_FOR_PLAYBACK_FLAG_UNSET";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("leaveMedia=").append(this.mLeaveMedia).toString();
    }
}

