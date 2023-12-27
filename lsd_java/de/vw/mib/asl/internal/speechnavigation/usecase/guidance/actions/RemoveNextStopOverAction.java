/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions;

import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.GuidanceActionBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.RemoveNextStopOverAction$1;

public class RemoveNextStopOverAction
extends GuidanceActionBase {
    public RemoveNextStopOverAction(GuidanceService guidanceService) {
        super(guidanceService, null);
    }

    @Override
    public void invoke() {
        this.guidanceService.removeNextStopOver(new RemoveNextStopOverAction$1(this));
    }
}

