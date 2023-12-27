/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.adapter;

import java.lang.reflect.Method;

interface MethodResolver {
    default public String resolveName(Object object, Class clazz, Method method) {
    }
}

