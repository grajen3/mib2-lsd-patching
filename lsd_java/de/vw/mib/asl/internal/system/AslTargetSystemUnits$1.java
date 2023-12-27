/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.AslTargetSystemUnits;

class AslTargetSystemUnits$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetSystemUnits this$0;

    AslTargetSystemUnits$1(AslTargetSystemUnits aslTargetSystemUnits) {
        this.this$0 = aslTargetSystemUnits;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.processRevertSystemUnits();
        factoryResetCallback.notifyResetDone();
    }
}

