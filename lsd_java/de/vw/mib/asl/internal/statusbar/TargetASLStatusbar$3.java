/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.api.navigation.IGuidanceInfo;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListenerAdapter;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar;
import generated.de.vw.mib.asl.internal.ListManager;

class TargetASLStatusbar$3
extends NavigationGuidanceListenerAdapter {
    private final /* synthetic */ TargetASLStatusbar this$0;

    TargetASLStatusbar$3(TargetASLStatusbar targetASLStatusbar) {
        this.this$0 = targetASLStatusbar;
    }

    @Override
    public void updateGuidanceState(int n, int n2) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("updateGuidanceState, mode: ").append(n).append(", state: ").append(n2).log();
        }
        if (n2 == 1) {
            AbstractASLTarget.writeBooleanToDatapool(-151499520, true);
        } else {
            AbstractASLTarget.writeBooleanToDatapool(-151499520, false);
            this.this$0.navigationTargetCollector.statusbar_navigation_target_distance_remaining = 0;
            ListManager.getGenericASLList(-168276736).updateList(this.this$0.navigationTimeCollectorArray);
            this.this$0.navigationTimeCollector.statusbar_navigation_time_etad = 0;
            this.this$0.navigationTimeCollector.statusbar_navigation_time_etah = 0;
            this.this$0.navigationTimeCollector.statusbar_navigation_time_etam = 0;
            this.this$0.navigationTimeCollector.statusbar_navigation_time_rtth = 0;
            this.this$0.navigationTimeCollector.statusbar_navigation_time_rttm = 0;
            ListManager.getGenericASLList(-185053952).updateList(this.this$0.navigationTargetCollectorArray);
        }
    }

    @Override
    public void updateGuidanceInfo(IGuidanceInfo[] iGuidanceInfoArray) {
        IGuidanceInfo iGuidanceInfo;
        IGuidanceInfo[] iGuidanceInfoArray2 = TargetASLStatusbar.access$200(this.this$0).getGuidanceInfo();
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("updateGuidanceInfo, stopOver: ").append(TargetASLStatusbar.access$200(this.this$0).isStatusNextStopover()).append(", stopover dest == null: ").append(iGuidanceInfoArray2[0] == null).log();
        }
        if (TargetASLStatusbar.access$200(this.this$0).isStatusNextStopover() && iGuidanceInfoArray2[0] != null) {
            iGuidanceInfo = iGuidanceInfoArray2[0];
            this.this$0.navigationTargetCollector.statusbar_navigation_target_mode = 1;
        } else {
            iGuidanceInfo = iGuidanceInfoArray2[1];
            this.this$0.navigationTargetCollector.statusbar_navigation_target_mode = 0;
        }
        if (iGuidanceInfo != null) {
            this.this$0.navigationTargetCollector.statusbar_navigation_target_distance_remaining = (int)iGuidanceInfo.getDistance();
            this.this$0.navigationTimeCollector.statusbar_navigation_time_etad = iGuidanceInfo.getEtaDays();
            this.this$0.navigationTimeCollector.statusbar_navigation_time_etah = iGuidanceInfo.getEtaHours();
            this.this$0.navigationTimeCollector.statusbar_navigation_time_etam = iGuidanceInfo.getEtaMinutes();
            this.this$0.navigationTimeCollector.statusbar_navigation_time_mode = TargetASLStatusbar.access$200(this.this$0).isEtaSelected() ? 0 : 1;
            this.this$0.navigationTimeCollector.statusbar_navigation_time_rtth = iGuidanceInfo.getRttHours();
            this.this$0.navigationTimeCollector.statusbar_navigation_time_rttm = iGuidanceInfo.getRttMinutes();
            ListManager.getGenericASLList(-168276736).updateList(this.this$0.navigationTimeCollectorArray);
            ListManager.getGenericASLList(-185053952).updateList(this.this$0.navigationTargetCollectorArray);
        }
    }
}

