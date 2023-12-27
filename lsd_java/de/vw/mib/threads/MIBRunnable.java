/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads;

import de.vw.mib.threads.MIBThread;

public interface MIBRunnable {
    default public void operate() {
    }

    default public void setThread(MIBThread mIBThread) {
    }

    default public void threadDeathDetected() {
    }

    default public void timeoutDetected() {
    }
}

