/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.DriverDistractionPreventionThresholdListener;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates;

class AslTargetSystemVehicleStates$1
implements DriverDistractionPreventionThresholdListener {
    private final /* synthetic */ AslTargetSystemVehicleStates this$0;

    AslTargetSystemVehicleStates$1(AslTargetSystemVehicleStates aslTargetSystemVehicleStates) {
        this.this$0 = aslTargetSystemVehicleStates;
    }

    @Override
    public void onDriverDistractionPreventionRequired(boolean bl) {
        this.this$0.updateVelocityExceedance(bl);
    }
}

