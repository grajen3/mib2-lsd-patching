/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.SpellerValueEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class SpellerValueEventImpl
extends AbstractHMIEvent
implements SpellerValueEvent {
    private int cursorPosition;
    private String pressedChar;
    private int selectionEnd;
    private int selectionStart;

    SpellerValueEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getCursorPosition() {
        return this.cursorPosition;
    }

    @Override
    public String getPressedChar() {
        return this.pressedChar;
    }

    @Override
    public int getSelectionEnd() {
        return this.selectionEnd;
    }

    @Override
    public int getSelectionStart() {
        return this.selectionStart;
    }

    @Override
    public int getType() {
        return 4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("SpellerValueEvent - pressed char: ").append(this.pressedChar);
        stringBuffer.append(", cursor position: ").append(this.cursorPosition);
        stringBuffer.append(", selection: ").append(this.selectionStart);
        stringBuffer.append(" to ").append(this.selectionEnd);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("SpellerValueEvent - pressed char: ").append(this.pressedChar);
        logMessage.append(", cursor position: ").append(this.cursorPosition);
        logMessage.append(", selection: ").append(this.selectionStart);
        logMessage.append(" to ").append(this.selectionEnd);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    void setContent(int n, String string, int n2, int n3, int n4) {
        this.id = n;
        this.pressedChar = string;
        this.cursorPosition = n2;
        this.selectionStart = n3;
        this.selectionEnd = n4;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

