/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.clients.player.CapabilityProperties;
import de.vw.mib.asl.internal.media.common.MediaConstants;
import de.vw.mib.asl.internal.media.common.MediaTimer;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.persistence.MediaPersistence;
import de.vw.mib.asl.internal.media.playback.AbstractPlayerTarget;
import de.vw.mib.asl.internal.media.playback.CurrentAudioSourceState;
import de.vw.mib.asl.internal.media.playback.DefaultSelectionFactory;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.MediaPlayer$1;
import de.vw.mib.asl.internal.media.playback.MediaPlayer$2;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.playback.PlayTime;
import de.vw.mib.asl.internal.media.playback.Seeker;
import de.vw.mib.asl.internal.media.playback.Skipper;
import de.vw.mib.asl.internal.media.playback.VideoFormat;
import de.vw.mib.asl.internal.media.playback.dsistate.UpdateActiveMedia;
import de.vw.mib.asl.internal.media.sound.MediaAudioManager;
import de.vw.mib.asl.internal.media.sourcehandling.controller.SourceIconController;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.PlaybackMode;

public abstract class MediaPlayer
extends AbstractPlayerTarget {
    private final MediaPlayerState mPlayerState;
    final MediaPersistence persistence;
    private static final int RT_MEDIA_ACTIVATION = MediaPlayer.assignRequestId();
    private MediaCollector mRequestedMedia = null;
    private MediaCollector mActiveMedia = null;
    private static final int RT_SET_PLAY_SELECTION = MediaPlayer.assignRequestId();
    private Selection mRequestedSelection = null;
    private boolean mRequestedSelectionAnswerReceived = false;
    private Selection mActivePlaySelection = null;
    private boolean mLastSelectionSeamless;
    protected Capabilities mCapabilities;
    private static final int RT_SET_PLAYBACK_MODE = MediaPlayer.assignRequestId();
    private MediaPlaybackModes mPlaybackModes = null;
    private PlayMode mRequestedPlaybackMode = null;
    private PlayMode mActivePlaymode = PlayMode.UNKNOWN;
    private static final int RT_TRACK_TO_TIME = MediaPlayer.assignRequestId();
    private long mRequestedSetTrackToTimeEntryId = -1L;
    private int mRequestedSetTrackToTimeTimePos = -1;
    private int mSetTrackToTimeTimePosCount = 0;
    private long mActiveTrackId = 0L;
    private int mActiveTrackTimePos = 0;
    private int mActiveTrackTotalPlaytime = 0;
    private EntryInfo mActiveTrackDetails = null;
    private static final int RT_SEEK = MediaPlayer.assignRequestId();
    private static final int RT_SET_ENTRY = MediaPlayer.assignRequestId();
    private static final int RT_WAIT_FOR_PLAYING = MediaPlayer.assignRequestId();
    private static final int RT_WAIT_FOR_STATE = MediaPlayer.assignRequestId();
    private long mRequestedEntryID = -1L;
    private long mRequestedEntryIDFailedCount = 0L;
    private ListEntry[] mActivePlaybackFolderRaw = null;
    private int mPlaybackState = 0;
    protected boolean playing = false;
    private boolean tryPlayDefaultAfterStop = true;
    private long mRepeatFileID = -1L;
    private boolean mDetailInfoTimerAlreadyStarted;
    private final UpdateActiveMedia mUpdateActiveMedia = new UpdateActiveMedia();
    private final Skipper mSkipper = new Skipper(this);
    private static final int ABORT_SET_ENTRY_COUNT = 5 * (IMediaConstants.ESO ? 3 : 1);
    private final Seeker mSeeker = new Seeker(this);
    private boolean mSeekStateReached = false;
    private ListEntry[] mActivePlaybackFolderContent = null;
    private boolean continueAfterRipnplay;
    private static final int SEEK_FAILED_TIMEOUT;
    private final MediaTimer mSeekFailedTimer = new MediaTimer(new MediaPlayer$1(this), 2000, "seek_failed");
    private boolean mSeekCanceled = false;
    private static final int RT_PAUSE;
    private static final int RT_RESUME;
    private static final int RT_VIDEO_FORMAT;
    private final VideoFormat mVideoFormat = new VideoFormat(this, RT_VIDEO_FORMAT);
    protected static final int RT_PLAY_SIMILAR;
    private final MediaTimer mRequestDetailInfoTimer = new MediaTimer(new MediaPlayer$2(this), 3000, "requestDetailInfo emergency timeout");
    private int rqWaitForState;
    boolean mPlayViewValid = false;
    boolean mRequestedSelectionPlayViewInvalidated = false;

    public MediaPlayer(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.persistence = MediaObjectAccessor.getPersistence();
        this.mPlayerState = new MediaPlayerState();
        this.mPlayerState.updateActivationState(2);
    }

    @Override
    protected void powerOn() {
        this.reset(null);
    }

    protected abstract void reset() {
    }

    protected void reset(MediaCollector mediaCollector) {
        this.onDevicesUpdated();
        this.mUpdateActiveMedia.invalidate();
        this.mPlaybackState = 0;
        this.mCapabilities = null;
        this.reset();
        this.mVideoFormat.invalidate();
        this.continueAfterRipnplay = false;
        this.mPlayerState.reset();
        this.mPlayerState.updateCapabilities(CapabilityProperties.RESET_CAPABILITIES);
        this.mActiveMedia = null;
        this.mRequestedSetTrackToTimeTimePos = -1;
        this.mRequestedSetTrackToTimeEntryId = -1L;
        this.mActivePlaybackFolderRaw = null;
        this.setPlaybackModes(null);
        this.mRequestedPlaybackMode = null;
        this.setPlaying(false);
        this.tryPlayDefaultAfterStop = true;
        this.mRepeatFileID = -1L;
        this.mActiveTrackTimePos = 0;
        this.mActiveTrackTotalPlaytime = 0;
        this.mPlayerState.updatePlayTimeInfo(null);
        this.mActiveTrackId = 0L;
        if (mediaCollector != MediaCollector.EMPTY) {
            CurrentAudioSourceState.setLoading();
        }
        this.setActiveMedia(null);
        this.setPlaybackMode(PlayMode.UNKNOWN);
        this.setEntryInfo(null);
        this.setCoverArt(null);
        this.setActivePlaySelection(null);
        this.mDetailInfoTimerAlreadyStarted = false;
        this.stopTimer(-1534721792);
    }

    public MediaCollector getActiveOrRequestedMedia() {
        if (this.mActiveMedia != null) {
            return this.mActiveMedia;
        }
        if (this.mRequestedMedia != null) {
            return this.mRequestedMedia;
        }
        return MediaCollector.EMPTY;
    }

    public MediaCollector getActiveMedia() {
        return this.mActiveMedia;
    }

    public MediaCollector getASLActiveMedia() {
        if (!(this.mActiveMedia != null && this.mActiveMedia != MediaCollector.EMPTY || this.mPlayerState.isDeactivated() || this.mPlayerState.isDeactivating())) {
            DeviceCollector deviceCollector = SourceIconController.getInstance().getDeviceCollector();
            if (deviceCollector != null && deviceCollector.getMainPartition() != null) {
                return deviceCollector.getMainPartition();
            }
            this.warn("SourceIconController.getInstance().getDeviceCollector() == null in getASLActiveMedia() -> using EMPTY_MEDIA for browser sync");
            return MediaCollector.EMPTY;
        }
        return this.mActiveMedia;
    }

    private void setActiveMedia(MediaCollector mediaCollector) {
        this.mActiveMedia = mediaCollector;
        this.mPlayerState.setPlayerMedia(mediaCollector);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        if (mediaCollector != null && mediaCollector.isUSB()) {
            eventGeneric.setString(0, mediaCollector.getUniqueMediaID());
        } else {
            eventGeneric.setString(0, "");
        }
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-909759232, eventGeneric);
    }

    public void rqMediaActivation(MediaCollector mediaCollector, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_MEDIA_ACTIVATION, responseHandler)) {
            if (mediaCollector == null) {
                this.fireResponse(false, new StringBuffer().append("invalid media: ").append(mediaCollector).toString());
                return;
            }
            if (this.mActiveMedia == mediaCollector && (this.isPlaybackStateActivated(this.mPlaybackState) || this.mPlaybackState == 11) && CapabilityProperties.isDsiUpdated() && this.mUpdateActiveMedia.isActive(mediaCollector)) {
                this.fireResponse(this.isPlaybackStateActivated(this.mPlaybackState), new StringBuffer().append("media is already active: ").append(mediaCollector).toString());
                return;
            }
            if (this.mActiveMedia == mediaCollector && mediaCollector == MediaCollector.EMPTY) {
                this.triggerBrowserSync("EMPTY MEDIA already active");
                this.fireResponse(true, "EMPTY media (0,0) is already 'active'!");
                return;
            }
            this.valueChangedInteger(74, 0);
            this.mRequestedMedia = mediaCollector;
            if (!this.mUpdateActiveMedia.isActive(mediaCollector)) {
                this.reset(mediaCollector);
                this.getDSI().setActiveMedia(mediaCollector.getDeviceID(), mediaCollector.getMediaID(), 0);
            } else {
                this.setActiveMedia(mediaCollector);
                if (this.mPlaybackState == 2) {
                    return;
                }
                this.fireResponse(this.isPlaybackStateActivated(this.mPlaybackState) || mediaCollector == MediaCollector.EMPTY, new StringBuffer().append("media is already active: ").append(mediaCollector).toString());
            }
        }
    }

    public void dsiMediaPlayerUpdateActiveMedia(long l, long l2, int n, int n2, int n3) {
        this.mUpdateActiveMedia.updateActiveMedia(l, l2, n, n2, n3);
        if (n3 != 1) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setString(0, "");
            ServiceManager.eventMain.getServiceRegister().triggerObserver(-909759232, eventGeneric);
            return;
        }
        long l3 = -1L;
        if (this.mActiveMedia != null && this.mActiveMedia.isDVDChanger() && l2 == -1L) {
            MediaObjectAccessor.mMediaController.changeSlot();
            return;
        }
        if (this.mRequestedMedia == null && l == 0L && l2 == 0L) {
            return;
        }
        if (this.mRequestedMedia == null || this.mRequestedMedia.getDeviceID() != l || this.mRequestedMedia.getMediaID() != l2) {
            this.error().append("reported deviceID (").append(l).append(") or mediaID (").append(l2).append(new StringBuffer().append(") does not match request: ").append(this.mRequestedMedia).toString()).log();
            return;
        }
        this.setActiveMedia(this.mRequestedMedia);
        if (this.mRequestedMedia == MediaCollector.EMPTY) {
            this.fireResponse(l == this.mRequestedMedia.getDeviceID() && l2 == this.mRequestedMedia.getMediaID(), RT_MEDIA_ACTIVATION);
            this.triggerBrowserSync("activating EMPTY MEDIA");
            return;
        }
    }

    private void detectActivationCompleted(Capabilities capabilities) {
        if (this.isRegisteredForResponse(RT_MEDIA_ACTIVATION) && this.mActiveMedia == this.mRequestedMedia && (this.mCapabilities == null || !this.mCapabilities.isPause() || !this.mCapabilities.isResume() || this.isPlaybackStateActivated(this.mPlaybackState))) {
            boolean bl;
            boolean bl2 = bl = this.mActiveMedia != null && this.mActiveMedia.isMediaPlayable();
            if (bl && (!this.mCapabilities.isDetailInfos() || this.mActiveMedia.isBT())) {
                CurrentAudioSourceState.set(0);
                this.triggerBrowserSync("detectActivationCompleted  (capabilities)");
            }
            this.fireResponse(bl, capabilities == null ? "null" : capabilities.toString());
        }
    }

    private void detectActivationCompleted(int n) {
        if (this.isRegisteredForResponse(RT_MEDIA_ACTIVATION) && this.mActiveMedia == this.mRequestedMedia && (this.isPlaybackStateActivated(n) || n == 11)) {
            boolean bl;
            boolean bl2 = bl = this.mActiveMedia != null && this.mActiveMedia.isMediaPlayable() && this.isPlaybackStateActivated(n) && this.mCapabilities != null && (this.mActiveMedia.hasPlaymodeSupport() && this.mPlaybackModes != null || !this.mActiveMedia.hasPlaymodeSupport());
            if (bl && (!this.mCapabilities.isDetailInfos() || this.mActiveMedia.isBT())) {
                CurrentAudioSourceState.set(0);
                this.triggerBrowserSync("detectActivationCompleted  (playbackState)");
            }
            this.fireResponse(bl, new StringBuffer().append("playmodes= [PlaybackModeList-Mapping: ").append(this.mPlaybackModes).append("]").toString());
        }
    }

    private boolean isPlaybackStateActivated(int n) {
        return n == 1 || n == 3 || n == 5 || n == 10 || n == -124;
    }

    public Capabilities getCapabilities() {
        return this.mCapabilities;
    }

    private void setCapabilities(Capabilities capabilities) {
        this.mCapabilities = capabilities;
        this.mPlayerState.updateCapabilities(capabilities);
    }

    public void dsiMediaPlayerUpdateCapabilities(Capabilities capabilities, int n) {
        if (n != 1) {
            this.mPlayerState.updateCapabilities(CapabilityProperties.RESET_CAPABILITIES);
            return;
        }
        this.setCapabilities(capabilities);
        if (!CapabilityProperties.isPlaybackStateExpected()) {
            this.mPlaybackState = -124;
        }
        if (!this.mUpdateActiveMedia.isEmpty() && this.mActiveMedia != null) {
            this.mActiveMedia.setPlayerCapabilities(capabilities);
        }
        this.detectActivationCompleted(this.mCapabilities);
    }

    public void dsiMediaPlayerUpdatePlaybackModeList(PlaybackMode[] playbackModeArray, int n) {
        if (n != 1 || Util.isNullOrEmpty(playbackModeArray)) {
            this.setPlaybackModes(null);
            return;
        }
        this.setPlaybackModes(new MediaPlaybackModes(playbackModeArray, this.mPlayerState, this.getActiveOrRequestedMedia().storesOwnPlaybackState()));
    }

    private void setPlaybackModes(MediaPlaybackModes mediaPlaybackModes) {
        this.mPlaybackModes = mediaPlaybackModes;
        this.mPlayerState.setPlaybackModesList(mediaPlaybackModes);
    }

    public void rqRestorePlaybackMode(ResponseHandler responseHandler) {
        PlayMode playMode;
        if (this.mActiveMedia == null || this.mActiveMedia.isAUX()) {
            if (this.registerForResponse(RT_SET_PLAY_SELECTION, responseHandler)) {
                this.fireResponse(true, new StringBuffer().append("short-cut rqRestorePlaybackMode because activeMedia is ").append(this.mActiveMedia).toString());
            }
            return;
        }
        if (!this.mActiveMedia.hasPlaymodeSupport()) {
            if (this.registerForResponse(RT_SET_PLAY_SELECTION, responseHandler)) {
                this.fireResponse(true, "short-cut rqRestorePlaybackMode because activeMedia has no playmode support.");
            }
            return;
        }
        Selection selection = this.persistence.getPlaySelection(this.mPlaybackModes, this.mActiveMedia);
        this.info().append("rqRestorePlaybackMode: lastPlaySelectionValid=").append(this.mActiveMedia.isLastPlaySelectionValid()).log();
        if (this.mActiveMedia.isLastPlaySelectionValid() && selection != null) {
            playMode = selection.getPlaymode();
        } else {
            playMode = this.mPlaybackModes.getPlayModeDefault();
            selection = this.getDefaultSelectionFactory().createDefaultPlaySelection(playMode, this.mActiveMedia, false);
        }
        this.rqSetPlaybackMode(playMode, selection, responseHandler);
    }

    public void rqRestoreDefaultPlaybackMode(ResponseHandler responseHandler) {
        if (this.mActiveMedia == null || this.mActiveMedia.isAUX()) {
            if (this.registerForResponse(RT_SET_PLAY_SELECTION, responseHandler)) {
                this.fireResponse(true, new StringBuffer().append("short-cut rqRestoreDefaultPlaybackMode because activeMedia is ").append(this.mActiveMedia).toString());
            }
            return;
        }
        if (!this.mActiveMedia.hasPlaymodeSupport()) {
            if (this.registerForResponse(RT_SET_PLAY_SELECTION, responseHandler)) {
                this.fireResponse(true, "short-cut rqRestoreDefaultPlaybackMode because activeMedia has no playmode support.");
            }
            return;
        }
        PlayMode playMode = this.mPlaybackModes.getPlayModeDefault();
        Selection selection = this.getDefaultSelectionFactory().createDefaultPlaySelection(playMode, this.mActiveMedia, false);
        this.rqSetPlaybackMode(playMode, selection, responseHandler);
    }

    public void rqSetDefaultPlaybackMode(Selection selection, ResponseHandler responseHandler) {
        this.rqSetPlaybackMode(this.mPlayerState.getPlaybackModeList().getPlayModeDefault(), selection, responseHandler);
    }

    public void rqSetPlaybackMode(PlayMode playMode, Selection selection, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_PLAYBACK_MODE, responseHandler)) {
            if (this.mPlaybackModes == null) {
                if (this.mPlayerState.getActiveMedia().hasPlaymodeSupport()) {
                    this.fireResponse(false, "no usable playback modes set!");
                } else {
                    this.fireResponse(true, "playback modes not supported");
                }
                return;
            }
            if (playMode == null) {
                this.fireResponse(false, "playmode == null!");
                return;
            }
            this.mRequestedSelection = selection;
            this.mRequestedPlaybackMode = playMode;
            if (playMode == PlayMode.DUMMY_EXTERNAL) {
                this.getDSI().setPlaybackMode(-1);
                return;
            }
            if (selection != null) {
                selection.setPlaymode(playMode);
                this.persistence.storePlaySelection(this.mActiveMedia.getObjectId(), this.mRequestedSelection);
            }
            int n = playMode.getModeId();
            int n2 = this.mActivePlaymode.getModeId();
            if (n == -1) {
                this.fireResponse(true, "no playback modes found play mode list, continuing anyway");
                this.error("No playback modes found play mode list!");
            } else if (n != n2 || this.mActivePlaymode == PlayMode.UNKNOWN) {
                this.getDSI().setPlaybackMode(n);
            } else {
                this.setPlaybackMode(playMode);
                if (selection != null) {
                    selection.setPlaymode(playMode);
                    this.persistence.storePlaySelection(this.mActiveMedia.getObjectId(), selection);
                }
                this.fireResponse(true, "old and new play back mode identical -> not sending");
            }
        }
    }

    public void dsiMediaPlayerUpdatePlaybackMode(int n, int n2) {
        if (n2 != 1 || this.mPlaybackState == 2) {
            this.mActivePlaymode = PlayMode.UNKNOWN;
            return;
        }
        if (this.mPlaybackModes == null) {
            this.error("MediaPlayer.dsiMediaPlayerUpdatePlaybackMode() sent but no play back mode list available!");
            return;
        }
        this.mRepeatFileID = this.mRepeatFileID == -1L && this.mActivePlaymode.isRepeatFile() && this.getActiveMedia().isIPod() ? this.mActiveTrackId : -1L;
        PlayMode playMode = this.mPlaybackModes.getPlayModeByDSIConstant(n, this.mRequestedSelection);
        if (this.isRegisteredForResponse(RT_SET_PLAYBACK_MODE) && !this.mActiveMedia.storesOwnPlaybackState()) {
            if (this.mRequestedSelection != null) {
                this.mRequestedSelection.setPlaymode(playMode);
                this.persistence.storePlaySelection(this.mActiveMedia.getObjectId(), this.mRequestedSelection);
            } else {
                this.warn("storePlaymode not executed because mRequestedSelection is null");
            }
        }
        this.setPlaybackMode(playMode);
        if (this.isRegisteredForResponse(RT_SET_PLAYBACK_MODE) && this.mRequestedPlaybackMode.getModeId() == n || this.mRequestedPlaybackMode == PlayMode.DUMMY_EXTERNAL) {
            this.fireResponse(true);
        }
    }

    public PlayMode getPlaybackMode() {
        return this.mActivePlaymode;
    }

    private void setPlaybackMode(PlayMode playMode) {
        this.mActivePlaymode = playMode;
        this.mPlayerState.setPlaybackMode(playMode);
    }

    public boolean isDefaultPlaymode() {
        PlayMode playMode = this.getPlaybackMode();
        Selection selection = this.getPlaySelection();
        MediaCollector mediaCollector = this.getActiveMedia();
        if (playMode != null) {
            if (playMode.usesSelections() && selection != null && mediaCollector != null && !mediaCollector.storesOwnPlaybackState()) {
                return (playMode.isPlayDefault() || playMode.isRepeatFolder()) && selection.isDefault();
            }
            return playMode.isPlayDefault();
        }
        return false;
    }

    public void rqSetPlaySelection(Selection selection, long l, boolean bl, boolean bl2, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_PLAY_SELECTION, responseHandler)) {
            if (selection == null || selection.getInstanceID() < 0) {
                this.fireResponse(false, new StringBuffer().append("selection is invalid: ").append(selection).toString());
                return;
            }
            this.mRequestedSelection = selection;
            this.mRequestedSelectionAnswerReceived = false;
            this.mRequestedSelectionPlayViewInvalidated = false;
            this.mRequestedEntryID = l;
            boolean bl3 = this.mPlaybackState == 1 || this.mPlaybackState == 4 || this.mPlaybackState == 11;
            this.mLastSelectionSeamless = !bl3 && !bl && selection.contains(this.getActiveMedia(), this.getActiveFolderPath());
            this.getDSI().setPlaySelection(selection.getInstanceID(), l, this.mLastSelectionSeamless);
            if (!bl2) {
                this.getDSI().pause();
            }
        }
    }

    public void dsiMediaPlayerResponseSetPlaySelection(int n, int n2) {
        if (this.isRegisteredForResponse(RT_SET_PLAY_SELECTION)) {
            if (n2 == 0) {
                this.setActivePlaySelection(this.mRequestedSelection);
                this.mRequestedSelectionAnswerReceived = true;
                this.persistence.storePlaySelection(this.mActiveMedia.getObjectId(), this.mRequestedSelection);
            }
            if (this.mLastSelectionSeamless) {
                this.fireResponse(n2 == 0, RT_SET_PLAY_SELECTION);
            }
        }
    }

    public Selection getPlaySelection() {
        return this.mActivePlaySelection;
    }

    private void setActivePlaySelection(Selection selection) {
        this.mActivePlaySelection = selection;
        this.mPlayerState.updatePlaySelection(selection);
    }

    public void rqSetTrackToTime(int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_TRACK_TO_TIME, responseHandler)) {
            long l = this.mActiveTrackId;
            if (l == 0L) {
                this.fireResponse(false, "no valid active track id available (track id is 0)");
                return;
            }
            if (n < 0 || n > this.mActiveTrackTotalPlaytime) {
                this.fireResponse(false, new StringBuffer().append("requested timePosition (").append(n).append(") outside of range: 0 ..").append(this.mActiveTrackTotalPlaytime).toString());
                return;
            }
            this.mRequestedSetTrackToTimeTimePos = n;
            this.mRequestedSetTrackToTimeEntryId = l;
            this.mSetTrackToTimeTimePosCount = 0;
            this.getDSI().setEntry(l, n);
        }
    }

    private void detectSetTrack2TimeCompletion(long l, int n) {
        if (this.isRegisteredForResponse(RT_TRACK_TO_TIME)) {
            boolean bl;
            boolean bl2 = this.mRequestedSetTrackToTimeEntryId == l;
            boolean bl3 = bl = Math.abs(this.mRequestedSetTrackToTimeTimePos / 1000 - n / 1000) < 2;
            if (!bl2 && !this.getActiveMedia().isDVDVideoAudio() || !bl && this.mSetTrackToTimeTimePosCount++ > 2) {
                this.mRequestedSetTrackToTimeEntryId = -1L;
                this.mRequestedSetTrackToTimeTimePos = -1;
                this.fireResponse(false, RT_TRACK_TO_TIME);
            }
            if ((bl2 || this.getActiveMedia().isDVDVideoAudio()) && bl) {
                this.mRequestedSetTrackToTimeEntryId = -1L;
                this.mRequestedSetTrackToTimeTimePos = -1;
                this.fireResponse(true, RT_TRACK_TO_TIME);
            }
        }
    }

    public void rqSkipTrack(int n, boolean bl, ResponseHandler responseHandler) {
        this.mSkipper.skipTrack(n, bl, responseHandler);
    }

    private void detectSkipCompletion(long l, int n) {
        this.mSkipper.detectSkipCompletion(l, n);
    }

    public void dsiMediaPlayerResponseDetailInfo(EntryInfo entryInfo) {
        Object object;
        this.mRequestDetailInfoTimer.stop();
        if (this.mActiveMedia == null) {
            return;
        }
        if (this.mActivePlaySelection == null) {
            object = null;
            if (this.mActiveMedia.isLastPlaySelectionValid() && MediaBrowserHelper.getBrowseMode((Selection)(object = this.persistence.getPlaySelection(this.mPlaybackModes, this.mActiveMedia))) == 1 && MediaBrowserHelper.isVideoFile(entryInfo)) {
                object = null;
            }
            if (object == null || !((Selection)object).isValid()) {
                object = this.getDefaultSelectionFactory().createDefaultPlaySelection(this.mActivePlaymode, this.mActiveMedia, entryInfo.contentType == 2);
                this.persistence.storePlaySelection(this.mActiveMedia.getObjectId(), (Selection)object);
            }
            this.setActivePlaySelection((Selection)object);
        }
        this.setEntryInfo(entryInfo);
        if (this.isRegisteredForResponse(RT_SET_ENTRY) && entryInfo.getEntryID() == this.mRequestedEntryID) {
            this.fireResponse(true);
        }
        this.detectSkipCompletion(entryInfo.getEntryID(), this.mActiveTrackTimePos);
        this.triggerBrowserSync("responseDetailInfo");
        object = this.mActiveMedia.getMediaCaps();
        if (object != null && (((MediaCapabilities)object).playerCoverArt || ((MediaCapabilities)object).coverArt)) {
            this.getDSI().requestCoverArt(entryInfo.entryID);
        }
        if (this.isRegisteredForResponse(RT_SET_PLAY_SELECTION) && this.mRequestedSelectionAnswerReceived) {
            this.fireResponse(this.mRequestedSelection.equalsTo(this.mActivePlaySelection));
        }
    }

    private void setEntryInfo(EntryInfo entryInfo) {
        this.mActiveTrackDetails = entryInfo;
        this.mPlayerState.updatePlaybackEntry(entryInfo, this.getActiveFolderPath());
    }

    public void dsiMediaPlayerResponseCoverArt(long l, ResourceLocator resourceLocator) {
        this.setCoverArt(resourceLocator);
    }

    private void setCoverArt(ResourceLocator resourceLocator) {
        long l = this.mActiveTrackDetails != null ? this.mActiveTrackDetails.albumID : -1L;
        this.mPlayerState.setCoverArt(resourceLocator, l);
    }

    public void dsiMediaPlayerUpdatePlayPosition(long l, int n, int n2, int n3) {
        boolean bl;
        if (this.mActiveMedia == null) {
            return;
        }
        if (n3 != 1 || n2 <= 0 && this.mCapabilities != null && this.mCapabilities.isTotalPlaytime()) {
            this.mActiveTrackId = 0L;
            this.mActiveTrackTimePos = 0;
            this.mActiveTrackTotalPlaytime = 0;
            this.mRequestedEntryIDFailedCount = 0L;
            if (n3 == 1 && (this.isRegisteredForResponse(RT_SET_ENTRY) || this.isRegisteredForResponse(RT_SET_PLAY_SELECTION) && this.mRequestedSelectionAnswerReceived) && l == this.mRequestedEntryID && n2 == 0) {
                this.fireResponse(true, "selected track is not playable!");
            }
            return;
        }
        boolean bl2 = bl = (l != this.mActiveTrackId || n == 0) && this.mPlaybackState != 4 && this.mPlaybackState != 11;
        if (bl && this.isRegisteredForResponse(RT_SET_PLAY_SELECTION) && !this.mRequestedSelectionAnswerReceived) {
            bl = false;
            this.warn("skip newTrackDetection because setPlaySelection ongoing");
        }
        this.mActiveTrackTimePos = n;
        this.mActiveTrackTotalPlaytime = n2;
        PlayMode playMode = this.getPlayerState().getPlaybackMode();
        boolean bl3 = this.getActiveMedia().isIPod() && playMode.isMix();
        boolean bl4 = this.getActiveMedia().isBT();
        if (this.mRequestedEntryID != 0L && !bl3 && !bl4 && (this.isRegisteredForResponse(RT_SET_ENTRY) || this.isRegisteredForResponse(RT_SET_PLAY_SELECTION) && this.mRequestedSelectionAnswerReceived) && l != this.mRequestedEntryID && !this.mLastSelectionSeamless) {
            if (this.mRequestedEntryIDFailedCount >= (long)ABORT_SET_ENTRY_COUNT) {
                this.mRequestedEntryIDFailedCount = 0L;
                this.fireResponse(false, new StringBuffer().append("aborted after ").append(ABORT_SET_ENTRY_COUNT).append(" unexpected updatePlayPositions().").toString());
            } else {
                ++this.mRequestedEntryIDFailedCount;
            }
        } else if (bl) {
            this.mRequestedEntryIDFailedCount = 0L;
            this.updateNewTrack(l);
        }
        if (this.mRequestedSelectionAnswerReceived && this.mRequestedSelectionPlayViewInvalidated && !bl) {
            this.fireResponse(true, "selectionAnswer received & playView invalidated & no newTrack detected ");
            this.mRequestedSelectionAnswerReceived = false;
            this.mRequestedSelectionPlayViewInvalidated = false;
        }
        this.detectSetTrack2TimeCompletion(l, n);
        this.detectSkipCompletion(l, n);
        if (!this.isRegisteredForResponse(RT_TRACK_TO_TIME)) {
            PlayTime playTime = this.getPlayerState().getPlayTime();
            this.mPlayerState.updatePlayTimeInfo(new PlayTime(n2, n, playTime));
        }
    }

    public void updateNewTrack(long l) {
        this.mActiveTrackId = l;
        if (l != this.mRequestedEntryID) {
            this.fireResponse(false, RT_SET_ENTRY);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(48, this.mCapabilities != null && this.mCapabilities.isTotalPlaytime() && this.mCapabilities.isPlayTime() && this.mActiveTrackTotalPlaytime > 1);
        if (l != 0L && this.mRepeatFileID != -1L && this.mActiveTrackId != 0L && this.mActivePlaymode.isRepeatFile() && this.mRepeatFileID != this.mActiveTrackId) {
            this.mRepeatFileID = -1L;
        }
        this.requestCoverArt(l);
    }

    private void requestCoverArt(long l) {
        if (this.mCapabilities != null && this.mCapabilities.detailInfos) {
            this.getDSI().requestDetailInfo(l);
            if (!this.mDetailInfoTimerAlreadyStarted) {
                this.mDetailInfoTimerAlreadyStarted = true;
                this.mRequestDetailInfoTimer.start();
            }
        }
    }

    public int getTotalTime() {
        return this.mActiveTrackTotalPlaytime;
    }

    public long getActiveTrackId() {
        return this.mActiveTrackId;
    }

    @Override
    protected void handleEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 100004: {
                if (!MediaObjectAccessor.getAudioManager().isMediaOnTop()) break;
                MediaObjectAccessor.getAudioManager().requestMute(true, "externalPause");
                break;
            }
            case 1073744072: {
                ServiceManager.aslPropertyManager.valueChangedInteger(13, this.mActiveTrackTimePos + 1);
                ServiceManager.aslPropertyManager.valueChangedInteger(13, this.mActiveTrackTimePos);
                break;
            }
            case 100005: {
                this.mActiveMedia = null;
                this.mRequestedMedia = null;
                this.fireResponse(false, "Cancel requested");
                break;
            }
        }
    }

    public void setSeekCanceled(boolean bl) {
        this.mSeekCanceled = bl;
    }

    public boolean isSeekCanceled() {
        return this.mSeekCanceled;
    }

    public void rqSeek(int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SEEK, responseHandler)) {
            if (this.isSeekCanceled()) {
                this.setSeekCanceled(false);
                this.fireResponse(true, "aborted by user (before SEEK was executed)");
                return;
            }
            this.mSeekStateReached = false;
            this.mSeekFailedTimer.start();
            this.mSeeker.startSeek(n);
        }
    }

    public void abortSeek() {
        if (this.isRegisteredForResponse(RT_SEEK)) {
            this.mSeeker.abortSeek();
            if (this.isSeeking()) {
                this.fireResponse(true, "aborted by user");
            }
        } else {
            this.setSeekCanceled(true);
        }
    }

    private void detectSeekCompleted(int n) {
        if (this.isRegisteredForResponse(RT_SEEK)) {
            if (this.mSeekStateReached && this.isSeeking() && this.mSeeker.isSeekAborted()) {
                this.fireResponse(true, "aborted by user (after SEEK state reached)");
                return;
            }
            if (this.mSeekStateReached && !this.isSeeking()) {
                this.fireResponse(true, "aborted by playback state change");
                if (!this.mSeeker.isSeekAborted()) {
                    this.mSeeker.abortSeek();
                }
            }
        }
    }

    public boolean isSeeking() {
        return this.mPlaybackState == 8 || this.mPlaybackState == 9;
    }

    public void dsiMediaPlayerUpdatePlaybackContentFolder(ListEntry[] listEntryArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("new play back content folder: ").append(MediaBrowserHelper.getPathString(listEntryArray)).log();
        }
        this.mActivePlaybackFolderContent = listEntryArray;
    }

    public void dsiMediaPlayerUpdatePlaybackFolder(ListEntry[] listEntryArray, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("new play back folder: ").append(MediaBrowserHelper.getPathString(listEntryArray)).log();
        }
        String string = "";
        if (listEntryArray != null && listEntryArray.length > 1) {
            string = listEntryArray[listEntryArray.length - 1].getFilename();
        }
        ServiceManager.aslPropertyManager.valueChangedString(2849, string);
        if (n != 1) {
            return;
        }
        this.mActivePlaybackFolderRaw = listEntryArray;
    }

    public ListEntry[] getActiveFolderPath() {
        Object[] objectArray = null;
        switch (MediaBrowserHelper.getBrowseMode(this.mActivePlaySelection)) {
            case 0: {
                objectArray = this.mActivePlaybackFolderRaw;
                break;
            }
            case 1: {
                if (this.mActivePlaybackFolderContent != null) {
                    objectArray = this.mActivePlaybackFolderContent;
                    break;
                }
                objectArray = this.generateDBLPath(this.mActivePlaySelection.getSelectionPath(), this.mActiveTrackDetails);
                break;
            }
            default: {
                objectArray = null;
            }
        }
        if (Util.isNullOrEmpty(objectArray) && this.mActivePlaySelection != null) {
            objectArray = this.mActivePlaySelection.getSelectionPath();
        }
        return objectArray;
    }

    public ListEntry getActiveTrack() {
        if (this.mActiveTrackDetails == null) {
            return null;
        }
        return new ListEntry(this.mActiveTrackDetails.entryID, this.mActiveTrackDetails.filename, this.mActiveTrackDetails.title, this.mActiveTrackDetails.contentType, 0, 0, null);
    }

    public ListEntry getActiveAlbum() {
        ListEntry listEntry = null;
        if (this.mActiveTrackDetails != null && this.mActiveTrackDetails.contentType != 2) {
            listEntry = new ListEntry(this.mActiveTrackDetails.albumID, this.mActiveTrackDetails.album, this.mActiveTrackDetails.album, 14, 0, 0, null);
        }
        return listEntry;
    }

    private ListEntry[] generateDBLPath(ListEntry[] listEntryArray, EntryInfo entryInfo) {
        ListEntry[] listEntryArray2 = null;
        if (listEntryArray != null && listEntryArray.length > 1 && entryInfo != null) {
            switch (listEntryArray[1].getContentType()) {
                case 16: {
                    listEntryArray2 = new ListEntry[]{listEntryArray[0], listEntryArray[1], this.getGenreEntry(entryInfo), this.getArtistEntry(entryInfo), this.getAlbumEntry(entryInfo)};
                    break;
                }
                case 13: {
                    listEntryArray2 = new ListEntry[]{listEntryArray[0], listEntryArray[1], this.getArtistEntry(entryInfo), this.getAlbumEntry(entryInfo)};
                    break;
                }
                case 14: {
                    listEntryArray2 = new ListEntry[]{listEntryArray[0], listEntryArray[1], this.getAlbumEntry(entryInfo)};
                    break;
                }
                case 6: 
                case 8: 
                case 15: {
                    listEntryArray2 = listEntryArray;
                    break;
                }
            }
        }
        return listEntryArray2;
    }

    private ListEntry getGenreEntry(EntryInfo entryInfo) {
        ListEntry listEntry = new ListEntry(entryInfo.genreID, entryInfo.genre, entryInfo.genre, 16, 0, 0, null);
        return listEntry;
    }

    private ListEntry getArtistEntry(EntryInfo entryInfo) {
        ListEntry listEntry = new ListEntry(entryInfo.artistID, entryInfo.artist, entryInfo.artist, 13, 0, 0, null);
        return listEntry;
    }

    private ListEntry getAlbumEntry(EntryInfo entryInfo) {
        ListEntry listEntry = new ListEntry(entryInfo.albumID, entryInfo.album, entryInfo.album, 14, 0, 0, null);
        return listEntry;
    }

    public void rqResume(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_RESUME, responseHandler)) {
            if (this.isPlaying()) {
                this.fireResponse(true, "resume already active");
            }
            this.resume(false);
        }
    }

    public void resume() {
        this.resume(false);
    }

    public void pauseIfNotOnTop() {
        this.resume(true);
    }

    private void resume(boolean bl) {
        MediaAudioManager mediaAudioManager = MediaObjectAccessor.getAudioManager();
        if (mediaAudioManager.isMediaOnTop()) {
            if (this.isPaused() && !bl || this.isSeeking()) {
                this.getDSI().resume();
            }
            this.setPlaying(true);
        } else {
            if (mediaAudioManager.isMuteActive()) {
                if (this.isTraceEnabled()) {
                    this.trace().append("Resume: mute is active, we expect to get audible, so do not send pause()!").log();
                }
                this.setPlaying(bl);
            } else if (this.isPlaying() || bl) {
                if (this.isTraceEnabled()) {
                    this.trace().append("Resume: call pause!").log();
                }
                this.pause(true);
            } else {
                this.setPlaying(bl);
            }
            if (this.isTraceEnabled()) {
                this.trace().append("Resume: demute!").log();
            }
            if (MediaObjectAccessor.getAudioManager().isAudioConnectionAvailable()) {
                mediaAudioManager.requestMute(false, "resume");
            }
        }
    }

    public void rqPause(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_PAUSE, responseHandler)) {
            this.pause(true);
        }
    }

    public void pause(boolean bl) {
        if (bl || !this.isPaused()) {
            this.getDSI().pause();
            this.setPlaying(false);
        }
    }

    public boolean isPlaying() {
        return this.playing;
    }

    protected void setPlaying(boolean bl) {
        ServiceManager.logger.trace(1024, new StringBuffer().append("playing = ").append(bl).toString());
        this.playing = bl;
    }

    public boolean isPaused() {
        return !this.isPlaying();
    }

    private void handleExternalNonPlayingPlaybackState(String string) {
        if (this.mPlayerState.isInitialized()) {
            this.retriggerOrStartTimer(-1534721792, (long)0, false);
            this.setPlaying(false);
        }
    }

    public void ripNPlay() {
        this.continueAfterRipnplay = true;
    }

    public int getDSIPlaybackState() {
        return this.mPlaybackState;
    }

    public void dsiMediaPlayerUpdatePlaybackState(int n, int n2) {
        this.stopTimer(-1534721792);
        if (n2 != 1) {
            return;
        }
        if (n == 9 || n == 8) {
            this.mSeekStateReached = true;
        }
        this.detectActivationCompleted(n);
        int n3 = 0;
        MediaAudioManager mediaAudioManager = MediaObjectAccessor.getAudioManager();
        if (this.mPlaybackState != n) {
            this.mPlaybackState = n;
            switch (n) {
                case 2: {
                    this.setPlaying(false);
                    break;
                }
                case 1: {
                    CurrentAudioSourceState.set(0);
                    if (this.continueAfterRipnplay) {
                        this.continueAfterRipnplay = false;
                        this.getDSI().resume();
                    }
                    this.setPlaying(false);
                    break;
                }
                case 3: {
                    if (!(this.isRegisteredForResponse(RT_SEEK) || this.isRegisteredForResponse(RT_SET_PLAY_SELECTION) || this.isRegisteredForResponse(RT_SET_ENTRY) || this.isRegisteredForResponse(RT_RESUME))) {
                        mediaAudioManager.requestMute(false, "updatePlaybackState(playing)");
                    }
                    n3 = 1;
                    this.setPlaying(true);
                    CurrentAudioSourceState.set(0);
                    break;
                }
                case 5: {
                    n3 = 2;
                    if (!(this.isRegisteredForResponse(RT_SEEK) || this.isRegisteredForResponse(RT_SET_PLAY_SELECTION) || this.isRegisteredForResponse(RT_SET_ENTRY) || this.isRegisteredForResponse(RT_PAUSE) || this.isRegisteredForResponse(RT_PLAY_SIMILAR) || !mediaAudioManager.isMediaOnTop() || this.mUpdateActiveMedia.isEmpty() || !mediaAudioManager.isAudioConnectionAvailable())) {
                        this.handleExternalNonPlayingPlaybackState("PLAYBACKSTATE_PAUSED");
                    }
                    this.setPlaying(false);
                    break;
                }
                case 11: {
                    if (this.tryPlayDefaultAfterStop && this.mActiveMedia != null && !this.mActiveMedia.isDVDVideoAudio() && this.mActiveMedia.isMediaPlayable()) {
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(432);
                        this.warn().append("PLAYBACKSTATE_STOPPED_WITH_ERROR -> trying play_default once").log();
                        this.triggerIt(279909120, -1467612928);
                        this.tryPlayDefaultAfterStop = false;
                    } else {
                        n3 = 5;
                        this.handleExternalNonPlayingPlaybackState("PLAYBACKSTATE_STOPPED_WITH_ERROR");
                    }
                    if (this.isRegisteredForResponse(RT_SET_ENTRY)) {
                        this.fireResponse(false, RT_SET_ENTRY, "PLAYBACKSTATE_STOPPED_WITH_ERROR");
                    }
                    if (this.isRegisteredForResponse(RT_SET_PLAY_SELECTION)) {
                        this.fireResponse(false, RT_SET_PLAY_SELECTION, "PLAYBACKSTATE_STOPPED_WITH_ERROR");
                    }
                    if (this.isRegisteredForResponse(RT_PLAY_SIMILAR)) {
                        this.fireResponse(false, RT_PLAY_SIMILAR, "PLAYBACKSTATE_STOPPED_WITH_ERROR");
                    }
                    if (this.isRegisteredForResponse(RT_SET_PLAYBACK_MODE)) {
                        this.fireResponse(false, RT_SET_PLAYBACK_MODE, "PLAYBACKSTATE_STOPPED_WITH_ERROR");
                    }
                    if (!this.isRegisteredForResponse(RT_RESUME)) break;
                    this.fireResponse(false, RT_RESUME, "PLAYBACKSTATE_STOPPED_WITH_ERROR");
                    break;
                }
                case 4: {
                    n3 = 2;
                    this.handleExternalNonPlayingPlaybackState("PLAYBACKSTATE_STOPPED");
                    this.setPlaying(false);
                    break;
                }
                case 9: {
                    n3 = 7;
                    this.setPlaying(false);
                    break;
                }
                case 8: {
                    n3 = 6;
                    this.setPlaying(false);
                    break;
                }
                case 10: {
                    n3 = 0;
                    break;
                }
                case 12: {
                    n3 = 0;
                    break;
                }
                default: {
                    n3 = 0;
                }
            }
            this.detectSeekCompleted(n);
            this.checkWaitForState();
        }
        if (n3 != 0) {
            this.mPlayerState.updatePlaybackState(n3);
        }
        if (n == 5 && this.isRegisteredForResponse(RT_PAUSE)) {
            this.fireResponse(true, RT_PAUSE);
        }
        if (n == 3) {
            if (this.isRegisteredForResponse(RT_WAIT_FOR_PLAYING)) {
                this.fireResponse(true, RT_WAIT_FOR_PLAYING);
            }
            if (this.isRegisteredForResponse(RT_RESUME)) {
                this.fireResponse(true, RT_RESUME);
            }
        }
        if (n == 4 && this.mActiveMedia != null && this.mActiveMedia.isBT()) {
            if (this.isRegisteredForResponse(RT_RESUME)) {
                this.fireResponse(true, RT_RESUME, "STOPPED received for BT when activating -> report success to enable media main screen");
            }
            if (this.isRegisteredForResponse(RT_PAUSE)) {
                this.fireResponse(true, RT_PAUSE, "STOPPED received for BT when activating -> report success to enable media main screen");
            }
        }
    }

    public void rqSetEntry(long l, boolean bl, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_ENTRY, responseHandler)) {
            if (l == this.mActiveTrackId) {
                this.fireResponse(true);
            } else {
                this.mRequestedEntryID = l;
            }
            this.getDSI().setEntry(l, -1);
            if (!bl) {
                this.getDSI().pause();
            }
        }
    }

    public void resetToFactorySettings() {
        this.persistence.clear();
    }

    @Override
    public void onDevicesUpdated() {
        if (this.mActiveMedia != null) {
            Medium medium = this.mActiveMedia.getMedium();
            if (medium.isJustRemoved()) {
                this.mUpdateActiveMedia.invalidate();
            }
            if (medium.isJustFullyRemoved()) {
                this.mPlayerState.updatePlaybackState(2);
            }
        }
        if (this.mRequestedMedia != null && this.mRequestedMedia.getMedium().isJustRemoved()) {
            this.mUpdateActiveMedia.invalidate();
            this.fireResponse(false, RT_MEDIA_ACTIVATION, "requested medium just removed");
            this.fireResponse(false, RT_RESUME, "requested medium just removed");
        }
        if (this.mActiveTrackId != 0L && this.mCapabilities != null && this.mCapabilities.detailInfos && this.mActiveMedia != null && this.mActiveMedia.getMedium().isFlagChanged(512) && !this.mRequestedMedia.getMedium().isJustRemoved()) {
            ServiceManager.logger.info(1024, "re-requestDetailInfo due to MEDIAFLAG_PASS_METADATA_COMPLETED (un)set");
            this.getDSI().requestDetailInfo(this.mActiveTrackId);
        }
    }

    public boolean isActive() {
        return this.mActiveMedia != null;
    }

    public void dsiMediaPlayerAsyncException(int n, String string, int n2) {
        this.error().append("MediaPlayer.dsiMediaPlayerAsyncException( errorCode=").append(n).append(", errorMsg=").append(string).append(", requestType=").append(n2).append(" )").log();
        switch (n2) {
            case 1019: {
                this.setEntryInfo(null);
                this.detectSkipCompletion(-1L, this.mActiveTrackTimePos);
                this.triggerBrowserSync("requestDetailInfo asnync");
                break;
            }
            case 1003: {
                this.setCoverArt(null);
                break;
            }
            case 1021: {
                this.fireResponse(false, RT_SET_PLAY_SELECTION);
                break;
            }
            case 1005: {
                if (!this.isRegisteredForResponse(RT_TRACK_TO_TIME)) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(517);
                break;
            }
            case 1012: {
                this.mRequestedMedia = null;
                this.fireResponse(false, RT_MEDIA_ACTIVATION);
                break;
            }
            case 1008: {
                this.fireResponse(false, RT_PAUSE, new StringBuffer().append("asyncException: ").append(string).toString());
                break;
            }
            case 1007: {
                this.fireResponse(false, RT_RESUME, new StringBuffer().append("asyncException: ").append(string).toString());
                break;
            }
            case 1000: {
                this.warn().append("asyncException: ").append(string).append(", but handled gracefully as it is usually not essential but may break source activation.").log();
                this.fireResponse(true, RT_SET_PLAYBACK_MODE, new StringBuffer().append("asyncException: ").append(string).toString());
                break;
            }
        }
    }

    public int getTimePos() {
        return this.mActiveTrackTimePos;
    }

    public EntryInfo getActiveTrackDetails() {
        return this.mActiveTrackDetails;
    }

    public boolean isWaitForSkipSensible(boolean bl) {
        boolean bl2 = this.mActiveTrackDetails != null && (!Util.isNullOrEmpty(this.mActiveTrackDetails.getTitle()) || !Util.isNullOrEmpty(this.mActiveTrackDetails.getFilename()) || !Util.isNullOrEmpty(MediaConstants.deleteI18nTags(this.mActiveTrackDetails.getAlbum())) || !Util.isNullOrEmpty(MediaConstants.deleteI18nTags(this.mActiveTrackDetails.getArtist())));
        boolean bl3 = this.mCapabilities != null && this.mCapabilities.detailInfos && (this.mActiveMedia == null || !this.mActiveMedia.isBT() || bl2 && (!this.mActiveMedia.isBT() || !bl));
        return this.getActiveMedia().getMediaCaps().isRawBrowser() && (this.mActiveTrackTotalPlaytime > 1 || bl3);
    }

    public MediaPlayerState getPlayerState() {
        return this.mPlayerState;
    }

    public void rqRestoreVideoFormat(ResponseHandler responseHandler) {
        this.rqVideoFormat(this.persistence.getVideoFormat(), responseHandler);
    }

    public void rqVideoFormat(int n, ResponseHandler responseHandler) {
        this.mVideoFormat.rqSetVideoFormat(n, responseHandler);
    }

    public void dsiMediaPlayerUpdateVideoFormat(int n, int n2) {
        if (n2 != 1) {
            this.mVideoFormat.invalidate();
            return;
        }
        int n3 = this.mVideoFormat.dsiVideoFormatChanged(n);
        this.persistence.setVideoFormat(n3);
    }

    public void restoreVideoSize() {
        this.setVideoSize(this.persistence.isVideoMaximized());
    }

    public void setVideoSize(boolean bl) {
        this.valueChangedBoolean(3353, bl);
        this.persistence.setVideoMaximized(bl);
    }

    public void restorePML() {
        this.getDsiMediaBase().setParentalML(this.persistence.getParentalManagementLevel());
    }

    public void rqPlaySimilar(Selection selection, boolean bl, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_PLAY_SIMILAR, responseHandler)) {
            this.mRequestedSelection = selection;
            this.getDSI().playSimilarEntry(this.mActiveTrackId, 100);
            if (!bl) {
                this.getDSI().pause();
            }
        }
    }

    public void dsiMediaPlayerResponsePlaySimilarEntry(long l, boolean bl) {
        if (this.isRegisteredForResponse(RT_PLAY_SIMILAR)) {
            if (bl) {
                this.setActivePlaySelection(this.mRequestedSelection);
            } else {
                MediaPlayer.writeIntegerToDatapool(559680512, 0);
                this.fireResponse(true, "no similar files found");
            }
        }
    }

    public void rqWaitForPlaying(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_WAIT_FOR_PLAYING, responseHandler)) {
            if (this.isPlaying()) {
                this.fireResponse(true, RT_WAIT_FOR_PLAYING, "already playing");
            } else {
                this.getDSI().resume();
            }
        }
    }

    public void rqWaitForState(int n, int n2, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_WAIT_FOR_STATE, n2, responseHandler)) {
            this.rqWaitForState = n;
            this.checkWaitForState();
        }
    }

    private void checkWaitForState() {
        if (this.isRegisteredForResponse(RT_WAIT_FOR_STATE) && this.rqWaitForState == this.mPlaybackState) {
            this.fireResponse(true, RT_WAIT_FOR_STATE, new StringBuffer().append(MediaBrowserHelper.getPlaybackStateStr(this.mPlaybackState)).append(" already set").toString());
        }
    }

    public void removePlaymodeLSM(MediaCollector mediaCollector) {
        this.persistence.removePlaySelection(mediaCollector.getObjectId());
    }

    private DefaultSelectionFactory getDefaultSelectionFactory() {
        return this.mPlayerState.getDefaultSelectionFactory();
    }

    public void updatePlaceHolderPaths(BrowserPathData browserPathData) {
        this.getDefaultSelectionFactory().updatePlaceholderPaths(browserPathData);
        if (this.mActiveTrackDetails != null) {
            if (this.mActivePlaySelection == null || !this.mActivePlaySelection.isValid() || this.mActivePlaySelection.getSelectionPath()[0].getEntryID() == -1L) {
                this.mActivePlaySelection = this.getDefaultSelectionFactory().createDefaultPlaySelection(this.mActivePlaymode, this.mActiveMedia, this.mActiveTrackDetails.contentType == 2);
                this.persistence.storePlaySelection(this.mActiveMedia.getObjectId(), this.mActivePlaySelection);
            }
            this.setEntryInfo(this.mActiveTrackDetails);
        }
    }

    public void resetPlayDefaultAfterStop() {
        this.tryPlayDefaultAfterStop = true;
    }

    @Override
    public int getComponentId() {
        return 2;
    }

    public void setPlayerState(int n) {
        this.mPlayerState.updateActivationState(n);
    }

    public void triggerBrowserSync(String string) {
        ServiceManager.logger.trace(1024, new StringBuffer().append("synchronizeBrowser: ").append(string).toString());
        this.triggerIt(279909120, -1484390144);
    }

    public void resetPlaySelectionForActiveMediaLocally() {
        this.setActivePlaySelection(null);
    }

    public void dsiMediaPlayerUpdatePlayViewSize(int n, int n2, int n3) {
        boolean bl;
        this.mPlayerState.setPlayViewSize(n, n3 == 1);
        boolean bl2 = bl = n3 == 1;
        if (this.mPlayViewValid != bl) {
            this.mPlayViewValid = bl;
            if (bl && this.isRegisteredForResponse(RT_SET_PLAY_SELECTION) && this.mRequestedSelectionAnswerReceived) {
                this.mRequestedSelectionPlayViewInvalidated = true;
            }
        }
        if (!bl) {
            return;
        }
        MediaCollector mediaCollector = this.getActiveMedia();
        if (Util.isBitSet(8, n2) && mediaCollector != null && mediaCollector.isMediaPlayable()) {
            this.sendHMIEvent(291245056);
        }
        if (Util.isBitSet(16, n2) && mediaCollector != null && mediaCollector.isMediaPlayable() && this.mActiveTrackId != 0L) {
            this.requestCoverArt(this.mActiveTrackId);
        }
        Selection selection = this.getPlaySelection();
        if (this.isRegisteredForResponse(RT_PLAY_SIMILAR) && selection.isPlaySimilarSelection() && mediaCollector != null) {
            MediaPlayer.writeIntegerToDatapool(559680512, n);
            this.persistence.storePlaySelection(mediaCollector.getObjectId(), selection);
            this.fireResponse(true);
        }
    }

    public MediaCollector getActiveSlot() {
        Object[] objectArray;
        if (this.mActiveMedia != null && this.mActiveMedia.isDVDChanger() && !Util.isNullOrEmpty(objectArray = this.mActiveMedia.getParentDevice().getPartitions())) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (((MediaCollector)objectArray[i2]).getMediaID() != this.mUpdateActiveMedia.getMediaID()) continue;
                return objectArray[i2];
            }
        }
        return null;
    }

    static /* synthetic */ int access$000() {
        return RT_SEEK;
    }

    static /* synthetic */ Seeker access$100(MediaPlayer mediaPlayer) {
        return mediaPlayer.mSeeker;
    }

    static {
        RT_PAUSE = MediaPlayer.assignRequestId();
        RT_RESUME = MediaPlayer.assignRequestId();
        RT_VIDEO_FORMAT = MediaPlayer.assignRequestId();
        RT_PLAY_SIMILAR = MediaPlayer.assignRequestId();
    }
}

