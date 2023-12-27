/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.async.TransportJob;
import de.esolutions.fw.util.transport.exception.TransportQueueLimitException;
import de.esolutions.fw.util.transport.exception.TransportQueueShutdownException;
import java.util.ArrayList;
import java.util.List;

public final class TransportJobQueue {
    private final List queue = new ArrayList();
    private boolean shutdown = false;
    private int limitJob;

    public TransportJobQueue(int n) {
        this.limitJob = n;
    }

    public final synchronized void shutdown() {
        this.shutdown = true;
        super.notifyAll();
    }

    public final synchronized int size() {
        return this.queue.size();
    }

    public final synchronized void put(TransportJob transportJob) {
        if (this.shutdown) {
            throw new TransportQueueShutdownException("Can't put, queue is already shutdown");
        }
        if (this.limitJob > 0 && this.limitJob < this.size() + 1) {
            throw new TransportQueueLimitException(new StringBuffer().append("Job limit exceeded: ").append(this.limitJob).toString());
        }
        this.queue.add(transportJob);
        super.notifyAll();
    }

    public final synchronized TransportJob get() {
        while (this.queue.size() == 0) {
            if (this.shutdown) {
                throw new TransportQueueShutdownException("Can't get, queue is already shutdown");
            }
            super.wait();
        }
        TransportJob transportJob = (TransportJob)this.queue.remove(0);
        return transportJob;
    }

    public final synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}

