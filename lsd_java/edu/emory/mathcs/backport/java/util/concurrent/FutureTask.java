/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.CancellationException;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutionException;
import edu.emory.mathcs.backport.java.util.concurrent.Executors;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableFuture;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;

public class FutureTask
implements RunnableFuture {
    private static final int READY;
    private static final int RUNNING;
    private static final int RAN;
    private static final int CANCELLED;
    private final Callable callable;
    private Object result;
    private Throwable exception;
    private int state;
    private volatile Thread runner;

    public FutureTask(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        this.callable = callable;
    }

    public FutureTask(Runnable runnable, Object object) {
        this(Executors.callable(runnable, object));
    }

    @Override
    public synchronized boolean isCancelled() {
        return this.state == 4;
    }

    @Override
    public synchronized boolean isDone() {
        return this.ranOrCancelled() && this.runner == null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean cancel(boolean bl) {
        FutureTask futureTask = this;
        synchronized (futureTask) {
            Thread thread;
            if (this.ranOrCancelled()) {
                return false;
            }
            this.state = 4;
            if (bl && (thread = this.runner) != null) {
                thread.interrupt();
            }
            this.runner = null;
            super.notifyAll();
        }
        this.done();
        return true;
    }

    @Override
    public synchronized Object get() {
        this.waitFor();
        return this.getResult();
    }

    @Override
    public synchronized Object get(long l, TimeUnit timeUnit) {
        this.waitFor(timeUnit.toNanos(l));
        return this.getResult();
    }

    protected void done() {
    }

    protected void set(Object object) {
        this.setCompleted(object);
    }

    protected void setException(Throwable throwable) {
        this.setFailed(throwable);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        FutureTask futureTask = this;
        synchronized (futureTask) {
            if (this.state != 0) {
                return;
            }
            this.state = 1;
            this.runner = Thread.currentThread();
        }
        try {
            this.set(this.callable.call());
        }
        catch (Throwable throwable) {
            this.setException(throwable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean runAndReset() {
        FutureTask futureTask = this;
        synchronized (futureTask) {
            if (this.state != 0) {
                return false;
            }
            this.state = 1;
            this.runner = Thread.currentThread();
        }
        try {
            this.callable.call();
            futureTask = this;
            synchronized (futureTask) {
                this.runner = null;
                if (this.state == 1) {
                    this.state = 0;
                    return true;
                }
                return false;
            }
        }
        catch (Throwable throwable) {
            this.setException(throwable);
            return false;
        }
    }

    private boolean ranOrCancelled() {
        return (this.state & 6) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setCompleted(Object object) {
        FutureTask futureTask = this;
        synchronized (futureTask) {
            if (this.ranOrCancelled()) {
                return;
            }
            this.state = 2;
            this.result = object;
            this.runner = null;
            super.notifyAll();
        }
        this.done();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setFailed(Throwable throwable) {
        FutureTask futureTask = this;
        synchronized (futureTask) {
            if (this.ranOrCancelled()) {
                return;
            }
            this.state = 2;
            this.exception = throwable;
            this.runner = null;
            super.notifyAll();
        }
        this.done();
    }

    private void waitFor() {
        while (!this.isDone()) {
            super.wait();
        }
    }

    private void waitFor(long l) {
        if (l < 0L) {
            throw new IllegalArgumentException();
        }
        if (this.isDone()) {
            return;
        }
        long l2 = Utils.nanoTime() + l;
        while (l > 0L) {
            TimeUnit.NANOSECONDS.timedWait(this, l);
            if (this.isDone()) {
                return;
            }
            l = l2 - Utils.nanoTime();
        }
        throw new TimeoutException();
    }

    private Object getResult() {
        if (this.state == 4) {
            throw new CancellationException();
        }
        if (this.exception != null) {
            throw new ExecutionException(this.exception);
        }
        return this.result;
    }
}

