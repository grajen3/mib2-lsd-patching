/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.controller.DestinationInputCountryStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.countrystate.model.CountryStateModel;

class DestinationInputCountryStateController$2
implements DestinationInputListener {
    private final /* synthetic */ CountryStateModel val$selectedCountryState;
    private final /* synthetic */ DestinationInputCountryStateController this$0;

    DestinationInputCountryStateController$2(DestinationInputCountryStateController destinationInputCountryStateController, CountryStateModel countryStateModel) {
        this.this$0 = destinationInputCountryStateController;
        this.val$selectedCountryState = countryStateModel;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyCountryStateSelected(this.val$selectedCountryState);
    }
}

