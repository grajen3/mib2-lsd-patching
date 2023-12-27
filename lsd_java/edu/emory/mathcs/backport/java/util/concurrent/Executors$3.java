/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Executors$PrivilegedCallable;
import java.security.PrivilegedAction;

class Executors$3
implements PrivilegedAction {
    private final /* synthetic */ Executors$PrivilegedCallable this$0;

    Executors$3(Executors$PrivilegedCallable executors$PrivilegedCallable) {
        this.this$0 = executors$PrivilegedCallable;
    }

    @Override
    public Object run() {
        try {
            Executors$PrivilegedCallable.access$002(this.this$0, Executors$PrivilegedCallable.access$100(this.this$0).call());
        }
        catch (Exception exception) {
            Executors$PrivilegedCallable.access$202(this.this$0, exception);
        }
        return null;
    }
}

