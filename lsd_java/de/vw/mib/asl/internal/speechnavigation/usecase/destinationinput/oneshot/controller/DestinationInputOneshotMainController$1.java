/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneshotMainController;

class DestinationInputOneshotMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputOneshotMainController this$0;

    DestinationInputOneshotMainController$1(DestinationInputOneshotMainController destinationInputOneshotMainController) {
        this.this$0 = destinationInputOneshotMainController;
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
            StartEntryMode.setMode(1);
            if (this.this$0.enterAgain) {
                DestinationInputOneShotController.enterOneShotAgain();
            } else {
                DestinationInputOneShotController.enterOneShot();
            }
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

