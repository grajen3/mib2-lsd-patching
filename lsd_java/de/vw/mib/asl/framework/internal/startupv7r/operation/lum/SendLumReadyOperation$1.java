/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation.lum;

import de.vw.mib.asl.framework.internal.startupv7r.api.impl.InternalStartupStateAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.SendLumReadyOperation;

class SendLumReadyOperation$1
extends InternalStartupStateAdapter {
    private final /* synthetic */ SendLumReadyOperation this$0;

    SendLumReadyOperation$1(SendLumReadyOperation sendLumReadyOperation) {
        this.this$0 = sendLumReadyOperation;
    }

    @Override
    public void onLastUserModeAvailable() {
        this.this$0.onLastUserModeAvailable();
    }
}

