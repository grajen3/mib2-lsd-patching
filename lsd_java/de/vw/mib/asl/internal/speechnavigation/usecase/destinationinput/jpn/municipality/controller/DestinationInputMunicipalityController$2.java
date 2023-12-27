/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.municipality.controller.DestinationInputMunicipalityController;

class DestinationInputMunicipalityController$2
implements DestinationInputListener {
    private final /* synthetic */ DestinationInputMunicipalityController this$0;

    DestinationInputMunicipalityController$2(DestinationInputMunicipalityController destinationInputMunicipalityController) {
        this.this$0 = destinationInputMunicipalityController;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyMunicipalitySelected(iNavigationLocation);
    }
}

