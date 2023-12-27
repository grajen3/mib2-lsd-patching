/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationRoute;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.NavigationGuidanceServiceAdapter;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StartGuidanceToListener;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;

class NavigationGuidanceServiceAdapter$2
implements StopGuidanceListener {
    private final /* synthetic */ StartGuidanceToListener val$listener;
    private final /* synthetic */ INavigationLocation val$destination;
    private final /* synthetic */ INavigationRoute val$route;
    private final /* synthetic */ int val$indexOfCurrentStopover;
    private final /* synthetic */ NavigationGuidanceServiceAdapter this$0;

    NavigationGuidanceServiceAdapter$2(NavigationGuidanceServiceAdapter navigationGuidanceServiceAdapter, StartGuidanceToListener startGuidanceToListener, INavigationLocation iNavigationLocation, INavigationRoute iNavigationRoute, int n) {
        this.this$0 = navigationGuidanceServiceAdapter;
        this.val$listener = startGuidanceToListener;
        this.val$destination = iNavigationLocation;
        this.val$route = iNavigationRoute;
        this.val$indexOfCurrentStopover = n;
    }

    @Override
    public void stopGuidanceResponse(int n, int n2, int n3) {
        try {
            this.this$0.startGuidanceCaller.acquire(this.val$listener, this.val$destination);
            if (n == 1) {
                AppLogger.error("error stopping the current guidance as part of add next stopover");
                this.val$listener.startGuidanceToResponse(1, this.val$destination);
                return;
            }
            this.val$route.addDestinationAtPosition(this.val$destination, this.val$indexOfCurrentStopover);
            this.this$0.guidanceService.reCalculateRoute(this.val$route, false);
        }
        catch (NavigationServiceException navigationServiceException) {
            AppLogger.error(new StringBuffer().append("error adding next stopover: ").append(navigationServiceException.getMessage()).toString());
            this.this$0.startGuidanceCaller.release(1);
        }
    }
}

