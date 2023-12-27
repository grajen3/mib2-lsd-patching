/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;

class DestinationInputChomeController$1
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputChomeController this$0;

    DestinationInputChomeController$1(DestinationInputChomeController destinationInputChomeController, int n) {
        this.this$0 = destinationInputChomeController;
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

