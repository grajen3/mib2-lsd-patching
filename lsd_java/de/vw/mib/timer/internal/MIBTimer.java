/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerException;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.timer.diag.TimerDiagInfo;
import de.vw.mib.timer.internal.MIBTimerThread;
import de.vw.mib.timer.internal.ServiceManager;
import de.vw.mib.timer.internal.UpdateTaskRequest;
import de.vw.mib.timer.internal.UpdateTaskRequestFactory;

final class MIBTimer
implements Loggable,
Timer,
TimerDiagInfo {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(512);
    private static long MINIMUM_DELAY = Long.getLong("de.vw.mib.timer.warn.minimumdelay", 0);
    private static UpdateTaskRequestFactory updateRequestFactory = new UpdateTaskRequestFactory();
    private long delay;
    private final int id;
    private Invoker invoker;
    private boolean isStarted;
    private boolean isSuspended;
    private String name;
    private boolean repeat;
    private Runnable runnable;
    private final TimerManager timerManager;
    private final MIBTimerThread timerThread;

    MIBTimer(String string, int n, MIBTimerThread mIBTimerThread, TimerManager timerManager) {
        this.id = n;
        this.timerThread = mIBTimerThread;
        this.timerManager = timerManager;
        this.name = string;
        ServiceManager.timerDiag.createTimer(this);
    }

    @Override
    public void extendDelay(long l) {
        if (l < 0L) {
            throw new TimerException("timer delay must not be negative");
        }
        this.delay += l;
        if (this.isStarted) {
            this.fireUpdateDelayRequest(-1L, false);
        }
    }

    @Override
    public long getDelay() {
        return this.delay;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Invoker getInvoker() {
        return this.invoker;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Runnable getRunnable() {
        return this.runnable;
    }

    @Override
    public long getSystemTimeMicros() {
        return this.timerManager.getSystemTimeMicros();
    }

    @Override
    public long getSystemTimeMillis() {
        return this.timerManager.getSystemTimeMillis();
    }

    @Override
    public boolean isRepeat() {
        return this.repeat;
    }

    @Override
    public boolean isRunning() {
        return this.timerThread.isRunning(this);
    }

    @Override
    public boolean isStarted() {
        return this.isStarted;
    }

    @Override
    public boolean isSuspended() {
        return this.isSuspended;
    }

    @Override
    public void resume() {
        this.isStarted = true;
        this.isSuspended = false;
        long l = this.getSystemTimeMillis();
        UpdateTaskRequest updateTaskRequest = updateRequestFactory.getUpdateTaskRequest(6, this.id, this.name, this.delay, this.repeat, this.runnable, this.invoker);
        updateTaskRequest.setNow(l);
        this.timerThread.updateTask(updateTaskRequest);
    }

    @Override
    public void setDelay(long l) {
        if (l < 0L) {
            throw new TimerException("timer delay must not be negative");
        }
        this.delay = l;
        if (this.isStarted) {
            this.fireUpdateDelayRequest(-1L, false);
        }
    }

    @Override
    public void setDelayFromNow(long l) {
        if (l < 0L) {
            throw new TimerException("timer delay must not be negative");
        }
        if (!this.isStarted) {
            throw new TimerException("setDelayFromNow called for stopped timer");
        }
        long l2 = this.getSystemTimeMillis();
        this.delay = l;
        this.fireUpdateDelayRequest(l2, true);
    }

    @Override
    public void setName(String string) {
        this.name = string;
    }

    @Override
    public void setRepeat(boolean bl) {
        this.repeat = bl;
        if (this.isStarted) {
            UpdateTaskRequest updateTaskRequest = updateRequestFactory.getUpdateTaskRequest(1, this.id, this.name, this.delay, bl, this.runnable, this.invoker);
            this.timerThread.updateTask(updateTaskRequest);
        }
    }

    @Override
    public void setRunnable(Runnable runnable, Invoker invoker) {
        if (runnable == null || invoker == null) {
            throw new TimerException("runnable and invoker must not be null");
        }
        this.runnable = runnable;
        this.invoker = invoker;
        if (this.isStarted) {
            UpdateTaskRequest updateTaskRequest = updateRequestFactory.getUpdateTaskRequest(2, this.id, this.name, this.delay, this.repeat, runnable, invoker);
            this.timerThread.updateTask(updateTaskRequest);
        }
    }

    @Override
    public synchronized void start() {
        if (this.delay < MINIMUM_DELAY) {
            logger.error(1).append("The timer '").append(this.getName()).append("' was started with a very short delay! Delay: ").append(this.delay).append("ms").attachThrowable(new Exception("Timer with very short delay started!")).log();
        }
        if (logger.isTraceEnabled(1)) {
            logger.trace(1).append("Start ").append(this).log();
        }
        this.isStarted = true;
        this.isSuspended = false;
        long l = this.getSystemTimeMillis();
        UpdateTaskRequest updateTaskRequest = updateRequestFactory.getUpdateTaskRequest(3, this.id, this.name, this.delay, this.repeat, this.runnable, this.invoker);
        updateTaskRequest.setNow(l);
        this.timerThread.updateTask(updateTaskRequest);
    }

    @Override
    public void start(Runnable runnable) {
        this.runnable = runnable;
        this.start();
    }

    @Override
    public synchronized void stop() {
        if (logger.isTraceEnabled(1)) {
            logger.trace(1).append("Stop ").append(this).log();
        }
        if (!this.isStarted) {
            return;
        }
        this.isStarted = false;
        this.isSuspended = false;
        this.timerThread.updateTask(updateRequestFactory.getUpdateTaskRequest(4, this.id, this.name, this.delay, this.repeat, this.runnable, this.invoker));
    }

    @Override
    public void suspend() {
        if (!this.isStarted || this.isSuspended) {
            return;
        }
        this.isSuspended = true;
        UpdateTaskRequest updateTaskRequest = updateRequestFactory.getUpdateTaskRequest(5, this.id, this.name, this.delay, this.repeat, this.runnable, this.invoker);
        updateTaskRequest.setNow(this.getSystemTimeMillis());
        this.timerThread.updateTask(updateTaskRequest);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("Timer '").append(this.name).append("' (").append(this.id).append(")");
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("Timer '").append(this.name).append("' (").append(this.id).append(")");
    }

    protected void finalize() {
        super.finalize();
        if (this.isSuspended) {
            logger.warn(1).append("cleanup suspended timer: ").append(this).log();
            this.stop();
        }
    }

    private void fireUpdateDelayRequest(long l, boolean bl) {
        UpdateTaskRequest updateTaskRequest = updateRequestFactory.getUpdateTaskRequest(0, this.id, this.name, this.delay, this.repeat, this.runnable, this.invoker);
        updateTaskRequest.setNow(l);
        updateTaskRequest.setFromNow(bl);
        this.timerThread.updateTask(updateTaskRequest);
    }
}

