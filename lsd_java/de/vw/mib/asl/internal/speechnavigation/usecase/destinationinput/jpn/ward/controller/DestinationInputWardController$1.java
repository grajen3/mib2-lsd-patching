/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller.DestinationInputWardController;

class DestinationInputWardController$1
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputWardController this$0;

    DestinationInputWardController$1(DestinationInputWardController destinationInputWardController, int n) {
        this.this$0 = destinationInputWardController;
        this.val$notificationEventId = n;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1 || n == 2) {
            this.this$0.onActionFailed();
        } else {
            this.this$0.notifyEnterWardSucceeded(iNavigationLocation, this.val$notificationEventId);
        }
    }
}

