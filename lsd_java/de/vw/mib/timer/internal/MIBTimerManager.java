/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBThread;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerException;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.timer.internal.MIBTimer;
import de.vw.mib.timer.internal.MIBTimerThread;
import de.vw.mib.timer.internal.ServiceManager;
import de.vw.mib.timer.internal.TimerTaskFactory;

final class MIBTimerManager
implements TimerManager {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(512);
    private static final int TASK_POOL_SIZE;
    private static final long MINIMUM_FREQUENCY;
    private static final double MICRO;
    private static final double MILLI;
    private final double cycleFactor_micros;
    private final double cycleFactor_millis;
    private final long systemTimeFreq = ServiceManager.timerSPI.getSystemTimeFrequency();
    private final MIBTimerThread timerThread;
    private MIBThread thread;
    private int timerIdCounter;

    MIBTimerManager() {
        this.cycleFactor_micros = 1000000.0 / (double)this.systemTimeFreq;
        this.cycleFactor_millis = 1000.0 / (double)this.systemTimeFreq;
        logger.normal(4).append("Timer clock frequency ").append(this.systemTimeFreq).append("Hz").log();
        if (this.systemTimeFreq < 0) {
            logger.warn(4).append("Timer clock frequency does not meet required minimum precision (").append((long)0).append("Hz)").log();
        }
        this.timerThread = new MIBTimerThread(this, new TimerTaskFactory(20));
        this.thread = ServiceManager.threadManager.createThread(0, this.timerThread);
    }

    @Override
    public Timer createTimer(String string) {
        return new MIBTimer(string, this.generateTimerId(), this.timerThread, this);
    }

    @Override
    public Timer createTimer(String string, long l, boolean bl, Runnable runnable, Invoker invoker) {
        if (l < 0L) {
            throw new TimerException("timer delay must not be negative");
        }
        MIBTimer mIBTimer = new MIBTimer(string, this.generateTimerId(), this.timerThread, this);
        mIBTimer.setDelay(l);
        mIBTimer.setRepeat(bl);
        mIBTimer.setRunnable(runnable, invoker);
        return mIBTimer;
    }

    @Override
    public long getSystemTime() {
        return ServiceManager.timerSPI.getSystemTime();
    }

    @Override
    public long getSystemTimeFrequency() {
        return this.systemTimeFreq;
    }

    @Override
    public long getSystemTimeMicros() {
        return (long)((double)ServiceManager.timerSPI.getSystemTime() * this.cycleFactor_micros);
    }

    @Override
    public long getSystemTimeMillis() {
        return (long)((double)ServiceManager.timerSPI.getSystemTime() * this.cycleFactor_millis);
    }

    private synchronized int generateTimerId() {
        ++this.timerIdCounter;
        if (this.timerIdCounter == 0) {
            throw new TimerException("Timer ID overflow");
        }
        return this.timerIdCounter;
    }

    void shutdownService() {
        logger.warn(2, "Stopping timer thread! The TimerManager becomes unusable!");
        this.timerThread.killThread();
    }

    void startTimerThread() {
        this.thread.start();
        logger.trace(2, "Timer thread started!");
    }
}

