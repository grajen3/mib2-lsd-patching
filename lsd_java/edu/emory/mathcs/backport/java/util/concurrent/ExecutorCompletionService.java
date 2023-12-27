/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.AbstractExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.CompletionService;
import edu.emory.mathcs.backport.java.util.concurrent.Executor;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorCompletionService$QueueingFuture;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.FutureTask;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableFuture;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public class ExecutorCompletionService
implements CompletionService {
    private final Executor executor;
    private final AbstractExecutorService aes;
    private final BlockingQueue completionQueue;

    private RunnableFuture newTaskFor(Callable callable) {
        if (this.aes == null) {
            return new FutureTask(callable);
        }
        return this.aes.newTaskFor(callable);
    }

    private RunnableFuture newTaskFor(Runnable runnable, Object object) {
        if (this.aes == null) {
            return new FutureTask(runnable, object);
        }
        return this.aes.newTaskFor(runnable, object);
    }

    public ExecutorCompletionService(Executor executor) {
        if (executor == null) {
            throw new NullPointerException();
        }
        this.executor = executor;
        this.aes = executor instanceof AbstractExecutorService ? (AbstractExecutorService)executor : null;
        this.completionQueue = new LinkedBlockingQueue();
    }

    public ExecutorCompletionService(Executor executor, BlockingQueue blockingQueue) {
        if (executor == null || blockingQueue == null) {
            throw new NullPointerException();
        }
        this.executor = executor;
        this.aes = executor instanceof AbstractExecutorService ? (AbstractExecutorService)executor : null;
        this.completionQueue = blockingQueue;
    }

    @Override
    public Future submit(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        RunnableFuture runnableFuture = this.newTaskFor(callable);
        this.executor.execute(new ExecutorCompletionService$QueueingFuture(this, runnableFuture));
        return runnableFuture;
    }

    @Override
    public Future submit(Runnable runnable, Object object) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture runnableFuture = this.newTaskFor(runnable, object);
        this.executor.execute(new ExecutorCompletionService$QueueingFuture(this, runnableFuture));
        return runnableFuture;
    }

    @Override
    public Future take() {
        return (Future)this.completionQueue.take();
    }

    @Override
    public Future poll() {
        return (Future)this.completionQueue.poll();
    }

    @Override
    public Future poll(long l, TimeUnit timeUnit) {
        return (Future)this.completionQueue.poll(l, timeUnit);
    }

    static /* synthetic */ BlockingQueue access$000(ExecutorCompletionService executorCompletionService) {
        return executorCompletionService.completionQueue;
    }
}

