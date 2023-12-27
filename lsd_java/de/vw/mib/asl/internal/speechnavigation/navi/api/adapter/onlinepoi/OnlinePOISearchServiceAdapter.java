/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiListenerAdapter;
import de.vw.mib.asl.api.navigation.poi.online.NavigationOnlinePoiService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi.OnlinePOIService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi.listener.SearchOnlinePOIListener;

public class OnlinePOISearchServiceAdapter
extends NavigationOnlinePoiListenerAdapter
implements OnlinePOIService {
    private String logPrefix = "[SN][OnlinePOI][NavigationOnlinePoiListenerAdapter] ";
    private final NavigationOnlinePoiService externalInterface = ASLNavigationFactory.getNavigationApi().getNavigationOnlinePoiService(this);
    private final SearchOnlinePOIListener internalHandler;
    public static final int BLOCKSIZE;
    private boolean searchActive;
    private boolean searchContinued;
    private boolean searchFailed;
    private boolean hasLock;
    private int totalElementCount;
    private int receivedElementsCount;

    public OnlinePOISearchServiceAdapter(SearchOnlinePOIListener searchOnlinePOIListener) {
        this.internalHandler = searchOnlinePOIListener;
        this.internalHandler.onRegistered(this);
    }

    private void handleException(NavigationServiceException navigationServiceException) {
        AppLogger.error(new StringBuffer().append(this.logPrefix).append("error during online POI search: ").append(navigationServiceException.getMessage()).toString());
        this.searchFailed = true;
        this.internalHandler.onErrorDuringSearch(0);
    }

    @Override
    public boolean isServiceReady() {
        return this.externalInterface.isServiceReady();
    }

    @Override
    public void prepareForSearch() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Preparing for search.").toString());
        try {
            if (!this.hasLock) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("No lock yet, trying to get the lock.").toString());
                this.externalInterface.weakLockInput();
            } else {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Lock already granted.").toString());
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            this.handleException(navigationServiceException);
        }
    }

    @Override
    public void startSearch() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Starting the search.").toString());
        this.searchActive = true;
        this.searchFailed = false;
        this.searchContinued = false;
        this.totalElementCount = 0;
        this.receivedElementsCount = 0;
        try {
            if (this.hasLock) {
                this.externalInterface.startVoicePoiSearch();
            } else {
                AppLogger.warn(new StringBuffer().append(this.logPrefix).append("Starting search without lock is not possible, please prepare the search first.").toString());
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            this.handleException(navigationServiceException);
        }
    }

    @Override
    public void getNextEntries() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Getting next entries.").toString());
        if (!this.hasLock) {
            AppLogger.error(new StringBuffer().append(this.logPrefix).append("Not possible to get further results without lock.").toString());
        } else if (!this.searchActive) {
            AppLogger.error(new StringBuffer().append(this.logPrefix).append("No search active, please prepare and start a search before asking for further results.").toString());
        } else {
            this.searchContinued = true;
            try {
                if (this.receivedElementsCount < this.totalElementCount) {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Retrieving further results.").toString());
                    this.externalInterface.getValueListBlock(this.receivedElementsCount, 10);
                } else {
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("There are no further results available.").toString());
                    this.internalHandler.onErrorDuringSearch(5);
                }
            }
            catch (NavigationServiceException navigationServiceException) {
                this.handleException(navigationServiceException);
            }
        }
    }

    @Override
    public void stopSearch() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Stopping search in case a search was active.").toString());
        try {
            this.searchActive = false;
            if (this.hasLock && !this.searchContinued) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("As defined in sequence stop search as an alternative to asking for further results.").toString());
                this.externalInterface.stopPoiSearch();
            }
            if (this.hasLock) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Releasing the lock.").toString());
                this.externalInterface.unlockInput();
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            this.handleException(navigationServiceException);
        }
    }

    @Override
    public boolean hasOnlyOneEntry() {
        return this.totalElementCount == 1;
    }

    @Override
    public boolean hasMoreEntries() {
        return this.totalElementCount != this.receivedElementsCount;
    }

    @Override
    public boolean isFirstSearchResult() {
        return !this.searchContinued;
    }

    @Override
    public void resolveEntry(IOnlinePoiListElement iOnlinePoiListElement) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Resolving a POI entry.").toString());
        if (!this.hasLock) {
            AppLogger.error(new StringBuffer().append(this.logPrefix).append("Not possible to resolve entry without lock.").toString());
        } else if (!this.searchActive) {
            AppLogger.error(new StringBuffer().append(this.logPrefix).append("No search active, please prepare and start a search and retrieve some entries before resolving an entry.").toString());
        } else {
            this.searchContinued = true;
            try {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Asking for address at the Navi interface.").toString());
                this.externalInterface.resolveEntry(iOnlinePoiListElement);
            }
            catch (NavigationServiceException navigationServiceException) {
                this.handleException(navigationServiceException);
            }
        }
    }

    @Override
    public void updateLock(boolean bl) {
        if (bl) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Lock has been granted.").toString());
        } else {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Lock has been released.").toString());
        }
        this.hasLock = bl;
        if (this.searchActive && !this.searchContinued && this.hasLock) {
            try {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Lock has been granted while search was queued, starting this search now.").toString());
                this.externalInterface.startVoicePoiSearch();
            }
            catch (NavigationServiceException navigationServiceException) {
                this.handleException(navigationServiceException);
            }
        }
    }

    @Override
    public void onlinePoiSearchResult(int n, int n2) {
        if (n == 1) {
            if (n2 == 58) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI voice search failed with unrecognizable keyword.").toString());
                this.internalHandler.onErrorDuringSearch(3);
                this.searchFailed = true;
            } else if (n2 == 59) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI voice search failed with no results.").toString());
                this.internalHandler.onErrorDuringSearch(2);
                this.searchFailed = true;
            } else if (n2 == 57) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI voice search failed because language is not supported.").toString());
                this.internalHandler.onErrorDuringSearch(4);
                this.searchFailed = true;
            } else if (n2 == 62) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI voice search failed because recognition in general failed.").toString());
                this.internalHandler.onErrorDuringSearch(3);
                this.searchFailed = true;
            } else if (n2 == 44) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI voice search failed with parsing error.").toString());
                this.internalHandler.onErrorDuringSearch(1);
                this.searchFailed = true;
            } else if (!this.onlinePOISearchStatusOK(n2)) {
                this.internalHandler.onErrorDuringSearch(1);
                this.searchFailed = true;
            }
        }
    }

    private boolean onlinePOISearchStatusOK(int n) {
        return n == 10 || n == 12 || n == 11;
    }

    @Override
    public void valueListBlock(IOnlinePoiListElement[] iOnlinePoiListElementArray, int n) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Navi interface sent a new block with online POIs.").toString());
        if (this.searchActive && !this.searchFailed) {
            if (!this.searchContinued) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("First search result, total elements count is ").append(n).append(".").toString());
            } else {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Further search results, total elements count is now ").append(n).append(".").toString());
            }
            this.totalElementCount = n;
            if (n == 0 || iOnlinePoiListElementArray == null || iOnlinePoiListElementArray.length == 0) {
                if (this.searchContinued) {
                    this.internalHandler.onErrorDuringSearch(5);
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received empty further search results.").toString());
                } else {
                    this.internalHandler.onErrorDuringSearch(2);
                    AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received empty first search results.").toString());
                }
                this.searchFailed = true;
            } else {
                this.receivedElementsCount += iOnlinePoiListElementArray.length;
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Forwarding new result block with ").append(iOnlinePoiListElementArray.length).append(" entries to SDS system. Received ").append(this.receivedElementsCount).append(" elements until now.").toString());
                this.internalHandler.onGetNextListPart(iOnlinePoiListElementArray);
            }
        } else {
            AppLogger.warn(new StringBuffer().append(this.logPrefix).append("Received POI element block without active search.").toString());
        }
    }

    @Override
    public void resolveEntryResult(INavigationLocation iNavigationLocation) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Navi interface sent a resolved POI address.").toString());
        if (this.searchActive && !this.searchFailed) {
            this.internalHandler.onResolvedResult(iNavigationLocation);
        } else {
            AppLogger.warn(new StringBuffer().append(this.logPrefix).append("Received resolved POI address without active search.").toString());
        }
    }
}

