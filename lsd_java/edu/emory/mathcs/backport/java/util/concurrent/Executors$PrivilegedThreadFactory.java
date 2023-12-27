/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Executors$5;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$DefaultThreadFactory;
import java.security.AccessControlContext;
import java.security.AccessController;

class Executors$PrivilegedThreadFactory
extends Executors$DefaultThreadFactory {
    private final ClassLoader ccl = Thread.currentThread().getContextClassLoader();
    private final AccessControlContext acc = AccessController.getContext();

    Executors$PrivilegedThreadFactory() {
        this.acc.checkPermission(new RuntimePermission("setContextClassLoader"));
    }

    @Override
    public Thread newThread(Runnable runnable) {
        return super.newThread(new Executors$5(this, runnable));
    }

    static /* synthetic */ ClassLoader access$800(Executors$PrivilegedThreadFactory executors$PrivilegedThreadFactory) {
        return executors$PrivilegedThreadFactory.ccl;
    }

    static /* synthetic */ AccessControlContext access$1000(Executors$PrivilegedThreadFactory executors$PrivilegedThreadFactory) {
        return executors$PrivilegedThreadFactory.acc;
    }
}

