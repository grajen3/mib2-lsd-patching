/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberControllerJPN;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.jpn.controller.DestinationInputHouseNumberMainControllerJPN;

class DestinationInputHouseNumberMainControllerJPN$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputHouseNumberMainControllerJPN this$0;

    DestinationInputHouseNumberMainControllerJPN$1(DestinationInputHouseNumberMainControllerJPN destinationInputHouseNumberMainControllerJPN) {
        this.this$0 = destinationInputHouseNumberMainControllerJPN;
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
            DestinationInputHouseNumberControllerJPN.enterHouseNumber();
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

