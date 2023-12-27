/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.ThreadHelpers$UncaughtExceptionHandler;

class ThreadHelpers$1
implements Runnable {
    private final /* synthetic */ Runnable val$runnable;
    private final /* synthetic */ ThreadHelpers$UncaughtExceptionHandler val$handler;

    ThreadHelpers$1(Runnable runnable, ThreadHelpers$UncaughtExceptionHandler threadHelpers$UncaughtExceptionHandler) {
        this.val$runnable = runnable;
        this.val$handler = threadHelpers$UncaughtExceptionHandler;
    }

    @Override
    public void run() {
        try {
            this.val$runnable.run();
        }
        catch (Throwable throwable) {
            try {
                this.val$handler.uncaughtException(Thread.currentThread(), throwable);
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
        }
    }
}

