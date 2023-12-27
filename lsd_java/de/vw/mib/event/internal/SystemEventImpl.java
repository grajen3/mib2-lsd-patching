/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.SystemEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;

public final class SystemEventImpl
extends AbstractHMIEvent
implements SystemEvent {
    private int aslSystemEventId;
    private int forkBranchId;

    SystemEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        super.dispatchEvent();
        ServiceManager.bapSystemEventConsumer.consumeEvent(this);
    }

    @Override
    public int getASLSystemEventId() {
        return this.aslSystemEventId;
    }

    @Override
    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("SystemEvent - id: ").append(this.id);
        stringBuffer.append(", aslSystemEventId: ").append(this.aslSystemEventId);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("SystemEvent - id: ").append(this.id);
        logMessage.append(", aslSystemEventId: ").append(this.aslSystemEventId);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    @Override
    public void traceDequeue(byte by) {
        if (this.type == 2) {
            InvocationContext.startSpecificInvocation(this.forkBranchId, null);
            this.invocationContext = InvocationContext.getCurrentInvocationContext(null);
            this.traceEvent((byte)1, by);
        } else {
            super.traceDequeue(by);
        }
    }

    @Override
    public void traceEnqueue(byte by) {
        super.traceEnqueue(by);
        this.forkBranchId = this.invocationContext.getForkBranchId();
    }

    void setContent(int n, int n2, int n3) {
        this.type = n;
        this.id = n2;
        this.aslSystemEventId = n3;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

