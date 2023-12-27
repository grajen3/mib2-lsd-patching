/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Executors$5;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$PrivilegedThreadFactory;
import java.security.PrivilegedAction;

class Executors$6
implements PrivilegedAction {
    private final /* synthetic */ Executors$5 this$1;

    Executors$6(Executors$5 executors$5) {
        this.this$1 = executors$5;
    }

    @Override
    public Object run() {
        Thread.currentThread().setContextClassLoader(Executors$PrivilegedThreadFactory.access$800(Executors$5.access$700(this.this$1)));
        Executors$5.access$900(this.this$1).run();
        return null;
    }
}

