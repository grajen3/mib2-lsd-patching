/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.genericevents.impl.AsyncTask;
import de.vw.mib.genericevents.impl.EventDispatcherImpl;
import de.vw.mib.genericevents.impl.ServiceRegisterImpl;
import de.vw.mib.genericevents.impl.SynchronousTask;
import de.vw.mib.genericevents.impl.Task;
import de.vw.mib.genericevents.impl.TimedEventServer;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.genericevents.internal.SimpleEventFactory;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;

public final class GenericEventsImpl
implements GenericEvents {
    private final EventDispatcherHSM eventDispatcher;
    private final ServiceRegister serviceRegister;
    private final TimerServer timerServer;

    public GenericEventsImpl(LoggerFactory loggerFactory) {
        ServiceManager.loggerFactory = loggerFactory;
        if (ServiceManager.mLogger == null && loggerFactory != null) {
            ServiceManager.mLogger = ServiceManager.loggerFactory.getLogger(128);
            if (ServiceManager.mEventContext == null) {
                ServiceManager.mEventContext = this;
            }
        }
        this.eventDispatcher = new EventDispatcherImpl(this);
        this.serviceRegister = new ServiceRegisterImpl(this);
        this.timerServer = new TimedEventServer();
        if (ServiceManager.mEventFactory == null) {
            ServiceManager.mEventFactory = new SimpleEventFactory();
        }
    }

    @Override
    public EventDispatcherHSM getEventDispatcher() {
        return this.eventDispatcher;
    }

    @Override
    public TimerServer getTimerServer() {
        return this.timerServer;
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public Logger getTextLogger(int n) {
        return ServiceManager.loggerFactory.getLogger(n);
    }

    @Override
    public Logger getTextLogger() {
        return ServiceManager.loggerFactory.getLogger(128);
    }

    @Override
    public LoggerFactory getLoggerFactory() {
        return ServiceManager.loggerFactory;
    }

    @Override
    public void dispose() {
        this.eventDispatcher.dispose();
    }

    @Override
    public TaskInterface createAsyncTask(String string) {
        return new AsyncTask(this, string, this.getTaskId(string));
    }

    @Override
    public TaskInterface createAsyncTask(String string, int n) {
        return new Task(this, string, n);
    }

    @Override
    public TaskInterface createSyncTask(String string, boolean bl) {
        return new SynchronousTask(this, string, bl);
    }

    public String toString() {
        return new StringBuffer().append("GenericEvent_").append(System.identityHashCode(this)).toString();
    }

    @Override
    public EventFactory getEventFactory() {
        return ServiceManager.mEventFactory;
    }

    private byte getTaskId(String string) {
        if ("hsmtask".equals(string)) {
            return 2;
        }
        if ("debug".equals(string)) {
            return 3;
        }
        return 0;
    }
}

