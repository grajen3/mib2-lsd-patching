/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.ward.controller.DestinationInputWardController;

class DestinationInputWardController$2
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputWardController this$0;

    DestinationInputWardController$2(DestinationInputWardController destinationInputWardController) {
        this.this$0 = destinationInputWardController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyWardSelected(iNavigationLocation);
    }
}

