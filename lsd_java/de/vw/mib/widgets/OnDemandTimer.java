/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.internal.EmptyTimer;
import de.vw.mib.widgets.internal.ServiceManager;

public final class OnDemandTimer
extends EmptyTimer {
    protected static Logger LOGGER;
    private String name;
    private long delay;
    private boolean repeat;
    private Runnable runnable;
    private Timer innerTimer;
    private Invoker invoker;

    private OnDemandTimer(String string, int n, boolean bl, Runnable runnable, Invoker invoker) {
        this.name = string;
        this.delay = n;
        this.repeat = bl;
        this.runnable = runnable;
        this.invoker = invoker;
        if (null == LOGGER) {
            LOGGER = ServiceManager.loggerFactory.getLogger(2048);
        }
    }

    public static Timer createTimer(String string, int n) {
        return OnDemandTimer.createTimer(string, n, false);
    }

    public static Timer createTimer(String string, int n, boolean bl) {
        return OnDemandTimer.createTimer(string, n, bl, null, null);
    }

    public static Timer createTimer(String string, int n, boolean bl, Runnable runnable, Invoker invoker) {
        return new OnDemandTimer(string, n, bl, runnable, invoker);
    }

    private Timer getInnerTimer() {
        return this.innerTimer;
    }

    private void createInnerTimer() {
        this.innerTimer = ServiceManager.timerManager.createTimer(this.name);
        this.innerTimer.setDelay(this.delay);
        this.innerTimer.setRepeat(this.repeat);
        this.innerTimer.setRunnable(this.runnable, this.invoker);
    }

    @Override
    public void extendDelay(long l) {
        this.getInnerTimer().extendDelay(l);
    }

    @Override
    public long getDelay() {
        if (this.getInnerTimer() != null) {
            return this.getInnerTimer().getDelay();
        }
        return this.delay;
    }

    @Override
    public int getId() {
        return this.getInnerTimer().getId();
    }

    @Override
    public Invoker getInvoker() {
        if (this.getInnerTimer() != null) {
            return this.getInnerTimer().getInvoker();
        }
        return this.invoker;
    }

    @Override
    public String getName() {
        if (this.getInnerTimer() != null) {
            return this.getInnerTimer().getName();
        }
        return this.name;
    }

    @Override
    public Runnable getRunnable() {
        if (this.getInnerTimer() != null) {
            return this.getInnerTimer().getRunnable();
        }
        return this.runnable;
    }

    @Override
    public long getSystemTimeMicros() {
        return this.getInnerTimer().getSystemTimeMicros();
    }

    @Override
    public long getSystemTimeMillis() {
        return this.getInnerTimer().getSystemTimeMillis();
    }

    @Override
    public boolean isRepeat() {
        return this.getInnerTimer().isRepeat();
    }

    @Override
    public boolean isStarted() {
        if (this.getInnerTimer() != null) {
            return this.getInnerTimer().isStarted();
        }
        return false;
    }

    @Override
    public boolean isSuspended() {
        return this.getInnerTimer().isSuspended();
    }

    @Override
    public void resume() {
        this.getInnerTimer().resume();
    }

    @Override
    public void setDelay(long l) {
        if (this.getInnerTimer() != null) {
            this.getInnerTimer().setDelay(l);
        }
        this.delay = l;
    }

    @Override
    public void setDelayFromNow(long l) {
        this.getInnerTimer().setDelayFromNow(l);
    }

    @Override
    public void setName(String string) {
        this.getInnerTimer().setName(string);
    }

    @Override
    public void setRepeat(boolean bl) {
        if (this.getInnerTimer() != null) {
            this.getInnerTimer().setRepeat(bl);
        }
        this.repeat = bl;
    }

    @Override
    public void setRunnable(Runnable runnable, Invoker invoker) {
        if (this.getInnerTimer() != null) {
            this.getInnerTimer().setRunnable(runnable, invoker);
        }
        this.runnable = runnable;
        this.invoker = invoker;
    }

    @Override
    public void start() {
        if (this.getInnerTimer() == null) {
            this.createInnerTimer();
        }
        this.getInnerTimer().start();
    }

    @Override
    public void start(Runnable runnable) {
        if (this.getInnerTimer() == null) {
            this.createInnerTimer();
        }
        this.getInnerTimer().start(runnable);
    }

    @Override
    public void stop() {
        if (this.getInnerTimer() != null) {
            this.getInnerTimer().stop();
        } else if (LOGGER.isTraceEnabled(1)) {
            LOGGER.trace(1, new StringBuffer().append("OnDemandTimer.stop() (").append(this.name).append("): Timer has been stopped without beeing started!").toString());
        }
    }

    @Override
    public void suspend() {
        this.getInnerTimer().suspend();
    }
}

