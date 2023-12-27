/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.settings.MediaSettings;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public class CmdSetPlaybackMode
extends AbstractCommand {
    private static int TIMEOUT = 20000;
    private static final int STEP_1_CHECK_SELECTION_NEEDED;
    private static final int STEP_2_TRY_REGULAR_SELECTION;
    private static final int STEP_3_REQUEST_INCLUDE_SUBDIRECTORY_SETTING;
    private static final int STEP_4_TRY_RECURSIVE_SELECTION;
    private static final int STEP_5_CHECK_SELECTION_RESULT;
    private static final int STEP_6_ACTIVATE_SOURCE;
    private static final int STEP_7_SET_PLAYBACKMODE;
    private static final int STEP_8_SET_PLAYSELECTION;
    private static final int STEP_9_RESUME;
    private final MediaComponents mComponents;
    private final AbstractMediaBrowser mBrowser;
    private final MediaPlayer mPlayer;
    private final MediaSettings mSettings;
    private final Selection mSelection;
    private PlayMode mPlayMode;
    private final boolean mForcePause;
    private final boolean mForceDefaultSelection;
    private boolean mSkipSelection;
    private final boolean mDontCloseBrowser;
    private final MediaAudioManager mSound;

    private CmdSetPlaybackMode(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, PlayMode playMode, boolean bl, boolean bl2, boolean bl3) {
        super(39, 0, 8, TIMEOUT);
        this.mComponents = mediaComponents;
        this.mDontCloseBrowser = bl3;
        this.mBrowser = abstractMediaBrowser;
        this.mPlayer = mediaComponents.getPlayer();
        this.mSound = mediaComponents.getSound();
        this.mSettings = mediaComponents.getSettings();
        this.mForcePause = bl;
        this.mForceDefaultSelection = bl2;
        Selection selection = null;
        if (this.mBrowser.isBrowsingAvailable() && !this.mBrowser.getBrowseMedia().storesOwnPlaybackState()) {
            if (playMode.isRepeatFolder() || playMode.isMix()) {
                boolean bl4 = this.mSettings.getIncludeSubfolder() || this.mBrowser.isInContentMode();
                selection = this.mBrowser.createFolderSelection(playMode, true, bl4, false);
            } else {
                selection = this.mBrowser.createDefaultSelection(playMode, bl2, false);
            }
        }
        this.mSelection = selection;
        this.mPlayMode = playMode;
    }

    public CmdSetPlaybackMode(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, PlayMode playMode, boolean bl) {
        this(mediaComponents, abstractMediaBrowser, playMode, bl, false, true);
    }

    public CmdSetPlaybackMode(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser) {
        this(mediaComponents, abstractMediaBrowser, PlayMode.DUMMY_PLAY_DEFAULT, false, true, true);
    }

    public CmdSetPlaybackMode(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, PlayMode playMode, boolean bl, boolean bl2) {
        this(mediaComponents, abstractMediaBrowser, playMode, bl, false, bl2);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mPlayer.getActiveMedia() == this.mBrowser.getBrowseMedia() && !this.mPlayer.getActiveMedia().isBT() && this.mPlayer.getActiveTrackId() == 0L && this.mPlayer.getDSIPlaybackState() != 11) {
                    this.commandCompleted("to be ignored while we are not in a stable state skipping corrupt files?)");
                    return;
                }
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append(" 01_CHECK_SELECTION_NEEDED  mPlayer: ").append(this.mPlayer.getActiveMedia()).append("  mBrowser: ").append(this.mBrowser.getBrowseMedia()).toString());
                }
                if (this.mPlayer.getActiveMedia() == this.mBrowser.getBrowseMedia()) {
                    this.mPlayMode = this.mPlayer.getPlayerState().getPlaybackModeList().getPlayModeByDummyPlaymode(this.mPlayMode, this.mSelection);
                    this.mPlayer.getPlayerState().predictPlaybackMode(this.mPlayMode, this.getSequenceNumber());
                }
                MediaCollector mediaCollector = this.mBrowser.getBrowseMedia();
                boolean bl = this.mSkipSelection = (this.mSelection == null || this.mSelection.equalsTo(this.mPlayer.getPlaySelection()) || this.mPlayer.getPlaySelection() != null && MediaBrowserHelper.isDynamicPlaylistFolder(this.mPlayer.getPlaySelection().getSelectionPath())) && !mediaCollector.isImportedTo() && !this.mForceDefaultSelection;
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append(" 01_CHECK_SELECTION_NEEDED  mSkipSelection: ").append(this.mSkipSelection).toString());
                }
                if (this.mSkipSelection) {
                    this.skipTo(5);
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                this.mBrowser.rqAddSelection(this.mSelection, this.NEXT_STEP);
                return;
            }
            case 2: {
                if (this.mSelection.getEntriesSelected() == 0L && !this.mSelection.isRecursive() && !this.mSettings.getIncludeSubfolder()) {
                    this.suspendTimer("includeSubDir Popup (user interaction)");
                    this.mSettings.rqIncludeSubfolder(this.NEXT_STEP);
                    return;
                }
                this.skipTo(4);
                return;
            }
            case 3: {
                this.resumeTimer();
                if (this.mSettings.getIncludeSubfolder()) {
                    this.mSelection.setRecursive(true);
                    this.mBrowser.rqAddSelection(this.mSelection, this.NEXT_STEP);
                    return;
                }
                this.commandCompleted("user does not want to toggle include subfolder setting!");
                return;
            }
            case 4: {
                if (this.mSelection.getEntriesSelected() == 0L) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(432);
                    this.commandCompleted("selection empty");
                    return;
                }
                this.nextStep();
                break;
            }
            case 5: {
                if (this.isTraceEnabled()) {
                    this.trace(new StringBuffer().append(" ACTIVATE_SOURCE  mPlayer: ").append(this.mPlayer.getActiveMedia()).append("  mBrowser: ").append(this.mBrowser.getBrowseMedia()).append(" same Media: ").append(this.mPlayer.getActiveMedia() != this.mBrowser.getBrowseMedia()).toString());
                }
                if (this.mPlayer.getActiveMedia() != this.mBrowser.getBrowseMedia()) {
                    this.rqExecuteCmd(new CmdActivateSource(this.mComponents, this.mBrowser.getBrowseMedia(), false, false), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 6: {
                this.mPlayMode = this.mPlayer.getPlayerState().getPlaybackModeList().getPlayModeByDummyPlaymode(this.mPlayMode, this.mSelection);
                this.mPlayer.getPlayerState().predictPlaybackMode(this.mPlayMode, this.getSequenceNumber());
                this.mPlayer.rqSetPlaybackMode(this.mPlayMode, this.mSelection, this.NEXT_STEP);
                return;
            }
            case 7: {
                if (!this.mSkipSelection) {
                    boolean bl = !this.mForcePause && this.mSound.isMediaOnTop();
                    this.mPlayer.rqSetPlaySelection(this.mSelection, 0L, this.mForceDefaultSelection, bl, this.NEXT_STEP);
                    return;
                }
                if (this.isTraceEnabled()) {
                    this.trace("-> no play selection set");
                }
                this.nextStep();
                break;
            }
            case 8: {
                if (!this.mForcePause) {
                    this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
        }
    }

    @Override
    public void onEnter() {
        long l = this.getSequenceNumber();
        MediaPlayerState mediaPlayerState = this.mPlayer.getPlayerState();
        mediaPlayerState.predictPlaybackMode(this.mPlayMode, l);
        mediaPlayerState.predictPlaySelection(this.mSelection, l);
    }

    @Override
    public void onExit() {
        if (!this.isCompleted()) {
            this.mPlayer.pauseIfNotOnTop();
        }
        if (!this.mDontCloseBrowser) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(4);
        }
        this.mPlayer.resetPlayDefaultAfterStop();
        long l = this.getSequenceNumber();
        MediaPlayerState mediaPlayerState = this.mPlayer.getPlayerState();
        mediaPlayerState.clearPlaybackMode(l);
        mediaPlayerState.clearPlaySelection(l);
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "CHECK_SELECTION_NEEDED";
            }
            case 1: {
                return "TRY_REGULAR_SELECTION";
            }
            case 2: {
                return "REQUEST_INCLUDE_SUBDIRECTORY_SETTING";
            }
            case 3: {
                return "TRY_RECURSIVE_SELECTION";
            }
            case 4: {
                return "CHECK_SELECTION_RESULT";
            }
            case 5: {
                return "ACTIVATE_SOURCE";
            }
            case 6: {
                return "SET_PLAYBACKMODE";
            }
            case 7: {
                return "SET_PLAYSELECTION";
            }
            case 8: {
                return "RESUME";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        return new StringBuffer().append("playmode: ").append(this.mPlayMode).append(", forcePause: ").append(this.mForcePause).toString();
    }
}

