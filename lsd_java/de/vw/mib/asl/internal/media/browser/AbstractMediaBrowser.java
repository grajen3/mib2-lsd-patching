/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser;

import de.vw.mib.asl.api.media.IMediaConstants;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.accessor.MediaObjectAccessor;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowserTarget;
import de.vw.mib.asl.internal.media.browser.BrowserPathData;
import de.vw.mib.asl.internal.media.browser.BrowserStateListener;
import de.vw.mib.asl.internal.media.browser.MediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListFetcher;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler;
import de.vw.mib.asl.internal.media.browser.MediaBrowserListHandler$MediaListElementFetcher;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.browser.Selection;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.asl.internal.media.playback.MediaPlayer;
import de.vw.mib.asl.internal.media.playback.PlayMode;
import de.vw.mib.asl.internal.media.sourcehandling.state.MediaCollector;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.MediaInfo;

public abstract class AbstractMediaBrowser
extends AbstractMediaBrowserTarget
implements MediaBrowser {
    private static final int RT_SET_BROWSE_MEDIA = AbstractMediaBrowser.assignRequestId();
    private static final int RT_SET_BROWSE_MODE = AbstractMediaBrowser.assignRequestId();
    private static final int RT_SET_CONTENT_FILTER = AbstractMediaBrowser.assignRequestId();
    private static final int RT_OPEN_FOLDER = AbstractMediaBrowser.assignRequestId();
    private static final int RT_SET_SELECTION = AbstractMediaBrowser.assignRequestId();
    private static final int RT_LIST_ENTRY = AbstractMediaBrowser.assignRequestId();
    private static final int RT_LIST = AbstractMediaBrowser.assignRequestId();
    private static final int RT_PICK_LIST = AbstractMediaBrowser.assignRequestId();
    private static final int RT_FILL_ROOT_FOLDER_INFO = AbstractMediaBrowser.assignRequestId();
    private MediaCollector mRequestedAssignedMedia;
    private MediaCollector mRequestedInternalMedia;
    private int mRequestedBrowseMode;
    private int mRequestedContentFilterMask;
    private Selection mRequestedSelection;
    private boolean mExecuteSelectionAfterReset = false;
    private final MediaBrowserState mBrowserState;
    private MediaBrowserListHandler mListHandler;
    protected MediaBrowserListHandler$MediaListElementFetcher mListFetcher;
    private MediaCollector mInternalMedia = MediaCollector.EMPTY;
    private ListEntry[] mRequestedFolderPath = null;
    private ExtendedListEntry[] mLastListResponse = null;
    private int mRequestedListEntryIndex = -1;
    private long mRequestedListEntryEntryId = -1L;
    private int mRequestedListEntryContentType = -1;
    private ExtendedListEntry mRequestedListEntryAnswer = null;
    private ListEntry[] mPickList = null;

    public AbstractMediaBrowser(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string, n);
        this.mBrowserState = new MediaBrowserState(n);
    }

    public void registerListFetcher(MediaBrowserListFetcher mediaBrowserListFetcher) {
        this.mListFetcher = mediaBrowserListFetcher;
    }

    public void registerListHandler(MediaBrowserListHandler mediaBrowserListHandler) {
        if (mediaBrowserListHandler != null) {
            mediaBrowserListHandler.setFetcher(this.mListFetcher);
            this.mListHandler = mediaBrowserListHandler;
        }
    }

    public void registerStateListener(BrowserStateListener browserStateListener) {
        if (browserStateListener != null) {
            this.mBrowserState.setListener(browserStateListener);
        }
    }

    public void invalidate(String string) {
        if (this.isTraceEnabled()) {
            this.trace(new StringBuffer().append(this.getBrowserName()).append("invalidate (reason: ").append(string).append(")").toString());
        }
        this.fireResponse(false, string);
        this.dsiMediaBrowserUpdateBrowseMedia(0L, 0L, 2);
        this.dsiMediaBrowserUpdateBrowseMode(0, 2);
        this.dsiMediaBrowserUpdateContentFilter(0, 2);
        this.dsiMediaBrowserUpdateBrowseFolder(null, 2);
        this.dsiMediaBrowserUpdateListSize(0, 0, 2);
        this.mBrowserState.reset();
    }

    @Override
    protected void powerOff() {
        this.invalidate("power Off");
    }

    private void invalidateAndResynchronize(String string, boolean bl) {
        this.invalidate("invalidate & resynchronize");
        if (bl) {
            MediaObjectAccessor.mMediaController.removeDBLPlaySelection();
        }
        MediaObjectAccessor.mMediaController.resynchronize(this);
    }

    public void rqSetBrowseMedia(MediaCollector mediaCollector, int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_BROWSE_MEDIA, responseHandler)) {
            this.mRequestedAssignedMedia = mediaCollector;
            this.mRequestedInternalMedia = this.getInternalMedia(mediaCollector, n);
            this.getDSI().setBrowseMedia(this.mRequestedInternalMedia.getDeviceID(), this.mRequestedInternalMedia.getMediaID());
            if (this.mRequestedInternalMedia.getDeviceID() == 0L && this.mRequestedInternalMedia.getMediaID() == 0L) {
                this.dsiMediaBrowserUpdateBrowseMedia(0L, 0L, 1);
            }
        }
    }

    public void rqDeactivate(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_BROWSE_MEDIA, responseHandler)) {
            this.mRequestedAssignedMedia = MediaCollector.EMPTY;
            this.mRequestedInternalMedia = MediaCollector.EMPTY;
            this.getDSI().setBrowseMedia(MediaCollector.EMPTY.getDeviceID(), MediaCollector.EMPTY.getMediaID());
            this.dsiMediaBrowserUpdateBrowseMedia(0L, 0L, 1);
        }
    }

    public void dsiMediaBrowserUpdateBrowseMedia(long l, long l2, int n) {
        if (n != 1) {
            this.mInternalMedia = null;
            this.mBrowserState.setBrowseMedia(null);
            return;
        }
        if (this.isRegisteredForResponse(RT_SET_BROWSE_MEDIA) && this.mRequestedInternalMedia.getDeviceID() == l && this.mRequestedInternalMedia.getMediaID() == l2) {
            this.mBrowserState.setBrowseMedia(this.mRequestedAssignedMedia);
            this.mInternalMedia = this.mRequestedInternalMedia;
            this.fireResponse(true);
        }
    }

    public boolean isDeactivated() {
        return this.mInternalMedia == MediaCollector.EMPTY;
    }

    public void rqSetBrowseMode(int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_BROWSE_MODE, responseHandler)) {
            this.mRequestedBrowseMode = n;
            if (this.getBrowseMode() != n) {
                this.getDSI().setBrowseMode(n);
            } else {
                this.fireResponse(true, "browseMode already set");
            }
        }
    }

    public void dsiMediaBrowserUpdateBrowseMode(int n, int n2) {
        if (n2 != 1) {
            this.setBrowseMode(-1);
            return;
        }
        this.setBrowseMode(n);
        this.detectModeSwitchingAvailable();
        this.detectFullySyncAvailable(false);
        this.fireResponse(this.mRequestedBrowseMode == n, RT_SET_BROWSE_MODE);
    }

    public void rqSetContentFilter(int n, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_CONTENT_FILTER, responseHandler)) {
            this.dsiMediaBrowserUpdateContentFilter(0, 2);
            this.dsiMediaBrowserUpdateBrowseFolder(null, 2);
            this.dsiMediaBrowserUpdateListSize(0, 0, 2);
            this.mRequestedContentFilterMask = n;
            this.getDSI().setContentFilter(n);
        }
    }

    public void dsiMediaBrowserUpdateContentFilter(int n, int n2) {
        if (n2 != 1 || n == 0) {
            this.setContentFilter(-1);
            return;
        }
        this.setContentFilter(n);
        this.detectContentFilterSet();
    }

    public int getDefaultContentFilterMask() {
        return 7;
    }

    private void detectContentFilterSet() {
        if (this.isRegisteredForResponse(RT_SET_CONTENT_FILTER) && !Util.isNullOrEmpty(this.getBrowseFolder()) && this.getListSize() > 0 && this.getContentFilter() >= 0) {
            this.fireResponse(this.mRequestedContentFilterMask == this.getContentFilter());
        }
    }

    @Override
    public void onDevicesUpdated() {
        if (this.mRequestedInternalMedia != null && this.mRequestedInternalMedia.getMedium().isJustRemoved()) {
            this.invalidateAndResynchronize("browsed media removed", false);
            this.mBrowserState.onBrowseMediaEjected();
            return;
        }
        MediaCollector mediaCollector = this.getBrowseMedia();
        if (mediaCollector != null) {
            MediaInfo mediaInfo = mediaCollector.getMedium().getPreviousInfo();
            MediaInfo mediaInfo2 = mediaCollector.getMedium().getCurrentInfo();
            if (mediaInfo.getFlags() != mediaInfo2.getFlags()) {
                int n = mediaInfo2.getFlags() & ~mediaInfo.getFlags();
                int n2 = ~mediaInfo2.getFlags() & mediaInfo.getFlags();
                if (this.isTraceEnabled()) {
                    if (n != 0) {
                        this.trace(new StringBuffer().append(this.getBrowserName()).append("+ [").append(MediaBrowserHelper.getMediaFlagsStr(n)).append("]").toString());
                    }
                    if (n2 != 0) {
                        this.trace(new StringBuffer().append(this.getBrowserName()).append("- [").append(MediaBrowserHelper.getMediaFlagsStr(n2)).append("]").toString());
                    }
                }
                if (Util.isAnyBitSet(0x8000F00, n2)) {
                    this.invalidateAndResynchronize("sync flags removed", Util.isBitSet(512, n2));
                    return;
                }
                this.detectModeSwitchingAvailable();
                this.detectFullySyncAvailable(true);
            }
            if (mediaCollector.isMediaPlayable() && mediaInfo.getMediaType() != 12) {
                MediaCapabilities mediaCapabilities = mediaInfo.mediaCaps;
                MediaCapabilities mediaCapabilities2 = mediaInfo2.mediaCaps;
                if (this.isTraceEnabled()) {
                    String string = "";
                    String string2 = "";
                    if (mediaCapabilities.rawBrowser != mediaCapabilities2.rawBrowser) {
                        if (mediaCapabilities2.rawBrowser) {
                            string = new StringBuffer().append(string).append("RAW_BROWSER|").toString();
                        } else {
                            string2 = new StringBuffer().append(string2).append("RAW_BROWSER|").toString();
                        }
                    }
                    if (mediaCapabilities.contentBrowser != mediaCapabilities2.contentBrowser) {
                        if (mediaCapabilities2.contentBrowser) {
                            string = new StringBuffer().append(string).append("CONTENT_BROWSER|").toString();
                        } else {
                            string2 = new StringBuffer().append(string2).append("CONTENT_BROWSER|").toString();
                        }
                    }
                    if (mediaCapabilities.playbackModes != mediaCapabilities2.playbackModes) {
                        if (mediaCapabilities2.playbackModes) {
                            string = new StringBuffer().append(string).append("PLAYBACKMODES|").toString();
                        } else {
                            string2 = new StringBuffer().append(string2).append("PLAYBACKMODES|").toString();
                        }
                    }
                    if (string.length() > 0) {
                        this.trace(new StringBuffer().append(this.getBrowserName()).append("+ [").append(string.substring(0, string.length() - 1)).append("]").toString());
                    }
                    if (string2.length() > 0) {
                        this.trace(new StringBuffer().append(this.getBrowserName()).append("- [").append(string2.substring(0, string2.length() - 1)).append("]").toString());
                    }
                }
                if (mediaCapabilities == null || mediaCapabilities.rawBrowser != mediaCapabilities2.rawBrowser || mediaCapabilities.contentBrowser != mediaCapabilities2.contentBrowser) {
                    this.invalidateAndResynchronize("browsing capabilities changed", !mediaCapabilities2.contentBrowser);
                    return;
                }
                if (this.mBrowserState.isBrowsingInitialized() && mediaCapabilities.playbackModes != mediaCapabilities2.playbackModes) {
                    this.mBrowserState.onPlaymodeCapabilityChanged();
                }
            }
            this.mBrowserState.onDeviceUpdated();
        }
    }

    private void detectModeSwitchingAvailable() {
        MediaCollector mediaCollector = this.getBrowseMedia();
        if (mediaCollector != null) {
            if (mediaCollector.supportsRawAndContentMode()) {
                if (mediaCollector.isFlagSet(512)) {
                    this.setModeSwitchingState(3);
                } else {
                    this.setModeSwitchingState(2);
                }
            } else if (mediaCollector.supportsContentModeOnly()) {
                this.setModeSwitchingState(4);
            } else {
                this.setModeSwitchingState(1);
            }
        } else {
            this.setModeSwitchingState(1);
        }
    }

    private void detectFullySyncAvailable(boolean bl) {
        MediaCollector mediaCollector = this.getBrowseMedia();
        int n = this.getBrowseMode();
        if (mediaCollector != null && n != -1 && !this.mBrowserState.isFullySynced()) {
            boolean bl2 = false;
            if (n == 1) {
                bl2 = mediaCollector.isFlagSet(1024, bl);
            } else {
                boolean bl3 = bl2 = IMediaConstants.ESO ? mediaCollector.isFlagSet(256, bl) : true;
            }
            if (bl2) {
                if (bl) {
                    this.refetch();
                }
                this.mBrowserState.setFullySynced(bl2);
            }
        }
    }

    @Override
    public void rqOpenFolder(ListEntry[] listEntryArray, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_OPEN_FOLDER, responseHandler)) {
            if (Util.isNullOrEmpty(listEntryArray)) {
                this.fireResponse(false, "openFolder: path must not be null/empty");
                return;
            }
            if (MediaBrowserHelper.isSameFolder(listEntryArray, this.getBrowseFolder())) {
                this.fireResponse(true, "openFolder: path already open");
                return;
            }
            if (MediaBrowserHelper.getBrowseMode(listEntryArray) != this.getBrowseMode()) {
                this.fireResponse(true, "openFolder: path incompatible with current browseMode -> skip");
                return;
            }
            this.mRequestedFolderPath = listEntryArray;
            this.getDSI().changeFolder(listEntryArray);
        }
    }

    public void dsiMediaBrowserUpdateBrowseFolder(ListEntry[] listEntryArray, int n) {
        if (n != 1) {
            this.mBrowserState.setBrowseFolder(null);
            return;
        }
        if (!Util.isNullOrEmpty(listEntryArray) && listEntryArray[0] != null) {
            listEntryArray[0].filename = this.getBrowseMode() == 1 ? "" : "/";
        }
        this.setActiveFolder(listEntryArray);
        if (this.mListHandler != null) {
            this.mListHandler.updateFolderPath(this.getState());
        }
        this.detectContentFilterSet();
    }

    private void detectFolderOpened() {
        if (MediaBrowserHelper.isSameFolder(this.mRequestedFolderPath, this.getBrowseFolder())) {
            this.fireResponse(true, RT_OPEN_FOLDER);
        }
    }

    public void dsiMediaBrowserUpdateListSize(int n, int n2, int n3) {
        if (n3 != 1) {
            this.mBrowserState.setListSize(-1);
            return;
        }
        this.mBrowserState.setListSize(n);
        if (this.mListHandler != null) {
            this.mListHandler.setFetcher(this.mListFetcher);
            this.mListHandler.updateListSize(n);
        }
        this.detectContentFilterSet();
        this.detectFolderOpened();
    }

    public void refetch() {
        if (this.mListHandler != null) {
            this.mListHandler.refetch();
        }
    }

    @Override
    public void rqList(long l, int n, int n2, int n3, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_LIST, responseHandler)) {
            this.getDSI().requestList(l, n, n2, n3);
        }
    }

    private void detectResponseList(ListEntry[] listEntryArray, int n) {
        if (this.isRegisteredForResponse(RT_LIST)) {
            if (Util.isNullOrEmpty(listEntryArray)) {
                this.mLastListResponse = null;
                this.fireResponse(false, "null or empty list");
                return;
            }
            this.mLastListResponse = new ExtendedListEntry[listEntryArray.length];
            for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                this.mLastListResponse[i2] = new ExtendedListEntry(this.getBrowseMedia(), listEntryArray[i2], n + i2);
            }
            this.fireResponse(true);
        }
    }

    @Override
    public ExtendedListEntry[] getListResponse() {
        return this.mLastListResponse;
    }

    public void dsiMediaBrowserResponseList(ListEntry[] listEntryArray, int n) {
        this.detectResponseList(listEntryArray, n);
        this.detectResponseListEntry(listEntryArray, n);
        if (Util.isNullOrEmpty(listEntryArray)) {
            this.error(new StringBuffer().append(this.getBrowserName()).append("~ RESPONSE LIST: entryList must not be null or empty").toString());
            return;
        }
        if (Util.isNullOrEmpty(this.getBrowseFolder())) {
            this.error(new StringBuffer().append(this.getBrowserName()).append("~ RESPONSE LIST: activeFolderPath must not be null or empty").toString());
            return;
        }
        this.detectFillPathDataResponse(listEntryArray, n);
    }

    public void dsiMediaBrowserUpdateAlphabeticalIndex(CharacterInfo[] characterInfoArray, int n) {
        if (this.mListHandler != null) {
            boolean bl = n == 1 && !Util.isNullOrEmpty(characterInfoArray);
            this.mListHandler.updateListData((CharacterInfo[])(bl ? characterInfoArray : null));
        }
    }

    @Override
    public void rqListEntry(long l, int n, String listEntryArray, int n2, boolean bl, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_LIST_ENTRY, responseHandler)) {
            ListEntry[] listEntryArray2;
            ListEntry[] listEntryArray3;
            this.mRequestedListEntryAnswer = null;
            if (this.mListHandler != null && (listEntryArray3 = this.getListEntryInCache(l, n, n2, (String)(listEntryArray2 = bl ? listEntryArray : null))) != null) {
                this.mRequestedListEntryAnswer = listEntryArray3;
                this.fireResponse(true, "found in cache");
                return;
            }
            listEntryArray2 = this.mBrowserState.getBrowseFolder();
            if (this.mBrowserState.getBrowseMode() == 1 && listEntryArray2 != null && listEntryArray2.length == 1 && n != 0 && (listEntryArray3 = this.getPathData().getDBLPath(n)) != null && listEntryArray3.length >= 2) {
                this.mRequestedListEntryAnswer = new ExtendedListEntry(this.mBrowserState.getBrowseMedia(), listEntryArray3[1], 0);
                this.fireResponse(true, "found in prefetched path Data");
                return;
            }
            if (bl) {
                this.fireResponse(true, "Nothing found in cache and no fetching of player ids from e.g. BT or iPod in jogger/mix mode!");
            } else {
                this.mRequestedListEntryEntryId = l;
                this.mRequestedListEntryContentType = n;
                this.mRequestedListEntryIndex = n2;
                this.getDSI().requestList(l, n, n2, l == 0L ? 1 : 0);
            }
        }
    }

    private void detectResponseListEntry(ListEntry[] listEntryArray, int n) {
        if (this.isRegisteredForResponse(RT_LIST_ENTRY)) {
            if (Util.isNullOrEmpty(listEntryArray)) {
                this.fireResponse(false, "listEntryNotFound");
                return;
            }
            if (this.mRequestedListEntryEntryId == 0L && this.mRequestedListEntryContentType == 0) {
                int n2 = this.mRequestedListEntryIndex - n;
                if (n2 >= 0 && n2 < listEntryArray.length) {
                    this.mRequestedListEntryAnswer = new ExtendedListEntry(this.getBrowseMedia(), listEntryArray[n2], n + n2);
                    this.fireResponse(true);
                    return;
                }
            } else {
                for (int i2 = 0; i2 < listEntryArray.length; ++i2) {
                    if (listEntryArray[i2].entryID != this.mRequestedListEntryEntryId || listEntryArray[i2].contentType != this.mRequestedListEntryContentType) continue;
                    this.mRequestedListEntryAnswer = new ExtendedListEntry(this.getBrowseMedia(), listEntryArray[i2], n + i2);
                    this.fireResponse(true);
                    return;
                }
            }
        }
    }

    @Override
    public ExtendedListEntry getRequestedListEntry() {
        return this.mRequestedListEntryAnswer;
    }

    @Override
    public void setFocusedElement(ExtendedListEntry extendedListEntry) {
        this.mBrowserState.setFocusedElementEntry(extendedListEntry);
    }

    public void rqPickList(long[] lArray, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_PICK_LIST, responseHandler)) {
            this.mPickList = null;
            this.getDSI().requestPickList(lArray);
        }
    }

    public void dsiMediaBrowserResponsePickList(ListEntry[] listEntryArray) {
        if (this.isRegisteredForResponse(RT_PICK_LIST)) {
            this.mPickList = listEntryArray;
            this.fireResponse(true);
        }
    }

    public ListEntry[] getRequestedPickList() {
        return this.mPickList;
    }

    public void rqFillPathData(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_FILL_ROOT_FOLDER_INFO, responseHandler)) {
            Object[] objectArray = this.getBrowseFolder();
            int n = this.getListSize();
            if (Util.isNullOrEmpty(objectArray)) {
                this.fireResponse(false, "browseFolder must not be null or empty");
                return;
            }
            if (this.getBrowseMode() == 0) {
                this.getPathData().updateRawPathData((ListEntry)objectArray[0]);
                this.fireResponse(true);
            } else {
                if (objectArray.length != 1) {
                    this.fireResponse(false, "browseFolder must be root");
                    return;
                }
                if (n <= 0) {
                    this.fireResponse(false, "browseFolderListSize must be >= 0");
                    return;
                }
                this.getDSI().requestList(0L, 0, 0, this.getListSize());
            }
        }
    }

    private void detectFillPathDataResponse(ListEntry[] listEntryArray, int n) {
        if (this.isRegisteredForResponse(RT_FILL_ROOT_FOLDER_INFO) && this.getBrowseMode() == 1 && this.getBrowseFolder().length == 1 && listEntryArray != null) {
            this.getPathData().updateDblPathData(this.getBrowseFolder()[0], listEntryArray);
            this.fireResponse(true);
        }
    }

    public ListEntry[] getStandardDblPath(int n) {
        return this.getPathData().getDBLPath(n);
    }

    private void setSelection(Selection selection) {
        this.mBrowserState.setSelection(selection);
    }

    public Selection getSelection() {
        return this.mBrowserState.getSelection();
    }

    public Selection createResetSelection() {
        int n = this.getInstanceId();
        String string = this.getBrowseMedia().getUniqueMediaID();
        return new Selection(PlayMode.UNKNOWN, n, string, null, false, false, false, -1);
    }

    public Selection createEntrySelection(PlayMode playMode, ListEntry listEntry, boolean bl, boolean bl2) {
        int n = this.getInstanceId();
        String string = this.getBrowseMedia().getUniqueMediaID();
        ListEntry[] listEntryArray = this.getListEntryPath(this.getBrowseFolder(), listEntry);
        return new Selection(playMode, n, string, listEntryArray, bl, true, bl2, 3);
    }

    public Selection createFolderSelection(PlayMode playMode, boolean bl, boolean bl2, boolean bl3) {
        int n = this.getInstanceId();
        String string = this.getBrowseMedia().getUniqueMediaID();
        ListEntry[] listEntryArray = this.getBrowseFolder();
        return new Selection(playMode, n, string, listEntryArray, bl, bl2, bl3, 2);
    }

    @Override
    public Selection createDefaultSelection() {
        return this.createDefaultSelection(PlayMode.DUMMY_PLAY_DEFAULT, false, false);
    }

    public Selection createDefaultSelection(PlayMode playMode, boolean bl, boolean bl2) {
        int n = this.getInstanceId();
        String string = this.getBrowseMedia().getUniqueMediaID();
        ListEntry[] listEntryArray = this.getMaximumSelectionPath(bl, bl2);
        return new Selection(playMode, n, string, listEntryArray, true, true, false, 1);
    }

    @Override
    public Selection createPlaySimilarSelection(PlayMode playMode, EntryInfo entryInfo) {
        int n = this.getInstanceId();
        String string = this.getBrowseMedia().getUniqueMediaID();
        boolean bl = entryInfo != null && entryInfo.contentType == 2;
        int n2 = bl ? 8 : 15;
        ListEntry[] listEntryArray = this.getPathData().getDBLPath(n2);
        return new Selection(playMode, n, string, listEntryArray, true, true, false, 4);
    }

    protected ListEntry[] getMaximumSelectionPath(boolean bl, boolean bl2) {
        Object[] objectArray = null;
        Object[] objectArray2 = this.getBrowseFolder();
        int n = this.getBrowseMode();
        if (!Util.isNullOrEmpty(objectArray2)) {
            objectArray = bl2 || !bl && MediaBrowserHelper.isFolderSpecificSelectionRequired((ListEntry[])objectArray2) ? objectArray2 : (n == 0 ? new ListEntry[]{objectArray2[0]} : (objectArray2.length >= 2 && ((ListEntry)objectArray2[1]).getContentType() != 6 ? new ListEntry[]{objectArray2[0], objectArray2[1]} : this.getPathData().getDBLPath(13)));
        }
        return objectArray;
    }

    @Override
    public void rqAddSelection(Selection selection, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SET_SELECTION, responseHandler)) {
            if (this.getDSI() == null) {
                this.error(new StringBuffer().append(this.getBrowserName()).append(" ~ rqSelect() failed: DSI must not be null").toString());
                this.fireResponse(false, RT_SET_SELECTION);
                return;
            }
            if (selection == null) {
                this.error(new StringBuffer().append(this.getBrowserName()).append(" ~ rqSelect() failed: invalid selection").toString());
                this.fireResponse(false, RT_SET_SELECTION);
                return;
            }
            this.mRequestedSelection = selection;
            if (selection.isComposite()) {
                this.executeSelection(selection);
            } else {
                this.mExecuteSelectionAfterReset = true;
                this.getDSI().resetSelection();
            }
        }
    }

    private void executeSelection(Selection selection) {
        Object[] objectArray = selection.getSelectionPath();
        if (Util.isNullOrEmpty(objectArray)) {
            this.getDSI().resetSelection();
        } else {
            this.getDSI().enableRecurseSubdirectories(selection.isRecursive());
            if (!MediaBrowserHelper.isSameFolder((ListEntry[])objectArray, this.getBrowseFolder()) || IMediaConstants.ESO && this.getBrowseMedia().isBT()) {
                Object object = objectArray[objectArray.length - 1];
                this.getDSI().addSelection(selection.isSelected(), 0, ((ListEntry)object).getEntryID(), ((ListEntry)object).getContentType(), false);
            } else {
                this.getDSI().addSelection(selection.isSelected(), 1, 0L, 0, false);
            }
        }
    }

    public void dsiMediaBrowserSelectionResult(int n, int n2, boolean bl, long l, long l2, long l3, long l4, long l5) {
        if (this.isRegisteredForResponse(RT_SET_SELECTION)) {
            if (this.mExecuteSelectionAfterReset) {
                this.mExecuteSelectionAfterReset = false;
                if (n == 0 && l4 == 0L) {
                    this.executeSelection(this.mRequestedSelection);
                } else {
                    this.setSelection(null);
                    this.mRequestedSelection = null;
                    this.fireResponse(false);
                }
                return;
            }
            this.mRequestedSelection.setSelectionResult(n, n2, l, l2, l3, l4, l5);
            this.setSelection(this.mRequestedSelection);
            this.mRequestedSelection = null;
            this.fireResponse(n == 0, RT_SET_SELECTION, new StringBuffer().append("selection: ").append(this.getSelection()).toString());
        }
    }

    public void dsiMediaBrowserAsyncException(int n, String string, int n2) {
        if (n2 == 1001) {
            if (this.isRegisteredForResponse(RT_SET_SELECTION)) {
                this.setSelection(null);
                this.mRequestedSelection = null;
                this.fireResponse(false, new StringBuffer().append("dsiAddSelection async: ").append(string).toString());
            }
        } else if (n2 == 1008) {
            if (this.isRegisteredForResponse(RT_LIST_ENTRY)) {
                this.setFocusedElement(null);
                this.fireResponse(false, new StringBuffer().append("dsiRequestList async: ").append(string).toString());
            }
            if (this.isRegisteredForResponse(RT_LIST)) {
                this.mLastListResponse = null;
                this.fireResponse(false, new StringBuffer().append("dsiRequestList async: ").append(string).toString());
            }
        } else if (n2 == 1007) {
            if (this.isRegisteredForResponse(RT_OPEN_FOLDER)) {
                this.fireResponse(false, new StringBuffer().append("dsiChangeFolder async: ").append(string).toString());
            }
        } else if (n2 == 1006) {
            if (this.isRegisteredForResponse(RT_SET_BROWSE_MEDIA)) {
                this.fireResponse(false, new StringBuffer().append("dsiSetBrowseMedia async: ").append(string).toString());
            }
        } else if (n2 == 1005) {
            if (this.isRegisteredForResponse(RT_SET_BROWSE_MODE)) {
                this.fireResponse(false, new StringBuffer().append("dsiSetBrowseMode async: ").append(string).toString());
            }
        } else if (n2 == 1004 && this.isRegisteredForResponse(RT_SET_CONTENT_FILTER)) {
            this.fireResponse(false, new StringBuffer().append("dsiSetContentFilter async: ").append(string).toString());
        }
    }

    @Override
    public MediaBrowserState getState() {
        return this.mBrowserState;
    }

    public MediaCollector getBrowseMedia() {
        return this.mBrowserState.getBrowseMedia();
    }

    public int getBrowseMode() {
        return this.mBrowserState.getBrowseMode();
    }

    private void setBrowseMode(int n) {
        this.mBrowserState.setBrowsedMode(n);
    }

    public boolean isInContentMode() {
        return this.getBrowseMode() == 1;
    }

    public boolean isInRawMode() {
        return this.getBrowseMode() == 0;
    }

    public int getContentFilter() {
        return this.mBrowserState.getContentFilter();
    }

    private void setContentFilter(int n) {
        this.mBrowserState.setContentFilter(n);
    }

    @Override
    public ListEntry[] getBrowseFolder() {
        return this.mBrowserState.getBrowseFolder();
    }

    private void setActiveFolder(ListEntry[] listEntryArray) {
        this.mBrowserState.setBrowseFolder(listEntryArray);
    }

    public int getListState() {
        return this.mBrowserState.getListState();
    }

    @Override
    public void setListState(int n) {
        this.mBrowserState.setListState(n);
    }

    public int getModeSwitchingState() {
        return this.mBrowserState.getModeSwitchingState();
    }

    public void setModeSwitchingState(int n) {
        this.mBrowserState.setModeSwitchingState(n);
    }

    @Override
    public boolean isBrowsingAvailable() {
        return this.mBrowserState.isBrowsingAvailable();
    }

    public void setInitState(int n) {
        this.mBrowserState.setInitState(n);
    }

    public int getMatchingBrowseMode(MediaPlayer mediaPlayer) {
        return MediaBrowserHelper.getBrowseMode(mediaPlayer.getPlaySelection());
    }

    @Override
    public ListEntry[] getMatchingBrowseFolder(MediaPlayer mediaPlayer) {
        return mediaPlayer.getPlayerState().getPlaybackPath();
    }

    @Override
    public ListEntry getMatchingBrowseEntry(MediaPlayer mediaPlayer) {
        return mediaPlayer.getActiveTrack();
    }

    @Override
    public BrowserPathData getPathData() {
        return this.getState().getPathData();
    }

    public ListEntry[] getListEntryPath(ListEntry[] listEntryArray, ListEntry listEntry) {
        if (listEntry != null) {
            ListEntry[] listEntryArray2 = new ListEntry[listEntryArray.length + 1];
            System.arraycopy((Object)listEntryArray, 0, (Object)listEntryArray2, 0, listEntryArray.length);
            listEntryArray2[listEntryArray2.length - 1] = listEntry;
            return listEntryArray2;
        }
        return null;
    }

    @Override
    public int getListSize() {
        return this.mBrowserState.getListSize();
    }

    @Override
    public MediaBrowserListHandler getListHandler() {
        return this.mListHandler;
    }

    @Override
    public ListEntry[] getAbsolutePathByListEntry(ListEntry listEntry) {
        return this.getListEntryPath(this.getBrowseFolder(), listEntry);
    }

    public void triggerErrorTextFor(ListEntry listEntry) {
        if (this.mListHandler != null) {
            this.mListHandler.showErrorInformation(listEntry);
        }
    }

    public ExtendedListEntry getListEntryInCache(long l, int n, int n2, String string) {
        if (this.mListHandler == null) {
            return null;
        }
        ExtendedListEntry extendedListEntry = null;
        extendedListEntry = l == 0L && n == 0 && n2 >= 0 ? this.mListHandler.getListEntryByIndex(n2) : this.mListHandler.getListEntryById(l, n);
        if (extendedListEntry == null && !Util.isNullOrEmpty(string)) {
            extendedListEntry = this.mListHandler.getListEntryByTitle(string);
        }
        return extendedListEntry;
    }

    public boolean isSetupRequired(MediaCollector mediaCollector, int n) {
        MediaCollector mediaCollector2 = this.getInternalMedia(mediaCollector, n);
        boolean bl = this.mBrowserState.getBrowseMedia() != mediaCollector || this.mInternalMedia != mediaCollector2;
        boolean bl2 = this.mInternalMedia != MediaCollector.EMPTY && this.mBrowserState.getBrowseMode() != n;
        boolean bl3 = this.mBrowserState.getInitState() == 2 || this.mBrowserState.getInitState() == 1;
        return bl || bl2 || !bl3;
    }

    private MediaCollector getInternalMedia(MediaCollector mediaCollector, int n) {
        if (mediaCollector == null) {
            return MediaCollector.EMPTY;
        }
        boolean bl = true;
        boolean bl2 = this.getInstanceId() == 7 && n == 1 ? mediaCollector.isDeletePossible() : mediaCollector.isMediaBrowsable();
        return bl2 && mediaCollector.supports(n) ? mediaCollector : MediaCollector.EMPTY;
    }

    public boolean isSetBrowseMediaNeeded(MediaCollector mediaCollector, int n) {
        return this.mInternalMedia != this.getInternalMedia(mediaCollector, n) || this.getBrowseMedia() != mediaCollector;
    }
}

