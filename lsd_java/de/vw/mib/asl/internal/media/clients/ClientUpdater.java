/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.BrowserStateListener;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.browser.bap.MediaBapBrowser;
import de.vw.mib.asl.internal.media.browser.bap.MediaHasBrowser;
import de.vw.mib.asl.internal.media.browser.coverflow.MediaCoverBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser;
import de.vw.mib.asl.internal.media.browser.headunit.MediaRecorderBrowser;
import de.vw.mib.asl.internal.media.browser.sds.MediaSpeechBrowser;
import de.vw.mib.asl.internal.media.clients.asi.ASIClient;
import de.vw.mib.asl.internal.media.clients.browser.SharedFolderPath;
import de.vw.mib.asl.internal.media.clients.browser.SharedListMapper;
import de.vw.mib.asl.internal.media.clients.browser.cover.CoverBrowserListHandler;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadUnitBrowserListHandler;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadUnitBrowsingTypeSwitching;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadunitBrowserActiveSource;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadunitBrowserListState;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadunitBrowserPlaymodeState;
import de.vw.mib.asl.internal.media.clients.browser.kombi.BapActiveTrackInfo;
import de.vw.mib.asl.internal.media.clients.browser.kombi.BapBrowsedFolder;
import de.vw.mib.asl.internal.media.clients.browser.kombi.KombiBrowserListHandler;
import de.vw.mib.asl.internal.media.clients.browser.kombi.KombiBrowserState;
import de.vw.mib.asl.internal.media.clients.browser.recorder.RecorderBrowserActiveSource;
import de.vw.mib.asl.internal.media.clients.browser.recorder.RecorderBrowserListHandler;
import de.vw.mib.asl.internal.media.clients.browser.recorder.RecorderBrowserSelectionState;
import de.vw.mib.asl.internal.media.clients.has.HASPlayerUpdater;
import de.vw.mib.asl.internal.media.clients.has.HasBrowserFolderPath;
import de.vw.mib.asl.internal.media.clients.has.HasBrowserListHandler;
import de.vw.mib.asl.internal.media.clients.has.HasBrowserListState;
import de.vw.mib.asl.internal.media.clients.player.CapabilityProperties;
import de.vw.mib.asl.internal.media.clients.player.PlaybackState;
import de.vw.mib.asl.internal.media.clients.player.TimeBar;
import de.vw.mib.asl.internal.media.clients.player.TrackInfo;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.playback.PlayTime;
import de.vw.mib.asl.internal.media.playback.PlayerStateListener;
import de.vw.mib.asl.internal.media.recorder.RecorderState;
import de.vw.mib.asl.internal.media.recorder.RecorderStateListener;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;

public class ClientUpdater
implements PlayerStateListener,
RecorderStateListener,
BrowserStateListener {
    private MediaPlayerState mPlayerState = null;
    private RecorderState mRecorderState = null;
    private MediaBrowserState mHeadunitBrowserState = null;
    private MediaBrowserState mRecorderBrowserState;
    private MediaBrowserState mKombiBrowserState = null;
    private MediaBrowserState mSpeechBrowserState = null;
    private MediaBrowserState mCoverBrowserState;
    private MediaBrowserState mHasBrowserState;
    public static final int STATE_CHANGE_REASON_PLAY_TIME_CHANGED;
    public static final int STATE_CHANGE_REASON_PLAY_BACK_ENTRY_CHANGED;
    public static final int STATE_CHANGE_REASON_PLAY_BACK_MODE_CHANGED;
    public static final int STATE_CHANGE_REASON_PLAY_BACK_STATE_CHANGED;
    private final SharedListMapper mSharedListMapper = new SharedListMapper();
    private final SharedFolderPath mSharedFolderPath = new SharedFolderPath();
    private final BapActiveTrackInfo mKombiBrowserActiveTrackInfo = new BapActiveTrackInfo();
    private final HeadUnitBrowserListHandler mHeadunitBrowserListHandler = new HeadUnitBrowserListHandler(this.mSharedListMapper, this.mSharedFolderPath);
    private final RecorderBrowserListHandler mRecorderBrowserListHandler = new RecorderBrowserListHandler(this.mSharedListMapper, this.mSharedFolderPath);
    private final CoverBrowserListHandler mCoverBrowserListHandler = new CoverBrowserListHandler();
    private final HasBrowserListHandler mHasBrowserListHandler = new HasBrowserListHandler();
    private final KombiBrowserListHandler mKombiBrowserListHandler = new KombiBrowserListHandler(this.mKombiBrowserActiveTrackInfo);
    private boolean mRecorderEntered;
    private final RecorderBrowserSelectionState mRecorderSelectionState = new RecorderBrowserSelectionState();

    public void registerPlayerStateListener(MediaPlayerState mediaPlayerState) {
        if (mediaPlayerState != null) {
            this.mPlayerState = mediaPlayerState;
            this.mPlayerState.setListener(this);
        }
    }

    public void registerRecorderStateListener(RecorderState recorderState) {
        if (recorderState != null) {
            this.mRecorderState = recorderState;
            this.mRecorderState.setListener(this);
        }
    }

    public void registerHeadunitBrowserStateListener(MediaMainBrowser mediaMainBrowser) {
        if (mediaMainBrowser != null) {
            this.mHeadunitBrowserState = mediaMainBrowser.getState();
            mediaMainBrowser.registerStateListener(this);
            mediaMainBrowser.registerListHandler(this.mHeadunitBrowserListHandler);
            mediaMainBrowser.registerSearchHandler(this.mHeadunitBrowserListHandler);
        }
    }

    public void registerRecorderBrowserStateListener(MediaRecorderBrowser mediaRecorderBrowser) {
        if (mediaRecorderBrowser != null) {
            this.mRecorderBrowserState = mediaRecorderBrowser.getState();
            mediaRecorderBrowser.registerStateListener(this);
            mediaRecorderBrowser.registerListHandler(this.mRecorderBrowserListHandler);
        }
    }

    public void registerKombiBrowserStateListener(MediaBapBrowser mediaBapBrowser) {
        if (mediaBapBrowser != null) {
            this.mKombiBrowserState = mediaBapBrowser.getState();
            this.mKombiBrowserState.setListener(this);
            mediaBapBrowser.registerListHandler(this.mKombiBrowserListHandler);
        }
    }

    public void registerSpeechBrowserStateListener(MediaSpeechBrowser mediaSpeechBrowser) {
        if (mediaSpeechBrowser != null) {
            this.mSpeechBrowserState = mediaSpeechBrowser.getState();
            this.mSpeechBrowserState.setListener(this);
        }
    }

    public void registerHasBrowserStateListener(MediaHasBrowser mediaHasBrowser) {
        if (mediaHasBrowser != null) {
            this.mHasBrowserState = mediaHasBrowser.getState();
            this.mHasBrowserState.setListener(this);
            mediaHasBrowser.registerListHandler(this.mHasBrowserListHandler);
        }
    }

    public void registerCoverBrowserStateListener(MediaCoverBrowser mediaCoverBrowser) {
        if (mediaCoverBrowser != null) {
            this.mCoverBrowserState = mediaCoverBrowser.getState();
            mediaCoverBrowser.registerStateListener(this);
            mediaCoverBrowser.registerListHandler(this.mCoverBrowserListHandler);
        }
    }

    @Override
    public void onActivationStateChanged(int n) {
        HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
        if (this.mHeadunitBrowserState != null && !this.mRecorderEntered) {
            HeadunitBrowserListState.update(this.mHeadunitBrowserState.getInitState(), this.mHeadunitBrowserState.getListState(), n);
        }
        if (n == 2 || n == 0) {
            boolean bl;
            MediaCollector mediaCollector;
            MediaCollector mediaCollector2 = MediaCollector.EMPTY;
            if (this.mPlayerState != null) {
                mediaCollector2 = this.mPlayerState.getActiveMedia();
            }
            if (this.mHeadunitBrowserState != null) {
                mediaCollector = this.mHeadunitBrowserState.getBrowseMedia();
                boolean bl2 = bl = mediaCollector == mediaCollector2 && MediaObjectAccessor.mMediaController.isHeadunitFollowModeActive();
                if (bl) {
                    this.mHeadunitBrowserState.setInitState(0);
                }
            }
            if (this.mKombiBrowserState != null) {
                mediaCollector = this.mKombiBrowserState.getBrowseMedia();
                boolean bl3 = bl = mediaCollector == mediaCollector2;
                if (bl) {
                    this.mKombiBrowserState.setInitState(0);
                }
            }
            if (this.mCoverBrowserState != null) {
                this.mCoverBrowserState.setInitState(0);
            }
        }
        this.mHeadunitBrowserListHandler.updateActivationState(n);
        this.mKombiBrowserListHandler.updateActivationState(this.mPlayerState, this.mKombiBrowserState);
        TrackInfo.updateTrackInfos(this.mPlayerState);
        TrackInfo.updateChapterInfos(this.mPlayerState);
        TimeBar.update(this.mPlayerState);
        HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
        CapabilityProperties.updateVideoCapability(this.mPlayerState);
    }

    @Override
    public void onPlaybackMediaChanged(MediaCollector mediaCollector) {
        HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
        this.mKombiBrowserActiveTrackInfo.onActiveMediaChanged(this.mPlayerState);
        TrackInfo.updateTrackInfos(this.mPlayerState);
        TrackInfo.updateChapterInfos(this.mPlayerState);
        this.mKombiBrowserListHandler.updateActivationState(this.mPlayerState, this.mKombiBrowserState);
    }

    @Override
    public void onPlaybackModesChanged(MediaPlaybackModes mediaPlaybackModes) {
        HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
        HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
    }

    @Override
    public void onPlaybackModeChanged(PlayMode playMode) {
        HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
        HASPlayerUpdater.update(this.mPlayerState, 4);
    }

    @Override
    public void onPlaybackStateChanged(int n) {
        PlaybackState.update(this.mPlayerState);
        HASPlayerUpdater.update(this.mPlayerState, 8);
        ASIClient.update(this.mPlayerState, 8);
    }

    @Override
    public void onCapabilitiesChanged(Capabilities capabilities) {
        CapabilityProperties.updateCapabilities(capabilities);
        HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
        PlaybackState.update(this.mPlayerState);
    }

    @Override
    public void onCmdBlockingMaskChanged(int n) {
        PlaybackState.update(this.mPlayerState);
    }

    @Override
    public void onPlayTimeChanged(PlayTime playTime) {
        HASPlayerUpdater.update(this.mPlayerState, 1);
        ASIClient.update(this.mPlayerState, 1);
        TimeBar.update(this.mPlayerState);
        if (playTime != null && playTime.hasTotalTimeChanged()) {
            TrackInfo.updateTrackInfos(this.mPlayerState);
        }
    }

    @Override
    public void onPlaySelectionChanged(Selection selection) {
        HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
        HASPlayerUpdater.update(this.mPlayerState, 4);
    }

    @Override
    public void onPlaybackEntryChanged(ListEntry[] listEntryArray, EntryInfo entryInfo) {
        this.mHeadunitBrowserListHandler.onPlaybackEntryChanged(this.mPlayerState);
        this.mKombiBrowserListHandler.onPlaybackEntryChanged(this.mPlayerState, this.mKombiBrowserState);
        this.mKombiBrowserActiveTrackInfo.update(this.mPlayerState);
        this.mHasBrowserListHandler.onPlaybackEntryChanged(this.mPlayerState);
        TrackInfo.updateTrackInfos(this.mPlayerState);
        TrackInfo.updateChapterInfos(this.mPlayerState);
        HASPlayerUpdater.update(this.mPlayerState, 2);
        HasBrowserFolderPath.updateMediaPlayerPath(this.mPlayerState);
        HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
    }

    @Override
    public void onBrowseMediaChanged(MediaCollector mediaCollector, int n) {
        switch (n) {
            case 0: {
                HeadunitBrowserActiveSource.update(mediaCollector);
                HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
                break;
            }
            case 3: {
                this.mKombiBrowserListHandler.updateActivationState(this.mPlayerState, this.mKombiBrowserState);
                break;
            }
            case 7: {
                RecorderBrowserActiveSource.update(this.mRecorderBrowserState);
                break;
            }
        }
    }

    @Override
    public void onPlaymodeCapabilityChanged(int n) {
        switch (n) {
            case 0: {
                HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
                break;
            }
            case 3: {
                break;
            }
            case 7: {
                break;
            }
        }
    }

    @Override
    public void onBrowseModeChanged(int n, int n2) {
        switch (n2) {
            case 0: {
                HeadUnitBrowsingTypeSwitching.forwardUsedBrowserType(n);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(777784320, n == 1);
                break;
            }
        }
    }

    @Override
    public void onBrowseFolderPathChanged(ListEntry[] listEntryArray, int n) {
        switch (n) {
            case 0: {
                HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
                HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
                break;
            }
            case 3: {
                BapBrowsedFolder.update(this.mKombiBrowserState);
                break;
            }
            case 7: {
                this.mRecorderSelectionState.onFolderPathChanged(this.mRecorderBrowserState);
                break;
            }
            case 4: {
                HasBrowserFolderPath.updateMediaBrowserPath(this.mHasBrowserState);
                break;
            }
        }
    }

    @Override
    public void onSelectionChanged(Selection selection, int n) {
        switch (n) {
            case 7: {
                this.mRecorderSelectionState.onSelectionChanged(this.mRecorderBrowserState);
                break;
            }
        }
    }

    @Override
    public void onModeSwitchingStateChanged(int n, int n2) {
        switch (n2) {
            case 0: {
                HeadUnitBrowsingTypeSwitching.update(this.mHeadunitBrowserState);
                break;
            }
            case 7: {
                break;
            }
            case 3: {
                break;
            }
            case 1: {
                break;
            }
            case 4: {
                HasBrowserFolderPath.updateMediaBrowserPath(this.mHasBrowserState);
                HasBrowserFolderPath.updateMediaPlayerPath(this.mPlayerState);
                break;
            }
        }
    }

    @Override
    public void onFocusedEntryChanged(ExtendedListEntry extendedListEntry, int n) {
        switch (n) {
            case 0: {
                this.mHeadunitBrowserListHandler.focusEntry(extendedListEntry, this.mHeadunitBrowserState);
                break;
            }
            case 7: {
                this.mRecorderBrowserListHandler.focusEntry(extendedListEntry);
                break;
            }
            case 1: {
                this.mCoverBrowserListHandler.focusAlbum(extendedListEntry, "album focus set by synchronizeBrowser");
                break;
            }
            case 4: {
                HASPlayerUpdater.onFocusedEntryChanged(extendedListEntry);
                break;
            }
        }
    }

    @Override
    public void onDeviceUpdated() {
        if (!this.mRecorderEntered) {
            this.mSharedFolderPath.update(this.mHeadunitBrowserState);
        } else {
            this.mSharedFolderPath.update(this.mRecorderBrowserState);
        }
        HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
    }

    @Override
    public void onStateChanged(int n, int n2, boolean bl, int n3) {
        switch (n3) {
            case 0: {
                if (!this.mRecorderEntered) {
                    HeadunitBrowserListState.update(n, n2, this.mPlayerState.getActivationState());
                    this.mSharedFolderPath.update(this.mHeadunitBrowserState);
                }
                HeadunitBrowserPlaymodeState.updateSupportedPlaymodes(this.mHeadunitBrowserState, this.mPlayerState);
                HeadUnitBrowsingTypeSwitching.update(this.mHeadunitBrowserState);
                break;
            }
            case 7: {
                if (!this.mRecorderEntered) break;
                HeadunitBrowserListState.update(n, n2, this.mPlayerState.getActivationState());
                break;
            }
            case 3: {
                KombiBrowserState.update(n, n2);
                this.mKombiBrowserListHandler.updateActivationState(this.mPlayerState, this.mKombiBrowserState);
                break;
            }
            case 1: {
                this.mCoverBrowserListHandler.onBrowserStateChanged(n, n2, bl);
                break;
            }
            case 4: {
                HasBrowserListState.update(n, n2);
                break;
            }
        }
    }

    @Override
    public void onCoverArtChanged(ResourceLocator resourceLocator, long l) {
        this.mCoverBrowserListHandler.onActiveTrackCoverChanged(l, resourceLocator);
        this.mKombiBrowserActiveTrackInfo.updateCoverArt(this.mPlayerState);
        TrackInfo.updateTrackInfos(this.mPlayerState);
        HASPlayerUpdater.update(this.mPlayerState, 2);
    }

    @Override
    public void onBrowseMediaEjected(int n) {
        switch (n) {
            case 0: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(308022272);
                break;
            }
            case 7: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(324799488);
                break;
            }
            case 3: {
                break;
            }
            case 1: {
                break;
            }
            case 4: {
                break;
            }
        }
    }

    @Override
    public void notifyChangingPlayerSource(MediaCollector mediaCollector, int n) {
        switch (n) {
            case 0: {
                if (this.mHeadunitBrowserState.getBrowseMedia() == mediaCollector) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(308022272);
                break;
            }
        }
    }

    @Override
    public void onRecorderMediaChanged(MediaCollector mediaCollector) {
        RecorderBrowserActiveSource.updatePrepareScreen(mediaCollector);
    }

    public int getSteps(int n) {
        return this.mHeadunitBrowserListHandler.onMoveFolderLevelUp(n);
    }

    public void onFollowModeEnabled() {
        this.mHeadunitBrowserListHandler.onFollowModeEnabled();
    }

    public void showList() {
        this.mHeadunitBrowserListHandler.onOpenFolder();
    }

    public void onRecorderEntered(boolean bl) {
        this.mRecorderEntered = bl;
        HeadunitBrowserPlaymodeState.updateActivePlaymodes(this.mPlayerState, this.mHeadunitBrowserState);
    }

    public boolean isRecorderEntered() {
        return this.mRecorderEntered;
    }
}

