/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.common.AppLogger;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.listener.StartGuidanceToListener;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.AddNextStopOverAction;

class AddNextStopOverAction$1
implements StartGuidanceToListener {
    private final /* synthetic */ AddNextStopOverAction this$0;

    AddNextStopOverAction$1(AddNextStopOverAction addNextStopOverAction) {
        this.this$0 = addNextStopOverAction;
    }

    @Override
    public void startGuidanceToResponse(int n, INavigationLocation iNavigationLocation) {
        this.this$0.guidanceService.release();
        if (n == 1) {
            AppLogger.error(new StringBuffer().append(super.getClass().getName()).append(".invoke() failed.").toString());
            return;
        }
    }
}

