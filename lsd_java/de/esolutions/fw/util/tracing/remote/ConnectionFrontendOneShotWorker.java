/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendWorkerBase;

public class ConnectionFrontendOneShotWorker
extends ConnectionFrontendWorkerBase {
    private Connection connection;
    private ConnectionFrontendHandler handler;
    public static final String chn;

    public ConnectionFrontendOneShotWorker(String string, Connection connection, TraceFrontend traceFrontend) {
        super(string, traceFrontend);
        this.connection = connection;
    }

    public synchronized void stop() {
        super.stop(this.handler);
    }

    @Override
    protected void doRun() {
        this.handler = new ConnectionFrontendHandler(this.myName, this.connection, this.frontend);
        this.configureHandler(this.handler);
        if (this.handler.connect()) {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendOneShotWorker", "enter msg loop");
            this.messageLoop("ConnectionFrontendOneShotWorker", this.handler);
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendOneShotWorker", "leave msg loop");
            if (this.handler.isConnected()) {
                this.handler.disconnect();
                this.handler = null;
            }
        } else {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendOneShotWorker", "can't connect: %1", this.connection.getDescription());
        }
        this.keepRunning = false;
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendOneShotWorker", "Thread done.");
    }
}

