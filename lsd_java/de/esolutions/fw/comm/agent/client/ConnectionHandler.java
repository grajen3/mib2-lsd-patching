/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.client.ClientException;
import de.esolutions.fw.comm.agent.client.ConnectionClientHandler;
import de.esolutions.fw.comm.agent.client.IConnectionRequestCallback;
import de.esolutions.fw.comm.agent.client.PingHandler;
import de.esolutions.fw.comm.agent.client.TransportWorkerFactory;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.config.CommConfigTransport;
import de.esolutions.fw.comm.agent.config.CommConfigTransportParams;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.CallMethodMessage;
import de.esolutions.fw.comm.core.protocol.IProtocolCallbacks;
import de.esolutions.fw.comm.core.protocol.IProtocolDecider;
import de.esolutions.fw.comm.core.protocol.ProtocolException;
import de.esolutions.fw.comm.core.protocol.ProtocolHandler;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.transport.TransportDebugAdapter;
import de.esolutions.fw.util.transport.async.AsyncTXTransport;
import de.esolutions.fw.util.transport.async.TransportWorker;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.exception.TransportPartialPacketException;
import de.esolutions.fw.util.transport.exception.TransportTimeoutException;
import java.io.IOException;
import java.io.InterruptedIOException;

public class ConnectionHandler
implements Runnable {
    public static final int NORMAL_OPERATION;
    public static final int HANDSHAKE_FAILED;
    public static final int LOST_CONNECTION;
    private final short myID;
    private final short myAgentID;
    private Connection connection;
    private final ProtocolHandler protocolHandler;
    private final Lifecycle lifecycle;
    private final ITimeSource monoTime;
    private final IRunnableWrapper runnableWrapper;
    private final CommConfig config;
    private short peerAgentID;
    private boolean doShutdown;
    private Thread thread;
    private boolean isIncoming;
    private boolean wasDropped;
    private boolean dynamicAgentId;
    private TransportWorkerFactory transportWorkerFactory;
    private String connectionType = "unknown";
    private short tracePeer;
    private TransportDebugAdapter debugAdapter;
    private ConnectionClientHandler clientHandler;
    private IConnectionRequestCallback callback;
    private Long dispatchStartTime;
    private AbstractMessage dispatchMessage;
    private int minDurationInt = -129;
    private int maxDurationInt;
    private long avgDurationInt;
    private long avgCountInt;
    private int minDurationCall = -129;
    private int maxDurationCall;
    private long avgDurationCall;
    private long avgCountCall;
    private PingHandler pingHandler;
    static /* synthetic */ Class class$de$esolutions$fw$util$transport$exception$EndOfTransportException;

    public ConnectionHandler(short s, short s2, short s3, short s4, Connection connection, boolean bl, byte by, IProtocolDecider iProtocolDecider, boolean bl2, TransportWorkerFactory transportWorkerFactory, short s5, ConnectionClientHandler connectionClientHandler, IConnectionRequestCallback iConnectionRequestCallback, boolean bl3, IProtocolCallbacks iProtocolCallbacks, ITimeSource iTimeSource, IRunnableWrapper iRunnableWrapper, CommConfig commConfig) {
        this.myID = s;
        this.peerAgentID = s4;
        this.connection = connection;
        this.dynamicAgentId = bl3;
        this.monoTime = iTimeSource;
        this.runnableWrapper = iRunnableWrapper;
        this.config = commConfig;
        this.protocolHandler = new ProtocolHandler(s2, s3, connection, bl, this.dynamicAgentId, by, iProtocolCallbacks);
        this.lifecycle = new Lifecycle(this);
        this.isIncoming = s4 == -1;
        this.myAgentID = s2;
        this.transportWorkerFactory = transportWorkerFactory;
        this.tracePeer = s5;
        this.clientHandler = connectionClientHandler;
        this.callback = iConnectionRequestCallback;
        this.connectionType = bl2 ? "spawn" : "simple";
        this.protocolHandler.setDecider(iProtocolDecider, this);
    }

    public void pingControl(String string) {
        if (this.pingHandler != null) {
            this.pingHandler.parseControlCommand(string);
        }
    }

    public void doTimer() {
        boolean bl;
        if (this.pingHandler != null && !(bl = this.pingHandler.timerTick())) {
            CommAgentTracing.CLIENT.log((short)3, "$%1(%2): Ping detects: Lost Connection", new Short(this.myID), (Object)new Short(this.peerAgentID));
            try {
                this.connection.close(false);
            }
            catch (Exception exception) {
                CommAgentTracing.CLIENT.log((short)3, "$%1(%2): Ping detects: connection close failed", new Short(this.myID), (Object)new Short(this.peerAgentID));
            }
        }
    }

    private void enableDebug() {
        CommAgentTracing.PEER.log((short)0, "enabled connection tracing to peer %1", new Short(this.peerAgentID));
        this.debugAdapter = new TransportDebugAdapter(CommAgentTracing.PEER, 100);
        this.debugAdapter.start(5);
        this.protocolHandler.setDebug(this.debugAdapter);
        this.connection.getTransport().setDebug(this.debugAdapter);
    }

    private void disableDebug() {
        if (this.debugAdapter != null) {
            CommAgentTracing.PEER.log((short)0, "disabled connection tracing to peer %1", new Short(this.peerAgentID));
            this.protocolHandler.setDebug(null);
            this.connection.getTransport().setDebug(null);
            this.debugAdapter.stop();
            this.debugAdapter = null;
        }
    }

    public String getConnectionDescription() {
        return this.connection.getDescription();
    }

    public short getPeerAgentID() {
        return this.peerAgentID;
    }

    public short getPeerAgentEpoch() {
        return this.protocolHandler.getPeerAgentEpoch();
    }

    public void assignPeerAgentID(short s) {
        if (this.isIncoming) {
            this.peerAgentID = s;
            CommAgentTracing.CLIENT.log((short)0, "$%1(%2): assigned peer id", new Short(this.myID), (Object)new Short(this.peerAgentID));
            if (this.thread != null) {
                this.thread.setName(this.getThreadName());
            }
        }
    }

    public boolean isIncoming() {
        return this.isIncoming;
    }

    public short getMyID() {
        return this.myID;
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public int getErrorCode() {
        return this.lifecycle.getErrorCode();
    }

    public String getErrorString() {
        int n = this.getErrorCode();
        switch (n) {
            case 0: {
                return "normal operation";
            }
            case 1: {
                return "handshake failed";
            }
            case 2: {
                return "connection lost";
            }
        }
        return null;
    }

    public Long getDispatchStartTime() {
        return this.dispatchStartTime;
    }

    public AbstractMessage getDispatchMessage() {
        return this.dispatchMessage;
    }

    public int[] getDispatchDurationInternal() {
        long l = this.avgDurationInt;
        if (this.avgCountInt > 0L) {
            l /= this.avgCountInt;
        }
        return new int[]{this.minDurationInt, this.maxDurationInt, (int)l};
    }

    public int[] getDispatchDurationCall() {
        long l = this.avgDurationCall;
        if (this.avgCountCall > 0L) {
            l /= this.avgCountCall;
        }
        return new int[]{this.minDurationCall, this.maxDurationCall, (int)l};
    }

    public ProtocolHandler getProtocolHandler() {
        return this.protocolHandler;
    }

    private String getThreadName() {
        Buffer buffer = new Buffer();
        buffer.append(this.isIncoming ? "commRxAcc" : "commRxCon");
        if (this.peerAgentID != -1) {
            buffer.append(this.peerAgentID);
        }
        return buffer.toString();
    }

    public void start() {
        if (!this.lifecycle.isUnborn()) {
            return;
        }
        this.thread = new Thread(this.runnableWrapper.wrap(this), this.getThreadName());
        this.thread.start();
    }

    public void stop() {
        if (!this.lifecycle.isAlive()) {
            return;
        }
        CommAgentTracing.CLIENT.log((short)0, "$%1(%2) + stop", new Short(this.myID), (Object)new Short(this.peerAgentID));
        try {
            this.setDoShutdown();
            this.thread.interrupt();
            this.connection.close(false);
        }
        catch (Exception exception) {
            CommAgentTracing.CLIENT.log((short)4, "$%1(%2): shutdown failed: %3", new Short(this.myID), (Object)new Short(this.peerAgentID), (Object)exception);
        }
        CommAgentTracing.CLIENT.log((short)0, "$%1(%2): - stop", new Short(this.myID), (Object)new Short(this.peerAgentID));
    }

    private synchronized void setDoShutdown() {
        this.doShutdown = true;
    }

    private synchronized boolean getDoShutdown() {
        return this.doShutdown;
    }

    public boolean getWasDropped() {
        return this.wasDropped;
    }

    public void setClientHandler(ConnectionClientHandler connectionClientHandler) {
        this.clientHandler = connectionClientHandler;
    }

    private void delayConnect(int n) {
        long l;
        long l2 = this.monoTime.getCurrentTime();
        long l3 = l2 - (l = this.clientHandler.getLastDisconnectTimeStamp());
        if (l3 > 0L && l3 < (long)n) {
            int n2 = n - (int)l3;
            CommAgentTracing.CLIENT.log((short)2, "$%1(%2): delaying connect: %3 ms", new Short(this.myID), (Object)new Short(this.peerAgentID), (Object)new Integer(n2));
            try {
                Thread.sleep(n2);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    @Override
    public void run() {
        int n;
        CommAgentTracing.CLIENT.log((short)1, "$%1(%2): connection handler started", new Short(this.myID), (Object)new Short(this.peerAgentID));
        if (this.clientHandler != null && (n = this.clientHandler.getMinConnectInterval()) > 0) {
            this.delayConnect(n);
        }
        try {
            this.wasDropped = this.doHandshake();
            CommAgentTracing.COMM.log((short)2, "on='%1' event='connection' type='%2' destination='%3' info='started' ", new Short(this.myAgentID), (Object)this.connectionType, (Object)new Short(this.peerAgentID));
            if (this.wasDropped) {
                CommAgentTracing.CLIENT.log((short)1, "$%1(%2): connection handler: dead -> dropped!", new Short(this.myID), (Object)new Short(this.peerAgentID));
                this.lifecycle.setDead();
                if (this.callback != null) {
                    this.callback.connectionEstablished(this.clientHandler);
                }
                CommAgentTracing.COMM.log((short)2, "on='%1' event='connection' type='%2' destination='%3' info='dropped' ", new Integer(this.myAgentID), (Object)this.connectionType, (Object)new Short(this.peerAgentID));
                return;
            }
        }
        catch (ClientException clientException) {
            CommAgentTracing.CLIENT.log((short)1, "$%1(%2): connection handler: dead -> handshake failed: %3", new Short(this.myID), (Object)new Short(this.peerAgentID), (Object)clientException.getMessage());
            CommAgentTracing.COMM.log((short)2, "on='%1' event='connection' type='%2' destination='%3' info='failed' ", new Integer(this.myAgentID), (Object)this.connectionType, (Object)new Short(this.peerAgentID));
            this.lifecycle.setError(1);
            if (this.callback != null) {
                this.callback.connectionFailed(this.clientHandler, clientException.getMessage());
            }
            return;
        }
        this.setRxThreadPrio();
        Boolean bl = this.prepareTransport();
        if (bl == null) {
            return;
        }
        if (this.peerAgentID == this.tracePeer) {
            this.enableDebug();
        }
        this.lifecycle.setAlive();
        if (this.clientHandler != null) {
            this.clientHandler.setLastConnectTimeStamp(this.monoTime.getCurrentTime());
        }
        this.pingHandler = PingHandler.create(this.config, this.protocolHandler, this.myID, this.peerAgentID);
        if (this.pingHandler != null) {
            this.protocolHandler.setMessageListener(this.pingHandler);
        }
        CommAgentTracing.CLIENT.log((short)1, "$%1(%2): connection handler is alive. async=%3. ping=%4", new Short(this.myID), (Object)new Short(this.peerAgentID), (Object)bl, (Object)this.pingHandler);
        CommAgentTracing.COMM.log((short)2, "on='%1' event='connection' type='%2' destination='%3' info='established' ", new Integer(this.myAgentID), (Object)this.connectionType, (Object)new Short(this.peerAgentID));
        if (this.callback != null) {
            this.callback.connectionEstablished(this.clientHandler);
        }
        boolean bl2 = false;
        boolean bl3 = true;
        while (this.lifecycle.isAlive() && bl3) {
            try {
                this.dispatchStartTime = null;
                this.dispatchMessage = null;
                AbstractMessage abstractMessage = this.protocolHandler.recvMessage();
                long l = this.monoTime.getCurrentTime();
                this.dispatchStartTime = new Long(l);
                this.dispatchMessage = abstractMessage;
                bl3 = this.protocolHandler.dispatchMessage(abstractMessage);
                long l2 = this.monoTime.getCurrentTime();
                int n2 = (int)(l2 - l);
                this.accountDispatchDelta(n2, abstractMessage);
            }
            catch (InterruptedException interruptedException) {
            }
            catch (InterruptedIOException interruptedIOException) {
            }
            catch (TransportTimeoutException transportTimeoutException) {
            }
            catch (TransportPartialPacketException transportPartialPacketException) {
                CommAgentTracing.CLIENT.log((short)4, "COMM reader thread failed on partial packet: %1", transportPartialPacketException);
                bl2 = true;
                break;
            }
            catch (Exception exception) {
                if (this.getDoShutdown()) break;
                if (super.getClass() == (class$de$esolutions$fw$util$transport$exception$EndOfTransportException == null ? (class$de$esolutions$fw$util$transport$exception$EndOfTransportException = ConnectionHandler.class$("de.esolutions.fw.util.transport.exception.EndOfTransportException")) : class$de$esolutions$fw$util$transport$exception$EndOfTransportException)) {
                    CommAgentTracing.CLIENT.log((short)1, "EOT detected");
                    break;
                }
                CommAgentTracing.CLIENT.log((short)4, "COMM reader thread failed: %1", exception);
                bl2 = true;
                break;
            }
            if (!this.getDoShutdown()) continue;
        }
        this.dispatchMessage = null;
        this.dispatchStartTime = null;
        if (this.clientHandler != null) {
            this.clientHandler.setLastDisconnectTimeStamp(this.monoTime.getCurrentTime());
        }
        if (this.getDoShutdown() || !bl3) {
            CommAgentTracing.CLIENT.log((short)1, "$%1(%2): connection handler shutdown finished", new Short(this.myID), (Object)new Short(this.peerAgentID));
            this.lifecycle.setDead();
            CommAgentTracing.COMM.log((short)2, "on='%1' event='connection' type='%2' destination='%3' info='closed' ", new Integer(this.myAgentID), (Object)this.connectionType, (Object)new Short(this.peerAgentID));
        } else {
            CommAgentTracing.CLIENT.log(bl2 ? (short)4 : 3, "$%1(%2): connection handler lost connection. remote peer disconnected!", new Short(this.myID), (Object)new Short(this.peerAgentID));
            try {
                this.connection.close(false);
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.lifecycle.setError(2);
            CommAgentTracing.COMM.log((short)2, "on='%1' event='connection' type='%2' destination='%3' info='lost' ", new Integer(this.myAgentID), (Object)this.connectionType, (Object)new Short(this.peerAgentID));
        }
        if (this.peerAgentID == this.tracePeer) {
            this.disableDebug();
        }
    }

    private final void setRxThreadPrio() {
        boolean bl = this.config.getDynamicAgentIdsConfig().isDynamicAgentID(this.peerAgentID);
        CommConfigTransport commConfigTransport = this.config.getTransport();
        CommConfigTransportParams commConfigTransportParams = commConfigTransport.getRxTransportConfig(this.peerAgentID, bl);
        int n = commConfigTransportParams.getPriority();
        int n2 = this.thread.getPriority();
        if (n2 != n) {
            this.thread.setPriority(n);
            CommAgentTracing.CLIENT.log((short)2, "$%1(%2): connection handler priority change from %3 to %4 (%5)", new Short(this.myID), (Object)new Short(this.peerAgentID), (Object)new Integer(n2), (Object)new Integer(n));
        }
    }

    private final Boolean prepareTransport() {
        TransportWorker transportWorker = this.transportWorkerFactory.createTransportWorker(this.peerAgentID);
        if (transportWorker != null) {
            AsyncTXTransport asyncTXTransport = new AsyncTXTransport(this.connection.getTransport(), transportWorker);
            try {
                asyncTXTransport.open();
            }
            catch (IOException iOException) {
                CommAgentTracing.CLIENT.log((short)4, "$%1(%2): async transport errror: %3", new Short(this.myID), (Object)new Short(this.peerAgentID), (Object)iOException);
                this.lifecycle.setError(2);
                return null;
            }
            this.connection = new Connection(asyncTXTransport, this.connection.getSerializer(), this.connection.getDeserializer());
            this.protocolHandler.setConnection(this.connection);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private final void accountDispatchDelta(int n, AbstractMessage abstractMessage) {
        if (abstractMessage instanceof CallMethodMessage) {
            if (n < this.minDurationCall) {
                this.minDurationCall = n;
            }
            if (n > this.maxDurationCall) {
                this.maxDurationCall = n;
            }
            this.avgDurationCall += (long)n;
            ++this.avgCountCall;
        } else {
            if (n < this.minDurationInt) {
                this.minDurationInt = n;
            }
            if (n > this.maxDurationInt) {
                this.maxDurationInt = n;
            }
            this.avgDurationInt += (long)n;
            ++this.avgCountInt;
        }
    }

    private final boolean doHandshake() {
        try {
            boolean bl;
            this.connection.open();
            boolean bl2 = bl = this.peerAgentID != -1;
            if (bl) {
                if (!this.protocolHandler.connectActive(this.peerAgentID)) {
                    if (this.protocolHandler.getState() == 5) {
                        return true;
                    }
                    throw new ProtocolException(new StringBuffer().append("FAILED iniating protocol to peer=#").append(this.peerAgentID).toString());
                }
            } else if (!this.protocolHandler.connectPassive()) {
                if (this.protocolHandler.getState() == 5) {
                    return true;
                }
                throw new ProtocolException(new StringBuffer().append("FAILED iniating protocol to peer=#").append(this.peerAgentID).toString());
            }
            if (bl) {
                short s = this.protocolHandler.getPeerAgentID();
                if (this.peerAgentID != s) {
                    throw new ClientException(new StringBuffer().append("PeerAgentID != reported PeerAgentID: ").append(this.peerAgentID).append(" != ").append(s).toString());
                }
            } else {
                this.peerAgentID = this.protocolHandler.getPeerAgentID();
            }
            return false;
        }
        catch (InterruptedException interruptedException) {
            throw new ClientException(new StringBuffer().append("Interrupted:").append(interruptedException).toString());
        }
        catch (IOException iOException) {
            throw new ClientException(new StringBuffer().append("IO Error: ").append(iOException).toString());
        }
        catch (TransportException transportException) {
            throw new ClientException(new StringBuffer().append("Transport Error: ").append(transportException).toString());
        }
        catch (SerializerException serializerException) {
            throw new ClientException(new StringBuffer().append("Serializer Error: ").append(serializerException).toString());
        }
        catch (ProtocolException protocolException) {
            throw new ClientException(new StringBuffer().append("Protocol Error: ").append(protocolException).toString());
        }
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

