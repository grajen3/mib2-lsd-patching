/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.AslTargetSystemDate;

class AslTargetSystemDate$2
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetSystemDate this$0;

    AslTargetSystemDate$2(AslTargetSystemDate aslTargetSystemDate) {
        this.this$0 = aslTargetSystemDate;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.processRevertDate();
        factoryResetCallback.notifyResetDone();
    }
}

