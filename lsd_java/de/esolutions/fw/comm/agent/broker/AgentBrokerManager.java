/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.agent.AgentLifecycleDispatcher;
import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.broker.AgentServiceWorker;
import de.esolutions.fw.comm.agent.broker.BrokerState;
import de.esolutions.fw.comm.agent.broker.IAgentServiceWorkerListener;
import de.esolutions.fw.comm.agent.broker.IBrokerProxyWrapper;
import de.esolutions.fw.comm.agent.broker.v4.BrokerProxyWrapper;
import de.esolutions.fw.comm.agent.client.ClientException;
import de.esolutions.fw.comm.agent.client.ClientPool;
import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.client.IConnectionRequestCallback;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;

public class AgentBrokerManager
implements IProxyListener,
IAgentServiceWorkerListener,
IConnectionRequestCallback {
    private boolean brokerProxyAlive;
    private boolean brokerProxyDead;
    private boolean agentStubConnected;
    private boolean agentStubDisconnected;
    private boolean agentStubCallFailed;
    private boolean brokerProxyCallFailed;
    private boolean wasOperational;
    private final BrokerState state;
    private final Object stateUpdateLock = new Object();
    private boolean brokerServiceRegistered;
    private Proxy brokerProxy;
    private IBrokerProxyWrapper brokerProxyWrapper;
    private ServiceInstanceID brokerInstanceID;
    private short brokerAgentID;
    private ServiceInstanceID agentInstanceID;
    private final AgentLifecycleDispatcher lifecycleDispatcher;
    private AbstractService agentService;
    private AgentServiceWorker agentServiceWorker;
    private boolean agentServiceRegistered;
    private short myAgentID;
    private short myAgentEpoch;
    private final CommConfig config;
    private final AgentWorker worker;
    private final ITimeSource monoTime;
    private final IRunnableWrapper runnableWrapper;

    public AgentBrokerManager(short s, short s2, AgentWorker agentWorker, CommConfig commConfig, AgentLifecycleDispatcher agentLifecycleDispatcher, ITimeSource iTimeSource, IRunnableWrapper iRunnableWrapper) {
        this.myAgentID = s;
        this.myAgentEpoch = s2;
        this.worker = agentWorker;
        this.config = commConfig;
        this.state = new BrokerState();
        this.lifecycleDispatcher = agentLifecycleDispatcher;
        this.monoTime = iTimeSource;
        this.runnableWrapper = iRunnableWrapper;
    }

    public String getErrorString() {
        return this.state.getErrorString();
    }

    public boolean hasPermanentError() {
        return this.state.getState() == 5;
    }

    public boolean needNewConnect() {
        return this.state.getState() == 0;
    }

    public IClientHandler connect(INameService iNameService, ClientPool clientPool) {
        if (!this.state.setState(1, 0)) {
            CommAgentTracing.BROKER.log((short)4, "BrokerState: wanted CONNECTING state but still in %1", (Object)this.state.getStateName());
            return null;
        }
        CommAgentTracing.BROKER.log((short)0, "+ broker connect");
        this.brokerProxyAlive = false;
        this.brokerProxyDead = false;
        this.agentStubConnected = false;
        this.agentStubDisconnected = false;
        this.agentStubCallFailed = false;
        this.brokerProxyCallFailed = false;
        this.brokerServiceRegistered = false;
        this.agentServiceRegistered = false;
        this.wasOperational = false;
        String string = "broker";
        Short s = iNameService.mapNameToID(string);
        if (s == null) {
            CommAgentTracing.BROKER.log((short)5, "agent 'broker' ID not found!");
            this.state.setErrorState(true, "broker proc ID  not found! config problem?");
            return null;
        }
        short s2 = s;
        CommAgentTracing.BROKER.log((short)2, "resolved broker agent=#%1", new Short(s2));
        IClientHandler iClientHandler = null;
        try {
            CommAgentTracing.BROKER.log((short)1, "opening broker connection to agent=#%1", new Short(s2));
            iClientHandler = clientPool.requestConnection(s2, true, this);
        }
        catch (ConnectionFactoryException connectionFactoryException) {
            CommAgentTracing.BROKER.log((short)5, "Can't find connection to 'broker': %1", (Object)connectionFactoryException.getMessage());
            this.state.setErrorState(true, new StringBuffer().append("broker connection not found! config problem? ").append(connectionFactoryException.getMessage()).toString());
            return null;
        }
        catch (ClientException clientException) {
            CommAgentTracing.BROKER.log((short)4, "Can't connect to 'broker': %1", (Object)clientException.getMessage());
            this.state.setErrorState(false, new StringBuffer().append("can't establish broker connection!").append(clientException.getMessage()).toString());
            return null;
        }
        CommAgentTracing.BROKER.log((short)0, "- broker connect");
        return iClientHandler;
    }

    public boolean setup(IClientHandler iClientHandler) {
        if (!this.state.setState(3, 2)) {
            CommAgentTracing.BROKER.log((short)4, "BrokerState: wanted SETTING_UP state but still in %1", (Object)this.state.getStateName());
            return false;
        }
        this.myAgentID = iClientHandler.getMyAssignedAgentID();
        this.myAgentEpoch = iClientHandler.getMyAssignedAgentEpoch();
        CommAgentTracing.BROKER.log((short)0, "+ broker setup (my id=%1, epoch=%2)", new Short(this.myAgentID), (Object)new Short(this.myAgentEpoch));
        ServiceInstanceID serviceInstanceID = iClientHandler.getBrokerServiceInstanceID();
        this.brokerAgentID = iClientHandler.getPeerAgentID();
        if (serviceInstanceID == null) {
            CommAgentTracing.BROKER.log((short)4, "returned broker instance ID invalid!");
            this.state.setErrorState(true, new StringBuffer().append("returned broker instance invalid: ").append(serviceInstanceID).toString());
            return false;
        }
        byte by = iClientHandler.getProtocolVersion();
        switch (by) {
            case 5: {
                this.brokerProxyWrapper = new BrokerProxyWrapper();
                break;
            }
            default: {
                CommAgentTracing.BROKER.log((short)4, "Unsupported 'broker' protocol version: %1", new Integer(by));
                this.state.setErrorState(true, new StringBuffer().append("invalid broker protocol version: ").append(by).toString());
                return false;
            }
        }
        this.brokerInstanceID = this.brokerProxyWrapper.getBrokerInstanceID();
        if (!this.brokerInstanceID.getServiceUUID().equals(serviceInstanceID.getServiceUUID())) {
            CommAgentTracing.BROKER.log((short)5, "Inconsistent Setup: Broker Interface Mismatch: remote=%1 local=%2", serviceInstanceID, (Object)this.brokerInstanceID);
            this.state.setErrorState(true, new StringBuffer().append("broker interface mismatch: ").append(this.brokerInstanceID).append(" != ").append(serviceInstanceID).toString());
            return false;
        }
        this.agentService = this.brokerProxyWrapper.createAgentService(this.worker, this.myAgentID);
        this.agentService.setCheckIK(new Boolean(true));
        this.agentInstanceID = this.agentService.getInstanceID();
        CommAgentTracing.BROKER.log((short)1, "creating and registering agent service %1", this.agentService.getInstanceID());
        int n = this.config.getCallQueueSize();
        int n2 = this.config.getCallTimeout();
        boolean bl = this.config.getServiceLazyStart();
        int n3 = this.config.getPriorities().getDefaultSvcWorkerPrio();
        this.agentServiceWorker = new AgentServiceWorker(this, n, n2, bl, n3, this.monoTime, this.runnableWrapper);
        this.worker.registerService(this.agentService, this.agentServiceWorker, true);
        this.agentServiceRegistered = true;
        CommAgentTracing.BROKER.log((short)1, "registering broker service instance %1", this.brokerInstanceID);
        this.worker.registerRemoteService(this.brokerInstanceID, this.brokerAgentID, true);
        this.brokerServiceRegistered = true;
        this.brokerProxy = this.brokerProxyWrapper.create();
        CommAgentTracing.BROKER.log((short)1, "connecting brokerProxy async: %1", this.brokerProxy);
        this.brokerProxy.setCheckIK(new Boolean(true));
        this.brokerProxy.registerProxyListener(this);
        this.brokerProxy.connectAsync();
        CommAgentTracing.BROKER.log((short)0, "- broker setup");
        return true;
    }

    private void unregisterServices() {
        CommAgentTracing.BROKER.log((short)0, "+ unregister broker services");
        if (this.brokerServiceRegistered) {
            CommAgentTracing.BROKER.log((short)1, "unregister broker service instance %1", this.brokerInstanceID);
            this.worker.registerRemoteService(this.brokerInstanceID, this.brokerAgentID, false);
            this.brokerServiceRegistered = false;
        }
        if (this.agentServiceRegistered) {
            CommAgentTracing.BROKER.log((short)1, "unregister agent service");
            this.worker.registerService(this.agentService, null, false);
            this.agentServiceRegistered = false;
        }
        CommAgentTracing.BROKER.log((short)0, "- unregister broker services");
    }

    public void shutdown() {
        CommAgentTracing.BROKER.log((short)0, "+ shutdown broker");
        if (this.brokerProxy != null) {
            CommAgentTracing.BROKER.log((short)1, "disconnect broker proxy: %1", this.brokerProxy);
            this.brokerProxy.disconnectAsync();
        }
        this.unregisterServices();
        CommAgentTracing.BROKER.log((short)0, "- shutdown broker");
    }

    @Override
    public void proxyStateChanged(Proxy proxy, int n) {
        if (proxy != this.brokerProxy) {
            CommAgentTracing.BROKER.log((short)3, "proxy change from unknown: %1", proxy);
            return;
        }
        if (n == 1) {
            CommAgentTracing.BROKER.log((short)2, "got broker proxy: calling 'announce'...: %1", this.brokerProxy);
            this.brokerProxyAlive = true;
            this.updateBrokerState();
            this.announce();
            this.worker.brokerProxyIsAlive();
        } else if (n == 2 || n == 3) {
            CommAgentTracing.BROKER.log((short)1, "broker proxy went dead. disabling broker: %1", this.brokerProxy);
            this.brokerProxyDead = true;
            this.brokerProxy.unregisterProxyListener(this);
            this.updateBrokerState();
            this.worker.brokerProxyIsDead();
        }
    }

    protected void announce() {
        CommAgentTracing.BROKER.log((short)0, "+ announce my agent at broker: agent=#%1", new Short(this.myAgentID));
        try {
            this.brokerProxyWrapper.announce(this.myAgentID);
        }
        catch (MethodException methodException) {
            CommAgentTracing.BROKER.log((short)4, "broker setup failed: %1", methodException);
            this.brokerProxyCallFailed = true;
            this.updateBrokerState();
        }
        CommAgentTracing.BROKER.log((short)0, "- announce my agent at broker: agent=#%1", new Short(this.myAgentID));
    }

    public boolean registerServiceAtBroker(ServiceInstanceID serviceInstanceID, boolean bl) {
        if (this.brokerProxy == null) {
            CommAgentTracing.BROKER_SERVICE.log((short)5, "register service at broker but no broker proxy. instance=", serviceInstanceID);
            return false;
        }
        boolean bl2 = false;
        try {
            if (bl) {
                CommAgentTracing.BROKER_SERVICE.log((short)1, "register service %1", serviceInstanceID);
                this.brokerProxyWrapper.registerService(serviceInstanceID, this.myAgentID);
            } else {
                CommAgentTracing.BROKER_SERVICE.log((short)1, "unregister service %1", serviceInstanceID);
                this.brokerProxyWrapper.unregisterService(serviceInstanceID, this.myAgentID);
            }
            bl2 = true;
        }
        catch (MethodException methodException) {
            CommAgentTracing.BROKER_SERVICE.log((short)4, "service register at broker failed: %1", methodException);
            this.brokerProxyCallFailed = true;
            this.updateBrokerState();
        }
        return bl2;
    }

    public boolean lookupService(ServiceInstanceID serviceInstanceID) {
        if (this.brokerProxy == null) {
            CommAgentTracing.BROKER_SERVICE.log((short)5, "lookup service at broker but no broker proxy. instance=%1", serviceInstanceID);
            return false;
        }
        boolean bl = false;
        CommAgentTracing.BROKER_SERVICE.log((short)0, "+ lookupService %1", serviceInstanceID);
        try {
            this.brokerProxyWrapper.lookupService(serviceInstanceID, this.myAgentID);
            bl = true;
        }
        catch (MethodException methodException) {
            CommAgentTracing.BROKER_SERVICE.log((short)4, "lookup service at broker failed: %1", methodException);
            this.brokerProxyCallFailed = true;
            this.updateBrokerState();
        }
        CommAgentTracing.BROKER_SERVICE.log((short)0, "- lookupService %1", serviceInstanceID);
        return bl;
    }

    public ServiceInstanceID getAgentInstanceID() {
        return this.agentInstanceID;
    }

    public short getMyAssignedAgentID() {
        return this.myAgentID;
    }

    public short getMyAssignedAgentEpoch() {
        return this.myAgentEpoch;
    }

    public short getBrokerAgentID() {
        return this.brokerAgentID;
    }

    @Override
    public void brokerConnectedToAgentService() {
        this.agentStubConnected = true;
        this.updateBrokerState();
    }

    @Override
    public void brokerDisconnectedFromAgentService() {
        this.agentStubDisconnected = true;
        this.updateBrokerState();
    }

    @Override
    public void brokerCallFailed() {
        this.agentStubCallFailed = true;
        this.updateBrokerState();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateBrokerState() {
        CommAgentTracing.BROKER.log((short)0, "<< broker state update in %1 (connect: proxy=%2, stub=%3, disconnect: proxy=%4, stub=%5, failed calls: proxy=%6, stub=%7)", this.state, (Object)new Boolean(this.brokerProxyAlive), (Object)new Boolean(this.agentStubConnected), (Object)new Boolean(this.brokerProxyDead), (Object)new Boolean(this.agentStubDisconnected), (Object)new Boolean(this.brokerProxyCallFailed), (Object)new Boolean(this.agentStubCallFailed));
        Object object = this.stateUpdateLock;
        synchronized (object) {
            if (this.state.getState() == 3) {
                this.updateWaitingForAlive();
            } else if (this.state.getState() == 4) {
                this.updateOperational();
            } else if (this.state.getState() == 6) {
                this.updateShutttingDown();
            } else {
                CommAgentTracing.BROKER.log((short)3, "Broker state update got in state %1 -> ignoring.", (Object)this.state.getStateName());
            }
        }
        CommAgentTracing.BROKER.log((short)0, ">> broker state update done: %1", this.state);
    }

    private void updateWaitingForAlive() {
        if (this.brokerProxyAlive && this.agentStubConnected && !this.agentStubCallFailed && !this.brokerProxyCallFailed && !this.brokerProxyDead && !this.agentStubDisconnected) {
            if (!this.state.setState(4, 3)) {
                CommAgentTracing.BROKER.log((short)4, "BrokerState: wanted OPERATIONAL but still is %1", (Object)this.state.getStateName());
            }
            CommAgentTracing.BROKER.log((short)1, "broker state is OPERATIONAL!");
            this.lifecycleDispatcher.brokerLinkStateChanged(true);
            this.wasOperational = true;
        } else if (this.agentStubCallFailed || this.brokerProxyCallFailed || this.brokerProxyDead || this.agentStubDisconnected) {
            CommAgentTracing.BROKER.log((short)3, "broker lost state WAITING_FOR_ALIVE! -> SHUTTING_DOWN broker link");
            if (!this.state.setState(6, 3)) {
                CommAgentTracing.BROKER.log((short)4, "BrokerState: wanted SHUTTING_DOWN but still is %1", (Object)this.state.getStateName());
            }
            this.wasOperational = false;
            this.shutdown();
            this.updateShutttingDown();
        } else {
            CommAgentTracing.BROKER.log((short)1, "still waiting to get operational...");
        }
    }

    private void updateOperational() {
        if (this.agentStubCallFailed || this.brokerProxyCallFailed || this.brokerProxyDead || this.agentStubDisconnected) {
            CommAgentTracing.BROKER.log((short)3, "broker lost OPERATIONAL state! (connect: proxy=%1, stub=%2, failed calls: proxy=%3, stub=%4)", new Boolean(this.brokerProxyAlive), (Object)new Boolean(this.agentStubConnected), (Object)new Boolean(this.brokerProxyCallFailed), (Object)new Boolean(this.agentStubCallFailed));
            if (!this.state.setState(6, 4)) {
                CommAgentTracing.BROKER.log((short)4, "BrokerState: wanted SHUTTING_DOWN but still is %1", (Object)this.state.getStateName());
            }
            this.lifecycleDispatcher.brokerLinkStateChanged(false);
            this.shutdown();
            this.updateShutttingDown();
        } else {
            CommAgentTracing.BROKER.log((short)1, "broker staying operational...");
        }
    }

    private void updateShutttingDown() {
        boolean bl;
        boolean bl2 = this.brokerProxyAlive && this.brokerProxyDead || !this.brokerProxyAlive;
        boolean bl3 = bl = this.agentStubConnected && this.agentStubDisconnected || !this.agentStubConnected;
        if (bl2 && bl) {
            CommAgentTracing.BROKER.log((short)1, "SHUTTING_DOWN completed");
            this.state.setErrorState(false, "broker lost operational state");
            this.brokerProxy = null;
            this.worker.brokerFinishedShutdown(this.wasOperational);
        } else {
            CommAgentTracing.BROKER.log((short)1, "broker still shutting down... proxyFinished=%1, stubFinished=%2", new Boolean(bl2), (Object)new Boolean(bl));
        }
    }

    public void brokerLinkDropped() {
        CommAgentTracing.BROKER.log((short)4, "broker link dropped ");
        this.state.setErrorState(false, "setting up broker connection failed -> DISCONNECTED");
    }

    @Override
    public void connectionEstablished(IClientHandler iClientHandler) {
        CommAgentTracing.BROKER.log((short)1, "broker connection reported as established");
        if (!this.state.setState(2, 1)) {
            CommAgentTracing.BROKER.log((short)4, "BrokerState: wanted CONNECTED but still in %1", (Object)this.state.getStateName());
        } else {
            this.worker.enqueueSetupBrokerLinkCommand(iClientHandler);
        }
    }

    @Override
    public void connectionFailed(IClientHandler iClientHandler, String string) {
        CommAgentTracing.BROKER.log((short)4, "broker connection reported as FAILED: %1", (Object)string);
        this.state.setErrorState(false, "setting up broker connection failed -> DISCONNECTED");
    }
}

