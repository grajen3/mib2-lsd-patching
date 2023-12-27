/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.homeaddress.HomeAddressController;

class HomeAddressController$1
implements StopGuidanceListener {
    private final /* synthetic */ INavigationLocation val$address;
    private final /* synthetic */ HomeAddressController this$0;

    HomeAddressController$1(HomeAddressController homeAddressController, INavigationLocation iNavigationLocation) {
        this.this$0 = homeAddressController;
        this.val$address = iNavigationLocation;
    }

    @Override
    public void stopGuidanceResponse(int n, int n2, int n3) {
        if (n == 1 || n3 != 0) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.startGuidanceTo(this.val$address);
    }
}

