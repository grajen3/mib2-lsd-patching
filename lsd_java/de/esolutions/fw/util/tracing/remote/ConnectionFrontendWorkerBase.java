/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.remote.ConnectionFrontendHandler;
import de.esolutions.fw.util.tracing.remote.IConnectionFrontendListener;
import java.util.ArrayList;
import java.util.ListIterator;

public abstract class ConnectionFrontendWorkerBase
implements Runnable {
    protected final String myName;
    protected final TraceFrontend frontend;
    protected final ArrayList listeners;
    private boolean isStarted;
    protected boolean keepRunning;
    private Thread thread;
    public static final String chn;

    public ConnectionFrontendWorkerBase(String string, TraceFrontend traceFrontend) {
        this.myName = string;
        this.frontend = traceFrontend;
        this.listeners = new ArrayList();
    }

    public void addListener(IConnectionFrontendListener iConnectionFrontendListener) {
        this.listeners.add(iConnectionFrontendListener);
    }

    public void removeListener(IConnectionFrontendListener iConnectionFrontendListener) {
        this.listeners.remove(iConnectionFrontendListener);
    }

    public synchronized boolean start() {
        if (this.isStarted) {
            return false;
        }
        this.keepRunning = true;
        this.isStarted = true;
        this.thread = new Thread(this, new StringBuffer().append("ConWorker_").append(this.myName).toString());
        this.thread.start();
        return true;
    }

    protected synchronized void stop(ConnectionFrontendHandler connectionFrontendHandler) {
        if (!this.isStarted) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "stop but not started!");
            return;
        }
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "stop");
        this.keepRunning = false;
        this.isStarted = false;
        if (connectionFrontendHandler != null) {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disconnect");
            connectionFrontendHandler.disconnect();
        }
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "interrupt");
        this.thread.interrupt();
        while (true) {
            try {
                this.thread.join();
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            break;
        }
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "joined");
    }

    @Override
    public void run() {
        while (this.keepRunning) {
            this.doRun();
        }
    }

    protected void configureHandler(ConnectionFrontendHandler connectionFrontendHandler) {
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            IConnectionFrontendListener iConnectionFrontendListener = (IConnectionFrontendListener)listIterator.next();
            iConnectionFrontendListener.configureHandler(connectionFrontendHandler);
        }
    }

    protected void messageLoop(String string, ConnectionFrontendHandler connectionFrontendHandler) {
        Object object;
        TraceMe.msg(TraceMe.INFO, string, "connected: %1", connectionFrontendHandler);
        ListIterator listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            object = (IConnectionFrontendListener)listIterator.next();
            object.registerConnection(connectionFrontendHandler);
        }
        while (connectionFrontendHandler.isValid()) {
            object = connectionFrontendHandler.handleIncomingMessage();
            if (object == null || this.listeners.isEmpty()) continue;
            listIterator = this.listeners.listIterator();
            while (listIterator.hasNext()) {
                IConnectionFrontendListener iConnectionFrontendListener = (IConnectionFrontendListener)listIterator.next();
                iConnectionFrontendListener.handleMessage(connectionFrontendHandler, (AbstractMessage)object);
            }
        }
        TraceMe.msg(TraceMe.INFO, string, "disconnected: %1", connectionFrontendHandler);
        listIterator = this.listeners.listIterator();
        while (listIterator.hasNext()) {
            object = (IConnectionFrontendListener)listIterator.next();
            object.unregisterConnection(connectionFrontendHandler);
        }
    }

    protected abstract void doRun() {
    }
}

