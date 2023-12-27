/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import java.security.PrivilegedAction;

class Executors$1
implements Callable {
    private final /* synthetic */ PrivilegedAction val$action;

    Executors$1(PrivilegedAction privilegedAction) {
        this.val$action = privilegedAction;
    }

    @Override
    public Object call() {
        return this.val$action.run();
    }
}

