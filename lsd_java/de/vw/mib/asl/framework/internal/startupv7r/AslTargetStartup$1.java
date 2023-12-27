/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.AslTargetStartup;
import de.vw.mib.asl.framework.internal.startupv7r.DsiPowerManagementListenerAdapter;

class AslTargetStartup$1
extends DsiPowerManagementListenerAdapter {
    private final /* synthetic */ AslTargetStartup this$0;

    AslTargetStartup$1(AslTargetStartup aslTargetStartup) {
        this.this$0 = aslTargetStartup;
    }

    @Override
    public void updatePowerManagementState(int n, int n2, int n3) {
        if (n3 == 1) {
            this.this$0.dsiPowerManagementUpdatePowerManagementState(n, n2);
        }
    }
}

