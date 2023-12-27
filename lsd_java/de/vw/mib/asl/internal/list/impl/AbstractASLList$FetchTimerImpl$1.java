/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.impl;

import de.vw.mib.asl.internal.list.impl.AbstractASLList$FetchTimerImpl;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.Invoker;

class AbstractASLList$FetchTimerImpl$1
implements Invoker {
    private final /* synthetic */ MIBInvoker val$invoker;
    private final /* synthetic */ AbstractASLList$FetchTimerImpl this$1;

    AbstractASLList$FetchTimerImpl$1(AbstractASLList$FetchTimerImpl abstractASLList$FetchTimerImpl, MIBInvoker mIBInvoker) {
        this.this$1 = abstractASLList$FetchTimerImpl;
        this.val$invoker = mIBInvoker;
    }

    @Override
    public void invoke(Runnable runnable) {
        this.val$invoker.invoke(runnable);
    }
}

