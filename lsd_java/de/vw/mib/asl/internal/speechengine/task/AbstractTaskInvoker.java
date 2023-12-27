/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.asl.internal.speechengine.task.MultiTask;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.asl.internal.speechengine.task.TaskListener;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractTaskInvoker
implements TaskInvoker,
TaskListener {
    protected String name;
    protected Logger logger;
    protected String tracePrefix;
    protected final int traceClassifier;
    private LinkedList taskList;
    private Task runningTask;
    private TaskInvokerListener invokerListener;
    private boolean invokeWasTriggered;
    private boolean wasHalted;
    private boolean isLocked;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("taskstatus: [runningTask=");
        stringBuffer.append(this.runningTask);
        stringBuffer.append(", taskList=");
        stringBuffer.append(this.taskList);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public AbstractTaskInvoker(int n, Logger logger, String string) {
        this.traceClassifier = n;
        this.logger = logger;
        this.invokeWasTriggered = false;
        this.wasHalted = false;
        this.isLocked = false;
        this.name = string;
        this.tracePrefix = new StringBuffer().append("[TaskInvoker]: '").append(string).append("' ").toString();
    }

    protected TaskInvokerListener getInvokerListener() {
        return this.invokerListener;
    }

    protected void clearCurrentTask() {
        if (this.runningTask != null) {
            this.runningTask.removeListener(this);
            this.runningTask.terminate();
            this.runningTask = null;
        } else if (this.logger.isTraceEnabled(this.traceClassifier)) {
            LogMessage logMessage = this.logger.trace(this.traceClassifier);
            logMessage.append(this.tracePrefix);
            logMessage.append("Calling: clearCurrentTask( ) - no task to clear. ");
            logMessage.log();
        }
    }

    public List getAllTasks() {
        return this.taskList;
    }

    public void forkRunningTask(MultiTask multiTask) {
        if (multiTask != null) {
            multiTask.setMasterTask((AbstractTask)this.runningTask, true);
            this.runningTask = multiTask;
            multiTask.execute();
        } else if (this.logger.isTraceEnabled(this.traceClassifier)) {
            LogMessage logMessage = this.logger.trace(this.traceClassifier);
            logMessage.append(this.tracePrefix);
            logMessage.append("Illegal call: forkRunningTask( NULL ) ");
            logMessage.log();
        }
    }

    @Override
    public void invoke() {
        this.invokeWasTriggered = true;
        this.wasHalted = false;
        this.executeNext();
    }

    private void executeNext() {
        if (this.wasHalted) {
            this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("not executing next task - invoking was halted. ").toString());
            return;
        }
        if (this.runningTask != null) {
            this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("executeNext() => executing skipped because still another task is running! ").append(this.toString()).toString());
            return;
        }
        if (this.taskList != null && !this.taskList.isEmpty()) {
            this.runningTask = (Task)this.taskList.removeFirst();
            this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("executeNext() => ").append(this.toString()).toString());
            this.runningTask.execute();
        } else {
            this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("executeNext() => task-list is empty ... stop executing").toString());
            if (this.invokerListener != null) {
                this.invokerListener.invokingStopped(this);
            }
        }
    }

    @Override
    public void halt() {
        this.wasHalted = true;
        this.abortRunningTask();
    }

    @Override
    public void abort() {
        this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("abort all pending tasks (except Task.MASK_END)").toString());
        this.discardPendingTasks(8, false);
        this.abortRunningTask();
    }

    @Override
    public void terminate() {
        this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("terminate tasks").toString());
        if (!this.isIdle()) {
            this.discardPendingTasks(-1, true);
        }
        if (this.isRunning()) {
            this.runningTask.terminate();
        }
    }

    @Override
    public void abort(int n) {
        this.discardPendingTasks(n, true);
    }

    private void abortRunningTask() {
        if (this.isRunning()) {
            this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("abort running task").toString());
            this.runningTask.abort();
        }
    }

    @Override
    public Task getRunningTask() {
        return this.runningTask;
    }

    private void discardPendingTasks(int n, boolean bl) {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.taskList.iterator();
        while (iterator.hasNext()) {
            Task task = (Task)iterator.next();
            if ((!task.matchMask(n) || !bl) && (bl || task.matchMask(n))) continue;
            task.terminate();
            arrayList.add(task);
        }
        this.taskList.removeAll(arrayList);
        if (this.runningTask != null && this.runningTask.matchMask(n)) {
            this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("abort running task").toString());
            this.runningTask.abort();
        }
    }

    @Override
    public void add(Task task) {
        if (task == null) {
            this.logger.warn(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("added invalid task (task was null)!").toString());
            return;
        }
        if (this.isLocked) {
            StringBuffer stringBuffer = new StringBuffer(this.tracePrefix);
            stringBuffer.append("Rejecting added task \"");
            stringBuffer.append(task.toString());
            stringBuffer.append("\" because invoker is locked.");
            this.logger.warn(this.traceClassifier, stringBuffer.toString());
            return;
        }
        boolean bl = this.isIdle();
        if (this.taskList == null) {
            this.taskList = new LinkedList();
        }
        task.addListener(this);
        this.taskList.add(task);
        if (this.logger.isTraceEnabled(this.traceClassifier)) {
            StringBuffer stringBuffer = new StringBuffer(this.tracePrefix);
            stringBuffer.append("added task: ");
            stringBuffer.append(task.toString());
            stringBuffer.append(" ==> ");
            stringBuffer.append(this.toString());
            this.logger.trace(this.traceClassifier, stringBuffer.toString());
        }
        if (bl && this.invokeWasTriggered) {
            this.executeNext();
        }
    }

    @Override
    public void lock() {
        this.isLocked = true;
    }

    @Override
    public void unlock() {
        this.isLocked = false;
    }

    @Override
    public boolean isIdle() {
        return (this.taskList == null || this.taskList.isEmpty()) && this.runningTask == null;
    }

    @Override
    public boolean isRunning() {
        return this.runningTask != null;
    }

    @Override
    public void setInvokerListener(TaskInvokerListener taskInvokerListener) {
        this.invokerListener = taskInvokerListener;
    }

    @Override
    public void taskFinishedSuccessful(Task task) {
        this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("task finished SUCCESSFUL: ").append(task.toString()).toString());
        this.clearCurrentTask();
        this.executeNext();
    }

    @Override
    public abstract void taskFinishedFlawed(Task task) {
    }

    @Override
    public void taskFinishedAborted(Task task) {
        this.logger.trace(this.traceClassifier, new StringBuffer().append(this.tracePrefix).append("task finished ABORTED: ").append(task.toString()).toString());
        this.clearCurrentTask();
        this.executeNext();
    }
}

