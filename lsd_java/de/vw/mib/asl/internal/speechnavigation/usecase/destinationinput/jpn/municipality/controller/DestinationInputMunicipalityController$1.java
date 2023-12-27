/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController;

class DestinationInputMunicipalityController$1
implements DestinationInputListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ DestinationInputMunicipalityController this$0;

    DestinationInputMunicipalityController$1(DestinationInputMunicipalityController destinationInputMunicipalityController, int n) {
        this.this$0 = destinationInputMunicipalityController;
        this.val$notificationEventId = n;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
        } else if (n == 2) {
            this.this$0.onActionNotSupported();
        } else {
            this.this$0.notifyEnterMunicipalitySucceeded(iNavigationLocation, this.val$notificationEventId);
        }
    }
}

