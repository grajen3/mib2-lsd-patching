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

final class UpdateTaskRequest
extends AbstractPooledObject
implements Loggable,
TimerDiagInfo {
    static final int UPDATE_DELAY;
    static final int UPDATE_REPEAT;
    static final int UPDATE_RUNNABLE_AND_INVOKER;
    static final int START;
    static final int STOP;
    static final int SUSPEND;
    static final int RESUME;
    private long delay;
    private int forkBranchId;
    private boolean fromNow;
    private int id;
    private Invoker invoker;
    private String name;
    private long now;
    private boolean repeat;
    private Runnable runnable;
    private int updateType;

    UpdateTaskRequest(ObjectPool objectPool) {
        super(objectPool);
    }

    @Override
    public void backToPool() {
        this.name = null;
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
    public boolean isRepeat() {
        return this.repeat;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("UpdateTaskRequest - timerName: ").append(this.name);
        stringBuffer.append(", id: ").append(this.id);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("UpdateTaskRequest - timerName: ").append(this.name);
        logMessage.append(", id: ").append(this.id);
        switch (this.updateType) {
            case 0: {
                logMessage.append(" - UPDATE_DELAY: ").append(this.delay);
                break;
            }
            case 1: {
                logMessage.append(" - UPDATE_REPEAT: ").append(this.repeat);
                break;
            }
            case 2: {
                logMessage.append(" - UPDATE_RUNNABLE_AND_INVOKER: ").append(this.runnable).append(" @ ").append(this.invoker);
                break;
            }
            case 3: {
                logMessage.append(" - START");
                break;
            }
            case 4: {
                logMessage.append(" - STOP");
                break;
            }
            case 5: {
                logMessage.append(" - SUSPEND");
                break;
            }
            case 6: {
                logMessage.append(" - RESUME");
                break;
            }
        }
    }

    int getForkBranchId() {
        return this.forkBranchId;
    }

    long getNow() {
        return this.now;
    }

    int getUpdateType() {
        return this.updateType;
    }

    void init(int n, int n2, String string, long l, boolean bl, Runnable runnable, Invoker invoker) {
        this.updateType = n;
        this.id = n2;
        this.name = string;
        this.delay = l;
        this.repeat = bl;
        this.runnable = runnable;
        this.invoker = invoker;
    }

    boolean isFromNow() {
        return this.fromNow;
    }

    void setForkBranchId(int n) {
        this.forkBranchId = n;
    }

    void setFromNow(boolean bl) {
        this.fromNow = bl;
    }

    void setNow(long l) {
        this.now = l;
    }
}

