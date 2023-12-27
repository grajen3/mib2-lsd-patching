/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.RotationEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;

public final class RotationEventImpl
extends AbstractHMIEvent
implements RotationEvent {
    private int forkBranchId;
    private int ticks;
    private int timestamp;

    RotationEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getTicks() {
        return this.ticks;
    }

    @Override
    public int getTimestamp() {
        return this.timestamp;
    }

    @Override
    public int getType() {
        return 16;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("RotationEvent - id: ").append(this.id);
        stringBuffer.append(", ticks: ").append(this.ticks);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("RotationEvent - id: ").append(this.id);
        logMessage.append(", ticks: ").append(this.ticks);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    @Override
    public void traceDequeue(byte by) {
        InvocationContext.startSpecificInvocation(this.forkBranchId, null);
        this.invocationContext = InvocationContext.getCurrentInvocationContext(null);
        this.traceEvent((byte)1, by);
    }

    @Override
    public void traceEnqueue(byte by) {
        super.traceEnqueue(by);
        this.forkBranchId = this.invocationContext.getForkBranchId();
    }

    void setContent(int n, int n2, int n3) {
        this.id = n;
        this.ticks = n2;
        this.timestamp = n3;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

