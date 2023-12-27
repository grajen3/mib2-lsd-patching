/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StopGuidanceListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.ApplicationModalControllerBase;

class ApplicationModalControllerBase$1
implements StopGuidanceListener {
    private final /* synthetic */ ApplicationModalControllerBase this$0;

    ApplicationModalControllerBase$1(ApplicationModalControllerBase applicationModalControllerBase) {
        this.this$0 = applicationModalControllerBase;
    }

    @Override
    public void stopGuidanceResponse(int n, int n2, int n3) {
        if (n == 1 || n3 != 0) {
            this.this$0.onActionFailed();
            return;
        }
        this.this$0.onActionResumed();
    }
}

