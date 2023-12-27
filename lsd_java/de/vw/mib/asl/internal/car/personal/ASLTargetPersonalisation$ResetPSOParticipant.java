/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.car.personal.ASLTargetPersonalisation;

class ASLTargetPersonalisation$ResetPSOParticipant
extends AbstractFactoryResetParticipant {
    private FactoryResetCallback callback;
    private final /* synthetic */ ASLTargetPersonalisation this$0;

    ASLTargetPersonalisation$ResetPSOParticipant(ASLTargetPersonalisation aSLTargetPersonalisation) {
        this.this$0 = aSLTargetPersonalisation;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.callback = factoryResetCallback;
        this.this$0.resetAll();
    }

    public void resetDone() {
        this.callback.notifyResetDone();
    }
}

