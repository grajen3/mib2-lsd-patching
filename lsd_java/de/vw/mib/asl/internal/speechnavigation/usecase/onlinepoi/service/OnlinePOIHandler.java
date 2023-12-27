/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service;

import de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedService;
import de.vw.mib.asl.api.connectivity.services.networking.InternetConnectionUserBlockedUpdate;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.poi.online.IOnlinePoiListElement;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.api.speechengine.result.service.AsyncCallback;
import de.vw.mib.asl.api.speechengine.result.service.DataService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi.OnlinePOISearchServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onlinepoi.listener.SearchOnlinePOIListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.model.OnlinePOI;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIDetailUpdateListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIHandler$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service.OnlinePOIListUpdateListener;
import de.vw.mib.collections.ObjectArrayList;

public class OnlinePOIHandler
implements SearchOnlinePOIListener,
DataService,
DialogStateConsumer,
InternetConnectionUserBlockedUpdate {
    private String logPrefix = "[SN][OnlinePOI][OnlinePOIHandler] ";
    private OnlinePOISearchServiceAdapter naviServiceAdapter;
    private ASLOnlineCoreServices onlineServices;
    private ASLOnlineServiceIdentifier onlinePOISearchServiceIdentifier = new OnlinePOIHandler$1(this);
    private ObjectArrayList searchResult = new ObjectArrayList(10);
    private int selectedIndex;
    private AsyncCallback lastCaller;
    private ObjectArrayList listUpdateListener = new ObjectArrayList(2);
    private ObjectArrayList detailUpdateListener = new ObjectArrayList(1);
    boolean useCaseActive;
    boolean searchActive;
    boolean connectionBlockedByUser;

    public void registerListener(OnlinePOIListUpdateListener onlinePOIListUpdateListener) {
        this.listUpdateListener.add(onlinePOIListUpdateListener);
    }

    public void registerListener(OnlinePOIDetailUpdateListener onlinePOIDetailUpdateListener) {
        this.detailUpdateListener.add(onlinePOIDetailUpdateListener);
    }

    public void setInternetConnectionUserBlockedService(InternetConnectionUserBlockedService internetConnectionUserBlockedService) {
        internetConnectionUserBlockedService.register(this);
    }

    public boolean isConnectionBlockedByUser() {
        return this.connectionBlockedByUser;
    }

    public void setOnlineServices(ASLOnlineCoreServices aSLOnlineCoreServices) {
        this.onlineServices = aSLOnlineCoreServices;
    }

    public void checkIsOnlineServiceReady(ASLOnlineServiceCallback aSLOnlineServiceCallback) {
        this.onlineServices.checkOnlineServiceStatus(this.onlinePOISearchServiceIdentifier, aSLOnlineServiceCallback);
    }

    public boolean isOnlineFeatureNotSupported() {
        return this.onlineServices.isServiceConfigured(this.onlinePOISearchServiceIdentifier);
    }

    public boolean isServiceReady() {
        return this.naviServiceAdapter.isServiceReady();
    }

    public void startUseCase() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI voice search use case started. Prepare search.").toString());
        this.searchActive = false;
        this.useCaseActive = true;
        this.naviServiceAdapter.prepareForSearch();
    }

    public boolean isUseCaseActive() {
        return this.useCaseActive;
    }

    public boolean isSearchActive() {
        return this.searchActive;
    }

    public boolean isUniqueResult() {
        return this.naviServiceAdapter.hasOnlyOneEntry();
    }

    public boolean hasMorePOIs() {
        return this.naviServiceAdapter.hasMoreEntries();
    }

    public void selectItem(OnlinePOI onlinePOI) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Setting selected POI to ").append(onlinePOI.getName()).append(".").toString());
        this.selectedIndex = onlinePOI.getId();
    }

    public OnlinePOI selectNext() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Select next POI.").toString());
        if (this.selectedIndex + 1 < this.searchResult.size()) {
            ++this.selectedIndex;
            return this.getSelectedItem();
        }
        return null;
    }

    public OnlinePOI selectPrev() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Select next POI.").toString());
        if (this.selectedIndex - 1 >= 0) {
            --this.selectedIndex;
            return this.getSelectedItem();
        }
        return null;
    }

    public OnlinePOI selectFirstItem() {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Select first POI.").toString());
        this.selectedIndex = 0;
        return this.getSelectedItem();
    }

    public OnlinePOI getSelectedItem() {
        return (OnlinePOI)this.searchResult.get(this.selectedIndex);
    }

    public void resolveSelectedItem() {
        this.naviServiceAdapter.resolveEntry(this.getSelectedItem().getOnlinePOIListElement());
    }

    public void retrieveMoreEntries() {
        this.naviServiceAdapter.getNextEntries();
    }

    @Override
    public void onRegistered(OnlinePOISearchServiceAdapter onlinePOISearchServiceAdapter) {
        this.naviServiceAdapter = onlinePOISearchServiceAdapter;
    }

    @Override
    public void onErrorDuringSearch(int n) {
        for (int i2 = 0; i2 < this.listUpdateListener.size(); ++i2) {
            ((OnlinePOIListUpdateListener)this.listUpdateListener.get(i2)).onError(n);
        }
    }

    @Override
    public void onGetNextListPart(IOnlinePoiListElement[] iOnlinePoiListElementArray) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Handling new search results.").toString());
        if (this.naviServiceAdapter.isFirstSearchResult()) {
            this.searchResult.clear();
        }
        int n = this.searchResult.size();
        Object[] objectArray = new OnlinePOI[iOnlinePoiListElementArray.length];
        for (int i2 = 0; i2 < iOnlinePoiListElementArray.length; ++i2) {
            OnlinePOI onlinePOI = new OnlinePOI(iOnlinePoiListElementArray[i2], i2 + n);
            this.searchResult.add(onlinePOI);
            objectArray[i2] = onlinePOI;
        }
        if (this.naviServiceAdapter.isFirstSearchResult()) {
            if (this.lastCaller != null) {
                AppLogger.trace(new StringBuffer().append(this.logPrefix).append("It was the first search result of this search, handing it to caller with response method to show list.").toString());
                this.lastCaller.onResponse(objectArray);
            } else {
                AppLogger.error(new StringBuffer().append(this.logPrefix).append("First search result arrived, but no caller available.").toString());
            }
        } else {
            int n2;
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("It was an additional result, handing it to listener.").toString());
            OnlinePOI[] onlinePOIArray = new OnlinePOI[this.searchResult.size()];
            for (n2 = 0; n2 < this.searchResult.size(); ++n2) {
                onlinePOIArray[n2] = (OnlinePOI)this.searchResult.get(n2);
            }
            for (n2 = 0; n2 < this.listUpdateListener.size(); ++n2) {
                ((OnlinePOIListUpdateListener)this.listUpdateListener.get(n2)).onNewDataReceived(onlinePOIArray);
            }
        }
    }

    @Override
    public void onResolvedResult(INavigationLocation iNavigationLocation) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Forwarding resolved address.").toString());
        for (int i2 = 0; i2 < this.detailUpdateListener.size(); ++i2) {
            ((OnlinePOIDetailUpdateListener)this.detailUpdateListener.get(i2)).onDetailsComplete(iNavigationLocation);
        }
    }

    @Override
    public void onInternetBlockedByUserChanged(boolean bl) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Received connectivity internet connection update, blockedByUser = ").append(bl).append(".").toString());
        this.connectionBlockedByUser = bl;
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 3 && this.useCaseActive) {
            AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Speech dialog ended and online POI search use case was active. End search and release lock.").toString());
            this.naviServiceAdapter.stopSearch();
            this.searchActive = false;
            this.useCaseActive = false;
        }
    }

    @Override
    public void getDataRequest(AsyncCallback asyncCallback) {
        AppLogger.trace(new StringBuffer().append(this.logPrefix).append("Online POI voice search input has been recognized. Start search to request results via Navi interface.").toString());
        this.lastCaller = asyncCallback;
        this.searchActive = true;
        this.naviServiceAdapter.startSearch();
    }
}

