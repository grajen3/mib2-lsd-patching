/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance;

import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.StopGuidanceController;

class StopGuidanceController$1
implements StopGuidanceListener {
    private final /* synthetic */ StopGuidanceController this$0;

    StopGuidanceController$1(StopGuidanceController stopGuidanceController) {
        this.this$0 = stopGuidanceController;
    }

    @Override
    public void stopGuidanceResponse(int n, int n2, int n3) {
        if (n == 1) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.notifyGuidanceStopped();
    }
}

