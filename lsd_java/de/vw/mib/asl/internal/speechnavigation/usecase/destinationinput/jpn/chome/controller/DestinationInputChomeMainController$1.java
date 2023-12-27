/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeMainController;

class DestinationInputChomeMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputChomeMainController this$0;

    DestinationInputChomeMainController$1(DestinationInputChomeMainController destinationInputChomeMainController) {
        this.this$0 = destinationInputChomeMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 0) {
            try {
                this.this$0.checkCountrySupported();
                StartEntryMode.setMode(13);
                DestinationInputChomeController.enterChome();
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

