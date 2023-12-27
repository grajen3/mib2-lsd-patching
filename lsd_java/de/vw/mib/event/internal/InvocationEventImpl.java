/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.InvocationEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class InvocationEventImpl
extends AbstractPooledEvent
implements InvocationEvent {
    private Runnable runnable;

    InvocationEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        if (this.runnable != null) {
            this.runnable.run();
        }
        this.runnable = null;
    }

    @Override
    public String getRunnableName() {
        return super.getClass().getName();
    }

    public String toString() {
        return "InvocationEvent";
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("InvocationEvent");
    }

    void setContent(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

