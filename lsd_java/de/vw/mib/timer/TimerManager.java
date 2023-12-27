/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer;

import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;

public interface TimerManager {
    default public Timer createTimer(String string) {
    }

    default public Timer createTimer(String string, long l, boolean bl, Runnable runnable, Invoker invoker) {
    }

    default public long getSystemTime() {
    }

    default public long getSystemTimeFrequency() {
    }

    default public long getSystemTimeMicros() {
    }

    default public long getSystemTimeMillis() {
    }
}

