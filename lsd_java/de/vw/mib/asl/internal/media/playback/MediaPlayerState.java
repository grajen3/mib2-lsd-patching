/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.playback;

import de.vw.mib.asl.api.media.services.player.MediaActivationStateListener;
import de.vw.mib.asl.api.media.services.player.MediaPlayViewListener;
import de.vw.mib.asl.internal.media.browser.PredictableModelProperty;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.playback.DefaultSelectionFactory;
import de.vw.mib.asl.internal.media.playback.MediaPlaybackModes;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$1;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$2;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$3;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$4;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$5;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$6;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$7;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState$8;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.playback.PlayTime;
import de.vw.mib.asl.internal.media.playback.PlayerStateListener;
import de.vw.mib.asl.internal.media.playback.listener.MediaActiveMediaListener;
import de.vw.mib.asl.internal.media.playback.listener.MediaPlaybackEntryListener;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;

public class MediaPlayerState {
    public static final int INIT_STATE_DEACTIVATING;
    public static final int INIT_STATE_DEACTIVATED;
    public static final int INIT_STATE_ACTIVATING;
    public static final int INIT_STATE_ACTIVATED;
    private DefaultSelectionFactory mDefaultSelectionFactory = new DefaultSelectionFactory();
    private MediaPlaybackModes mPlaybackModeList = null;
    PlayerStateListener mListener = null;
    private final PredictableModelProperty mPlaybackMedia = new PredictableModelProperty(new MediaPlayerState$1(this));
    private final ArrayList mActiveMediaListener = new ArrayList();
    private final PredictableModelProperty mPlaySelection = new PredictableModelProperty(new MediaPlayerState$2(this));
    private final PredictableModelProperty mPlaybackMode = new PredictableModelProperty(new MediaPlayerState$3(this));
    private final PredictableModelProperty mPlaybackFolder = new PredictableModelProperty();
    private final PredictableModelProperty mPlaybackEntry = new PredictableModelProperty(new MediaPlayerState$4(this));
    private final ArrayList mPlaybackEntryListener = new ArrayList();
    private final PredictableModelProperty mPlaybackState = new PredictableModelProperty(new MediaPlayerState$5(this));
    private final PredictableModelProperty mCapabilities = new PredictableModelProperty(new MediaPlayerState$6(this));
    private final PredictableModelProperty mPlayTimeInfo = new PredictableModelProperty(new MediaPlayerState$7(this));
    private ResourceLocator mCoverArt = null;
    private int mCmdBlockingMask;
    private final ArrayList mPlayViewListener = new ArrayList();
    int mPlayViewSize = 0;
    private final ArrayList mActivationStateListener = new ArrayList();
    private final PredictableModelProperty mActivationState = new PredictableModelProperty(new MediaPlayerState$8(this));

    public DefaultSelectionFactory getDefaultSelectionFactory() {
        return this.mDefaultSelectionFactory;
    }

    public void reset() {
        this.mDefaultSelectionFactory = new DefaultSelectionFactory();
    }

    public void setListener(PlayerStateListener playerStateListener) {
        this.mListener = playerStateListener;
    }

    protected void setPlayerMedia(MediaCollector mediaCollector) {
        this.mPlaybackMedia.updateSubmittedValue(mediaCollector);
    }

    public void predictPlaybackMedia(MediaCollector mediaCollector, long l) {
        this.mPlaybackMedia.updatePredictedValue(mediaCollector, l);
    }

    public void clearPlaybackMedia(long l) {
        this.mPlaybackMedia.clearPrediction(l);
    }

    public void addActiveMediaListener(MediaActiveMediaListener mediaActiveMediaListener) {
        this.mActiveMediaListener.add(mediaActiveMediaListener);
        mediaActiveMediaListener.updatePlaybackMedia();
    }

    public void notifyActiveMediaListener() {
        for (int i2 = 0; i2 < this.mActiveMediaListener.size(); ++i2) {
            MediaActiveMediaListener mediaActiveMediaListener = (MediaActiveMediaListener)this.mActiveMediaListener.get(i2);
            mediaActiveMediaListener.updatePlaybackMedia();
        }
    }

    protected void updatePlaySelection(Selection selection) {
        this.mPlaySelection.updateSubmittedValue(selection);
    }

    public void predictPlaySelection(Selection selection, long l) {
        this.mPlaySelection.updatePredictedValue(selection, l);
    }

    public void clearPlaySelection(long l) {
        this.mPlaySelection.clearPrediction(l);
    }

    protected void setPlaybackMode(PlayMode playMode) {
        this.mPlaybackMode.updateSubmittedValue(playMode);
    }

    public void predictPlaybackMode(PlayMode playMode, long l) {
        this.mPlaybackMode.updatePredictedValue(playMode, l);
    }

    public void clearPlaybackMode(long l) {
        this.mPlaybackMode.clearPrediction(l);
    }

    private boolean isDefaultPlaymode() {
        PlayMode playMode = this.getPlaybackMode();
        Selection selection = this.getPlaybackSelection();
        MediaCollector mediaCollector = this.getActiveMedia();
        if (playMode != null) {
            if (playMode.usesSelections() && selection != null && mediaCollector != null && !mediaCollector.storesOwnPlaybackState()) {
                return (playMode.isPlayDefault() || playMode.isRepeatFolder()) && selection.isDefault();
            }
            return playMode.isPlayDefault();
        }
        return false;
    }

    private boolean isRepeatFolder() {
        PlayMode playMode = this.getPlaybackMode();
        if (!this.isDefaultPlaymode() && !this.isPlaySimilar()) {
            return playMode.isRepeatFolder();
        }
        return false;
    }

    public boolean isRepeatFolderMix() {
        PlayMode playMode = this.getPlaybackMode();
        if (playMode != null) {
            return playMode.isRepeatFolderMix();
        }
        return false;
    }

    public boolean isRepeatFile() {
        PlayMode playMode = this.getPlaybackMode();
        if (playMode != null) {
            return playMode.isRepeatFile();
        }
        return false;
    }

    public boolean isRepeatFileMix() {
        PlayMode playMode = this.getPlaybackMode();
        if (playMode != null) {
            return playMode.isRepeatFileMix();
        }
        return false;
    }

    public boolean isMix() {
        PlayMode playMode = this.getPlaybackMode();
        if (playMode != null) {
            return playMode.isMix();
        }
        return false;
    }

    public boolean isPlaySimilar() {
        PlayMode playMode = this.getPlaybackMode();
        Selection selection = this.getPlaybackSelection();
        if (playMode != null && selection != null) {
            return (playMode.isRepeatFolder() || playMode.isPlayDefault()) && selection.isPlaySimilarSelection();
        }
        return false;
    }

    public boolean involvesMix() {
        return this.isMix() || this.isRepeatFolderMix() || this.isRepeatFileMix();
    }

    public boolean involvesRepeatFolder() {
        return this.isRepeatFolder() || this.isRepeatFolderMix();
    }

    public boolean involvesRepeatFile() {
        return this.isRepeatFile() || this.isRepeatFileMix();
    }

    public boolean involvesRepeat() {
        return this.involvesRepeatFolder() || this.involvesRepeatFile();
    }

    protected void updatePlaybackEntry(EntryInfo entryInfo, ListEntry[] listEntryArray) {
        this.mPlaybackFolder.updateSubmittedValue(listEntryArray);
        this.mPlaybackEntry.updateSubmittedValue(entryInfo);
    }

    public void predictPlaybackEntry(EntryInfo entryInfo, ListEntry[] listEntryArray, long l) {
        this.mPlaybackFolder.updatePredictedValue(listEntryArray, l);
        this.mPlaybackEntry.updatePredictedValue(entryInfo, l);
    }

    public void clearPlaybackEntry(long l) {
        this.mPlaybackFolder.clearPrediction(l);
        this.mPlaybackEntry.clearPrediction(l);
    }

    public void addPlaybackEntryListener(MediaPlaybackEntryListener mediaPlaybackEntryListener) {
        this.mPlaybackEntryListener.add(mediaPlaybackEntryListener);
        mediaPlaybackEntryListener.updatePlaybackEntry();
    }

    public void notifyPlaybackEntryListener() {
        for (int i2 = 0; i2 < this.mPlaybackEntryListener.size(); ++i2) {
            MediaPlaybackEntryListener mediaPlaybackEntryListener = (MediaPlaybackEntryListener)this.mPlaybackEntryListener.get(i2);
            mediaPlaybackEntryListener.updatePlaybackEntry();
        }
    }

    protected void updatePlaybackState(int n) {
        this.mPlaybackState.updateSubmittedValue(new Integer(n));
    }

    public void predictPlaybackState(int n, long l) {
        this.mPlaybackState.updatePredictedValue(new Integer(n), l);
    }

    public void clearPlaybackState(long l) {
        this.mPlaybackState.clearPrediction(l);
    }

    protected void updateCapabilities(Capabilities capabilities) {
        this.mCapabilities.updateSubmittedValue(capabilities);
    }

    public void predictCapabilities(Capabilities capabilities, long l) {
        this.mCapabilities.updatePredictedValue(capabilities, l);
    }

    public void clearCapabilities(long l) {
        this.mCapabilities.clearPrediction(l);
    }

    protected void updatePlayTimeInfo(PlayTime playTime) {
        this.mPlayTimeInfo.updateSubmittedValue(playTime);
    }

    public void predictPlayTime(PlayTime playTime, long l) {
        this.mPlayTimeInfo.updatePredictedValue(playTime, l);
    }

    public void clearPlayTime(long l) {
        this.mPlayTimeInfo.clearPrediction(l);
    }

    public boolean isPlaying() {
        Object object = this.mPlaybackState.getVisibleProperty();
        int n = object == null ? 0 : (Integer)object;
        return n == 1;
    }

    public void setPlaybackModesList(MediaPlaybackModes mediaPlaybackModes) {
        this.mPlaybackModeList = mediaPlaybackModes;
        if (this.mListener != null) {
            this.mListener.onPlaybackModesChanged(this.mPlaybackModeList);
        }
    }

    public MediaCollector getActiveMedia() {
        return this.mPlaybackMedia.getVisibleProperty() != null ? (MediaCollector)this.mPlaybackMedia.getVisibleProperty() : null;
    }

    public Selection getPlaybackSelection() {
        return this.mPlaySelection.getVisibleProperty() != null ? (Selection)this.mPlaySelection.getVisibleProperty() : null;
    }

    public MediaPlaybackModes getPlaybackModeList() {
        return this.mPlaybackModeList;
    }

    public PlayMode getPlaybackMode() {
        return this.mPlaybackMode.getVisibleProperty() != null ? (PlayMode)this.mPlaybackMode.getVisibleProperty() : PlayMode.UNKNOWN;
    }

    public int getPlaybackState() {
        return this.mPlaybackState.getVisibleProperty() != null ? (Integer)this.mPlaybackState.getVisibleProperty() : -124;
    }

    public Capabilities getCapabilities() {
        return this.mCapabilities.getVisibleProperty() != null ? (Capabilities)this.mCapabilities.getVisibleProperty() : null;
    }

    public PlayTime getPlayTime() {
        return this.mPlayTimeInfo.getVisibleProperty() != null ? (PlayTime)this.mPlayTimeInfo.getVisibleProperty() : null;
    }

    public ListEntry[] getPlaybackPath() {
        return this.mPlaybackFolder.getVisibleProperty() != null ? (ListEntry[])this.mPlaybackFolder.getVisibleProperty() : null;
    }

    public EntryInfo getPlaybackEntry() {
        return this.mPlaybackEntry.getVisibleProperty() != null ? (EntryInfo)this.mPlaybackEntry.getVisibleProperty() : null;
    }

    public ResourceLocator getTrackCover() {
        return this.mCoverArt;
    }

    public void setCoverArt(ResourceLocator resourceLocator, long l) {
        this.mCoverArt = resourceLocator;
        if (this.mListener != null) {
            this.mListener.onCoverArtChanged(resourceLocator, l);
        }
    }

    public boolean isIPodMixMode() {
        return this.getActiveMedia() != null && this.getActiveMedia().isIPod() && this.involvesMix();
    }

    public boolean isJoggerMode() {
        if (this.getActiveMedia() != null && (this.getActiveMedia().isIPod() || this.getActiveMedia().isBT()) && this.getPlaybackPath() != null && this.getPlaybackPath().length == 2) {
            ListEntry listEntry = this.getPlaybackPath()[1];
            return listEntry.getEntryID() == 0 || listEntry.getFilename().equals("filterCriteria.nowPlaying");
        }
        return false;
    }

    public boolean isInitialized() {
        return this.isActivated() || this.isDeactivated();
    }

    public boolean isActivated() {
        return this.getActivationState() == 3;
    }

    public boolean isDeactivated() {
        return this.getActivationState() == 1;
    }

    public boolean isDeactivating() {
        return this.getActivationState() == 0;
    }

    public void updateCmdBlockingMask(int n) {
        this.mCmdBlockingMask = n;
        if (this.mListener != null) {
            this.mListener.onCmdBlockingMaskChanged(n);
        }
    }

    public int getCmdBlockingMask() {
        return this.mCmdBlockingMask;
    }

    public void addPlayViewListener(MediaPlayViewListener mediaPlayViewListener) {
        this.mPlayViewListener.add(mediaPlayViewListener);
        mediaPlayViewListener.updatePlayViewSize(this.mPlayViewSize);
    }

    public int getPlayViewSize() {
        return this.mPlayViewSize;
    }

    public void setPlayViewSize(int n, boolean bl) {
        if (this.mPlayViewSize != n) {
            this.mPlayViewSize = n;
            for (int i2 = 0; i2 < this.mPlayViewListener.size(); ++i2) {
                MediaPlayViewListener mediaPlayViewListener = (MediaPlayViewListener)this.mPlayViewListener.get(i2);
                mediaPlayViewListener.updatePlayViewSize(n);
            }
        }
    }

    public void addActivationStateListener(MediaActivationStateListener mediaActivationStateListener) {
        this.mActivationStateListener.add(mediaActivationStateListener);
        mediaActivationStateListener.updateActivationState(this.getActivationState());
    }

    protected void updateActivationState(int n) {
        this.mActivationState.updateSubmittedValue(new Integer(n));
    }

    public void predictActivationState(int n, long l) {
        this.mActivationState.updatePredictedValue(new Integer(n), l);
    }

    public void clearActivationState(long l) {
        this.mActivationState.clearPrediction(l);
    }

    public int getActivationState() {
        return (Integer)this.mActivationState.getVisibleProperty();
    }

    static /* synthetic */ PredictableModelProperty access$000(MediaPlayerState mediaPlayerState) {
        return mediaPlayerState.mPlaybackFolder;
    }

    static /* synthetic */ PredictableModelProperty access$100(MediaPlayerState mediaPlayerState) {
        return mediaPlayerState.mPlaybackEntry;
    }

    static /* synthetic */ ArrayList access$200(MediaPlayerState mediaPlayerState) {
        return mediaPlayerState.mActivationStateListener;
    }
}

