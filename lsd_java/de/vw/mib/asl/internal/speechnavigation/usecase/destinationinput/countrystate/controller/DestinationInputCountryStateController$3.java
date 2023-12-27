/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController;

class DestinationInputCountryStateController$3
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputCountryStateController this$0;

    DestinationInputCountryStateController$3(DestinationInputCountryStateController destinationInputCountryStateController) {
        this.this$0 = destinationInputCountryStateController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        if (n == 2) {
            this.this$0.onActionNotAvailable();
        }
        this.this$0.notifyInputStatePrepared();
    }
}

