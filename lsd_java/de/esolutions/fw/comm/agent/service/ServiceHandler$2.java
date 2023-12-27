/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.IServiceHandlerCallback;
import de.esolutions.fw.comm.agent.service.ServiceHandler;

class ServiceHandler$2
implements IServiceHandlerCallback {
    private final /* synthetic */ ServiceHandler this$0;

    ServiceHandler$2(ServiceHandler serviceHandler) {
        this.this$0 = serviceHandler;
    }

    @Override
    public void completedCall() {
        this.this$0.detachedStubComplete();
    }
}

