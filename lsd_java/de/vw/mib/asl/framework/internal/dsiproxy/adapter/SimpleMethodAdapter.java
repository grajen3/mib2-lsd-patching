/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.adapter;

import de.vw.mib.asl.framework.internal.dsiproxy.adapter.AbstractMethodAdapter;
import de.vw.mib.asl.framework.internal.dsiproxy.adapter.MethodResolver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class SimpleMethodAdapter
extends AbstractMethodAdapter {
    private final Object consumer;
    private final String consumerClassName;
    private final MethodResolver methodResolver;
    private final Class listenerType;
    private final MultipleMethodAccessibleObject mmao;

    SimpleMethodAdapter(Object object, MethodResolver methodResolver, Class clazz, MultipleMethodAccessibleObject multipleMethodAccessibleObject) {
        this.consumer = object;
        this.consumerClassName = object.getClass().getName();
        this.methodResolver = methodResolver;
        this.listenerType = clazz;
        this.mmao = multipleMethodAccessibleObject;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object invoke(Object object, Method method, int n, Object[] objectArray) {
        try {
            int n2;
            String string = SimpleMethodAdapter.buildKey(this.consumerClassName, method);
            ObjectIntMap objectIntMap = SimpleMethodAdapter.getResolvedMs(this.mmao);
            if (!objectIntMap.containsKey(string)) {
                String string2 = this.methodResolver.resolveName(this.consumer, this.listenerType, method);
                Class[] classArray = method.getParameterTypes();
                n2 = this.mmao.getIndex(this.consumerClassName, string2, classArray);
                objectIntMap.put(string, n2);
            } else {
                n2 = objectIntMap.get(string);
            }
            if (-1 < n2) {
                try {
                    Utils.debugInvokeListenerMethodAdapter(this.consumerClassName, n2, objectArray);
                    this.mmao.invoke(n2, this.consumer, objectArray);
                }
                catch (InvocationTargetException invocationTargetException) {
                    ServiceManager.loggerDSIProxy.error().append("Invocation of DSI method ").append(method.getName()).append(" failed on ").append(this.consumerClassName).attachThrowable(invocationTargetException.getTargetException()).log();
                }
                catch (Throwable throwable) {
                    ServiceManager.loggerDSIProxy.error().append("Invocation of DSI method ").append(method.getName()).append(" failed on ").append(this.consumerClassName).attachThrowable(throwable).log();
                }
            }
        }
        finally {
            Constants.PROXY_OAP.returnArray(objectArray);
        }
        return null;
    }
}

