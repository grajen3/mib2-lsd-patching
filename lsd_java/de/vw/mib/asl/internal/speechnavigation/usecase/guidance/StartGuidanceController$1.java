/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.api.navigation.INavigationListElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.memory.listener.GetLastDestinationAddressListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.Framework;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceController;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StartGuidanceDestinationDetailsController;

class StartGuidanceController$1
implements GetLastDestinationAddressListener {
    private final /* synthetic */ StartGuidanceController this$0;

    StartGuidanceController$1(StartGuidanceController startGuidanceController) {
        this.this$0 = startGuidanceController;
    }

    @Override
    public void getLastDestinationAddressResponse(int n, INavigationListElement iNavigationListElement, INavigationLocation iNavigationLocation) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        if (iNavigationLocation == null || !iNavigationLocation.isValid()) {
            this.notifyDefineAddressFirst();
            return;
        }
        StartGuidanceDestinationDetailsController.showAddressDetailView(iNavigationLocation);
    }

    private void notifyDefineAddressFirst() {
        Framework.fireUIEvent(1560818688);
    }
}

