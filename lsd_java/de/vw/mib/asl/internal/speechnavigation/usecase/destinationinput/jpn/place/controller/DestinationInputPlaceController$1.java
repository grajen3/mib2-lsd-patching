/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;

class DestinationInputPlaceController$1
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputPlaceController this$0;

    DestinationInputPlaceController$1(DestinationInputPlaceController destinationInputPlaceController, int n) {
        this.this$0 = destinationInputPlaceController;
        this.val$notificationEventId = n;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
        } else if (n == 2) {
            this.this$0.onActionNotSupported();
        } else {
            this.this$0.notifyEnterPlaceSucceeded(iNavigationLocation, this.val$notificationEventId);
        }
    }
}

