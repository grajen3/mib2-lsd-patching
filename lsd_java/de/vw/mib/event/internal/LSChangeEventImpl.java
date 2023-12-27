/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.LSChangeEvent;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class LSChangeEventImpl
extends AbstractEvent
implements LSChangeEvent {
    private final int command;

    public LSChangeEventImpl(int n) {
        this.command = n;
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.lsChanger.consumeEvent(this);
    }

    @Override
    public int getCommand() {
        return this.command;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("LSChangeEvent - command: ").append(this.command);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("LSChangeEvent - command: ").append(this.command);
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

