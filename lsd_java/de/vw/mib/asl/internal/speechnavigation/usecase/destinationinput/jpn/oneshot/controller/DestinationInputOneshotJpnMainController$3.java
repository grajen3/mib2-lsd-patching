/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneshotJpnMainController;

class DestinationInputOneshotJpnMainController$3
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputOneshotJpnMainController this$0;

    DestinationInputOneshotJpnMainController$3(DestinationInputOneshotJpnMainController destinationInputOneshotJpnMainController) {
        this.this$0 = destinationInputOneshotJpnMainController;
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
            DestinationInputOneShotJpnController.enterOneShotAgain();
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

