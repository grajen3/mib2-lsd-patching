/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mediacontrol.adapter.views.browser;

import de.vw.mib.asl.api.mediacontrol.services.MediaControlAPI;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlCallbackListRequest;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListEntry;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerFolderPath;
import de.vw.mib.asl.api.mediacontrol.services.browser.MediaControlListenerListSize;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.mediacontrol.adapter.views.browser.BrowserList$1;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;

public class BrowserList
implements ASLListElementFetcher,
MediaControlListenerListSize,
MediaControlListenerFolderPath {
    private static final GenericASLList BROWSER_LIST = ListManager.getGenericASLList(-1138731264);
    final MediaControlAPI mMediaControlAPI;
    private MediaControlListEntry[] mFolderPath;
    private final MediaControlCallbackListRequest mListRequestCallback = new BrowserList$1(this);

    public BrowserList(MediaControlAPI mediaControlAPI) {
        this.mMediaControlAPI = mediaControlAPI;
        this.registerList(BROWSER_LIST);
        this.mMediaControlAPI.getBrowserService().addListSizeListener(this);
        this.mMediaControlAPI.getBrowserService().addFolderPathListener(this);
    }

    protected void registerList(GenericASLList genericASLList) {
        int n = 0;
        int n2 = 10;
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, n2, n);
        genericASLList.setColumn4ObjectId(4);
    }

    @Override
    public void updateListSize(int n) {
        BROWSER_LIST.setSizeClearCache(n);
    }

    @Override
    public void updateFolderPath(MediaControlListEntry[] mediaControlListEntryArray) {
        this.mFolderPath = mediaControlListEntryArray;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        this.mMediaControlAPI.getBrowserService().requestList(n, n2, this.mListRequestCallback);
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.mMediaControlAPI.getBrowserService().requestList(n, n2, this.mListRequestCallback);
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.mMediaControlAPI.getBrowserService().requestList(n, n2, this.mListRequestCallback);
    }

    private int getBrowserContentType(int n, MediaControlListEntry[] mediaControlListEntryArray, String string) {
        int n2 = 0;
        if (string != null) {
            if (string.equals("filterCriteria.unknownGenre") || string.equals("filterCriteria.unknownGenres")) {
                return 30;
            }
            if (string.equals("filterCriteria.unknownArtist") || string.equals("filterCriteria.unknownArtists")) {
                return 26;
            }
            if (string.equals("filterCriteria.unknownAlbum") || string.equals("filterCriteria.unknownAlbums")) {
                return 28;
            }
        }
        if (!Util.isNullOrEmpty(mediaControlListEntryArray)) {
            switch (n) {
                case 0: {
                    n2 = 0;
                    break;
                }
                case 1: {
                    if (string != null && (string.equals("filterCriteria.unknownTitle") || string.equals("filterCriteria.unknownSong"))) {
                        n2 = 24;
                        break;
                    }
                    n2 = 1;
                    break;
                }
                case 2: {
                    if (string != null && (string.equals("filterCriteria.unknownTitle") || string.equals("filterCriteria.unknownSong"))) {
                        n2 = 25;
                        break;
                    }
                    n2 = 2;
                    break;
                }
                case 3: {
                    n2 = 3;
                    break;
                }
                case 4: {
                    n2 = 4;
                    break;
                }
                case 5: {
                    n2 = 5;
                    break;
                }
                case 6: {
                    n2 = 6;
                    break;
                }
                case 7: {
                    n2 = 7;
                    break;
                }
                case 8: {
                    n2 = 8;
                    break;
                }
                case 9: {
                    n2 = 9;
                    break;
                }
                case 10: {
                    n2 = 10;
                    break;
                }
                case 11: {
                    n2 = 11;
                    break;
                }
                case 12: {
                    n2 = 12;
                    break;
                }
                case 13: {
                    if (mediaControlListEntryArray.length == 2) {
                        n2 = 13;
                        break;
                    }
                    n2 = 27;
                    break;
                }
                case 14: {
                    if (mediaControlListEntryArray.length == 2) {
                        n2 = 14;
                        break;
                    }
                    n2 = 29;
                    break;
                }
                case 16: {
                    if (mediaControlListEntryArray.length == 2) {
                        n2 = 16;
                        break;
                    }
                    n2 = 31;
                    break;
                }
                case 15: {
                    n2 = 15;
                    break;
                }
                case 17: {
                    n2 = 17;
                    break;
                }
                case 18: {
                    n2 = 18;
                    break;
                }
                case 19: {
                    n2 = 19;
                    break;
                }
                case 20: {
                    n2 = 20;
                    break;
                }
                case 21: {
                    n2 = 21;
                    break;
                }
                case 22: {
                    n2 = 22;
                    break;
                }
                default: {
                    n2 = 0;
                }
            }
        }
        return n2;
    }

    static /* synthetic */ MediaControlListEntry[] access$000(BrowserList browserList) {
        return browserList.mFolderPath;
    }

    static /* synthetic */ int access$100(BrowserList browserList, int n, MediaControlListEntry[] mediaControlListEntryArray, String string) {
        return browserList.getBrowserContentType(n, mediaControlListEntryArray, string);
    }

    static /* synthetic */ GenericASLList access$200() {
        return BROWSER_LIST;
    }
}

