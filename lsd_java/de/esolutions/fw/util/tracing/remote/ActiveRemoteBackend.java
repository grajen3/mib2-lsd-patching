/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.remote.AbstractRemoteBackend;

public abstract class ActiveRemoteBackend
extends AbstractRemoteBackend
implements Runnable {
    private Thread thread;
    protected boolean doRun;

    public ActiveRemoteBackend(String string) {
        super(string);
    }

    public void startWorker() {
        if (this.thread == null) {
            this.thread = new Thread(this, "TraceRemote");
            this.doRun = true;
            this.thread.start();
        }
    }

    public void stopWorker() {
        if (this.thread != null) {
            this.doRun = false;
            this.remoteDisconnect();
            this.thread.interrupt();
            try {
                this.thread.join();
            }
            catch (InterruptedException interruptedException) {
                this.listener.logMessage(this.bid, "waiting for remote worker interrupted");
            }
        }
        super.exit();
    }

    @Override
    public void run() {
        if (!this.doInit()) {
            return;
        }
        this.listener.logMessage(this.bid, "worker thread started");
        while (this.doRun) {
            try {
                if (this.doWork()) continue;
                break;
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
                break;
            }
        }
        this.listener.logMessage(this.bid, "worker thread stopped");
        this.doExit();
    }

    protected abstract boolean doInit() {
    }

    protected abstract boolean doWork() {
    }

    protected abstract void doExit() {
    }
}

