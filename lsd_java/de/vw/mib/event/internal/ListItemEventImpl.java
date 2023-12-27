/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ListItemEvent;
import de.vw.mib.event.internal.AbstractHMIEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class ListItemEventImpl
extends AbstractHMIEvent
implements ListItemEvent {
    private int absoluteIndex;
    private int actionIndex;
    private int destinationIndex;
    private int dropDownIndex;
    private String eventSender;
    private long objectId;

    ListItemEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public int getAbsoluteIndex() {
        return this.absoluteIndex;
    }

    @Override
    public int getActionIndex() {
        return this.actionIndex;
    }

    @Override
    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    @Override
    public int getDropDownIndex() {
        return this.dropDownIndex;
    }

    @Override
    public String getEventSender() {
        return this.eventSender;
    }

    @Override
    public long getObjectId() {
        return this.objectId;
    }

    @Override
    public int getType() {
        return 4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ListItemEvent - id: ").append(this.id);
        stringBuffer.append(", absoluteIndex: ").append(this.absoluteIndex);
        stringBuffer.append(", actionIndex: ").append(this.actionIndex);
        stringBuffer.append(", destinationIndex: ").append(this.destinationIndex);
        stringBuffer.append(", dropDownIndex: ").append(this.dropDownIndex);
        stringBuffer.append(", eventSender: ").append(this.eventSender);
        stringBuffer.append(", objectId: ").append(this.objectId);
        stringBuffer.append(", isConsumed: ").append(this.consumed);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ListItemEvent - id: ").append(this.id);
        logMessage.append(", absoluteIndex: ").append(this.absoluteIndex);
        logMessage.append(", actionIndex: ").append(this.actionIndex);
        logMessage.append(", destinationIndex: ").append(this.destinationIndex);
        logMessage.append(", dropDownIndex: ").append(this.dropDownIndex);
        logMessage.append(", eventSender: ").append(this.eventSender);
        logMessage.append(", objectId: ").append(this.objectId);
        logMessage.append(", isConsumed: ").append(this.consumed);
    }

    void setContent(int n, int n2, int n3, int n4, int n5, String string, long l) {
        this.id = n;
        this.absoluteIndex = n2;
        this.actionIndex = n3;
        this.destinationIndex = n4;
        this.dropDownIndex = n5;
        this.eventSender = string;
        this.objectId = l;
        this.consumed = false;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

