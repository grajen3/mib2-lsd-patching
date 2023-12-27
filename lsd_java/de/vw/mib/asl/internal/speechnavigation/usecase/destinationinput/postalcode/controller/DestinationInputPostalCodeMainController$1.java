/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeMainController;

class DestinationInputPostalCodeMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputPostalCodeMainController this$0;

    DestinationInputPostalCodeMainController$1(DestinationInputPostalCodeMainController destinationInputPostalCodeMainController) {
        this.this$0 = destinationInputPostalCodeMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (0 == n) {
            try {
                this.this$0.checkCountrySupported();
            }
            catch (NavigationServiceException navigationServiceException) {
                AppLogger.info(new StringBuffer().append(super.getClass().getName()).append(" ").append(navigationServiceException.getMessage()).toString());
                return;
            }
            StartEntryMode.setMode(5);
            DestinationInputPostalCodeController.enterPostalCode();
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

