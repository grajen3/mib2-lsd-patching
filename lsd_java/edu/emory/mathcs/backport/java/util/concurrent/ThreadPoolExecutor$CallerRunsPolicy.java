/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.RejectedExecutionHandler;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutor$CallerRunsPolicy
implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        if (!threadPoolExecutor.isShutdown()) {
            runnable.run();
        }
    }
}

