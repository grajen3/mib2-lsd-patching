/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.powerstate;

import de.vw.mib.asl.internal.impl.system.powerstate.ClampSignalServiceImpl;
import de.vw.mib.asl.internal.impl.system.powerstate.DSIPowerManagementListenerAdapter;
import org.dsi.ifc.powermanagement.ClampSignal;

class ClampSignalServiceImpl$1
extends DSIPowerManagementListenerAdapter {
    private final /* synthetic */ ClampSignalServiceImpl this$0;

    ClampSignalServiceImpl$1(ClampSignalServiceImpl clampSignalServiceImpl) {
        this.this$0 = clampSignalServiceImpl;
    }

    @Override
    public void updateClampSignal(ClampSignal clampSignal, int n) {
        if (n == 1) {
            this.this$0.applyCurrentClampSValue(clampSignal.isClampS());
            this.this$0.applyCurrentClamp15Value(clampSignal.isClamp15());
        }
    }
}

