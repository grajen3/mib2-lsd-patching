/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$4;
import java.security.AccessControlContext;
import java.security.AccessController;

final class Executors$PrivilegedCallableUsingCurrentClassLoader
implements Callable {
    private final ClassLoader ccl;
    private final AccessControlContext acc;
    private final Callable task;
    private Object result;
    private Exception exception;

    Executors$PrivilegedCallableUsingCurrentClassLoader(Callable callable) {
        this.task = callable;
        this.ccl = Thread.currentThread().getContextClassLoader();
        this.acc = AccessController.getContext();
        this.acc.checkPermission(new RuntimePermission("getContextClassLoader"));
        this.acc.checkPermission(new RuntimePermission("setContextClassLoader"));
    }

    @Override
    public Object call() {
        AccessController.doPrivileged(new Executors$4(this), this.acc);
        if (this.exception != null) {
            throw this.exception;
        }
        return this.result;
    }

    static /* synthetic */ ClassLoader access$300(Executors$PrivilegedCallableUsingCurrentClassLoader executors$PrivilegedCallableUsingCurrentClassLoader) {
        return executors$PrivilegedCallableUsingCurrentClassLoader.ccl;
    }

    static /* synthetic */ Object access$402(Executors$PrivilegedCallableUsingCurrentClassLoader executors$PrivilegedCallableUsingCurrentClassLoader, Object object) {
        executors$PrivilegedCallableUsingCurrentClassLoader.result = object;
        return executors$PrivilegedCallableUsingCurrentClassLoader.result;
    }

    static /* synthetic */ Callable access$500(Executors$PrivilegedCallableUsingCurrentClassLoader executors$PrivilegedCallableUsingCurrentClassLoader) {
        return executors$PrivilegedCallableUsingCurrentClassLoader.task;
    }

    static /* synthetic */ Exception access$602(Executors$PrivilegedCallableUsingCurrentClassLoader executors$PrivilegedCallableUsingCurrentClassLoader, Exception exception) {
        executors$PrivilegedCallableUsingCurrentClassLoader.exception = exception;
        return executors$PrivilegedCallableUsingCurrentClassLoader.exception;
    }
}

