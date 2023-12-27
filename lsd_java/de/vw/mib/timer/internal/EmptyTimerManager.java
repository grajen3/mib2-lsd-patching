/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.timer.internal.EmptyTimer;

public class EmptyTimerManager
implements TimerManager {
    private final Timer timer = new EmptyTimer();

    @Override
    public Timer createTimer(String string) {
        return this.timer;
    }

    @Override
    public Timer createTimer(String string, long l, boolean bl, Runnable runnable, Invoker invoker) {
        return this.timer;
    }

    @Override
    public long getSystemTime() {
        return 0L;
    }

    @Override
    public long getSystemTimeFrequency() {
        return 0L;
    }

    @Override
    public long getSystemTimeMicros() {
        return 0L;
    }

    @Override
    public long getSystemTimeMillis() {
        return 0L;
    }
}

