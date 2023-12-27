/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi;

import de.vw.mib.asl.api.navigation.ASLNavigationFactory;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapterBase$ResolvePOIAddressCallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapterBase$SearchPOICallerLock;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.OnboardPOIService;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.ResolvePOIAddressListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.SearchPOIListener;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.util.StringBuilder;

public final class NavigationOnboardPOIServiceAdapter
extends NavigationOnboardPOIServiceAdapterBase
implements OnboardPOIService {
    private final NavigationOnboardPOIServiceAdapterBase$ResolvePOIAddressCallerLock resolvePOIAddressCaller;
    private final NavigationOnboardPOIServiceAdapterBase$SearchPOICallerLock searchPOICaller;
    private NavigationOnboardPoiService navigationOnboardPOIService;
    private IntArrayList poiResultList = new IntArrayList();
    private static NavigationOnboardPOIServiceAdapter instance = null;
    boolean isResponseOnRequestPending = false;
    boolean isRetriggerNecessary = false;

    private NavigationOnboardPOIServiceAdapter() {
        this.navigationOnboardPOIService = ASLNavigationFactory.getNavigationApi().getNavigationOnboardPoiService(this);
        this.resolvePOIAddressCaller = new NavigationOnboardPOIServiceAdapterBase$ResolvePOIAddressCallerLock(this, this.navigationOnboardPOIService);
        this.searchPOICaller = new NavigationOnboardPOIServiceAdapterBase$SearchPOICallerLock(this, this.navigationOnboardPOIService);
    }

    private static NavigationOnboardPOIServiceAdapter getInstance() {
        if (instance == null) {
            instance = new NavigationOnboardPOIServiceAdapter();
        }
        return instance;
    }

    public static OnboardPOIService getService() {
        return NavigationOnboardPOIServiceAdapter.getInstance();
    }

    @Override
    public void release() {
        try {
            if (this.resolvePOIAddressCaller.isAcquired()) {
                this.resolvePOIAddressCaller.release();
            }
            if (this.searchPOICaller.isAcquired()) {
                this.stopSearch();
                this.searchPOICaller.release();
            }
            if (this.isServiceAcquired()) {
                this.navigationOnboardPOIService.unlockInput();
            }
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(", error releasing the NAVI interface: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    private boolean isServiceAcquired() {
        return this.resolvePOIAddressCaller.isAcquired() || this.searchPOICaller.isAcquired();
    }

    @Override
    public void startSearch(SearchPOIListener searchPOIListener, long l, int n) {
        this.searchPOICaller.acquire(searchPOIListener, l, n);
    }

    private void onSearchGranted() {
        try {
            AppLogger.trace(this, new StringBuffer().append(".onSearchGranted(), call startPoiSearch( categoryId = ").append(this.searchPOICaller.getCategory()).append(", criteria = ").append(this.searchPOICaller.getCriteria()).append(" )").toString());
            this.poiResultList.clear();
            this.navigationOnboardPOIService.startPoiSearch(this.searchPOICaller.getCategory(), this.searchPOICaller.getCriteria());
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".onSearchGranted(), error calling startPoiSearch: ").append(navigationServiceException.getMessage()).toString());
            this.searchPOICaller.release(1);
        }
    }

    @Override
    public void updateSearchStatus(int n, int n2, int n3) {
        if (this.searchPOICaller.isAcquired()) {
            if (AppLogger.isLoggingEnabled()) {
                StringBuilder stringBuilder = new StringBuilder().append(".updateSearchStatus").append("( ").append("status = ").append(n).append(", ").append("numberOfAvailablePOIs = ").append(n2).append(", ").append("distance = ").append(n3).append(" )");
                AppLogger.trace(this, stringBuilder.toString());
            }
            this.searchPOICaller.setNumberOfAvailablePOIs(n2);
            this.searchPOICaller.setSearchStatus(n);
            if (n2 == 0 && n == 3) {
                AppLogger.trace(this, ".updateSearchStatus(..), no POIs found.");
                this.searchPOICaller.release(0);
            } else if (n2 > 0) {
                int n4 = this.searchPOICaller.getNumberOfRetrievedPOIs();
                if (n4 == 0) {
                    this.getNextResults(".updateSearchStatus()", 0, 10);
                } else if (n == 3) {
                    if (n2 > n4) {
                        this.getNextResults(".updateSearchStatus()", n4, n2);
                    } else {
                        AppLogger.trace(this, ".updateSearchStatus(), got ALL POIs");
                        this.searchPOICaller.release(0);
                    }
                } else if (this.isRetriggerNecessary && n2 > n4) {
                    this.isRetriggerNecessary = false;
                    AppLogger.trace(this, new StringBuffer().append(".updateSearchStatus(..), retriggering getNextResults(").append(n4).append(", 10);").toString());
                    this.getNextResults(".updateSearchStatus()", n4, 10);
                }
            }
        } else {
            AppLogger.warn(this, ".updateSearchStatus(), got called but no listener has been aquired.");
        }
    }

    @Override
    public void valueListBlock(IOnboardPoiListElement[] iOnboardPoiListElementArray, int n) {
        if (AppLogger.isLoggingEnabled()) {
            StringBuilder stringBuilder = new StringBuilder(" << [UPDATE] ").append(".valueListBlock").append("( ").append("poiElements = ").append(iOnboardPoiListElementArray != null ? String.valueOf(iOnboardPoiListElementArray.length) : "null").append(", ").append("numberOfAvailablePOIs = ").append(n).append(" )");
            AppLogger.trace(this, stringBuilder.toString());
        }
        if (this.searchPOICaller.isAcquired()) {
            this.isResponseOnRequestPending = false;
            if (iOnboardPoiListElementArray == null || iOnboardPoiListElementArray.length == 0) {
                AppLogger.warn(this, ".valueListBlock(), update ignored as empty");
            } else {
                int n2;
                boolean bl = false;
                for (n2 = 0; n2 < iOnboardPoiListElementArray.length; ++n2) {
                    if (this.poiResultList.contains(iOnboardPoiListElementArray[n2].getIndex())) continue;
                    this.poiResultList.add(iOnboardPoiListElementArray[n2].getIndex());
                    bl = true;
                }
                if (bl) {
                    this.searchPOICaller.setNumberOfRetrivedPOIs(iOnboardPoiListElementArray.length);
                    this.searchPOICaller.getListener().updatePOIs(iOnboardPoiListElementArray);
                    n2 = this.searchPOICaller.getNumberOfAvailablePOIs();
                    int n3 = this.searchPOICaller.getNumberOfRetrievedPOIs();
                    if (n2 > n3) {
                        this.getNextResults(".valueListBlock()", this.searchPOICaller.getNumberOfRetrievedPOIs(), 10);
                    } else {
                        this.isRetriggerNecessary = true;
                    }
                } else {
                    AppLogger.warn(this, ".valueListBlock() ignored as already got the same result.");
                }
            }
            if (this.searchPOICaller.getSearchStatus() == 3 && this.searchPOICaller.getNumberOfRetrievedPOIs() >= n) {
                AppLogger.trace(this, ".valueListBlock(), got ALL POIs");
                this.searchPOICaller.release(0);
                return;
            }
        }
    }

    private void getNextResults(String string, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(new StringBuffer().append(string).append(" >> [CALL] ").toString()).append(".getValueListBlock").append("( ").append("index = ").append(n).append(", ").append("count = ").append(n2).append(" )");
        if (this.isResponseOnRequestPending) {
            stringBuilder.append(" is IGNORED as another pending request/response has been already triggered");
            AppLogger.trace(this, stringBuilder.toString());
            return;
        }
        AppLogger.trace(this, stringBuilder.toString());
        try {
            this.isResponseOnRequestPending = true;
            this.navigationOnboardPOIService.getValueListBlock(n, n2);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".getNextResults(), got exception calling getValueListBlock(..), ").append(navigationServiceException.getMessage()).toString());
            this.searchPOICaller.release(1);
        }
    }

    @Override
    public void poiListEntryChanged(IOnboardPoiListElement iOnboardPoiListElement) {
    }

    @Override
    public void resolveEntry(ResolvePOIAddressListener resolvePOIAddressListener, IOnboardPoiListElement iOnboardPoiListElement) {
        this.resolvePOIAddressCaller.acquire(resolvePOIAddressListener, iOnboardPoiListElement);
    }

    private void onResolveEntryGranted() {
        try {
            this.navigationOnboardPOIService.resolveEntry(this.resolvePOIAddressCaller.getElement());
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error calling resolveEntry: ").append(navigationServiceException.getMessage()).toString());
            this.resolvePOIAddressCaller.releaseOnError(this.resolvePOIAddressCaller.getElement());
        }
    }

    @Override
    public void resolveEntryResult(INavigationLocation iNavigationLocation) {
        if (this.resolvePOIAddressCaller.isAcquired()) {
            this.resolvePOIAddressCaller.release(0, iNavigationLocation);
        } else {
            AppLogger.warn(new StringBuffer().append(super.getClass().getName()).append(", got resolveContactResult but no listener has been aquired").toString());
        }
    }

    @Override
    public void updateLock(boolean bl) {
        if (this.resolvePOIAddressCaller.isAcquired()) {
            if (!bl) {
                this.resolvePOIAddressCaller.releaseOnError(null);
                return;
            }
            this.onResolveEntryGranted();
        } else if (this.searchPOICaller.isAcquired()) {
            if (!bl) {
                this.searchPOICaller.release(1);
                return;
            }
            this.onSearchGranted();
        }
    }

    @Override
    public void stopSearch() {
        try {
            AppLogger.trace(new StringBuffer().append(super.getClass().getName()).append(", call ").append(super.getClass().getName()).append(".stopPoiSearch()").toString());
            this.navigationOnboardPOIService.stopPoiSearch();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.warn(new StringBuffer().append(super.getClass().getName()).append(", error calling stopPoiSearch, ").append(navigationServiceException.getMessage()).toString());
        }
    }
}

