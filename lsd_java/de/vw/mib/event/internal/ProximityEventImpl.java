/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public final class ProximityEventImpl
extends AbstractPooledEvent
implements ProximityEvent {
    private int type;
    private int proximityArea;
    private int objectId;
    private float x;
    private float y;
    private float width;
    private float height;
    private float distance;
    private int timestamp;

    ProximityEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.gestureEventConsumer.consumeEvent(this);
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public int getProximityArea() {
        return this.proximityArea;
    }

    @Override
    public int getObjectId() {
        return this.objectId;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }

    @Override
    public float getDistance() {
        return this.distance;
    }

    @Override
    public int getTimestamp() {
        return this.timestamp;
    }

    void setContent(int n, int n2, int n3, float f2, float f3, float f4, float f5, float f6, int n4) {
        this.type = n;
        this.proximityArea = n2;
        this.objectId = n3;
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
        this.distance = f6;
        this.timestamp = n4;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ProximityEvent - type: ").append(this.type);
        stringBuffer.append(", proximity area: ").append(this.proximityArea);
        stringBuffer.append(", object id: ").append(this.objectId);
        stringBuffer.append(", x: ").append(this.x).append(", y: ").append(this.y);
        stringBuffer.append(", width: ").append(this.width).append(", height: ").append(this.height);
        stringBuffer.append(", distance: ").append(this.distance);
        stringBuffer.append(", timestamp: ").append(this.timestamp);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("ProximityEvent - type: ").append(this.type);
        logMessage.append(", proximity area: ").append(this.proximityArea);
        logMessage.append(", object id: ").append(this.objectId);
        logMessage.append(", x: ").append(this.x).append(", y: ").append(this.y);
        logMessage.append(", width: ").append(this.width).append(", height: ").append(this.height);
        logMessage.append(", distance: ").append(this.distance);
        logMessage.append(", timestamp: ").append(this.timestamp);
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

