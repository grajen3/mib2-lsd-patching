/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Executors$6;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$PrivilegedThreadFactory;
import java.security.AccessController;

class Executors$5
implements Runnable {
    private final /* synthetic */ Runnable val$r;
    private final /* synthetic */ Executors$PrivilegedThreadFactory this$0;

    Executors$5(Executors$PrivilegedThreadFactory executors$PrivilegedThreadFactory, Runnable runnable) {
        this.this$0 = executors$PrivilegedThreadFactory;
        this.val$r = runnable;
    }

    @Override
    public void run() {
        AccessController.doPrivileged(new Executors$6(this), Executors$PrivilegedThreadFactory.access$1000(this.this$0));
    }

    static /* synthetic */ Executors$PrivilegedThreadFactory access$700(Executors$5 executors$5) {
        return executors$5.this$0;
    }

    static /* synthetic */ Runnable access$900(Executors$5 executors$5) {
        return executors$5.val$r;
    }
}

