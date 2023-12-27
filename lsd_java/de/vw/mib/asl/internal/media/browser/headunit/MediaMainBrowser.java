/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.browser.headunit;

import de.vw.mib.asl.internal.avdc.audio.browser.transformer.ExtendedListEntry;
import de.vw.mib.asl.internal.media.browser.AbstractMediaBrowser;
import de.vw.mib.asl.internal.media.browser.MediaBrowserSearchHandler;
import de.vw.mib.asl.internal.media.browser.MediaBrowserSearchHandler$MediaSearchElementFetcher;
import de.vw.mib.asl.internal.media.browser.headunit.MediaMainBrowser$1;
import de.vw.mib.asl.internal.media.common.ResponseHandler;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.util.Util;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.SearchListEntryExt;

public class MediaMainBrowser
extends AbstractMediaBrowser {
    private static final int RT_ACTIVATE_SEARCH = MediaMainBrowser.assignRequestId();
    private static final int RT_DEACTIVATE_SEARCH = MediaMainBrowser.assignRequestId();
    private static final int RT_SEARCH_SET_CHAR = MediaMainBrowser.assignRequestId();
    private MediaBrowserSearchHandler mSearchHandler = null;
    private final MediaBrowserSearchHandler$MediaSearchElementFetcher mSearchFetcher = new MediaMainBrowser$1(this);

    public void registerSearchHandler(MediaBrowserSearchHandler mediaBrowserSearchHandler) {
        mediaBrowserSearchHandler.setFetcher(this.mSearchFetcher);
        this.mSearchHandler = mediaBrowserSearchHandler;
    }

    public MediaMainBrowser(GenericEvents genericEvents, String string, int n) {
        super(genericEvents, string, n);
    }

    @Override
    public int getDefaultTargetId() {
        return 397349632;
    }

    public void rqActivateSearchSpeller(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_ACTIVATE_SEARCH, responseHandler)) {
            this.getDSI().deactivateSearchSpeller();
            this.getDSI().activateSearchSpeller();
            this.getDSI().setSearchCriteria(this.getSearchCriteria(this.getBrowseFolder()));
            this.mSearchHandler.onSpellerEnter();
        }
    }

    public void rqDeactivateSearchSpeller(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_DEACTIVATE_SEARCH, responseHandler)) {
            this.mSearchHandler.onSpellerExit();
            this.fireResponse(true);
        }
    }

    private int getSearchCriteria(ListEntry[] listEntryArray) {
        if (!Util.isNullOrEmpty(listEntryArray) && listEntryArray.length > 1) {
            switch (listEntryArray[1].getContentType()) {
                case 13: {
                    return 2;
                }
                case 14: {
                    return 1;
                }
                case 15: {
                    return 4;
                }
            }
            throw new IllegalStateException("Search not permitted when not in artists, album or title root!");
        }
        throw new IllegalStateException("Search not permitted when not in artists, album or title root!");
    }

    public void dsiMediaBrowserUpdateSearchSpellerState(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        if (this.isRegisteredForResponse(RT_ACTIVATE_SEARCH) && n == 2) {
            this.getDSI().resetSearchString();
            this.getDSI().setSearchString("");
            this.fireResponse(true);
        }
        if (this.isRegisteredForResponse(RT_DEACTIVATE_SEARCH) && n == 0) {
            this.fireResponse(true);
        }
        if (this.isRegisteredForResponse(RT_SEARCH_SET_CHAR) && n == 2) {
            this.fireResponse(true);
        }
    }

    public void setCursorPosition(int n) {
        this.mSearchHandler.setCursorPosition(n);
    }

    public void rqAddChar(String string, int n, int n2, int n3, ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SEARCH_SET_CHAR, responseHandler)) {
            this.mSearchHandler.addCharacter(string, n, n2, n3);
            this.getDSI().setSearchString(this.mSearchHandler.getEnteredText());
        }
    }

    public void rqDeleteChar(ResponseHandler responseHandler) {
        if (this.registerForResponse(RT_SEARCH_SET_CHAR, responseHandler)) {
            this.mSearchHandler.deleteCharacter();
            this.getDSI().setSearchString(this.mSearchHandler.getEnteredText());
        }
    }

    public void executeSearch() {
        this.mSearchHandler.onSearchStart();
    }

    public void dsiMediaBrowserUpdateSearchSize(int n, int n2, int n3, int n4, int n5) {
        if (this.mSearchHandler != null) {
            this.mSearchHandler.updateSearchSize(n);
        }
    }

    public void dsiMediaBrowserResponseSearchListExt(SearchListEntryExt[] searchListEntryExtArray, int n) {
        if (this.mSearchHandler != null) {
            ExtendedListEntry[] extendedListEntryArray = new ExtendedListEntry[searchListEntryExtArray.length];
            for (int i2 = 0; i2 < searchListEntryExtArray.length; ++i2) {
                extendedListEntryArray[i2] = new ExtendedListEntry(this.getBrowseMedia(), searchListEntryExtArray[i2], n + i2);
            }
            this.mSearchHandler.updateSearchData(extendedListEntryArray, n);
        }
    }

    @Override
    public int getComponentId() {
        return 32;
    }
}

