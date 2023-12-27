/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling;

class AslTargetSystemPowerManagementHandling$5
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetSystemPowerManagementHandling this$0;

    AslTargetSystemPowerManagementHandling$5(AslTargetSystemPowerManagementHandling aslTargetSystemPowerManagementHandling) {
        this.this$0 = aslTargetSystemPowerManagementHandling;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.processRevertSystemPower();
        factoryResetCallback.notifyResetDone();
    }
}

