/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import java.lang.reflect.Method;

class ENIServiceProxyMarshaller$ENIServiceNotifier
implements ServiceNotifier {
    private Method _method;
    private Object[] _args;

    public void setMethod(Method method) {
        this._method = method;
    }

    public Method getMethod() {
        return this._method;
    }

    public Object[] getArgs() {
        return this._args;
    }

    public void setArgs(Object[] objectArray) {
        this._args = objectArray;
    }

    @Override
    public void notifyServiceListener(Object object) {
        this.getMethod().invoke(object, this.getArgs());
    }
}

