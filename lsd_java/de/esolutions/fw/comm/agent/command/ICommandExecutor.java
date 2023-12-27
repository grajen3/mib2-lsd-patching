/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.broker.BrokerAgentUpdate;
import de.esolutions.fw.comm.agent.broker.BrokerServiceUpdate;
import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.directory.IServiceQueryReply;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface ICommandExecutor {
    default public boolean doRegisterService(IService iService, IServiceWorker iServiceWorker, boolean bl) {
    }

    default public boolean doBrokerProxyAlive() {
    }

    default public boolean doRegisterRemoteService(ServiceInstanceID serviceInstanceID, short s, boolean bl) {
    }

    default public boolean doRegisterServiceInstanceListener(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener, boolean bl) {
    }

    default public boolean doRegisterServiceListener(IService iService, IServiceListener iServiceListener, boolean bl) {
    }

    default public boolean doRegisterProxyListener(Proxy proxy, IProxyListener iProxyListener, boolean bl) {
    }

    default public boolean doConnectProxy(Proxy proxy) {
    }

    default public boolean doSetupProxy(Proxy proxy, IClientHandler iClientHandler) {
    }

    default public boolean doDisconnectProxy(Proxy proxy) {
    }

    default public boolean doBrokerServiceUpdate(BrokerServiceUpdate[] brokerServiceUpdateArray) {
    }

    default public boolean doBrokerAgentUpdate(BrokerAgentUpdate[] brokerAgentUpdateArray) {
    }

    default public boolean doTimer() {
    }

    default public boolean doLookupService(ServiceInstanceID serviceInstanceID) {
    }

    default public boolean doQuit() {
    }

    default public boolean doConnectBrokerLink() {
    }

    default public boolean doSetupBrokerLink(IClientHandler iClientHandler) {
    }

    default public void dropSetupBrokerLink(IClientHandler iClientHandler) {
    }

    default public void dropSetupProxy(Proxy proxy, boolean bl) {
    }

    default public void dropConnectProxy(Proxy proxy, boolean bl) {
    }

    default public boolean doClientHandlerUpdate(IClientHandler iClientHandler, boolean bl) {
    }

    default public boolean doForceDisconnect(short s) {
    }

    default public boolean doQueryService(ServiceInstanceID serviceInstanceID, IServiceQueryReply iServiceQueryReply) {
    }

    default public void dropQueryService(ServiceInstanceID serviceInstanceID, IServiceQueryReply iServiceQueryReply, boolean bl) {
    }
}

