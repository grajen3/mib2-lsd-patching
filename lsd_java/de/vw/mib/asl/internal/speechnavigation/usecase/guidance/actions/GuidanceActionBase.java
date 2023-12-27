/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.actions;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.guidance.GuidanceService;
import de.vw.mib.asl.internal.speechnavigation.usecase.common.actions.Action;

public abstract class GuidanceActionBase
implements Action {
    protected final INavigationLocation location;
    protected final GuidanceService guidanceService;

    public GuidanceActionBase(GuidanceService guidanceService, INavigationLocation iNavigationLocation) {
        this.guidanceService = guidanceService;
        this.location = iNavigationLocation;
    }
}

