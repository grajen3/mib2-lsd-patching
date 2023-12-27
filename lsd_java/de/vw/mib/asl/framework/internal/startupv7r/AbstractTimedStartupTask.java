/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.AbstractTimedStartupTask$1;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public abstract class AbstractTimedStartupTask
extends AbstractStartupTask {
    static final String TIMER_NAME;
    private final TimerManager timerManager;
    private final Invoker invoker;
    private Timer timer;

    public AbstractTimedStartupTask(Logger logger, TimerManager timerManager, Invoker invoker) {
        super(logger);
        this.timerManager = timerManager;
        this.invoker = invoker;
    }

    protected abstract long getTimeout() {
    }

    @Override
    protected void prepare() {
        this.timer = this.timerManager.createTimer("AbstractTimedStartupTask Timer", this.getTimeout(), false, new AbstractTimedStartupTask$1(this), this.invoker);
        this.timer.start();
    }

    @Override
    protected void cleanUp() {
        if (this.timer.isStarted()) {
            this.timer.stop();
        }
    }

    protected void handleTimeout() {
    }
}

