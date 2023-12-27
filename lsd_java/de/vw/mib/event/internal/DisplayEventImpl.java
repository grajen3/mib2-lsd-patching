/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.DisplayEvent;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

final class DisplayEventImpl
extends AbstractEvent
implements DisplayEvent {
    private final int displayState;

    DisplayEventImpl(int n) {
        this.displayState = n;
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.viewManager.consumeEvent(this);
    }

    @Override
    public int getState() {
        return this.displayState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("DisplayEvent - displayState: ").append(this.displayState);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("DisplayEvent - displayState: ").append(this.displayState);
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

