/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;

class AslTargetSystemGeneral$2
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$2(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.this$0 = aslTargetSystemGeneral;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.processRevertSystemGeneral();
        factoryResetCallback.notifyResetDone();
    }
}

