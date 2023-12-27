/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.api.navigation.poi.onboard.IOnboardPoiListElement;
import de.vw.mib.asl.api.navigation.poi.onboard.NavigationOnboardPoiService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.NavigationOnboardPOIServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.ResolvePOIAddressListener;

public class NavigationOnboardPOIServiceAdapterBase$ResolvePOIAddressCallerLock {
    private final NavigationOnboardPoiService onboardPOIService;
    private ResolvePOIAddressListener listener;
    private IOnboardPoiListElement element;
    private final /* synthetic */ NavigationOnboardPOIServiceAdapterBase this$0;

    public NavigationOnboardPOIServiceAdapterBase$ResolvePOIAddressCallerLock(NavigationOnboardPOIServiceAdapterBase navigationOnboardPOIServiceAdapterBase, NavigationOnboardPoiService navigationOnboardPoiService) {
        this.this$0 = navigationOnboardPOIServiceAdapterBase;
        this.onboardPOIService = navigationOnboardPoiService;
        this.listener = null;
    }

    public void acquire(ResolvePOIAddressListener resolvePOIAddressListener, IOnboardPoiListElement iOnboardPoiListElement) {
        if (this.listener != null) {
            AppLogger.warn(this, new StringBuffer().append(".acquire(), collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = resolvePOIAddressListener;
        this.element = iOnboardPoiListElement;
        AppLogger.info(this, new StringBuffer().append(".acquire(), caller aquired: ").append(this.toString()).toString());
        try {
            AppLogger.info(this, new StringBuffer().append(".acquire(), call ").append(super.getClass().getName()).append(".weakLockInput()").toString());
            this.onboardPOIService.weakLockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error calling weakLockInput: ").append(navigationServiceException.getMessage()).toString());
            this.releaseOnError(iOnboardPoiListElement);
        }
    }

    public void releaseOnError(IOnboardPoiListElement iOnboardPoiListElement) {
        this.release(1, null);
        try {
            AppLogger.info(this, new StringBuffer().append(".releaseOnError(), call ").append(super.getClass().getName()).append(".unlockInput()").toString());
            this.onboardPOIService.unlockInput();
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(", error calling unlockInput: ").append(navigationServiceException.getMessage()).toString());
        }
    }

    public void release(int n, INavigationLocation iNavigationLocation) {
        this.listener.getPOIAddressResponse(n, iNavigationLocation);
        this.release();
    }

    public void release() {
        AppLogger.info(this, new StringBuffer().append(".release(), caller released: ").append(this.toString()).toString());
        this.listener = null;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public IOnboardPoiListElement getElement() {
        return this.element;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(" - ").append(this.listener.hashCode()).append(" - ").append(this.element.toString()).toString();
    }
}

