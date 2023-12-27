/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.impl.system.powerstate.DSIPowerManagementListenerAdapter;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;
import org.dsi.ifc.powermanagement.ClampSignal;

class AslTargetSystemGeneral$6
extends DSIPowerManagementListenerAdapter {
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$6(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.this$0 = aslTargetSystemGeneral;
    }

    @Override
    public void updateClampSignal(ClampSignal clampSignal, int n) {
        if (n == 1) {
            this.this$0.dsiPowerManagementUpdateClampSignal(clampSignal);
        }
    }
}

