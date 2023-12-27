/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.AbstractStartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.StartupSummarizer;
import de.vw.mib.asl.framework.internal.startupv7r.StartupTask;
import de.vw.mib.asl.framework.internal.startupv7r.model.AbstractWorkUnit;
import de.vw.mib.asl.framework.internal.startupv7r.operation.TaskPool;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitQueue;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter$1;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarterListener;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ControllerFactory;
import de.vw.mib.log4mib.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WorkUnitStarter
extends AbstractStartupTask {
    private final Set listeners = new HashSet();
    private WorkUnitQueue workUnitQueue;
    private TaskPool taskPool;
    private StartupSummarizer startupSummarizer;
    private ControllerFactory controllerManager;

    WorkUnitStarter(Logger logger) {
        super(logger);
    }

    public void addListener(WorkUnitStarterListener workUnitStarterListener) {
        this.listeners.add(workUnitStarterListener);
    }

    @Override
    protected void runTask() {
        this.runWorkUnits();
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        this.getStartupSummarizer().printSummary(this.getLogger());
    }

    void runWorkUnits() {
        if (!this.getWorkUnitQueue().hasPendingWorkUnits()) {
            this.finish();
        } else {
            while (this.taskPool.hasIdleWorkers() && this.workUnitQueue.checkIsNextWorkUnitAvailable()) {
                this.runNextWorkUnit();
            }
        }
    }

    void setWorkUnitQueue(WorkUnitQueue workUnitQueue) {
        this.workUnitQueue = workUnitQueue;
    }

    void setTaskPool(TaskPool taskPool) {
        this.taskPool = taskPool;
    }

    void setStartupSummarizer(StartupSummarizer startupSummarizer) {
        this.startupSummarizer = startupSummarizer;
    }

    void setControllerManager(ControllerFactory controllerFactory) {
        this.controllerManager = controllerFactory;
    }

    WorkUnitQueue getWorkUnitQueue() {
        return this.workUnitQueue;
    }

    StartupSummarizer getStartupSummarizer() {
        return this.startupSummarizer;
    }

    void finishWorkUnitStart(AbstractWorkUnit abstractWorkUnit) {
        this.notifyListenersWorkUnitCompleted(abstractWorkUnit);
        this.getWorkUnitQueue().markAsCompleted(abstractWorkUnit);
        this.getStartupSummarizer().logWorkUnitCompleted(abstractWorkUnit);
    }

    private void runNextWorkUnit() {
        AbstractWorkUnit abstractWorkUnit = this.getWorkUnitQueue().poll();
        this.trace(new StringBuffer().append("Starting Work Unit ").append(abstractWorkUnit.getName()).toString());
        this.notifyListenersWorkUnitAboutToStart(abstractWorkUnit);
        StartupTask startupTask = this.controllerManager.createController(abstractWorkUnit);
        int n = this.taskPool.run(startupTask, this.createCallback(abstractWorkUnit));
        this.getStartupSummarizer().logWorkUnitStart(abstractWorkUnit, n);
    }

    private void notifyListenersWorkUnitAboutToStart(AbstractWorkUnit abstractWorkUnit) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            WorkUnitStarterListener workUnitStarterListener = (WorkUnitStarterListener)iterator.next();
            workUnitStarterListener.onWorkUnitAboutToStart(abstractWorkUnit);
        }
    }

    private void notifyListenersWorkUnitCompleted(AbstractWorkUnit abstractWorkUnit) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            WorkUnitStarterListener workUnitStarterListener = (WorkUnitStarterListener)iterator.next();
            workUnitStarterListener.onWorkUnitCompleted(abstractWorkUnit);
        }
    }

    private Runnable createCallback(AbstractWorkUnit abstractWorkUnit) {
        return new WorkUnitStarter$1(this, abstractWorkUnit);
    }
}

