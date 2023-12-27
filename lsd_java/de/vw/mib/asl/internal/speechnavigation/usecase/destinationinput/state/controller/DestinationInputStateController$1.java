/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController;

class DestinationInputStateController$1
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputStateController this$0;

    DestinationInputStateController$1(DestinationInputStateController destinationInputStateController, int n) {
        this.this$0 = destinationInputStateController;
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
        this.this$0.notifyEnteringStateSucceeded(iNavigationLocation, this.val$notificationEventId);
    }
}

