/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.FetchTimerImpl;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.Invoker;

class FetchTimerImpl$1
implements Invoker {
    private final /* synthetic */ MIBInvoker val$invoker;
    private final /* synthetic */ FetchTimerImpl this$0;

    FetchTimerImpl$1(FetchTimerImpl fetchTimerImpl, MIBInvoker mIBInvoker) {
        this.this$0 = fetchTimerImpl;
        this.val$invoker = mIBInvoker;
    }

    @Override
    public void invoke(Runnable runnable) {
        this.val$invoker.invoke(runnable);
    }
}

