/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.SpeechStateEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.log4mib.LogMessage;

public final class SpeechStateEventImpl
extends AbstractPooledEvent
implements SpeechStateEvent {
    private int state;

    public SpeechStateEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
    }

    @Override
    public int getState() {
        return this.state;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("SpeechStateEvent - state: ").append(this.state);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("SpeechStateEvent - state: ").append(this.state);
    }

    void setContent(int n) {
        this.state = n;
    }

    @Override
    void traceEvent(byte by, byte by2) {
    }
}

