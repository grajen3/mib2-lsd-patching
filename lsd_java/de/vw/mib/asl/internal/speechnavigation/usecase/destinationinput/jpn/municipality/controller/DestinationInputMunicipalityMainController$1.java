/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityMainController;

class DestinationInputMunicipalityMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputMunicipalityMainController this$0;

    DestinationInputMunicipalityMainController$1(DestinationInputMunicipalityMainController destinationInputMunicipalityMainController) {
        this.this$0 = destinationInputMunicipalityMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 0) {
            try {
                this.this$0.checkCountrySupported();
                StartEntryMode.setMode(10);
                DestinationInputMunicipalityController.enterMunicipality();
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

