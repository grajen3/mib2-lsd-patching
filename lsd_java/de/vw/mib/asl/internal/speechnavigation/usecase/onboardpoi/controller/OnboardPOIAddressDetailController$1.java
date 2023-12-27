/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.onboardpoi.listener.ResolvePOIAddressListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.onboardpoi.controller.OnboardPOIAddressDetailController;

class OnboardPOIAddressDetailController$1
implements ResolvePOIAddressListener {
    private final /* synthetic */ int val$notificationEventId;
    private final /* synthetic */ OnboardPOIAddressDetailController this$0;

    OnboardPOIAddressDetailController$1(OnboardPOIAddressDetailController onboardPOIAddressDetailController, int n) {
        this.this$0 = onboardPOIAddressDetailController;
        this.val$notificationEventId = n;
    }

    @Override
    public void getPOIAddressResponse(int n, INavigationLocation iNavigationLocation) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyShowDestinationAddressDetails(iNavigationLocation, this.val$notificationEventId);
    }
}

