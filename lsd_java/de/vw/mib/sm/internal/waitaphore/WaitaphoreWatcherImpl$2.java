/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.waitaphore;

import de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcherImpl;

class WaitaphoreWatcherImpl$2
implements Runnable {
    private final /* synthetic */ int val$propertyId;
    private final /* synthetic */ WaitaphoreWatcherImpl this$0;

    WaitaphoreWatcherImpl$2(WaitaphoreWatcherImpl waitaphoreWatcherImpl, int n) {
        this.this$0 = waitaphoreWatcherImpl;
        this.val$propertyId = n;
    }

    @Override
    public final void run() {
        this.this$0.onErrorTimeout(this.val$propertyId);
    }
}

