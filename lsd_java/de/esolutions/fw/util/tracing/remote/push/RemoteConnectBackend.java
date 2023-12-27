/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.push;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.serializer.connection.ConfigConnectionFactoryProvider;
import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.GenericConnectionFactory;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.factory.BEDefaultSerializerFactory;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.remote.ActiveRemoteBackend;
import de.esolutions.fw.util.transport.config.TransportConfig;
import de.esolutions.fw.util.transport.factory.TCPSingleTransportFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RemoteConnectBackend
extends ActiveRemoteBackend {
    private IConnectionFactory factory;
    private boolean doConnect;
    private boolean doDisconnect;
    private boolean isConnected;
    private String remoteProc;
    private String remoteHost;
    private int remotePort;
    private int retryInterval;
    private int connectAfter;
    private int ignoreDelayAfter;
    private int connectDelay;
    private boolean bulkLogData;
    private boolean bulkCreateEntity;
    private boolean bulkChangeLevel;
    private static final String chn;

    public RemoteConnectBackend() {
        super("remoteConnect");
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        IConfigQuery iConfigQuery = traceConfigBackend.getQuery();
        this.remoteProc = iConfigQuery.getStringValue("proc", null);
        this.remoteHost = iConfigQuery.getStringValue("host", null);
        this.remotePort = iConfigQuery.getIntegerValue("port", -1);
        this.retryInterval = iConfigQuery.getIntegerValue("retryInterval", 5000);
        this.connectAfter = iConfigQuery.getIntegerValue("connectAfter", 0);
        this.ignoreDelayAfter = iConfigQuery.getIntegerValue("ignoreDelayAfter", 0);
        this.connectDelay = iConfigQuery.getIntegerValue("connectDelay", 0);
        this.bulkLogData = iConfigQuery.getBooleanValue("bulkLogData", false);
        this.bulkCreateEntity = iConfigQuery.getBooleanValue("bulkCreateEntity", false);
        this.bulkChangeLevel = iConfigQuery.getBooleanValue("bulkChangeLevel", false);
        boolean bl = iConfigQuery.getBooleanValue("aggregate", false);
        if (bl) {
            this.bulkLogData = true;
            this.bulkCreateEntity = true;
        }
    }

    @Override
    public int getFlags() {
        int n = super.getFlags();
        if (this.bulkLogData) {
            n |= 8;
        }
        if (this.bulkCreateEntity) {
            n |= 0x10;
        }
        if (this.bulkChangeLevel) {
            n |= 0x20;
        }
        return n;
    }

    @Override
    public boolean connect() {
        TraceMe.msg(TraceMe.INFO, "RemoteConnectBackend", "start worker");
        this.startWorker();
        this.listener.logMessage(this.bid, "trigger remote connect");
        if (!this.isConnected) {
            this.doConnect = true;
        }
        return true;
    }

    @Override
    public void disconnect() {
        this.listener.logMessage(this.bid, "remote disconnect");
        if (this.isConnected) {
            this.doDisconnect = true;
        }
        TraceMe.msg(TraceMe.INFO, "RemoteConnectBackend", "stop worker");
        this.stopWorker();
    }

    private boolean setupFactory() {
        if (this.remoteProc != null) {
            TransportConfig transportConfig = TransportConfig.getInstance();
            if (!transportConfig.isValid()) {
                this.listener.logMessage(this.bid, new StringBuffer().append("Invalid Transport Config: ").append(transportConfig.getFailString()).toString());
                return false;
            }
            try {
                ConfigConnectionFactoryProvider configConnectionFactoryProvider = new ConfigConnectionFactoryProvider(transportConfig);
                this.factory = configConnectionFactoryProvider.createConnectionFactory("tracing", this.remoteProc);
                this.listener.logMessage(this.bid, new StringBuffer().append("Got Transport Factory for tracing:").append(this.remoteProc).toString());
                return true;
            }
            catch (ConnectionFactoryException connectionFactoryException) {
                this.listener.logMessage(this.bid, new StringBuffer().append("Transport Provider failed: ").append(connectionFactoryException.getMessage()).toString());
                return false;
            }
        }
        if (this.remoteHost != null && this.remotePort != -1) {
            this.listener.logMessage(this.bid, new StringBuffer().append("setting up factory to ").append(this.remoteHost).append(":").append(this.remotePort).toString());
            TCPSingleTransportFactory tCPSingleTransportFactory = null;
            try {
                tCPSingleTransportFactory = new TCPSingleTransportFactory(InetAddress.getByName(this.remoteHost), this.remotePort);
            }
            catch (UnknownHostException unknownHostException) {
                this.listener.logMessage(this.bid, new StringBuffer().append("ERROR: unknown host: ").append(this.remoteHost).toString());
                return false;
            }
            BEDefaultSerializerFactory bEDefaultSerializerFactory = new BEDefaultSerializerFactory();
            this.factory = new GenericConnectionFactory(tCPSingleTransportFactory, bEDefaultSerializerFactory);
            return true;
        }
        this.listener.logMessage(this.bid, "can't setup remote connection. 'proc' or 'host' and 'port' missing!");
        return false;
    }

    @Override
    protected boolean doInit() {
        TraceMe.msg(TraceMe.DEBUG, "RemoteConnectBackend", "doInit");
        if (!this.setupFactory()) {
            this.listener.connected(this.bid, false);
            return false;
        }
        this.delayStartup();
        return true;
    }

    private void delayStartup() {
        try {
            ITimeSource iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
            long l = iTimeSource.getCurrentTime();
            if (this.connectAfter > 0) {
                if (l < (long)this.connectAfter) {
                    long l2 = (long)this.connectAfter - l;
                    this.listener.logMessage(this.bid, new StringBuffer().append("connectAfter: waiting for ").append(l2).append(" ms").toString());
                    Thread.sleep(l2);
                }
            } else if (this.ignoreDelayAfter > 0 && this.connectDelay > 0) {
                if (l < (long)this.ignoreDelayAfter) {
                    this.listener.logMessage(this.bid, new StringBuffer().append("ignoreDelayAfter: waiting for ").append(this.connectDelay).append(" ms").toString());
                    Thread.sleep(this.connectDelay);
                }
            } else if (this.connectDelay > 0) {
                this.listener.logMessage(this.bid, new StringBuffer().append("connectDelay: waiting for ").append(this.connectDelay).append(" ms").toString());
                Thread.sleep(this.connectDelay);
            }
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    @Override
    protected boolean doWork() {
        if (this.doConnect && !this.isConnected) {
            TraceMe.msg(TraceMe.DEBUG, "RemoteConnectBackend", "remote connect");
            this.isConnected = this.remoteConnect(this.factory.createConnection(), true, false, false);
            if (!this.isConnected) {
                try {
                    this.listener.logMessage(this.bid, new StringBuffer().append("delay for reconnect ").append(this.retryInterval).append(" ms").toString());
                    Thread.sleep(this.retryInterval);
                }
                catch (InterruptedException interruptedException) {}
            }
        } else if (this.doDisconnect && this.isConnected) {
            TraceMe.msg(TraceMe.DEBUG, "RemoteConnectBackend", "remote disconnect");
            this.remoteDisconnect();
            this.doDisconnect = false;
            this.isConnected = false;
        } else if (this.isConnected) {
            if (!this.handleProtocol()) {
                if (!this.doRun) {
                    TraceMe.msg(TraceMe.INFO, "RemoteConnectBackend", "handleProtocol returned -> shutdown");
                    return false;
                }
                TraceMe.msg(TraceMe.INFO, "RemoteConnectBackend", "handleProtocol returned -> disconnect");
                this.doDisconnect = true;
                this.doConnect = true;
            }
        } else {
            Thread.sleep(0);
        }
        return true;
    }

    @Override
    protected void doExit() {
        TraceMe.msg(TraceMe.DEBUG, "RemoteConnectBackend", "doExit");
        if (this.isConnected) {
            this.remoteDisconnect();
            this.isConnected = false;
        }
    }
}

