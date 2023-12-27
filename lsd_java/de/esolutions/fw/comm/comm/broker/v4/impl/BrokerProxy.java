/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.Broker;
import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.impl.BrokerProxy$1;
import de.esolutions.fw.comm.comm.broker.v4.impl.BrokerProxy$2;
import de.esolutions.fw.comm.comm.broker.v4.impl.BrokerProxy$3;
import de.esolutions.fw.comm.comm.broker.v4.impl.BrokerProxy$4;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BrokerProxy
implements Broker {
    private static final CallContext context = CallContext.getContext("PROXY.comm.broker.Broker");
    private Proxy proxy;

    public BrokerProxy(int n) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847", n, "8935d19b-313a-5d23-bf1f-64bc869ad5a7", "comm.broker.Broker");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void announce(InstanceID instanceID) {
        BrokerProxy$1 brokerProxy$1 = new BrokerProxy$1(this, instanceID);
        this.proxy.remoteCallMethod((short)0, brokerProxy$1);
    }

    @Override
    public void registerService(InstanceID instanceID, int n) {
        BrokerProxy$2 brokerProxy$2 = new BrokerProxy$2(this, instanceID, n);
        this.proxy.remoteCallMethod((short)2, brokerProxy$2);
    }

    @Override
    public void unregisterService(InstanceID instanceID, int n) {
        BrokerProxy$3 brokerProxy$3 = new BrokerProxy$3(this, instanceID, n);
        this.proxy.remoteCallMethod((short)3, brokerProxy$3);
    }

    @Override
    public void lookupService(InstanceID instanceID, int n) {
        BrokerProxy$4 brokerProxy$4 = new BrokerProxy$4(this, instanceID, n);
        this.proxy.remoteCallMethod((short)1, brokerProxy$4);
    }
}

