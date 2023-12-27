/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.AddNextStopOverAction$1;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.GuidanceActionBase;

public class AddNextStopOverAction
extends GuidanceActionBase {
    public AddNextStopOverAction(GuidanceService guidanceService, INavigationLocation iNavigationLocation) {
        super(guidanceService, iNavigationLocation);
    }

    @Override
    public void invoke() {
        this.guidanceService.addNextStopOver(new AddNextStopOverAction$1(this), this.location);
    }
}

