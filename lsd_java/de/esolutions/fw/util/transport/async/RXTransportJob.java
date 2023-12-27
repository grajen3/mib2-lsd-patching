/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.async.ClientContext;
import de.esolutions.fw.util.transport.async.TransportJob;

public final class RXTransportJob
extends TransportJob {
    private IReadable readable;

    public RXTransportJob(ClientContext clientContext, ITransport iTransport) {
        super(clientContext, iTransport);
    }

    public final IReadable getReadable() {
        return this.readable;
    }

    @Override
    protected final void doIO() {
        this.readable = this.transport.recv();
    }
}

