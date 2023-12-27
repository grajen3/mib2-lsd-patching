/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.notification.INotification;
import de.esolutions.fw.comm.agent.notification.INotificationCallback;
import de.esolutions.fw.comm.agent.service.IServiceHandlerCallback;

class AgentWorker$3
implements INotificationCallback {
    private final /* synthetic */ IServiceHandlerCallback val$cb;
    private final /* synthetic */ AgentWorker this$0;

    AgentWorker$3(AgentWorker agentWorker, IServiceHandlerCallback iServiceHandlerCallback) {
        this.this$0 = agentWorker;
        this.val$cb = iServiceHandlerCallback;
    }

    @Override
    public void doneNotification(INotification iNotification) {
        this.val$cb.completedCall();
    }
}

