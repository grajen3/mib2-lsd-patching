/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads;

import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;

public interface MIBThreadManager {
    default public MIBThread createThread(int n, MIBRunnable mIBRunnable) {
    }

    default public Thread createThread(int n, Runnable runnable) {
    }

    default public void dump() {
    }
}

