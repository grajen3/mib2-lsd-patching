/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.PopupStackChangeEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class PopupStackChangeEventImpl
extends AbstractPooledEvent
implements PopupStackChangeEvent {
    private int numberOfPopups;
    private int numberOfUserPerceivedOffPopups;

    PopupStackChangeEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.popupStackChangeEventConsumer.consumeEvent(this);
    }

    @Override
    public int getNumberOfPopups() {
        return this.numberOfPopups;
    }

    @Override
    public int getNumberOfUserPerceivedOffPopups() {
        return this.numberOfUserPerceivedOffPopups;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("PopupStackChangeEvent - numberOfPopups: ").append(this.numberOfPopups);
        stringBuffer.append(", numberOfUserPerceivedOffPopups: ").append(this.numberOfUserPerceivedOffPopups);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("PopupStackChangeEvent - numberOfPopups: ").append(this.numberOfPopups);
        logMessage.append(", numberOfUserPerceivedOffPopups: ").append(this.numberOfUserPerceivedOffPopups);
    }

    void setContent(int n, int n2) {
        this.numberOfPopups = n;
        this.numberOfUserPerceivedOffPopups = n2;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

