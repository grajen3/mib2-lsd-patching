/*
 * Decompiled with CFR 0.152.
 */
package edu.emory.mathcs.backport.java.util.concurrent;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;
import edu.emory.mathcs.backport.java.util.concurrent.CancellationException;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutionException;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorCompletionService;
import edu.emory.mathcs.backport.java.util.concurrent.ExecutorService;
import edu.emory.mathcs.backport.java.util.concurrent.Future;
import edu.emory.mathcs.backport.java.util.concurrent.FutureTask;
import edu.emory.mathcs.backport.java.util.concurrent.RunnableFuture;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;
import edu.emory.mathcs.backport.java.util.concurrent.TimeoutException;
import edu.emory.mathcs.backport.java.util.concurrent.helpers.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractExecutorService
implements ExecutorService {
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$edu$emory$mathcs$backport$java$util$concurrent$AbstractExecutorService;

    protected RunnableFuture newTaskFor(Runnable runnable, Object object) {
        return new FutureTask(runnable, object);
    }

    protected RunnableFuture newTaskFor(Callable callable) {
        return new FutureTask(callable);
    }

    @Override
    public Future submit(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture runnableFuture = this.newTaskFor(runnable, null);
        this.execute(runnableFuture);
        return runnableFuture;
    }

    @Override
    public Future submit(Runnable runnable, Object object) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        RunnableFuture runnableFuture = this.newTaskFor(runnable, object);
        this.execute(runnableFuture);
        return runnableFuture;
    }

    @Override
    public Future submit(Callable callable) {
        if (callable == null) {
            throw new NullPointerException();
        }
        RunnableFuture runnableFuture = this.newTaskFor(callable);
        this.execute(runnableFuture);
        return runnableFuture;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    private Object doInvokeAny(Collection var1_1, boolean var2_2, long var3_3) {
        block18: {
            if (var1_1 == null) {
                throw new NullPointerException();
            }
            var5_4 = var1_1.size();
            if (var5_4 == 0) {
                throw new IllegalArgumentException();
            }
            var6_5 = new ArrayList(var5_4);
            var7_6 = new ExecutorCompletionService(this);
            var8_7 = null;
            var9_8 = var2_2 != false ? Utils.nanoTime() : 0L;
            var11_9 = var1_1.iterator();
            var6_5.add(var7_6.submit((Callable)var11_9.next()));
            --var5_4;
            var12_10 = 1;
            while (true) lbl-1000:
            // 4 sources

            {
                if ((var13_11 = var7_6.poll()) == null) {
                    if (var5_4 > 0) {
                        --var5_4;
                        var6_5.add(var7_6.submit((Callable)var11_9.next()));
                        ++var12_10;
                    } else {
                        if (var12_10 == 0) ** break;
                        if (var2_2) {
                            var13_11 = var7_6.poll(var3_3, TimeUnit.NANOSECONDS);
                            if (var13_11 == null) {
                                throw new TimeoutException();
                            }
                            var14_12 = Utils.nanoTime();
                            var3_3 -= var14_12 - var9_8;
                            var9_8 = var14_12;
                        } else {
                            var13_11 = var7_6.take();
                        }
                    }
                }
                if (var13_11 == null) continue;
                --var12_10;
                try {
                    var14_13 = var13_11.get();
                    return var14_13;
                }
                catch (InterruptedException var14_14) {
                    throw var14_14;
                }
                catch (ExecutionException var14_15) {
                    var8_7 = var14_15;
                }
                catch (RuntimeException var14_16) {
                    var8_7 = new ExecutionException(var14_16);
                    continue;
                }
                break;
            }
            ** GOTO lbl-1000
            if (var8_7 != null) break block18;
            var8_7 = new ExecutionException();
        }
        throw var8_7;
        finally {
            var18_17 = var6_5.iterator();
            while (var18_17.hasNext()) {
                ((Future)var18_17.next()).cancel(true);
            }
        }
    }

    @Override
    public Object invokeAny(Collection collection) {
        try {
            return this.doInvokeAny(collection, false, 0L);
        }
        catch (TimeoutException timeoutException) {
            if (!$assertionsDisabled) {
                throw new AssertionError();
            }
            return null;
        }
    }

    @Override
    public Object invokeAny(Collection collection, long l, TimeUnit timeUnit) {
        return this.doInvokeAny(collection, true, timeUnit.toNanos(l));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List invokeAll(Collection collection) {
        if (collection == null) {
            throw new NullPointerException();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        boolean bl = false;
        try {
            Future future;
            Object object = collection.iterator();
            while (object.hasNext()) {
                future = this.newTaskFor((Callable)object.next());
                arrayList.add(future);
                this.execute((Runnable)((Object)future));
            }
            object = arrayList.iterator();
            while (object.hasNext()) {
                future = (Future)object.next();
                if (future.isDone()) continue;
                try {
                    future.get();
                }
                catch (CancellationException cancellationException) {
                }
                catch (ExecutionException executionException) {}
            }
            bl = true;
            object = arrayList;
            return object;
        }
        finally {
            if (!bl) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    Future future = (Future)iterator.next();
                    future.cancel(true);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List invokeAll(Collection collection, long l, TimeUnit timeUnit) {
        if (collection == null || timeUnit == null) {
            throw new NullPointerException();
        }
        long l2 = timeUnit.toNanos(l);
        ArrayList arrayList = new ArrayList(collection.size());
        boolean bl = false;
        try {
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                arrayList.add(this.newTaskFor((Callable)iterator.next()));
            }
            long l3 = Utils.nanoTime();
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                this.execute((Runnable)iterator2.next());
                long l4 = Utils.nanoTime();
                l3 = l4;
                if ((l2 -= l4 - l3) > 0L) continue;
                ArrayList arrayList2 = arrayList;
                return arrayList2;
            }
            Object object = arrayList.iterator();
            while (object.hasNext()) {
                Future future = (Future)object.next();
                if (future.isDone()) continue;
                if (l2 <= 0L) {
                    ArrayList arrayList3 = arrayList;
                    return arrayList3;
                }
                try {
                    future.get(l2, TimeUnit.NANOSECONDS);
                }
                catch (CancellationException cancellationException) {
                }
                catch (ExecutionException executionException) {
                }
                catch (TimeoutException timeoutException) {
                    ArrayList arrayList4 = arrayList;
                    if (!bl) {
                        Iterator iterator3 = arrayList.iterator();
                        while (iterator3.hasNext()) {
                            Future future2 = (Future)iterator3.next();
                            future2.cancel(true);
                        }
                    }
                    return arrayList4;
                }
                long l5 = Utils.nanoTime();
                l2 -= l5 - l3;
                l3 = l5;
            }
            bl = true;
            object = arrayList;
            return object;
        }
        finally {
            if (!bl) {
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    Future future = (Future)iterator.next();
                    future.cancel(true);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$edu$emory$mathcs$backport$java$util$concurrent$AbstractExecutorService == null ? (class$edu$emory$mathcs$backport$java$util$concurrent$AbstractExecutorService = AbstractExecutorService.class$("edu.emory.mathcs.backport.java.util.concurrent.AbstractExecutorService")) : class$edu$emory$mathcs$backport$java$util$concurrent$AbstractExecutorService).desiredAssertionStatus();
    }
}

