/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceService;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StartGuidanceToListener;

public class NavigationGuidanceServiceAdapterBase$StartGuidanceCallerLock {
    private StartGuidanceToListener listener;
    private INavigationLocation destination;
    private final NavigationGuidanceService guidanceService;
    private boolean isNaviGuidanceDemoSettingEnabled;
    private final /* synthetic */ NavigationGuidanceServiceAdapterBase this$0;

    public NavigationGuidanceServiceAdapterBase$StartGuidanceCallerLock(NavigationGuidanceServiceAdapterBase navigationGuidanceServiceAdapterBase, NavigationGuidanceService navigationGuidanceService) {
        this.this$0 = navigationGuidanceServiceAdapterBase;
        this.guidanceService = navigationGuidanceService;
        this.listener = null;
    }

    public void acquire(StartGuidanceToListener startGuidanceToListener, INavigationLocation iNavigationLocation) {
        if (this.listener != null) {
            AppLogger.warn(new StringBuffer().append("collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = startGuidanceToListener;
        this.isNaviGuidanceDemoSettingEnabled = this.guidanceService.isDemomodeActive();
        AppLogger.info(new StringBuffer().append("caller aquired: ").append(this.toString()).toString());
    }

    public void release(int n) {
        this.listener.startGuidanceToResponse(n, this.destination);
        this.release();
    }

    private void release() {
        AppLogger.info(new StringBuffer().append("caller released: ").append(this.toString()).toString());
        this.listener = null;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public void restoreNaviGuidanceDemoSetting() {
        if (this.guidanceService.isDemomodeActive() != this.isNaviGuidanceDemoSettingEnabled) {
            this.guidanceService.setDemomodeActive(this.isNaviGuidanceDemoSettingEnabled);
        }
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(" - ").append(this.listener.hashCode()).toString();
    }
}

