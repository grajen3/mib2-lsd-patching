/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.task;

import de.vw.mib.asl.internal.speechengine.dialogsystem.dialog.task.DefaultDialogTask;
import de.vw.mib.asl.internal.speechengine.task.AbstractTask;
import de.vw.mib.asl.internal.speechengine.task.MultiTask$1;
import de.vw.mib.asl.internal.speechengine.task.MultiTask$2;
import de.vw.mib.asl.internal.speechengine.task.MultiTask$3;
import de.vw.mib.asl.internal.speechengine.task.Task;
import de.vw.mib.asl.internal.speechengine.task.TaskInvoker;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerIgnoringErrors;
import de.vw.mib.asl.internal.speechengine.task.TaskInvokerListener;
import de.vw.mib.asl.internal.speechengine.task.TaskListener;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;
import java.util.List;

public abstract class MultiTask
extends DefaultDialogTask
implements TaskListener,
TaskInvokerListener {
    private static final int TRACE_CLASS;
    private static final String TRACE_PREFIX;
    protected AbstractTask masterTask;
    protected TaskInvoker servantTaskInvoker;
    protected boolean isMasterFinished;
    protected boolean isMasterTaskAlreadyInvoked;
    protected Runnable runFinishResult;

    public MultiTask(Logger logger) {
        super(logger);
        this.servantTaskInvoker = new TaskInvokerIgnoringErrors(8, logger, "MultiTask-Invoker");
        this.servantTaskInvoker.setInvokerListener(this);
        this.isMasterFinished = false;
    }

    protected AbstractTask getMasterTask() {
        if (this.masterTask == null) {
            this.taskLogger.warn(8, "[MultiTask] masterTask is still null. ");
        }
        return this.masterTask;
    }

    public void setMasterTask(AbstractTask abstractTask, boolean bl) {
        this.isMasterTaskAlreadyInvoked = bl;
        this.masterTask = abstractTask;
        List list = this.masterTask.getListeners();
        this.masterTask.addListener(this);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            TaskListener taskListener = (TaskListener)iterator.next();
            this.addListener(taskListener);
            this.masterTask.removeListener(taskListener);
        }
    }

    public void addServantTask(Task task) {
        this.servantTaskInvoker.add(task);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MultiTask [masterTask=");
        stringBuffer.append(this.masterTask);
        stringBuffer.append(", servantTaskInvoker=");
        stringBuffer.append(this.servantTaskInvoker);
        stringBuffer.append(", isMasterFinished=");
        stringBuffer.append(this.isMasterFinished);
        stringBuffer.append(", isMasterTaskAlreadyInvoked=");
        stringBuffer.append(this.isMasterTaskAlreadyInvoked);
        stringBuffer.append(", runFinishResult=");
        stringBuffer.append(this.runFinishResult);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override
    public void execute() {
        if (this.getMasterTask() == null) {
            this.notifyFinishedSuccessful();
        }
        if (!this.isMasterTaskAlreadyInvoked) {
            this.getMasterTask().execute();
        }
        this.servantTaskInvoker.invoke();
    }

    @Override
    public void terminate() {
        this.getMasterTask().terminate();
        this.servantTaskInvoker.terminate();
    }

    @Override
    public void abort() {
        this.getMasterTask().abort();
        this.servantTaskInvoker.abort();
    }

    @Override
    protected int getMask() {
        int n = 0;
        if (this.masterTask != null) {
            n = this.masterTask.getMask();
        }
        return n;
    }

    @Override
    public void onPttBargeIn() {
        ((DefaultDialogTask)this.getMasterTask()).onPttBargeIn();
        DefaultDialogTask defaultDialogTask = (DefaultDialogTask)this.servantTaskInvoker.getRunningTask();
        if (defaultDialogTask != null) {
            defaultDialogTask.onPttBargeIn();
        }
    }

    protected abstract void onFinished() {
    }

    protected void onMasterTaskFinished(Task task) {
        this.isMasterFinished = true;
        if (this.taskLogger.isTraceEnabled(8)) {
            LogMessage logMessage = this.taskLogger.trace(8);
            logMessage.append("[MultiTask] ");
            logMessage.append("Master task finished. ");
            logMessage.append(this.toString());
            logMessage.log();
        }
        this.onFinished();
    }

    protected void notifyFinished() {
        if (this.runFinishResult != null) {
            this.runFinishResult.run();
        }
    }

    @Override
    public void taskFinishedSuccessful(Task task) {
        this.runFinishResult = new MultiTask$1(this);
        this.onMasterTaskFinished(task);
    }

    @Override
    public void taskFinishedFlawed(Task task) {
        this.runFinishResult = new MultiTask$2(this);
        this.onMasterTaskFinished(task);
    }

    @Override
    public void taskFinishedAborted(Task task) {
        this.runFinishResult = new MultiTask$3(this);
        this.onMasterTaskFinished(task);
    }

    @Override
    public void invokingStopped(TaskInvoker taskInvoker) {
        if (this.taskLogger.isTraceEnabled(8)) {
            LogMessage logMessage = this.taskLogger.trace(8);
            logMessage.append("[MultiTask] ");
            logMessage.append("Servant tasks are idle. ");
            logMessage.append(this.toString());
            logMessage.log();
        }
        this.onFinished();
    }
}

