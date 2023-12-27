/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.async.ClientContext;
import de.esolutions.fw.util.transport.async.TransportWorker;
import de.esolutions.fw.util.transport.debug.ITransportDebug;

public abstract class AbstractAsyncTransport
implements ITransport {
    protected ITransportDebug debug;
    protected final ITransport transport;
    protected final TransportWorker worker;
    protected final ClientContext context;
    private boolean isOpen;
    private Object openLock = new Object();

    public AbstractAsyncTransport(ITransport iTransport) {
        this.transport = iTransport;
        this.worker = new TransportWorker("AsyncTX");
        this.context = new ClientContext();
    }

    public AbstractAsyncTransport(ITransport iTransport, TransportWorker transportWorker) {
        this.transport = iTransport;
        this.worker = transportWorker;
        this.context = new ClientContext();
    }

    @Override
    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
        this.transport.setDebug(this.debug);
    }

    @Override
    public int maxMsgSize() {
        return this.transport.maxMsgSize();
    }

    @Override
    public boolean isReliable() {
        return this.transport.isReliable();
    }

    @Override
    public boolean detectsPeerReset() {
        return this.transport.detectsPeerReset();
    }

    @Override
    public boolean keepsRecordBoundaries() {
        return this.transport.keepsRecordBoundaries();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void open() {
        Object object = this.openLock;
        synchronized (object) {
            if (!this.isOpen) {
                this.isOpen = true;
                this.transport.open();
                this.worker.start();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close(boolean bl) {
        Object object = this.openLock;
        synchronized (object) {
            if (this.isOpen) {
                this.isOpen = false;
                this.transport.close(bl);
                this.worker.shutdown();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isOpen() {
        Object object = this.openLock;
        synchronized (object) {
            return this.isOpen;
        }
    }

    @Override
    public abstract IReadable recv() {
    }

    @Override
    public abstract void send(IWriter iWriter) {
    }

    @Override
    public abstract void sendSync(IWriter iWriter) {
    }

    @Override
    public abstract void flush() {
    }

    @Override
    public abstract String getDescription() {
    }
}

