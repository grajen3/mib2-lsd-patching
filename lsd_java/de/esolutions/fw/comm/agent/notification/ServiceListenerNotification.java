/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.AbstractNotification;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceListener;
import java.util.List;
import java.util.ListIterator;

public class ServiceListenerNotification
extends AbstractNotification {
    protected IService service;
    protected List listeners;
    protected int stubCount;

    public ServiceListenerNotification(IService iService, List list, int n) {
        this.service = iService;
        this.listeners = list;
        this.stubCount = n;
    }

    public String toString() {
        return new StringBuffer().append("[ServiceListener:service=").append(this.service.getInstanceID()).append(",stubCount=").append(this.stubCount).append("]").toString();
    }

    @Override
    public void performNotification() {
        CommAgentTracing.NOTIFICATION.log((short)1, "{ ServiceListenerNotification: service=%1 stubCount=%2", this.service.getInstanceID(), (Object)new Integer(this.stubCount));
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            IServiceListener iServiceListener = (IServiceListener)listIterator.next();
            CommAgentTracing.NOTIFICATION.log((short)1, " + Callback Service Listener %1", iServiceListener);
            iServiceListener.serviceStubCountChanged(this.service, this.stubCount);
            CommAgentTracing.NOTIFICATION.log((short)1, " - Callback Service Listener %1", iServiceListener);
        }
        CommAgentTracing.NOTIFICATION.log((short)1, "} ServiceListenerNotification");
    }
}

