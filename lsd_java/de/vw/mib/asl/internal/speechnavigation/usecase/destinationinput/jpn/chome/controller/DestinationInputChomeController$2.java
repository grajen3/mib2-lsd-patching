/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.chome.controller.DestinationInputChomeController;

class DestinationInputChomeController$2
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputChomeController this$0;

    DestinationInputChomeController$2(DestinationInputChomeController destinationInputChomeController) {
        this.this$0 = destinationInputChomeController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyChomeSelected(iNavigationLocation);
    }
}

