/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.adapter;

import de.vw.mib.asl.framework.internal.dsiproxy.adapter.AbstractMethodAdapter;
import de.vw.mib.asl.framework.internal.dsiproxy.adapter.MethodResolver;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.asl.framework.internal.framework.reflection.ReflectionException;
import de.vw.mib.collections.ObjectIntMap;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class HsmMethodAdapter
extends AbstractMethodAdapter {
    private final Hsm hsm;
    private final MethodResolver methodResolver;
    private final Class listenerType;

    HsmMethodAdapter(Hsm hsm, MethodResolver methodResolver, Class clazz) {
        this.hsm = hsm;
        this.methodResolver = methodResolver;
        this.listenerType = clazz;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object invoke(Object object, Method method, int n, Object[] objectArray) {
        try {
            boolean bl;
            if (null == method) {
                throw new NullPointerException("method");
            }
            HsmState hsmState = this.hsm.getState();
            boolean bl2 = bl = null != hsmState;
            while (null != hsmState) {
                int n2;
                Object object2;
                String string;
                MultipleMethodAccessibleObject multipleMethodAccessibleObject;
                String string2 = super.getClass().getName();
                try {
                    multipleMethodAccessibleObject = ServiceManager.reflectionFactory.getHsmStatesMmao(string2);
                }
                catch (ReflectionException reflectionException) {
                    ServiceManager.loggerDSIProxy.warn().append(reflectionException.getMessage()).log();
                    multipleMethodAccessibleObject = null;
                }
                if (null == multipleMethodAccessibleObject) {
                    hsmState = hsmState.getParent();
                    continue;
                }
                ObjectIntMap objectIntMap = HsmMethodAdapter.getResolvedMs(multipleMethodAccessibleObject);
                if (!objectIntMap.containsKey(string = HsmMethodAdapter.buildKey(string2, method))) {
                    object2 = this.methodResolver.resolveName(hsmState, this.listenerType, method);
                    Class[] classArray = method.getParameterTypes();
                    n2 = multipleMethodAccessibleObject.getIndex(string2, (String)object2, classArray);
                    objectIntMap.put(string, n2);
                } else {
                    n2 = objectIntMap.get(string);
                }
                if (-1 == n2) {
                    hsmState = hsmState.getParent();
                    continue;
                }
                try {
                    Utils.debugInvokeListenerMethodAdapter(string2, n2, objectArray);
                    object2 = multipleMethodAccessibleObject.invoke(n2, hsmState, objectArray);
                }
                catch (InvocationTargetException invocationTargetException) {
                    ServiceManager.loggerDSIProxy.error().append("Invocation of DSI method ").append(method.getName()).append(" failed on HSM state").attachThrowable(invocationTargetException.getTargetException()).log();
                    object2 = null;
                }
                catch (Throwable throwable) {
                    ServiceManager.loggerDSIProxy.error().append("Invocation of DSI method ").append(method.getName()).append(" failed on HSM state").attachThrowable(throwable).log();
                    object2 = null;
                }
                if (object2 == hsmState) {
                    ServiceManager.loggerDSIProxy.error().append("HSM state returned itself as handling state - breaking endless loop: state=").append(hsmState).append(", method=").append(this.methodResolver.resolveName(hsmState, this.listenerType, method)).log();
                    hsmState = null;
                }
                hsmState = (HsmState)object2;
            }
            if (bl) {
                try {
                    this.hsm.activateTransition();
                }
                catch (Exception exception) {
                    ServiceManager.loggerDSIProxy.error().append("HSM transition failed").attachThrowable(exception).log();
                }
            }
        }
        finally {
            Constants.PROXY_OAP.returnArray(objectArray);
        }
        return null;
    }
}

