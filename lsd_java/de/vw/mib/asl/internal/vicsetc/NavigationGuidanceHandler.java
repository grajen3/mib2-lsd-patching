/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListenerAdapter;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;

public class NavigationGuidanceHandler
extends NavigationGuidanceListenerAdapter {
    private final VicsTarget target;

    public NavigationGuidanceHandler(VicsTarget vicsTarget) {
        this.target = vicsTarget;
    }

    @Override
    public void updateGuidanceErrorState(int n) {
        this.target.traceMsg(new StringBuffer().append("updateGuidanceErrorState( guidanceErrorState ").append(n).append(" )").toString(), this);
    }
}

