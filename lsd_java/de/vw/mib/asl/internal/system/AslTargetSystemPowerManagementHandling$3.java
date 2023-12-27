/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.impl.system.powerstate.DSIPowerManagementListenerAdapter;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling;
import org.dsi.ifc.powermanagement.ClampSignal;

class AslTargetSystemPowerManagementHandling$3
extends DSIPowerManagementListenerAdapter {
    private final /* synthetic */ AslTargetSystemPowerManagementHandling this$0;

    AslTargetSystemPowerManagementHandling$3(AslTargetSystemPowerManagementHandling aslTargetSystemPowerManagementHandling) {
        this.this$0 = aslTargetSystemPowerManagementHandling;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.this$0.dsiPowerManagementAsyncException(n, string, n2);
    }

    @Override
    public void updateRVCActive(boolean bl, int n) {
        this.this$0.dsiPowerManagementUpdateRVCActive(bl, n);
    }

    @Override
    public void updatePowerManagementState(int n, int n2, int n3) {
        this.this$0.dsiPowerManagementUpdatePowerManagementState(n, n2, n3);
    }

    @Override
    public void updateClampSignal(ClampSignal clampSignal, int n) {
        this.this$0.dsiPowerManagementUpdateClampSignal(clampSignal, n);
    }

    @Override
    public void updateBEMState(int n, int n2) {
        this.this$0.dsiPowerManagementUpdateBEMState(n, n2);
    }
}

