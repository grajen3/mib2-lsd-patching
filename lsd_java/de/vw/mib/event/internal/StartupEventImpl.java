/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.StartupEvent;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class StartupEventImpl
extends AbstractEvent
implements StartupEvent {
    private final int eventId;

    public StartupEventImpl(int n) {
        this.eventId = n;
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.startupManager.consumeEvent(this);
        ServiceManager.statemachineManager.consumeEvent(this);
        ServiceManager.appStartupManager.consumeEvent(this);
        ServiceManager.aslStartupManager.consumeEvent(this);
        ServiceManager.viewManager.consumeEvent(this);
    }

    @Override
    public int getEventId() {
        return this.eventId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("StartupEvent - event id: ").append(this.eventId);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("StartupEvent - event id: ").append(this.eventId);
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

