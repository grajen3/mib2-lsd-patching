/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.impl.system.powerstate.DSIPowerManagementListenerAdapter;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates;
import org.dsi.ifc.powermanagement.ClampSignal;

class AslTargetSystemVehicleStates$4
extends DSIPowerManagementListenerAdapter {
    private final /* synthetic */ AslTargetSystemVehicleStates this$0;

    AslTargetSystemVehicleStates$4(AslTargetSystemVehicleStates aslTargetSystemVehicleStates) {
        this.this$0 = aslTargetSystemVehicleStates;
    }

    @Override
    public void updateClampSignal(ClampSignal clampSignal, int n) {
        if (n == 1) {
            this.this$0.dsiPowerManagementUpdateClampSignal(clampSignal);
        }
    }
}

