/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneshotMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;

class DestinationInputOneshotMainController$2
implements DestinationInputListener {
    private final /* synthetic */ OneShotModel val$address;
    private final /* synthetic */ DestinationInputOneshotMainController this$0;

    DestinationInputOneshotMainController$2(DestinationInputOneshotMainController destinationInputOneshotMainController, OneShotModel oneShotModel) {
        this.this$0 = destinationInputOneshotMainController;
        this.val$address = oneShotModel;
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
            Framework.fireEvent(-975097024, this.val$address);
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

