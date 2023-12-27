/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapterBase;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;

public class NavigationGuidanceServiceAdapterBase$StopGuidanceCallerLock {
    private StopGuidanceListener listener = null;
    private final /* synthetic */ NavigationGuidanceServiceAdapterBase this$0;

    public NavigationGuidanceServiceAdapterBase$StopGuidanceCallerLock(NavigationGuidanceServiceAdapterBase navigationGuidanceServiceAdapterBase) {
        this.this$0 = navigationGuidanceServiceAdapterBase;
    }

    public void acquire(StopGuidanceListener stopGuidanceListener) {
        if (this.listener != null) {
            AppLogger.warn(new StringBuffer().append("collision caller detected: ").append(this.toString()).toString());
        }
        this.listener = stopGuidanceListener;
        AppLogger.info(new StringBuffer().append("caller aquired: ").append(this.toString()).toString());
    }

    public void release(int n, int n2, int n3) {
        this.listener.stopGuidanceResponse(n, n2, n3);
        this.release();
    }

    private void release() {
        AppLogger.info(new StringBuffer().append("caller released: ").append(this.toString()).toString());
        this.listener = null;
    }

    public boolean isAcquired() {
        return this.listener != null;
    }

    public String toString() {
        return new StringBuffer().append(super.getClass().getName()).append(" - ").append(this.listener.hashCode()).toString();
    }
}

