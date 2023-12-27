/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.StringValueEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class StringValueEventImpl
extends AbstractHMIEvent
implements StringValueEvent {
    private String value;

    StringValueEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getType() {
        return 4;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("StringValueEvent - value: ").append(this.value);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("StringValueEvent - value: ").append(this.value);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    void setContent(int n, String string) {
        this.id = n;
        this.value = string;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

