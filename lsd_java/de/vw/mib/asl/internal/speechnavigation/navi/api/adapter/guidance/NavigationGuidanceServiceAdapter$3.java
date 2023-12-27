/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.api.navigation.INavigationRoute;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StartGuidanceToListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;

class NavigationGuidanceServiceAdapter$3
implements StopGuidanceListener {
    private final /* synthetic */ StartGuidanceToListener val$caller;
    private final /* synthetic */ INavigationRoute val$route;
    private final /* synthetic */ int val$indexOfCurrentStopover;
    private final /* synthetic */ NavigationGuidanceServiceAdapter this$0;

    NavigationGuidanceServiceAdapter$3(NavigationGuidanceServiceAdapter navigationGuidanceServiceAdapter, StartGuidanceToListener startGuidanceToListener, INavigationRoute iNavigationRoute, int n) {
        this.this$0 = navigationGuidanceServiceAdapter;
        this.val$caller = startGuidanceToListener;
        this.val$route = iNavigationRoute;
        this.val$indexOfCurrentStopover = n;
    }

    @Override
    public void stopGuidanceResponse(int n, int n2, int n3) {
        try {
            this.this$0.startGuidanceCaller.acquire(this.val$caller, null);
            if (n == 1) {
                AppLogger.error("error stopping the current guidance as part of remove next stopover");
                this.val$caller.startGuidanceToResponse(1, null);
                return;
            }
            this.val$route.deleteDestinationAtPosition(this.val$indexOfCurrentStopover);
            this.this$0.guidanceService.reCalculateRoute(this.val$route, false);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append("error removing next stopover: ").append(navigationServiceException.getMessage()).toString());
            this.this$0.startGuidanceCaller.release(1);
        }
    }
}

