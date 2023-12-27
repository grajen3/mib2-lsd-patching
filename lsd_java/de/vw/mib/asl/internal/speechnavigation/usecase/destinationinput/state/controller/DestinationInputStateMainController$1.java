/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.StartEntryMode;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.state.controller.DestinationInputStateMainController;

class DestinationInputStateMainController$1
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputStateMainController this$0;

    DestinationInputStateMainController$1(DestinationInputStateMainController destinationInputStateMainController) {
        this.this$0 = destinationInputStateMainController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (0 == n) {
            StartEntryMode.setMode(3);
            DestinationInputStateController.enterState();
        } else {
            this.this$0.onActionNotAvailable();
        }
    }
}

