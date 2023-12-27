/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api;

import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxyMarshaller;
import java.lang.reflect.Method;
import java.util.Comparator;

class ECallServiceProxyMarshaller$1
implements Comparator {
    private final /* synthetic */ ECallServiceProxyMarshaller this$0;

    ECallServiceProxyMarshaller$1(ECallServiceProxyMarshaller eCallServiceProxyMarshaller) {
        this.this$0 = eCallServiceProxyMarshaller;
    }

    @Override
    public int compare(Object object, Object object2) {
        return ((Method)object).getName().compareTo(((Method)object2).getName());
    }
}

