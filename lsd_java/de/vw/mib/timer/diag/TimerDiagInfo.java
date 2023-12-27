/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.diag;

import de.vw.mib.timer.Invoker;

public interface TimerDiagInfo {
    default public String getName() {
    }

    default public int getId() {
    }

    default public long getDelay() {
    }

    default public Invoker getInvoker() {
    }

    default public Runnable getRunnable() {
    }

    default public boolean isRepeat() {
    }
}

