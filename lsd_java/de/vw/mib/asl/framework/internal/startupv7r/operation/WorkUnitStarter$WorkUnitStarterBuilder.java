/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.operation;

import de.vw.mib.asl.framework.internal.startupv7r.StartupSummarizer;
import de.vw.mib.asl.framework.internal.startupv7r.operation.TaskPool;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitQueue;
import de.vw.mib.asl.framework.internal.startupv7r.operation.WorkUnitStarter;
import de.vw.mib.asl.framework.internal.startupv7r.workunits.ControllerFactory;
import de.vw.mib.log4mib.Logger;

public class WorkUnitStarter$WorkUnitStarterBuilder {
    private Logger logger;
    private TaskPool taskPool;
    private WorkUnitQueue workUnitQueue;
    private StartupSummarizer startupSummarizer;
    private ControllerFactory controllerManager;

    public WorkUnitStarter$WorkUnitStarterBuilder logger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public WorkUnitStarter$WorkUnitStarterBuilder taskPool(TaskPool taskPool) {
        this.taskPool = taskPool;
        return this;
    }

    public WorkUnitStarter$WorkUnitStarterBuilder workUnitQueue(WorkUnitQueue workUnitQueue) {
        this.workUnitQueue = workUnitQueue;
        return this;
    }

    public WorkUnitStarter$WorkUnitStarterBuilder startupSummarizer(StartupSummarizer startupSummarizer) {
        this.startupSummarizer = startupSummarizer;
        return this;
    }

    public WorkUnitStarter$WorkUnitStarterBuilder controllerManager(ControllerFactory controllerFactory) {
        this.controllerManager = controllerFactory;
        return this;
    }

    public WorkUnitStarter build() {
        WorkUnitStarter workUnitStarter = new WorkUnitStarter(this.logger);
        workUnitStarter.setTaskPool(this.taskPool);
        workUnitStarter.setWorkUnitQueue(this.workUnitQueue);
        workUnitStarter.setStartupSummarizer(this.startupSummarizer);
        workUnitStarter.setControllerManager(this.controllerManager);
        return workUnitStarter;
    }
}

