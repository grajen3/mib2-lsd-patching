/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;

class DestinationInputHouseNumberController$2
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputHouseNumberController this$0;

    DestinationInputHouseNumberController$2(DestinationInputHouseNumberController destinationInputHouseNumberController) {
        this.this$0 = destinationInputHouseNumberController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyHouseNumberSelected(iNavigationLocation);
    }
}

