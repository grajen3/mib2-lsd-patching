/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.country.controller.DestinationInputCountryMainController;

class DestinationInputCountryMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputCountryMainController this$0;

    DestinationInputCountryMainController$1(DestinationInputCountryMainController destinationInputCountryMainController) {
        this.this$0 = destinationInputCountryMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (0 == n) {
            StartEntryMode.setMode(2);
            DestinationInputCountryController.enterCountry();
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

