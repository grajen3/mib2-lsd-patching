/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.ExecutorCompletionService;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.FutureTask;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableFuture;

class ExecutorCompletionService$QueueingFuture
extends FutureTask {
    private final Future task;
    private final /* synthetic */ ExecutorCompletionService this$0;

    ExecutorCompletionService$QueueingFuture(ExecutorCompletionService executorCompletionService, RunnableFuture runnableFuture) {
        this.this$0 = executorCompletionService;
        super(runnableFuture, null);
        this.task = runnableFuture;
    }

    @Override
    protected void done() {
        ExecutorCompletionService.access$000(this.this$0).add(this.task);
    }
}

