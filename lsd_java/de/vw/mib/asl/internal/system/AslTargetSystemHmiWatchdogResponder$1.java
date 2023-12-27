/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemHmiWatchdogResponder;
import de.vw.mib.asl.internal.system.DsiHmiWatchdogListenerAdapter;

class AslTargetSystemHmiWatchdogResponder$1
extends DsiHmiWatchdogListenerAdapter {
    private final /* synthetic */ AslTargetSystemHmiWatchdogResponder this$0;

    AslTargetSystemHmiWatchdogResponder$1(AslTargetSystemHmiWatchdogResponder aslTargetSystemHmiWatchdogResponder) {
        this.this$0 = aslTargetSystemHmiWatchdogResponder;
    }

    @Override
    public void updateQueryHeartbeat(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.this$0.dsiHmiWatchDogUpdateQueryHeartbeat(n);
    }
}

