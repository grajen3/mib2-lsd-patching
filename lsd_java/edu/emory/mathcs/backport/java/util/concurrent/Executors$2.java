/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import java.security.PrivilegedExceptionAction;

class Executors$2
implements Callable {
    private final /* synthetic */ PrivilegedExceptionAction val$action;

    Executors$2(PrivilegedExceptionAction privilegedExceptionAction) {
        this.val$action = privilegedExceptionAction;
    }

    @Override
    public Object call() {
        return this.val$action.run();
    }
}

