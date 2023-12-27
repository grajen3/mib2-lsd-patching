/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.IntegerValueEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class IntegerValueEventImpl
extends AbstractHMIEvent
implements IntegerValueEvent {
    private int value;

    IntegerValueEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("IntegerValueEvent - value: ").append(this.value);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("IntegerValueEvent - value: ").append(this.value);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    void setContent(int n, int n2) {
        this.id = n;
        this.value = n2;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

