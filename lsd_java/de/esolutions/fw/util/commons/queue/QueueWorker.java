/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.queue;

import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.queue.Queue;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;

public abstract class QueueWorker
implements Runnable {
    private final Queue queue;
    private final String name;
    private final IRunnableWrapper runnableWrapper;
    private Thread thread;

    public QueueWorker(String string, int n, IRunnableWrapper iRunnableWrapper) {
        this.name = string;
        this.queue = new Queue(n);
        this.runnableWrapper = iRunnableWrapper;
    }

    public QueueWorker(String string, int n) {
        this(string, n, null);
    }

    public void start(int n) {
        if (this.thread != null) {
            return;
        }
        Runnable runnable = null;
        if (this.runnableWrapper != null) {
            runnable = this.runnableWrapper.wrap(this);
        }
        if (runnable == null) {
            runnable = this;
        }
        this.thread = new Thread(runnable, this.name);
        this.thread.setPriority(n);
        this.thread.start();
    }

    public void stop() {
        if (this.thread == null) {
            return;
        }
        this.queue.shutdown();
        try {
            this.thread.join();
            this.thread = null;
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    public boolean isRunning() {
        return this.thread != null;
    }

    protected boolean addToQueue(Object object) {
        return this.queue.put(object);
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (true) {
                    Object object = this.queue.get();
                    this.handleQueuedObject(object);
                }
            }
            catch (QueueShutdownException queueShutdownException) {
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            break;
        }
    }

    protected abstract void handleQueuedObject(Object object) {
    }

    public int queueSize() {
        return this.queue.size();
    }
}

