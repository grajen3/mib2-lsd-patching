/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.remote.AbstractRemoteBackend;

public class SyncMarkerSender
implements Runnable {
    private final AbstractRemoteBackend backend;
    private Thread thread;
    private boolean doRun;
    private int interval = 2000;

    public SyncMarkerSender(AbstractRemoteBackend abstractRemoteBackend) {
        this.backend = abstractRemoteBackend;
    }

    public void setInterval(int n) {
        this.interval = n;
    }

    public void start() {
        if (this.thread == null) {
            this.thread = new Thread(this, "SyncMarkerSender");
            this.thread.start();
            this.doRun = true;
        }
    }

    public void stop() {
        if (this.thread != null) {
            this.doRun = false;
            this.thread.interrupt();
            try {
                this.thread.join();
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }
    }

    @Override
    public void run() {
        while (this.doRun) {
            try {
                Thread.sleep(this.interval);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
            this.backend.sendSyncMarker();
        }
    }
}

