/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.organizer;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.organizer.TargetASLOrganizerBaseFunctionality;

class TargetASLOrganizerBaseFunctionality$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ TargetASLOrganizerBaseFunctionality this$0;

    TargetASLOrganizerBaseFunctionality$1(TargetASLOrganizerBaseFunctionality targetASLOrganizerBaseFunctionality) {
        this.this$0 = targetASLOrganizerBaseFunctionality;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace("Organizer: FULL reset received setting flag!");
        }
        this.this$0.factoryResetActivated = true;
        factoryResetCallback.notifyResetDone();
    }
}

