/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.uota.service;

import de.vw.mib.asl.api.navigation.guidance.NavigationGuidanceListenerAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.uota.states.UotATarget;
import de.vw.mib.genericevents.EventGeneric;

public class UotAGuidanceService
extends NavigationGuidanceListenerAdapter {
    private UotATarget _target;

    public UotAGuidanceService(UotATarget uotATarget) {
        this._target = uotATarget;
    }

    @Override
    public void updateGuidanceState(int n, int n2) {
        if (1 == n2) {
            if (0 == n) {
                if (this._target.getPropertyManager().isNavDBConfigurationOnly() && !this._target.getPropertyManager().isNaviDestinationsSetForLater() && !this._target.getPropertyManager().isNaviDestinationsTillNextRevision()) {
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this._target.getDefaultTargetId(), this._target.getDefaultTargetId(), -1585053440);
                    this._target.sendSafe(eventGeneric);
                }
            } else if (1 == n) {
                // empty if block
            }
        }
    }
}

