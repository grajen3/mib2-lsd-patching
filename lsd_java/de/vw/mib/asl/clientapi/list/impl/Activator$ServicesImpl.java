/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.list.impl;

import de.vw.mib.asl.clientapi.list.impl.Services;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.threads.MIBInvoker;
import de.vw.mib.timer.TimerManager;

class Activator$ServicesImpl
implements Services {
    ClassifiedLogger clogger;
    TimerManager timerManager;
    MIBInvoker invoker;
    HMIListDataFactory factory;
    HMIListRegistry registry;

    Activator$ServicesImpl() {
    }

    boolean isReady() {
        return null != this.clogger && null != this.timerManager && null != this.invoker && null != this.factory && null != this.registry;
    }

    @Override
    public HMIListDataFactory getFactory() {
        return this.factory;
    }

    @Override
    public ClassifiedLogger getLogger() {
        return this.clogger;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    @Override
    public MIBInvoker getASLInvoker() {
        return this.invoker;
    }
}

