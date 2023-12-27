/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer;

import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.internal.TimerThreadInvoker;

public interface Timer {
    public static final Invoker TIMER_THREAD_INVOKER = TimerThreadInvoker.TIMER_THREAD_INVOKER;

    default public void extendDelay(long l) {
    }

    default public long getDelay() {
    }

    default public int getId() {
    }

    default public Invoker getInvoker() {
    }

    default public String getName() {
    }

    default public Runnable getRunnable() {
    }

    default public long getSystemTimeMicros() {
    }

    default public long getSystemTimeMillis() {
    }

    default public boolean isRepeat() {
    }

    default public boolean isRunning() {
    }

    default public boolean isStarted() {
    }

    default public boolean isSuspended() {
    }

    default public void resume() {
    }

    default public void setDelay(long l) {
    }

    default public void setDelayFromNow(long l) {
    }

    default public void setName(String string) {
    }

    default public void setRepeat(boolean bl) {
    }

    default public void setRunnable(Runnable runnable, Invoker invoker) {
    }

    default public void start() {
    }

    default public void start(Runnable runnable) {
    }

    default public void stop() {
    }

    default public void suspend() {
    }
}

