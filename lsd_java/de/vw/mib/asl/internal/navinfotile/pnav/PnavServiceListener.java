/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.pnav;

import de.vw.mib.asl.api.navigation.IPnavLikelyDestination;
import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListenerAdapter;
import de.vw.mib.asl.internal.navinfotile.pnav.NavInfoTilePnavTarget;

public class PnavServiceListener
extends NavigationGuidanceListenerAdapter {
    NavInfoTilePnavTarget target;

    public PnavServiceListener(NavInfoTilePnavTarget navInfoTilePnavTarget) {
        this.target = navInfoTilePnavTarget;
    }

    @Override
    public void updatePNavStatus(int n) {
        this.target.traceState("updatePNavStatus");
        this.target.notifierModel.notifyPNavStatusChanged(n);
    }

    @Override
    public void updatePNavIsEnabled(boolean bl) {
        this.target.traceState("updatePNavIsEnabled");
        this.target.notifierModel.notifyPnavEnabledChanged(bl);
    }

    @Override
    public void updatePNavCombinedCalculationState(int n) {
        this.target.traceState("updatePNavCombinedCalculationState");
        this.target.notifierModel.notifyCombinedCalculationStateChanged(n);
    }

    @Override
    public void updatePNavSelectedDestination(IPnavLikelyDestination iPnavLikelyDestination) {
        this.target.traceState("updatePNavSelectedDestination");
        this.target.notifierModel.updateListSelectedDestination(iPnavLikelyDestination);
    }

    @Override
    public void updatePNavLikelyDestinations(IPnavLikelyDestination[] iPnavLikelyDestinationArray) {
        this.target.traceState("updatePNavLikelyDestinations");
        this.target.notifierModel.updateListLikelyDestinations(iPnavLikelyDestinationArray);
    }
}

