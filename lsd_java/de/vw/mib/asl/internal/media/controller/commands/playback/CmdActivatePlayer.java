/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.controller.MediaSourceController;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.asl.internal.media.sourcehandling.target.ISources;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;

public class CmdActivatePlayer
extends AbstractCommand {
    private static int TIMEOUT = 20000;
    private static boolean mPerformancePingSent = false;
    private static final int EXECUTION_STEP_00_VALIDATE;
    private static final int EXECUTION_STEP_01_REQUEST_SOURCE_ACTIVATION;
    private static final int EXECUTION_STEP_02_RESTORE_LANGUAGE_SETTING;
    private static final int EXECUTION_STEP_03_REQUEST_AUDIO_CONNECTION;
    private static final int EXECUTION_STEP_04_PERFORMANCE_LOG;
    private static final int EXECUTION_STEP_05_SET_ACTIVE_MEDIA;
    private static final int EXECUTION_STEP_06_DISCONNECT_BLUETOOTH;
    private static final int EXECUTION_STEP_07_RESTORE_VIDEO_SETTINGS;
    private static final int EXECUTION_STEP_08_FADE_IN;
    private static final int EXECUTION_STEP_09_RESTORE_PLAYBACKMODE;
    private static final int EXECUTION_STEP_10_SET_PLAYBACK_MODE;
    private static final int EXECUTION_STEP_11_RESUME;
    private final MediaAudioManager mSound;
    private final MediaPlayer mPlayer;
    private final MediaMainBrowser mMainBrowser;
    private final ISources mSources;
    private final MediaCollector mMedia;
    private final boolean mRestorePlaymode;
    private final boolean mResume;

    public CmdActivatePlayer(MediaComponents mediaComponents, MediaCollector mediaCollector, boolean bl, boolean bl2) {
        super(7, 0, 11, TIMEOUT);
        if (mediaCollector == null) {
            throw new IllegalArgumentException("Cannot activate source <null>.");
        }
        this.mSound = mediaComponents.getSound();
        this.mPlayer = mediaComponents.getPlayer();
        this.mSources = mediaComponents.getSources();
        this.mMainBrowser = mediaComponents.getBrowser_MainView();
        this.mMedia = mediaCollector;
        this.mRestorePlaymode = bl;
        this.mResume = bl2;
    }

    @Override
    public void execute(int n) {
        if (this.mSources == null || this.mSound == null || this.mPlayer == null) {
            this.commandFailed("Sources, Sound or Player is null");
            return;
        }
        if (this.mMedia == null || !this.mSources.isDeviceValid(this.mMedia) || !this.mMedia.isMediaPlayable()) {
            this.commandFailed(new StringBuffer().append("Media is not Valid: ").append(this.mMedia).toString());
            return;
        }
        if (this.mSources.isCancelPending()) {
            this.commandCompleted("activation canceled.");
            return;
        }
        switch (n) {
            case 0: {
                if (this.mMedia.isDisconnectable() && this.mPlayer.getActiveMedia() == this.mMedia && this.mSound.isAudioConnectionMatching(this.mMedia)) {
                    this.mPlayer.resume();
                    this.commandCompleted("Tried to activate BT/Wlan which is already activated!");
                    return;
                }
                if (this.mMainBrowser != null) {
                    this.mMainBrowser.getState().notifyChangingPlayerSource(this.mMedia);
                }
                this.mSources.beginActivation();
                int n2 = MediaSourceController.getInstance().activateMediaSource(this.mMedia);
                switch (n2) {
                    case 2: {
                        SourceIconController.getInstance().setCurrentAudioSource(this.mMedia.getAslDeviceID());
                        if (this.mPlayer.getActiveMedia() == this.mMedia) {
                            this.commandCompleted("Already active");
                            return;
                        }
                        this.trace("MediaSourceController says active, but MediaPlayer knows better");
                        break;
                    }
                    case 0: {
                        this.trace("activate success");
                        break;
                    }
                    case 1: 
                    case 3: {
                        this.commandFailed("ACTIVATE_UNPLAYABLE/ACTIVATE_GENERAL_ERROR");
                        return;
                    }
                    default: {
                        this.commandFailed("unknown result code of activateMediaSource");
                        return;
                    }
                }
                this.mPlayer.setPlayerState(2);
                this.nextStep();
                break;
            }
            case 1: {
                this.nextStep();
                return;
            }
            case 2: {
                this.mPlayer.rqRestoreLSCLanguageAsPreferred(this.NEXT_STEP);
                if (!this.mMedia.isDVDVideoAudio()) break;
                this.mPlayer.restorePML();
                break;
            }
            case 3: {
                this.mSound.rqAudioConnection(this.mMedia, this.NEXT_STEP);
                return;
            }
            case 4: {
                if (ServiceManager.perfService != null && !mPerformancePingSent) {
                    mPerformancePingSent = true;
                    ServiceManager.perfService.performanceLogMsgByID(15);
                }
                this.nextStep();
                break;
            }
            case 5: {
                this.suspendTimer("setActiveMedia may take some time");
                this.mPlayer.rqMediaActivation(this.mMedia, this.NEXT_STEP);
                return;
            }
            case 6: {
                this.resumeTimer();
                this.mSources.disconnectBluetooth(this.mMedia);
                this.nextStep();
                break;
            }
            case 7: {
                if (this.mPlayer.getActiveMedia().getMediaCaps() != null && this.mPlayer.getActiveMedia().getMediaCaps().isVideoSupport()) {
                    this.mPlayer.restoreVideoSize();
                    this.mPlayer.rqRestoreVideoFormat(this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 8: {
                if (this.mSound.isMediaOnTop()) {
                    this.mSound.rqMediaFadeIn(this.NO_OPERATION);
                }
                if (this.mPlayer.getCapabilities() != null && !this.mPlayer.getCapabilities().isPlay()) {
                    this.mMedia.clearVirginity();
                    this.commandCompleted("no resume for this source");
                    return;
                }
                this.nextStep();
                break;
            }
            case 9: {
                if (this.mRestorePlaymode) {
                    if (this.mMedia.storesOwnPlaybackState()) {
                        this.mPlayer.rqSetPlaybackMode(PlayMode.DUMMY_EXTERNAL, null, this.NEXT_STEP);
                    } else {
                        this.mPlayer.rqRestorePlaybackMode(this.NEXT_STEP);
                    }
                    return;
                }
                this.nextStep();
                break;
            }
            case 10: {
                MediaPlayerState mediaPlayerState;
                MediaPlaybackModes mediaPlaybackModes;
                if (this.mRestorePlaymode && this.mMedia.isBT() && this.mMedia.isVirgin() && (mediaPlaybackModes = (mediaPlayerState = this.mPlayer.getPlayerState()).getPlaybackModeList()) != null && !mediaPlayerState.involvesRepeat()) {
                    PlayMode playMode = mediaPlaybackModes.toggleRepeat(mediaPlayerState.getPlaybackMode());
                    this.mPlayer.rqSetPlaybackMode(playMode, null, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 11: {
                this.mMedia.clearVirginity();
                if (this.mSound.isMediaOnTop() && this.mSound.isAudioConnectionAvailable()) {
                    if (this.mResume) {
                        this.rqExecuteCmd(CmdPlaybackResume.createInfiniteResumeCmd(this.mPlayer, this.mSound), this.NEXT_STEP);
                        return;
                    }
                } else {
                    this.rqExecuteCmd(CmdPlaybackPause.createSystemPauseCmd(this.mPlayer, this.mSound), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
        }
    }

    @Override
    public void onEnter() {
        this.mPlayer.getPlayerState().predictPlaybackEntry(new EntryInfo(-1L, "", 0, "", 0L, 0L, -1L, -1L, -1L, "", "", "", "", "", 0L, 0L, 0, 0, null), new ListEntry[0], this.getSequenceNumber());
        this.mPlayer.getPlayerState().predictPlaybackMedia(this.mMedia, this.getSequenceNumber());
        int n = (this.mSound.isMediaOnTop() || this.mSound.isMuteActive()) && !this.mSound.isMuteStarted() ? 1 : 2;
        this.mPlayer.getPlayerState().predictPlaybackState(n, this.getSequenceNumber());
    }

    @Override
    public void onExit() {
        this.mPlayer.getPlayerState().clearPlaybackMedia(this.getSequenceNumber());
        this.mSound.unlockAllVolumeConnections();
        this.mPlayer.setPlayerState(3);
        if (this.isCompleted()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(861670400, this.mMedia.isFlagSet(2048));
        }
        this.mPlayer.getPlayerState().clearPlaybackState(this.getSequenceNumber());
        this.mPlayer.getPlayerState().clearPlaybackEntry(this.getSequenceNumber());
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "REQUEST_SOURCE_ACTIVATION";
            }
            case 2: {
                return "RESTORE_LANGUAGE_SETTING";
            }
            case 3: {
                return "REQUEST_AUDIO_CONNECTION";
            }
            case 4: {
                return "PERFORMANCE_LOG";
            }
            case 5: {
                return new StringBuffer().append("SET_ACTIVE_MEDIA ").append(this.mMedia.toStringShort()).toString();
            }
            case 6: {
                return "DISCONNECT BLUETOOTH";
            }
            case 7: {
                return "RESTORE_VIDEO_SETTINGS";
            }
            case 8: {
                return "FADE_IN";
            }
            case 9: {
                return "RESTORE_PLAYBACK_MODE";
            }
            case 10: {
                return "SET_PLAYBACK_MODE_EXTERNAL";
            }
            case 11: {
                return "RESUME";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = this.mRestorePlaymode ? " [restorePlaymode]" : "";
        String string2 = this.mResume ? " [resume]" : "";
        return new StringBuffer().append("MediaCollector: ").append(this.mMedia).append(string).append(string2).toString();
    }
}

