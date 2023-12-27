/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.notification.INotification;
import de.esolutions.fw.comm.agent.notification.INotificationCallback;
import de.esolutions.fw.comm.core.Proxy;

class AgentWorker$1
implements INotificationCallback {
    private final /* synthetic */ Proxy val$proxy;
    private final /* synthetic */ AgentWorker this$0;

    AgentWorker$1(AgentWorker agentWorker, Proxy proxy) {
        this.this$0 = agentWorker;
        this.val$proxy = proxy;
    }

    @Override
    public void doneNotification(INotification iNotification) {
        this.val$proxy.getBackend().proxyAliveDone(this.val$proxy);
    }
}

