/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ContextChangeEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class ContextChangeEventImpl
extends AbstractPooledEvent
implements ContextChangeEvent {
    private String context;

    ContextChangeEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.popupStackManager.consumeEvent(this);
    }

    @Override
    public String getContext() {
        return this.context;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ContextChangeEvent - context: ").append(this.context);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ContextChangeEvent - context: ").append(this.context);
    }

    void setContent(String string) {
        this.context = string;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

