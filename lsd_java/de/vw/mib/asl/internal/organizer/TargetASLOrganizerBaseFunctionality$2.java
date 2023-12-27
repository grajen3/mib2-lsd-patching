/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.organizer;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.organizer.TargetASLOrganizerBaseFunctionality;

class TargetASLOrganizerBaseFunctionality$2
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ TargetASLOrganizerBaseFunctionality this$0;

    TargetASLOrganizerBaseFunctionality$2(TargetASLOrganizerBaseFunctionality targetASLOrganizerBaseFunctionality) {
        this.this$0 = targetASLOrganizerBaseFunctionality;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("Organizer: Organizer reset received. Flag=").append(this.this$0.factoryResetActivated).log();
        }
        if (this.this$0.factoryResetActivated && !ASLPhoneFactory.getPhoneApi().isCallsActive()) {
            this.this$0.dsiAdbSetup.resetToFactorySettings();
            TargetASLOrganizerBaseFunctionality.access$002(this.this$0, factoryResetCallback);
        } else {
            factoryResetCallback.notifyResetDone();
        }
        this.this$0.factoryResetActivated = false;
    }
}

