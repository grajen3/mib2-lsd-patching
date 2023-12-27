/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController;

class DestinationInputOneShotJpnController$6
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputOneShotJpnController this$0;

    DestinationInputOneShotJpnController$6(DestinationInputOneShotJpnController destinationInputOneShotJpnController) {
        this.this$0 = destinationInputOneShotJpnController;
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
        this.this$0.notifyInputPlacePrepared();
    }
}

