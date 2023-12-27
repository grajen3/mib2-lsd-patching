/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$3;
import java.security.AccessControlContext;
import java.security.AccessController;

final class Executors$PrivilegedCallable
implements Callable {
    private final AccessControlContext acc;
    private final Callable task;
    private Object result;
    private Exception exception;

    Executors$PrivilegedCallable(Callable callable) {
        this.task = callable;
        this.acc = AccessController.getContext();
    }

    @Override
    public Object call() {
        AccessController.doPrivileged(new Executors$3(this), this.acc);
        if (this.exception != null) {
            throw this.exception;
        }
        return this.result;
    }

    static /* synthetic */ Object access$002(Executors$PrivilegedCallable executors$PrivilegedCallable, Object object) {
        executors$PrivilegedCallable.result = object;
        return executors$PrivilegedCallable.result;
    }

    static /* synthetic */ Callable access$100(Executors$PrivilegedCallable executors$PrivilegedCallable) {
        return executors$PrivilegedCallable.task;
    }

    static /* synthetic */ Exception access$202(Executors$PrivilegedCallable executors$PrivilegedCallable, Exception exception) {
        executors$PrivilegedCallable.exception = exception;
        return executors$PrivilegedCallable.exception;
    }
}

