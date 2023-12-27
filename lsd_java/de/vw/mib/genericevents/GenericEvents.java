/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.TaskInterface;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;

public interface GenericEvents {
    default public TaskInterface createAsyncTask(String string) {
    }

    default public TaskInterface createAsyncTask(String string, int n) {
    }

    default public TaskInterface createSyncTask(String string, boolean bl) {
    }

    default public void dispose() {
    }

    default public EventDispatcherHSM getEventDispatcher() {
    }

    default public EventFactory getEventFactory() {
    }

    default public LoggerFactory getLoggerFactory() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public Logger getTextLogger() {
    }

    default public Logger getTextLogger(int n) {
    }

    default public TimerServer getTimerServer() {
    }
}

