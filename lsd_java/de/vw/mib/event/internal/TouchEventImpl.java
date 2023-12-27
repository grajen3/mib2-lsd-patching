/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.event.internal;

import de.vw.mib.event.TouchEvent;
import de.vw.mib.event.internal.AbstractPooledEvent;
import de.vw.mib.event.internal.EventPool;
import de.vw.mib.event.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.log4mib.LogMessage;

public final class TouchEventImpl
extends AbstractPooledEvent
implements TouchEvent {
    private int gestureParam1;
    private int gestureParam2;
    private int timestamp;
    private int type;
    private int x;
    private int y;
    private int zDelta;
    private int forkBranchId = -1;

    TouchEventImpl(EventPool eventPool) {
        super(eventPool);
    }

    @Override
    public void dispatchEvent() {
        ServiceManager.viewManager.consumeEvent(this);
    }

    @Override
    public int getGestureParam1() {
        return this.gestureParam1;
    }

    @Override
    public int getGestureParam2() {
        return this.gestureParam2;
    }

    @Override
    public int getTimestamp() {
        return this.timestamp;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getZDelta() {
        return this.zDelta;
    }

    @Override
    public void setCoordinates(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("TouchEvent - gesture type: ").append(this.type);
        stringBuffer.append(", x: ").append(this.x);
        stringBuffer.append(", y: ").append(this.y);
        stringBuffer.append(", zDelta: ").append(this.zDelta);
        stringBuffer.append(", param1: ").append(this.gestureParam1);
        stringBuffer.append(", param2: ").append(this.gestureParam2);
        stringBuffer.append(", timestamp: ").append(this.timestamp);
        return stringBuffer.toString();
    }

    @Override
    public void toString(LogMessage logMessage) {
        logMessage.append("TouchEvent - gesture type: ").append(this.type);
        logMessage.append(", x: ").append(this.x);
        logMessage.append(", y: ").append(this.y);
        logMessage.append(", zDelta: ").append(this.zDelta);
        logMessage.append(", param1: ").append(this.gestureParam1);
        logMessage.append(", param2: ").append(this.gestureParam2);
        logMessage.append(", timestamp: ").append(this.timestamp);
    }

    @Override
    public void traceDequeue(byte by) {
        InvocationContext.startSpecificInvocation(this.forkBranchId, null);
        this.invocationContext = InvocationContext.getCurrentInvocationContext(null);
        this.traceEvent((byte)1, by);
    }

    @Override
    public void traceEnqueue(byte by) {
        super.traceEnqueue(by);
        this.forkBranchId = this.invocationContext.getForkBranchId();
    }

    void setContent(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.type = n;
        this.x = n2;
        this.y = n3;
        this.zDelta = n4;
        this.gestureParam1 = n5;
        this.gestureParam2 = n6;
        this.timestamp = n7;
    }

    @Override
    void traceEvent(byte by, byte by2) {
        ServiceManager.eventTracer.trace(by, by2, this);
    }
}

