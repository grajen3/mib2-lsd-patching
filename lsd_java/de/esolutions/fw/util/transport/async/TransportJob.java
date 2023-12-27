/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.async.ClientContext;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public abstract class TransportJob {
    protected final ClientContext context;
    protected final ITransport transport;
    private boolean isDone;
    private boolean ok;

    public TransportJob(ClientContext clientContext, ITransport iTransport) {
        this.context = clientContext;
        this.transport = iTransport;
    }

    public ClientContext getClientContext() {
        return this.context;
    }

    public ITransport getTransport() {
        return this.transport;
    }

    protected abstract void doIO() {
    }

    public boolean doTransport() {
        try {
            this.doIO();
            this.setDone(true);
            return true;
        }
        catch (IOException iOException) {
            if (this.context != null) {
                this.context.setIOException(iOException);
            }
            this.setDone(false);
            return false;
        }
        catch (TransportException transportException) {
            if (this.context != null) {
                this.context.setTransportException(transportException);
            }
            this.setDone(false);
            return false;
        }
    }

    private synchronized void setDone(boolean bl) {
        this.isDone = true;
        this.ok = bl;
        super.notifyAll();
    }

    public synchronized boolean waitDone() {
        while (!this.isDone) {
            try {
                super.wait();
            }
            catch (InterruptedException interruptedException) {}
        }
        return this.ok;
    }
}

