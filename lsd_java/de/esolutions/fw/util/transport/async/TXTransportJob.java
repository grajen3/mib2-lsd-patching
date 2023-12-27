/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.async.ClientContext;
import de.esolutions.fw.util.transport.async.TransportJob;

public final class TXTransportJob
extends TransportJob {
    private final IWriter writer;

    public TXTransportJob(ClientContext clientContext, ITransport iTransport, IWriter iWriter) {
        super(clientContext, iTransport);
        this.writer = iWriter;
    }

    public final IWriter getWriter() {
        return this.writer;
    }

    @Override
    protected final void doIO() {
        this.transport.send(this.writer);
    }
}

