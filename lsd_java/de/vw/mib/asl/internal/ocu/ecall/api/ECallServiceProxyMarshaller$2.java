/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.api;

import de.vw.mib.asl.internal.ocu.common.api.services.InternalServiceProvider;
import de.vw.mib.asl.internal.ocu.common.api.services.ServiceNotifier;
import de.vw.mib.asl.internal.ocu.ecall.api.ECallServiceProxyMarshaller;

class ECallServiceProxyMarshaller$2
implements ServiceNotifier {
    private final /* synthetic */ int val$registeredService;
    private final /* synthetic */ ECallServiceProxyMarshaller this$0;

    ECallServiceProxyMarshaller$2(ECallServiceProxyMarshaller eCallServiceProxyMarshaller, int n) {
        this.this$0 = eCallServiceProxyMarshaller;
        this.val$registeredService = n;
    }

    @Override
    public void notifyServiceListener(Object object) {
        InternalServiceProvider internalServiceProvider = (InternalServiceProvider)object;
        internalServiceProvider.serviceListenerRegistered(this.val$registeredService);
    }
}

