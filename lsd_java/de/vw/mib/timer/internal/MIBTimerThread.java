/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.error.HMIDumpInformationProvider;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.MIBRunnable;
import de.vw.mib.threads.MIBThread;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerException;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.timer.internal.ServiceManager;
import de.vw.mib.timer.internal.TimerTask;
import de.vw.mib.timer.internal.TimerTaskFactory;
import de.vw.mib.timer.internal.TimerTaskList;
import de.vw.mib.timer.internal.UpdateTaskRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class MIBTimerThread
implements MIBRunnable,
HMIDumpInformationProvider {
    private static Logger logger = ServiceManager.loggerFactory.getLogger(512);
    private static final long SLEEPTIME_IDLE_THREAD;
    private static final int MAX_ERRORS_PER_REPEAT_TASK;
    private final TimerTaskList activeTimerTaskList = new TimerTaskList();
    private final TimerTaskList executedRepeatTasks = new TimerTaskList();
    private boolean running = true;
    private final TimerManager timerManager;
    private final IntObjectMap timerTasksMap = new IntObjectOptHashMap();
    private final TimerTaskFactory timerTaskFactory;
    private MIBThread thread;
    private final List updateRequests = new ArrayList();

    MIBTimerThread(TimerManager timerManager, TimerTaskFactory timerTaskFactory) {
        this.timerManager = timerManager;
        this.timerTaskFactory = timerTaskFactory;
        if (ServiceManager.errorHandler != null) {
            ServiceManager.errorHandler.addHMIDumpInformationProvider(this);
        }
    }

    @Override
    public void clearDumpInformation() {
    }

    @Override
    public String[] getDumpInformation() {
        if (this.timerTasksMap.isEmpty()) {
            return new String[]{"<empty>"};
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.timerTasksMap.valueIterator();
        while (iterator.hasNext()) {
            TimerTask timerTask = (TimerTask)iterator.next();
            arrayList.add(new StringBuffer().append(this.activeTimerTaskList.contains(timerTask) ? "ACTIVE " : "SUSPENDED ").append(timerTask.toString()).toString());
        }
        return (String[])arrayList.toArray(new String[0]);
    }

    @Override
    public String getName() {
        return new StringBuffer().append("TimerManager - active timer tasks: ").append(this.activeTimerTaskList.size()).append(", suspended timer tasks: ").append(this.timerTasksMap.size() - this.activeTimerTaskList.size()).toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void operate() {
        try {
            List list = this.updateRequests;
            synchronized (list) {
                if (this.updateRequests.size() == 0) {
                    try {
                        long l = this.calcSleepTime();
                        if (l > 0L) {
                            super.wait(l);
                        }
                    }
                    catch (InterruptedException interruptedException) {
                        // empty catch block
                    }
                }
                if (this.running && this.updateRequests.size() > 0) {
                    this.performUpdates();
                }
            }
            this.executeTimers();
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
        }
    }

    @Override
    public void setThread(MIBThread mIBThread) {
        this.thread = mIBThread;
    }

    @Override
    public void threadDeathDetected() {
        logger.error(2, "thread death detected!");
    }

    @Override
    public void timeoutDetected() {
        logger.error(2, "timeout detected!");
    }

    private long calcSleepTime() {
        if (!this.running) {
            return 0L;
        }
        TimerTask timerTask = this.activeTimerTaskList.getFirst();
        if (timerTask == null) {
            return 0;
        }
        long l = timerTask.getNextActivationTime() - this.timerManager.getSystemTimeMillis();
        return l < 0L ? 0L : l;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void executeTimers() {
        if (!this.running) {
            return;
        }
        TimerTask timerTask = this.activeTimerTaskList.getFirst();
        while (this.running && this.hasToExecute(timerTask)) {
            try {
                InvocationContext.startSpecificInvocation(timerTask.getForkBranchId(), this.thread.getJavaThread());
                ServiceManager.timerDiag.timerExecuted(timerTask);
                if (logger.isTraceEnabled(2)) {
                    logger.trace(2).append("execute ").append(timerTask).log();
                }
                Invoker invoker = timerTask.getInvoker();
                Runnable runnable = timerTask.getRunnable();
                invoker.invoke(runnable);
            }
            catch (Throwable throwable) {
                timerTask.increaseErrorCount();
                if (timerTask.getErrorCount() == 3) {
                    logger.error(2).append(timerTask).append(" will be stopped and removed, because it causes too much exceptions!").log();
                    timerTask.setRepeat(false);
                    timerTask.resetErrorCount();
                }
                ServiceManager.errorHandler.handleError(throwable);
            }
            finally {
                this.activeTimerTaskList.remove(timerTask);
                if (timerTask.isRepeat()) {
                    timerTask.setLastActivationTime(timerTask.getNextActivationTime());
                    timerTask.setNextActivationTime(timerTask.getNextActivationTime() + timerTask.getDelay());
                    this.executedRepeatTasks.insert(timerTask);
                } else {
                    this.timerTasksMap.remove(timerTask.getTimerId());
                    timerTask.releaseObject();
                    timerTask = null;
                }
                timerTask = this.activeTimerTaskList.getFirst();
            }
        }
        if (this.running && !this.executedRepeatTasks.isEmpty()) {
            this.activeTimerTaskList.insertAll(this.executedRepeatTasks);
        }
        this.executedRepeatTasks.clear();
    }

    private boolean hasToExecute(TimerTask timerTask) {
        return timerTask != null ? timerTask.getNextActivationTime() - this.timerManager.getSystemTimeMillis() <= 0L : false;
    }

    private void performUpdates() {
        if (!this.running) {
            return;
        }
        int n = this.updateRequests.size();
        for (int i2 = 0; i2 < n; ++i2) {
            UpdateTaskRequest updateTaskRequest = (UpdateTaskRequest)this.updateRequests.get(i2);
            InvocationContext.startSpecificInvocation(updateTaskRequest.getForkBranchId(), this.thread.getJavaThread());
            ServiceManager.timerDiag.timerUpdated(updateTaskRequest);
            if (logger.isTraceEnabled(2)) {
                logger.trace(2).append("perform ").append(updateTaskRequest).log();
            }
            int n2 = updateTaskRequest.getId();
            TimerTask timerTask = (TimerTask)this.timerTasksMap.get(n2);
            switch (updateTaskRequest.getUpdateType()) {
                case 0: {
                    if (timerTask == null) break;
                    this.activeTimerTaskList.remove(timerTask);
                    timerTask.setDelay(updateTaskRequest.getDelay());
                    if (updateTaskRequest.isFromNow()) {
                        timerTask.setLastActivationTime(updateTaskRequest.getNow());
                    }
                    timerTask.setNextActivationTime(timerTask.getLastActivationTime() + updateTaskRequest.getDelay());
                    timerTask.setForkBranchId(updateTaskRequest.getForkBranchId());
                    this.activeTimerTaskList.insert(timerTask);
                    break;
                }
                case 1: {
                    if (timerTask == null) break;
                    timerTask.setRepeat(updateTaskRequest.isRepeat());
                    timerTask.setForkBranchId(updateTaskRequest.getForkBranchId());
                    break;
                }
                case 2: {
                    if (timerTask == null) break;
                    timerTask.setRunnable(updateTaskRequest.getRunnable());
                    timerTask.setInvoker(updateTaskRequest.getInvoker());
                    timerTask.setForkBranchId(updateTaskRequest.getForkBranchId());
                    break;
                }
                case 3: {
                    if (timerTask != null) {
                        this.activeTimerTaskList.remove(timerTask);
                    } else {
                        timerTask = this.timerTaskFactory.getTimerTask();
                        timerTask.setTimerId(n2);
                        this.timerTasksMap.put(n2, timerTask);
                    }
                    timerTask.setTimerName(updateTaskRequest.getName());
                    timerTask.setDelay(updateTaskRequest.getDelay());
                    timerTask.setLastActivationTime(updateTaskRequest.getNow());
                    timerTask.setNextActivationTime(updateTaskRequest.getNow() + updateTaskRequest.getDelay());
                    timerTask.setRepeat(updateTaskRequest.isRepeat());
                    timerTask.setRunnable(updateTaskRequest.getRunnable());
                    timerTask.setInvoker(updateTaskRequest.getInvoker());
                    timerTask.setForkBranchId(updateTaskRequest.getForkBranchId());
                    this.activeTimerTaskList.insert(timerTask);
                    break;
                }
                case 4: {
                    if (timerTask == null) break;
                    this.activeTimerTaskList.remove(timerTask);
                    this.timerTasksMap.remove(n2);
                    timerTask.releaseObject();
                    timerTask = null;
                    break;
                }
                case 5: {
                    if (timerTask == null) break;
                    this.activeTimerTaskList.remove(timerTask);
                    timerTask.setDelay(timerTask.getNextActivationTime() - updateTaskRequest.getNow());
                    break;
                }
                case 6: {
                    if (timerTask == null) break;
                    timerTask.setLastActivationTime(updateTaskRequest.getNow());
                    timerTask.setNextActivationTime(updateTaskRequest.getNow() + timerTask.getDelay());
                    timerTask.setDelay(updateTaskRequest.getDelay());
                    this.activeTimerTaskList.insert(timerTask);
                    break;
                }
                default: {
                    throw new TimerException("Unkown Timer Update Type");
                }
            }
            updateTaskRequest.releaseObject();
            updateTaskRequest = null;
        }
        this.updateRequests.clear();
    }

    boolean isRunning(Timer timer) {
        int n = timer.getId();
        TimerTask timerTask = (TimerTask)this.timerTasksMap.get(n);
        if (timerTask == null) {
            return false;
        }
        return this.activeTimerTaskList.contains(timerTask);
    }

    void killThread() {
        this.running = false;
        this.thread.stop();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void updateTask(UpdateTaskRequest updateTaskRequest) {
        if (!this.running) {
            throw new TimerException(new StringBuffer().append("UpdateTaskRequest for killed timer thread: ").append(updateTaskRequest).toString());
        }
        if (logger.isTraceEnabled(2)) {
            logger.trace(2).append("UpdateTaskRequest queued: ").append(updateTaskRequest).log();
        }
        InvocationContext invocationContext = InvocationContext.getCurrentInvocationContext(null).createBranch();
        updateTaskRequest.setForkBranchId(invocationContext.getForkBranchId());
        switch (updateTaskRequest.getUpdateType()) {
            case 3: {
                ServiceManager.timerDiag.startTimer(updateTaskRequest);
                break;
            }
            case 4: {
                ServiceManager.timerDiag.stopTimer(updateTaskRequest);
                break;
            }
            case 5: {
                ServiceManager.timerDiag.suspendTimer(updateTaskRequest);
                break;
            }
            case 6: {
                ServiceManager.timerDiag.resumeTimer(updateTaskRequest);
                break;
            }
            default: {
                ServiceManager.timerDiag.configureTimer(updateTaskRequest);
            }
        }
        List list = this.updateRequests;
        synchronized (list) {
            this.updateRequests.add(updateTaskRequest);
            super.notifyAll();
        }
    }
}

