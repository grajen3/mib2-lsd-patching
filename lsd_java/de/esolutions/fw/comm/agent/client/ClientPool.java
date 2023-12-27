/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.agentdir.AgentDirectory;
import de.esolutions.fw.comm.agent.client.ClientException;
import de.esolutions.fw.comm.agent.client.ConnectionClientHandler;
import de.esolutions.fw.comm.agent.client.ConnectionHandler;
import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.client.IClientHandlerListener;
import de.esolutions.fw.comm.agent.client.IConnectionRequestCallback;
import de.esolutions.fw.comm.agent.client.LocalClientHandler;
import de.esolutions.fw.comm.agent.client.ProxyStubPools;
import de.esolutions.fw.comm.agent.client.TransportWorkerFactory;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.diag.AgentErrorLog;
import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;
import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.comm.agent.service.IServiceFinder;
import de.esolutions.fw.comm.agent.service.ServiceIKChecker;
import de.esolutions.fw.comm.agent.service.Stub;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.IProxyConnector;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.protocol.IProtocolActions;
import de.esolutions.fw.comm.core.protocol.IProtocolCallbacks;
import de.esolutions.fw.comm.core.protocol.IProtocolDecider;
import de.esolutions.fw.comm.core.protocol.ProtocolHandler;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.connection.IConnectionFactoryProvider;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ClientPool
implements ISpawnedConnectionListener,
IProtocolDecider {
    private short myAgentID;
    private final IConnectionFactoryProvider connectionFactoryProvider;
    private final INameService nameService;
    private final IClientHandlerListener listener;
    private final IProtocolCallbacks callbacks;
    private final IProxyConnector connector;
    private final AgentDirectory agentDirectory;
    private final boolean withBroker;
    private final boolean dynamicAgentId;
    private final CommConfig config;
    private final AgentErrorLog errorLog;
    private final byte protocolVersion;
    private List clientList;
    private IClientHandler localClientHandler;
    private ProxyStubPools proxyStubPools;
    private short connectionId;
    private Object lock;
    private TransportWorkerFactory transportWorkerFactory;
    private short tracePeer;
    private final ITimeSource monoTime;
    private final IRunnableWrapper runnableWrapper;

    public ClientPool(short s, IConnectionFactoryProvider iConnectionFactoryProvider, IServiceFinder iServiceFinder, INameService iNameService, CommConfig commConfig, IClientHandlerListener iClientHandlerListener, IProxyConnector iProxyConnector, AgentDirectory agentDirectory, boolean bl, ServiceIKChecker serviceIKChecker, AgentErrorLog agentErrorLog, boolean bl2, IProtocolCallbacks iProtocolCallbacks, ITimeSource iTimeSource, IRunnableWrapper iRunnableWrapper) {
        this.myAgentID = s;
        this.connectionFactoryProvider = iConnectionFactoryProvider;
        this.nameService = iNameService;
        this.listener = iClientHandlerListener;
        this.connector = iProxyConnector;
        this.agentDirectory = agentDirectory;
        this.withBroker = bl;
        this.dynamicAgentId = bl2;
        this.config = commConfig;
        this.errorLog = agentErrorLog;
        this.callbacks = iProtocolCallbacks;
        this.clientList = new ArrayList();
        this.protocolVersion = (byte)commConfig.getProtocolVersion();
        this.proxyStubPools = new ProxyStubPools(iServiceFinder, commConfig, serviceIKChecker, iTimeSource);
        this.connectionId = 1;
        this.lock = new Object();
        this.transportWorkerFactory = new TransportWorkerFactory(commConfig);
        this.tracePeer = (short)commConfig.getTracePeer();
        this.monoTime = iTimeSource;
        this.runnableWrapper = iRunnableWrapper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void pingControl(String string) {
        Object[] objectArray = null;
        List list = this.clientList;
        synchronized (list) {
            objectArray = this.clientList.toArray();
        }
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ConnectionClientHandler connectionClientHandler = (ConnectionClientHandler)objectArray[i2];
                connectionClientHandler.pingControl(string);
            }
        }
    }

    public void setTracePeer(short s) {
        this.tracePeer = s;
    }

    public void assignMyAgentID(short s) {
        this.myAgentID = s;
    }

    public short getMyAgentID() {
        return this.myAgentID;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void shutdown() {
        CommAgentTracing.CLIENTPOOL.log((short)0, "+ client pool shutdown");
        CommAgentTracing.CLIENTPOOL.log((short)0, "transport worker shutdown");
        Object[] objectArray = null;
        List list = this.clientList;
        synchronized (list) {
            objectArray = this.clientList.toArray();
            this.clientList.clear();
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            IClientHandler iClientHandler = (IClientHandler)objectArray[i2];
            iClientHandler.shutdown();
        }
        CommAgentTracing.CLIENTPOOL.log((short)0, "proxy stub pools shutdown");
        this.proxyStubPools.shutdown();
        CommAgentTracing.CLIENTPOOL.log((short)0, "- client pool shutdown");
    }

    public IClientHandler requestConnection(short s, boolean bl) {
        return this.requestConnection(s, bl, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IClientHandler requestConnection(short s, boolean bl, IConnectionRequestCallback iConnectionRequestCallback) {
        CommAgentTracing.CLIENTPOOL.log((short)1, "%1: request connection", new Short(s));
        short s2 = this.agentDirectory.getAgentEpoch(this.myAgentID);
        if (s == this.myAgentID) {
            Object object = this.lock;
            synchronized (object) {
                if (this.localClientHandler == null) {
                    this.localClientHandler = new LocalClientHandler(this.myAgentID, s2, this.proxyStubPools, this.connector, this.monoTime);
                }
                return this.localClientHandler;
            }
        }
        ConnectionClientHandler connectionClientHandler = this.getClientHandler(s);
        if (!connectionClientHandler.isAvailable()) {
            String string = this.nameService.mapIDToName(s);
            if (string == null) {
                throw new ClientException(new StringBuffer().append("Can't map peer=#").append(s).toString());
            }
            IConnectionFactory iConnectionFactory = this.connectionFactoryProvider.createConnectionFactory("comm", string);
            Connection connection = iConnectionFactory.createConnection();
            short s3 = 0;
            Object object = this.lock;
            synchronized (object) {
                short s4 = this.connectionId;
                this.connectionId = (short)(s4 + 1);
                s3 = s4;
            }
            CommAgentTracing.CLIENTPOOL.log((short)1, "%1: create outgoing connection handler for peer '%2' via %3 -> $%4", new Short(s), (Object)string, (Object)connection.getDescription(), (Object)new Short(s3));
            object = new ConnectionHandler(s3, this.myAgentID, s2, s, connection, bl, this.protocolVersion, this, false, this.transportWorkerFactory, this.tracePeer, connectionClientHandler, iConnectionRequestCallback, this.dynamicAgentId, this.callbacks, this.monoTime, this.runnableWrapper, this.config);
            boolean bl2 = ProtocolHandler.determineMasterRole(this.myAgentID, s);
            if (connectionClientHandler.reportConnection((ConnectionHandler)object, bl2)) {
                CommAgentTracing.CLIENTPOOL.log((short)1, "%1: starting outgoing connection handler for peer '%2' -> $%3 (myEpoch=%4)", new Short(s), (Object)string, (Object)new Short(s3), (Object)new Short(s2));
                ((ConnectionHandler)object).start();
            }
        } else if (iConnectionRequestCallback != null) {
            iConnectionRequestCallback.connectionEstablished(connectionClientHandler);
        }
        return connectionClientHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void spawnedConnection(Connection connection) {
        short s = 0;
        Object object = this.lock;
        synchronized (object) {
            short s2 = this.connectionId;
            this.connectionId = (short)(s2 + 1);
            s = s2;
        }
        short s3 = this.agentDirectory.getAgentEpoch(this.myAgentID);
        CommAgentTracing.CLIENTPOOL.log((short)1, "spawned connection %1 -> $%2 (myEpoch=%3)", (Object)connection.getDescription(), (Object)new Integer(s), (Object)new Short(s3));
        ConnectionHandler connectionHandler = new ConnectionHandler(s, this.myAgentID, s3, -1, connection, false, this.protocolVersion, this, true, this.transportWorkerFactory, this.tracePeer, null, null, this.dynamicAgentId, this.callbacks, this.monoTime, this.runnableWrapper, this.config);
        connectionHandler.start();
    }

    @Override
    public boolean spawningRetry(ISpawnConnectionFactory iSpawnConnectionFactory, IOException iOException, int n) {
        CommAgentTracing.CLIENTPOOL.log((short)3, "%1: retry spawning connection setup: %2:%3 (timeout %4 ms)", (Object)iSpawnConnectionFactory.getDescription(), (Object)super.getClass().getName(), (Object)iOException.getMessage(), (Object)new Integer(n));
        return true;
    }

    @Override
    public void spawningEnabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
        CommAgentTracing.CLIENTPOOL.log((short)2, "%1: enabled spawning", (Object)iSpawnConnectionFactory.getDescription());
    }

    @Override
    public void spawningDisabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
        CommAgentTracing.CLIENTPOOL.log((short)2, "%1: disabled spawning", (Object)iSpawnConnectionFactory.getDescription());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cleanUpGoneLocalService(IService iService) {
        Stub[] stubArray = this.proxyStubPools.getStubsForService(iService);
        CommAgentTracing.CLIENTPOOL.log((short)1, "cleaning up stubs for local service %1: #%2 proxies went dead", iService.getInstanceID(), (Object)new Integer(stubArray == null ? 0 : stubArray.length));
        if (stubArray != null) {
            Object object;
            Object object2 = this.clientList;
            synchronized (object2) {
                ListIterator listIterator = this.clientList.listIterator();
                while (listIterator.hasNext()) {
                    object = (ConnectionClientHandler)listIterator.next();
                    for (int i2 = 0; i2 < stubArray.length; ++i2) {
                        Stub stub = stubArray[i2];
                        if (stub.getRemoteAgentID() != ((ConnectionClientHandler)object).getPeerAgentID()) continue;
                        ((ConnectionClientHandler)object).dropStub(stub);
                    }
                }
            }
            object2 = this.lock;
            synchronized (object2) {
                if (this.localClientHandler != null) {
                    for (int i3 = 0; i3 < stubArray.length; ++i3) {
                        object = stubArray[i3];
                        if (object.getRemoteAgentID() != this.myAgentID) continue;
                        this.localClientHandler.dropStub((IStub)object);
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cleanUpOldConnection(short s, short s2) {
        ConnectionClientHandler connectionClientHandler = null;
        List list = this.clientList;
        synchronized (list) {
            ListIterator listIterator = this.clientList.listIterator();
            while (listIterator.hasNext()) {
                ConnectionClientHandler connectionClientHandler2 = (ConnectionClientHandler)listIterator.next();
                if (connectionClientHandler2.getPeerAgentID() != s) continue;
                connectionClientHandler = connectionClientHandler2;
                break;
            }
            if (connectionClientHandler != null) {
                short s3 = connectionClientHandler.getPeerAgentEpoch();
                if (s3 == 0) {
                    CommAgentTracing.CLIENTPOOL.log((short)1, "ignoring connection clean up to peer %1 because its setting up a new one right now (epoch now=%2, last epoch=%3)", new Short(s), (Object)new Short(s2), (Object)new Short(connectionClientHandler.getLastPeerAgentEpoch()));
                } else if (s3 < s2) {
                    CommAgentTracing.CLIENTPOOL.log((short)1, "cleaning up/shutting down connection to peer %1 because its OLD (epoch now=%2, old epoch=%3)", new Short(s), (Object)new Short(s2), (Object)new Short(s3));
                    connectionClientHandler.shutdown();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private Proxy[] getProxiesForService(short s, ServiceInstanceID serviceInstanceID) {
        Proxy[] proxyArray = null;
        List list = this.clientList;
        synchronized (list) {
            ListIterator listIterator = this.clientList.listIterator();
            while (listIterator.hasNext()) {
                ConnectionClientHandler connectionClientHandler = (ConnectionClientHandler)listIterator.next();
                if (connectionClientHandler.getPeerAgentID() != s) continue;
                proxyArray = this.proxyStubPools.getProxiesForService(serviceInstanceID, connectionClientHandler);
            }
        }
        return proxyArray;
    }

    public void disconnectProxiesLostOfService(short s, ServiceInstanceID serviceInstanceID) {
        Proxy[] proxyArray = this.getProxiesForService(s, serviceInstanceID);
        if (proxyArray != null) {
            for (int i2 = 0; i2 < proxyArray.length; ++i2) {
                if (proxyArray[i2] != null) {
                    proxyArray[i2].setPendingError(6);
                    proxyArray[i2].disconnectAsync();
                    CommAgentTracing.COMM.log((short)2, "proxy disconnected, service was reported as lost! [on=%1, interface='%2:%3]", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()));
                    continue;
                }
                CommAgentTracing.COMM.log((short)4, "received proxy, but was null, proxies[%1] == null !", new Integer(i2));
            }
        } else {
            CommAgentTracing.COMM.log((short)2, "no proxies associated with this service! [on=%1, interface='%2:%3]", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void forceDisconnect(short s) {
        CommAgentTracing.CLIENTPOOL.log((short)2, "forcing disconnect of peer #%1", new Short(s));
        ConnectionClientHandler connectionClientHandler = this.getClientHandler(s);
        if (connectionClientHandler != null) {
            connectionClientHandler.shutdown();
            List list = this.clientList;
            synchronized (list) {
                this.clientList.remove(connectionClientHandler);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void forceDisconnectAllWithoutBroker() {
        List list = this.clientList;
        synchronized (list) {
            ListIterator listIterator = this.clientList.listIterator();
            while (listIterator.hasNext()) {
                ConnectionClientHandler connectionClientHandler = (ConnectionClientHandler)listIterator.next();
                if (connectionClientHandler == null) continue;
                short s = connectionClientHandler.getPeerAgentID();
                short s2 = connectionClientHandler.getPeerAgentEpoch();
                if (!connectionClientHandler.getWithBroker()) {
                    CommAgentTracing.CLIENTPOOL.log((short)2, "disconnecting connection to peer #%1 (epoch %2)", new Short(s), (Object)new Short(s2));
                    connectionClientHandler.shutdown();
                    this.clientList.remove(connectionClientHandler);
                    continue;
                }
                CommAgentTracing.CLIENTPOOL.log((short)2, "not disconnecting connection to peer #%1 (epoch %2)", new Short(s), (Object)new Short(s2));
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void forceDisconnectAll() {
        List list = this.clientList;
        synchronized (list) {
            ListIterator listIterator = this.clientList.listIterator();
            while (listIterator.hasNext()) {
                ConnectionClientHandler connectionClientHandler = (ConnectionClientHandler)listIterator.next();
                if (connectionClientHandler == null) continue;
                short s = connectionClientHandler.getPeerAgentID();
                short s2 = connectionClientHandler.getPeerAgentEpoch();
                CommAgentTracing.CLIENTPOOL.log((short)2, "disconnecting connection to peer #%1 (epoch %2)", new Short(s), (Object)new Short(s2));
                connectionClientHandler.shutdown();
            }
            this.clientList.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ConnectionClientHandler getClientHandler(short s) {
        List list = this.clientList;
        synchronized (list) {
            ConnectionClientHandler connectionClientHandler;
            ListIterator listIterator = this.clientList.listIterator();
            while (listIterator.hasNext()) {
                connectionClientHandler = (ConnectionClientHandler)listIterator.next();
                if (connectionClientHandler.getPeerAgentID() != s) continue;
                return connectionClientHandler;
            }
            connectionClientHandler = new ConnectionClientHandler(s, this.proxyStubPools, this.listener, this.connector, this.withBroker, this.config, this.errorLog, this.monoTime);
            this.clientList.add(connectionClientHandler);
            return connectionClientHandler;
        }
    }

    @Override
    public boolean reportProtocolRole(boolean bl, short s, Object object) {
        ConnectionHandler connectionHandler = (ConnectionHandler)object;
        if (connectionHandler.isIncoming()) {
            connectionHandler.assignPeerAgentID(s);
            ConnectionClientHandler connectionClientHandler = this.getClientHandler(s);
            boolean bl2 = connectionClientHandler.reportConnection(connectionHandler, bl);
            return !bl2;
        }
        return false;
    }

    @Override
    public boolean decideProtocolDrop(short s, Object object) {
        ConnectionClientHandler connectionClientHandler = this.getClientHandler(s);
        ConnectionHandler connectionHandler = (ConnectionHandler)object;
        return connectionClientHandler.decideConnectionDrop(connectionHandler);
    }

    @Override
    public IProtocolActions setupProtocolActions(short s, Object object) {
        return this.getClientHandler(s);
    }

    public void dumpProxiesAndConnections() {
        this.proxyStubPools.dumpCommDatamodelProxies(this.myAgentID);
        this.dumpCommDatamodelConnections();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpCommDatamodelConnections() {
        short[] sArray;
        short[] sArray2;
        boolean[] blArray;
        int n = 0;
        List list = this.clientList;
        synchronized (list) {
            int n2 = this.clientList.size();
            blArray = new boolean[n2];
            sArray2 = new short[n2];
            sArray = new short[n2];
            for (int i2 = 0; i2 < this.clientList.size(); ++i2) {
                ConnectionClientHandler connectionClientHandler = (ConnectionClientHandler)this.clientList.get(i2);
                if (!connectionClientHandler.isAvailable() || !connectionClientHandler.isConnected()) continue;
                sArray[n] = connectionClientHandler.getMyAssignedAgentID();
                sArray2[n] = connectionClientHandler.getPeerAgentID();
                blArray[n] = connectionClientHandler.isConnectionHandlerIncoming();
                ++n;
            }
        }
        for (int i3 = 0; i3 < n; ++i3) {
            String string = "unknown";
            string = blArray[i3] ? "spawn" : "simple";
            CommAgentTracing.COMM.log((short)2, "on='%1' event='connection-status' destination='%2' type='%3' ", new Short(sArray[i3]), (Object)new Short(sArray2[i3]), (Object)string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void doTimer() {
        Object[] objectArray = null;
        List list = this.clientList;
        synchronized (list) {
            objectArray = this.clientList.toArray();
        }
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                ConnectionClientHandler connectionClientHandler = (ConnectionClientHandler)objectArray[i2];
                connectionClientHandler.doTimer();
            }
        }
    }

    public ProxyInfo[] createProxyInfos() {
        return this.proxyStubPools.createProxyInfos();
    }

    public StubInfo[] createStubInfos() {
        return this.proxyStubPools.createStubInfos();
    }

    public ClientInfo[] createClientInfos() {
        Object[] objectArray = null;
        objectArray = this.clientList.toArray();
        if (objectArray != null && objectArray.length > 0) {
            int n = objectArray.length;
            ClientInfo[] clientInfoArray = new ClientInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                clientInfoArray[i2] = ((IClientHandler)objectArray[i2]).createInfo();
            }
            return clientInfoArray;
        }
        return null;
    }
}

