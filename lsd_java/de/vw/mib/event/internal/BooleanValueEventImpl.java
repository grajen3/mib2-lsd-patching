/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.BooleanValueEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;

public final class BooleanValueEventImpl
extends AbstractHMIEvent
implements BooleanValueEvent {
    private int forkBranchId;
    private boolean value;

    BooleanValueEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public boolean getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("BooleanValueEvent - id: ").append(this.id);
        stringBuffer.append(", type: ").append(this.type);
        stringBuffer.append(", value: ").append(this.value);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("BooleanValueEvent - id: ").append(this.id);
        logMessage.append(", type: ").append(this.type);
        logMessage.append(", value: ").append(this.value);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    @Override
    public void traceDequeue(byte by) {
        if (this.type == 8) {
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

    void setContent(int n, boolean bl, int n2) {
        this.id = n;
        this.value = bl;
        this.type = n2;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

