/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.AbstractNotification;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import java.util.List;
import java.util.ListIterator;

public class ServiceInstanceListenerNotification
extends AbstractNotification {
    protected ServiceInstanceID instanceID;
    protected List listeners;
    protected boolean doRegister;
    protected short agentID;

    public ServiceInstanceListenerNotification(ServiceInstanceID serviceInstanceID, List list, boolean bl, short s) {
        this.instanceID = serviceInstanceID;
        this.listeners = list;
        this.doRegister = bl;
        this.agentID = s;
    }

    public String toString() {
        return new StringBuffer().append("[ServiceInstanceListener:service=").append(this.instanceID).append(",doRegister=").append(this.doRegister).append(",agentID=").append(this.agentID).append("]").toString();
    }

    @Override
    public void performNotification() {
        CommAgentTracing.NOTIFICATION.log((short)1, "{ ServiceInstanceListenerNotification instanceID=%1 doRegister=%2 agentID=%3", this.instanceID, (Object)new Boolean(this.doRegister), (Object)new Short(this.agentID));
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            IServiceInstanceListener iServiceInstanceListener = (IServiceInstanceListener)listIterator.next();
            CommAgentTracing.NOTIFICATION.log((short)1, " + Callback Service Instance Listener %1", iServiceInstanceListener);
            if (this.doRegister) {
                iServiceInstanceListener.serviceRegistered(this.instanceID, this.agentID);
            } else {
                iServiceInstanceListener.serviceUnregistered(this.instanceID, this.agentID);
            }
            CommAgentTracing.NOTIFICATION.log((short)1, " - Callback Service Instance Listener %1", iServiceInstanceListener);
        }
        CommAgentTracing.NOTIFICATION.log((short)1, "} ServiceInstanceListenerNotification");
    }
}

