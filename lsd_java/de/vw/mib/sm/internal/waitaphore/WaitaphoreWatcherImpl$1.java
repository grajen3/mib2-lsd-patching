/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.waitaphore;

import de.vw.mib.sm.internal.waitaphore.WaitaphoreWatcherImpl;

class WaitaphoreWatcherImpl$1
implements Runnable {
    private final /* synthetic */ int val$propertyId;
    private final /* synthetic */ int val$errorTimeout;
    private final /* synthetic */ WaitaphoreWatcherImpl this$0;

    WaitaphoreWatcherImpl$1(WaitaphoreWatcherImpl waitaphoreWatcherImpl, int n, int n2) {
        this.this$0 = waitaphoreWatcherImpl;
        this.val$propertyId = n;
        this.val$errorTimeout = n2;
    }

    @Override
    public final void run() {
        this.this$0.onWaitTimeout(this.val$propertyId, this.val$errorTimeout);
    }
}

