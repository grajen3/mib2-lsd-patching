/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.ServiceQueueWorker;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.commons.timeout.ITimeOutHandler;

public class ServiceQueueWorker$ServiceTimeOutHandler
implements ITimeOutHandler {
    private String methodDesc;
    private final /* synthetic */ ServiceQueueWorker this$0;

    public ServiceQueueWorker$ServiceTimeOutHandler(ServiceQueueWorker serviceQueueWorker, String string) {
        this.this$0 = serviceQueueWorker;
        this.methodDesc = string;
    }

    public void disarm() {
        this.methodDesc = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void timeoutOccurred(Thread thread) {
        int n;
        ServiceQueueWorker serviceQueueWorker = this.this$0;
        synchronized (serviceQueueWorker) {
            n = this.this$0.maxMethodTime;
        }
        CommAgentTracing.SERVICE.log((short)4, "method invocation timeout detected:\n  method=%1\n  worker=%2 thread=%3 maxMethodTime=%4 ms", (Object)this.methodDesc, (Object)this.this$0.name, (Object)thread, (Object)new Integer(n));
    }
}

