/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.street.controller.DestinationInputStreetController;

class DestinationInputStreetController$2
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputStreetController this$0;

    DestinationInputStreetController$2(DestinationInputStreetController destinationInputStreetController, int n) {
        this.this$0 = destinationInputStreetController;
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
        }
        this.this$0.notifyEnterStreetSucceeded(iNavigationLocation, this.val$notificationEventId);
    }
}

