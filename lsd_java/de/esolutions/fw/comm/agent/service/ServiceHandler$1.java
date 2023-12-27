/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.IServiceHandlerCallback;
import de.esolutions.fw.comm.agent.service.ServiceHandler;
import de.esolutions.fw.comm.agent.service.Stub;

class ServiceHandler$1
implements IServiceHandlerCallback {
    private final /* synthetic */ Stub val$stub;
    private final /* synthetic */ ServiceHandler this$0;

    ServiceHandler$1(ServiceHandler serviceHandler, Stub stub) {
        this.this$0 = serviceHandler;
        this.val$stub = stub;
    }

    @Override
    public void completedCall() {
        this.this$0.attachtedStubComplete(this.val$stub);
    }
}

