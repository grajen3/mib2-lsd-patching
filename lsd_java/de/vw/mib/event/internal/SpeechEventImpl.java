/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.SpeechEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.log4mib.LogMessage;

public final class SpeechEventImpl
extends AbstractPooledEvent
implements SpeechEvent {
    private int index;
    private long objectId;
    private int ruleId;
    private int slotId;
    private String tag;

    SpeechEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public long getObjectId() {
        return this.objectId;
    }

    @Override
    public int getRuleId() {
        return this.ruleId;
    }

    @Override
    public int getSlotId() {
        return this.slotId;
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    @Override
    public void setIndex(int n) {
        this.index = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("SpeechEvent - index: ").append(this.index);
        stringBuffer.append(", ruleId: ").append(this.ruleId);
        stringBuffer.append(", slotId: ").append(this.slotId);
        stringBuffer.append(", tag: ").append(this.tag);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("SpeechEvent - index: ").append(this.index);
        logMessage.append(", ruleId: ").append(this.ruleId);
        logMessage.append(", slotId: ").append(this.slotId);
        logMessage.append(", tag: ").append(this.tag);
    }

    void setContent(int n, long l, int n2, String string, int n3) {
        this.ruleId = n;
        this.objectId = l;
        this.index = n2;
        this.tag = string;
        this.slotId = n3;
    }

    @Override
    void traceEvent(byte by, byte by2) {
    }
}

