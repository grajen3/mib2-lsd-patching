/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.agent.broker.IBrokerServiceListener;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IBrokerProxyWrapper {
    default public ServiceInstanceID getBrokerInstanceID() {
    }

    default public AbstractService createAgentService(IBrokerServiceListener iBrokerServiceListener, short s) {
    }

    default public Proxy create() {
    }

    default public void announce(short s) {
    }

    default public void registerService(ServiceInstanceID serviceInstanceID, short s) {
    }

    default public void unregisterService(ServiceInstanceID serviceInstanceID, short s) {
    }

    default public void lookupService(ServiceInstanceID serviceInstanceID, short s) {
    }
}

