/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.threads.internal.AsyncServiceFactoryImpl$AsyncServiceImpl;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AsyncServiceFactoryImpl
implements AsyncServiceFactory {
    private final MIBInvoker invoker;

    public AsyncServiceFactoryImpl(MIBInvoker mIBInvoker) {
        if (null == mIBInvoker) {
            throw new NullPointerException("invoker");
        }
        this.invoker = mIBInvoker;
    }

    @Override
    public Object create(Object object) {
        return this.create(object, null);
    }

    @Override
    public Object create(Object object, Class[] classArray) {
        Class clazz = object.getClass();
        Class[] classArray2 = AsyncServiceFactoryImpl.gatherInterfaces(clazz);
        ClassLoader classLoader = AsyncServiceFactoryImpl.findClassLoader(clazz);
        Set set = null != classArray && 0 < classArray.length ? new HashSet(Arrays.asList(classArray)) : (Set)null;
        AsyncServiceFactoryImpl$AsyncServiceImpl asyncServiceFactoryImpl$AsyncServiceImpl = new AsyncServiceFactoryImpl$AsyncServiceImpl(this.invoker, object, set);
        return Proxy.newProxyInstance(classLoader, classArray2, asyncServiceFactoryImpl$AsyncServiceImpl);
    }

    @Override
    public Object createNarrow(Object object, Class[] classArray) {
        Class clazz = object.getClass();
        ClassLoader classLoader = AsyncServiceFactoryImpl.findClassLoader(clazz);
        AsyncServiceFactoryImpl$AsyncServiceImpl asyncServiceFactoryImpl$AsyncServiceImpl = new AsyncServiceFactoryImpl$AsyncServiceImpl(this.invoker, object, null);
        return Proxy.newProxyInstance(classLoader, classArray, asyncServiceFactoryImpl$AsyncServiceImpl);
    }

    private static ClassLoader findClassLoader(Class clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        if (null == classLoader) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        if (null == classLoader) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return classLoader;
    }

    private static Class[] gatherInterfaces(Class clazz) {
        HashSet hashSet = new HashSet();
        do {
            AsyncServiceFactoryImpl.gatherInterfaces(clazz, hashSet);
        } while (null != (clazz = clazz.getSuperclass()));
        return (Class[])hashSet.toArray(new Class[hashSet.size()]);
    }

    private static void gatherInterfaces(Class clazz, Collection collection) {
        if (clazz.isInterface() && Modifier.isPublic(clazz.getModifiers())) {
            collection.add(clazz);
        }
        Class[] classArray = clazz.getInterfaces();
        for (int i2 = 0; i2 < classArray.length; ++i2) {
            AsyncServiceFactoryImpl.gatherInterfaces(classArray[i2], collection);
        }
    }
}

