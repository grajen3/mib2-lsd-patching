/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.postalcode.controller.DestinationInputPostalCodeController;

class DestinationInputPostalCodeController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputPostalCodeController this$0;

    DestinationInputPostalCodeController$1(DestinationInputPostalCodeController destinationInputPostalCodeController) {
        this.this$0 = destinationInputPostalCodeController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyPostalCodeSelected();
    }
}

