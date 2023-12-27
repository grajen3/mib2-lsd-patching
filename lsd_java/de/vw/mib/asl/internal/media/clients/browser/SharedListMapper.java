/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.clients.browser;

import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.media.browser.MediaBrowserState;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.media.ListEntry;

public class SharedListMapper
implements ASLListElementFetcher {
    private static final GenericASLList RAW_BROWSER_LIST = ListManager.getGenericASLList(3649);
    private static final GenericASLList DBL_ROOT_LIST = ListManager.getGenericASLList(3555);
    private static final GenericASLList DBL_TITLE_LIST = ListManager.getGenericASLList(3650);
    private static final GenericASLList DBL_ALBUM_LIST = ListManager.getGenericASLList(3648);
    private static final GenericASLList DBL_ARTIST_LIST = ListManager.getGenericASLList(99);
    private static final GenericASLList DBL_GENRE_LIST = ListManager.getGenericASLList(102);
    private static final GenericASLList DBL_VIDEO_LIST = ListManager.getGenericASLList(3651);
    private static final GenericASLList DBL_NOT_PLAYABLE_LIST = ListManager.getGenericASLList(2588);
    private static ASLListElementFetcher mConnectedFetcher = null;

    public SharedListMapper() {
        this.registerList(RAW_BROWSER_LIST);
        this.registerList(DBL_ROOT_LIST);
        this.registerList(DBL_TITLE_LIST);
        this.registerList(DBL_ALBUM_LIST);
        this.registerList(DBL_ARTIST_LIST);
        this.registerList(DBL_GENRE_LIST);
        this.registerList(DBL_VIDEO_LIST);
        this.registerList(DBL_NOT_PLAYABLE_LIST);
    }

    private void registerList(GenericASLList genericASLList) {
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 10, 0);
        genericASLList.setColumn4ObjectId(-2);
        genericASLList.setFetchTimeout(0);
    }

    private void clear() {
        RAW_BROWSER_LIST.clear();
        DBL_ROOT_LIST.clear();
        DBL_TITLE_LIST.clear();
        DBL_ALBUM_LIST.clear();
        DBL_ARTIST_LIST.clear();
        DBL_GENRE_LIST.clear();
        DBL_VIDEO_LIST.clear();
        DBL_NOT_PLAYABLE_LIST.clear();
    }

    public GenericASLList getMatchingList(ASLListElementFetcher aSLListElementFetcher, MediaBrowserState mediaBrowserState) {
        this.clear();
        this.fetchFrom(aSLListElementFetcher);
        GenericASLList genericASLList = null;
        ListEntry[] listEntryArray = null;
        int n = -1;
        if (mediaBrowserState != null) {
            listEntryArray = mediaBrowserState.getBrowseFolder();
            n = mediaBrowserState.getBrowseMode();
        }
        if (listEntryArray != null && listEntryArray.length > 0 && n != -1) {
            if (n == 0) {
                genericASLList = RAW_BROWSER_LIST;
            } else {
                block0 : switch (listEntryArray.length) {
                    case 1: {
                        genericASLList = DBL_ROOT_LIST;
                        break;
                    }
                    case 2: {
                        switch (listEntryArray[1].getContentType()) {
                            case 16: {
                                genericASLList = DBL_GENRE_LIST;
                                break block0;
                            }
                            case 13: {
                                genericASLList = DBL_ARTIST_LIST;
                                break block0;
                            }
                            case 14: {
                                genericASLList = DBL_ALBUM_LIST;
                                break block0;
                            }
                            case 15: {
                                genericASLList = DBL_TITLE_LIST;
                                break block0;
                            }
                            case 6: {
                                genericASLList = DBL_TITLE_LIST;
                                break block0;
                            }
                            case 8: {
                                genericASLList = DBL_VIDEO_LIST;
                                break block0;
                            }
                            case 19: {
                                genericASLList = DBL_NOT_PLAYABLE_LIST;
                                break block0;
                            }
                        }
                        break;
                    }
                    case 3: {
                        switch (listEntryArray[1].getContentType()) {
                            case 14: {
                                genericASLList = DBL_TITLE_LIST;
                                break block0;
                            }
                            case 13: {
                                genericASLList = DBL_ALBUM_LIST;
                                break block0;
                            }
                            case 16: {
                                genericASLList = DBL_ARTIST_LIST;
                                break block0;
                            }
                            case 6: {
                                genericASLList = DBL_TITLE_LIST;
                                break block0;
                            }
                        }
                        break;
                    }
                    case 4: {
                        switch (listEntryArray[1].getContentType()) {
                            case 13: {
                                genericASLList = DBL_TITLE_LIST;
                                break block0;
                            }
                            case 16: {
                                genericASLList = DBL_ALBUM_LIST;
                                break block0;
                            }
                        }
                        break;
                    }
                    case 5: {
                        genericASLList = DBL_TITLE_LIST;
                        break;
                    }
                }
            }
        }
        return genericASLList;
    }

    private void fetchFrom(ASLListElementFetcher aSLListElementFetcher) {
        mConnectedFetcher = aSLListElementFetcher;
    }

    public ASLListElementFetcher getCurrentFetcher() {
        return mConnectedFetcher;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (mConnectedFetcher != null) {
            mConnectedFetcher.fetchItems(aSLCachedWindowList, n, n2);
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (mConnectedFetcher != null) {
            mConnectedFetcher.fetchNextPage(aSLCachedWindowList, object, n, n2);
        }
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        if (mConnectedFetcher != null) {
            mConnectedFetcher.fetchPreviousPage(aSLCachedWindowList, object, n, n2);
        }
    }
}

