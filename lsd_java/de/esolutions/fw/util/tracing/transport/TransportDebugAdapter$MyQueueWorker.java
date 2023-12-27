/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.transport;

import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.queue.QueueWorker;
import de.esolutions.fw.util.tracing.TraceChannel;
import de.esolutions.fw.util.tracing.transport.TransportDebugAdapter$Entry;

class TransportDebugAdapter$MyQueueWorker
extends QueueWorker {
    private TraceChannel channel;

    public TransportDebugAdapter$MyQueueWorker(TraceChannel traceChannel, int n) {
        super("fwTpDebug", n);
        this.channel = traceChannel;
    }

    @Override
    protected void handleQueuedObject(Object object) {
        TransportDebugAdapter$Entry transportDebugAdapter$Entry = (TransportDebugAdapter$Entry)object;
        this.channel.log((short)2, "%1", transportDebugAdapter$Entry);
    }

    public void add(TransportDebugAdapter$Entry transportDebugAdapter$Entry) {
        try {
            this.addToQueue(transportDebugAdapter$Entry);
        }
        catch (QueueShutdownException queueShutdownException) {
            // empty catch block
        }
    }
}

