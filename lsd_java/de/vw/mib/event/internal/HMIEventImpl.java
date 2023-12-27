/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class HMIEventImpl
extends AbstractHMIEvent
implements HMIEvent {
    HMIEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("HMIEvent - id: ").append(this.id);
        stringBuffer.append(", type: ").append(this.type);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("HMIEvent - id: ").append(this.id);
        logMessage.append(", type: ").append(this.type);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    void setContent(int n, int n2) {
        this.id = n;
        this.type = n2;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

