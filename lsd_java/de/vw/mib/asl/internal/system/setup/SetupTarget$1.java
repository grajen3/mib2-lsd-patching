/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.setup;

import de.vw.mib.asl.api.online.ASLOnlineServiceAvailabilityListener;
import de.vw.mib.asl.internal.system.setup.SetupTarget;

class SetupTarget$1
implements ASLOnlineServiceAvailabilityListener {
    private final /* synthetic */ SetupTarget this$0;

    SetupTarget$1(SetupTarget setupTarget) {
        this.this$0 = setupTarget;
    }

    @Override
    public void updateOnlineServicesAvailabilityStatus(int n) {
        this.this$0.updateOnlineSetupAvailability(n);
    }
}

