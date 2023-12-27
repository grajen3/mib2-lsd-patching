/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.controller.DestinationInputOneShotJpnController;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.oneshot.model.OneShotJpnModel;

class DestinationInputOneShotJpnController$9
implements DestinationInputListener {
    private final /* synthetic */ OneShotJpnModel val$selectedOneshot;
    private final /* synthetic */ DestinationInputOneShotJpnController this$0;

    DestinationInputOneShotJpnController$9(DestinationInputOneShotJpnController destinationInputOneShotJpnController, OneShotJpnModel oneShotJpnModel) {
        this.this$0 = destinationInputOneShotJpnController;
        this.val$selectedOneshot = oneShotJpnModel;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        this.this$0.updateLocation(iNavigationLocation);
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyChomeSelected(this.val$selectedOneshot);
    }
}

