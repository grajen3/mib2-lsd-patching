/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;

public class CmdPlaySimilar
extends AbstractCommand {
    private static int TIMEOUT = 8000;
    private static final int STEP_1_SET_DEFAULT_PLAYMODE;
    private static final int STEP_2_PLAY_SIMILAR;
    private static final int STEP_3_RESUME;
    private final MediaPlayer mPlayer;
    private final MediaBrowser mBrowser;
    private final MediaAudioManager mSound;
    private Selection mSimilarSelection;
    private PlayMode mDefaultPlaymode;

    public CmdPlaySimilar(MediaPlayer mediaPlayer, MediaAudioManager mediaAudioManager, AbstractMediaBrowser abstractMediaBrowser) {
        super(6 | abstractMediaBrowser.getComponentId(), 1, 3, TIMEOUT);
        this.mPlayer = mediaPlayer;
        this.mBrowser = abstractMediaBrowser;
        this.mSound = mediaAudioManager;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                if (!this.mPlayer.isDefaultPlaymode()) {
                    this.mPlayer.rqSetPlaybackMode(this.mDefaultPlaymode, this.mBrowser.createDefaultSelection(), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                boolean bl = this.mSound.isMediaOnTop();
                this.mPlayer.rqPlaySimilar(this.mSimilarSelection, bl, this.NEXT_STEP);
                return;
            }
            case 3: {
                this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        this.mDefaultPlaymode = this.mPlayer.getPlayerState().getPlaybackModeList().getPlayModeDefault();
        this.mSimilarSelection = this.mBrowser.createPlaySimilarSelection(this.mDefaultPlaymode, this.mPlayer.getActiveTrackDetails());
        long l = this.getSequenceNumber();
        MediaPlayerState mediaPlayerState = this.mPlayer.getPlayerState();
        mediaPlayerState.predictPlaybackMode(this.mDefaultPlaymode, l);
        mediaPlayerState.predictPlaySelection(this.mSimilarSelection, l);
        int n = (this.mSound.isMediaOnTop() || this.mSound.isMuteActive()) && !this.mSound.isMuteStarted() ? 1 : 2;
        this.mPlayer.getPlayerState().predictPlaybackState(n, this.getSequenceNumber());
    }

    @Override
    public void onExit() {
        if (!this.isCompleted()) {
            this.mPlayer.pauseIfNotOnTop();
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2);
        long l = this.getSequenceNumber();
        MediaPlayerState mediaPlayerState = this.mPlayer.getPlayerState();
        mediaPlayerState.clearPlaybackMode(l);
        mediaPlayerState.clearPlaySelection(l);
        mediaPlayerState.clearPlaybackState(l);
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 1: {
                return "SET_DEFAULT_PLAYMODE";
            }
            case 2: {
                return "PLAY_SIMILAR";
            }
            case 3: {
                return "RESUME";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = MediaBrowserHelper.getInstanceIdStr(this.mBrowser);
        return new StringBuffer().append("instanceId=").append(string).toString();
    }
}

