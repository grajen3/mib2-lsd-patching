/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.threads.internal.AsyncServiceFactoryImpl$Invocation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

class AsyncServiceFactoryImpl$AsyncServiceImpl
implements InvocationHandler {
    private final MIBInvoker invoker;
    private final Object service;
    private final Set restriction;

    AsyncServiceFactoryImpl$AsyncServiceImpl(MIBInvoker mIBInvoker, Object object, Set set) {
        this.invoker = mIBInvoker;
        this.service = object;
        this.restriction = set;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        if (Void.TYPE == method.getReturnType() && (null == this.restriction || this.restriction.contains(method.getDeclaringClass()))) {
            AsyncServiceFactoryImpl$Invocation asyncServiceFactoryImpl$Invocation = AsyncServiceFactoryImpl$Invocation.create(this.service, method, objectArray);
            this.invoker.invoke(asyncServiceFactoryImpl$Invocation);
            return null;
        }
        try {
            return method.invoke(this.service, objectArray);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw invocationTargetException.getTargetException();
        }
    }
}

