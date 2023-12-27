/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.async.AbstractAsyncTransport;
import de.esolutions.fw.util.transport.async.FlushTransportJob;
import de.esolutions.fw.util.transport.async.TXTransportJob;
import de.esolutions.fw.util.transport.async.TransportWorker;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.exception.TransportTimeoutException;
import java.io.IOException;
import java.net.SocketTimeoutException;

public class AsyncTXTransport
extends AbstractAsyncTransport {
    public AsyncTXTransport(ITransport iTransport) {
        super(iTransport);
    }

    public AsyncTXTransport(ITransport iTransport, TransportWorker transportWorker) {
        super(iTransport, transportWorker);
    }

    @Override
    public IReadable recv() {
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            return this.transport.recv();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
    }

    @Override
    public void send(IWriter iWriter) {
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            this.context.throwPendingException();
            this.worker.addJob(new TXTransportJob(this.context, this.transport, iWriter));
            this.context.throwPendingException();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
    }

    @Override
    public void sendSync(IWriter iWriter) {
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            this.context.throwPendingException();
            TXTransportJob tXTransportJob = new TXTransportJob(this.context, this.transport, iWriter);
            this.worker.addJob(tXTransportJob);
            tXTransportJob.waitDone();
            this.context.throwPendingException();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
    }

    @Override
    public void flush() {
        if (!this.isOpen()) {
            throw new TransportException("transport is not open!");
        }
        try {
            this.context.throwPendingException();
            this.worker.addJob(new FlushTransportJob(this.context, this.transport));
            this.context.throwPendingException();
        }
        catch (TransportTimeoutException transportTimeoutException) {
            throw transportTimeoutException;
        }
        catch (TransportException transportException) {
            this.close(true);
            throw transportException;
        }
        catch (SocketTimeoutException socketTimeoutException) {
            throw socketTimeoutException;
        }
        catch (IOException iOException) {
            this.close(true);
            throw iOException;
        }
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[AsyncTX:").append(this.transport.getDescription()).append("]").toString();
    }
}

