/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.agent.broker.IAgentServiceWorkerListener;
import de.esolutions.fw.comm.agent.service.ServiceQueueWorker;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public class AgentServiceWorker
extends ServiceQueueWorker {
    private final IAgentServiceWorkerListener listener;

    public AgentServiceWorker(IAgentServiceWorkerListener iAgentServiceWorkerListener, int n, int n2, boolean bl, int n3, ITimeSource iTimeSource, IRunnableWrapper iRunnableWrapper) {
        super("commSrvAgent", n, n2, bl, n3, iTimeSource, iRunnableWrapper);
        this.listener = iAgentServiceWorkerListener;
    }

    @Override
    public void stubCountChanged(IService iService, int n) {
        CommAgentTracing.BROKER.log((short)0, "AgentServiceWorker: stubCountChanged=%1", new Integer(n));
        if (n == 0) {
            this.listener.brokerDisconnectedFromAgentService();
        } else if (n == 1) {
            this.listener.brokerConnectedToAgentService();
        }
    }

    @Override
    protected void methodExceptionHandler(MethodException methodException) {
        this.listener.brokerCallFailed();
    }
}

