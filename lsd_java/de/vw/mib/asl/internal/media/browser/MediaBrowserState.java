/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.api.media.services.browser.SpeakableElementsListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.BrowserStateListener;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import java.util.ArrayList;
import org.dsi.ifc.media.ListEntry;

public class MediaBrowserState {
    private final int mInstanceId;
    private BrowserStateListener mListener = null;
    private MediaCollector mBrowseMedia = null;
    public static final int BROWSEMODE_UNKNOWN;
    private int mBrowseMode = -1;
    public static final int CONTENTFILTER_UNKNOWN;
    private int mContentFilter = -1;
    private final BrowserPathData mPathData = new BrowserPathData();
    private ListEntry[] mBrowserFolderPath = null;
    private ExtendedListEntry mFocusedEntry = null;
    private int mInitState = -1;
    public static final int INIT_STATE_NO_SOURCE_SET;
    public static final int INIT_STATE_LOADING_SOURCE;
    public static final int INIT_STATE_SOURCE_LOADED_BROWSING_NOT_AVAILABLE;
    public static final int INIT_STATE_SOURCE_LOADED_BROWSING_AVAILABLE;
    private int mListState = -1;
    public static final int LIST_STATE_NOT_AVAILABLE;
    public static final int LIST_STATE_LOADING;
    public static final int LIST_STATE_EMPTY;
    public static final int LIST_STATE_READY;
    private int mBrowseModeSwitching = 1;
    public static final int BROWSER_TYPE_SWITCHING_NOT_INITIALIZED;
    public static final int BROWSER_TYPE_SWITCHING_NOT_SUPPORTED;
    public static final int BROWSER_TYPE_SWITCHING_SUPPORTED_BUT_STILL_REFRESHING;
    public static final int BROWSER_TYPE_SWITCHING_SUPPORTED_AND_AVAILABLE;
    public static final int BROWSER_TYPE_SWITCHING_NOT_SUPPORTED_CONTENT_ONLY;
    private boolean mFullySynced = false;
    private boolean mPlayModeBarVisible;
    private Selection mSelection = null;
    private int mListSize;
    private final ArrayList mDatabaseCategoryListener = new ArrayList();
    private int mDatabaseCategoryElementSize = 0;

    public MediaBrowserState(int n) {
        this.mInstanceId = n;
    }

    public void reset() {
        this.setBrowseMedia(null);
        this.setBrowsedMode(-1);
        this.setContentFilter(-1);
        this.setSelection(null);
        this.setBrowseFolder(null);
        this.setFocusedElementEntry(null);
        this.setListState(-1);
        this.setModeSwitchingState(-1);
        this.setFullySynced(false);
    }

    public void setListener(BrowserStateListener browserStateListener) {
        this.mListener = browserStateListener;
    }

    public MediaCollector getBrowseMedia() {
        return this.mBrowseMedia;
    }

    public void setBrowseMedia(MediaCollector mediaCollector) {
        if (this.mBrowseMedia != mediaCollector) {
            this.mBrowseMedia = mediaCollector;
            if (this.mListener != null) {
                this.mListener.onBrowseMediaChanged(this.mBrowseMedia, this.mInstanceId);
            }
        }
    }

    public int getBrowseMode() {
        return this.mBrowseMode;
    }

    public void setBrowsedMode(int n) {
        if (this.mBrowseMode != n) {
            this.mBrowseMode = n;
            if (this.mListener != null) {
                this.mListener.onBrowseModeChanged(this.mBrowseMode, this.mInstanceId);
            }
        }
    }

    public int getContentFilter() {
        return this.mContentFilter;
    }

    public void setContentFilter(int n) {
        this.mContentFilter = n;
    }

    public BrowserPathData getPathData() {
        return this.mPathData;
    }

    public ListEntry[] getBrowseFolder() {
        return this.mBrowserFolderPath;
    }

    public void setBrowseFolder(ListEntry[] listEntryArray) {
        if (!MediaBrowserHelper.isSameFolder(this.mBrowserFolderPath, listEntryArray)) {
            this.mBrowserFolderPath = listEntryArray;
            if (this.mListener != null) {
                this.mListener.onBrowseFolderPathChanged(this.mBrowserFolderPath, this.mInstanceId);
            }
        }
    }

    public int getListSize() {
        return this.mListSize;
    }

    public void setListSize(int n) {
        if (this.mListSize != n) {
            this.mListSize = n;
        }
    }

    public Selection getSelection() {
        return this.mSelection;
    }

    public void setSelection(Selection selection) {
        if (this.mSelection != selection) {
            this.mSelection = selection;
            if (this.mListener != null) {
                this.mListener.onSelectionChanged(this.mSelection, this.mInstanceId);
            }
        }
    }

    public ExtendedListEntry getFocusedElementEntry() {
        return this.mFocusedEntry;
    }

    public void setFocusedElementEntry(ExtendedListEntry extendedListEntry) {
        this.mFocusedEntry = extendedListEntry;
        if (this.mListener != null) {
            this.mListener.onFocusedEntryChanged(this.mFocusedEntry, this.mInstanceId);
        }
    }

    public int getInitState() {
        return this.mInitState;
    }

    public void setInitState(int n) {
        if (this.mInitState != n) {
            this.mInitState = n;
            if (this.mListener != null) {
                this.mListener.onStateChanged(this.mInitState, this.mListState, this.mFullySynced, this.mInstanceId);
            }
        }
    }

    public int getListState() {
        return this.mListState;
    }

    public void setListState(int n) {
        if (this.mListState != n) {
            this.mListState = n;
            if (this.mListener != null) {
                this.mListener.onStateChanged(this.mInitState, this.mListState, this.mFullySynced, this.mInstanceId);
            }
        }
    }

    public boolean isFullySynced() {
        return this.mFullySynced;
    }

    public void setFullySynced(boolean bl) {
        this.mFullySynced = bl;
        if (this.mListener != null) {
            this.mListener.onStateChanged(this.mInitState, this.mListState, this.mFullySynced, this.mInstanceId);
        }
    }

    public boolean isBrowsingAvailable() {
        return this.mInitState == 2;
    }

    public boolean isBrowsingInitialized() {
        return this.isBrowsingAvailable() || this.mInitState == 1;
    }

    public int getModeSwitchingState() {
        return this.mBrowseModeSwitching;
    }

    public void setModeSwitchingState(int n) {
        if (this.mBrowseModeSwitching != n) {
            this.mBrowseModeSwitching = n;
            if (this.mListener != null) {
                this.mListener.onModeSwitchingStateChanged(this.mBrowseModeSwitching, this.mInstanceId);
            }
        }
    }

    public int getInstanceId() {
        return this.mInstanceId;
    }

    public void onBrowseMediaEjected() {
        if (this.mListener != null) {
            this.mListener.onBrowseMediaEjected(this.mInstanceId);
            this.setInitState(-1);
        }
    }

    public void notifyChangingPlayerSource(MediaCollector mediaCollector) {
        if (this.mListener != null) {
            this.mListener.notifyChangingPlayerSource(mediaCollector, this.mInstanceId);
            if (mediaCollector != this.mBrowseMedia) {
                this.setInitState(-1);
            }
        }
    }

    public boolean isPlayModeBarVisible() {
        return this.mPlayModeBarVisible;
    }

    public void setPlayModeBarVisible(boolean bl) {
        this.mPlayModeBarVisible = bl;
    }

    public void onPlaymodeCapabilityChanged() {
        if (this.mListener != null) {
            this.mListener.onPlaymodeCapabilityChanged(this.mInstanceId);
        }
    }

    public void onDeviceUpdated() {
        if (this.mListener != null) {
            this.mListener.onDeviceUpdated();
        }
    }

    public boolean isCurrentFolderPartOfPlaySelection(MediaPlayerState mediaPlayerState) {
        Selection selection = null;
        if (mediaPlayerState != null) {
            selection = mediaPlayerState.getPlaybackSelection();
        }
        MediaCollector mediaCollector = this.getBrowseMedia();
        ListEntry[] listEntryArray = this.getBrowseFolder();
        if (selection != null && mediaCollector != null && listEntryArray != null) {
            return selection.contains(mediaCollector, listEntryArray);
        }
        return false;
    }

    public void addDatabaseCategoryListener(SpeakableElementsListener speakableElementsListener) {
        this.mDatabaseCategoryListener.add(speakableElementsListener);
        speakableElementsListener.updateSpeakableElementCount(this.mDatabaseCategoryElementSize, ServiceManager.configManagerDiag.getSDSMediaMaxItems());
    }

    public int getDatabaseCategoryElementSize() {
        return this.mDatabaseCategoryElementSize;
    }

    public void setSpeakableElementsSize(int n, boolean bl) {
        if (this.mDatabaseCategoryElementSize != n) {
            this.mDatabaseCategoryElementSize = n;
            for (int i2 = 0; i2 < this.mDatabaseCategoryListener.size(); ++i2) {
                SpeakableElementsListener speakableElementsListener = (SpeakableElementsListener)this.mDatabaseCategoryListener.get(i2);
                speakableElementsListener.updateSpeakableElementCount(n, ServiceManager.configManagerDiag.getSDSMediaMaxItems());
            }
        }
    }
}

