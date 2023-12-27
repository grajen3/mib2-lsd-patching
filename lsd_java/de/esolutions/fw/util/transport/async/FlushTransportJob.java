/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.async.ClientContext;
import de.esolutions.fw.util.transport.async.TransportJob;

public final class FlushTransportJob
extends TransportJob {
    public FlushTransportJob(ClientContext clientContext, ITransport iTransport) {
        super(clientContext, iTransport);
    }

    @Override
    protected final void doIO() {
        this.transport.flush();
    }
}

