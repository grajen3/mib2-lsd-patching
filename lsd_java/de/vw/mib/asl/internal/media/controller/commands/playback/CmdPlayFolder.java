/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;

public final class CmdPlayFolder
extends AbstractCommand {
    private static int TIMEOUT;
    private static final int STEP_00_VALIDATE;
    private static final int STEP_01_OBTAIN_LIST_ENTRY;
    private static final int STEP_02_CHECK_LIST_ENTRY;
    private static final int STEP_03_CHANGE_FOLDER;
    private static final int STEP_04_SELECT_FOLDER;
    private static final int STEP_05_CHECK_FOLDER_SELECTION;
    private static final int STEP_06_ACTIVATE_SOURCE;
    private static final int STEP_07_SET_DEFAULT_PLAY_MODE;
    private static final int STEP_08_PLAY_FOLDER_SELECTION;
    private static final int STEP_09_SELECT_DEFAULT;
    private static final int STEP_10_PLAY_DEFAULT_SELECTION;
    private static final int STEP_11_RESUME;
    private final MediaComponents mComponents;
    private final MediaPlayer mPlayer;
    private final AbstractMediaBrowser mBrowser;
    private final long mEntryId;
    private final int mContentType;
    private final int mIndex;
    private final boolean mUseIndexSelection;
    private ExtendedListEntry mEntry;
    private Selection mFolderSelection;
    private Selection mDefaultSelection;
    private final MediaAudioManager mSound;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder;

    private CmdPlayFolder(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, long l, int n, int n2, boolean bl) {
        super(7 | abstractMediaBrowser.getComponentId(), 0, 11, TIMEOUT);
        this.mComponents = mediaComponents;
        this.mPlayer = mediaComponents.getPlayer();
        this.mSound = mediaComponents.getSound();
        this.mBrowser = abstractMediaBrowser;
        this.mEntryId = l;
        this.mContentType = n;
        this.mIndex = n2;
        this.mUseIndexSelection = bl;
    }

    public static Command createByIndex(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, int n, boolean bl) {
        if (!$assertionsDisabled && abstractMediaBrowser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && n < 0) {
            throw new AssertionError((Object)"index must be >= 0");
        }
        return new CmdPlayFolder(mediaComponents, abstractMediaBrowser, 0L, 0, n, bl);
    }

    public static Command createById(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, long l, int n, boolean bl) {
        if (!$assertionsDisabled && abstractMediaBrowser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && l < 0L) {
            throw new AssertionError((Object)"entryId must be >= 0");
        }
        if (!$assertionsDisabled && n <= 0) {
            throw new AssertionError((Object)"contentType must be > 0");
        }
        return new CmdPlayFolder(mediaComponents, abstractMediaBrowser, l, n, 0, bl);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                this.nextStep();
                break;
            }
            case 1: {
                if (this.mEntry == null) {
                    this.mBrowser.rqListEntry(this.mEntryId, this.mContentType, null, this.mIndex, false, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                if (this.mEntry == null) {
                    this.mEntry = this.mBrowser.getRequestedListEntry();
                }
                if (this.mEntry == null) {
                    this.commandFailed("matching listEntry not found");
                    return;
                }
                this.info(new StringBuffer().append("matching ListEntry found: ").append(this.mEntry).toString());
                if (this.mEntry.getFileState() != 0) {
                    this.mBrowser.triggerErrorTextFor(this.mEntry);
                    this.commandCompleted("playFolder ignored (invalid file state)");
                    return;
                }
                this.nextStep();
                break;
            }
            case 3: {
                if (!this.mUseIndexSelection) {
                    this.mBrowser.rqOpenFolder(this.mBrowser.getAbsolutePathByListEntry(this.mEntry), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 4: {
                this.mFolderSelection = this.mUseIndexSelection ? this.mBrowser.createEntrySelection(PlayMode.DUMMY_PLAY_DEFAULT, this.mEntry, true, false) : this.mBrowser.createFolderSelection(PlayMode.DUMMY_PLAY_DEFAULT, true, true, false);
                this.mBrowser.rqAddSelection(this.mFolderSelection, this.NEXT_STEP);
                return;
            }
            case 5: {
                if (this.mFolderSelection.getEntriesSelected() < 1L) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(432);
                    this.commandCompleted("selection empty");
                    return;
                }
                this.nextStep();
                break;
            }
            case 6: {
                MediaCollector mediaCollector = this.mBrowser.getBrowseMedia();
                MediaCollector mediaCollector2 = this.mPlayer.getActiveMedia();
                if (mediaCollector2 != mediaCollector) {
                    this.rqExecuteCmd(new CmdActivateSource(this.mComponents, mediaCollector, false, false), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 7: {
                if (!this.mPlayer.isDefaultPlaymode()) {
                    PlayMode playMode = this.mPlayer.getPlayerState().getPlaybackModeList().getPlayModeDefault();
                    this.mPlayer.rqSetPlaybackMode(playMode, this.mDefaultSelection, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 8: {
                boolean bl = this.mSound.isMediaOnTop();
                this.mPlayer.rqSetPlaySelection(this.mFolderSelection, 0L, true, bl, this.NEXT_STEP);
                return;
            }
            case 9: {
                this.mBrowser.rqAddSelection(this.mDefaultSelection, this.NEXT_STEP);
                return;
            }
            case 10: {
                boolean bl = this.mSound.isMediaOnTop();
                this.mPlayer.rqSetPlaySelection(this.mDefaultSelection, 0L, false, bl, this.NEXT_STEP);
                return;
            }
            case 11: {
                this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        this.mEntry = this.mBrowser.getListEntryInCache(this.mEntryId, this.mContentType, this.mIndex, null);
        this.mDefaultSelection = this.mBrowser.createDefaultSelection();
        this.mPlayer.getPlayerState().predictPlaybackMode(PlayMode.DUMMY_PLAY_DEFAULT, this.getSequenceNumber());
    }

    @Override
    public void onExit() {
        if (!this.isCompleted()) {
            this.mPlayer.pauseIfNotOnTop();
        }
        this.mPlayer.getPlayerState().clearPlaybackMode(this.getSequenceNumber());
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "VALIDATE";
            }
            case 1: {
                return "OBTAIN_LIST_ENTRY";
            }
            case 2: {
                return "CHECK_LIST_ENTRY";
            }
            case 4: {
                return "SELECT_FOLDER";
            }
            case 5: {
                return "CHECK_FOLDER_SELECTION";
            }
            case 6: {
                return "ACTIVATE_SOURCE";
            }
            case 7: {
                return "SET_DEFAULT_PLAY_MODE";
            }
            case 8: {
                return "PLAY_FOLDER_SELECTION";
            }
            case 9: {
                return "SELECT_DEFAULT";
            }
            case 10: {
                return "PLAY_DEFAULT_SELECTION";
            }
            case 11: {
                return "RESUME";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = new StringBuffer().append("instanceId: ").append(MediaBrowserHelper.getInstanceIdStr(this.mBrowser)).toString();
        string = this.mEntryId == 0L && this.mContentType == 0 ? new StringBuffer().append(string).append(", index: ").append(this.mIndex).toString() : new StringBuffer().append(string).append(", entryId: ").append(this.mEntryId).append(", contentType: ").append(MediaBrowserHelper.getContentTypeStr(this.mContentType)).toString();
        return string;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder = CmdPlayFolder.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFolder")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFolder).desiredAssertionStatus();
        TIMEOUT = 20000;
    }
}

