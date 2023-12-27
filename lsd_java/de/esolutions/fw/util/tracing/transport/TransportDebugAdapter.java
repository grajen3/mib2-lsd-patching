/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.transport;

import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.transport.TransportDebugAdapter$Entry;
import de.esolutions.fw.util.tracing.transport.TransportDebugAdapter$MyQueueWorker;
import de.esolutions.fw.util.transport.debug.ITransportDebug;

public class TransportDebugAdapter
implements ITransportDebug {
    private final TransportDebugAdapter$MyQueueWorker worker;

    public TransportDebugAdapter(TraceChannel traceChannel, int n) {
        this.worker = new TransportDebugAdapter$MyQueueWorker(traceChannel, n);
    }

    public void start(int n) {
        this.worker.start(n);
    }

    public void stop() {
        this.worker.stop();
    }

    @Override
    public void log(long l, int n, int n2, Object object) {
        this.worker.add(new TransportDebugAdapter$Entry(Thread.currentThread(), l, n, n2, object));
    }
}

