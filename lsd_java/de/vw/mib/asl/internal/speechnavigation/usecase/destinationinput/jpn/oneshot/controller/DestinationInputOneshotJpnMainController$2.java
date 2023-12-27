/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.NavigationServiceException;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneshotJpnMainController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;

class DestinationInputOneshotJpnMainController$2
implements DestinationInputListener {
    private final /* synthetic */ OneShotModel val$address;
    private final /* synthetic */ DestinationInputOneshotJpnMainController this$0;

    DestinationInputOneshotJpnMainController$2(DestinationInputOneshotJpnMainController destinationInputOneshotJpnMainController, OneShotModel oneShotModel) {
        this.this$0 = destinationInputOneshotJpnMainController;
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
            Framework.fireEvent(-153013440, this.val$address);
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

