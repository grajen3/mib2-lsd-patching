/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendWorkerBase;

public class ConnectionFrontendReconnectWorker
extends ConnectionFrontendWorkerBase {
    private final IConnectionFactory factory;
    private long retryDelay = 0;
    private ConnectionFrontendHandler handler;
    public static final String chn;

    public ConnectionFrontendReconnectWorker(String string, IConnectionFactory iConnectionFactory, TraceFrontend traceFrontend) {
        super(string, traceFrontend);
        this.factory = iConnectionFactory;
    }

    public void setRetryDelay(long l) {
        this.retryDelay = l;
    }

    public synchronized void stop() {
        super.stop(this.handler);
    }

    @Override
    protected void doRun() {
        while (this.keepRunning) {
            Connection connection = this.factory.createConnection();
            this.handler = new ConnectionFrontendHandler(this.myName, connection, this.frontend);
            this.configureHandler(this.handler);
            if (this.handler.connect()) break;
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendReconnectWorker", "connection retry after %1 ms", new Long(this.retryDelay));
            try {
                Thread.sleep(this.retryDelay);
            }
            catch (InterruptedException interruptedException) {}
        }
        if (!this.keepRunning) {
            return;
        }
        this.messageLoop("ConnectionFrontendReconnectWorker", this.handler);
        if (this.handler.isConnected()) {
            this.handler.disconnect();
        }
        this.handler = null;
    }
}

