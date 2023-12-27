/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.features.model;

import de.vw.mib.asl.api.speechengine.features.model.Event;

public class EventImpl
implements Event {
    private int eventId;

    public EventImpl() {
    }

    public EventImpl(int n) {
        this.eventId = n;
    }

    @Override
    public int getEventId() {
        return this.eventId;
    }

    public void setEventId(int n) {
        this.eventId = n;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("eventId=");
        stringBuffer.append(String.valueOf(this.eventId));
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

