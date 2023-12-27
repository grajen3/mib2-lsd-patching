/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptor;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleRegistrationWaitOperation$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleRegistrationWaitOperation$2;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public class ModuleRegistrationWaitOperation
implements Runnable {
    private static final String LOG_PREFIX;
    private static final int TIMEOUT;
    private final Runnable failOperation;
    private final Runnable successOperation;
    private final ModuleDescriptorRegistry registry;
    private final Logger logger;
    private final TimerManager timerManager;
    private final ThreadSwitchingTarget threadSwitchingTarget;
    private final int namespace;

    public ModuleRegistrationWaitOperation(PersistenceServices persistenceServices, int n, Runnable runnable, Runnable runnable2) {
        this.logger = persistenceServices.getLogger();
        this.timerManager = persistenceServices.getTimerManager();
        this.threadSwitchingTarget = persistenceServices.getThreadSwitchingTarget();
        this.registry = persistenceServices.getModuleDescriptorRegistry();
        this.namespace = n;
        this.successOperation = runnable;
        this.failOperation = runnable2;
    }

    @Override
    public void run() {
        if (this.registry.containsDescriptor(this.namespace)) {
            this.processRegisteredModule();
        } else {
            this.runFailOperation(new StringBuffer().append("Module ").append(this.namespace).append(" is not registered. Wait operation is failing.").toString());
        }
    }

    void runFailOperation(String string) {
        this.logger.error(32, new StringBuffer().append("[ModuleRegistrationWaitOperation] ").append(string).toString());
        this.failOperation.run();
    }

    void runSuccessOperation(String string) {
        if (this.logger.isTraceEnabled(32)) {
            this.logger.trace(32, new StringBuffer().append("[ModuleRegistrationWaitOperation] Module ").append(this.namespace).append(" is available (").append(string).append(")").toString());
        }
        this.successOperation.run();
    }

    private void processRegisteredModule() {
        ModuleDescriptor moduleDescriptor = this.registry.getOrCreateDescriptor(this.namespace);
        if (moduleDescriptor.hasPersistenceModule()) {
            this.runSuccessOperation("without waiting");
        } else {
            this.waitForModuleRegistration(moduleDescriptor);
        }
    }

    private void waitForModuleRegistration(ModuleDescriptor moduleDescriptor) {
        Timer timer = this.startTimeoutDetection(moduleDescriptor);
        ModuleRegistrationWaitOperation$1 moduleRegistrationWaitOperation$1 = new ModuleRegistrationWaitOperation$1(this, timer);
        moduleDescriptor.addPersistableModuleAddedListener(moduleRegistrationWaitOperation$1);
    }

    private Timer startTimeoutDetection(ModuleDescriptor moduleDescriptor) {
        String string = "ModuleRegistration";
        boolean bl = false;
        ModuleRegistrationWaitOperation$2 moduleRegistrationWaitOperation$2 = new ModuleRegistrationWaitOperation$2(this, moduleDescriptor);
        Timer timer = this.timerManager.createTimer(string, 0, bl, moduleRegistrationWaitOperation$2, this.threadSwitchingTarget);
        timer.start();
        return timer;
    }
}

