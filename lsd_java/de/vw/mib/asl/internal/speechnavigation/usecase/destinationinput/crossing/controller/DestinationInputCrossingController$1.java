/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.crossing.controller.DestinationInputCrossingController;

class DestinationInputCrossingController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputCrossingController this$0;

    DestinationInputCrossingController$1(DestinationInputCrossingController destinationInputCrossingController) {
        this.this$0 = destinationInputCrossingController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyCrossingSelected();
    }
}

