/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.SpeechCommandEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.log4mib.LogMessage;

public final class SpeechCommandEventImpl
extends AbstractPooledEvent
implements SpeechCommandEvent {
    private int command;

    SpeechCommandEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
    }

    @Override
    public int getCommand() {
        return this.command;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("SpeechCommandEvent - command: ").append(this.command);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("SpeechCommandEvent - command: ").append(this.command);
    }

    void setContent(int n) {
        this.command = n;
    }

    @Override
    void traceEvent(byte by, byte by2) {
    }
}

