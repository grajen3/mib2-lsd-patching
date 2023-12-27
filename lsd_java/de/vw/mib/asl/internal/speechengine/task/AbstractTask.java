/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.asl.internal.speechengine.task.TaskListener;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTask
implements Task {
    protected ArrayList taskListener;
    protected boolean isAborted = false;
    protected Logger taskLogger;

    public AbstractTask(Logger logger) {
        this.taskLogger = logger;
    }

    protected void notifyFinishedFlawed() {
        if (this.taskListener != null) {
            for (int i2 = 0; i2 < this.taskListener.size(); ++i2) {
                TaskListener taskListener = (TaskListener)this.taskListener.get(i2);
                taskListener.taskFinishedFlawed(this);
            }
        }
    }

    protected void notifyFinishedSuccessful() {
        if (this.taskListener != null) {
            for (int i2 = 0; i2 < this.taskListener.size(); ++i2) {
                TaskListener taskListener = (TaskListener)this.taskListener.get(i2);
                taskListener.taskFinishedSuccessful(this);
            }
        }
    }

    protected void notifyFinishedAborted() {
        if (this.taskListener != null) {
            for (int i2 = 0; i2 < this.taskListener.size(); ++i2) {
                TaskListener taskListener = (TaskListener)this.taskListener.get(i2);
                taskListener.taskFinishedAborted(this);
            }
        }
    }

    @Override
    public void addListener(TaskListener taskListener) {
        if (taskListener != null) {
            if (this.taskListener == null) {
                this.taskListener = new ArrayList(1);
            }
            this.taskListener.add(taskListener);
        }
    }

    @Override
    public void removeListener(TaskListener taskListener) {
        if (taskListener != null && this.taskListener != null) {
            this.taskListener.remove(taskListener);
        }
    }

    public List getListeners() {
        return (List)this.taskListener.clone();
    }

    @Override
    public final boolean matchMask(int n) {
        return (this.getMask() & n) != 0;
    }

    protected int getMask() {
        return 0;
    }

    public String toString() {
        return this.getSimpleName();
    }

    private String getSimpleName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n >= 0) {
            return string.substring(n + 1, string.length());
        }
        return "";
    }
}

