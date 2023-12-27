/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent.helpers;

import edu.emory.mathcs.backport.java.util.concurrent.helpers.ThreadHelpers$1;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.ThreadHelpers$UncaughtExceptionHandler;

public class ThreadHelpers {
    private ThreadHelpers() {
    }

    public static Runnable assignExceptionHandler(Runnable runnable, UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (runnable == null || uncaughtExceptionHandler == null) {
            throw new NullPointerException();
        }
        return new ThreadHelpers$1(runnable, uncaughtExceptionHandler);
    }
}

