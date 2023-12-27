/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navigation.internal.logging;

import de.vw.mib.asl.navigation.internal.logging.LoggingProxyInvocationHandler;
import java.lang.reflect.Proxy;

public final class LoggingProxy {
    public static boolean useLoggingProxy() {
        String string = System.getProperty("de.vw.mib.asl.api.navigation.useLoggingProxy");
        if (string == null) {
            return false;
        }
        return Boolean.valueOf(string);
    }

    public static Object createLoggingProxyInstance(Class clazz, Object object) {
        ClassLoader classLoader = clazz.getClassLoader();
        Class[] classArray = new Class[]{clazz};
        LoggingProxyInvocationHandler loggingProxyInvocationHandler = new LoggingProxyInvocationHandler(object);
        Object object2 = Proxy.newProxyInstance(classLoader, classArray, loggingProxyInvocationHandler);
        return object2;
    }
}

