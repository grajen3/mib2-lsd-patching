/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.BlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$1;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$2;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$DefaultThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$DelegatedExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$DelegatedScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$FinalizableDelegatedExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$PrivilegedCallable;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$PrivilegedCallableUsingCurrentClassLoader;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$PrivilegedThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.Executors$RunnableAdapter;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.ScheduledThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.SynchronousQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadFactory;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;

public class Executors {
    public static ExecutorService newFixedThreadPool(int n) {
        return new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    public static ExecutorService newFixedThreadPool(int n, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(n, n, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingQueue(), threadFactory);
    }

    public static ExecutorService newSingleThreadExecutor() {
        return new Executors$FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()));
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new Executors$FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingQueue(), threadFactory));
    }

    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, -129, 0, TimeUnit.SECONDS, new SynchronousQueue());
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, -129, (long)0, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), threadFactory);
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new Executors$DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1));
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new Executors$DelegatedScheduledExecutorService(new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int n) {
        return new ScheduledThreadPoolExecutor(n);
    }

    public static ScheduledExecutorService newScheduledThreadPool(int n, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(n, threadFactory);
    }

    public static ExecutorService unconfigurableExecutorService(ExecutorService executorService) {
        if (executorService == null) {
            throw new NullPointerException();
        }
        return new Executors$DelegatedExecutorService(executorService);
    }

    public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            throw new NullPointerException();
        }
        return new Executors$DelegatedScheduledExecutorService(scheduledExecutorService);
    }

    public static ThreadFactory defaultThreadFactory() {
        return new Executors$DefaultThreadFactory();
    }

    public static ThreadFactory privilegedThreadFactory() {
        return new Executors$PrivilegedThreadFactory();
    }

    public static Callable callable(Runnable runnable, Object object) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        return new Executors$RunnableAdapter(runnable, object);
    }

    public static Callable callable(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        return new Executors$RunnableAdapter(runnable, null);
    }

    public static Callable callable(PrivilegedAction privilegedAction) {
        if (privilegedAction == null) {
            throw new NullPointerException();
        }
        return new Executors$1(privilegedAction);
    }

    public static Callable callable(PrivilegedExceptionAction privilegedExceptionAction) {
        if (privilegedExceptionAction == null) {
            throw new NullPointerException();
        }
        return new Executors$2(privilegedExceptionAction);
    }

    public static Callable privilegedCallable(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new Executors$PrivilegedCallable(callable);
    }

    public static Callable privilegedCallableUsingCurrentClassLoader(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        return new Executors$PrivilegedCallableUsingCurrentClassLoader(callable);
    }

    private Executors() {
    }
}

