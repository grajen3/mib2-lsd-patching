/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker.v4;

import de.esolutions.fw.comm.agent.broker.IBrokerProxyWrapper;
import de.esolutions.fw.comm.agent.broker.IBrokerServiceListener;
import de.esolutions.fw.comm.agent.broker.v4.AgentServiceImpl;
import de.esolutions.fw.comm.agent.broker.v4.BrokerIDLTool;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentService;
import de.esolutions.fw.comm.comm.broker.v4.impl.BrokerProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BrokerProxyWrapper
implements IBrokerProxyWrapper {
    private BrokerProxy brokerProxy;
    static /* synthetic */ Class class$de$esolutions$fw$comm$comm$broker$v4$Broker;

    @Override
    public ServiceInstanceID getBrokerInstanceID() {
        return new ServiceInstanceID("8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847", 0, "8935d19b-313a-5d23-bf1f-64bc869ad5a7", (class$de$esolutions$fw$comm$comm$broker$v4$Broker == null ? (class$de$esolutions$fw$comm$comm$broker$v4$Broker = BrokerProxyWrapper.class$("de.esolutions.fw.comm.comm.broker.v4.Broker")) : class$de$esolutions$fw$comm$comm$broker$v4$Broker).getName());
    }

    @Override
    public AbstractService createAgentService(IBrokerServiceListener iBrokerServiceListener, short s) {
        return new AgentService(s, new AgentServiceImpl(iBrokerServiceListener));
    }

    @Override
    public Proxy create() {
        this.brokerProxy = new BrokerProxy(0);
        return this.brokerProxy.getProxy();
    }

    @Override
    public void announce(short s) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("78a07e56-255a-4309-8bde-b1e1c73bc71c", (int)s, "299585a3-5e89-5854-a716-dafd54af2e50");
        this.brokerProxy.announce(BrokerIDLTool.convertInstanceIDToIDL(serviceInstanceID));
    }

    @Override
    public void lookupService(ServiceInstanceID serviceInstanceID, short s) {
        this.brokerProxy.lookupService(BrokerIDLTool.convertInstanceIDToIDL(serviceInstanceID), s);
    }

    @Override
    public void registerService(ServiceInstanceID serviceInstanceID, short s) {
        this.brokerProxy.registerService(BrokerIDLTool.convertInstanceIDToIDL(serviceInstanceID), s);
    }

    @Override
    public void unregisterService(ServiceInstanceID serviceInstanceID, short s) {
        this.brokerProxy.unregisterService(BrokerIDLTool.convertInstanceIDToIDL(serviceInstanceID), s);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

