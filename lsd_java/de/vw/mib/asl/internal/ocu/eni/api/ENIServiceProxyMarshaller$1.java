/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller;
import java.lang.reflect.Method;
import java.util.Comparator;

class ENIServiceProxyMarshaller$1
implements Comparator {
    private final /* synthetic */ ENIServiceProxyMarshaller this$0;

    ENIServiceProxyMarshaller$1(ENIServiceProxyMarshaller eNIServiceProxyMarshaller) {
        this.this$0 = eNIServiceProxyMarshaller;
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Method)object).getName().compareTo(((Method)object2).getName());
    }
}

