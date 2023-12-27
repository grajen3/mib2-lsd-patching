/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.AbstractNotification;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.IStub;
import java.util.List;
import java.util.ListIterator;

public class ServiceListenerStubNotification
extends AbstractNotification {
    protected IStub stub;
    protected List listeners;
    protected boolean attached;

    public ServiceListenerStubNotification(IStub iStub, List list, boolean bl) {
        this.stub = iStub;
        this.listeners = list;
        this.attached = bl;
    }

    public String toString() {
        return new StringBuffer().append("[ServiceListenerStub:stub=").append(this.stub).append(",attached=").append(this.attached).append("]").toString();
    }

    @Override
    public void performNotification() {
        CommAgentTracing.NOTIFICATION.log((short)1, "{ ServiceListenerStubNotification: stub=%1 attached=%2", this.stub, (Object)new Boolean(this.attached));
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            IServiceListener iServiceListener = (IServiceListener)listIterator.next();
            CommAgentTracing.NOTIFICATION.log((short)1, " + Callback Service Listener %1", iServiceListener);
            if (this.attached) {
                iServiceListener.serviceStubAttached(this.stub);
            } else {
                iServiceListener.serviceStubDetached(this.stub);
            }
            CommAgentTracing.NOTIFICATION.log((short)1, " - Callback Service Listener %1", iServiceListener);
        }
        CommAgentTracing.NOTIFICATION.log((short)1, "} ServiceListenerStubNotification");
    }
}

