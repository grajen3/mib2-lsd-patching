/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates;

class AslTargetSystemVehicleStates$3
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ AslTargetSystemVehicleStates this$0;

    AslTargetSystemVehicleStates$3(AslTargetSystemVehicleStates aslTargetSystemVehicleStates) {
        this.this$0 = aslTargetSystemVehicleStates;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.processRevertSystemVehicleStates();
        factoryResetCallback.notifyResetDone();
    }
}

