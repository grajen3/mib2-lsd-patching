/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.adapter;

import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.collections.ObjectIntOptHashMap;
import de.vw.mib.reflection.InvocationHandler;
import java.lang.reflect.Method;
import java.util.IdentityHashMap;
import java.util.Map;

abstract class AbstractMethodAdapter
extends InvocationHandler {
    private static final Map RESOLVED_METHODS = new IdentityHashMap();

    AbstractMethodAdapter() {
    }

    protected static ObjectIntMap getResolvedMs(Object object) {
        ObjectIntMap objectIntMap = (ObjectIntMap)RESOLVED_METHODS.get(object);
        if (objectIntMap == null) {
            objectIntMap = new ObjectIntOptHashMap();
            RESOLVED_METHODS.put(object, objectIntMap);
        }
        return objectIntMap;
    }

    protected static String buildKey(String string, Method method) {
        return new StringBuffer(120).append(string).append("/#").append(method.getDeclaringClass()).append(".").append(method.getName()).toString();
    }
}

