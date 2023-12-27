/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;

public interface RejectedExecutionHandler {
    default public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
    }
}

