/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.controller.DestinationInputOneShotController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.oneshot.model.OneShotModel;

class DestinationInputOneShotController$5
implements DestinationInputListener {
    private final /* synthetic */ OneShotModel val$selectedOneshot;
    private final /* synthetic */ DestinationInputOneShotController this$0;

    DestinationInputOneShotController$5(DestinationInputOneShotController destinationInputOneShotController, OneShotModel oneShotModel) {
        this.this$0 = destinationInputOneShotController;
        this.val$selectedOneshot = oneShotModel;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyStreetSelected(this.val$selectedOneshot);
    }
}

