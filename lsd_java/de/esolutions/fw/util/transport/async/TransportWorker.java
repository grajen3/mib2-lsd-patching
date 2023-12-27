/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.async;

import de.esolutions.fw.util.transport.async.TransportJob;
import de.esolutions.fw.util.transport.async.TransportJobQueue;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.exception.TransportQueueShutdownException;

public class TransportWorker
implements Runnable {
    private TransportJobQueue queue;
    private boolean stayInRunLoop = false;
    private int startCounter = 0;
    private final int priority;
    private final String name;
    private Thread thread;
    private int queueLimitJobs;

    public TransportWorker(String string, int n, int n2) {
        this.name = string;
        this.priority = n;
        this.stayInRunLoop = false;
        this.startCounter = 0;
        this.queueLimitJobs = n2;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public TransportWorker(String string) {
        this(string, 5, 0);
    }

    public synchronized void start() {
        ++this.startCounter;
        if (this.startCounter == 1) {
            this.stayInRunLoop = true;
            this.queue = new TransportJobQueue(this.queueLimitJobs);
            this.thread = new Thread(this);
            this.thread.setName(this.name);
            this.thread.setPriority(this.priority);
            this.thread.start();
        }
    }

    public synchronized void shutdown() {
        if (this.startCounter == 1) {
            this.queue.shutdown();
            try {
                this.thread.join();
                this.thread = null;
                this.queue = null;
                this.startCounter = 0;
            }
            catch (InterruptedException interruptedException) {}
        } else if (this.startCounter > 1) {
            --this.startCounter;
        }
    }

    public boolean isInRunLoop() {
        return this.stayInRunLoop;
    }

    public synchronized int getStartCounter() {
        return this.startCounter;
    }

    public synchronized void addJob(TransportJob transportJob) {
        if (this.queue == null) {
            throw new TransportException("Queue not available");
        }
        this.queue.put(transportJob);
    }

    @Override
    public void run() {
        while (this.stayInRunLoop) {
            try {
                TransportJob transportJob = this.queue.get();
                boolean bl = transportJob.doTransport();
                if (bl) continue;
                this.stayInRunLoop = false;
            }
            catch (InterruptedException interruptedException) {
            }
            catch (TransportQueueShutdownException transportQueueShutdownException) {
                this.stayInRunLoop = false;
            }
        }
    }
}

