/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller.commands.playback;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.controller.MediaComponents;
import de.vw.mib.asl.internal.media.controller.commands.AbstractCommand;
import de.vw.mib.asl.internal.media.controller.commands.Command;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdActivateSource;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackPause;
import de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlaybackResume;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.media.EntryInfo;

public final class CmdPlayFile
extends AbstractCommand {
    private static final String AUTOSKIP_FILENAME;
    private static EventGeneric autoskipEvent;
    private static int TIMEOUT;
    private static final int STEP_0_OBTAIN_LIST_ENTRY;
    private static final int STEP_1_VALIDATE;
    private static final int STEP_2_PAUSE_OR_PLAY_IF_ACTIVE;
    private static final int STEP_3_PREPARE;
    private static final int STEP_4_ACTIVATE_SOURCE;
    private static final int STEP_5_PREPARE_SELECTION;
    private static final int STEP_6_DO_SELECTION;
    private static final int STEP_7_SET_PLAYBACKMODE;
    private static final int STEP_8_SET_PLAYSELECTION;
    private static final int STEP_9_RESUME;
    private final MediaComponents mComponents;
    private final MediaPlayer mPlayer;
    private final MediaAudioManager mSound;
    private final AbstractMediaBrowser mBrowser;
    private final long mEntryId;
    private final int mContentType;
    private int mIndex;
    private Selection mDefaultSelection;
    private PlayMode mDefaultPlaymode;
    private final boolean mTogglePlayback;
    private boolean mExecuteSelection;
    private ExtendedListEntry mFileEntry;
    private boolean mFileEntryActive;
    private final boolean mSearchFirstPlayable;
    private boolean mPlaybackFailed = false;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile;

    private CmdPlayFile(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, long l, int n, int n2, boolean bl, boolean bl2) {
        super(7 | abstractMediaBrowser.getComponentId(), 0, 9, TIMEOUT);
        this.mComponents = mediaComponents;
        this.mPlayer = mediaComponents.getPlayer();
        this.mSound = mediaComponents.getSound();
        this.mBrowser = abstractMediaBrowser;
        this.mEntryId = l;
        this.mContentType = n;
        this.mIndex = n2;
        this.mTogglePlayback = bl;
        this.mSearchFirstPlayable = bl2;
    }

    public static Command createByIndex(MediaComponents mediaComponents, AbstractMediaBrowser abstractMediaBrowser, int n, boolean bl, boolean bl2) {
        if (!$assertionsDisabled && abstractMediaBrowser == null) {
            throw new AssertionError((Object)"browser must not be null");
        }
        if (!$assertionsDisabled && n < 0) {
            throw new AssertionError((Object)"index must be >= 0");
        }
        return new CmdPlayFile(mediaComponents, abstractMediaBrowser, 0L, 0, n, bl, bl2);
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
        return new CmdPlayFile(mediaComponents, abstractMediaBrowser, l, n, 0, bl, false);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 0: {
                if (this.mFileEntry == null) {
                    this.mBrowser.rqListEntry(this.mEntryId, this.mContentType, null, this.mIndex, false, this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 1: {
                if (this.mFileEntry == null) {
                    this.mFileEntry = this.mBrowser.getRequestedListEntry();
                    if (this.mFileEntry != null) {
                        this.mFileEntryActive = this.mFileEntry.isActive;
                    }
                }
                if (this.mFileEntry == null) {
                    this.commandFailed("matching listEntry not found");
                    return;
                }
                this.info(new StringBuffer().append("matching ListEntry found: ").append(MediaBrowserHelper.getListEntryStr(this.mFileEntry)).toString());
                if (this.mFileEntry.getFileState() != 0) {
                    this.mPlaybackFailed = true;
                    this.mBrowser.triggerErrorTextFor(this.mFileEntry);
                    this.commandCompleted("playFile ignored (invalid file state)");
                    return;
                }
                this.nextStep();
                break;
            }
            case 2: {
                if (this.mFileEntryActive && this.mTogglePlayback) {
                    if (this.mPlayer.isPlaying()) {
                        this.rqExecuteCmd(CmdPlaybackPause.createUserPauseCmd(this.mPlayer, this.mComponents.getSound()), this.NEXT_STEP);
                        return;
                    }
                    this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mComponents.getSound()), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 3: {
                int n2;
                if (this.mFileEntryActive && this.mTogglePlayback) {
                    this.commandCompleted("track already active: playback was toggled");
                    return;
                }
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(400) && (n2 = this.mFileEntry.getFilename().toLowerCase().indexOf("autoskip_az")) > 0) {
                    int n3;
                    if (autoskipEvent != null) {
                        MediaObjectAccessor.mMediaController.stopTimer(705298496);
                        autoskipEvent = null;
                    }
                    if ((n3 = Integer.parseInt(this.mFileEntry.getFilename().substring(0, n2))) > 0) {
                        autoskipEvent = ServiceManager.mGenericEventFactory.newEvent(279909120, 279909120, 705298496);
                        autoskipEvent.setInt(0, 1);
                        MediaObjectAccessor.mMediaController.startTimer(autoskipEvent, (long)(n3 * 1000), true);
                    }
                }
                this.nextStep();
                break;
            }
            case 4: {
                MediaCollector mediaCollector = this.mBrowser.getBrowseMedia();
                MediaCollector mediaCollector2 = this.mPlayer.getActiveMedia();
                if (mediaCollector2 != mediaCollector) {
                    this.rqExecuteCmd(new CmdActivateSource(this.mComponents, mediaCollector, false, false), this.NEXT_STEP);
                    return;
                }
                this.nextStep();
                break;
            }
            case 5: {
                this.mDefaultPlaymode = this.mPlayer.getPlayerState().getPlaybackModeList() == null ? null : this.mPlayer.getPlayerState().getPlaybackModeList().getPlayModeByDummyPlaymode(this.mDefaultPlaymode, this.mDefaultSelection);
                MediaCollector mediaCollector = this.mPlayer.getActiveMedia();
                if (mediaCollector.isCDDA()) {
                    this.mExecuteSelection = false;
                } else if (mediaCollector.isWLAN() || mediaCollector.isIPod() || mediaCollector.isBT()) {
                    this.mExecuteSelection = true;
                } else {
                    boolean bl = !mediaCollector.isFlagSet(256);
                    boolean bl2 = this.mExecuteSelection = bl || mediaCollector.isImportedTo() || this.mDefaultPlaymode == null || (this.mDefaultPlaymode.usesSelections() || this.mDefaultPlaymode.isMediumSelection()) && (!this.mDefaultSelection.equalsTo(this.mPlayer.getPlaySelection()) || this.mPlayer.getPlaySelection() != null && MediaBrowserHelper.isDynamicPlaylistFolder(this.mPlayer.getPlaySelection().getSelectionPath()));
                }
                if (this.mExecuteSelection) {
                    this.mPlayer.getPlayerState().predictPlaySelection(this.mDefaultSelection, this.getSequenceNumber());
                }
                this.nextStep();
                break;
            }
            case 6: {
                if (this.mExecuteSelection) {
                    this.mBrowser.rqAddSelection(this.mDefaultSelection, this.NEXT_STEP);
                } else {
                    this.trace("No selection needed, skipping");
                    this.nextStep();
                }
                return;
            }
            case 7: {
                this.mPlayer.rqSetPlaybackMode(this.mDefaultPlaymode, this.mDefaultSelection, this.NEXT_STEP);
                return;
            }
            case 8: {
                boolean bl = this.mSound.isMediaOnTop();
                if (this.mExecuteSelection) {
                    this.mPlayer.rqSetPlaySelection(this.mDefaultSelection, this.mFileEntry.getEntryID(), true, bl, this.NEXT_STEP);
                } else {
                    this.mPlayer.rqSetEntry(this.mFileEntry.getEntryID(), bl, this.NEXT_STEP);
                }
                return;
            }
            case 9: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2);
                this.rqExecuteCmd(new CmdPlaybackResume(this.mPlayer, this.mSound), this.NEXT_STEP);
                return;
            }
        }
    }

    @Override
    public void onEnter() {
        if (this.mBrowser == null || !this.mBrowser.isBrowsingAvailable()) {
            this.abort("browsing not available");
            return;
        }
        this.mFileEntry = this.mBrowser.getListEntryInCache(this.mEntryId, this.mContentType, this.mIndex, null);
        if (this.mSearchFirstPlayable && this.mIndex == 0 && this.mFileEntry != null && this.mFileEntry.getFileState() != 0) {
            while (this.mFileEntry != null && this.mFileEntry.getFileState() != 0 && this.mIndex < this.mBrowser.getListSize()) {
                this.mFileEntry = this.mBrowser.getListEntryInCache(this.mEntryId, this.mContentType, ++this.mIndex, null);
            }
            if (this.mFileEntry != null && this.mFileEntry.getFileState() == 0) {
                this.trace(new StringBuffer().append("Found valid list item at index ").append(this.mIndex).toString());
            } else {
                this.mIndex = 0;
            }
        }
        this.mDefaultSelection = this.mBrowser.createDefaultSelection();
        this.mDefaultPlaymode = !this.mBrowser.getBrowseMedia().isBT() ? PlayMode.DUMMY_PLAY_DEFAULT : PlayMode.DUMMY_REPEAT;
        this.mFileEntryActive = this.mFileEntry != null && this.mFileEntry.isActive;
        long l = this.getSequenceNumber();
        MediaPlayerState mediaPlayerState = this.mPlayer.getPlayerState();
        if (this.mFileEntry != null) {
            if (this.mPlayer.getActiveMedia() != this.mBrowser.getBrowseMedia()) {
                mediaPlayerState.predictActivationState(2, l);
                mediaPlayerState.predictPlaybackMedia(this.mBrowser.getBrowseMedia(), l);
            } else if (this.mFileEntry.isActive && this.mTogglePlayback) {
                mediaPlayerState.predictPlaybackState(2, l);
            } else {
                mediaPlayerState.predictPlaybackState(1, l);
            }
            if (this.mFileEntry.hasExtendedInfo()) {
                MediaCollector mediaCollector = this.mPlayer.getActiveMedia();
                if (mediaCollector == null || mediaCollector != this.mBrowser.getBrowseMedia()) {
                    return;
                }
                if (mediaCollector.supportsContentMode() && !mediaCollector.isContentModeReadyToUse(true)) {
                    return;
                }
                if (mediaCollector.supportsRawMode() && !mediaCollector.isRawModeReadyToUse(true)) {
                    return;
                }
                EntryInfo entryInfo = this.mFileEntry.toEntryInfo();
                entryInfo.trackNo = this.mIndex + 1;
                mediaPlayerState.predictPlaybackEntry(entryInfo, this.mBrowser.getBrowseFolder(), l);
            }
        }
        if (!(this.mPlayer.getActiveMedia() == this.mBrowser.getBrowseMedia() && this.mFileEntryActive || this.mDefaultPlaymode == null || this.mDefaultSelection == null)) {
            mediaPlayerState.predictPlaybackMode(this.mDefaultPlaymode, l);
        }
    }

    @Override
    public void onExit() {
        if (!this.isCompleted()) {
            this.mPlayer.pauseIfNotOnTop();
        }
        long l = this.getSequenceNumber();
        MediaPlayerState mediaPlayerState = this.mPlayer.getPlayerState();
        mediaPlayerState.clearPlaybackMedia(l);
        mediaPlayerState.clearPlaybackEntry(l);
        mediaPlayerState.clearPlaybackMode(l);
        mediaPlayerState.clearPlaybackState(l);
        mediaPlayerState.clearPlaySelection(l);
        mediaPlayerState.clearActivationState(l);
    }

    @Override
    protected String getStepStr(int n) {
        switch (n) {
            case 0: {
                return "OBTAIN_LIST_ENTRY";
            }
            case 1: {
                return "VALIDATE";
            }
            case 2: {
                return "PAUSE_OR_PLAY_IF_ACTIVE";
            }
            case 3: {
                return "PREPARE";
            }
            case 4: {
                return "ACTIVATE_SOURCE";
            }
            case 5: {
                return "PEPARE_SELECTION";
            }
            case 6: {
                return "DO_SELECTION";
            }
            case 7: {
                return "SET_PLAYBACKMODE";
            }
            case 8: {
                return "SET_PLAYSELECTION";
            }
            case 9: {
                return "RESUME";
            }
        }
        return null;
    }

    @Override
    protected String getParameterStr() {
        String string = new StringBuffer().append("instanceId: ").append(MediaBrowserHelper.getInstanceIdStr(this.mBrowser)).toString();
        string = this.mEntryId == 0L && this.mContentType == 0 ? new StringBuffer().append(string).append(", index: ").append(this.mIndex).toString() : new StringBuffer().append(string).append(", entryId: ").append(this.mEntryId).append(", contentType: ").append(MediaBrowserHelper.getContentTypeStr(this.mContentType)).toString();
        string = new StringBuffer().append(string).append(", playBackToggle: ").append(this.mTogglePlayback).toString();
        return string;
    }

    public boolean hasPlaybackFailed() {
        return this.mPlaybackFailed;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile == null ? (class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile = CmdPlayFile.class$("de.vw.mib.asl.internal.media.controller.commands.playback.CmdPlayFile")) : class$de$vw$mib$asl$internal$media$controller$commands$playback$CmdPlayFile).desiredAssertionStatus();
        autoskipEvent = null;
        TIMEOUT = 20000;
    }
}

