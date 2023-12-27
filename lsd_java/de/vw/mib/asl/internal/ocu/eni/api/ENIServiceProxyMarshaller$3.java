/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller;
import de.vw.mib.genericevents.EventGeneric;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class ENIServiceProxyMarshaller$3
implements InvocationHandler {
    private final /* synthetic */ ENIServiceProxyMarshaller this$0;

    ENIServiceProxyMarshaller$3(ENIServiceProxyMarshaller eNIServiceProxyMarshaller) {
        this.this$0 = eNIServiceProxyMarshaller;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objectArray) {
        EventGeneric eventGeneric = ENIServiceProxyMarshaller.access$000(-1182400256);
        eventGeneric.setObject(0, method);
        eventGeneric.setObject(1, objectArray);
        ENIServiceProxyMarshaller.access$100(this.this$0, eventGeneric);
        return null;
    }
}

