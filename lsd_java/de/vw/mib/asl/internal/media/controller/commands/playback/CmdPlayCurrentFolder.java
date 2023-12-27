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
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;

public class CmdPlayCurrentFolder
extends AbstractCommand {
    private static int TIMEOUT = 20000;
    private static final int STEP_00_DETECT_FLAT_LIST;
    private static final int STEP_01_VALIDATE;
    private static final int STEP_02_SELECT_FOLDER;
    private static final int STEP_03_CHECK_SELECTION;
    private static final int STEP_04_ACTIVATE_SOURCE;
    private static final int STEP_05_SET_PLAYBACKMODE;
    private static final int STEP_06_SET_PLAYSELECTION;
    private static final int STEP_07_SELECT_MEDIA;
    private static final int STEP_08_SET_PLAYSELECTION;
    private static final int STEP_09_RESUME;
    private final MediaComponents mAllComponents;
    private final AbstractMediaBrowser mBrowser;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;
    private Selection mFolderSelection;
    private final Selection mDefaultSelection;
    private PlayMode mDefaultPlaymode;
    private boolean mPlaylistOnly;

    public CmdPlayCurrentFolder(MediaComponents mediaComponents) {
        super(39, 0, 9, TIMEOUT);
        this.mAllComponents = mediaComponents;
        this.mBrowser = mediaComponents.getBrowser_MainView();
        this.mPlayer = mediaComponents.getPlayer();
        this.mSound = mediaComponents.getSound();
        this.mDefaultSelection = this.mBrowser.createDefaultSelection();
        this.mDefaultPlaymode = PlayMode.DUMMY_PLAY_DEFAULT;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                boolean bl = this.mPlaylistOnly = this.mBrowser.getBrowseMedia().isCDDA() || MediaBrowserHelper.isFolderSpecificSelectionRequired(this.mBrowser.getBrowseFolder());
                if (this.mPlaylistOnly) {
                    this.rqExecuteCmd(CmdPlayFile.createByIndex(this.mAllComponents, this.mBrowser, 0, false, true), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                if (this.mPlaylistOnly) {
                    this.commandCompleted("flat list detected: playAll completed by playing the first track");
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                if (this.mPlayer.getActiveMedia() == this.mBrowser.getBrowseMedia()) {
                    this.mDefaultPlaymode = this.mPlayer.getPlayerState().getPlaybackModeList().getPlayModeByDummyPlaymode(this.mDefaultPlaymode);
                    this.updatePrediction();
                }
                this.mFolderSelection = this.mBrowser.createFolderSelection(this.mDefaultPlaymode, true, true, false);
                this.mBrowser.rqAddSelection(this.mFolderSelection, this.NEXT_STEP);
                return;
            }
            case 3: {
                if (this.mFolderSelection.getEntriesSelected() < 1L) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(432);
                    this.commandCompleted("selection empty");
                    return;
                }
                this.nextStep();
                break;
            }
            case 4: {
                if (this.mPlayer.getActiveMedia() != this.mBrowser.getBrowseMedia()) {
                    this.rqExecuteCmd(new CmdActivateSource(this.mAllComponents, this.mBrowser.getBrowseMedia(), false, false), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 5: {
                if (!this.mPlayer.isDefaultPlaymode()) {
                    this.mPlayer.rqSetDefaultPlaybackMode(this.mDefaultSelection, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 6: {
                boolean bl = this.mSound.isMediaOnTop();
                this.mPlayer.rqSetPlaySelection(this.mFolderSelection, 0L, true, bl, this.NEXT_STEP);
                return;
            }
            case 7: {
                this.mBrowser.rqAddSelection(this.mDefaultSelection, this.NEXT_STEP);
                return;
            }
            case 8: {
                boolean bl = this.mSound.isMediaOnTop();
                this.mPlayer.rqSetPlaySelection(this.mDefaultSelection, 0L, false, bl, this.NEXT_STEP);
                return;
            }
            case 9: {
                this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        this.updatePrediction();
    }

    private void updatePrediction() {
        this.mPlayer.getPlayerState().predictPlaybackMode(this.mDefaultPlaymode, this.getSequenceNumber());
    }

    @Override
    public void onExit() {
        if (!this.isCompleted()) {
            this.mPlayer.pauseIfNotOnTop();
        }
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(4);
        this.mPlayer.getPlayerState().clearPlaybackMode(this.getSequenceNumber());
    }

    @Override
    protected String getStepStr(int n) {
        return null;
    }

    @Override
    protected String getParameterStr() {
        return null;
    }
}

