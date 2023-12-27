/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;

public class EmptyTimer
implements Timer {
    @Override
    public void extendDelay(long l) {
    }

    @Override
    public long getDelay() {
        return 0L;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Invoker getInvoker() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Runnable getRunnable() {
        return null;
    }

    @Override
    public long getSystemTimeMicros() {
        return 0L;
    }

    @Override
    public long getSystemTimeMillis() {
        return 0L;
    }

    @Override
    public boolean isRepeat() {
        return false;
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isSuspended() {
        return false;
    }

    @Override
    public void resume() {
    }

    @Override
    public void setDelay(long l) {
    }

    @Override
    public void setDelayFromNow(long l) {
    }

    @Override
    public void setName(String string) {
    }

    @Override
    public void setRepeat(boolean bl) {
    }

    @Override
    public void setRunnable(Runnable runnable, Invoker invoker) {
    }

    @Override
    public void start() {
    }

    @Override
    public void start(Runnable runnable) {
    }

    @Override
    public void stop() {
    }

    @Override
    public void suspend() {
    }
}

