/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation.lum;

import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateListener;
import de.vw.mib.asl.framework.internal.startupv7r.operation.lum.AbstractLumReadyOperation;

class AbstractLumReadyOperation$1
implements StartupStateListener {
    private final /* synthetic */ AbstractLumReadyOperation this$0;

    AbstractLumReadyOperation$1(AbstractLumReadyOperation abstractLumReadyOperation) {
        this.this$0 = abstractLumReadyOperation;
    }

    @Override
    public void onStartupStateChanged(int n) {
        if (n == 2 && !this.this$0.wasLumReadySent()) {
            this.this$0.logError("[AbstractLumReadyOperation] ASL startup was done but LUM READY has not been sent yet. Sending finally as fallback now.");
            this.this$0.sendLumReady();
        }
    }
}

