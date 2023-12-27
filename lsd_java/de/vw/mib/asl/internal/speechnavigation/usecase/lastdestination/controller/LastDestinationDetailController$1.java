/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetLastDestinationAddressListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.lastdestination.controller.LastDestinationDetailController;

class LastDestinationDetailController$1
implements GetLastDestinationAddressListener {
    private final /* synthetic */ LastDestinationDetailController this$0;

    LastDestinationDetailController$1(LastDestinationDetailController lastDestinationDetailController) {
        this.this$0 = lastDestinationDetailController;
    }

    @Override
    public void getLastDestinationAddressResponse(int n, INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation) {
        if (n == 1) {
            Framework.fireUIEvent(2097689600);
            return;
        }
        this.this$0.notifyShowDestinationAddressDetails(iNavigationLocation);
    }
}

