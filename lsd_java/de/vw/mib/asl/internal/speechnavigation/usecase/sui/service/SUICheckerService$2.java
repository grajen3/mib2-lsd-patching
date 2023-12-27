/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.sui.service;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.destinationinput.listener.DestinationInputListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.sui.service.SUICheckerService;

class SUICheckerService$2
implements DestinationInputListener {
    private final /* synthetic */ SUICheckerService this$0;

    SUICheckerService$2(SUICheckerService sUICheckerService) {
        this.this$0 = sUICheckerService;
    }

    @Override
    public void setDestinationFieldResponse(int n, INavigationLocation iNavigationLocation, int[] nArray) {
        if (n == 1) {
            AppLogger.error(this, ", calling initializeDestinationInput(..) failed. Cannot evaluate SUI on current location change. ");
            return;
        }
        this.this$0.evaluateSUIFeature(this.this$0.destinationInputService.getCurrentInputSpeechCapabilities(), this.this$0.destinationInputService.getCurrentInput());
    }
}

