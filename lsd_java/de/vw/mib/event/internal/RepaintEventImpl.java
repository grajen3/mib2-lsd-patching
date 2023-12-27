/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.RepaintEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class RepaintEventImpl
extends AbstractPooledEvent
implements RepaintEvent {
    RepaintEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.repaintManager.consumeEvent(this);
    }

    public String toString() {
        return "RepaintEvent";
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("RepaintEvent");
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

