/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.core.IProxyBackend;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IClientHandler
extends IProxyBackend {
    default public void shutdown() {
    }

    @Override
    default public short getPeerAgentID() {
    }

    default public short getPeerAgentEpoch() {
    }

    default public short getMyAssignedAgentID() {
    }

    default public short getMyAssignedAgentEpoch() {
    }

    default public byte getProtocolVersion() {
    }

    default public ServiceInstanceID getBrokerServiceInstanceID() {
    }

    default public boolean connectProxy(Proxy proxy) {
    }

    default public void disconnectProxy(Proxy proxy) {
    }

    default public void dropStub(IStub iStub) {
    }

    default public boolean isAvailable() {
    }

    default public boolean isConnected() {
    }

    default public boolean isDeadOrError() {
    }

    default public ClientInfo createInfo() {
    }
}

