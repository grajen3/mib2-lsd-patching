/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.pull;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.remote.AbstractRemoteFrontend;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendReconnectWorker;
import de.esolutions.fw.util.tracing.remote.IConnectionFrontendListener;

public class RemoteConnectFrontend
extends AbstractRemoteFrontend
implements IConnectionFrontendListener {
    private final ConnectionFrontendReconnectWorker worker;
    private static final String chn;

    public RemoteConnectFrontend(IConnectionFactory iConnectionFactory, TraceFrontend traceFrontend) {
        super(traceFrontend);
        String string = SystemConfig.getInstance().getMyProcName();
        this.worker = new ConnectionFrontendReconnectWorker(string, iConnectionFactory, traceFrontend);
        this.worker.addListener(this);
    }

    public void addListener(IConnectionFrontendListener iConnectionFrontendListener) {
        this.worker.addListener(iConnectionFrontendListener);
    }

    public void removeListener(IConnectionFrontendListener iConnectionFrontendListener) {
        this.worker.removeListener(iConnectionFrontendListener);
    }

    @Override
    public boolean start() {
        if (!super.start()) {
            return false;
        }
        TraceMe.msg(TraceMe.INFO, "RemoteConnectFrontend", "start");
        return this.worker.start();
    }

    @Override
    public void stop() {
        TraceMe.msg(TraceMe.INFO, "RemoteConnectFrontend", "stop");
        this.worker.stop();
        super.stop();
    }

    @Override
    public void configureHandler(ConnectionFrontendHandler connectionFrontendHandler) {
        connectionFrontendHandler.setPassiveMode(false);
    }

    @Override
    public void registerConnection(ConnectionFrontendHandler connectionFrontendHandler) {
    }

    @Override
    public void unregisterConnection(ConnectionFrontendHandler connectionFrontendHandler) {
    }

    @Override
    public void handleMessage(ConnectionFrontendHandler connectionFrontendHandler, AbstractMessage abstractMessage) {
    }
}

