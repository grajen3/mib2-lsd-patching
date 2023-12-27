/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.housenumber.controller.DestinationInputHouseNumberController;

class DestinationInputHouseNumberController$1
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputHouseNumberController this$0;

    DestinationInputHouseNumberController$1(DestinationInputHouseNumberController destinationInputHouseNumberController, int n) {
        this.this$0 = destinationInputHouseNumberController;
        this.val$notificationEventId = n;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        if (n == 2) {
            this.this$0.onActionNotAvailable();
            return;
        }
        this.this$0.notifyEnterHouseNumberSucceeded(iNavigationLocation, this.val$notificationEventId);
    }
}

