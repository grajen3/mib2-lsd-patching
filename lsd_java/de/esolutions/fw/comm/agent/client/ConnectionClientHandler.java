/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.client.ConnectionClientHandler$WaitingStub;
import de.esolutions.fw.comm.agent.client.ConnectionHandler;
import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.client.IClientHandlerListener;
import de.esolutions.fw.comm.agent.client.ProxyStubPools;
import de.esolutions.fw.comm.agent.client.StubOrError;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.diag.AgentErrorLog;
import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;
import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.IProxyConnector;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.core.protocol.IProtocolActions;
import de.esolutions.fw.comm.core.protocol.ProtocolHandler;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ConnectionClientHandler
implements IProtocolActions,
IClientHandler,
ILifecycleListener {
    private final short peerAgentID;
    private final ProxyStubPools proxyStubPools;
    private final IClientHandlerListener listener;
    private final boolean withBroker;
    private final int proxyAliveTimeout;
    private final AgentErrorLog errorLog;
    private ConnectionHandler connectionHandler;
    private ProtocolHandler protocolHandler;
    private boolean isWeak;
    private final Object lock;
    private short lastPeerEpoch;
    private IClientHandlerListener optionalListener;
    private long lastConnectTimeStamp;
    private long lastDisconnectTimeStamp;
    private final int minConnectInterval;
    private final int clientDispatchWD;
    private final int clientDispatchKillDelay;
    private final IProxyConnector connector;
    private final ITimeSource monoTime;
    private final List waitingStubList;

    public ConnectionClientHandler(short s, ProxyStubPools proxyStubPools, IClientHandlerListener iClientHandlerListener, IProxyConnector iProxyConnector, boolean bl, CommConfig commConfig, AgentErrorLog agentErrorLog, ITimeSource iTimeSource) {
        this.peerAgentID = s;
        this.proxyStubPools = proxyStubPools;
        this.listener = iClientHandlerListener;
        this.connector = iProxyConnector;
        this.withBroker = bl;
        this.proxyAliveTimeout = commConfig.getProxyAliveTimeout();
        this.errorLog = agentErrorLog;
        this.lock = new Object();
        this.waitingStubList = new ArrayList();
        this.minConnectInterval = commConfig.getMinConnectInterval();
        this.clientDispatchWD = commConfig.getClientDispatchWD();
        this.clientDispatchKillDelay = commConfig.getClientDispatchKillDelay();
        this.monoTime = iTimeSource;
    }

    public String toString() {
        return new StringBuffer().append("[Connection:peer=#").append(this.peerAgentID).append("]").toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setOptionalListener(IClientHandlerListener iClientHandlerListener) {
        Object object = this.lock;
        synchronized (object) {
            this.optionalListener = iClientHandlerListener;
        }
    }

    @Override
    public short getPeerAgentID() {
        return this.peerAgentID;
    }

    public boolean getWithBroker() {
        return this.withBroker;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public byte getProtocolVersion() {
        Object object = this.lock;
        synchronized (object) {
            if (this.protocolHandler != null) {
                return this.protocolHandler.getActiveProtocolVersion();
            }
            return 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public short getPeerAgentEpoch() {
        Object object = this.lock;
        synchronized (object) {
            if (this.protocolHandler != null) {
                return this.protocolHandler.getPeerAgentEpoch();
            }
            return 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public short getLastPeerAgentEpoch() {
        Object object = this.lock;
        synchronized (object) {
            return this.lastPeerEpoch;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public short getMyAssignedAgentID() {
        Object object = this.lock;
        synchronized (object) {
            if (this.protocolHandler != null) {
                return this.protocolHandler.getAgentID();
            }
            return 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public short getMyAssignedAgentEpoch() {
        Object object = this.lock;
        synchronized (object) {
            if (this.protocolHandler != null) {
                return this.protocolHandler.getAgentEpoch();
            }
            return 0;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ServiceInstanceID getBrokerServiceInstanceID() {
        Object object = this.lock;
        synchronized (object) {
            if (this.protocolHandler != null) {
                return this.protocolHandler.getBrokerInstanceID();
            }
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isAvailable() {
        Object object = this.lock;
        synchronized (object) {
            return this.connectionHandler != null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isConnected() {
        Object object = this.lock;
        synchronized (object) {
            if (this.connectionHandler != null) {
                return this.connectionHandler.getLifecycle().isAlive();
            }
            return false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isDeadOrError() {
        Object object = this.lock;
        synchronized (object) {
            if (this.connectionHandler != null) {
                // MONITOREXIT @DISABLED, blocks:[0, 1, 3] lbl5 : MonitorExitStatement: MONITOREXIT : var1_1
                Lifecycle lifecycle = this.connectionHandler.getLifecycle();
                return lifecycle.isDead() || lifecycle.isError();
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean reportConnection(ConnectionHandler connectionHandler, boolean bl) {
        boolean bl2 = false;
        Object object = this.lock;
        synchronized (object) {
            CommAgentTracing.CLIENT.log((short)0, "$%1(%2): + report (isMaster=%3,incoming=%4)", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Boolean(bl), (Object)new Boolean(connectionHandler.isIncoming()));
            if (this.connectionHandler == null) {
                CommAgentTracing.CLIENT.log((short)0, "$%1(%2): take me as a first connection", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID));
                bl2 = true;
                this.isWeak = !bl && !connectionHandler.isIncoming();
            } else if (this.isWeak) {
                if (connectionHandler.isIncoming()) {
                    CommAgentTracing.CLIENT.log((short)0, "$%1(%2): replacing weak connection $%3", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Short(this.connectionHandler.getMyID()));
                    bl2 = true;
                } else {
                    CommAgentTracing.CLIENT.log((short)3, "$%1(%2): outgoing slave connection $%3 already exists! we drop the new one.", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Short(this.connectionHandler.getMyID()));
                }
                this.isWeak = false;
            } else if (this.connectionHandler.isIncoming() && connectionHandler.isIncoming()) {
                CommAgentTracing.CLIENT.log((short)3, "$%1(%2): replacing OLD incoming connection $%3", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Short(this.connectionHandler.getMyID()));
                bl2 = true;
            } else if (!bl) {
                CommAgentTracing.CLIENT.log((short)3, "$%1(%2): HUH? strong connection $%3 already exists!!", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Short(this.connectionHandler.getMyID()));
            }
            if (bl2) {
                if (this.connectionHandler != null) {
                    CommAgentTracing.CLIENT.log((short)0, "$%1(%2): cleaning up old connection $%3 begin", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Short(this.connectionHandler.getMyID()));
                    this.connectionHandler.getLifecycle().setListener(null);
                    this.cleanupUsers(true, this.connectionHandler);
                    CommAgentTracing.CLIENT.log((short)0, "$%1(%2): cleaning up old connection $%3 done", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Short(this.connectionHandler.getMyID()));
                    this.connectionHandler.stop();
                }
                this.connectionHandler = connectionHandler;
                this.connectionHandler.getLifecycle().setListener(this);
                this.connectionHandler.setClientHandler(this);
                this.protocolHandler = this.connectionHandler.getProtocolHandler();
            }
            CommAgentTracing.CLIENT.log((short)0, "$%1(%2): - report (isMaster=%3,incoming=%4) -> current=$%5, weak=%6", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Boolean(bl), (Object)new Boolean(connectionHandler.isIncoming()), (Object)new Short(this.connectionHandler.getMyID()), (Object)new Boolean(this.isWeak));
        }
        return bl2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean decideConnectionDrop(ConnectionHandler connectionHandler) {
        boolean bl = false;
        Object object = this.lock;
        synchronized (object) {
            bl = connectionHandler != this.connectionHandler;
            CommAgentTracing.CLIENT.log((short)0, "$%1(%2): decide drop (current $%3) -> drop=%4", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Short(this.connectionHandler != null ? this.connectionHandler.getMyID() : (short)0), (Object)new Boolean(bl));
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void shutdown() {
        CommAgentTracing.CLIENT.log((short)0, "%1: + shutdown", new Short(this.peerAgentID));
        ConnectionHandler connectionHandler = null;
        Object object = this.lock;
        synchronized (object) {
            if (this.connectionHandler != null) {
                this.connectionHandler.getLifecycle().setListener(null);
                this.connectionHandler.stop();
                connectionHandler = this.connectionHandler;
                this.connectionHandler = null;
            }
            this.cleanupUsers(false, connectionHandler);
        }
        if (connectionHandler != null) {
            try {
                connectionHandler.getLifecycle().waitUntilAlive();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
        CommAgentTracing.CLIENT.log((short)0, "%1: - shutdown", new Short(this.peerAgentID));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void lifecycleChanged(Lifecycle lifecycle, Object object) {
        ConnectionHandler connectionHandler = (ConnectionHandler)object;
        Object object2 = this.lock;
        synchronized (object2) {
            if (this.connectionHandler == connectionHandler) {
                if (!lifecycle.isAlive()) {
                    CommAgentTracing.CLIENT.log((short)0, "$%1(%2): + removing active connection ", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID));
                    this.connectionHandler.getLifecycle().setListener(null);
                    this.connectionHandler.stop();
                    boolean bl = this.connectionHandler.getWasDropped();
                    this.connectionHandler = null;
                    this.protocolHandler = null;
                    if (!bl) {
                        CommAgentTracing.CLIENT.log((short)0, "$%1(%2): notify agent about my death", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID));
                        this.listener.clientHandlerStateUpdate(this, false);
                        if (this.optionalListener != null) {
                            this.optionalListener.clientHandlerStateUpdate(this, false);
                        }
                        this.cleanupUsers(true, connectionHandler);
                    } else {
                        CommAgentTracing.CLIENT.log((short)0, "$%1(%2): do not notify agent as connection was dropped. (new connection should arrive soon)", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID));
                    }
                    CommAgentTracing.CLIENT.log((short)0, "$%1(%2): - removing active connection ", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID));
                } else {
                    CommAgentTracing.CLIENT.log((short)0, "$%1(%2): notify agent about my birth", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID));
                    if (this.protocolHandler != null) {
                        this.lastPeerEpoch = this.protocolHandler.getAgentEpoch();
                    }
                    this.listener.clientHandlerStateUpdate(this, true);
                    if (this.optionalListener != null) {
                        this.optionalListener.clientHandlerStateUpdate(this, true);
                    }
                }
            } else {
                CommAgentTracing.CLIENT.log((short)3, "$%1(%2): unknown life cycle changed: state=%3. Ignoring!", new Short(connectionHandler.getMyID()), (Object)new Short(this.peerAgentID), (Object)new Integer(connectionHandler.getLifecycle().getState()));
            }
        }
    }

    private void cleanupUsers(boolean bl, ConnectionHandler connectionHandler) {
        CommAgentTracing.CLIENT.log((short)0, "%1: + cleaning up connection: lostConnection=%2", new Short(this.peerAgentID), (Object)new Boolean(bl));
        Stub[] stubArray = this.proxyStubPools.dropStubsForClient(this);
        Proxy[] proxyArray = this.proxyStubPools.dropProxiesForBackend(this, bl);
        this.clearWaitingStubList();
        int n = 0;
        int n2 = 0;
        if (stubArray != null) {
            n = stubArray.length;
        }
        if (proxyArray != null) {
            n2 = proxyArray.length;
        }
        if (bl) {
            int n3;
            this.errorLog.addClientError(this.createInfo(connectionHandler));
            if (proxyArray != null) {
                for (n3 = 0; n3 < proxyArray.length; ++n3) {
                    this.errorLog.addProxyError(new ProxyInfo(proxyArray[n3]));
                }
            }
            if (stubArray != null) {
                for (n3 = 0; n3 < stubArray.length; ++n3) {
                    this.errorLog.addStubError(new StubInfo(stubArray[n3]));
                }
            }
        }
        CommAgentTracing.CLIENT.log((short)0, "%1: - cleaning up connection: %2 stubs cleaned, %3 proxies cleaned", new Short(this.peerAgentID), (Object)new Integer(n), (Object)new Integer(n2));
    }

    private boolean isProxyIDValid(short s) {
        return s >= 0 && s < this.proxyStubPools.getProxyIDPoolSize();
    }

    private boolean isStubIDValid(short s) {
        return s >= 0 && s < this.proxyStubPools.getStubIDPoolSize();
    }

    @Override
    public void handleDestroyStub(short s) {
        Proxy proxy;
        CommAgentTracing.CLIENT.log((short)1, "%2: { deleteStub stub=%1", new Short(s), (Object)new Short(this.peerAgentID));
        if (!this.isStubIDValid(s)) {
            CommAgentTracing.CLIENT.log((short)3, "%2: handleDestroyStub, invalid stubID (%1) received, call ignored", new Short(s), (Object)new Short(this.peerAgentID));
            return;
        }
        this.removeWaitingStub(s);
        Stub stub = this.proxyStubPools.removeStub(s);
        if (stub == null) {
            CommAgentTracing.CLIENT.log((short)2, "%2: DELETE STUB NOT IN POOL stub=%1", new Short(s), (Object)new Short(this.peerAgentID));
            return;
        }
        stub.getServiceHandler().detachedStub(stub);
        IProxyFrontend iProxyFrontend = stub.getReplyProxyFrontend();
        if (iProxyFrontend != null && (proxy = iProxyFrontend.getProxy()) != null) {
            CommAgentTracing.CLIENT.log((short)1, "%1: shutting down associated reply proxy #%2 %3", new Short(this.peerAgentID), (Object)new Short(proxy.getProxyID()), (Object)proxy.getInstanceID());
            this.proxyStubPools.makeProxyDead(proxy);
            if (!this.withBroker) {
                CommAgentTracing.CLIENT.log((short)1, "%2: unregistering proxy reply service %1 (broker-less mode)", proxy.getInstanceID(), (Object)new Short(this.peerAgentID));
                proxy.unregisterRemoteReplyService(this.peerAgentID);
            }
        }
        CommAgentTracing.CLIENT.log((short)1, "%3: } deleteStub %2 stub=%1", new Short(s), (Object)(stub != null ? stub.getServiceHandler().getInstanceID() : null), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void handleCreateStub(short s, short s2, ServiceInstanceID serviceInstanceID) {
        CommAgentTracing.CLIENT.log((short)1, "%4: { remote connectProxy instance=%3 agent=#%1 proxy=#%2 creating stub", new Short(s), (Object)new Short(s2), (Object)serviceInstanceID, (Object)new Short(this.peerAgentID));
        if (serviceInstanceID == null) {
            CommAgentTracing.CLIENT.log((short)3, "%1: } -> ignoring null service instance!", new Short(this.peerAgentID));
            return;
        }
        if (s2 == -1 || serviceInstanceID.getServiceUUID().isZero()) {
            CommAgentTracing.CLIENT.log((short)1, "%1: } -> ignoring zero service or invalid proxy id!", new Short(this.peerAgentID));
            return;
        }
        StubOrError stubOrError = this.proxyStubPools.createStub(serviceInstanceID, this, s2, s);
        if (stubOrError.hasError()) {
            int n = stubOrError.getError();
            CommAgentTracing.CLIENT.log((short)4, "%4: creating stub for remote proxy %3 @%1 #%2 failed -> error = %5", new Short(s), (Object)new Short(s2), (Object)serviceInstanceID, (Object)new Short(this.peerAgentID), (Object)new Integer(n));
            this.sendStubFailed(s2, (byte)n);
            return;
        }
        Stub stub = stubOrError.getStub();
        short s3 = stub.getStubID();
        boolean bl = this.sendStubCreated(stub);
        if (!bl) {
            this.proxyStubPools.removeStub(stub.getStubID());
        } else {
            this.postponeStub(stub);
        }
        CommAgentTracing.CLIENT.log((short)1, "%5: } remote connectProxy instance=%3 agent=#%1 proxy=#%2 -> stub=#%4 created", new Short(s), (Object)new Short(s2), (Object)serviceInstanceID, (Object)new Short(s3), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void handleProxyAlive(short s) {
        if (!this.isStubIDValid(s)) {
            CommAgentTracing.CLIENT.log((short)3, "%2: handleProxyAlive, invalid stubID (%1) received, call ignored", new Short(s), (Object)new Short(this.peerAgentID));
            return;
        }
        Stub stub = this.proxyStubPools.getStubForID(s);
        if (stub == null) {
            CommAgentTracing.CLIENT.log((short)1, "%1: ! remote proxyAlive stub=#%2 NOT IN POOL", new Short(this.peerAgentID), (Object)new Short(s));
            return;
        }
        CommAgentTracing.CLIENT.log((short)1, "%1: { remote proxyAlive stub=#%2 -> proxy=#%3 instance=%4", new Short(this.peerAgentID), (Object)new Short(s), (Object)new Short(stub.getRemoteProxyID()), (Object)stub.getService().getInstanceID());
        if (this.removeWaitingStub(s)) {
            CommAgentTracing.CLIENT.log((short)2, "%1: proxy is reported alive -> attach stub: proxy #%2, stub #%3 instance=%4", new Short(this.peerAgentID), (Object)new Short(stub.getRemoteProxyID()), (Object)new Short(s), (Object)stub.getServiceHandler().getInstanceID());
            stub.getServiceHandler().attachedStub(stub);
        } else {
            CommAgentTracing.CLIENT.log((short)2, "%1: proxy is reported alive, but ALREADY ATTACHED for proxy #%2, stub #%3 instance=%4", new Short(this.peerAgentID), (Object)new Short(stub.getRemoteProxyID()), (Object)new Short(s), (Object)stub.getServiceHandler().getInstanceID());
        }
        CommAgentTracing.CLIENT.log((short)1, "%1: } remote proxyAlive stub=#%2 -> proxy=#%3 instance=%4", new Short(this.peerAgentID), (Object)new Short(s), (Object)new Short(stub.getRemoteProxyID()), (Object)stub.getService().getInstanceID());
    }

    @Override
    public void handleCreateRRStub(short s, short s2, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2, short s3) {
        CommAgentTracing.CLIENT.log((short)1, "%1: { remote connectProxyRR instance=%2 agent=#%3 requestProxy=#%4 + replyInstance=%5 replyStub=#%6 creating stub", new Short(this.peerAgentID), (Object)serviceInstanceID, (Object)new Short(s), (Object)new Short(s2), (Object)serviceInstanceID2, (Object)new Short(s3));
        if (serviceInstanceID == null || serviceInstanceID2 == null) {
            CommAgentTracing.CLIENT.log((short)3, "%1: } -> ignoring null service instance!", new Short(this.peerAgentID));
            return;
        }
        if (s2 == -1 || serviceInstanceID.getServiceUUID().isZero() || serviceInstanceID2.getServiceUUID().isZero() || s3 == -1) {
            CommAgentTracing.CLIENT.log((short)1, "%1: } -> ignoring NULL service or invalid proxy/stub id!", new Short(this.peerAgentID));
            return;
        }
        StubOrError stubOrError = this.proxyStubPools.createStub(serviceInstanceID, this, s2, this.peerAgentID);
        if (stubOrError.hasError()) {
            int n = stubOrError.getError();
            CommAgentTracing.CLIENT.log((short)4, "%1: creating request stub for remote proxy %2 (#%3) failed -> error=%4", new Short(this.peerAgentID), (Object)serviceInstanceID, (Object)new Short(s2), (Object)new Integer(n));
            this.sendStubFailed(s2, (byte)n);
            return;
        }
        Stub stub = stubOrError.getStub();
        short s4 = stub.getStubID();
        CommAgentTracing.CLIENT.log((short)1, "%1: created request stub=#%2, now setting up reply proxy: replyInstance=%3", new Short(this.peerAgentID), (Object)new Short(s4), (Object)serviceInstanceID2);
        IService iService = stub.getServiceHandler().getService();
        Proxy proxy = null;
        IProxyFrontend iProxyFrontend = null;
        if (iService != null && (iProxyFrontend = iService.createReplyProxy()) != null) {
            proxy = iProxyFrontend.getProxy();
        }
        short s5 = -1;
        if (proxy != null) {
            s5 = this.proxyStubPools.addProxy(proxy, this);
        }
        if (proxy == null || s5 == -1) {
            CommAgentTracing.CLIENT.log((short)4, "%1: no reply proxy for %2 available via requestStub=#%3", new Short(this.peerAgentID), (Object)serviceInstanceID2, (Object)new Short(stub.getStubID()));
            this.sendStubFailed(s2, (byte)8);
            this.proxyStubPools.removeStub(s3);
            return;
        }
        CommAgentTracing.CLIENT.log((short)1, "%1: created reply proxy=#%2 (stub=#%3) for %4", new Short(this.peerAgentID), (Object)new Short(s5), (Object)new Short(s3), (Object)proxy.getInstanceID());
        proxy.getInstanceID().setHandle(serviceInstanceID2.getHandle());
        proxy.setReplyProxyFlag(true);
        if (!this.withBroker) {
            this.ensureReplyServiceRegistered(proxy);
        }
        stub.setReplyProxyFrontend(iProxyFrontend);
        proxy.setRequestStub(stub);
        this.postponeStub(stub);
        this.proxyStubPools.makeProxyAlive(s5, s3);
        if (!this.sendRRStubCreated(stub, s5)) {
            CommAgentTracing.CLIENT.log((short)4, "%4: remote connectProxyRR instance=%3 agent=#%1 proxy=#%2: send RRSTUB_CREATIOn failed!", new Short(s), (Object)new Short(s2), (Object)serviceInstanceID, (Object)new Short(this.peerAgentID));
            this.proxyStubPools.makeProxyFailed(s5, (byte)3);
            this.proxyStubPools.removeStub(s3);
            this.removeWaitingStub(s4);
            return;
        }
        CommAgentTracing.CLIENT.log((short)1, "%1: } remote connectProxyRR instance=%2 agent=#%3 requestProxy=#%4 + replyInstance=%5 replyStub=#%6 -> requestStub=#%7, replyProxy=#%8", new Short(this.peerAgentID), (Object)serviceInstanceID, (Object)new Short(s), (Object)new Short(s2), (Object)serviceInstanceID2, (Object)new Short(s3), (Object)new Short(s4), (Object)new Short(s5));
    }

    @Override
    public void handleRRStubCreated(short s, short s2, short s3) {
        CommAgentTracing.CLIENT.log((short)1, "%1: { connectProxyRR: request proxy=#%2 -> request stub=#%3 + reply proxy=#%4", new Short(this.peerAgentID), (Object)new Short(s), (Object)new Short(s2), (Object)new Short(s3));
        if (!this.isProxyIDValid(s)) {
            CommAgentTracing.CLIENT.log((short)3, "%2: handleRRStubCreated, invalid requestProxyID (%1) received, call ignored", new Short(s), (Object)new Short(this.peerAgentID));
            return;
        }
        Proxy proxy = this.proxyStubPools.getProxyForID(s);
        if (proxy == null) {
            CommAgentTracing.CLIENT.log((short)4, "%1: connectProxyRR: can't find request proxy #%2", new Short(this.peerAgentID), (Object)new Short(s));
            return;
        }
        short s4 = proxy.getReplyStubID();
        if (s4 == -1) {
            CommAgentTracing.CLIENT.log((short)4, "%1: connectProxyRR: can't find reply stub id for request proxy #%2", new Short(this.peerAgentID), (Object)new Short(s));
            return;
        }
        Stub stub = this.proxyStubPools.getStubForID(s4);
        if (stub == null) {
            CommAgentTracing.CLIENT.log((short)4, "%1: connectProxyRR: can't get reply stub for request proxy #%2", new Short(this.peerAgentID), (Object)new Short(s));
            return;
        }
        stub.setRequestProxy(proxy);
        proxy.setReplyStub(stub);
        stub.setRemoteProxyID(s3);
        CommAgentTracing.CLIENT.log((short)1, "%1: connectProxyRR: associated reply stub=#%2 with remote reply proxy=#%3 -> now attaching", new Short(this.peerAgentID), (Object)new Short(s4), (Object)new Short(s3));
        stub.getServiceHandler().attachedStub(stub);
        proxy = this.proxyStubPools.makeProxyAlive(s, s2);
        CommAgentTracing.CLIENT.log((short)1, "%4: } connectProxyRR: %3 request proxy=#%1 -> request stub=#%2 alive!", new Short(s), (Object)new Short(s2), (Object)(proxy != null ? proxy.getInstanceID() : null), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void handleStubCreated(short s, short s2) {
        CommAgentTracing.CLIENT.log((short)1, "%3: { connectProxy: proxy=%1 -> stub=#%2 received", new Short(s), (Object)new Short(s2), (Object)new Short(this.peerAgentID));
        if (!this.isProxyIDValid(s)) {
            CommAgentTracing.CLIENT.log((short)3, "%2: handleStubCreated, invalid proxyID (%1) received, call ignored", new Short(s), (Object)new Short(this.peerAgentID));
            return;
        }
        Proxy proxy = this.proxyStubPools.makeProxyAlive(s, s2);
        CommAgentTracing.CLIENT.log((short)1, "%4: } connectProxy: %3 proxy=#%1 -> stub=#%2 alive!", new Short(s), (Object)new Short(s2), (Object)(proxy != null ? proxy.getInstanceID() : null), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void handleStubFailed(short s, byte by) {
        CommAgentTracing.CLIENT.log((short)1, "%3: { connectProxy: proxy=%1 -> FAILED with error code %2", new Short(s), (Object)new Byte(by), (Object)new Short(this.peerAgentID));
        if (!this.isProxyIDValid(s)) {
            CommAgentTracing.CLIENT.log((short)3, "%2: handleStubFailed, invalid proxyID (%1) received, call ignored", new Short(s), (Object)new Short(this.peerAgentID));
            return;
        }
        Proxy proxy = this.proxyStubPools.makeProxyFailed(s, by);
        CommAgentTracing.CLIENT.log((short)1, "%4: } connectProxy: %3 proxy=#%1 -> FAILED with error code %2", new Short(s), (Object)new Short(by), (Object)(proxy != null ? proxy.getInstanceID() : null), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void handleCallMethod(short s, short s2, IDeserializer iDeserializer) {
        CommAgentTracing.CLIENT_CALLS.log((short)1, "%3: { remote method call stub=#%1 method=#%2", new Short(s), (Object)new Short(s2), (Object)new Short(this.peerAgentID));
        if (!this.isStubIDValid(s)) {
            CommAgentTracing.CLIENT.log((short)3, "%2: handleCallMethod, invalid stubID (%1) received, call ignored", new Short(s), (Object)new Short(this.peerAgentID));
            return;
        }
        Stub stub = this.proxyStubPools.getStubForID(s);
        if (stub != null) {
            stub.handleCallMethod(s2, iDeserializer, stub.getReplyProxyFrontend());
        }
        CommAgentTracing.CLIENT_CALLS.log((short)1, "%3: } remote method call instance=%1 method=#%2", stub != null ? stub.getServiceHandler().getInstanceID() : null, (Object)new Short(s2), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void handlePing() {
    }

    @Override
    public boolean connectProxy(Proxy proxy) {
        boolean bl = false;
        IReplyService iReplyService = proxy.getReplyService();
        bl = iReplyService != null ? this.connectProxyWithReply(proxy) : this.connectProxyWithoutReply(proxy);
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean connectProxyWithoutReply(Proxy proxy) {
        CommAgentTracing.CLIENT.log((short)1, "%2: < connectProxy instance=%1", proxy.getInstanceID(), (Object)new Short(this.peerAgentID));
        short s = this.proxyStubPools.addProxy(proxy, this);
        if (s == -1) {
            proxy.getLifecycle().setError(8);
            this.errorLog.addProxyError(new ProxyInfo(proxy));
            return false;
        }
        try {
            ServiceInstanceID serviceInstanceID = proxy.getInstanceID();
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler == null) {
                    CommAgentTracing.CLIENT.log((short)4, "%1: Can't send CreateStub proxy=#%2", new Integer(this.peerAgentID), (Object)new Short(s));
                    this.proxyStubPools.makeProxyFailed(s, (byte)3);
                    return false;
                }
                this.protocolHandler.sendCreateStub(s, serviceInstanceID);
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "%2: send create stub failed: %1", exception, (Object)new Short(this.peerAgentID));
            this.proxyStubPools.makeProxyFailed(s, (byte)3);
            return false;
        }
        CommAgentTracing.CLIENT.log((short)1, "%3: > connectProxy instance=%1 -> proxy=#%2", proxy.getInstanceID(), (Object)new Short(s), (Object)new Short(this.peerAgentID));
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean connectProxyWithReply(Proxy proxy) {
        CommAgentTracing.CLIENT.log((short)1, "%2: < connectProxyRR instance=%1", proxy.getInstanceID(), (Object)new Short(this.peerAgentID));
        short s = this.proxyStubPools.addProxy(proxy, this);
        if (s == -1) {
            CommAgentTracing.CLIENT.log((short)4, "add request proxy to pool failed, proxyID == -1 ");
            proxy.getLifecycle().setError(8);
            this.errorLog.addProxyError(new ProxyInfo(proxy));
            return false;
        }
        ServiceInstanceID serviceInstanceID = proxy.getInstanceID();
        CommAgentTracing.CLIENT.log((short)2, "added request proxy to pool %1, %2, %3", serviceInstanceID, (Object)new Short(this.peerAgentID), (Object)new Short(s));
        IReplyService iReplyService = proxy.getReplyService();
        if (iReplyService == null) {
            CommAgentTracing.CLIENT.log((short)5, "no replyService attached to proxy!!!");
            proxy.getLifecycle().setError(13);
            this.errorLog.addProxyError(new ProxyInfo(proxy));
            return false;
        }
        ServiceInstanceID serviceInstanceID2 = iReplyService.getInstanceID();
        if (serviceInstanceID2 == null) {
            CommAgentTracing.CLIENT.log((short)5, "no instanceID found in replyService!!!");
            proxy.getLifecycle().setError(13);
            this.errorLog.addProxyError(new ProxyInfo(proxy));
            return false;
        }
        short s2 = -1;
        StubOrError stubOrError = this.proxyStubPools.createStub(serviceInstanceID2, this, s2, this.peerAgentID);
        if (stubOrError.hasError()) {
            int n = stubOrError.getError();
            CommAgentTracing.CLIENT.log((short)4, "%2: creating reply stub for remote proxy %1 failed -> error=%3", proxy.getInstanceID(), (Object)new Short(this.peerAgentID), (Object)new Integer(n));
            proxy.getLifecycle().setError(n);
            this.errorLog.addProxyError(new ProxyInfo(proxy));
            return false;
        }
        Stub stub = stubOrError.getStub();
        short s3 = stub.getStubID();
        proxy.setReplyStubID(s3);
        proxy.setReplyStub(stub);
        CommAgentTracing.CLIENT.log((short)1, "create reply stub for upcoming reply proxy succeeded, remoteAgentID: %1 remoteProxyID: %2, reply stubID: %3", new Short(stub.getRemoteAgentID()), (Object)new Short(stub.getRemoteProxyID()), (Object)new Short(s3));
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler == null) {
                    CommAgentTracing.CLIENT.log((short)4, "%1: Can't send CreateRRStub proxy=#%2", new Integer(this.peerAgentID), (Object)new Short(s));
                    this.proxyStubPools.makeProxyFailed(s, (byte)3);
                    this.proxyStubPools.removeStub(s3);
                    return false;
                }
                this.protocolHandler.sendCreateRRStub(s, s3, serviceInstanceID, serviceInstanceID2);
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "%2: send create stub failed: %1", exception, (Object)new Short(this.peerAgentID));
            this.proxyStubPools.makeProxyFailed(s, (byte)3);
            this.proxyStubPools.removeStub(s3);
            return false;
        }
        CommAgentTracing.CLIENT.log((short)1, "%3: > connectProxyRR instance=%1 -> proxy=#%2", proxy.getInstanceID(), (Object)new Short(s), (Object)new Short(this.peerAgentID));
        return true;
    }

    @Override
    public void proxyAliveDone(Proxy proxy) {
        boolean bl;
        Stub stub;
        CommAgentTracing.CLIENT.log((short)1, "%1: { proxyAliveDone: proxy=%2 stub=%3", new Short(this.peerAgentID), (Object)new Short(proxy.getProxyID()), (Object)new Short(proxy.getStubID()));
        short s = proxy.getReplyStubID();
        if (s != -1 && (stub = this.proxyStubPools.getStubForID(s)) != null) {
            CommAgentTracing.CLIENT.log((short)1, "%1: reply stub go live: stub=%2", new Short(this.peerAgentID), (Object)new Short(proxy.getStubID()));
            stub.goLive();
        }
        if (!proxy.getReplyProxyFlag()) {
            this.sendProxyAlive(proxy);
        }
        if (bl = proxy.setNotifyProxyBackend()) {
            CommAgentTracing.CLIENT.log((short)2, "%1: disconnect is pending, enqueue disconnect command, requestStubID=#%2", new Short(this.peerAgentID), (Object)new Short(proxy.getStubID()));
            this.connector.disconnectProxy(proxy);
        }
        CommAgentTracing.CLIENT.log((short)1, "%1: } proxyAliveDone: proxy=%2 stub=%3", new Short(this.peerAgentID), (Object)new Short(proxy.getProxyID()), (Object)new Short(proxy.getStubID()));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void remoteCallMethod(short s, short s2, ISerializable iSerializable, ICallMethodSerializeCallback iCallMethodSerializeCallback) {
        CommAgentTracing.CLIENT_CALLS.log((short)1, "%3: < callMethod stub=#%1 method=#%2", new Short(s), (Object)new Short(s2), (Object)new Short(this.peerAgentID));
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler == null) {
                    CommAgentTracing.CLIENT_CALLS.log((short)4, "%3: can't send call method stub=%1 method=%2!", new Short(s), (Object)new Short(s2), (Object)new Short(this.peerAgentID));
                    throw new MethodException("Sending Call Failed!");
                }
                this.protocolHandler.sendCallMethod(s, s2, iSerializable, iCallMethodSerializeCallback);
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT_CALLS.log((short)4, "%3: send call method failed: stub=%1 method=%2: %4", new Short(s), (Object)new Short(s2), (Object)new Short(this.peerAgentID), (Object)exception);
            throw new MethodException(new StringBuffer().append("Call failed: ").append(exception).toString());
        }
        CommAgentTracing.CLIENT_CALLS.log((short)1, "%3: > callMethod stub=#%1 method=#%2", new Short(s), (Object)new Short(s2), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void disconnectProxy(Proxy proxy) {
        short s = proxy.getProxyID();
        short s2 = proxy.getStubID();
        CommAgentTracing.CLIENT.log((short)1, "%4: < disconnectProxy instance=%3 proxy=#%1 (stub=#%2)", new Short(s), (Object)new Short(s2), (Object)proxy.getInstanceID(), (Object)new Short(this.peerAgentID));
        short s3 = proxy.getReplyStubID();
        if (s3 != -1) {
            CommAgentTracing.CLIENT.log((short)1, "%1: removing reply stub #%2", new Short(this.peerAgentID), (Object)new Short(s3));
            Stub stub = this.proxyStubPools.removeStub(s3);
            if (stub != null) {
                stub.getServiceHandler().detachedStub(stub);
            } else {
                CommAgentTracing.CLIENT.log((short)2, "%1: reply stub #%2 NOT FOUND!", new Short(this.peerAgentID), (Object)new Short(s3));
            }
        }
        this.proxyStubPools.makeProxyDead(proxy);
        this.sendDestroyStub(s2);
        CommAgentTracing.CLIENT.log((short)1, "%4: > disconnectProxy instance=%3 proxy=#%1 (stub=#%2)", new Short(s), (Object)new Short(s2), (Object)proxy.getInstanceID(), (Object)new Short(this.peerAgentID));
    }

    @Override
    public void dropStub(IStub iStub) {
        CommAgentTracing.CLIENT.log((short)1, "%4: < dropStub instance=%3 proxy=#%1 (stub=#%2)", new Short(iStub.getRemoteProxyID()), (Object)new Short(iStub.getStubID()), (Object)iStub.getService().getInstanceID(), (Object)new Short(this.peerAgentID));
        if (iStub.getReplyProxyFrontend() != null) {
            this.proxyStubPools.makeProxyDead(iStub.getReplyProxyFrontend().getProxy());
        }
        this.proxyStubPools.removeStub(iStub.getStubID());
        this.removeWaitingStub(iStub.getStubID());
        CommAgentTracing.CLIENT.log((short)1, "%4: > dropStub instance=%3 proxy=#%1 (stub=#%2)", new Short(iStub.getRemoteProxyID()), (Object)new Short(iStub.getStubID()), (Object)iStub.getService().getInstanceID(), (Object)new Short(this.peerAgentID));
    }

    public void pingControl(String string) {
        if (this.connectionHandler != null) {
            this.connectionHandler.pingControl(string);
        }
    }

    public void doTimer() {
        long l = this.monoTime.getCurrentTime();
        ConnectionClientHandler$WaitingStub[] connectionClientHandler$WaitingStubArray = this.getDueStubs(l);
        if (connectionClientHandler$WaitingStubArray != null) {
            for (int i2 = 0; i2 < connectionClientHandler$WaitingStubArray.length; ++i2) {
                ConnectionClientHandler$WaitingStub connectionClientHandler$WaitingStub = connectionClientHandler$WaitingStubArray[i2];
                short s = connectionClientHandler$WaitingStub.getStubID();
                Stub stub = this.proxyStubPools.getStubForID(s);
                if (stub == null) {
                    CommAgentTracing.CLIENT.log((short)4, "%1: doTimer: timed out proxyAlive stub=#%2 NOT IN POOL", new Short(this.peerAgentID), (Object)new Short(s));
                    continue;
                }
                long l2 = l - connectionClientHandler$WaitingStub.getStartTime();
                long l3 = connectionClientHandler$WaitingStub.getTimeOut();
                CommAgentTracing.CLIENT.log((short)4, "%1: proxy is reported alive after TIMEOUT of %2 (%3) ms (Peer is missing PROXY_ALIVE support!) -> attach stub for proxy #%4, stub #%5 instance=%6", new Short(this.peerAgentID), (Object)new Long(l2), (Object)new Long(l3), (Object)new Short(stub.getRemoteProxyID()), (Object)new Short(s), (Object)stub.getServiceHandler().getInstanceID());
                stub.getServiceHandler().attachedStub(stub);
            }
        }
        if (this.connectionHandler != null) {
            this.connectionHandler.doTimer();
        }
        if (this.clientDispatchWD > 0) {
            this.checkClientDispatchWD();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkClientDispatchWD() {
        Object object = this.lock;
        synchronized (object) {
            Long l;
            if (this.connectionHandler != null && (l = this.connectionHandler.getDispatchStartTime()) != null) {
                long l2 = this.monoTime.getCurrentTime();
                long l3 = l;
                long l4 = l2 - l3;
                short s = 0;
                if (l4 >= (long)this.clientDispatchWD) {
                    s = 4;
                }
                CommAgentTracing.CLIENT.log(s, "$%1(%2) Watchdog: read worker problem! dispatching peer message took too long: delta=%3 ms, msg=%4", new Short(this.connectionHandler.getMyID()), (Object)new Short(this.connectionHandler.getPeerAgentID()), (Object)new Long(l4), (Object)this.connectionHandler.getDispatchMessage());
                if (this.clientDispatchKillDelay != 0 && l4 >= (long)this.clientDispatchKillDelay) {
                    IFatalErrorHandler iFatalErrorHandler;
                    CommAgentTracing.CLIENT.log((short)5, "$%1(%2) Watchdog: kill delay reached %3. Shutting down!", new Short(this.connectionHandler.getMyID()), (Object)new Short(this.connectionHandler.getPeerAgentID()), (Object)new Long(l4));
                    Agent agent = Agent.getAgent();
                    if (agent != null && (iFatalErrorHandler = agent.getFatalErrorHandler()) != null) {
                        iFatalErrorHandler.handleFatalError(null, "COMM Rx Client Watchdog");
                    }
                }
            }
        }
    }

    private void ensureReplyServiceRegistered(Proxy proxy) {
        CommAgentTracing.CLIENT.log((short)1, "%1: registering proxy reply service %2 (broker-less mode)", new Short(this.peerAgentID), (Object)proxy.getInstanceID());
        proxy.registerRemoteReplyService(this.peerAgentID);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void postponeStub(Stub stub) {
        CommAgentTracing.CLIENT.log((short)2, "%1: postponing stub attachment: waiting for proxy alive: proxy #%2, stub #%3 instance=%4. waiting for PROXY_ALIVE", new Short(this.peerAgentID), (Object)new Short(stub.getRemoteProxyID()), (Object)new Short(stub.getStubID()), (Object)stub.getServiceHandler().getInstanceID());
        List list = this.waitingStubList;
        synchronized (list) {
            ConnectionClientHandler$WaitingStub connectionClientHandler$WaitingStub = new ConnectionClientHandler$WaitingStub(stub.getStubID(), this.proxyAliveTimeout, this.monoTime.getCurrentTime());
            if (this.waitingStubList.contains(connectionClientHandler$WaitingStub)) {
                CommAgentTracing.CLIENT.log((short)5, "This should never happen!!! Stub already in waiting list! stub=%1", new Short(stub.getStubID()));
            } else {
                this.waitingStubList.add(connectionClientHandler$WaitingStub);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearWaitingStubList() {
        List list = this.waitingStubList;
        synchronized (list) {
            this.waitingStubList.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean removeWaitingStub(short s) {
        List list = this.waitingStubList;
        synchronized (list) {
            ListIterator listIterator = this.waitingStubList.listIterator();
            while (listIterator.hasNext()) {
                ConnectionClientHandler$WaitingStub connectionClientHandler$WaitingStub = (ConnectionClientHandler$WaitingStub)listIterator.next();
                if (connectionClientHandler$WaitingStub.getStubID() != s) continue;
                listIterator.remove();
                return true;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ConnectionClientHandler$WaitingStub[] getDueStubs(long l) {
        ConnectionClientHandler$WaitingStub[] connectionClientHandler$WaitingStubArray;
        ArrayList arrayList = new ArrayList();
        List list = this.waitingStubList;
        synchronized (list) {
            if (this.waitingStubList.isEmpty()) {
                return null;
            }
            connectionClientHandler$WaitingStubArray = this.waitingStubList.listIterator();
            while (connectionClientHandler$WaitingStubArray.hasNext()) {
                ConnectionClientHandler$WaitingStub connectionClientHandler$WaitingStub = (ConnectionClientHandler$WaitingStub)connectionClientHandler$WaitingStubArray.next();
                if (!connectionClientHandler$WaitingStub.isDue(l)) continue;
                arrayList.add(connectionClientHandler$WaitingStub);
                connectionClientHandler$WaitingStubArray.remove();
            }
        }
        int n = arrayList.size();
        if (n == 0) {
            return null;
        }
        connectionClientHandler$WaitingStubArray = new ConnectionClientHandler$WaitingStub[n];
        for (int i2 = 0; i2 < n; ++i2) {
            connectionClientHandler$WaitingStubArray[i2] = (ConnectionClientHandler$WaitingStub)arrayList.get(i2);
        }
        return connectionClientHandler$WaitingStubArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isConnectionHandlerIncoming() {
        boolean bl;
        Object object = this.lock;
        synchronized (object) {
            bl = this.connectionHandler.isIncoming();
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendProxyAlive(Proxy proxy) {
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler != null) {
                    this.protocolHandler.sendProxyAlive(proxy.getStubID());
                } else {
                    CommAgentTracing.CLIENT.log((short)4, "%1: can't send proxy alive!", new Short(this.peerAgentID));
                }
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "%2: send proxy alive failed: %1", exception, (Object)new Short(this.peerAgentID));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendCustomMessage(byte by, byte[] byArray) {
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler != null) {
                    this.protocolHandler.sendCostumMessage(by, byArray);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean sendRRStubCreated(Stub stub, short s) {
        boolean bl = false;
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler != null) {
                    this.protocolHandler.sendRRStubCreated(stub.getRemoteProxyID(), stub.getStubID(), s);
                    bl = true;
                } else {
                    CommAgentTracing.CLIENT.log((short)4, "%1: can't send stub reply!", new Short(this.peerAgentID));
                }
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "%2: send Stub creation failed: %1", exception, (Object)new Short(this.peerAgentID));
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean sendStubCreated(Stub stub) {
        boolean bl = false;
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler != null) {
                    this.protocolHandler.sendStubCreated(stub.getRemoteProxyID(), stub.getStubID());
                    bl = true;
                } else {
                    CommAgentTracing.CLIENT.log((short)4, "%1: can't send stub reply!", new Short(this.peerAgentID));
                }
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "%2: send Stub creation failed: %1", exception, (Object)new Short(this.peerAgentID));
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendStubFailed(short s, byte by) {
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler != null) {
                    this.protocolHandler.sendStubFailed(s, by);
                } else {
                    CommAgentTracing.CLIENT.log((short)4, "%1: can't send stub failure!", new Short(this.peerAgentID));
                }
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "%2: send Stub failure failed: %1", exception, (Object)new Short(this.peerAgentID));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendDestroyStub(short s) {
        try {
            Object object = this.lock;
            synchronized (object) {
                if (this.protocolHandler != null) {
                    this.protocolHandler.sendDestroyStub(s);
                } else {
                    CommAgentTracing.CLIENT.log((short)4, "%1: sending destroy stub #%2 failed!", new Short(this.peerAgentID), (Object)new Short(s));
                }
            }
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "%1: send destroy stub #%2 failed: %3", new Short(this.peerAgentID), (Object)new Short(s), (Object)exception);
        }
    }

    public long getLastConnectTimeStamp() {
        return this.lastConnectTimeStamp;
    }

    public void setLastConnectTimeStamp(long l) {
        this.lastConnectTimeStamp = l;
    }

    public long getLastDisconnectTimeStamp() {
        return this.lastDisconnectTimeStamp;
    }

    public void setLastDisconnectTimeStamp(long l) {
        this.lastDisconnectTimeStamp = l;
    }

    public int getMinConnectInterval() {
        return this.minConnectInterval;
    }

    public ClientInfo createInfo(ConnectionHandler connectionHandler) {
        short s = -1;
        String string = super.getClass().getName();
        String string2 = null;
        Boolean bl = null;
        short s2 = -1;
        int n = -1;
        int n2 = 0;
        String string3 = null;
        int n3 = -1;
        int n4 = -1;
        int[] nArray = null;
        int[] nArray2 = null;
        if (connectionHandler != null) {
            s = connectionHandler.getMyID();
            string2 = connectionHandler.getConnectionDescription();
            bl = new Boolean(connectionHandler.isIncoming());
            n3 = this.proxyStubPools.countProxies(this);
            n4 = this.proxyStubPools.countStubs(this);
            s2 = connectionHandler.getPeerAgentID();
            n = connectionHandler.getPeerAgentEpoch();
            n2 = connectionHandler.getErrorCode();
            string3 = connectionHandler.getErrorString();
            nArray = connectionHandler.getDispatchDurationInternal();
            nArray2 = connectionHandler.getDispatchDurationCall();
        }
        return new ClientInfo(s, s2, n, string, string2, bl, n3, n4, n2, string3, this.lastConnectTimeStamp, this.lastDisconnectTimeStamp, nArray, nArray2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ClientInfo createInfo() {
        Object object = this.lock;
        synchronized (object) {
            return this.createInfo(this.connectionHandler);
        }
    }
}

