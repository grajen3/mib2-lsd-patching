/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.pool.PoorMansPool;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class AsyncServiceFactoryImpl$Invocation
implements Runnable {
    private static final int MAX_POOL_SIZE;
    private static final PoorMansPool POOL;
    private Object service;
    private Method method;
    private Object[] args;

    private AsyncServiceFactoryImpl$Invocation() {
    }

    private AsyncServiceFactoryImpl$Invocation init(Object object, Method method, Object[] objectArray) {
        this.service = object;
        this.method = method;
        this.args = objectArray;
        return this;
    }

    private static AsyncServiceFactoryImpl$Invocation borrow() {
        AsyncServiceFactoryImpl$Invocation asyncServiceFactoryImpl$Invocation = (AsyncServiceFactoryImpl$Invocation)POOL.borrow();
        if (null == asyncServiceFactoryImpl$Invocation) {
            asyncServiceFactoryImpl$Invocation = new AsyncServiceFactoryImpl$Invocation();
        }
        return asyncServiceFactoryImpl$Invocation;
    }

    void release() {
        this.service = null;
        this.method = null;
        this.args = null;
        POOL.release(this);
    }

    static AsyncServiceFactoryImpl$Invocation create(Object object, Method method, Object[] objectArray) {
        return AsyncServiceFactoryImpl$Invocation.borrow().init(object, method, objectArray);
    }

    @Override
    public void run() {
        try {
            this.method.invoke(this.service, this.args);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException(invocationTargetException.getTargetException());
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        finally {
            this.release();
        }
    }

    static {
        POOL = new PoorMansPool("AsyncService.Invocation", 30);
    }
}

