/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberMainController;

class DestinationInputHouseNumberMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputHouseNumberMainController this$0;

    DestinationInputHouseNumberMainController$1(DestinationInputHouseNumberMainController destinationInputHouseNumberMainController) {
        this.this$0 = destinationInputHouseNumberMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (0 == n) {
            try {
                this.this$0.checkCountrySupported();
            }
            catch (NavigationServiceException navigationServiceException) {
                AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(navigationServiceException.getMessage()).toString());
            }
            StartEntryMode.setMode(7);
            DestinationInputHouseNumberController.enterHouseNumber();
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

