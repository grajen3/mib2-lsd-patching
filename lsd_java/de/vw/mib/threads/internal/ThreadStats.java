/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

final class ThreadStats {
    private int numberOfChecks;
    private int numberOfErrors;
    private int numberOfRestarts;
    private boolean started;
    private boolean stopped;

    ThreadStats() {
    }

    void check() {
        ++this.numberOfChecks;
    }

    void error() {
        ++this.numberOfErrors;
    }

    int getNumberOfChecks() {
        return this.numberOfChecks;
    }

    int getNumberOfErrors() {
        return this.numberOfErrors;
    }

    int getNumberOfRestarts() {
        return this.numberOfRestarts;
    }

    boolean isStarted() {
        return this.started;
    }

    boolean isStopped() {
        return this.stopped;
    }

    void restart() {
        ++this.numberOfRestarts;
    }

    void start() {
        this.started = true;
    }

    void stop() {
        this.stopped = true;
    }
}

