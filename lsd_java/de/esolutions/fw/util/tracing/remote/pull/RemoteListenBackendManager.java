/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.pull;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.remote.pull.IRemoteListenNotifier;
import de.esolutions.fw.util.tracing.remote.pull.RemoteListenBackend;
import java.io.IOException;

public class RemoteListenBackendManager
implements ISpawnedConnectionListener {
    private ISpawnConnectionFactory factory;
    private TraceFrontend frontend;
    private IRemoteListenNotifier notifier;
    private boolean forceActive;
    private static final String chn;

    public RemoteListenBackendManager(ISpawnConnectionFactory iSpawnConnectionFactory, TraceFrontend traceFrontend, IRemoteListenNotifier iRemoteListenNotifier) {
        this.factory = iSpawnConnectionFactory;
        this.frontend = traceFrontend;
        this.notifier = iRemoteListenNotifier;
    }

    public void setForceActive(boolean bl) {
        this.forceActive = bl;
    }

    public boolean start() {
        this.factory.setListener(this);
        try {
            this.factory.enableSpawning();
            return true;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public void stop() {
        this.factory.disableSpawning();
    }

    @Override
    public void spawnedConnection(Connection connection) {
        RemoteListenBackend remoteListenBackend = new RemoteListenBackend(this, connection, this.notifier);
        remoteListenBackend.setForceActive(this.forceActive);
        TraceMe.msg(TraceMe.INFO, "RemoteListenBackendManager", "register backend for %1", connection);
        this.frontend.registerBackend(remoteListenBackend, "RemoteListen");
    }

    @Override
    public boolean spawningRetry(ISpawnConnectionFactory iSpawnConnectionFactory, IOException iOException, int n) {
        TraceMe.msg(TraceMe.INFO, "RemoteListenBackendManager", "%1 retry spawning: %2", iSpawnConnectionFactory.getDescription(), iOException);
        return true;
    }

    @Override
    public void spawningEnabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
        TraceMe.msg(TraceMe.INFO, "RemoteListenBackendManager", "%1 enabeld", iSpawnConnectionFactory.getDescription());
    }

    @Override
    public void spawningDisabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
        TraceMe.msg(TraceMe.INFO, "RemoteListenBackendManager", "%1 disabled", iSpawnConnectionFactory.getDescription());
    }

    public void removeBackend(RemoteListenBackend remoteListenBackend) {
        TraceMe.msg(TraceMe.INFO, "RemoteListenBackendManager", "unregister backend for %1", remoteListenBackend.getConnection());
        this.frontend.unregisterBackend(remoteListenBackend);
    }
}

