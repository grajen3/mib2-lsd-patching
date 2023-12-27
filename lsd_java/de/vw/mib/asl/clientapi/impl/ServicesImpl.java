/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.ASLClientAPIBridge$Services;
import de.vw.mib.asl.clientapi.impl.Clock;
import de.vw.mib.asl.clientapi.impl.ClockImpl;
import de.vw.mib.asl.clientapi.list.ASLClientListFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.Invoker;

class ServicesImpl
implements ASLClientAPIBridge$Services {
    static final int LOG_CLASSIFIER;
    static final int LOG_SUBCLASSIFIER;
    static final String LOG_PREFIX;
    ClassifiedLogger clogger;
    ASLClientListFactory clientListFactory;
    Invoker aslInvoker;
    ClockImpl clock;
    HMIListRegistry listRegistry;
    LoggerFactory loggerFactory;

    ServicesImpl() {
    }

    static ServicesImpl copy(ServicesImpl servicesImpl) {
        ServicesImpl servicesImpl2 = new ServicesImpl();
        servicesImpl2.clogger = servicesImpl.clogger;
        servicesImpl2.clientListFactory = servicesImpl.clientListFactory;
        servicesImpl2.aslInvoker = servicesImpl.aslInvoker;
        servicesImpl2.clock = servicesImpl.clock;
        servicesImpl2.listRegistry = servicesImpl.listRegistry;
        servicesImpl2.loggerFactory = servicesImpl.loggerFactory;
        return servicesImpl2;
    }

    boolean isReady() {
        return null != this.clogger && null != this.clientListFactory && null != this.aslInvoker && null != this.clock && null != this.listRegistry && null != this.loggerFactory;
    }

    @Override
    public ASLClientListFactory getASLClientListFactory() {
        return this.clientListFactory;
    }

    @Override
    public Invoker getASLInvoker() {
        return this.aslInvoker;
    }

    @Override
    public ClassifiedLogger getClassifiedLogger() {
        return this.clogger;
    }

    @Override
    public Clock getClock() {
        return this.clock;
    }

    @Override
    public HMIListRegistry getHMIListRegistry() {
        return this.listRegistry;
    }

    LoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }
}

