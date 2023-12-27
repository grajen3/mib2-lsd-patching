/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser.headunit;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserHelper;
import de.vw.mib.asl.internal.media.browser.MediaBrowserSearchHandler;
import de.vw.mib.asl.internal.media.browser.MediaBrowserSearchHandler$MediaSearchElementFetcher;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import de.vw.mib.asl.internal.media.clients.browser.AbstractGenericAslListHandler;
import de.vw.mib.asl.internal.media.clients.browser.SharedFolderPath;
import de.vw.mib.asl.internal.media.clients.browser.SharedListMapper;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadUnitBrowserListHandler$1;
import de.vw.mib.asl.internal.media.clients.browser.headunit.HeadunitBrowserPlaymodeState;
import de.vw.mib.asl.internal.media.common.MediaTimer;
import de.vw.mib.asl.internal.media.playback.MediaPlayerState;
import de.vw.mib.collections.longs.LongOptHashSet;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.CharacterInfo;
import org.dsi.ifc.media.ListEntry;

public class HeadUnitBrowserListHandler
extends AbstractGenericAslListHandler
implements MediaBrowserSearchHandler {
    private final SharedListMapper mSharedListMapper;
    private final SharedFolderPath mSharedFolderPath;
    private GenericASLList mConnectedList = null;
    private MediaBrowserState mBrowserState = null;
    private MediaPlayerState mPlayerState = null;
    private int mListSize = 0;
    private int mSearchSize = 0;
    private boolean pendingGoingBackToSearchResults = false;
    private static final int SHOW_ERROR_TEXT_TIMEOUT;
    protected static LongOptHashSet mErrorTextIdsToDisplay;
    private final MediaTimer mErrorTextTimer = new MediaTimer(new HeadUnitBrowserListHandler$1(this), 2000, "disable_error_text");
    private static final SpellerData EMPTY_SPELLER;
    private SpellerData mSpellerData;
    private MediaBrowserSearchHandler$MediaSearchElementFetcher mSearchFetcher = null;
    private boolean mSearchEnabled = false;
    private boolean mSearchVisible = false;

    public HeadUnitBrowserListHandler(SharedListMapper sharedListMapper, SharedFolderPath sharedFolderPath) {
        this.mSharedListMapper = sharedListMapper;
        this.mSharedFolderPath = sharedFolderPath;
        DATA_POOL.valueChangedSpellerData(108, EMPTY_SPELLER);
    }

    @Override
    public void onFolderPathChanged(MediaBrowserState mediaBrowserState) {
        this.mBrowserState = mediaBrowserState;
        this.mConnectedList = this.mSharedListMapper.getMatchingList(this, mediaBrowserState);
        this.mSharedFolderPath.update(mediaBrowserState);
        if (this.pendingGoingBackToSearchResults) {
            this.mConnectedList.setSize(0);
            this.mConnectedList.setSize(this.mSearchSize);
        }
        DATA_POOL.valueChangedBoolean(4112, false);
    }

    @Override
    public GenericASLList getList() {
        return this.mConnectedList;
    }

    public void onPlaybackEntryChanged(MediaPlayerState mediaPlayerState) {
        this.mPlayerState = mediaPlayerState;
        this.updateListCache();
    }

    @Override
    public void updateListData(CharacterInfo[] characterInfoArray) {
        super.updateListData(characterInfoArray);
        DATA_POOL.valueChangedBoolean(4112, this.getList() != null && !Util.isNullOrEmpty(characterInfoArray));
    }

    @Override
    public void updateSearchData(ExtendedListEntry[] extendedListEntryArray, int n) {
        this.updateListData(extendedListEntryArray, n);
    }

    @Override
    protected boolean updateEntry(ExtendedListEntry extendedListEntry, boolean bl) {
        boolean bl2 = false;
        if (extendedListEntry != null && extendedListEntry.isActive != bl) {
            extendedListEntry.isActive = bl;
            bl2 = true;
        }
        return bl2;
    }

    @Override
    protected boolean isEntryActive(ExtendedListEntry extendedListEntry) {
        return MediaBrowserHelper.isActive(this.mPlayerState, this.mBrowserState, extendedListEntry);
    }

    @Override
    protected void onActiveEntryChangedInFolder(ExtendedListEntry extendedListEntry, String string) {
        int n = -1;
        if (extendedListEntry != null) {
            n = extendedListEntry.listIndex;
        }
        DATA_POOL.valueChangedInteger(79, n);
    }

    @Override
    protected void onActiveEntryChangedInCache(ExtendedListEntry extendedListEntry, String string) {
    }

    public void focusEntry(ExtendedListEntry extendedListEntry, MediaBrowserState mediaBrowserState) {
        int n = -1;
        if (extendedListEntry != null) {
            n = extendedListEntry.listIndex;
        }
        int n2 = 0;
        if (mediaBrowserState.getBrowseFolder() != null && mediaBrowserState.getBrowseFolder().length == 1 && mediaBrowserState.getBrowseMedia().supportsRawAndContentMode()) {
            ++n2;
        }
        if (mediaBrowserState.isPlayModeBarVisible()) {
            ++n2;
        }
        if (mediaBrowserState.getBrowseMode() == 1 && !Util.isNullOrEmpty(mediaBrowserState.getBrowseFolder()) && mediaBrowserState.getBrowseFolder()[mediaBrowserState.getBrowseFolder().length - 1].getContentType() == 14) {
            n2 += 2;
        }
        DATA_POOL.valueChangedInteger(81, n + n2);
        DATA_POOL.valueChangedInteger(79, n);
        GenericASLList genericASLList = this.getList();
        if (genericASLList != null) {
            genericASLList.setActiveIndex(n);
            ServiceManager.logger.trace(1024, new StringBuffer().append("FOCUSED ENTRY: ").append(n).toString());
        }
    }

    @Override
    public void showErrorInformation(ListEntry listEntry) {
        mErrorTextIdsToDisplay.add(listEntry.entryID);
        this.mErrorTextTimer.start();
        this.updateErrorTextFlagInListCache();
    }

    protected void updateErrorTextFlagInListCache() {
        GenericASLList genericASLList = this.mConnectedList;
        LongOptHashSet longOptHashSet = mErrorTextIdsToDisplay;
        if (genericASLList != null) {
            for (int i2 = 0; i2 < genericASLList.getItemCount(); ++i2) {
                boolean bl;
                ExtendedListEntry extendedListEntry;
                Object object = genericASLList.getRowItemCacheOnly(i2);
                if (!genericASLList.isValidItem(object) || extendedListEntry.showErrorText == (bl = longOptHashSet.contains((extendedListEntry = (ExtendedListEntry)object).getEntryID()))) continue;
                extendedListEntry.showErrorText = bl;
                genericASLList.updateListItem(extendedListEntry.listIndex, extendedListEntry);
            }
        }
    }

    @Override
    public void onSpellerEnter() {
        this.mSpellerData = new SpellerData();
        DATA_POOL.valueChangedSpellerData(108, this.mSpellerData);
    }

    @Override
    public void addCharacter(String string, int n, int n2, int n3) {
        String string2 = this.mSpellerData.getEnteredText();
        int n4 = this.mSpellerData.getCursorPosition();
        if (string2 == null) {
            string2 = "";
        }
        if (n4 < 0) {
            n4 = 0;
        }
        if (this.mSpellerData.isSelectionActive()) {
            int n5 = this.mSpellerData.getSelectionStart();
            int n6 = this.mSpellerData.getSelectionEnd();
            if (string2 != null && n5 < string2.length() && n6 <= string2.length()) {
                string2 = new StringBuffer().append(string2.substring(0, n5)).append(string2.substring(n6)).toString();
                n4 = n5;
            }
            this.mSpellerData.resetSelection();
        }
        string2 = new StringBuffer().append(string2.substring(0, n4)).append(string).append(string2.substring(n4)).toString();
        this.mSpellerData.setEnteredText(string2);
        this.mSpellerData.setCursorPosition(n4 += string.length());
        this.mSpellerData.setSelectionStart(n);
        this.mSpellerData.setSelectionEnd(n2);
        DATA_POOL.valueChangedSpellerData(108, this.mSpellerData);
    }

    @Override
    public void deleteCharacter() {
        String string = this.mSpellerData.getEnteredText();
        int n = this.mSpellerData.getCursorPosition();
        if (this.mSpellerData.isSelectionActive()) {
            string = new StringBuffer().append(string.substring(0, this.mSpellerData.getSelectionStart())).append(string.substring(this.mSpellerData.getSelectionEnd())).toString();
            n = this.mSpellerData.getSelectionStart();
            this.mSpellerData.resetSelection();
        } else {
            string = n == string.length() ? string.substring(0, n - 1) : new StringBuffer().append(string.substring(0, n - 1)).append(string.substring(n)).toString();
            --n;
        }
        this.mSpellerData.setEnteredText(string);
        this.mSpellerData.setCursorPosition(n);
        DATA_POOL.valueChangedSpellerData(108, this.mSpellerData);
    }

    @Override
    public void setCursorPosition(int n) {
        this.mSpellerData.resetSelection();
        this.mSpellerData.setCursorPosition(n);
        DATA_POOL.valueChangedSpellerData(108, this.mSpellerData);
    }

    @Override
    public String getEnteredText() {
        return this.mSpellerData.getEnteredText();
    }

    @Override
    public void onSpellerExit() {
    }

    @Override
    public void setFetcher(MediaBrowserSearchHandler$MediaSearchElementFetcher mediaBrowserSearchHandler$MediaSearchElementFetcher) {
        this.mSearchFetcher = mediaBrowserSearchHandler$MediaSearchElementFetcher;
    }

    @Override
    public void updateSearchSize(int n) {
        this.mSearchSize = n;
        if (this.mSpellerData != null) {
            this.mSpellerData.setMatchCount(n);
            DATA_POOL.valueChangedSpellerData(108, this.mSpellerData);
        }
    }

    @Override
    public void updateListSize(int n) {
        this.mListSize = n;
        if (this.mSearchFetcher == null || !this.mSearchVisible) {
            super.updateListSize(n);
        }
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.mSearchFetcher != null && this.mSearchVisible) {
            this.mSearchFetcher.fetchSearchItems(n, n2);
        } else {
            super.fetchItems(aSLCachedWindowList, n, n2);
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (this.mSearchFetcher != null && this.mSearchVisible) {
            this.mSearchFetcher.fetchSearchItems(n, n2);
        } else {
            super.fetchNextPage(aSLCachedWindowList, object, n, n2);
        }
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (this.mSearchFetcher != null && this.mSearchVisible) {
            this.mSearchFetcher.fetchSearchItems(n, n2);
        } else {
            super.fetchPreviousPage(aSLCachedWindowList, object, n, n2);
        }
    }

    @Override
    public void onSearchStart() {
        this.setSearchEnabled(true, true);
    }

    public void onFollowModeEnabled() {
        boolean bl = false;
        if (this.mPlayerState != null && this.mBrowserState != null) {
            bl = MediaBrowserHelper.isSameFolder(this.mPlayerState.getPlaybackPath(), this.mBrowserState.getBrowseFolder());
        }
        this.setSearchEnabled(false, bl);
    }

    public void onOpenFolder() {
        this.setSearchVisible(false, false);
    }

    public int onMoveFolderLevelUp(int n) {
        int n2;
        int n3 = 2;
        int n4 = this.mBrowserState.getBrowseFolder().length;
        int n5 = n2 = n == 0 ? n4 - 1 : n;
        if (this.mSearchEnabled) {
            int n6 = n4 - n2;
            if (n6 < 2) {
                n5 = n2 - 1;
                this.setSearchEnabled(false, n2 == 1);
            } else if (n6 > 2) {
                this.setSearchVisible(false, false);
            } else {
                this.pendingGoingBackToSearchResults = true;
                this.setSearchVisible(true, false);
            }
        }
        return n5;
    }

    private void setSearchEnabled(boolean bl, boolean bl2) {
        if (this.mSearchEnabled != bl) {
            this.mSearchEnabled = bl;
            HeadunitBrowserPlaymodeState.onSearchEnabledChanged(this.mBrowserState, this.mPlayerState, this.mSearchEnabled);
            if (!bl) {
                this.mSpellerData = EMPTY_SPELLER;
                DATA_POOL.valueChangedSpellerData(108, this.mSpellerData);
            }
            DATA_POOL.valueChangedBoolean(109, bl);
            this.mSharedFolderPath.setSearchEnabled(bl);
            this.mSharedFolderPath.update(this.mBrowserState);
            this.setSearchVisible(bl, bl2);
        }
    }

    private void setSearchVisible(boolean bl, boolean bl2) {
        if (this.mSearchVisible != bl) {
            this.mSearchVisible = bl;
            if (bl2) {
                this.mConnectedList.setSize(0);
                this.mConnectedList.setSize(bl ? this.mSearchSize : this.mListSize);
            }
        }
        if (!bl) {
            this.pendingGoingBackToSearchResults = false;
        }
    }

    public void updateActivationState(int n) {
        if (n != 3) {
            // empty if block
        }
    }

    static {
        mErrorTextIdsToDisplay = new LongOptHashSet(3);
        EMPTY_SPELLER = new SpellerData();
    }
}

