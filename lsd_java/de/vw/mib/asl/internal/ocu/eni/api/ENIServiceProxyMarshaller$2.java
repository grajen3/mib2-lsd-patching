/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.api;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.eni.api.ENIServiceProxyMarshaller;

class ENIServiceProxyMarshaller$2
implements ServiceNotifier {
    private final /* synthetic */ int val$registeredService;
    private final /* synthetic */ ENIServiceProxyMarshaller this$0;

    ENIServiceProxyMarshaller$2(ENIServiceProxyMarshaller eNIServiceProxyMarshaller, int n) {
        this.this$0 = eNIServiceProxyMarshaller;
        this.val$registeredService = n;
    }

    @Override
    public void notifyServiceListener(Object object) {
        InternalServiceProvider internalServiceProvider = (InternalServiceProvider)object;
        internalServiceProvider.serviceListenerRegistered(this.val$registeredService);
    }
}

