/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceMainController;

class DestinationInputPlaceMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputPlaceMainController this$0;

    DestinationInputPlaceMainController$1(DestinationInputPlaceMainController destinationInputPlaceMainController) {
        this.this$0 = destinationInputPlaceMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 0) {
            try {
                this.this$0.checkCountrySupported();
                StartEntryMode.setMode(12);
                DestinationInputPlaceController.enterPlace();
            }
            catch (NavigationServiceException navigationServiceException) {
                AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(" ").append(navigationServiceException.getMessage()).toString());
                this.this$0.onActionNotAvailable();
            }
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

