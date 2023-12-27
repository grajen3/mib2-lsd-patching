/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.aggregate.AggregateTransport;
import de.esolutions.fw.util.transport.async.AsyncRXTransport;
import de.esolutions.fw.util.transport.async.AsyncTXTransport;

public class BaseTransportFactory {
    protected boolean isAsync = false;
    protected boolean doAggregate = false;
    protected long asyncTxBufferSize = 0;
    protected long asyncRxBufferSize = 0;

    public boolean isAsync() {
        return this.isAsync;
    }

    public void setAsync(boolean bl) {
        this.isAsync = bl;
    }

    public boolean doAggregate() {
        return this.doAggregate;
    }

    public void setAggregate(boolean bl) {
        this.doAggregate = bl;
    }

    protected ITransport enrichTransport(ITransport iTransport) {
        if (this.doAggregate) {
            iTransport = new AggregateTransport(iTransport, 0);
        }
        if (this.isAsync) {
            AsyncTXTransport asyncTXTransport = new AsyncTXTransport(iTransport);
            AsyncRXTransport asyncRXTransport = new AsyncRXTransport(asyncTXTransport);
            iTransport = asyncRXTransport;
        }
        return iTransport;
    }
}

