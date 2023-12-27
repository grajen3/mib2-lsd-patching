/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.GuidanceActionBase;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions.StartGuidanceAction$1;

public class StartGuidanceAction
extends GuidanceActionBase {
    public StartGuidanceAction(GuidanceService guidanceService, INavigationLocation iNavigationLocation) {
        super(guidanceService, iNavigationLocation);
    }

    @Override
    public void invoke() {
        this.guidanceService.startGuidanceTo(new StartGuidanceAction$1(this), this.location);
    }
}

