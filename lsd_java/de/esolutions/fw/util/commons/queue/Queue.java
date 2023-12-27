/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.queue;

import de.esolutions.fw.util.commons.queue.MyQueue;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;

public final class Queue {
    private final MyQueue queue = new MyQueue();
    private final int highWaterMark;
    private boolean shutdown;
    private boolean inHighWater;

    public Queue(int n) {
        this.highWaterMark = n;
        this.shutdown = false;
        this.inHighWater = false;
    }

    public synchronized void shutdown() {
        this.shutdown = true;
        super.notifyAll();
    }

    public synchronized boolean inHighWater() {
        return this.inHighWater;
    }

    public synchronized int size() {
        return this.queue.size();
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public synchronized boolean put(Object object) {
        if (this.shutdown) {
            throw new QueueShutdownException("Can't put, queue is already shutdown");
        }
        this.queue.push(object);
        super.notifyAll();
        if (this.queue.size() >= this.highWaterMark) {
            this.inHighWater = true;
        }
        return this.inHighWater;
    }

    public synchronized Object get() {
        while (this.queue.isEmpty()) {
            if (this.shutdown) {
                throw new QueueShutdownException("Can't get, queue is already shutdown");
            }
            super.wait();
        }
        Object object = this.queue.pop();
        if (this.queue.size() < this.highWaterMark) {
            this.inHighWater = false;
        }
        return object;
    }

    public synchronized void dump() {
        this.queue.dump();
    }
}

