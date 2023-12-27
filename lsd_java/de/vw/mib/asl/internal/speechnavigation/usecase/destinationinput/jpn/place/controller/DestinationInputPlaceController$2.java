/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.place.controller.DestinationInputPlaceController;

class DestinationInputPlaceController$2
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputPlaceController this$0;

    DestinationInputPlaceController$2(DestinationInputPlaceController destinationInputPlaceController) {
        this.this$0 = destinationInputPlaceController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyPlaceSelected(iNavigationLocation);
    }
}

