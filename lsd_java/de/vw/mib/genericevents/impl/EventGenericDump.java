/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.EventGeneric;

final class EventGenericDump {
    private boolean blocked;
    private boolean isAnswer;
    private int receiverEventId;
    private int receiverRouterId;
    private int receiverTargetId;
    private int result;
    private int senderEventId;
    private int senderRouterId;
    private int senderTargetId;
    private int sid;
    private long timestamp;

    EventGenericDump() {
    }

    public void fromEvent(long l, EventGeneric eventGeneric) {
        this.timestamp = l;
        this.sid = eventGeneric.getServiceId();
        this.senderEventId = eventGeneric.getSenderEventId();
        this.senderTargetId = eventGeneric.getSenderTargetId();
        this.receiverEventId = eventGeneric.getReceiverEventId();
        this.receiverTargetId = eventGeneric.getReceiverTargetId();
        this.senderRouterId = eventGeneric.getSenderRouterId();
        this.receiverRouterId = eventGeneric.getReceiverRouterId();
        this.result = eventGeneric.getResult();
        this.blocked = eventGeneric.isBlocked();
        this.isAnswer = eventGeneric.isAnswer();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(42);
        if (this.timestamp > 0L) {
            stringBuffer.append(this.timestamp);
            stringBuffer.append(" - [");
        } else {
            stringBuffer.append("[");
        }
        stringBuffer.append(this.senderRouterId);
        stringBuffer.append(".");
        stringBuffer.append(this.senderTargetId);
        stringBuffer.append(".");
        stringBuffer.append(this.senderEventId);
        stringBuffer.append("]-->[");
        stringBuffer.append(this.receiverRouterId);
        if (this.sid > 0) {
            stringBuffer.append(":");
            stringBuffer.append(this.sid);
            stringBuffer.append("]");
        } else {
            stringBuffer.append(".");
            stringBuffer.append(this.receiverTargetId);
            stringBuffer.append(".");
            stringBuffer.append(this.receiverEventId);
            stringBuffer.append("]");
        }
        if (this.isAnswer) {
            stringBuffer.append("[A");
            stringBuffer.append(this.result);
            stringBuffer.append("]");
        }
        if (this.blocked) {
            stringBuffer.append("[B]");
        }
        return stringBuffer.toString();
    }
}

