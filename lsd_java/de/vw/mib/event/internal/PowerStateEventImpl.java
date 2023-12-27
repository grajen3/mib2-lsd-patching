/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.PowerStateEvent;
import de.vw.mib.event.internal.AbstractEvent;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class PowerStateEventImpl
extends AbstractEvent
implements PowerStateEvent {
    private final int powerState;

    PowerStateEventImpl(int n) {
        this.powerState = n;
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.popupStackManager.consumeEvent(this);
        ServiceManager.powerStateEventConsumer.consumeEvent(this);
    }

    @Override
    public int getState() {
        return this.powerState;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("PowerStateEvent - powerState: ").append(this.powerState);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("PowerStateEvent - powerState: ").append(this.powerState);
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

