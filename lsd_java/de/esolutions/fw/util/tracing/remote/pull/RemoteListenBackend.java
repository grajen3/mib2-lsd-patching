/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.pull;

import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.tracing.remote.ActiveRemoteBackend;
import de.esolutions.fw.util.tracing.remote.pull.IRemoteListenNotifier;
import de.esolutions.fw.util.tracing.remote.pull.RemoteListenBackendManager;

public class RemoteListenBackend
extends ActiveRemoteBackend {
    private final Connection connection;
    private final IRemoteListenNotifier notifier;
    private final RemoteListenBackendManager mgr;
    private boolean isConnected;
    private boolean forceActive;

    private boolean doConnect() {
        try {
            this.isConnected = this.remoteConnect(this.connection, true, false, this.forceActive);
        }
        catch (InterruptedException interruptedException) {
            this.isConnected = false;
        }
        return this.isConnected;
    }

    public RemoteListenBackend(RemoteListenBackendManager remoteListenBackendManager, Connection connection, IRemoteListenNotifier iRemoteListenNotifier) {
        super("remoteListen");
        this.connection = connection;
        this.notifier = iRemoteListenNotifier;
        this.mgr = remoteListenBackendManager;
        this.setSendSyncMarkers(true);
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void setForceActive(boolean bl) {
        this.forceActive = bl;
    }

    @Override
    public boolean connect() {
        if (!this.isConnected) {
            if (this.doConnect()) {
                if (this.notifier != null) {
                    this.notifier.connectedLogger(this.getPeerName(), this.connection);
                }
                this.isConnected = true;
                if (!this.isPassiveConnect()) {
                    this.startWorker();
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public void disconnect() {
        if (this.isConnected) {
            boolean bl = this.isPassiveConnect();
            if (!bl) {
                this.stopWorker();
            }
            this.remoteDisconnect();
            if (this.notifier != null) {
                this.notifier.disconnectedLogger(this.getPeerName(), this.connection);
            }
            this.isConnected = false;
        }
        super.disconnect();
    }

    @Override
    protected boolean doInit() {
        return true;
    }

    @Override
    protected boolean doWork() {
        if (this.isConnected) {
            return this.handleProtocol();
        }
        Thread.sleep(0);
        return true;
    }

    @Override
    protected void doExit() {
        if (this.isConnected) {
            String string = this.getPeerName();
            this.remoteDisconnect();
            if (this.notifier != null) {
                this.notifier.disconnectedLogger(string, this.connection);
            }
            this.isConnected = false;
        }
        this.mgr.removeBackend(this);
    }
}

