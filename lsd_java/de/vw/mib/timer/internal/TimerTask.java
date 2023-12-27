/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.defaultimpl.AbstractPooledObject;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.diag.TimerDiagInfo;

final class TimerTask
extends AbstractPooledObject
implements Loggable,
TimerDiagInfo {
    private long delay;
    private int errorCount;
    private int forkBranchId = -1;
    private Invoker invoker;
    private long lastActivationTime;
    private TimerTask next;
    private long nextActivationTime;
    private TimerTask prev;
    private boolean repeat;
    private Runnable runnable;
    private int timerId;
    private String timerName;

    TimerTask(ObjectPool objectPool) {
        super(objectPool);
    }

    @Override
    public long getDelay() {
        return this.delay;
    }

    @Override
    public int getId() {
        return this.timerId;
    }

    @Override
    public Invoker getInvoker() {
        return this.invoker;
    }

    @Override
    public String getName() {
        return this.timerName;
    }

    @Override
    public Runnable getRunnable() {
        return this.runnable;
    }

    @Override
    public boolean isRepeat() {
        return this.repeat;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("TimerTask - name: ").append(this.timerName);
        stringBuffer.append(", id: ").append(this.timerId);
        if (this.errorCount > 0) {
            stringBuffer.append(", errors: ").append(this.errorCount);
        }
        stringBuffer.append(", repeat: ").append(this.repeat);
        stringBuffer.append(", delay: ").append(this.delay);
        stringBuffer.append(", runnable: ").append(this.runnable != null ? super.getClass().getName() : "<not set>");
        stringBuffer.append(", invoker: ").append(this.invoker != null ? super.getClass().getName() : "<not set>");
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("TimerTask - name: ").append(this.timerName);
        logMessage.append(", id: ").append(this.timerId);
        if (this.errorCount > 0) {
            logMessage.append(", errors: ").append(this.errorCount);
        }
        logMessage.append(", repeat: ").append(this.repeat);
        logMessage.append(", delay: ").append(this.delay);
        logMessage.append(", runnable: ").append(this.runnable != null ? super.getClass().getName() : "<not set>");
        logMessage.append(", invoker: ").append(this.invoker != null ? super.getClass().getName() : "<not set>");
    }

    int getErrorCount() {
        return this.errorCount;
    }

    int getForkBranchId() {
        return this.forkBranchId;
    }

    long getLastActivationTime() {
        return this.lastActivationTime;
    }

    long getNextActivationTime() {
        return this.nextActivationTime;
    }

    TimerTask getNextTask() {
        return this.next;
    }

    TimerTask getPrevTask() {
        return this.prev;
    }

    int getTimerId() {
        return this.timerId;
    }

    String getTimerName() {
        return this.timerName;
    }

    void increaseErrorCount() {
        ++this.errorCount;
    }

    boolean isOlderThan(TimerTask timerTask) {
        if (timerTask == null) {
            return false;
        }
        return this.nextActivationTime > timerTask.nextActivationTime;
    }

    void resetErrorCount() {
        this.errorCount = 0;
    }

    void setDelay(long l) {
        this.delay = l;
    }

    void setForkBranchId(int n) {
        this.forkBranchId = n;
    }

    void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }

    void setLastActivationTime(long l) {
        this.lastActivationTime = l;
    }

    void setNextActivationTime(long l) {
        this.nextActivationTime = l;
    }

    void setNextTask(TimerTask timerTask) {
        this.next = timerTask;
    }

    void setPrevTask(TimerTask timerTask) {
        this.prev = timerTask;
    }

    void setRepeat(boolean bl) {
        this.repeat = bl;
    }

    void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    void setTimerId(int n) {
        this.timerId = n;
    }

    void setTimerName(String string) {
        this.timerName = string;
    }
}

