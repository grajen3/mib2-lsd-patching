/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.notification;

import de.esolutions.fw.comm.agent.notification.AbstractNotification;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.Proxy;
import java.util.List;
import java.util.ListIterator;

public class ProxyListenerNotification
extends AbstractNotification {
    protected Proxy proxy;
    protected List listeners;
    protected int state;

    public ProxyListenerNotification(Proxy proxy, List list, int n) {
        this.proxy = proxy;
        this.listeners = list;
        this.state = n;
    }

    public String toString() {
        return new StringBuffer().append("[ProxyListener:proxyId=").append(this.proxy.getProxyID()).append(",state=").append(Lifecycle.lifecycleNames[this.state]).append("]").toString();
    }

    @Override
    public void performNotification() {
        CommAgentTracing.NOTIFICATION.log((short)1, "{ ProxyListenerNotification: state=%1 proxy=#%2:%3", (Object)Lifecycle.lifecycleNames[this.state], (Object)new Integer(this.proxy.getProxyID()), (Object)this.proxy.getInstanceID());
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            IProxyListener iProxyListener = (IProxyListener)listIterator.next();
            CommAgentTracing.NOTIFICATION.log((short)1, "  + Callback Proxy Listener %1", iProxyListener);
            iProxyListener.proxyStateChanged(this.proxy, this.state);
            CommAgentTracing.NOTIFICATION.log((short)1, "  - Callback Proxy Listener %1", iProxyListener);
        }
        CommAgentTracing.NOTIFICATION.log((short)1, "} ProxyListenerNotification: state=%1 proxy=#%2:%3", (Object)Lifecycle.lifecycleNames[this.state], (Object)new Integer(this.proxy.getProxyID()), (Object)this.proxy.getInstanceID());
    }
}

