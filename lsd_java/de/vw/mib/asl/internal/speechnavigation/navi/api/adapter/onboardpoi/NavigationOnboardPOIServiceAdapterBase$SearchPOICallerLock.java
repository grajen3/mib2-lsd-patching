/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi;

import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.SearchPOIListener;

public class NavigationOnboardPOIServiceAdapterBase$SearchPOICallerLock {
    private final NavigationOnboardPoiService onboardPOIService;
    private SearchPOIListener listener;
    private long categoryId;
    private int criteria;
    private int searchStatus;
    private int numberOfAvailablePOIs;
    private int numberOfRetrievedPOIs;
    private final /* synthetic */ NavigationOnboardPOIServiceAdapterBase this$0;

    public NavigationOnboardPOIServiceAdapterBase$SearchPOICallerLock(NavigationOnboardPOIServiceAdapterBase navigationOnboardPOIServiceAdapterBase, NavigationOnboardPoiService navigationOnboardPoiService) {
        this.this$0 = navigationOnboardPOIServiceAdapterBase;
        this.onboardPOIService = navigationOnboardPoiService;
        this.listener = null;
    }

    public void acquire(SearchPOIListener searchPOIListener, long l, int n) {
        if (this.listener != null) {
            AppLogger.warn(this, new StringBuffer().append(".aquire(), collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = searchPOIListener;
        this.categoryId = l;
        this.criteria = n;
        this.searchStatus = 0;
        this.numberOfAvailablePOIs = 0;
        this.numberOfRetrievedPOIs = 0;
        AppLogger.info(this, new StringBuffer().append(".acquire(), caller aquired: ").append(this.toString()).toString());
        try {
            AppLogger.info(this, new StringBuffer().append(".aquire(), call ").append(super.getClass().getName()).append(".weakLockInput()").toString());
            this.onboardPOIService.weakLockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".aquire(), error calling weakLockInput: ").append(navigationServiceException.getMessage()).toString());
            this.release(1);
        }
    }

    public void release(int n) {
        this.listener.updateSearchStatus(n, this.searchStatus, this.numberOfAvailablePOIs, this.numberOfRetrievedPOIs);
        this.releaseUnlock();
    }

    private void releaseUnlock() {
        this.release();
        try {
            AppLogger.info(this, new StringBuffer().append(".release(), call ").append(super.getClass().getName()).append(".unlockInput()").toString());
            this.onboardPOIService.unlockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(this, new StringBuffer().append(".release(), exception calling ").append(super.getClass().getName()).append(".unlockInput(), ").append(navigationServiceException.getMessage()).toString());
        }
    }

    public void release() {
        AppLogger.info(new StringBuffer().append("caller released: ").append(this.toString()).toString());
        this.listener = null;
    }

    public SearchPOIListener getListener() {
        return this.listener;
    }

    public long getCategory() {
        return this.categoryId;
    }

    public int getCriteria() {
        return this.criteria;
    }

    public void setSearchStatus(int n) {
        this.searchStatus = n;
    }

    public int getSearchStatus() {
        return this.searchStatus;
    }

    public void setNumberOfAvailablePOIs(int n) {
        this.numberOfAvailablePOIs = n;
    }

    public int getNumberOfAvailablePOIs() {
        return this.numberOfAvailablePOIs;
    }

    public void setNumberOfRetrivedPOIs(int n) {
        this.numberOfRetrievedPOIs += n;
        AppLogger.trace(this, new StringBuffer().append(".setNumberOfRetrivedPOIs( count = ").append(n).append("), ==> numberOfRetrievedPOIs = ").append(this.numberOfRetrievedPOIs).toString());
    }

    public int getNumberOfRetrievedPOIs() {
        return this.numberOfRetrievedPOIs;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(" - ").append(this.listener.hashCode()).toString();
    }
}

