/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads;

public interface MIBThread {
    default public boolean isAlive() {
    }

    default public boolean isInCurrentMIBThread() {
    }

    default public int getId() {
    }

    default public Thread getJavaThread() {
    }

    default public Object getSemaphore() {
    }

    default public void restart() {
    }

    default public void resume() {
    }

    default public void start() {
    }

    default public void stop() {
    }

    default public void suspend() {
    }
}

